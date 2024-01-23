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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;

import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.encoding.EncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.encoding.UaDecoder;
import org.eclipse.milo.opcua.stack.core.encoding.UaEncoder;
import org.eclipse.milo.opcua.stack.core.types.UaStructuredType;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.PerformUpdateType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;
import org.eclipse.milo.opcua.stack.core.util.codegen.EqualsBuilder;
import org.eclipse.milo.opcua.stack.core.util.codegen.HashCodeBuilder;
import org.jetbrains.annotations.Nullable;

/**
 * @see <a href="https://reference.opcfoundation.org/v104/Core/docs/Part11/6.8.2/#6.8.2.1">https://reference.opcfoundation.org/v104/Core/docs/Part11/6.8.2/#6.8.2.1</a>
 */
public class UpdateDataDetails extends HistoryUpdateDetails implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=680");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=682");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=681");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15280");

    private final PerformUpdateType performInsertReplace;

    private final DataValue @Nullable [] updateValues;

    public UpdateDataDetails(NodeId nodeId, PerformUpdateType performInsertReplace,
                             DataValue @Nullable [] updateValues) {
        super(nodeId);
        this.performInsertReplace = performInsertReplace;
        this.updateValues = updateValues;
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

    public PerformUpdateType getPerformInsertReplace() {
        return performInsertReplace;
    }

    public DataValue @Nullable [] getUpdateValues() {
        return updateValues;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        }
        UpdateDataDetails that = (UpdateDataDetails) object;
        var eqb = new EqualsBuilder();
        eqb.append(getPerformInsertReplace(), that.getPerformInsertReplace());
        eqb.append(getUpdateValues(), that.getUpdateValues());
        eqb.appendSuper(super.equals(object));
        return eqb.build();
    }

    @Override
    public int hashCode() {
        var hcb = new HashCodeBuilder();
        hcb.append(getPerformInsertReplace());
        hcb.append(getUpdateValues());
        hcb.appendSuper(super.hashCode());
        return hcb.build();
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", UpdateDataDetails.class.getSimpleName() + "[", "]");
        joiner.add("performInsertReplace=" + getPerformInsertReplace());
        joiner.add("updateValues=" + java.util.Arrays.toString(getUpdateValues()));
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 682),
            new NodeId(0, 677),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("NodeId", LocalizedText.NULL_VALUE, new NodeId(0, 17), -1, null, UInteger.valueOf(0), false),
                new StructureField("PerformInsertReplace", LocalizedText.NULL_VALUE, new NodeId(0, 11293), -1, null, UInteger.valueOf(0), false),
                new StructureField("UpdateValues", LocalizedText.NULL_VALUE, new NodeId(0, 23), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<UpdateDataDetails> {
        @Override
        public Class<UpdateDataDetails> getType() {
            return UpdateDataDetails.class;
        }

        @Override
        public UpdateDataDetails decodeType(EncodingContext context, UaDecoder decoder) {
            NodeId nodeId = decoder.decodeNodeId("NodeId");
            PerformUpdateType performInsertReplace = PerformUpdateType.from(decoder.decodeEnum("PerformInsertReplace"));
            DataValue[] updateValues = decoder.decodeDataValueArray("UpdateValues");
            return new UpdateDataDetails(nodeId, performInsertReplace, updateValues);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder, UpdateDataDetails value) {
            encoder.encodeNodeId("NodeId", value.getNodeId());
            encoder.encodeEnum("PerformInsertReplace", value.getPerformInsertReplace());
            encoder.encodeDataValueArray("UpdateValues", value.getUpdateValues());
        }
    }
}
