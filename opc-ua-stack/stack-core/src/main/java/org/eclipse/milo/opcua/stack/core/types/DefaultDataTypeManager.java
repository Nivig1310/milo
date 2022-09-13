package org.eclipse.milo.opcua.stack.core.types;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.serialization.codecs.DataTypeCodec;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.jetbrains.annotations.Nullable;

public class DefaultDataTypeManager implements DataTypeManager {

    /**
     * QualifiedName of the OPC UA Binary encoding.
     */
    private static final QualifiedName BINARY_ENCODING_NAME =
        new QualifiedName(0, "Default Binary");

    /**
     * QualifiedName of the OPC UA XML encoding.
     */
    private static final QualifiedName XML_ENCODING_NAME =
        new QualifiedName(0, "Default XML");

    /**
     * QualifiedName of the OPC UA JSON encoding.
     */
    private static final QualifiedName JSON_ENCODING_NAME =
        new QualifiedName(0, "Default JSON");

    /**
     * K = NodeId of DataType Encoding
     * V = DataTypeCodec
     */
    private final Map<NodeId, DataTypeCodec> codecsByEncodingId = new ConcurrentHashMap<>();

    /**
     * R = QualifiedName of DataType Encoding
     * C = NodeId of DataType
     * V = DataTypeCodec
     */
    private final Map<QualifiedName, Map<NodeId, DataTypeCodec>> codecsByEncodingName =
        new ConcurrentHashMap<>();

    /**
     * R = QualifiedName of DataType Encoding
     * C = NodeId of DataType
     * V = NodeId of DataType Encoding
     */
    private final Map<QualifiedName, Map<NodeId, NodeId>> encodingIdsByEncodingName =
        new ConcurrentHashMap<>();

    @Override
    public void registerType(
        NodeId dataTypeId,
        DataTypeCodec codec,
        @Nullable NodeId binaryEncodingId,
        @Nullable NodeId xmlEncodingId,
        @Nullable NodeId jsonEncodingId
    ) {

        if (binaryEncodingId != null && binaryEncodingId.isNotNull()) {
            putCodecForEncoding(BINARY_ENCODING_NAME, dataTypeId, codec);
            putEncodingIdForEncoding(BINARY_ENCODING_NAME, dataTypeId, binaryEncodingId);
            codecsByEncodingId.put(binaryEncodingId, codec);
        }
        if (xmlEncodingId != null && xmlEncodingId.isNotNull()) {
            putCodecForEncoding(XML_ENCODING_NAME, dataTypeId, codec);
            putEncodingIdForEncoding(XML_ENCODING_NAME, dataTypeId, xmlEncodingId);
            codecsByEncodingId.put(xmlEncodingId, codec);
        }
        if (jsonEncodingId != null && jsonEncodingId.isNotNull()) {
            putCodecForEncoding(JSON_ENCODING_NAME, dataTypeId, codec);
            putEncodingIdForEncoding(JSON_ENCODING_NAME, dataTypeId, jsonEncodingId);
            codecsByEncodingId.put(jsonEncodingId, codec);
        }
    }

    @Override
    public @Nullable DataTypeCodec getCodec(NodeId encodingId) {
        return codecsByEncodingId.get(encodingId);
    }

    @Override
    public @Nullable DataTypeCodec getCodec(QualifiedName encodingName, NodeId dataTypeId) {
        Map<NodeId, DataTypeCodec> byDataTypeId = codecsByEncodingName.get(encodingName);

        return byDataTypeId != null ? byDataTypeId.get(dataTypeId) : null;
    }

    @Override
    public @Nullable NodeId getBinaryEncodingId(NodeId dataTypeId) {
        Map<NodeId, NodeId> byDataTypeId = encodingIdsByEncodingName.get(BINARY_ENCODING_NAME);

        return byDataTypeId != null ? byDataTypeId.get(dataTypeId) : null;
    }

    @Override
    public @Nullable NodeId getXmlEncodingId(NodeId dataTypeId) {
        Map<NodeId, NodeId> byDataTypeId = encodingIdsByEncodingName.get(XML_ENCODING_NAME);

        return byDataTypeId != null ? byDataTypeId.get(dataTypeId) : null;
    }

    @Override
    public @Nullable NodeId getJsonEncodingId(NodeId dataTypeId) {
        Map<NodeId, NodeId> byDataTypeId = encodingIdsByEncodingName.get(JSON_ENCODING_NAME);

        return byDataTypeId != null ? byDataTypeId.get(dataTypeId) : null;
    }

//    @Override
//    public void registerBinaryTypeDictionary(OpcUaBinaryDataTypeDictionary dataTypeDictionary) {
//        binaryDictionariesByNamespaceUri.put(dataTypeDictionary.getNamespaceUri(), dataTypeDictionary);
//
//        dataTypeDictionary.getEnumCodecInfos().forEach(
//            info ->
//                registerEnumType(info.dataTypeId, info.codec)
//        );
//
//        dataTypeDictionary.getStructCodecInfos().forEach(
//            info ->
//                registerType(info.dataTypeId, info.codec, info.encodingId, null, null)
//        );
//    }

    private void putCodecForEncoding(QualifiedName encodingName, NodeId dataTypeId, DataTypeCodec codec) {
        Map<NodeId, DataTypeCodec> byDataTypeId = codecsByEncodingName.computeIfAbsent(
            encodingName,
            k -> new ConcurrentHashMap<>()
        );
        byDataTypeId.put(dataTypeId, codec);
    }

    private void putEncodingIdForEncoding(QualifiedName encodingName, NodeId dataTypeId, NodeId encodingId) {
        Map<NodeId, NodeId> byDataTypeId = encodingIdsByEncodingName.computeIfAbsent(
            encodingName,
            k -> new ConcurrentHashMap<>()
        );
        byDataTypeId.put(dataTypeId, encodingId);
    }

    /**
     * Create a {@link DefaultDataTypeManager} and initialize it with the built-in DataTypes.
     *
     * @param namespaceTable a {@link NamespaceTable}.
     * @return a {@link DataTypeManager} pre-initialized wth the built-in DataTypes.
     */
    public static DataTypeManager createAndInitialize(NamespaceTable namespaceTable) {
        DefaultDataTypeManager dataTypeManager = new DefaultDataTypeManager();

        new DataTypeInitializer().initialize(namespaceTable, dataTypeManager);

        return dataTypeManager;
    }

}
