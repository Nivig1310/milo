/*
 * Copyright (c) 2022 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.structured;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.serialization.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.SerializationContext;
import org.eclipse.milo.opcua.stack.core.serialization.UaDecoder;
import org.eclipse.milo.opcua.stack.core.serialization.UaEncoder;
import org.eclipse.milo.opcua.stack.core.types.UaStructuredType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

@EqualsAndHashCode(
    callSuper = true
)
@SuperBuilder
@ToString
public class InstanceNode extends Node implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=11879");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=11889");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=11887");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15069");

    public InstanceNode(NodeId nodeId, NodeClass nodeClass, QualifiedName browseName,
                        LocalizedText displayName, LocalizedText description, UInteger writeMask,
                        UInteger userWriteMask, RolePermissionType[] rolePermissions,
                        RolePermissionType[] userRolePermissions, UShort accessRestrictions,
                        ReferenceNode[] references) {
        super(nodeId, nodeClass, browseName, displayName, description, writeMask, userWriteMask, rolePermissions, userRolePermissions, accessRestrictions, references);
    }

    @Override
    public ExpandedNodeId getTypeId() {
        return TYPE_ID;
    }

    @Override
    public ExpandedNodeId getBinaryEncodingId() {
        return BINARY_ENCODING_ID;
    }

    @Override
    public ExpandedNodeId getXmlEncodingId() {
        return XML_ENCODING_ID;
    }

    @Override
    public ExpandedNodeId getJsonEncodingId() {
        return JSON_ENCODING_ID;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 11889),
            new NodeId(0, 258),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("NodeId", LocalizedText.NULL_VALUE, new NodeId(0, 17), -1, null, UInteger.valueOf(0), false),
                new StructureField("NodeClass", LocalizedText.NULL_VALUE, new NodeId(0, 257), -1, null, UInteger.valueOf(0), false),
                new StructureField("BrowseName", LocalizedText.NULL_VALUE, new NodeId(0, 20), -1, null, UInteger.valueOf(0), false),
                new StructureField("DisplayName", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("Description", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("WriteMask", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("UserWriteMask", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("RolePermissions", LocalizedText.NULL_VALUE, new NodeId(0, 96), 1, null, UInteger.valueOf(0), false),
                new StructureField("UserRolePermissions", LocalizedText.NULL_VALUE, new NodeId(0, 96), 1, null, UInteger.valueOf(0), false),
                new StructureField("AccessRestrictions", LocalizedText.NULL_VALUE, new NodeId(0, 5), -1, null, UInteger.valueOf(0), false),
                new StructureField("References", LocalizedText.NULL_VALUE, new NodeId(0, 285), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<InstanceNode> {
        @Override
        public Class<InstanceNode> getType() {
            return InstanceNode.class;
        }

        @Override
        public InstanceNode decodeType(SerializationContext context, UaDecoder decoder) {
            NodeId nodeId = decoder.decodeNodeId("NodeId");
            NodeClass nodeClass = NodeClass.from(decoder.decodeEnum("NodeClass"));
            QualifiedName browseName = decoder.decodeQualifiedName("BrowseName");
            LocalizedText displayName = decoder.decodeLocalizedText("DisplayName");
            LocalizedText description = decoder.decodeLocalizedText("Description");
            UInteger writeMask = decoder.decodeUInt32("WriteMask");
            UInteger userWriteMask = decoder.decodeUInt32("UserWriteMask");
            RolePermissionType[] rolePermissions = (RolePermissionType[]) decoder.decodeStructArray("RolePermissions", RolePermissionType.TYPE_ID);
            RolePermissionType[] userRolePermissions = (RolePermissionType[]) decoder.decodeStructArray("UserRolePermissions", RolePermissionType.TYPE_ID);
            UShort accessRestrictions = decoder.decodeUInt16("AccessRestrictions");
            ReferenceNode[] references = (ReferenceNode[]) decoder.decodeStructArray("References", ReferenceNode.TYPE_ID);
            return new InstanceNode(nodeId, nodeClass, browseName, displayName, description, writeMask, userWriteMask, rolePermissions, userRolePermissions, accessRestrictions, references);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder, InstanceNode value) {
            encoder.encodeNodeId("NodeId", value.getNodeId());
            encoder.encodeEnum("NodeClass", value.getNodeClass());
            encoder.encodeQualifiedName("BrowseName", value.getBrowseName());
            encoder.encodeLocalizedText("DisplayName", value.getDisplayName());
            encoder.encodeLocalizedText("Description", value.getDescription());
            encoder.encodeUInt32("WriteMask", value.getWriteMask());
            encoder.encodeUInt32("UserWriteMask", value.getUserWriteMask());
            encoder.encodeStructArray("RolePermissions", value.getRolePermissions(), RolePermissionType.TYPE_ID);
            encoder.encodeStructArray("UserRolePermissions", value.getUserRolePermissions(), RolePermissionType.TYPE_ID);
            encoder.encodeUInt16("AccessRestrictions", value.getAccessRestrictions());
            encoder.encodeStructArray("References", value.getReferences(), ReferenceNode.TYPE_ID);
        }
    }
}
