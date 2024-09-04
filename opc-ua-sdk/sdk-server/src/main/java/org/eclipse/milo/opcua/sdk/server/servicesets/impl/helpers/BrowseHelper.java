/*
 * Copyright (c) 2024 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.servicesets.impl.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.primitives.Ints;
import org.eclipse.milo.opcua.sdk.core.Reference;
import org.eclipse.milo.opcua.sdk.core.typetree.ReferenceTypeTree;
import org.eclipse.milo.opcua.sdk.server.AccessContext;
import org.eclipse.milo.opcua.sdk.server.AddressSpace;
import org.eclipse.milo.opcua.sdk.server.AddressSpace.BrowseContext;
import org.eclipse.milo.opcua.sdk.server.AddressSpace.ReadContext;
import org.eclipse.milo.opcua.sdk.server.ContinuationPoint;
import org.eclipse.milo.opcua.sdk.server.OpcUaServer;
import org.eclipse.milo.opcua.sdk.server.Session;
import org.eclipse.milo.opcua.sdk.server.servicesets.impl.AccessController.AccessResult;
import org.eclipse.milo.opcua.stack.core.AttributeId;
import org.eclipse.milo.opcua.stack.core.NodeIds;
import org.eclipse.milo.opcua.stack.core.StatusCodes;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.BrowseResultMask;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseRequest;
import org.eclipse.milo.opcua.stack.core.types.structured.BrowseResult;
import org.eclipse.milo.opcua.stack.core.types.structured.ReadValueId;
import org.eclipse.milo.opcua.stack.core.types.structured.ReferenceDescription;
import org.eclipse.milo.opcua.stack.core.types.structured.ViewDescription;
import org.eclipse.milo.opcua.stack.core.util.Lists;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

import static org.eclipse.milo.opcua.sdk.server.util.UaEnumUtil.browseResultMasks;
import static org.eclipse.milo.opcua.sdk.server.util.UaEnumUtil.nodeClasses;

public class BrowseHelper {

    public static List<BrowseResult> browse(
        OpcUaServer server,
        AccessContext context,
        BrowseRequest browseRequest
    ) {

        Session session = context.getSession().orElseThrow();

        List<PendingBrowse> pending = Lists.ofNullable(browseRequest.getNodesToBrowse())
            .stream()
            .map(PendingBrowse::new)
            .toList();

        List<NodeId> nodeIds = pending.stream()
            .map(pb -> pb.browseDescription.getNodeId()).toList();

        Map<NodeId, AccessResult> accessResults =
            server.getAccessController().checkBrowseAccess(session, nodeIds);

        for (PendingBrowse pb : pending) {
            AccessResult result = accessResults.get(pb.browseDescription.getNodeId());

            if (result.isDenied()) {
                pb.referenceDescriptions =
                    new ReferenceDescriptions.ReferenceDescriptionList(Collections.emptyList());
            }
        }

        List<BrowseDescription> nodesToBrowse = pending.stream()
            .filter(pb -> pb.referenceDescriptions == null)
            .map(pb -> pb.browseDescription).toList();

        List<AddressSpace.ReferenceResult> referenceResults = server.getAddressSpaceManager().browse(
            new BrowseContext(server, session),
            browseRequest.getView(),
            nodesToBrowse.stream()
                .map(BrowseDescription::getNodeId)
                .collect(Collectors.toList())
        );

        List<ReferenceDescriptions> referenceDescriptionLists = createReferenceDescriptions(
            server,
            nodesToBrowse,
            referenceResults
        );

        for (int i = 0; i < nodesToBrowse.size(); i++) {
            PendingBrowse pb = pending.get(i);
            ReferenceDescriptions referenceDescriptions = referenceDescriptionLists.get(i);

            if (referenceDescriptions instanceof ReferenceDescriptions.BadNoReferences) {
                pb.referenceDescriptions = referenceDescriptions;
            } else if (referenceDescriptions instanceof ReferenceDescriptions.ReferenceDescriptionList rdl) {
                List<NodeId> nodeIdsToCheck = rdl.referenceDescriptions.stream()
                    .map(r -> r.getNodeId().toNodeId(server.getNamespaceTable()).orElse(NodeId.NULL_VALUE))
                    .toList();

                Map<NodeId, AccessResult> referenceAccessResults =
                    server.getAccessController().checkBrowseAccess(session, nodeIdsToCheck);

                var filteredReferences = new ArrayList<ReferenceDescription>();

                for (ReferenceDescription reference : rdl.referenceDescriptions) {
                    NodeId nodeId = reference.getNodeId()
                        .toNodeId(server.getNamespaceTable())
                        .orElse(NodeId.NULL_VALUE);

                    AccessResult result = referenceAccessResults.get(nodeId);

                    if (result.isAllowed()) {
                        filteredReferences.add(reference);
                    }
                }

                // Filter out references to Nodes that the Session doesn't have Browse permission for.
                pb.referenceDescriptions = new ReferenceDescriptions.ReferenceDescriptionList(filteredReferences);
            }
        }

        // Gather all the ReferenceDescription lists: the ones we initially filtered out due to
        // lack of Browse permission and the ones from the actual Browse.
        List<ReferenceDescriptions> allReferenceDescriptionLists =
            pending.stream().map(pb -> pb.referenceDescriptions).toList();

        int max = browseRequest.getRequestedMaxReferencesPerNode().longValue() == 0 ?
            Integer.MAX_VALUE :
            Ints.saturatedCast(browseRequest.getRequestedMaxReferencesPerNode().longValue());

        var browseResults = new ArrayList<BrowseResult>();

        for (ReferenceDescriptions referenceDescriptions : allReferenceDescriptionLists) {
            if (referenceDescriptions instanceof ReferenceDescriptions.BadNoReferences bnr) {
                browseResults.add(new BrowseResult(
                    bnr.statusCode,
                    null,
                    new ReferenceDescription[0]
                ));
            } else if (referenceDescriptions instanceof ReferenceDescriptions.ReferenceDescriptionList rdl) {
                BrowseResult browseResult = createBrowseResult(
                    server,
                    context.getSession().orElse(null),
                    max,
                    rdl.referenceDescriptions
                );

                browseResults.add(browseResult);
            }
        }

        return browseResults;
    }

    private static List<ReferenceDescriptions> createReferenceDescriptions(
        OpcUaServer server,
        List<BrowseDescription> nodesToBrowse,
        List<AddressSpace.ReferenceResult> referenceResults
    ) {

        var referenceDescriptionsList = new ArrayList<ReferenceDescriptions>();

        for (int i = 0; i < nodesToBrowse.size(); i++) {
            BrowseDescription browseDescription = nodesToBrowse.get(i);
            AddressSpace.ReferenceResult result = referenceResults.get(i);

            List<Reference> references;
            if (result instanceof AddressSpace.ReferenceResult.ReferenceList r) {
                references = r.references();
            } else {
                referenceDescriptionsList.add(
                    new ReferenceDescriptions.BadNoReferences(new StatusCode(StatusCodes.Bad_NodeIdUnknown))
                );
                continue;
            }

            NodeId referenceTypeId = browseDescription.getReferenceTypeId();

            if (referenceTypeId.isNotNull() &&
                !server.getReferenceTypeTree().containsType(referenceTypeId)) {

                referenceDescriptionsList.add(
                    new ReferenceDescriptions.BadNoReferences(new StatusCode(StatusCodes.Bad_ReferenceTypeIdInvalid))
                );
                continue;
            }

            List<Reference> stage1Refs = references.stream()
                .filter(reference -> filterDirection(browseDescription, reference))
                .filter(reference -> filterReferenceType(server, browseDescription, reference))
                .toList();

            // The target of each of these references is going to need "BrowseAttributes" read
            // and possibly the TypeDefinition browsed for. How can we batch these up?

            List<ExpandedNodeId> targetNodeIds = stage1Refs.stream()
                .map(Reference::getTargetNodeId)
                .collect(Collectors.toList());

            List<BrowseAttributes> browseAttributes = readBrowseAttributes(
                server,
                targetNodeIds
            );

            List<ExpandedNodeId> typeDefinitionIds = browseTypeDefinitions(
                server,
                targetNodeIds,
                browseDescription.getResultMask()
            );

            var referenceDescriptions = new ArrayList<ReferenceDescription>();

            for (int j = 0; j < stage1Refs.size(); j++) {
                Reference reference = stage1Refs.get(j);
                BrowseAttributes attributes = browseAttributes.get(j);
                ExpandedNodeId typeDefinitionId = typeDefinitionIds.get(j);

                if (filterNodeClass(browseDescription, attributes.nodeClass())) {
                    ReferenceDescription referenceDescription = createReferenceDescription(
                        browseDescription,
                        reference,
                        attributes,
                        typeDefinitionId
                    );

                    referenceDescriptions.add(referenceDescription);
                }
            }

            referenceDescriptionsList.add(new ReferenceDescriptions.ReferenceDescriptionList(referenceDescriptions));
        }

        return referenceDescriptionsList;
    }

    private static ReferenceDescription createReferenceDescription(
        BrowseDescription browseDescription,
        Reference reference,
        BrowseAttributes browseAttributes,
        ExpandedNodeId typeDefinitionId
    ) {

        EnumSet<BrowseResultMask> masks = browseResultMasks(
            browseDescription.getResultMask().longValue()
        );

        NodeId referenceTypeId = masks.contains(BrowseResultMask.ReferenceTypeId) ?
            reference.getReferenceTypeId() : NodeId.NULL_VALUE;

        boolean forward = masks.contains(BrowseResultMask.IsForward) && reference.isForward();

        return new ReferenceDescription(
            referenceTypeId,
            forward,
            reference.getTargetNodeId(),
            masks.contains(BrowseResultMask.BrowseName) ?
                browseAttributes.browseName() : QualifiedName.NULL_VALUE,
            masks.contains(BrowseResultMask.DisplayName) ?
                browseAttributes.displayName() : LocalizedText.NULL_VALUE,
            masks.contains(BrowseResultMask.NodeClass) ?
                browseAttributes.nodeClass() : NodeClass.Unspecified,
            typeDefinitionId
        );
    }

    private static BrowseResult createBrowseResult(
        OpcUaServer server,
        Session session,
        int max,
        List<ReferenceDescription> references
    ) {

        if (references.size() > max) {
            if (session.getBrowseContinuationPoints().size() >
                server.getConfig().getLimits().getMaxBrowseContinuationPoints().intValue()) {

                return new BrowseResult(
                    new StatusCode(StatusCodes.Bad_NoContinuationPoints),
                    null,
                    new ReferenceDescription[0]
                );
            } else {
                List<ReferenceDescription> subList = references.subList(0, max);
                List<ReferenceDescription> current = List.copyOf(subList);
                subList.clear();

                ContinuationPoint c = new ContinuationPoint(references, max);
                session.getBrowseContinuationPoints().put(c.id(), c);

                return new BrowseResult(
                    StatusCode.GOOD,
                    c.id(),
                    current.toArray(new ReferenceDescription[0])
                );
            }
        } else {
            return new BrowseResult(
                StatusCode.GOOD,
                null,
                references.toArray(new ReferenceDescription[0])
            );
        }
    }

    private static List<BrowseAttributes> readBrowseAttributes(
        OpcUaServer server,
        List<ExpandedNodeId> nodeIds
    ) {

        final var browseAttributes = new ArrayList<BrowseAttributes>();

        var readValueIds = new ArrayList<ReadValueId>();

        for (ExpandedNodeId xni : nodeIds) {
            NodeId nodeId = xni.toNodeId(server.getNamespaceTable()).orElse(NodeId.NULL_VALUE);
            readValueIds.add(new ReadValueId(nodeId, AttributeId.BrowseName.uid(), null, QualifiedName.NULL_VALUE));
            readValueIds.add(new ReadValueId(nodeId, AttributeId.DisplayName.uid(), null, QualifiedName.NULL_VALUE));
            readValueIds.add(new ReadValueId(nodeId, AttributeId.NodeClass.uid(), null, QualifiedName.NULL_VALUE));
        }

        var context = new ReadContext(server, null);

        List<DataValue> values = server.getAddressSpaceManager().read(
            context,
            0.0,
            TimestampsToReturn.Neither,
            readValueIds
        );

        for (int i = 0; i < values.size(); i += 3) {
            QualifiedName browseName = (QualifiedName) values.get(i).getValue().getValue();
            LocalizedText displayName = (LocalizedText) values.get(i + 1).getValue().getValue();
            NodeClass nodeClass = (NodeClass) values.get(i + 2).getValue().getValue();

            browseAttributes.add(new BrowseAttributes(browseName, displayName, nodeClass));
        }

        return browseAttributes;
    }

    private static List<ExpandedNodeId> browseTypeDefinitions(OpcUaServer server, List<ExpandedNodeId> nodeIds, UInteger resultMask) {
        EnumSet<BrowseResultMask> resultMasks = browseResultMasks(resultMask.longValue());

        if (!resultMasks.contains(BrowseResultMask.TypeDefinition)) {
            return Collections.nCopies(nodeIds.size(), ExpandedNodeId.NULL_VALUE);
        }

        return nodeIds.stream()
            .map(xni -> xni.toNodeId(server.getNamespaceTable()).orElse(NodeId.NULL_VALUE))
            .map(nodeId -> {
                try {
                    return browseTypeDefinition(server, nodeId);
                } catch (UaException e) {
                    LoggerFactory.getLogger(BrowseHelper.class)
                        .error("Error browsing TypeDefinition for nodeId={}", nodeId, e);
                    return ExpandedNodeId.NULL_VALUE;
                }
            })
            .collect(Collectors.toList());
    }

    private static ExpandedNodeId browseTypeDefinition(OpcUaServer server, NodeId nodeId) throws UaException {
        ExpandedNodeId typeDefinitionId = server.getAddressSpaceManager()
            .getManagedReferences(nodeId, Reference.HAS_TYPE_DEFINITION_PREDICATE)
            .stream()
            .findFirst()
            .map(Reference::getTargetNodeId)
            .orElse(null);

        if (typeDefinitionId != null) {
            return typeDefinitionId;
        } else {
            LoggerFactory.getLogger(BrowseHelper.class)
                .trace("No managed TypeDefinition for nodeId={}, browsing...", nodeId);

            var browseContext = new BrowseContext(server, null);

            var view = new ViewDescription(NodeId.NULL_VALUE, DateTime.NULL_VALUE, UInteger.valueOf(0));

            AddressSpace.ReferenceResult result =
                server.getAddressSpaceManager()
                    .browse(browseContext, view, List.of(nodeId)).get(0);

            if (result instanceof AddressSpace.ReferenceResult.ReferenceList rl) {
                List<Reference> references = rl.references();

                return references.stream()
                    .filter(r -> NodeIds.HasTypeDefinition.equals(r.getReferenceTypeId()))
                    .filter(Reference::isForward)
                    .findFirst()
                    .map(Reference::getTargetNodeId)
                    .orElse(ExpandedNodeId.NULL_VALUE);
            } else {
                return ExpandedNodeId.NULL_VALUE;
            }
        }
    }

    private static boolean filterDirection(
        BrowseDescription browseDescription, Reference reference) {

        return switch (browseDescription.getBrowseDirection()) {
            case Forward -> reference.isForward();
            case Inverse -> reference.isInverse();
            default -> true;
        };
    }

    private static boolean filterReferenceType(
        OpcUaServer server, BrowseDescription browseDescription, Reference reference) {

        ReferenceTypeTree referenceTypeTree = server.getReferenceTypeTree();
        NodeId referenceTypeId = browseDescription.getReferenceTypeId();

        boolean includeAny = referenceTypeId == null || referenceTypeId.isNull();
        boolean includeSubtypes = browseDescription.getIncludeSubtypes();

        return includeAny || reference.getReferenceTypeId().equals(referenceTypeId)
            || (includeSubtypes && referenceTypeTree.isSubtypeOf(reference.getReferenceTypeId(), referenceTypeId));
    }

    private static boolean filterNodeClass(
        BrowseDescription browseDescription, NodeClass nodeClass) {

        long mask = browseDescription.getNodeClassMask().longValue();

        EnumSet<NodeClass> nodeClasses = (mask == 0L) ?
            EnumSet.allOf(NodeClass.class) : nodeClasses(mask);

        return nodeClasses.contains(nodeClass);
    }

    private record BrowseAttributes(
        @Nullable QualifiedName browseName,
        @Nullable LocalizedText displayName,
        @Nullable NodeClass nodeClass
    ) {}

    private static class PendingBrowse {

        ReferenceDescriptions referenceDescriptions;
        final BrowseDescription browseDescription;

        PendingBrowse(BrowseDescription browseDescription) {
            this.browseDescription = browseDescription;
        }

    }

    private sealed interface ReferenceDescriptions {

        record BadNoReferences(StatusCode statusCode) implements ReferenceDescriptions {}

        record ReferenceDescriptionList(
            List<ReferenceDescription> referenceDescriptions
        ) implements ReferenceDescriptions {}

    }

}
