package cl.fapp.docs;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.xml.NoNamespaceWriter;
import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.DTE;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DTERoot extends SIIAbstractFactory<DTE> {

	@Override
	public String toXml(DTE data, String urlSchemaLocation) throws UnsupportedEncodingException {

		try {
			// crea una instancia jaxb del objeto DD
			JAXBContext contextDD = JAXBContext.newInstance(DTE.class);
			Marshaller marshallerDD = contextDD.createMarshaller();
			marshallerDD.setProperty(Marshaller.JAXB_ENCODING, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);
			marshallerDD.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			marshallerDD.setProperty(Marshaller.JAXB_FRAGMENT, true);
			marshallerDD.setSchema(null);

			// -----------------------------------------------
			// crea un writer para acumular el xml resultante
			StringWriter swxmlDTE = new StringWriter();

			// el esquema de DTE incluye declaracion de namespace, pero este no es aceptado por SII cuando se obtiene el TED
			// por lo que deben eliminarse las declaraciones de namespace, para ello se implementa un XMLWriter que descarta 
			// la escritura de namespaces del xml resultante
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			XMLStreamWriter xmlStreamWriter = outputFactory.createXMLStreamWriter(swxmlDTE);

			NoNamespaceWriter mywriter = new NoNamespaceWriter(xmlStreamWriter);
			marshallerDD.marshal(data, mywriter);
			mywriter.flush();
			xmlStreamWriter.flush();
			
			StringWriter stringWriter = new StringWriter();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING,SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");
			
			transformer.transform(new StreamSource(new StringReader(swxmlDTE.toString())), new StreamResult(stringWriter));

			// convierte el stream a string
			//String xmlContent = swxmlDTE.toString();
			String xmlContent = stringWriter.toString();

			return xmlContent;

		} catch (Exception ex) {
			log.error("No fue posible realizar marshall del objeto DTERoot. Error=" + ex.getMessage());
			return null;
		}
	}

}
