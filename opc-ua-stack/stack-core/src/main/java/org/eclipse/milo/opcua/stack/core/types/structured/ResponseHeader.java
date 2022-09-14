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
import org.eclipse.milo.opcua.stack.core.types.builtin.DiagnosticInfo;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part4/7.34">https://reference.opcfoundation.org/v105/Core/docs/Part4/7.34</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
@ToString
public class ResponseHeader extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=392");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=394");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=393");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15089");

    private final DateTime timestamp;

    private final UInteger requestHandle;

    private final StatusCode serviceResult;

    private final DiagnosticInfo serviceDiagnostics;

    private final String[] stringTable;

    private final ExtensionObject additionalHeader;

    public ResponseHeader(DateTime timestamp, UInteger requestHandle, StatusCode serviceResult,
                          DiagnosticInfo serviceDiagnostics, String[] stringTable, ExtensionObject additionalHeader) {
        this.timestamp = timestamp;
        this.requestHandle = requestHandle;
        this.serviceResult = serviceResult;
        this.serviceDiagnostics = serviceDiagnostics;
        this.stringTable = stringTable;
        this.additionalHeader = additionalHeader;
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

    public DateTime getTimestamp() {
        return timestamp;
    }

    public UInteger getRequestHandle() {
        return requestHandle;
    }

    public StatusCode getServiceResult() {
        return serviceResult;
    }

    public DiagnosticInfo getServiceDiagnostics() {
        return serviceDiagnostics;
    }

    public String[] getStringTable() {
        return stringTable;
    }

    public ExtensionObject getAdditionalHeader() {
        return additionalHeader;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 394),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("Timestamp", LocalizedText.NULL_VALUE, new NodeId(0, 294), -1, null, UInteger.valueOf(0), false),
                new StructureField("RequestHandle", LocalizedText.NULL_VALUE, new NodeId(0, 288), -1, null, UInteger.valueOf(0), false),
                new StructureField("ServiceResult", LocalizedText.NULL_VALUE, new NodeId(0, 19), -1, null, UInteger.valueOf(0), false),
                new StructureField("ServiceDiagnostics", LocalizedText.NULL_VALUE, new NodeId(0, 25), -1, null, UInteger.valueOf(0), false),
                new StructureField("StringTable", LocalizedText.NULL_VALUE, new NodeId(0, 12), 1, null, UInteger.valueOf(0), false),
                new StructureField("AdditionalHeader", LocalizedText.NULL_VALUE, new NodeId(0, 22), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<ResponseHeader> {
        @Override
        public Class<ResponseHeader> getType() {
            return ResponseHeader.class;
        }

        @Override
        public ResponseHeader decodeType(SerializationContext context, UaDecoder decoder) {
            DateTime timestamp = decoder.decodeDateTime("Timestamp");
            UInteger requestHandle = decoder.decodeUInt32("RequestHandle");
            StatusCode serviceResult = decoder.decodeStatusCode("ServiceResult");
            DiagnosticInfo serviceDiagnostics = decoder.decodeDiagnosticInfo("ServiceDiagnostics");
            String[] stringTable = decoder.decodeStringArray("StringTable");
            ExtensionObject additionalHeader = decoder.decodeExtensionObject("AdditionalHeader");
            return new ResponseHeader(timestamp, requestHandle, serviceResult, serviceDiagnostics, stringTable, additionalHeader);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder, ResponseHeader value) {
            encoder.encodeDateTime("Timestamp", value.getTimestamp());
            encoder.encodeUInt32("RequestHandle", value.getRequestHandle());
            encoder.encodeStatusCode("ServiceResult", value.getServiceResult());
            encoder.encodeDiagnosticInfo("ServiceDiagnostics", value.getServiceDiagnostics());
            encoder.encodeStringArray("StringTable", value.getStringTable());
            encoder.encodeExtensionObject("AdditionalHeader", value.getAdditionalHeader());
        }
    }
}
