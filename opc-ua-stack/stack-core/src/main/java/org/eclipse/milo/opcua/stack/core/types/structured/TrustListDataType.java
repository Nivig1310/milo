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
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
@ToString
public class TrustListDataType extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=12554");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=12680");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=12676");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15044");

    private final UInteger specifiedLists;

    private final ByteString[] trustedCertificates;

    private final ByteString[] trustedCrls;

    private final ByteString[] issuerCertificates;

    private final ByteString[] issuerCrls;

    public TrustListDataType(UInteger specifiedLists, ByteString[] trustedCertificates,
                             ByteString[] trustedCrls, ByteString[] issuerCertificates, ByteString[] issuerCrls) {
        this.specifiedLists = specifiedLists;
        this.trustedCertificates = trustedCertificates;
        this.trustedCrls = trustedCrls;
        this.issuerCertificates = issuerCertificates;
        this.issuerCrls = issuerCrls;
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

    public UInteger getSpecifiedLists() {
        return specifiedLists;
    }

    public ByteString[] getTrustedCertificates() {
        return trustedCertificates;
    }

    public ByteString[] getTrustedCrls() {
        return trustedCrls;
    }

    public ByteString[] getIssuerCertificates() {
        return issuerCertificates;
    }

    public ByteString[] getIssuerCrls() {
        return issuerCrls;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 12680),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("SpecifiedLists", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("TrustedCertificates", LocalizedText.NULL_VALUE, new NodeId(0, 15), 1, null, UInteger.valueOf(0), false),
                new StructureField("TrustedCrls", LocalizedText.NULL_VALUE, new NodeId(0, 15), 1, null, UInteger.valueOf(0), false),
                new StructureField("IssuerCertificates", LocalizedText.NULL_VALUE, new NodeId(0, 15), 1, null, UInteger.valueOf(0), false),
                new StructureField("IssuerCrls", LocalizedText.NULL_VALUE, new NodeId(0, 15), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<TrustListDataType> {
        @Override
        public Class<TrustListDataType> getType() {
            return TrustListDataType.class;
        }

        @Override
        public TrustListDataType decodeType(SerializationContext context, UaDecoder decoder) {
            UInteger specifiedLists = decoder.decodeUInt32("SpecifiedLists");
            ByteString[] trustedCertificates = decoder.decodeByteStringArray("TrustedCertificates");
            ByteString[] trustedCrls = decoder.decodeByteStringArray("TrustedCrls");
            ByteString[] issuerCertificates = decoder.decodeByteStringArray("IssuerCertificates");
            ByteString[] issuerCrls = decoder.decodeByteStringArray("IssuerCrls");
            return new TrustListDataType(specifiedLists, trustedCertificates, trustedCrls, issuerCertificates, issuerCrls);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               TrustListDataType value) {
            encoder.encodeUInt32("SpecifiedLists", value.getSpecifiedLists());
            encoder.encodeByteStringArray("TrustedCertificates", value.getTrustedCertificates());
            encoder.encodeByteStringArray("TrustedCrls", value.getTrustedCrls());
            encoder.encodeByteStringArray("IssuerCertificates", value.getIssuerCertificates());
            encoder.encodeByteStringArray("IssuerCrls", value.getIssuerCrls());
        }
    }
}
