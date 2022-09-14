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
import org.eclipse.milo.opcua.stack.core.types.enumerated.ServerState;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.10">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.10</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
@ToString
public class ServerStatusDataType extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=862");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=864");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=863");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15367");

    private final DateTime startTime;

    private final DateTime currentTime;

    private final ServerState state;

    private final BuildInfo buildInfo;

    private final UInteger secondsTillShutdown;

    private final LocalizedText shutdownReason;

    public ServerStatusDataType(DateTime startTime, DateTime currentTime, ServerState state,
                                BuildInfo buildInfo, UInteger secondsTillShutdown, LocalizedText shutdownReason) {
        this.startTime = startTime;
        this.currentTime = currentTime;
        this.state = state;
        this.buildInfo = buildInfo;
        this.secondsTillShutdown = secondsTillShutdown;
        this.shutdownReason = shutdownReason;
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

    public DateTime getStartTime() {
        return startTime;
    }

    public DateTime getCurrentTime() {
        return currentTime;
    }

    public ServerState getState() {
        return state;
    }

    public BuildInfo getBuildInfo() {
        return buildInfo;
    }

    public UInteger getSecondsTillShutdown() {
        return secondsTillShutdown;
    }

    public LocalizedText getShutdownReason() {
        return shutdownReason;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 864),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("StartTime", LocalizedText.NULL_VALUE, new NodeId(0, 294), -1, null, UInteger.valueOf(0), false),
                new StructureField("CurrentTime", LocalizedText.NULL_VALUE, new NodeId(0, 294), -1, null, UInteger.valueOf(0), false),
                new StructureField("State", LocalizedText.NULL_VALUE, new NodeId(0, 852), -1, null, UInteger.valueOf(0), false),
                new StructureField("BuildInfo", LocalizedText.NULL_VALUE, new NodeId(0, 338), -1, null, UInteger.valueOf(0), false),
                new StructureField("SecondsTillShutdown", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("ShutdownReason", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<ServerStatusDataType> {
        @Override
        public Class<ServerStatusDataType> getType() {
            return ServerStatusDataType.class;
        }

        @Override
        public ServerStatusDataType decodeType(SerializationContext context, UaDecoder decoder) {
            DateTime startTime = decoder.decodeDateTime("StartTime");
            DateTime currentTime = decoder.decodeDateTime("CurrentTime");
            ServerState state = ServerState.from(decoder.decodeEnum("State"));
            BuildInfo buildInfo = (BuildInfo) decoder.decodeStruct("BuildInfo", BuildInfo.TYPE_ID);
            UInteger secondsTillShutdown = decoder.decodeUInt32("SecondsTillShutdown");
            LocalizedText shutdownReason = decoder.decodeLocalizedText("ShutdownReason");
            return new ServerStatusDataType(startTime, currentTime, state, buildInfo, secondsTillShutdown, shutdownReason);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               ServerStatusDataType value) {
            encoder.encodeDateTime("StartTime", value.getStartTime());
            encoder.encodeDateTime("CurrentTime", value.getCurrentTime());
            encoder.encodeEnum("State", value.getState());
            encoder.encodeStruct("BuildInfo", value.getBuildInfo(), BuildInfo.TYPE_ID);
            encoder.encodeUInt32("SecondsTillShutdown", value.getSecondsTillShutdown());
            encoder.encodeLocalizedText("ShutdownReason", value.getShutdownReason());
        }
    }
}
