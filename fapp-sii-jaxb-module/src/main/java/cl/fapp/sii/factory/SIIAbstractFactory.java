package cl.fapp.sii.factory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.fapp.sii.signer.common.SignedXml;
import cl.fapp.sii.signer.common.XmlSigner;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

public abstract class SIIAbstractFactory<T> {
	static final Logger logger = LoggerFactory.getLogger(SIIAbstractFactory.class);
	static final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA_NS_URI = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	static final String XML_VERSION_DECL = "<?xml version=\"1.0\"?>\n";
	static final String DEFAULT_ENCODING = "ISO-8859-1";

	private static int errorCount = 0;

	/**
	 * Firma un nodo del xml y agrega su definicion al resultante
	 * 
	 * @param sourceXml     un inputstream con el xml
	 * @param domIdElement  nodo desde el cual hacer la firma
	 * @param elementWithID elemento que posee la propiedad ID que se usara para referencias
	 * @param referenceID   id de referencia al elemento que se firma
	 * @param cert          certificado a utilizar
	 * @param pk            primary key a utilizar
	 * @return el string xml firmado
	 */
	public String sign(InputStream sourceXml, String domIdElement, String elementWithID, String referenceID, X509Certificate cert, PrivateKey pk) {

		try {
			XmlSigner signer = new XmlSigner();
			logger.debug(sourceXml.toString());
			logger.debug(domIdElement);
			logger.debug(elementWithID);
			logger.debug(referenceID);
			logger.debug(cert.toString());
			logger.debug(pk.toString());
			SignedXml signedXml = signer.sign(sourceXml, domIdElement, elementWithID, referenceID, cert, pk);

			return signedXml.getContent();

		} catch (Exception ex) {
			logger.error("Excepcion firmando. Error:" + ex.getMessage(), ex);
			return null;
		}
	}

