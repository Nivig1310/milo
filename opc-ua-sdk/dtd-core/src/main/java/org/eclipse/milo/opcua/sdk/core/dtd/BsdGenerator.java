package org.eclipse.milo.opcua.sdk.core.dtd;

import java.io.OutputStream;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;
import org.eclipse.milo.opcua.stack.core.util.Namespaces;
import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;
import org.opcfoundation.opcua.binaryschema.ObjectFactory;
import org.opcfoundation.opcua.binaryschema.TypeDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BsdGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BsdGenerator.class);

    private BsdGenerator() {}

    public static void generate(TypeDictionary typeDictionary, OutputStream outputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try {
            marshaller.setProperty(
                "com.sun.xml.bind.namespacePrefixMapper",
                new OpcUaNamespacePrefixMapper()
            );
        } catch (PropertyException e) {
            LOGGER.debug("NamespacePrefixMapper not supported", e);
        }

        marshaller.marshal(typeDictionary, outputStream);
    }

    private static class OpcUaNamespacePrefixMapper extends NamespacePrefixMapper {
        @Override
        public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
            if (Namespaces.OPC_UA_BSD.equals(namespaceUri)) {
                return "opc";
            } else if (Namespaces.OPC_UA.equals(namespaceUri)) {
                return "ua";
            } else {
                return null;
            }
        }
    }

}
