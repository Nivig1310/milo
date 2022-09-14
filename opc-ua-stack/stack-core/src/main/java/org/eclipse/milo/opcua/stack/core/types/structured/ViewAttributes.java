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
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part4/7.24.9">https://reference.opcfoundation.org/v105/Core/docs/Part4/7.24.9</a>
 */
@EqualsAndHashCode(
    callSuper = true
)
@SuperBuilder
@ToString
public class ViewAttributes extends NodeAttributes implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=373");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=375");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=374");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15162");

    private final Boolean containsNoLoops;

    private final UByte eventNotifier;

    public ViewAttributes(UInteger specifiedAttributes, LocalizedText displayName,
                          LocalizedText description, UInteger writeMask, UInteger userWriteMask,
                          Boolean containsNoLoops, UByte eventNotifier) {
        super(specifiedAttributes, displayName, description, writeMask, userWriteMask);
        this.containsNoLoops = containsNoLoops;
        this.eventNotifier = eventNotifier;
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

    public Boolean getContainsNoLoops() {
        return containsNoLoops;
    }

    public UByte getEventNotifier() {
        return eventNotifier;
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 375),
            new NodeId(0, 349),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("SpecifiedAttributes", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("DisplayName", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("Description", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("WriteMask", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("UserWriteMask", LocalizedText.NULL_VALUE, new NodeId(0, 7), -1, null, UInteger.valueOf(0), false),
                new StructureField("ContainsNoLoops", LocalizedText.NULL_VALUE, new NodeId(0, 1), -1, null, UInteger.valueOf(0), false),
                new StructureField("EventNotifier", LocalizedText.NULL_VALUE, new NodeId(0, 3), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<ViewAttributes> {
        @Override
        public Class<ViewAttributes> getType() {
            return ViewAttributes.class;
        }

        @Override
        public ViewAttributes decodeType(SerializationContext context, UaDecoder decoder) {
            UInteger specifiedAttributes = decoder.decodeUInt32("SpecifiedAttributes");
            LocalizedText displayName = decoder.decodeLocalizedText("DisplayName");
            LocalizedText description = decoder.decodeLocalizedText("Description");
            UInteger writeMask = decoder.decodeUInt32("WriteMask");
            UInteger userWriteMask = decoder.decodeUInt32("UserWriteMask");
            Boolean containsNoLoops = decoder.decodeBoolean("ContainsNoLoops");
            UByte eventNotifier = decoder.decodeByte("EventNotifier");
            return new ViewAttributes(specifiedAttributes, displayName, description, writeMask, userWriteMask, containsNoLoops, eventNotifier);
        }

        @Override
        public void encodeType(SerializationContext context, UaEncoder encoder, ViewAttributes value) {
            encoder.encodeUInt32("SpecifiedAttributes", value.getSpecifiedAttributes());
            encoder.encodeLocalizedText("DisplayName", value.getDisplayName());
            encoder.encodeLocalizedText("Description", value.getDescription());
            encoder.encodeUInt32("WriteMask", value.getWriteMask());
            encoder.encodeUInt32("UserWriteMask", value.getUserWriteMask());
            encoder.encodeBoolean("ContainsNoLoops", value.getContainsNoLoops());
            encoder.encodeByte("EventNotifier", value.getEventNotifier());
        }
    }
}
