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
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part4/7.24.4">https://reference.opcfoundation.org/v105/Core/docs/Part4/7.24.4</a>
 */
public class MethodAttributes extends NodeAttributes implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=358");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=360");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=359");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15157");

    private final Boolean executable;

    private final Boolean userExecutable;

    public MethodAttributes(UInteger specifiedAttributes, LocalizedText displayName,
                            LocalizedText description, UInteger writeMask, UInteger userWriteMask, Boolean executable,
                            Boolean userExecutable) {
        super(specifiedAttributes, displayName, description, writeMask, userWriteMask);
        this.executable = executable;
        this.userExecutable = userExecutable;
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

    public Boolean getExecutable() {
        return executable;
    }

    public Boolean getUserExecutable() {
        return userExecutable;
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", MethodAttributes.class.getSimpleName() + "[", "]");
        joiner.add("executable=" + getExecutable());
        joiner.add("userExecutable=" + getUserExecutable());
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 360),
            new NodeId(0, 349),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("SpecifiedAttributes", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("DisplayName", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("Description", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("WriteMask", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("UserWriteMask", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("Executable", LocalizedText.NULL_VALUE, new NodeId(0, 1), -1, null, UInteger.valueOf(0), false),
                new StructureField("UserExecutable", LocalizedText.NULL_VALUE, new NodeId(0, 1), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<MethodAttributes> {
        @Override
        public Class<MethodAttributes> getType() {
            return MethodAttributes.class;
        }

        @Override
        public MethodAttributes decodeType(EncodingContext context, UaDecoder decoder) {
            UInteger specifiedAttributes = decoder.decodeUInt32("SpecifiedAttributes");
            LocalizedText displayName = decoder.decodeLocalizedText("DisplayName");
            LocalizedText description = decoder.decodeLocalizedText("Description");
            UInteger writeMask = decoder.decodeUInt32("WriteMask");
            UInteger userWriteMask = decoder.decodeUInt32("UserWriteMask");
            Boolean executable = decoder.decodeBoolean("Executable");
            Boolean userExecutable = decoder.decodeBoolean("UserExecutable");
            return new MethodAttributes(specifiedAttributes, displayName, description, writeMask, userWriteMask, executable, userExecutable);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder, MethodAttributes value) {
            encoder.encodeUInt32("SpecifiedAttributes", value.getSpecifiedAttributes());
            encoder.encodeLocalizedText("DisplayName", value.getDisplayName());
            encoder.encodeLocalizedText("Description", value.getDescription());
            encoder.encodeUInt32("WriteMask", value.getWriteMask());
            encoder.encodeUInt32("UserWriteMask", value.getUserWriteMask());
            encoder.encodeBoolean("Executable", value.getExecutable());
            encoder.encodeBoolean("UserExecutable", value.getUserExecutable());
        }
    }
}
