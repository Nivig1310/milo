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
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.40">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.40</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
@ToString
public class UnsignedRationalNumber extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=24107");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=24110");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=24122");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=24134");

    private final UInteger numerator;

    private final UInteger denominator;

    public UnsignedRationalNumber(UInteger numerator, UInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
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

    public UInteger getNumerator() {
        return numerator;
    }

    public UInteger getDenominator() {
        return denominator;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 24110),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("Numerator", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("Denominator", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<UnsignedRationalNumber> {
        @Override
        public Class<UnsignedRationalNumber> getType() {
            return UnsignedRationalNumber.class;
        }

        @Override
        public UnsignedRationalNumber decodeType(SerializationContext context, UaDecoder decoder) {
            UInteger numerator = decoder.decodeUInt32("Numerator");
            UInteger denominator = decoder.decodeUInt32("Denominator");
            return new UnsignedRationalNumber(numerator, denominator);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               UnsignedRationalNumber value) {
            encoder.encodeUInt32("Numerator", value.getNumerator());
            encoder.encodeUInt32("Denominator", value.getDenominator());
        }
    }
}
