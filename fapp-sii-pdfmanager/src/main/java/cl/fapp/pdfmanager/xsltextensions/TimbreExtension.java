package cl.fapp.pdfmanager.xsltextensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.krysalis.barcode4j.xalan.BarcodeExt;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Extensión XSLT para generación de timbre a partir del TED de un DTE
 * 
 */
public class TimbreExtension extends BarcodeExt {

	public DocumentFragment generate(NodeList nl, NodeList tedxml) throws SAXException {

		Node elem = tedxml.item(0);
		StringWriter buf = new StringWriter();
		Transformer xform;
		try {
			xform = TransformerFactory.newInstance().newTransformer();
			xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes"); // optional
			xform.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1"); //-->modificado el 19072023
			
			// xform.setOutputProperty(OutputKeys.INDENT, "no"); // optional
			xform.transform(new DOMSource(elem), new StreamResult(buf));

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return generate(nl, trim(buf.toString()));
	}

	private static String trim(String input) {
		BufferedReader reader = new BufferedReader(new StringReader(input));
		StringBuffer result = new StringBuffer();
		try {
			String line;
			while ((line = reader.readLine()) != null)
				result.append(line.trim());
			return result.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}