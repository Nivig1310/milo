/*
 * Copyright (c) 2024 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.types.structured;

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.encoding.EncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.encoding.UaDecoder;
import org.eclipse.milo.opcua.stack.core.encoding.UaEncoder;
import org.eclipse.milo.opcua.stack.core.types.UaResponseMessageType;
import org.eclipse.milo.opcua.stack.core.types.builtin.DiagnosticInfo;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;
import org.jetbrains.annotations.Nullable;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part4/5.12.5/#5.12.5.2">https://reference.opcfoundation.org/v105/Core/docs/Part4/5.12.5/#5.12.5.2</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
public class SetTriggeringResponse extends Structure implements UaResponseMessageType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=776");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=778");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=777");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15333");

    private final ResponseHeader responseHeader;

    private final StatusCode @Nullable [] addResults;

    private final DiagnosticInfo @Nullable [] addDiagnosticInfos;

    private final StatusCode @Nullable [] removeResults;

    private final DiagnosticInfo @Nullable [] removeDiagnosticInfos;

    public SetTriggeringResponse(ResponseHeader responseHeader, StatusCode @Nullable [] addResults,
                                 DiagnosticInfo @Nullable [] addDiagnosticInfos, StatusCode @Nullable [] removeResults,
                                 DiagnosticInfo @Nullable [] removeDiagnosticInfos) {
        this.responseHeader = responseHeader;
        this.addResults = addResults;
        this.addDiagnosticInfos = addDiagnosticInfos;
        this.removeResults = removeResults;
        this.removeDiagnosticInfos = removeDiagnosticInfos;
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

    public ResponseHeader getResponseHeader() {
        return responseHeader;
    }

    public StatusCode @Nullable [] getAddResults() {
        return addResults;
    }

    public DiagnosticInfo @Nullable [] getAddDiagnosticInfos() {
        return addDiagnosticInfos;
    }

    public StatusCode @Nullable [] getRemoveResults() {
        return removeResults;
    }

    public DiagnosticInfo @Nullable [] getRemoveDiagnosticInfos() {
        return removeDiagnosticInfos;
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", SetTriggeringResponse.class.getSimpleName() + "[", "]");
        joiner.add("responseHeader=" + getResponseHeader());
        joiner.add("addResults=" + java.util.Arrays.toString(getAddResults()));
        joiner.add("addDiagnosticInfos=" + java.util.Arrays.toString(getAddDiagnosticInfos()));
        joiner.add("removeResults=" + java.util.Arrays.toString(getRemoveResults()));
        joiner.add("removeDiagnosticInfos=" + java.util.Arrays.toString(getRemoveDiagnosticInfos()));
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 778),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("ResponseHeader", LocalizedText.NULL_VALUE, new NodeId(0, 392), -1, null, UInteger.valueOf(0), false),
                new StructureField("AddResults", LocalizedText.NULL_VALUE, new NodeId(0, 19), 1, null, UInteger.valueOf(0), false),
                new StructureField("AddDiagnosticInfos", LocalizedText.NULL_VALUE, new NodeId(0, 25), 1, null, UInteger.valueOf(0), false),
                new StructureField("RemoveResults", LocalizedText.NULL_VALUE, new NodeId(0, 19), 1, null, UInteger.valueOf(0), false),
                new StructureField("RemoveDiagnosticInfos", LocalizedText.NULL_VALUE, new NodeId(0, 25), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<SetTriggeringResponse> {
        @Override
        public Class<SetTriggeringResponse> getType() {
            return SetTriggeringResponse.class;
        }

        @Override
        public SetTriggeringResponse decodeType(EncodingContext context, UaDecoder decoder) {
            ResponseHeader responseHeader = (ResponseHeader) decoder.decodeStruct("ResponseHeader", ResponseHeader.TYPE_ID);
            StatusCode[] addResults = decoder.decodeStatusCodeArray("AddResults");
            DiagnosticInfo[] addDiagnosticInfos = decoder.decodeDiagnosticInfoArray("AddDiagnosticInfos");
            StatusCode[] removeResults = decoder.decodeStatusCodeArray("RemoveResults");
            DiagnosticInfo[] removeDiagnosticInfos = decoder.decodeDiagnosticInfoArray("RemoveDiagnosticInfos");
            return new SetTriggeringResponse(responseHeader, addResults, addDiagnosticInfos, removeResults, removeDiagnosticInfos);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder,
                               SetTriggeringResponse value) {
            encoder.encodeStruct("ResponseHeader", value.getResponseHeader(), ResponseHeader.TYPE_ID);
            encoder.encodeStatusCodeArray("AddResults", value.getAddResults());
            encoder.encodeDiagnosticInfoArray("AddDiagnosticInfos", value.getAddDiagnosticInfos());
            encoder.encodeStatusCodeArray("RemoveResults", value.getRemoveResults());
            encoder.encodeDiagnosticInfoArray("RemoveDiagnosticInfos", value.getRemoveDiagnosticInfos());
        }
    }
}
