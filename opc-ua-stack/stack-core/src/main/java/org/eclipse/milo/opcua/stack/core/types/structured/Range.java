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

import java.util.StringJoiner;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.encoding.EncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.encoding.UaDecoder;
import org.eclipse.milo.opcua.stack.core.encoding.UaEncoder;
import org.eclipse.milo.opcua.stack.core.types.UaStructuredType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part8/5.6.2">https://reference.opcfoundation.org/v105/Core/docs/Part8/5.6.2</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
public class Range extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=884");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=886");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=885");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15375");

    private final Double low;

    private final Double high;

    public Range(Double low, Double high) {
        this.low = low;
        this.high = high;
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

    public Double getLow() {
        return low;
    }

    public Double getHigh() {
        return high;
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", Range.class.getSimpleName() + "[", "]");
        joiner.add("low=" + getLow());
        joiner.add("high=" + getHigh());
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 886),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("Low", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false),
                new StructureField("High", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<Range> {
        @Override
        public Class<Range> getType() {
            return Range.class;
        }

        @Override
        public Range decodeType(EncodingContext context, UaDecoder decoder) {
            Double low = decoder.decodeDouble("Low");
            Double high = decoder.decodeDouble("High");
            return new Range(low, high);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder, Range value) {
            encoder.encodeDouble("Low", value.getLow());
            encoder.encodeDouble("High", value.getHigh());
        }
    }
}
