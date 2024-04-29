package cl.fapp.sii.signer.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.dom.DOMValidateContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import lombok.extern.slf4j.Slf4j;



/**
 * Firma XML empleando diferentes metodos
 */
@Slf4j
public class XmlSigner {
    static {
    	System.setProperty("com.sun.org.apache.xml.internal.security.ignoreLineBreaks", "true");
	}
	private static final String C14N_INC = CanonicalizationMethod.INCLUSIVE;

	static final Logger logger = LoggerFactory.getLogger(XmlSigner.class);
	
	// windows
	// public static final String CARRIAGE_RETURN = "\r\n";
	
	// linux
	public static final String CARRIAGE_RETURN = "\n";

	/**
	 * Firma sourceXml, a partir del tag domIdElement, utilizando certificate y pkey
	 * @param sourceXml xml a firmar
	 * @param domIdElement indica desde que tag se realiza la firma
	 * @param elementWithID elemento que tiene la propiedad ID que se usara como referencia
	 * @param referenceID id de referencia al elemento que se firma (000001)
	 * @param certificate certificado a utilizar
	 * @param pKey PrimaryKey a utilizar
	 * @return Un objeto {@link SignedXml} El xml de entrada con la seccion 'signature'
	 */
	public SignedXml sign(InputStream sourceXml, String domIdElement, String elementWithID, String referenceID, X509Certificate certificate, PrivateKey pKey) {
		try {
			// datos de certificado
			if (pKey == null || certificate == null) {
				throw new XmlSigningException("No se indico PrivateKey/Certificate");
			}

			// Create a DOM XMLSignatureFactory that will be used to generate the enveloped signature.
			XMLSignatureFactory xmlSignatureFactory = XMLSignatureFactory.getInstance("DOM");

			// Create a Reference to the enveloped document (in this case, you are signing the whole document, so a URI of "" signifies
			// that, and also specify the SHA1 digest algorithm and the ENVELOPED Transform.
			Transform envelopedTransform = xmlSignatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);

			// la siguiente estaba en comentario
			//-->Transform c14NEXCTransform = xmlSignatureFactory.newTransform(C14N_INC, (TransformParameterSpec) null);
			//-->List<Transform> transforms = Arrays.asList(envelopedTransform,c14NEXCTransform);

			List<Transform> transforms = Arrays.asList(envelopedTransform /*,c14NEXCTransform*/);

			DigestMethod digestMethod = xmlSignatureFactory.newDigestMethod(DigestMethod.SHA1, null);
			Reference reference;
			if( referenceID == null ) {
				reference = xmlSignatureFactory.newReference("", digestMethod, transforms, null, null);
			}else {
				reference = xmlSignatureFactory.newReference("#" + referenceID, digestMethod, transforms, null, null);
			}

			// Create the SignedInfo
			CanonicalizationMethod canonicalizationMethod = xmlSignatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null);
			SignatureMethod signatureMethod = xmlSignatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
			SignedInfo signedInfo = xmlSignatureFactory.newSignedInfo(canonicalizationMethod, signatureMethod, Collections.singletonList(reference));

			// Create a KeyInfo and add the KeyValue to it
			KeyInfoFactory keyInfoFactory = xmlSignatureFactory.getKeyInfoFactory();
			KeyValue keyvalue = keyInfoFactory.newKeyValue(certificate.getPublicKey());

			List<XMLStructure> keyinfodata = new ArrayList<XMLStructure>();
			keyinfodata.add(keyvalue);
			keyinfodata.add(keyInfoFactory.newX509Data(Collections.singletonList(certificate)));
			KeyInfo keyInfo = keyInfoFactory.newKeyInfo(keyinfodata);

			// Converts XML to Document
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder builder = dbf.newDocumentBuilder();
			// --18072023---------------------------------------
			InputSource is = new InputSource(sourceXml);
			is.setEncoding(StandardCharsets.ISO_8859_1.name());
			Document doc = builder.parse(is); //sourceXml);
			// -----------------------------------------
			
			//-->Document doc = builder.parse(sourceXml);
			doc.setXmlStandalone(true);

