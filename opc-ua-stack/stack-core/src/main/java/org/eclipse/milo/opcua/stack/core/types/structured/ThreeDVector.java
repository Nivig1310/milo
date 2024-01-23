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
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.24">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.24</a>
 */
public class ThreeDVector extends Vector implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=18808");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=18817");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=18853");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=19066");

    private final Double x;

    private final Double y;

    private final Double z;

    public ThreeDVector(Double x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", ThreeDVector.class.getSimpleName() + "[", "]");
        joiner.add("x=" + getX());
        joiner.add("y=" + getY());
        joiner.add("z=" + getZ());
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 18817),
            new NodeId(0, 18807),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("X", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false),
                new StructureField("Y", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false),
                new StructureField("Z", LocalizedText.NULL_VALUE, new NodeId(0, 11), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<ThreeDVector> {
        @Override
        public Class<ThreeDVector> getType() {
            return ThreeDVector.class;
        }

        @Override
        public ThreeDVector decodeType(EncodingContext context, UaDecoder decoder) {
            Double x = decoder.decodeDouble("X");
            Double y = decoder.decodeDouble("Y");
            Double z = decoder.decodeDouble("Z");
            return new ThreeDVector(x, y, z);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder, ThreeDVector value) {
            encoder.encodeDouble("X", value.getX());
            encoder.encodeDouble("Y", value.getY());
            encoder.encodeDouble("Z", value.getZ());
        }
    }
}
