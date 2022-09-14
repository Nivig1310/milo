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
public class NodeTypeDescription extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=573");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=575");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=574");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15201");

    private final ExpandedNodeId typeDefinitionNode;

    private final Boolean includeSubTypes;

    private final QueryDataDescription[] dataToReturn;

    public NodeTypeDescription(ExpandedNodeId typeDefinitionNode, Boolean includeSubTypes,
                               QueryDataDescription[] dataToReturn) {
        this.typeDefinitionNode = typeDefinitionNode;
        this.includeSubTypes = includeSubTypes;
        this.dataToReturn = dataToReturn;
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

    public ExpandedNodeId getTypeDefinitionNode() {
        return typeDefinitionNode;
    }

    public Boolean getIncludeSubTypes() {
        return includeSubTypes;
    }

    public QueryDataDescription[] getDataToReturn() {
        return dataToReturn;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 575),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("TypeDefinitionNode", LocalizedText.NULL_VALUE, new NodeId(0, 18), -1, null, UInteger.valueOf(0), false),
                new StructureField("IncludeSubTypes", LocalizedText.NULL_VALUE, new NodeId(0, 1), -1, null, UInteger.valueOf(0), false),
                new StructureField("DataToReturn", LocalizedText.NULL_VALUE, new NodeId(0, 570), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<NodeTypeDescription> {
        @Override
        public Class<NodeTypeDescription> getType() {
            return NodeTypeDescription.class;
        }

        @Override
        public NodeTypeDescription decodeType(SerializationContext context, UaDecoder decoder) {
            ExpandedNodeId typeDefinitionNode = decoder.decodeExpandedNodeId("TypeDefinitionNode");
            Boolean includeSubTypes = decoder.decodeBoolean("IncludeSubTypes");
            QueryDataDescription[] dataToReturn = (QueryDataDescription[]) decoder.decodeStructArray("DataToReturn", QueryDataDescription.TYPE_ID);
            return new NodeTypeDescription(typeDefinitionNode, includeSubTypes, dataToReturn);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder,
                               NodeTypeDescription value) {
            encoder.encodeExpandedNodeId("TypeDefinitionNode", value.getTypeDefinitionNode());
            encoder.encodeBoolean("IncludeSubTypes", value.getIncludeSubTypes());
            encoder.encodeStructArray("DataToReturn", value.getDataToReturn(), QueryDataDescription.TYPE_ID);
        }
    }
}
