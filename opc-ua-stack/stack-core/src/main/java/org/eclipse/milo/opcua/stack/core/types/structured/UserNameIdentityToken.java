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

import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.util.StringJoiner;

import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.encoding.EncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.GenericDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.encoding.UaDecoder;
import org.eclipse.milo.opcua.stack.core.encoding.UaEncoder;
import org.eclipse.milo.opcua.stack.core.types.UaStructuredType;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;
import org.jetbrains.annotations.Nullable;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.3.15/#12.3.15.3">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.3.15/#12.3.15.3</a>
 */
@EqualsAndHashCode(
    callSuper = true
)
@SuperBuilder
public class UserNameIdentityToken extends UserIdentityToken implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=322");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=324");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=323");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15142");

    private final @Nullable String userName;

    private final ByteString password;

    private final @Nullable String encryptionAlgorithm;

    public UserNameIdentityToken(@Nullable String policyId, @Nullable String userName,
                                 ByteString password, @Nullable String encryptionAlgorithm) {
        super(policyId);
        this.userName = userName;
        this.password = password;
        this.encryptionAlgorithm = encryptionAlgorithm;
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

    public @Nullable String getUserName() {
        return userName;
    }

    public ByteString getPassword() {
        return password;
    }

    public @Nullable String getEncryptionAlgorithm() {
        return encryptionAlgorithm;
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", UserNameIdentityToken.class.getSimpleName() + "[", "]");
        joiner.add("userName='" + getUserName() + "'");
        joiner.add("password=" + getPassword());
        joiner.add("encryptionAlgorithm='" + getEncryptionAlgorithm() + "'");
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 324),
            new NodeId(0, 316),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("PolicyId", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("UserName", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("Password", LocalizedText.NULL_VALUE, new NodeId(0, 15), -1, null, UInteger.valueOf(0), false),
                new StructureField("EncryptionAlgorithm", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<UserNameIdentityToken> {
        @Override
        public Class<UserNameIdentityToken> getType() {
            return UserNameIdentityToken.class;
        }

        @Override
        public UserNameIdentityToken decodeType(EncodingContext context, UaDecoder decoder) {
            String policyId = decoder.decodeString("PolicyId");
            String userName = decoder.decodeString("UserName");
            ByteString password = decoder.decodeByteString("Password");
            String encryptionAlgorithm = decoder.decodeString("EncryptionAlgorithm");
            return new UserNameIdentityToken(policyId, userName, password, encryptionAlgorithm);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder,
                               UserNameIdentityToken value) {
            encoder.encodeString("PolicyId", value.getPolicyId());
            encoder.encodeString("UserName", value.getUserName());
            encoder.encodeByteString("Password", value.getPassword());
            encoder.encodeString("EncryptionAlgorithm", value.getEncryptionAlgorithm());
        }
    }
}
