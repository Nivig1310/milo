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
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.28">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.28</a>
 */
@EqualsAndHashCode(
    callSuper = true
)
@SuperBuilder
@ToString
public class ThreeDOrientation extends Orientation implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=18812");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=18821");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=18857");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=19070");

    private final Double a;

    private final Double b;

    private final Double c;

    public ThreeDOrientation(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public Double getA() {
        return a;
    }

    public Double getB() {
        return b;
    }

    public Double getC() {
        return c;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 18821),
            new NodeId(0, 18811),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("A", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false),
                new StructureField("B", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false),
                new StructureField("C", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<ThreeDOrientation> {
        @Override
        public Class<ThreeDOrientation> getType() {
            return ThreeDOrientation.class;
        }

        @Override
        public ThreeDOrientation decodeType(EncodingContext context, UaDecoder decoder) {
            Double a = decoder.decodeDouble("A");
            Double b = decoder.decodeDouble("B");
            Double c = decoder.decodeDouble("C");
            return new ThreeDOrientation(a, b, c);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder, ThreeDOrientation value) {
            encoder.encodeDouble("A", value.getA());
            encoder.encodeDouble("B", value.getB());
            encoder.encodeDouble("C", value.getC());
        }
    }
}
