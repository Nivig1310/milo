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
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part4/7.13.2">https://reference.opcfoundation.org/v105/Core/docs/Part4/7.13.2</a>
 */
@EqualsAndHashCode(
    callSuper = true
)
@SuperBuilder
@ToString
public class MdnsDiscoveryConfiguration extends DiscoveryConfiguration implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=12891");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=12901");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=12893");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15106");

    private final String mdnsServerName;

    private final String[] serverCapabilities;

    public MdnsDiscoveryConfiguration(String mdnsServerName, String[] serverCapabilities) {
        this.mdnsServerName = mdnsServerName;
        this.serverCapabilities = serverCapabilities;
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

    public String getMdnsServerName() {
        return mdnsServerName;
    }

    public String[] getServerCapabilities() {
        return serverCapabilities;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 12901),
            new NodeId(0, 12890),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("MdnsServerName", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("ServerCapabilities", LocalizedText.NULL_VALUE, new NodeId(0, 12), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<MdnsDiscoveryConfiguration> {
        @Override
        public Class<MdnsDiscoveryConfiguration> getType() {
            return MdnsDiscoveryConfiguration.class;
        }

        @Override
        public MdnsDiscoveryConfiguration decodeType(SerializationContext context, UaDecoder decoder) {
            String mdnsServerName = decoder.decodeString("MdnsServerName");
            String[] serverCapabilities = decoder.decodeStringArray("ServerCapabilities");
            return new MdnsDiscoveryConfiguration(mdnsServerName, serverCapabilities);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               MdnsDiscoveryConfiguration value) {
            encoder.encodeString("MdnsServerName", value.getMdnsServerName());
            encoder.encodeStringArray("ServerCapabilities", value.getServerCapabilities());
        }
    }
}
