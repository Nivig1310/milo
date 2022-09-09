package org.eclipse.milo.opcua.stack.core.types;

import org.eclipse.milo.opcua.stack.core.NamespaceTable;
import org.eclipse.milo.opcua.stack.core.types.structured.*;

public class DataTypeInitializer {
    public void initialize(NamespaceTable namespaceTable, DataTypeManager dataTypeManager) {
        try {
            registerStructCodecs(namespaceTable, dataTypeManager);
        } catch (Exception e) {
            throw new RuntimeException("DataType initialization failed", e);
        }
    }

    private void registerStructCodecs(NamespaceTable namespaceTable, DataTypeManager dataTypeManager)
        throws Exception {
        dataTypeManager.registerCodec(
            KeyValuePair.TYPE_ID.toNodeIdOrThrow(namespaceTable), new KeyValuePair.Codec(),
            KeyValuePair.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            KeyValuePair.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            KeyValuePair.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AdditionalParametersType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AdditionalParametersType.Codec(),
            AdditionalParametersType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AdditionalParametersType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AdditionalParametersType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EphemeralKeyType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EphemeralKeyType.Codec(),
            EphemeralKeyType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EphemeralKeyType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EphemeralKeyType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EndpointType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EndpointType.Codec(),
            EndpointType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RationalNumber.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RationalNumber.Codec(),
            RationalNumber.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RationalNumber.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RationalNumber.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ThreeDVector.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ThreeDVector.Codec(),
            ThreeDVector.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDVector.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDVector.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ThreeDCartesianCoordinates.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ThreeDCartesianCoordinates.Codec(),
            ThreeDCartesianCoordinates.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDCartesianCoordinates.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDCartesianCoordinates.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ThreeDOrientation.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ThreeDOrientation.Codec(),
            ThreeDOrientation.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDOrientation.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDOrientation.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ThreeDFrame.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ThreeDFrame.Codec(),
            ThreeDFrame.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDFrame.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ThreeDFrame.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CurrencyUnitType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CurrencyUnitType.Codec(),
            CurrencyUnitType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CurrencyUnitType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CurrencyUnitType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TrustListDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TrustListDataType.Codec(),
            TrustListDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TrustListDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TrustListDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UABinaryFileDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UABinaryFileDataType.Codec(),
            UABinaryFileDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UABinaryFileDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UABinaryFileDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataSetMetaDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataSetMetaDataType.Codec(),
            DataSetMetaDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataSetMetaDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataSetMetaDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StructureDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StructureDescription.Codec(),
            StructureDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StructureDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StructureDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EnumDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EnumDescription.Codec(),
            EnumDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SimpleTypeDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SimpleTypeDescription.Codec(),
            SimpleTypeDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SimpleTypeDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SimpleTypeDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PortableQualifiedName.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PortableQualifiedName.Codec(),
            PortableQualifiedName.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PortableQualifiedName.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PortableQualifiedName.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PortableNodeId.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PortableNodeId.Codec(),
            PortableNodeId.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PortableNodeId.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PortableNodeId.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UnsignedRationalNumber.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UnsignedRationalNumber.Codec(),
            UnsignedRationalNumber.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UnsignedRationalNumber.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UnsignedRationalNumber.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FieldMetaData.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FieldMetaData.Codec(),
            FieldMetaData.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FieldMetaData.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FieldMetaData.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ConfigurationVersionDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ConfigurationVersionDataType.Codec(),
            ConfigurationVersionDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ConfigurationVersionDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ConfigurationVersionDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishedDataSetDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishedDataSetDataType.Codec(),
            PublishedDataSetDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedDataSetDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedDataSetDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishedDataItemsDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishedDataItemsDataType.Codec(),
            PublishedDataItemsDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedDataItemsDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedDataItemsDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishedEventsDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishedEventsDataType.Codec(),
            PublishedEventsDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedEventsDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedEventsDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishedDataSetCustomSourceDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishedDataSetCustomSourceDataType.Codec(),
            PublishedDataSetCustomSourceDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedDataSetCustomSourceDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedDataSetCustomSourceDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishedVariableDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishedVariableDataType.Codec(),
            PublishedVariableDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedVariableDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishedVariableDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataSetWriterDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataSetWriterDataType.Codec(),
            DataSetWriterDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataSetWriterDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataSetWriterDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrokerDataSetWriterTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrokerDataSetWriterTransportDataType.Codec(),
            BrokerDataSetWriterTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerDataSetWriterTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerDataSetWriterTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UadpDataSetWriterMessageDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UadpDataSetWriterMessageDataType.Codec(),
            UadpDataSetWriterMessageDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UadpDataSetWriterMessageDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UadpDataSetWriterMessageDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            JsonDataSetWriterMessageDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new JsonDataSetWriterMessageDataType.Codec(),
            JsonDataSetWriterMessageDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            JsonDataSetWriterMessageDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            JsonDataSetWriterMessageDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            WriterGroupDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new WriterGroupDataType.Codec(),
            WriterGroupDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriterGroupDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriterGroupDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReaderGroupDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReaderGroupDataType.Codec(),
            ReaderGroupDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReaderGroupDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReaderGroupDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DatagramWriterGroupTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DatagramWriterGroupTransportDataType.Codec(),
            DatagramWriterGroupTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramWriterGroupTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramWriterGroupTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DatagramWriterGroupTransport2DataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DatagramWriterGroupTransport2DataType.Codec(),
            DatagramWriterGroupTransport2DataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramWriterGroupTransport2DataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramWriterGroupTransport2DataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrokerWriterGroupTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrokerWriterGroupTransportDataType.Codec(),
            BrokerWriterGroupTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerWriterGroupTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerWriterGroupTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UadpWriterGroupMessageDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UadpWriterGroupMessageDataType.Codec(),
            UadpWriterGroupMessageDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UadpWriterGroupMessageDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UadpWriterGroupMessageDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            JsonWriterGroupMessageDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new JsonWriterGroupMessageDataType.Codec(),
            JsonWriterGroupMessageDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            JsonWriterGroupMessageDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            JsonWriterGroupMessageDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PubSubConnectionDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PubSubConnectionDataType.Codec(),
            PubSubConnectionDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConnectionDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConnectionDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DatagramConnectionTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DatagramConnectionTransportDataType.Codec(),
            DatagramConnectionTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramConnectionTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramConnectionTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DatagramConnectionTransport2DataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DatagramConnectionTransport2DataType.Codec(),
            DatagramConnectionTransport2DataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramConnectionTransport2DataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramConnectionTransport2DataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrokerConnectionTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrokerConnectionTransportDataType.Codec(),
            BrokerConnectionTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerConnectionTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerConnectionTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NetworkAddressUrlDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NetworkAddressUrlDataType.Codec(),
            NetworkAddressUrlDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NetworkAddressUrlDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NetworkAddressUrlDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataSetReaderDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataSetReaderDataType.Codec(),
            DataSetReaderDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataSetReaderDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataSetReaderDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DatagramDataSetReaderTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DatagramDataSetReaderTransportDataType.Codec(),
            DatagramDataSetReaderTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramDataSetReaderTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DatagramDataSetReaderTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrokerDataSetReaderTransportDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrokerDataSetReaderTransportDataType.Codec(),
            BrokerDataSetReaderTransportDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerDataSetReaderTransportDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrokerDataSetReaderTransportDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UadpDataSetReaderMessageDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UadpDataSetReaderMessageDataType.Codec(),
            UadpDataSetReaderMessageDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UadpDataSetReaderMessageDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UadpDataSetReaderMessageDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            JsonDataSetReaderMessageDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new JsonDataSetReaderMessageDataType.Codec(),
            JsonDataSetReaderMessageDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            JsonDataSetReaderMessageDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            JsonDataSetReaderMessageDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TargetVariablesDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TargetVariablesDataType.Codec(),
            TargetVariablesDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TargetVariablesDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TargetVariablesDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SubscribedDataSetMirrorDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SubscribedDataSetMirrorDataType.Codec(),
            SubscribedDataSetMirrorDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SubscribedDataSetMirrorDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SubscribedDataSetMirrorDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StandaloneSubscribedDataSetRefDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StandaloneSubscribedDataSetRefDataType.Codec(),
            StandaloneSubscribedDataSetRefDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StandaloneSubscribedDataSetRefDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StandaloneSubscribedDataSetRefDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StandaloneSubscribedDataSetDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StandaloneSubscribedDataSetDataType.Codec(),
            StandaloneSubscribedDataSetDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StandaloneSubscribedDataSetDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StandaloneSubscribedDataSetDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FieldTargetDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FieldTargetDataType.Codec(),
            FieldTargetDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FieldTargetDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FieldTargetDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PubSubConfigurationDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PubSubConfigurationDataType.Codec(),
            PubSubConfigurationDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfigurationDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfigurationDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PubSubConfiguration2DataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PubSubConfiguration2DataType.Codec(),
            PubSubConfiguration2DataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfiguration2DataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfiguration2DataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SecurityGroupDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SecurityGroupDataType.Codec(),
            SecurityGroupDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SecurityGroupDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SecurityGroupDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PubSubKeyPushTargetDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PubSubKeyPushTargetDataType.Codec(),
            PubSubKeyPushTargetDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubKeyPushTargetDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubKeyPushTargetDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TransmitQosPriorityDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TransmitQosPriorityDataType.Codec(),
            TransmitQosPriorityDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransmitQosPriorityDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransmitQosPriorityDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReceiveQosPriorityDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReceiveQosPriorityDataType.Codec(),
            ReceiveQosPriorityDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReceiveQosPriorityDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReceiveQosPriorityDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PubSubConfigurationRefDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PubSubConfigurationRefDataType.Codec(),
            PubSubConfigurationRefDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfigurationRefDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfigurationRefDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PubSubConfigurationValueDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PubSubConfigurationValueDataType.Codec(),
            PubSubConfigurationValueDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfigurationValueDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PubSubConfigurationValueDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AliasNameDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AliasNameDataType.Codec(),
            AliasNameDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AliasNameDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AliasNameDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UserManagementDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UserManagementDataType.Codec(),
            UserManagementDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UserManagementDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UserManagementDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PriorityMappingEntryType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PriorityMappingEntryType.Codec(),
            PriorityMappingEntryType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PriorityMappingEntryType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PriorityMappingEntryType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RolePermissionType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RolePermissionType.Codec(),
            RolePermissionType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RolePermissionType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RolePermissionType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StructureDefinition.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StructureDefinition.Codec(),
            StructureDefinition.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StructureDefinition.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StructureDefinition.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EnumDefinition.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EnumDefinition.Codec(),
            EnumDefinition.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumDefinition.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumDefinition.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StructureField.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StructureField.Codec(),
            StructureField.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StructureField.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StructureField.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            Argument.TYPE_ID.toNodeIdOrThrow(namespaceTable), new Argument.Codec(),
            Argument.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Argument.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Argument.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EnumValueType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EnumValueType.Codec(),
            EnumValueType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumValueType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumValueType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EnumField.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EnumField.Codec(),
            EnumField.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumField.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EnumField.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TimeZoneDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TimeZoneDataType.Codec(),
            TimeZoneDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TimeZoneDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TimeZoneDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ApplicationDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ApplicationDescription.Codec(),
            ApplicationDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ApplicationDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ApplicationDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ServerOnNetwork.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ServerOnNetwork.Codec(),
            ServerOnNetwork.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServerOnNetwork.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServerOnNetwork.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UserTokenPolicy.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UserTokenPolicy.Codec(),
            UserTokenPolicy.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UserTokenPolicy.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UserTokenPolicy.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EndpointDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EndpointDescription.Codec(),
            EndpointDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisteredServer.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisteredServer.Codec(),
            RegisteredServer.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisteredServer.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisteredServer.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DiscoveryConfiguration.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DiscoveryConfiguration.Codec(),
            DiscoveryConfiguration.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DiscoveryConfiguration.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DiscoveryConfiguration.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MdnsDiscoveryConfiguration.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MdnsDiscoveryConfiguration.Codec(),
            MdnsDiscoveryConfiguration.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MdnsDiscoveryConfiguration.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MdnsDiscoveryConfiguration.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SignedSoftwareCertificate.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SignedSoftwareCertificate.Codec(),
            SignedSoftwareCertificate.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SignedSoftwareCertificate.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SignedSoftwareCertificate.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AnonymousIdentityToken.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AnonymousIdentityToken.Codec(),
            AnonymousIdentityToken.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AnonymousIdentityToken.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AnonymousIdentityToken.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UserNameIdentityToken.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UserNameIdentityToken.Codec(),
            UserNameIdentityToken.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UserNameIdentityToken.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UserNameIdentityToken.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            X509IdentityToken.TYPE_ID.toNodeIdOrThrow(namespaceTable), new X509IdentityToken.Codec(),
            X509IdentityToken.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            X509IdentityToken.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            X509IdentityToken.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            IssuedIdentityToken.TYPE_ID.toNodeIdOrThrow(namespaceTable), new IssuedIdentityToken.Codec(),
            IssuedIdentityToken.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            IssuedIdentityToken.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            IssuedIdentityToken.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddNodesItem.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddNodesItem.Codec(),
            AddNodesItem.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesItem.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesItem.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddReferencesItem.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddReferencesItem.Codec(),
            AddReferencesItem.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddReferencesItem.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddReferencesItem.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteNodesItem.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteNodesItem.Codec(),
            DeleteNodesItem.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteNodesItem.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteNodesItem.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteReferencesItem.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteReferencesItem.Codec(),
            DeleteReferencesItem.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteReferencesItem.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteReferencesItem.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RelativePathElement.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RelativePathElement.Codec(),
            RelativePathElement.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RelativePathElement.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RelativePathElement.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RelativePath.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RelativePath.Codec(),
            RelativePath.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RelativePath.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RelativePath.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EndpointConfiguration.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EndpointConfiguration.Codec(),
            EndpointConfiguration.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointConfiguration.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointConfiguration.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ContentFilterElement.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ContentFilterElement.Codec(),
            ContentFilterElement.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilterElement.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilterElement.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ContentFilter.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ContentFilter.Codec(),
            ContentFilter.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilter.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilter.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FilterOperand.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FilterOperand.Codec(),
            FilterOperand.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FilterOperand.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FilterOperand.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ElementOperand.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ElementOperand.Codec(),
            ElementOperand.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ElementOperand.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ElementOperand.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            LiteralOperand.TYPE_ID.toNodeIdOrThrow(namespaceTable), new LiteralOperand.Codec(),
            LiteralOperand.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            LiteralOperand.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            LiteralOperand.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AttributeOperand.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AttributeOperand.Codec(),
            AttributeOperand.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AttributeOperand.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AttributeOperand.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SimpleAttributeOperand.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SimpleAttributeOperand.Codec(),
            SimpleAttributeOperand.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SimpleAttributeOperand.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SimpleAttributeOperand.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryEvent.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryEvent.Codec(),
            HistoryEvent.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryEvent.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryEvent.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoringFilter.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoringFilter.Codec(),
            MonitoringFilter.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoringFilter.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoringFilter.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EventFilter.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EventFilter.Codec(),
            EventFilter.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventFilter.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventFilter.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataChangeFilter.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataChangeFilter.Codec(),
            DataChangeFilter.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataChangeFilter.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataChangeFilter.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AggregateFilter.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AggregateFilter.Codec(),
            AggregateFilter.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AggregateFilter.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AggregateFilter.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AggregateConfiguration.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AggregateConfiguration.Codec(),
            AggregateConfiguration.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AggregateConfiguration.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AggregateConfiguration.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryEventFieldList.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryEventFieldList.Codec(),
            HistoryEventFieldList.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryEventFieldList.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryEventFieldList.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BuildInfo.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BuildInfo.Codec(),
            BuildInfo.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BuildInfo.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BuildInfo.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RedundantServerDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RedundantServerDataType.Codec(),
            RedundantServerDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RedundantServerDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RedundantServerDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EndpointUrlListDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EndpointUrlListDataType.Codec(),
            EndpointUrlListDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointUrlListDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EndpointUrlListDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NetworkGroupDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NetworkGroupDataType.Codec(),
            NetworkGroupDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NetworkGroupDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NetworkGroupDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SamplingIntervalDiagnosticsDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SamplingIntervalDiagnosticsDataType.Codec(),
            SamplingIntervalDiagnosticsDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SamplingIntervalDiagnosticsDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SamplingIntervalDiagnosticsDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ServerDiagnosticsSummaryDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ServerDiagnosticsSummaryDataType.Codec(),
            ServerDiagnosticsSummaryDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServerDiagnosticsSummaryDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServerDiagnosticsSummaryDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ServerStatusDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ServerStatusDataType.Codec(),
            ServerStatusDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServerStatusDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServerStatusDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SessionDiagnosticsDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SessionDiagnosticsDataType.Codec(),
            SessionDiagnosticsDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionDiagnosticsDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionDiagnosticsDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SessionSecurityDiagnosticsDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SessionSecurityDiagnosticsDataType.Codec(),
            SessionSecurityDiagnosticsDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionSecurityDiagnosticsDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionSecurityDiagnosticsDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ServiceCounterDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ServiceCounterDataType.Codec(),
            ServiceCounterDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServiceCounterDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServiceCounterDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StatusResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StatusResult.Codec(),
            StatusResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StatusResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StatusResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SubscriptionDiagnosticsDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SubscriptionDiagnosticsDataType.Codec(),
            SubscriptionDiagnosticsDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SubscriptionDiagnosticsDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SubscriptionDiagnosticsDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ModelChangeStructureDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ModelChangeStructureDataType.Codec(),
            ModelChangeStructureDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModelChangeStructureDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModelChangeStructureDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SemanticChangeStructureDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SemanticChangeStructureDataType.Codec(),
            SemanticChangeStructureDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SemanticChangeStructureDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SemanticChangeStructureDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            Range.TYPE_ID.toNodeIdOrThrow(namespaceTable), new Range.Codec(),
            Range.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Range.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Range.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EUInformation.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EUInformation.Codec(),
            EUInformation.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EUInformation.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EUInformation.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ComplexNumberType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ComplexNumberType.Codec(),
            ComplexNumberType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ComplexNumberType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ComplexNumberType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DoubleComplexNumberType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DoubleComplexNumberType.Codec(),
            DoubleComplexNumberType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DoubleComplexNumberType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DoubleComplexNumberType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AxisInformation.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AxisInformation.Codec(),
            AxisInformation.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AxisInformation.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AxisInformation.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            XVType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new XVType.Codec(),
            XVType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            XVType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            XVType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ProgramDiagnosticDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ProgramDiagnosticDataType.Codec(),
            ProgramDiagnosticDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ProgramDiagnosticDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ProgramDiagnosticDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ProgramDiagnostic2DataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ProgramDiagnostic2DataType.Codec(),
            ProgramDiagnostic2DataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ProgramDiagnostic2DataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ProgramDiagnostic2DataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            Annotation.TYPE_ID.toNodeIdOrThrow(namespaceTable), new Annotation.Codec(),
            Annotation.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Annotation.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Annotation.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DecimalDataType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DecimalDataType.Codec(),
            DecimalDataType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DecimalDataType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DecimalDataType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            Node.TYPE_ID.toNodeIdOrThrow(namespaceTable), new Node.Codec(),
            Node.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Node.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            Node.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            InstanceNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new InstanceNode.Codec(),
            InstanceNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            InstanceNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            InstanceNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ObjectNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ObjectNode.Codec(),
            ObjectNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            VariableNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new VariableNode.Codec(),
            VariableNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MethodNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MethodNode.Codec(),
            MethodNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MethodNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MethodNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ViewNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ViewNode.Codec(),
            ViewNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ViewNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ViewNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TypeNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TypeNode.Codec(),
            TypeNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TypeNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TypeNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ObjectTypeNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ObjectTypeNode.Codec(),
            ObjectTypeNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectTypeNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectTypeNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            VariableTypeNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new VariableTypeNode.Codec(),
            VariableTypeNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableTypeNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableTypeNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReferenceTypeNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReferenceTypeNode.Codec(),
            ReferenceTypeNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceTypeNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceTypeNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataTypeNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataTypeNode.Codec(),
            DataTypeNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataTypeNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataTypeNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReferenceNode.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReferenceNode.Codec(),
            ReferenceNode.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceNode.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceNode.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RequestHeader.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RequestHeader.Codec(),
            RequestHeader.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RequestHeader.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RequestHeader.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ResponseHeader.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ResponseHeader.Codec(),
            ResponseHeader.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ResponseHeader.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ResponseHeader.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ServiceFault.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ServiceFault.Codec(),
            ServiceFault.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServiceFault.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ServiceFault.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SessionlessInvokeRequestType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SessionlessInvokeRequestType.Codec(),
            SessionlessInvokeRequestType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionlessInvokeRequestType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionlessInvokeRequestType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SessionlessInvokeResponseType.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SessionlessInvokeResponseType.Codec(),
            SessionlessInvokeResponseType.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionlessInvokeResponseType.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SessionlessInvokeResponseType.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FindServersRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FindServersRequest.Codec(),
            FindServersRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FindServersResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FindServersResponse.Codec(),
            FindServersResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FindServersOnNetworkRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FindServersOnNetworkRequest.Codec(),
            FindServersOnNetworkRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersOnNetworkRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersOnNetworkRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            FindServersOnNetworkResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new FindServersOnNetworkResponse.Codec(),
            FindServersOnNetworkResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersOnNetworkResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            FindServersOnNetworkResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            GetEndpointsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new GetEndpointsRequest.Codec(),
            GetEndpointsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GetEndpointsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GetEndpointsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            GetEndpointsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new GetEndpointsResponse.Codec(),
            GetEndpointsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GetEndpointsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GetEndpointsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisterServerRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisterServerRequest.Codec(),
            RegisterServerRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServerRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServerRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisterServerResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisterServerResponse.Codec(),
            RegisterServerResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServerResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServerResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisterServer2Request.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisterServer2Request.Codec(),
            RegisterServer2Request.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServer2Request.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServer2Request.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisterServer2Response.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisterServer2Response.Codec(),
            RegisterServer2Response.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServer2Response.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterServer2Response.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ChannelSecurityToken.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ChannelSecurityToken.Codec(),
            ChannelSecurityToken.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ChannelSecurityToken.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ChannelSecurityToken.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            OpenSecureChannelRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new OpenSecureChannelRequest.Codec(),
            OpenSecureChannelRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            OpenSecureChannelRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            OpenSecureChannelRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            OpenSecureChannelResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new OpenSecureChannelResponse.Codec(),
            OpenSecureChannelResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            OpenSecureChannelResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            OpenSecureChannelResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CloseSecureChannelRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CloseSecureChannelRequest.Codec(),
            CloseSecureChannelRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSecureChannelRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSecureChannelRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CloseSecureChannelResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CloseSecureChannelResponse.Codec(),
            CloseSecureChannelResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSecureChannelResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSecureChannelResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SignatureData.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SignatureData.Codec(),
            SignatureData.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SignatureData.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SignatureData.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CreateSessionRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CreateSessionRequest.Codec(),
            CreateSessionRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSessionRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSessionRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CreateSessionResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CreateSessionResponse.Codec(),
            CreateSessionResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSessionResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSessionResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ActivateSessionRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ActivateSessionRequest.Codec(),
            ActivateSessionRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ActivateSessionRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ActivateSessionRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ActivateSessionResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ActivateSessionResponse.Codec(),
            ActivateSessionResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ActivateSessionResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ActivateSessionResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CloseSessionRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CloseSessionRequest.Codec(),
            CloseSessionRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSessionRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSessionRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CloseSessionResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CloseSessionResponse.Codec(),
            CloseSessionResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSessionResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CloseSessionResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CancelRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CancelRequest.Codec(),
            CancelRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CancelRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CancelRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CancelResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CancelResponse.Codec(),
            CancelResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CancelResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CancelResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NodeAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NodeAttributes.Codec(),
            NodeAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NodeAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NodeAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ObjectAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ObjectAttributes.Codec(),
            ObjectAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            VariableAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new VariableAttributes.Codec(),
            VariableAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MethodAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MethodAttributes.Codec(),
            MethodAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MethodAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MethodAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ObjectTypeAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ObjectTypeAttributes.Codec(),
            ObjectTypeAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectTypeAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ObjectTypeAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            VariableTypeAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new VariableTypeAttributes.Codec(),
            VariableTypeAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableTypeAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            VariableTypeAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReferenceTypeAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReferenceTypeAttributes.Codec(),
            ReferenceTypeAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceTypeAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceTypeAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataTypeAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataTypeAttributes.Codec(),
            DataTypeAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataTypeAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataTypeAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ViewAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ViewAttributes.Codec(),
            ViewAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ViewAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ViewAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            GenericAttributes.TYPE_ID.toNodeIdOrThrow(namespaceTable), new GenericAttributes.Codec(),
            GenericAttributes.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GenericAttributes.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GenericAttributes.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            GenericAttributeValue.TYPE_ID.toNodeIdOrThrow(namespaceTable), new GenericAttributeValue.Codec(),
            GenericAttributeValue.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GenericAttributeValue.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            GenericAttributeValue.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddNodesResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddNodesResult.Codec(),
            AddNodesResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddNodesRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddNodesRequest.Codec(),
            AddNodesRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddNodesResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddNodesResponse.Codec(),
            AddNodesResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddNodesResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddReferencesRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddReferencesRequest.Codec(),
            AddReferencesRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddReferencesRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddReferencesRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AddReferencesResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AddReferencesResponse.Codec(),
            AddReferencesResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddReferencesResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AddReferencesResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteNodesRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteNodesRequest.Codec(),
            DeleteNodesRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteNodesRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteNodesRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteNodesResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteNodesResponse.Codec(),
            DeleteNodesResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteNodesResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteNodesResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteReferencesRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteReferencesRequest.Codec(),
            DeleteReferencesRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteReferencesRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteReferencesRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteReferencesResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteReferencesResponse.Codec(),
            DeleteReferencesResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteReferencesResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteReferencesResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ViewDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ViewDescription.Codec(),
            ViewDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ViewDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ViewDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowseDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowseDescription.Codec(),
            BrowseDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReferenceDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReferenceDescription.Codec(),
            ReferenceDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReferenceDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowseResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowseResult.Codec(),
            BrowseResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowseRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowseRequest.Codec(),
            BrowseRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowseResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowseResponse.Codec(),
            BrowseResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowseNextRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowseNextRequest.Codec(),
            BrowseNextRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseNextRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseNextRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowseNextResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowseNextResponse.Codec(),
            BrowseNextResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseNextResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowseNextResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowsePath.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowsePath.Codec(),
            BrowsePath.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowsePath.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowsePath.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowsePathTarget.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowsePathTarget.Codec(),
            BrowsePathTarget.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowsePathTarget.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowsePathTarget.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            BrowsePathResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new BrowsePathResult.Codec(),
            BrowsePathResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowsePathResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            BrowsePathResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TranslateBrowsePathsToNodeIdsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TranslateBrowsePathsToNodeIdsRequest.Codec(),
            TranslateBrowsePathsToNodeIdsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TranslateBrowsePathsToNodeIdsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TranslateBrowsePathsToNodeIdsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TranslateBrowsePathsToNodeIdsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TranslateBrowsePathsToNodeIdsResponse.Codec(),
            TranslateBrowsePathsToNodeIdsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TranslateBrowsePathsToNodeIdsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TranslateBrowsePathsToNodeIdsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisterNodesRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisterNodesRequest.Codec(),
            RegisterNodesRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterNodesRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterNodesRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RegisterNodesResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RegisterNodesResponse.Codec(),
            RegisterNodesResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterNodesResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RegisterNodesResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UnregisterNodesRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UnregisterNodesRequest.Codec(),
            UnregisterNodesRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UnregisterNodesRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UnregisterNodesRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UnregisterNodesResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UnregisterNodesResponse.Codec(),
            UnregisterNodesResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UnregisterNodesResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UnregisterNodesResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            QueryDataDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new QueryDataDescription.Codec(),
            QueryDataDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryDataDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryDataDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NodeTypeDescription.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NodeTypeDescription.Codec(),
            NodeTypeDescription.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NodeTypeDescription.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NodeTypeDescription.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            QueryDataSet.TYPE_ID.toNodeIdOrThrow(namespaceTable), new QueryDataSet.Codec(),
            QueryDataSet.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryDataSet.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryDataSet.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NodeReference.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NodeReference.Codec(),
            NodeReference.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NodeReference.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NodeReference.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ContentFilterElementResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ContentFilterElementResult.Codec(),
            ContentFilterElementResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilterElementResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilterElementResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ContentFilterResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ContentFilterResult.Codec(),
            ContentFilterResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilterResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ContentFilterResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ParsingResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ParsingResult.Codec(),
            ParsingResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ParsingResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ParsingResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            QueryFirstRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new QueryFirstRequest.Codec(),
            QueryFirstRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryFirstRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryFirstRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            QueryFirstResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new QueryFirstResponse.Codec(),
            QueryFirstResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryFirstResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryFirstResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            QueryNextRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new QueryNextRequest.Codec(),
            QueryNextRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryNextRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryNextRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            QueryNextResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new QueryNextResponse.Codec(),
            QueryNextResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryNextResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            QueryNextResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadValueId.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadValueId.Codec(),
            ReadValueId.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadValueId.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadValueId.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadRequest.Codec(),
            ReadRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadResponse.Codec(),
            ReadResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryReadValueId.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryReadValueId.Codec(),
            HistoryReadValueId.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadValueId.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadValueId.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryReadResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryReadResult.Codec(),
            HistoryReadResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryReadDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryReadDetails.Codec(),
            HistoryReadDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadEventDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadEventDetails.Codec(),
            ReadEventDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadEventDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadEventDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadRawModifiedDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadRawModifiedDetails.Codec(),
            ReadRawModifiedDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadRawModifiedDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadRawModifiedDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadProcessedDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadProcessedDetails.Codec(),
            ReadProcessedDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadProcessedDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadProcessedDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadAtTimeDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadAtTimeDetails.Codec(),
            ReadAtTimeDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadAtTimeDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadAtTimeDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ReadAnnotationDataDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ReadAnnotationDataDetails.Codec(),
            ReadAnnotationDataDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadAnnotationDataDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ReadAnnotationDataDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryData.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryData.Codec(),
            HistoryData.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryData.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryData.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryModifiedData.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryModifiedData.Codec(),
            HistoryModifiedData.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryModifiedData.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryModifiedData.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ModificationInfo.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ModificationInfo.Codec(),
            ModificationInfo.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModificationInfo.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModificationInfo.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryReadRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryReadRequest.Codec(),
            HistoryReadRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryReadResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryReadResponse.Codec(),
            HistoryReadResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryReadResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            WriteValue.TYPE_ID.toNodeIdOrThrow(namespaceTable), new WriteValue.Codec(),
            WriteValue.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriteValue.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriteValue.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            WriteRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new WriteRequest.Codec(),
            WriteRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriteRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriteRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            WriteResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new WriteResponse.Codec(),
            WriteResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriteResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            WriteResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryUpdateDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryUpdateDetails.Codec(),
            HistoryUpdateDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UpdateDataDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UpdateDataDetails.Codec(),
            UpdateDataDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UpdateDataDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UpdateDataDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UpdateStructureDataDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UpdateStructureDataDetails.Codec(),
            UpdateStructureDataDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UpdateStructureDataDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UpdateStructureDataDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            UpdateEventDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new UpdateEventDetails.Codec(),
            UpdateEventDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UpdateEventDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            UpdateEventDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteRawModifiedDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteRawModifiedDetails.Codec(),
            DeleteRawModifiedDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteRawModifiedDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteRawModifiedDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteAtTimeDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteAtTimeDetails.Codec(),
            DeleteAtTimeDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteAtTimeDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteAtTimeDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteEventDetails.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteEventDetails.Codec(),
            DeleteEventDetails.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteEventDetails.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteEventDetails.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryUpdateResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryUpdateResult.Codec(),
            HistoryUpdateResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryUpdateRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryUpdateRequest.Codec(),
            HistoryUpdateRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            HistoryUpdateResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new HistoryUpdateResponse.Codec(),
            HistoryUpdateResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            HistoryUpdateResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CallMethodRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CallMethodRequest.Codec(),
            CallMethodRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallMethodRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallMethodRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CallMethodResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CallMethodResult.Codec(),
            CallMethodResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallMethodResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallMethodResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CallRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CallRequest.Codec(),
            CallRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CallResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CallResponse.Codec(),
            CallResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CallResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoringFilterResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoringFilterResult.Codec(),
            MonitoringFilterResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoringFilterResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoringFilterResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EventFilterResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EventFilterResult.Codec(),
            EventFilterResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventFilterResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventFilterResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            AggregateFilterResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new AggregateFilterResult.Codec(),
            AggregateFilterResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AggregateFilterResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            AggregateFilterResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoringParameters.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoringParameters.Codec(),
            MonitoringParameters.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoringParameters.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoringParameters.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoredItemCreateRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoredItemCreateRequest.Codec(),
            MonitoredItemCreateRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemCreateRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemCreateRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoredItemCreateResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoredItemCreateResult.Codec(),
            MonitoredItemCreateResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemCreateResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemCreateResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CreateMonitoredItemsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CreateMonitoredItemsRequest.Codec(),
            CreateMonitoredItemsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateMonitoredItemsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateMonitoredItemsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CreateMonitoredItemsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CreateMonitoredItemsResponse.Codec(),
            CreateMonitoredItemsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateMonitoredItemsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateMonitoredItemsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoredItemModifyRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoredItemModifyRequest.Codec(),
            MonitoredItemModifyRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemModifyRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemModifyRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoredItemModifyResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoredItemModifyResult.Codec(),
            MonitoredItemModifyResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemModifyResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemModifyResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ModifyMonitoredItemsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ModifyMonitoredItemsRequest.Codec(),
            ModifyMonitoredItemsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifyMonitoredItemsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifyMonitoredItemsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ModifyMonitoredItemsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ModifyMonitoredItemsResponse.Codec(),
            ModifyMonitoredItemsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifyMonitoredItemsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifyMonitoredItemsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SetMonitoringModeRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SetMonitoringModeRequest.Codec(),
            SetMonitoringModeRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetMonitoringModeRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetMonitoringModeRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SetMonitoringModeResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SetMonitoringModeResponse.Codec(),
            SetMonitoringModeResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetMonitoringModeResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetMonitoringModeResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SetTriggeringRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SetTriggeringRequest.Codec(),
            SetTriggeringRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetTriggeringRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetTriggeringRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SetTriggeringResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SetTriggeringResponse.Codec(),
            SetTriggeringResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetTriggeringResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetTriggeringResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteMonitoredItemsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteMonitoredItemsRequest.Codec(),
            DeleteMonitoredItemsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteMonitoredItemsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteMonitoredItemsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteMonitoredItemsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteMonitoredItemsResponse.Codec(),
            DeleteMonitoredItemsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteMonitoredItemsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteMonitoredItemsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CreateSubscriptionRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CreateSubscriptionRequest.Codec(),
            CreateSubscriptionRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSubscriptionRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSubscriptionRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            CreateSubscriptionResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new CreateSubscriptionResponse.Codec(),
            CreateSubscriptionResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSubscriptionResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            CreateSubscriptionResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ModifySubscriptionRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ModifySubscriptionRequest.Codec(),
            ModifySubscriptionRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifySubscriptionRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifySubscriptionRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            ModifySubscriptionResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new ModifySubscriptionResponse.Codec(),
            ModifySubscriptionResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifySubscriptionResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            ModifySubscriptionResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SetPublishingModeRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SetPublishingModeRequest.Codec(),
            SetPublishingModeRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetPublishingModeRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetPublishingModeRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SetPublishingModeResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SetPublishingModeResponse.Codec(),
            SetPublishingModeResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetPublishingModeResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SetPublishingModeResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NotificationMessage.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NotificationMessage.Codec(),
            NotificationMessage.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NotificationMessage.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NotificationMessage.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            NotificationData.TYPE_ID.toNodeIdOrThrow(namespaceTable), new NotificationData.Codec(),
            NotificationData.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NotificationData.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            NotificationData.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DataChangeNotification.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DataChangeNotification.Codec(),
            DataChangeNotification.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataChangeNotification.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DataChangeNotification.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EventNotificationList.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EventNotificationList.Codec(),
            EventNotificationList.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventNotificationList.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventNotificationList.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            StatusChangeNotification.TYPE_ID.toNodeIdOrThrow(namespaceTable), new StatusChangeNotification.Codec(),
            StatusChangeNotification.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StatusChangeNotification.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            StatusChangeNotification.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            MonitoredItemNotification.TYPE_ID.toNodeIdOrThrow(namespaceTable), new MonitoredItemNotification.Codec(),
            MonitoredItemNotification.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemNotification.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            MonitoredItemNotification.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            EventFieldList.TYPE_ID.toNodeIdOrThrow(namespaceTable), new EventFieldList.Codec(),
            EventFieldList.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventFieldList.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            EventFieldList.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            SubscriptionAcknowledgement.TYPE_ID.toNodeIdOrThrow(namespaceTable), new SubscriptionAcknowledgement.Codec(),
            SubscriptionAcknowledgement.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SubscriptionAcknowledgement.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            SubscriptionAcknowledgement.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishRequest.Codec(),
            PublishRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            PublishResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new PublishResponse.Codec(),
            PublishResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            PublishResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RepublishRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RepublishRequest.Codec(),
            RepublishRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RepublishRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RepublishRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            RepublishResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new RepublishResponse.Codec(),
            RepublishResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RepublishResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            RepublishResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TransferResult.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TransferResult.Codec(),
            TransferResult.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransferResult.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransferResult.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TransferSubscriptionsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TransferSubscriptionsRequest.Codec(),
            TransferSubscriptionsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransferSubscriptionsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransferSubscriptionsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            TransferSubscriptionsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new TransferSubscriptionsResponse.Codec(),
            TransferSubscriptionsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransferSubscriptionsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            TransferSubscriptionsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteSubscriptionsRequest.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteSubscriptionsRequest.Codec(),
            DeleteSubscriptionsRequest.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteSubscriptionsRequest.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteSubscriptionsRequest.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
        dataTypeManager.registerCodec(
            DeleteSubscriptionsResponse.TYPE_ID.toNodeIdOrThrow(namespaceTable), new DeleteSubscriptionsResponse.Codec(),
            DeleteSubscriptionsResponse.BINARY_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteSubscriptionsResponse.XML_ENCODING_ID.toNodeIdOrThrow(namespaceTable),
            DeleteSubscriptionsResponse.JSON_ENCODING_ID.toNodeIdOrThrow(namespaceTable)
        );
    }
}
