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
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part4/5.9.3/#5.9.3.1">https://reference.opcfoundation.org/v105/Core/docs/Part4/5.9.3/#5.9.3.1</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
@ToString
public class QueryDataDescription extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=570");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=572");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=571");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15200");

    private final RelativePath relativePath;

    private final UInteger attributeId;

    private final String indexRange;

    public QueryDataDescription(RelativePath relativePath, UInteger attributeId, String indexRange) {
        this.relativePath = relativePath;
        this.attributeId = attributeId;
        this.indexRange = indexRange;
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

    public RelativePath getRelativePath() {
        return relativePath;
    }

    public UInteger getAttributeId() {
        return attributeId;
    }

    public String getIndexRange() {
        return indexRange;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 572),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("RelativePath", LocalizedText.NULL_VALUE, new NodeId(0, 540), -1, null, UInteger.valueOf(0), false),
                new StructureField("AttributeId", LocalizedText.NULL_VALUE, new NodeId(0, 288), -1, null, UInteger.valueOf(0), false),
                new StructureField("IndexRange", LocalizedText.NULL_VALUE, new NodeId(0, 291), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<QueryDataDescription> {
        @Override
        public Class<QueryDataDescription> getType() {
            return QueryDataDescription.class;
        }

        @Override
        public QueryDataDescription decodeType(SerializationContext context, UaDecoder decoder) {
            RelativePath relativePath = (RelativePath) decoder.decodeStruct("RelativePath", RelativePath.TYPE_ID);
            UInteger attributeId = decoder.decodeUInt32("AttributeId");
            String indexRange = decoder.decodeString("IndexRange");
            return new QueryDataDescription(relativePath, attributeId, indexRange);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               QueryDataDescription value) {
            encoder.encodeStruct("RelativePath", value.getRelativePath(), RelativePath.TYPE_ID);
            encoder.encodeUInt32("AttributeId", value.getAttributeId());
            encoder.encodeString("IndexRange", value.getIndexRange());
        }
    }
}