	/**
	 * Realiza el marshal, retornando un {@link org.w3c.dom.Document} del objeto
	 * 
	 * @param objeto datos a los cuales realizar el marshal
	 * @return {@link org.w3c.dom.Document}
	 */
	public Document marshallToW3CDocument(T objeto) {
		try {
			// Create the JAXBContext
			JAXBContext jc = JAXBContext.newInstance(objeto.getClass());

			// Create the Document
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.newDocument();

			// Marshal the Object to a Document
			Marshaller marshaller = jc.createMarshaller();
			marshaller.marshal(objeto, new DOMResult(document));
			//marshaller.marshal(objeto, document);

			@SuppressWarnings("unused")
			Element element = document.getDocumentElement();

			// Output the Document
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();

			DOMSource source = new DOMSource(document);
			StringWriter sw = new StringWriter();
			StreamResult sr = new StreamResult(sw);

			t.transform(source, sr);
			return document;

		} catch (Exception ex) {
			logger.error("Ocurrio un error realizando el marshalling del objeto. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Realiza el unmarshall del string xml
	 * 
	 * @param xml string xml con los datos
	 * @return una instancia del objeto
	 */
	public T unmarshallXml(String xml, Class<T> clazz) {
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);

			@SuppressWarnings("unchecked")
			T unmarshallDte = (T) context.createUnmarshaller().unmarshal(new StringReader(xml));
			return unmarshallDte;

		} catch (Exception ex) {
			logger.error("Se produjo un error realizando unmarshall. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Realiza el unmarshall del string xml sin exigir la declaracion xmlns
	 * 
	 * @param defaultNamespaceURI uri del namespace con el que se hace match
	 * @param xml string xml con los datos
	 * @return una instancia del objeto
	 */
	public T unmarshallXmlWithoutNamespace(String defaultNamespaceURI, String xml, Class<T> clazz) {
		try {
			//InputStream is = new FileInputStream(name);
			InputStream is = new ByteArrayInputStream(xml.getBytes());
			XMLStreamReader xsr = XMLInputFactory.newFactory().createXMLStreamReader(is);
			XMLReaderWithoutNamespace xr = new XMLReaderWithoutNamespace(defaultNamespaceURI, xsr);

			JAXBContext context = JAXBContext.newInstance(clazz);

			@SuppressWarnings("unchecked")
			T unmarshallDte = (T) context.createUnmarshaller().unmarshal(xr);
			return unmarshallDte;

		} catch (Exception ex) {
			logger.error("Se produjo un error realizando unmarshall. Error=", ex);
			return null;
		}
	}

	/**
	 * Obtiene el string xml del objeto. Utilizar para modificar la forma en que se crea el xml
	 * 
	 * @param data              {@link T} objeto con los datos
	 * @param urlSchemaLocation ubicacion del esquema que define el namespace en el xml
	 */
	public abstract String toXml(T data, String urlSchemaLocation) throws UnsupportedEncodingException;

	/**
	 * Obtiene el string xml del objeto.
	 * 
	 * @param data              objeto que contiene los datos
	 * @param urlSchemaLocation (opcional) si se indica, agrega la ubicacion del esquema al string xml resultante
	 * @param addXmlDeclaration agrega o no la declarion del archivo xml
	 * @return el xml correspondiente a los datos contenidos en el objeto
	 */
	protected String getXml(T data, String urlSchemaLocation, boolean addXmlDeclaration) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(data.getClass());

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, DEFAULT_ENCODING);

			//jaxbMarshaller.setProperty("{http://xml.apache.org/xslt}indent-amount", "0");
			//jaxbMarshaller.setProperty( "com.sun.xml.bin.indentString", "" );
			if (urlSchemaLocation != null) {
				jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, urlSchemaLocation);
			}

			// escribe el xml al stringwriter
			StringWriter sw = new StringWriter();
			if (addXmlDeclaration == true) {
				sw.append(XML_VERSION_DECL);
			}
			jaxbMarshaller.marshal(data, sw);

			StringWriter stringWriter = new StringWriter();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, DEFAULT_ENCODING);
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");

			transformer.transform(new StreamSource(new StringReader(sw.toString())), new StreamResult(stringWriter));

			return stringWriter.toString();

		} catch (Exception ex) {
			logger.error("Excepcion obteniendo el xml. Error:" + ex.getMessage(), ex);
		}
		return null;
	}

	/**
	 * Obtiene una representacion en JSON del objeto
	 * 
	 * @param data el objeto
	 * @return un string json representando el objeto de entrada
	 */
	protected String getJSON(T data) {
		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
		String json = gson.toJson(data);

		return json;
	}

	/**
	 * Valida el contenido de un string xml. Si el xml referencia esquemas, los utiliza para su validacion
	 * 
	 * @param xmlContent string xml
	 * @return
	 */
	public boolean validateXml(String xmlContent) {
		try {
			saxParserFactory.setNamespaceAware(true);
			saxParserFactory.setValidating(true);

			SAXParser saxParser = saxParserFactory.newSAXParser();
			saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA_NS_URI);

			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setErrorHandler(new ParserErrorHandler());
			xmlReader.setEntityResolver(new EntityResolver() {
				@Override
				public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
					String filename = systemId.substring(systemId.lastIndexOf("/") + 1, systemId.length());

					if (filename.equalsIgnoreCase("EnvioDTE_v10.xsd") || filename.equalsIgnoreCase("ConsumoFolio_v10.xsd")) {
						systemId = getClass().getResource("") + "../../../../sii/xsd/" + filename;
					}
					InputSource result = null;
					result = new InputSource(systemId);
					return result;
				}
			});

			InputSource is = new InputSource(new StringReader(xmlContent));
			xmlReader.parse(is);
			if (errorCount > 0) {
				logger.error("Fallo con " + errorCount + " errores");
				return false;
			} else {
				logger.debug("El xml esta correcto");
				return true;
			}
		} catch (Exception ex) {
			logger.error("Excepcion validando el xml. Error=" + ex.getMessage(), ex);
			return false;
		}
	}

	/**
	 * Error handler para el parser
	 */
	private static class ParserErrorHandler extends DefaultHandler {

		public void warning(SAXParseException e) throws SAXException {
			printException(e);
		}

		public void error(SAXParseException e) throws SAXException {
			printException(e);
		}

		public void fatalError(SAXParseException e) throws SAXException {
			printException(e);
		}

		private void printException(SAXParseException e) {
			errorCount++;
			logger.error("(linea=" + e.getLineNumber() + ", columna=" + e.getColumnNumber() + "), msg=" + e.getMessage());
		}
	}

	/**
	 * Se proporciona una implementacion propia dado que el xml almacenado en la base de datos no posee declaracion de namespace (xmlns, asi lo pide sii) Al momento del unmarshal es necesario dado que los objetos jaxb fueron generados segun la especificacion del esquema
	 *
	 */
	private class XMLReaderWithoutNamespace extends StreamReaderDelegate {
		private String defaultNamespaceUri;

		public XMLReaderWithoutNamespace(String defaultNamespaceUri, XMLStreamReader reader) {
			super(reader);
			this.defaultNamespaceUri = defaultNamespaceUri;
		}

		@Override
		public String getAttributeNamespace(int arg0) {
			return "";
		}

		@Override
		public String getNamespaceURI() {
			return defaultNamespaceUri; // "http://www.sii.cl/SiiDte";
		}
	}
}