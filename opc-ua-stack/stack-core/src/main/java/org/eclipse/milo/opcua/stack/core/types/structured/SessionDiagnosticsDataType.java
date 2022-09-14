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
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.11">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.11</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
@ToString
public class SessionDiagnosticsDataType extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=865");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=867");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=866");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15368");

    private final NodeId sessionId;

    private final String sessionName;

    private final ApplicationDescription clientDescription;

    private final String serverUri;

    private final String endpointUrl;

    private final String[] localeIds;

    private final Double actualSessionTimeout;

    private final UInteger maxResponseMessageSize;

    private final DateTime clientConnectionTime;

    private final DateTime clientLastContactTime;

    private final UInteger currentSubscriptionsCount;

    private final UInteger currentMonitoredItemsCount;

    private final UInteger currentPublishRequestsInQueue;

    private final ServiceCounterDataType totalRequestCount;

    private final UInteger unauthorizedRequestCount;

    private final ServiceCounterDataType readCount;

    private final ServiceCounterDataType historyReadCount;

    private final ServiceCounterDataType writeCount;

    private final ServiceCounterDataType historyUpdateCount;

    private final ServiceCounterDataType callCount;

    private final ServiceCounterDataType createMonitoredItemsCount;

    private final ServiceCounterDataType modifyMonitoredItemsCount;

    private final ServiceCounterDataType setMonitoringModeCount;

    private final ServiceCounterDataType setTriggeringCount;

    private final ServiceCounterDataType deleteMonitoredItemsCount;

    private final ServiceCounterDataType createSubscriptionCount;

    private final ServiceCounterDataType modifySubscriptionCount;

    private final ServiceCounterDataType setPublishingModeCount;

    private final ServiceCounterDataType publishCount;

    private final ServiceCounterDataType republishCount;

    private final ServiceCounterDataType transferSubscriptionsCount;

    private final ServiceCounterDataType deleteSubscriptionsCount;

    private final ServiceCounterDataType addNodesCount;

    private final ServiceCounterDataType addReferencesCount;

    private final ServiceCounterDataType deleteNodesCount;

    private final ServiceCounterDataType deleteReferencesCount;

    private final ServiceCounterDataType browseCount;

    private final ServiceCounterDataType browseNextCount;

    private final ServiceCounterDataType translateBrowsePathsToNodeIdsCount;

    private final ServiceCounterDataType queryFirstCount;

    private final ServiceCounterDataType queryNextCount;

    private final ServiceCounterDataType registerNodesCount;

    private final ServiceCounterDataType unregisterNodesCount;

    public SessionDiagnosticsDataType(NodeId sessionId, String sessionName,
                                      ApplicationDescription clientDescription, String serverUri, String endpointUrl,
                                      String[] localeIds, Double actualSessionTimeout, UInteger maxResponseMessageSize,
                                      DateTime clientConnectionTime, DateTime clientLastContactTime,
                                      UInteger currentSubscriptionsCount, UInteger currentMonitoredItemsCount,
                                      UInteger currentPublishRequestsInQueue, ServiceCounterDataType totalRequestCount,
                                      UInteger unauthorizedRequestCount, ServiceCounterDataType readCount,
                                      ServiceCounterDataType historyReadCount, ServiceCounterDataType writeCount,
                                      ServiceCounterDataType historyUpdateCount, ServiceCounterDataType callCount,
                                      ServiceCounterDataType createMonitoredItemsCount,
                                      ServiceCounterDataType modifyMonitoredItemsCount,
                                      ServiceCounterDataType setMonitoringModeCount, ServiceCounterDataType setTriggeringCount,
                                      ServiceCounterDataType deleteMonitoredItemsCount,
                                      ServiceCounterDataType createSubscriptionCount,
                                      ServiceCounterDataType modifySubscriptionCount, ServiceCounterDataType setPublishingModeCount,
                                      ServiceCounterDataType publishCount, ServiceCounterDataType republishCount,
                                      ServiceCounterDataType transferSubscriptionsCount,
                                      ServiceCounterDataType deleteSubscriptionsCount, ServiceCounterDataType addNodesCount,
                                      ServiceCounterDataType addReferencesCount, ServiceCounterDataType deleteNodesCount,
                                      ServiceCounterDataType deleteReferencesCount, ServiceCounterDataType browseCount,
                                      ServiceCounterDataType browseNextCount,
                                      ServiceCounterDataType translateBrowsePathsToNodeIdsCount,
                                      ServiceCounterDataType queryFirstCount, ServiceCounterDataType queryNextCount,
                                      ServiceCounterDataType registerNodesCount, ServiceCounterDataType unregisterNodesCount) {
        this.sessionId = sessionId;
        this.sessionName = sessionName;
        this.clientDescription = clientDescription;
        this.serverUri = serverUri;
        this.endpointUrl = endpointUrl;
        this.localeIds = localeIds;
        this.actualSessionTimeout = actualSessionTimeout;
        this.maxResponseMessageSize = maxResponseMessageSize;
        this.clientConnectionTime = clientConnectionTime;
        this.clientLastContactTime = clientLastContactTime;
        this.currentSubscriptionsCount = currentSubscriptionsCount;
        this.currentMonitoredItemsCount = currentMonitoredItemsCount;
        this.currentPublishRequestsInQueue = currentPublishRequestsInQueue;
        this.totalRequestCount = totalRequestCount;
        this.unauthorizedRequestCount = unauthorizedRequestCount;
        this.readCount = readCount;
        this.historyReadCount = historyReadCount;
        this.writeCount = writeCount;
        this.historyUpdateCount = historyUpdateCount;
        this.callCount = callCount;
        this.createMonitoredItemsCount = createMonitoredItemsCount;
        this.modifyMonitoredItemsCount = modifyMonitoredItemsCount;
        this.setMonitoringModeCount = setMonitoringModeCount;
        this.setTriggeringCount = setTriggeringCount;
        this.deleteMonitoredItemsCount = deleteMonitoredItemsCount;
        this.createSubscriptionCount = createSubscriptionCount;
        this.modifySubscriptionCount = modifySubscriptionCount;
        this.setPublishingModeCount = setPublishingModeCount;
        this.publishCount = publishCount;
        this.republishCount = republishCount;
        this.transferSubscriptionsCount = transferSubscriptionsCount;
        this.deleteSubscriptionsCount = deleteSubscriptionsCount;
        this.addNodesCount = addNodesCount;
        this.addReferencesCount = addReferencesCount;
        this.deleteNodesCount = deleteNodesCount;
        this.deleteReferencesCount = deleteReferencesCount;
        this.browseCount = browseCount;
        this.browseNextCount = browseNextCount;
        this.translateBrowsePathsToNodeIdsCount = translateBrowsePathsToNodeIdsCount;
        this.queryFirstCount = queryFirstCount;
        this.queryNextCount = queryNextCount;
        this.registerNodesCount = registerNodesCount;
        this.unregisterNodesCount = unregisterNodesCount;
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

    public NodeId getSessionId() {
        return sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public ApplicationDescription getClientDescription() {
        return clientDescription;
    }

    public String getServerUri() {
        return serverUri;
    }

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public String[] getLocaleIds() {
        return localeIds;
    }

    public Double getActualSessionTimeout() {
        return actualSessionTimeout;
    }

    public UInteger getMaxResponseMessageSize() {
        return maxResponseMessageSize;
    }

    public DateTime getClientConnectionTime() {
        return clientConnectionTime;
    }

    public DateTime getClientLastContactTime() {
        return clientLastContactTime;
    }

    public UInteger getCurrentSubscriptionsCount() {
        return currentSubscriptionsCount;
    }

    public UInteger getCurrentMonitoredItemsCount() {
        return currentMonitoredItemsCount;
    }

    public UInteger getCurrentPublishRequestsInQueue() {
        return currentPublishRequestsInQueue;
    }

    public ServiceCounterDataType getTotalRequestCount() {
        return totalRequestCount;
    }

    public UInteger getUnauthorizedRequestCount() {
        return unauthorizedRequestCount;
    }

    public ServiceCounterDataType getReadCount() {
        return readCount;
    }

    public ServiceCounterDataType getHistoryReadCount() {
        return historyReadCount;
    }

    public ServiceCounterDataType getWriteCount() {
        return writeCount;
    }

    public ServiceCounterDataType getHistoryUpdateCount() {
        return historyUpdateCount;
    }

    public ServiceCounterDataType getCallCount() {
        return callCount;
    }

    public ServiceCounterDataType getCreateMonitoredItemsCount() {
        return createMonitoredItemsCount;
    }

    public ServiceCounterDataType getModifyMonitoredItemsCount() {
        return modifyMonitoredItemsCount;
    }

    public ServiceCounterDataType getSetMonitoringModeCount() {
        return setMonitoringModeCount;
    }

    public ServiceCounterDataType getSetTriggeringCount() {
        return setTriggeringCount;
    }

    public ServiceCounterDataType getDeleteMonitoredItemsCount() {
        return deleteMonitoredItemsCount;
    }

    public ServiceCounterDataType getCreateSubscriptionCount() {
        return createSubscriptionCount;
    }

    public ServiceCounterDataType getModifySubscriptionCount() {
        return modifySubscriptionCount;
    }

    public ServiceCounterDataType getSetPublishingModeCount() {
        return setPublishingModeCount;
    }

    public ServiceCounterDataType getPublishCount() {
        return publishCount;
    }

    public ServiceCounterDataType getRepublishCount() {
        return republishCount;
    }

    public ServiceCounterDataType getTransferSubscriptionsCount() {
        return transferSubscriptionsCount;
    }

    public ServiceCounterDataType getDeleteSubscriptionsCount() {
        return deleteSubscriptionsCount;
    }

    public ServiceCounterDataType getAddNodesCount() {
        return addNodesCount;
    }

    public ServiceCounterDataType getAddReferencesCount() {
        return addReferencesCount;
    }

    public ServiceCounterDataType getDeleteNodesCount() {
        return deleteNodesCount;
    }

    public ServiceCounterDataType getDeleteReferencesCount() {
        return deleteReferencesCount;
    }

    public ServiceCounterDataType getBrowseCount() {
        return browseCount;
    }

    public ServiceCounterDataType getBrowseNextCount() {
        return browseNextCount;
    }

    public ServiceCounterDataType getTranslateBrowsePathsToNodeIdsCount() {
        return translateBrowsePathsToNodeIdsCount;
    }

    public ServiceCounterDataType getQueryFirstCount() {
        return queryFirstCount;
    }

    public ServiceCounterDataType getQueryNextCount() {
        return queryNextCount;
    }

    public ServiceCounterDataType getRegisterNodesCount() {
        return registerNodesCount;
    }

    public ServiceCounterDataType getUnregisterNodesCount() {
        return unregisterNodesCount;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 867),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("SessionId", LocalizedText.NULL_VALUE, new NodeId(0, 17), -1, null, UInteger.valueOf(0), false),
                new StructureField("SessionName", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("ClientDescription", LocalizedText.NULL_VALUE, new NodeId(0, 308), -1, null, UInteger.valueOf(0), false),
                new StructureField("ServerUri", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("EndpointUrl", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("LocaleIds", LocalizedText.NULL_VALUE, new NodeId(0, 295), 1, null, UInteger.valueOf(0), false),
                new StructureField("ActualSessionTimeout", LocalizedText.NULL_VALUE, new NodeId(0, 290), -1, null, UInteger.valueOf(0), false),
                new StructureField("MaxResponseMessageSize", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("ClientConnectionTime", LocalizedText.NULL_VALUE, new NodeId(0, 294), -1, null, UInteger.valueOf(0), false),
                new StructureField("ClientLastContactTime", LocalizedText.NULL_VALUE, new NodeId(0, 294), -1, null, UInteger.valueOf(0), false),
                new StructureField("CurrentSubscriptionsCount", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("CurrentMonitoredItemsCount", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("CurrentPublishRequestsInQueue", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("TotalRequestCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("UnauthorizedRequestCount", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("ReadCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("HistoryReadCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("WriteCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("HistoryUpdateCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("CallCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("CreateMonitoredItemsCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("ModifyMonitoredItemsCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("SetMonitoringModeCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("SetTriggeringCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("DeleteMonitoredItemsCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("CreateSubscriptionCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("ModifySubscriptionCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("SetPublishingModeCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("PublishCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("RepublishCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("TransferSubscriptionsCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("DeleteSubscriptionsCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("AddNodesCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("AddReferencesCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("DeleteNodesCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("DeleteReferencesCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("BrowseCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("BrowseNextCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("TranslateBrowsePathsToNodeIdsCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("QueryFirstCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("QueryNextCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("RegisterNodesCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false),
                new StructureField("UnregisterNodesCount", LocalizedText.NULL_VALUE, new NodeId(0, 871), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<SessionDiagnosticsDataType> {
        @Override
        public Class<SessionDiagnosticsDataType> getType() {
            return SessionDiagnosticsDataType.class;
        }

        @Override
        public SessionDiagnosticsDataType decodeType(SerializationContext context, UaDecoder decoder) {
            NodeId sessionId = decoder.decodeNodeId("SessionId");
            String sessionName = decoder.decodeString("SessionName");
            ApplicationDescription clientDescription = (ApplicationDescription) decoder.decodeStruct("ClientDescription", ApplicationDescription.TYPE_ID);
            String serverUri = decoder.decodeString("ServerUri");
            String endpointUrl = decoder.decodeString("EndpointUrl");
            String[] localeIds = decoder.decodeStringArray("LocaleIds");
            Double actualSessionTimeout = decoder.decodeDouble("ActualSessionTimeout");
            UInteger maxResponseMessageSize = decoder.decodeUInt32("MaxResponseMessageSize");
            DateTime clientConnectionTime = decoder.decodeDateTime("ClientConnectionTime");
            DateTime clientLastContactTime = decoder.decodeDateTime("ClientLastContactTime");
            UInteger currentSubscriptionsCount = decoder.decodeUInt32("CurrentSubscriptionsCount");
            UInteger currentMonitoredItemsCount = decoder.decodeUInt32("CurrentMonitoredItemsCount");
            UInteger currentPublishRequestsInQueue = decoder.decodeUInt32("CurrentPublishRequestsInQueue");
            ServiceCounterDataType totalRequestCount = (ServiceCounterDataType) decoder.decodeStruct("TotalRequestCount", ServiceCounterDataType.TYPE_ID);
            UInteger unauthorizedRequestCount = decoder.decodeUInt32("UnauthorizedRequestCount");
            ServiceCounterDataType readCount = (ServiceCounterDataType) decoder.decodeStruct("ReadCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType historyReadCount = (ServiceCounterDataType) decoder.decodeStruct("HistoryReadCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType writeCount = (ServiceCounterDataType) decoder.decodeStruct("WriteCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType historyUpdateCount = (ServiceCounterDataType) decoder.decodeStruct("HistoryUpdateCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType callCount = (ServiceCounterDataType) decoder.decodeStruct("CallCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType createMonitoredItemsCount = (ServiceCounterDataType) decoder.decodeStruct("CreateMonitoredItemsCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType modifyMonitoredItemsCount = (ServiceCounterDataType) decoder.decodeStruct("ModifyMonitoredItemsCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType setMonitoringModeCount = (ServiceCounterDataType) decoder.decodeStruct("SetMonitoringModeCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType setTriggeringCount = (ServiceCounterDataType) decoder.decodeStruct("SetTriggeringCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType deleteMonitoredItemsCount = (ServiceCounterDataType) decoder.decodeStruct("DeleteMonitoredItemsCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType createSubscriptionCount = (ServiceCounterDataType) decoder.decodeStruct("CreateSubscriptionCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType modifySubscriptionCount = (ServiceCounterDataType) decoder.decodeStruct("ModifySubscriptionCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType setPublishingModeCount = (ServiceCounterDataType) decoder.decodeStruct("SetPublishingModeCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType publishCount = (ServiceCounterDataType) decoder.decodeStruct("PublishCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType republishCount = (ServiceCounterDataType) decoder.decodeStruct("RepublishCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType transferSubscriptionsCount = (ServiceCounterDataType) decoder.decodeStruct("TransferSubscriptionsCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType deleteSubscriptionsCount = (ServiceCounterDataType) decoder.decodeStruct("DeleteSubscriptionsCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType addNodesCount = (ServiceCounterDataType) decoder.decodeStruct("AddNodesCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType addReferencesCount = (ServiceCounterDataType) decoder.decodeStruct("AddReferencesCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType deleteNodesCount = (ServiceCounterDataType) decoder.decodeStruct("DeleteNodesCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType deleteReferencesCount = (ServiceCounterDataType) decoder.decodeStruct("DeleteReferencesCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType browseCount = (ServiceCounterDataType) decoder.decodeStruct("BrowseCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType browseNextCount = (ServiceCounterDataType) decoder.decodeStruct("BrowseNextCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType translateBrowsePathsToNodeIdsCount = (ServiceCounterDataType) decoder.decodeStruct("TranslateBrowsePathsToNodeIdsCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType queryFirstCount = (ServiceCounterDataType) decoder.decodeStruct("QueryFirstCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType queryNextCount = (ServiceCounterDataType) decoder.decodeStruct("QueryNextCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType registerNodesCount = (ServiceCounterDataType) decoder.decodeStruct("RegisterNodesCount", ServiceCounterDataType.TYPE_ID);
            ServiceCounterDataType unregisterNodesCount = (ServiceCounterDataType) decoder.decodeStruct("UnregisterNodesCount", ServiceCounterDataType.TYPE_ID);
            return new SessionDiagnosticsDataType(sessionId, sessionName, clientDescription, serverUri, endpointUrl, localeIds, actualSessionTimeout, maxResponseMessageSize, clientConnectionTime, clientLastContactTime, currentSubscriptionsCount, currentMonitoredItemsCount, currentPublishRequestsInQueue, totalRequestCount, unauthorizedRequestCount, readCount, historyReadCount, writeCount, historyUpdateCount, callCount, createMonitoredItemsCount, modifyMonitoredItemsCount, setMonitoringModeCount, setTriggeringCount, deleteMonitoredItemsCount, createSubscriptionCount, modifySubscriptionCount, setPublishingModeCount, publishCount, republishCount, transferSubscriptionsCount, deleteSubscriptionsCount, addNodesCount, addReferencesCount, deleteNodesCount, deleteReferencesCount, browseCount, browseNextCount, translateBrowsePathsToNodeIdsCount, queryFirstCount, queryNextCount, registerNodesCount, unregisterNodesCount);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               SessionDiagnosticsDataType value) {
            encoder.encodeNodeId("SessionId", value.getSessionId());
            encoder.encodeString("SessionName", value.getSessionName());
            encoder.encodeStruct("ClientDescription", value.getClientDescription(), ApplicationDescription.TYPE_ID);
            encoder.encodeString("ServerUri", value.getServerUri());
            encoder.encodeString("EndpointUrl", value.getEndpointUrl());
            encoder.encodeStringArray("LocaleIds", value.getLocaleIds());
            encoder.encodeDouble("ActualSessionTimeout", value.getActualSessionTimeout());
            encoder.encodeUInt32("MaxResponseMessageSize", value.getMaxResponseMessageSize());
            encoder.encodeDateTime("ClientConnectionTime", value.getClientConnectionTime());
            encoder.encodeDateTime("ClientLastContactTime", value.getClientLastContactTime());
            encoder.encodeUInt32("CurrentSubscriptionsCount", value.getCurrentSubscriptionsCount());
            encoder.encodeUInt32("CurrentMonitoredItemsCount", value.getCurrentMonitoredItemsCount());
            encoder.encodeUInt32("CurrentPublishRequestsInQueue", value.getCurrentPublishRequestsInQueue());
            encoder.encodeStruct("TotalRequestCount", value.getTotalRequestCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeUInt32("UnauthorizedRequestCount", value.getUnauthorizedRequestCount());
            encoder.encodeStruct("ReadCount", value.getReadCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("HistoryReadCount", value.getHistoryReadCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("WriteCount", value.getWriteCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("HistoryUpdateCount", value.getHistoryUpdateCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("CallCount", value.getCallCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("CreateMonitoredItemsCount", value.getCreateMonitoredItemsCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("ModifyMonitoredItemsCount", value.getModifyMonitoredItemsCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("SetMonitoringModeCount", value.getSetMonitoringModeCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("SetTriggeringCount", value.getSetTriggeringCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("DeleteMonitoredItemsCount", value.getDeleteMonitoredItemsCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("CreateSubscriptionCount", value.getCreateSubscriptionCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("ModifySubscriptionCount", value.getModifySubscriptionCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("SetPublishingModeCount", value.getSetPublishingModeCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("PublishCount", value.getPublishCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("RepublishCount", value.getRepublishCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("TransferSubscriptionsCount", value.getTransferSubscriptionsCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("DeleteSubscriptionsCount", value.getDeleteSubscriptionsCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("AddNodesCount", value.getAddNodesCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("AddReferencesCount", value.getAddReferencesCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("DeleteNodesCount", value.getDeleteNodesCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("DeleteReferencesCount", value.getDeleteReferencesCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("BrowseCount", value.getBrowseCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("BrowseNextCount", value.getBrowseNextCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("TranslateBrowsePathsToNodeIdsCount", value.getTranslateBrowsePathsToNodeIdsCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("QueryFirstCount", value.getQueryFirstCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("QueryNextCount", value.getQueryNextCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("RegisterNodesCount", value.getRegisterNodesCount(), ServiceCounterDataType.TYPE_ID);
            encoder.encodeStruct("UnregisterNodesCount", value.getUnregisterNodesCount(), ServiceCounterDataType.TYPE_ID);
        }
    }
}