			// busca el nodo (elemento) a firmar
			Element nodetosign = null;
			if (domIdElement == null) {
				nodetosign = doc.getDocumentElement();
			} else {
				NodeList nodelist = doc.getElementsByTagName(domIdElement);
				if (nodelist == null || nodelist.getLength() != 1) {
					logger.error("El tag indicado no es unico. Tag=" + domIdElement);
					return null;
				} else {
					nodetosign = (Element) nodelist.item(0);
				}
			}
			
			// Create a DOMSignContext and specify the PrivateKey and location
			DOMSignContext dsc = new DOMSignContext(pKey, nodetosign);
			
			// define el elemento que tiene el ID para usarlo como referencia
            Element element = (Element)doc.getElementsByTagName(elementWithID).item(0);
            dsc.setIdAttributeNS(element, null, "ID");

			// Create the XMLSignature (but don't sign it yet)
			XMLSignature signature = xmlSignatureFactory.newXMLSignature(signedInfo, keyInfo);

			// Marshal, generate (and sign) the enveloped signature
			signature.sign(dsc);

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
			
			// las dos siguientes estaban en comentario
			//-->transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // sin indentacion, si no, causa error en la firma
			//-->transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");

			transformer.transform(new DOMSource(doc), new StreamResult(output));
			//transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(output, "ISO-8859-1")));
			String rawSignedXml = new String(output.toByteArray(),"UTF-8"); //, "UTF-8"); //, "ISO-8859-1");
			// normaliza el xml para que el sii lo pueda procesar
			logger.debug("Se formatea segun reglas del SII...");
			String newRawSignedXml = replaceTagValue("SignatureValue", 76, rawSignedXml);
			newRawSignedXml = replaceTagValue("Modulus", 76, newRawSignedXml);
			newRawSignedXml = replaceTagValue("X509Certificate", 76, newRawSignedXml);
			
			newRawSignedXml = newRawSignedXml.replace("UTF-8", "ISO-8859-1");

