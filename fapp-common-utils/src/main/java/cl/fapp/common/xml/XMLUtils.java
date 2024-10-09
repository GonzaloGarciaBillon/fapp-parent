package cl.fapp.common.xml;

import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import lombok.extern.slf4j.Slf4j;

/**
 * Utiles para el manejo de xml
 */
@Slf4j
public class XMLUtils {

	/**
	 * Tabla de caracteres especiales definidos por el SII
	 */
	private static Map<String, String> siiEspecialChars;
	static {
		siiEspecialChars = new HashMap<String, String>();
		siiEspecialChars.put("&", "&amp;");
		siiEspecialChars.put("<", "&lt;");
		siiEspecialChars.put(">", "&gt;");
		siiEspecialChars.put("\"", "&quot;");
		siiEspecialChars.put("'", "&apos;");
	}

	/**
	 * Reemplaza caracteres especiales definidos por el SII por su representacion
	 * xml
	 * 
	 * @param s String con caracteres especiales
	 * @return String con caracteres especiales convertidos
	 */
	public static String replaceSiiEspecialChars(String s) {
		if (s == null) {
			return null;
		}

		for (Map.Entry<String, String> entry : siiEspecialChars.entrySet()) {
			s = s.replace(entry.getKey(), entry.getValue());
		}
		return s;
	}

	/**
	 * Procesa cada nodo de un documento resuelto por una expresion xpath
	 * 
	 * @param doc     documento
	 * @param xpath   expresion xpath
	 * @param process consumidor de los nodos
	 */
	public static void processFilteredXml(Document doc, String xpath, Consumer<Node> process) {
		NodeList list = filterNodesByXPath(doc, xpath);
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			process.accept(node);
		}
	}

	/**
	 * Crea un documento xml a partir de un stream
	 * 
	 * @param xmlin stream con contendio xml
	 * @return un documento xml
	 */
	public static Document readXml(InputStream xmlin) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(xmlin);
			is.setEncoding(StandardCharsets.ISO_8859_1.name());
			return db.parse(is);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Filtra nodos indicados en la expresion xpath
	 * 
	 * @param doc       documento xml
	 * @param xpathExpr expresion xpath
	 * @return lista de nodos hijos resueltos por la expresion xpath
	 */
	public static NodeList filterNodesByXPath(Document doc, String xpathExpr) {
		try {
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xpath = xPathFactory.newXPath();
			XPathExpression expr = xpath.compile(xpathExpr);
			Object eval = expr.evaluate(doc, XPathConstants.NODESET);
			return (NodeList) eval;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Acumula en el writer el contenido de un nodo. Se utiliza para recolectar el
	 * contenido de todos los nodos hijos de un nodo padre.
	 * 
	 * @param node      nodo
	 * @param strwriter en donde acumular
	 */
	public static void getContent(Node node, StringWriter strwriter) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");

			StreamResult result = new StreamResult(strwriter);
			DOMSource source = new DOMSource(node);
			transformer.transform(source, result);

			strwriter = (StringWriter) result.getWriter();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Obtiene el valor (text) encerrado entre dos tags. Comunmente tag abierto/tag
	 * cerrado
	 * 
	 * @param doc       documento
	 * @param xpathExpr expresion xpath
	 * @return un string con el texto contenido entre tag abierto/tag cerrado. Null
	 *         en caso de no encontrar el tag
	 */
	public static String getText(Document doc, String xpathExpr) {
		try {
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			String text;
			text = xp.evaluate(xpathExpr, doc.getDocumentElement());
			return text;
		} catch (XPathExpressionException e) {
			log.error(e.getMessage());
			return null;
		}
	}
}
