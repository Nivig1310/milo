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

import lombok.EqualsAndHashCode;
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
import org.eclipse.milo.opcua.stack.core.types.enumerated.ApplicationType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.StructureType;
import org.jetbrains.annotations.Nullable;

/**
 * @see <a href="https://reference.opcfoundation.org/v105/Core/docs/Part5/12.3.3">https://reference.opcfoundation.org/v105/Core/docs/Part5/12.3.3</a>
 */
@EqualsAndHashCode(
    callSuper = false
)
@SuperBuilder
public class ApplicationDescription extends Structure implements UaStructuredType {
    public static final ExpandedNodeId TYPE_ID = ExpandedNodeId.parse("ns=0;i=308");

    public static final ExpandedNodeId BINARY_ENCODING_ID = ExpandedNodeId.parse("i=310");

    public static final ExpandedNodeId XML_ENCODING_ID = ExpandedNodeId.parse("i=309");

    public static final ExpandedNodeId JSON_ENCODING_ID = ExpandedNodeId.parse("i=15087");

    private final @Nullable String applicationUri;

    private final @Nullable String productUri;

    private final LocalizedText applicationName;

    private final ApplicationType applicationType;

    private final @Nullable String gatewayServerUri;

    private final @Nullable String discoveryProfileUri;

    private final String @Nullable [] discoveryUrls;

    public ApplicationDescription(@Nullable String applicationUri, @Nullable String productUri,
                                  LocalizedText applicationName, ApplicationType applicationType,
                                  @Nullable String gatewayServerUri, @Nullable String discoveryProfileUri,
                                  String @Nullable [] discoveryUrls) {
        this.applicationUri = applicationUri;
        this.productUri = productUri;
        this.applicationName = applicationName;
        this.applicationType = applicationType;
        this.gatewayServerUri = gatewayServerUri;
        this.discoveryProfileUri = discoveryProfileUri;
        this.discoveryUrls = discoveryUrls;
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

    public @Nullable String getApplicationUri() {
        return applicationUri;
    }

    public @Nullable String getProductUri() {
        return productUri;
    }

    public LocalizedText getApplicationName() {
        return applicationName;
    }

    public ApplicationType getApplicationType() {
        return applicationType;
    }

    public @Nullable String getGatewayServerUri() {
        return gatewayServerUri;
    }

    public @Nullable String getDiscoveryProfileUri() {
        return discoveryProfileUri;
    }

    public String @Nullable [] getDiscoveryUrls() {
        return discoveryUrls;
    }

    @Override
    public String toString() {
        var joiner = new StringJoiner(", ", ApplicationDescription.class.getSimpleName() + "[", "]");
        joiner.add("applicationUri='" + getApplicationUri() + "'");
        joiner.add("productUri='" + getProductUri() + "'");
        joiner.add("applicationName=" + getApplicationName());
        joiner.add("applicationType=" + getApplicationType());
        joiner.add("gatewayServerUri='" + getGatewayServerUri() + "'");
        joiner.add("discoveryProfileUri='" + getDiscoveryProfileUri() + "'");
        joiner.add("discoveryUrls=" + java.util.Arrays.toString(getDiscoveryUrls()));
        return joiner.toString();
    }

    public static StructureDefinition definition(NamespaceTable namespaceTable) {
        return new StructureDefinition(
            new NodeId(0, 310),
            new NodeId(0, 22),
            StructureType.Structure,
            new StructureField[]{
                new StructureField("ApplicationUri", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("ProductUri", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("ApplicationName", LocalizedText.NULL_VALUE, new NodeId(0, 21), -1, null, UInteger.valueOf(0), false),
                new StructureField("ApplicationType", LocalizedText.NULL_VALUE, new NodeId(0, 307), -1, null, UInteger.valueOf(0), false),
                new StructureField("GatewayServerUri", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("DiscoveryProfileUri", LocalizedText.NULL_VALUE, new NodeId(0, 12), -1, null, UInteger.valueOf(0), false),
                new StructureField("DiscoveryUrls", LocalizedText.NULL_VALUE, new NodeId(0, 12), 1, null, UInteger.valueOf(0), false)
            }
        );
    }

    public static final class Codec extends GenericDataTypeCodec<ApplicationDescription> {
        @Override
        public Class<ApplicationDescription> getType() {
            return ApplicationDescription.class;
        }

        @Override
        public ApplicationDescription decodeType(EncodingContext context, UaDecoder decoder) {
            String applicationUri = decoder.decodeString("ApplicationUri");
            String productUri = decoder.decodeString("ProductUri");
            LocalizedText applicationName = decoder.decodeLocalizedText("ApplicationName");
            ApplicationType applicationType = ApplicationType.from(decoder.decodeEnum("ApplicationType"));
            String gatewayServerUri = decoder.decodeString("GatewayServerUri");
            String discoveryProfileUri = decoder.decodeString("DiscoveryProfileUri");
            String[] discoveryUrls = decoder.decodeStringArray("DiscoveryUrls");
            return new ApplicationDescription(applicationUri, productUri, applicationName, applicationType, gatewayServerUri, discoveryProfileUri, discoveryUrls);
        }

        @Override
        public void encodeType(EncodingContext context, UaEncoder encoder,
                               ApplicationDescription value) {
            encoder.encodeString("ApplicationUri", value.getApplicationUri());
            encoder.encodeString("ProductUri", value.getProductUri());
            encoder.encodeLocalizedText("ApplicationName", value.getApplicationName());
            encoder.encodeEnum("ApplicationType", value.getApplicationType());
            encoder.encodeString("GatewayServerUri", value.getGatewayServerUri());
            encoder.encodeString("DiscoveryProfileUri", value.getDiscoveryProfileUri());
            encoder.encodeStringArray("DiscoveryUrls", value.getDiscoveryUrls());
        }
    }
}