			return new SignedXml(newRawSignedXml);

		} catch (Exception ex) {
			logger.error("Ocurrio un error durante el proceso de firma. Error= {}", ex.getMessage());
			return null;
		}
	}

	/**
	 * Firma sourceXml, a partir del tag domIdElement, utilizando certificate y pkey
	 * @param sourceXml xml a firmar
	 * @param domIdElement indica desde que tag se realiza la firma
	 * @param elementWithID elemento que tiene la propiedad ID que se usara como referencia
	 * @param referenceID id de referencia al elemento que se firma (000001)
	 * @param certificate certificado a utilizar
	 * @param pKey PrimaryKey a utilizar
	 * @return Un objeto {@link SignedXml} El xml de entrada con la seccion 'signature'
	 */
	public SignedXml signMultiple(InputStream sourceXml, String domIdElement, String elementWithID, String referenceID, X509Certificate certificate, PrivateKey pKey) {
		try {
			// datos de certificado
			if (pKey == null || certificate == null) {
				throw new XmlSigningException("No se indico PrivateKey/Certificate");
			}

			// Create a DOM XMLSignatureFactory that will be used to generate the enveloped signature.
			XMLSignatureFactory xmlSignatureFactory = XMLSignatureFactory.getInstance("DOM");

			// Create a Reference to the enveloped document (in this case, you are signing the whole document, so a URI of "" signifies
			// that, and also specify the SHA1 digest algorithm and the ENVELOPED Transform.
			//-->Transform envelopedTransform = xmlSignatureFactory.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null);
			Transform c14NEXCTransform = xmlSignatureFactory.newTransform(C14N_INC, (TransformParameterSpec) null);
			List<Transform> transforms = Arrays.asList(/*envelopedTransform,*/ c14NEXCTransform);

			DigestMethod digestMethod = xmlSignatureFactory.newDigestMethod(DigestMethod.SHA1, null);
			Reference reference;
			if( referenceID == null ) {
				reference = xmlSignatureFactory.newReference("", digestMethod, transforms, null, null);
			}else {
				reference = xmlSignatureFactory.newReference("#" + referenceID, digestMethod, transforms, null, null);
			}

			// Create the SignedInfo
			CanonicalizationMethod canonicalizationMethod = xmlSignatureFactory.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null);
			SignatureMethod signatureMethod = xmlSignatureFactory.newSignatureMethod(SignatureMethod.RSA_SHA1, null);
			SignedInfo signedInfo = xmlSignatureFactory.newSignedInfo(canonicalizationMethod, signatureMethod, Collections.singletonList(reference));

			// Create a KeyInfo and add the KeyValue to it
			KeyInfoFactory keyInfoFactory = xmlSignatureFactory.getKeyInfoFactory();
			KeyValue keyvalue = keyInfoFactory.newKeyValue(certificate.getPublicKey());

			List<XMLStructure> keyinfodata = new ArrayList<XMLStructure>();
			keyinfodata.add(keyvalue);
			keyinfodata.add(keyInfoFactory.newX509Data(Collections.singletonList(certificate)));
			KeyInfo keyInfo = keyInfoFactory.newKeyInfo(keyinfodata);

			// Converts XML to Document
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder builder = dbf.newDocumentBuilder();
			Document doc = builder.parse(sourceXml);
			
			// busca el nodo (elemento) a firmar
			Element nodetosign = null;
			if (domIdElement == null) {
				nodetosign = doc.getDocumentElement();
			} else {
				NodeList nodelist = doc.getElementsByTagName(domIdElement);
				if (nodelist == null || nodelist.getLength() != 1) {
					logger.error("El tag indicado no es unico. Tag=" + domIdElement);
					return null;
				} else {
					nodetosign = (Element) nodelist.item(0);
				}
			}
			
			// Create a DOMSignContext and specify the PrivateKey and location
			DOMSignContext dsc = new DOMSignContext(pKey, nodetosign);
			
			// define el elemento que tiene el ID para usarlo como referencia
            Element element = (Element)doc.getElementsByTagName(elementWithID).item(0);
            dsc.setIdAttributeNS(element, null, "ID");

			// Create the XMLSignature (but don't sign it yet)
			XMLSignature signature = xmlSignatureFactory.newXMLSignature(signedInfo, keyInfo);

			// Marshal, generate (and sign) the enveloped signature
			signature.sign(dsc);

			ByteArrayOutputStream output = new ByteArrayOutputStream();
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING,"ISO-8859-1");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "0");

			transformer.transform(new DOMSource(doc), new StreamResult(output));

			String rawSignedXml = new String(output.toByteArray(), "ISO-8859-1");
			
			return new SignedXml(rawSignedXml);

		} catch (Exception ex) {
			logger.error("Ocurrio un error durante el proceso de firma. Error=" + ex.getMessage());
			return null;
		}
	}
	
	
	
	/**
	 * Elimina lineas en blanco del documento
	 * @param element raiz del documento
	 */
	@SuppressWarnings("unused")
	private void clearBlankLine(Element element) {
	    NodeList childNodes = element.getChildNodes();
	    for (int index = 0; index < childNodes.getLength(); index++) {
	        Node item = childNodes.item(index);
	        if (item.getNodeType() != 1 && System.lineSeparator()
	            .equals(item.getNodeValue())) {
	            element.removeChild(item);
	        } else {
	            if (item instanceof Element) {
	                clearBlankLine((Element) item);
	            }
	        }
	    }
	}
	
	/**
	 * Elimina los saltos de linea
	 * @param doc documento
	 * @return documento sin saltos de linea
	 */
	@SuppressWarnings("unused")
	private Document removeWhitespaceFromSignature(Document doc) {
	    Element sig = (Element) doc.getElementsByTagName("SignatureValue").item(0);
	    String sigValue = sig.getTextContent().replaceAll("\r\n", "");
	    sig.setTextContent(sigValue);

	    Element cert = (Element) doc.getElementsByTagName("X509Certificate").item(0);
	    String certValue = cert.getTextContent().replaceAll("\r\n", "");
	    cert.setTextContent(certValue);
	    
	    return doc;
	}
	
	/**
	 * Valida la firma del string xml indicado
	 * @param xmlcontent contenido xml a validar (debe contener el tag Signature)
	 * @return true/false
	 */
	public boolean validateSignature(String xmlcontent, String elementWithID, String subElement) {
		try {
			
			// instancia del documento a ser verificado
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(xmlcontent.getBytes("ISO-8859-1")));
			
			// el factory se usa para extraer el sobre de la firma
			XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
			
			// busca el elemento que contiene la firma
			NodeList nl = doc.getElementsByTagNameNS(XMLSignature.XMLNS, "Signature");
			if (nl.getLength() == 0) {
			    throw new Exception("No se encuentra el tag Signature");
			}

			// crea el DOMValidateContext especificando el KeySelector y el documento a verificar
			DOMValidateContext valContext = new DOMValidateContext(new X509KeySelector(), nl.item(0));
			valContext.setProperty("org.jcp.xml.dsig.secureValidation", Boolean.FALSE);
            //-->Element element = (Element)doc.getElementsByTagName(elementWithID).item(0);
            //-->valContext.setIdAttributeNS(element, null, "ID");
            
            XPath xPath = XPathFactory.newInstance().newXPath();
            //DOMValidateContext ctx = new DOMValidateContext(new X509KeySelector(), nl.item(0));            
            NodeList idAttributes = (NodeList)xPath.evaluate("//*[@ID]", doc.getDocumentElement(), XPathConstants.NODESET);
            for (int i = 0; i < idAttributes.getLength(); i++) {
            	valContext.setIdAttributeNS((Element) idAttributes.item(i), null, "ID");
            	logger.debug("Estableciendo id=" + i);
            }            
            
            //-->if( subElement != null ) {
            //-->    Element elementDocumento = (Element)doc.getElementsByTagName(subElement).item(0);
            //-->    valContext.setIdAttributeNS(elementDocumento, null, "ID");
            //-->}
			
			// unmarshal el tag Signature
			XMLSignature signature = fac.unmarshalXMLSignature(valContext);

			// valida el contenido del Signature
			boolean coreValidity = signature.validate(valContext);
			
			// verifica el status de la validacion
			if (coreValidity == false) {
			    boolean sv = signature.getSignatureValue().validate(valContext);
			    logger.error("Signature failed core validation. Signature validation status=" + sv);
			    if (sv == false) {
			        // verifica el estado de cada referencia
			        Iterator<Reference> i = signature.getSignedInfo().getReferences().iterator();
			        for (int j=0; i.hasNext(); j++) {
			        	Reference currentReference = (Reference) i.next();
			            boolean refValid = currentReference.validate(valContext);
			            
			            logger.debug("ref["+j+"]=" + currentReference.getURI() + ", validity status: " + refValid);
			        }
			    }
			    
			    return false;
			    
			} else {
			    logger.debug("Signature passed core validation");
			    return true;
			}
			
		}catch(Exception ex) {
			logger.error("Ocurrio un error mientras se validaba la firma. Error=" + ex.getMessage());
			return false;
		}
	}
	
	/**
	 * Reemplaza cada valor de un tag en partes de 'numchar' caracteres. Reemplaza todas las ocurrencias del tag.
	 * @param tag tag al cual reemplazar su valor
	 * @param numchar numero de caracteres de cada porcion
	 * @param xml xml que contiene el tag a reemplazar
	 * @return el xml modificado
	 */
	private static String replaceTagValue(String tag, Integer numchar, String xml) {
		Pattern TAG_PATTERN = Pattern.compile("<" + tag + ">(.+?)</" + tag + ">", Pattern.DOTALL);
		String original = new String(xml);
		int lastIndex = 0;
		StringBuilder output = new StringBuilder();
		Matcher matcher = TAG_PATTERN.matcher(original);
		while (matcher.find()) {
			String tagValue = matcher.group(1);
			output.append(original, lastIndex, matcher.start()).append(splitTagValue(tag, numchar, tagValue));
			lastIndex = matcher.end();
		}

		if (lastIndex < original.length()) {
			output.append(original, lastIndex, original.length());
		}
		
		return output.toString();
	}
	
	/**
	 * Porciona el valor del tag en partes de 'numchar' caracteres
	 * @param tag nombre del tag (se utiliza para generar el nuevo string incluyendo el tag)
	 * @param numchar numero de caracteres de cada parte
	 * @param value valor del tag
	 * @return el tag formateado
	 */
    private static String splitTagValue(String tag, Integer numchar, String value) {
		String crlf = value.contains(CARRIAGE_RETURN) ? "" : CARRIAGE_RETURN;
		String parsedTagValue = value.replaceAll("(.{" + numchar + "})", "$1" + crlf);
    	//String parsedTagValue = value.replaceAll("(.{" + numchar + "})", "$1" + CARRIAGE_RETURN);
    	String newValue = "<" + tag + ">" + parsedTagValue + "</" + tag + ">";
        return newValue;
    }
}
