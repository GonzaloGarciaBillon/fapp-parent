package cl.fapp.siiclient.digitalsignature;

import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.crypto.XMLStructure;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.KeyValue;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import cl.fapp.siiclient.utils.Utils;

public class SignatureSemillaFactory implements SignatureSemilla {

	public static SignatureSemillaFactory getSigner() {
        return new SignatureSemillaFactory();
    }

    public String signerWithCertAndPk(String semilla, X509Certificate cert, PrivateKey privateKey)
            throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyException,
            XMLSignatureException, FileNotFoundException, TransformerException {

        String stringToSing = addTagsToSign(semilla);

        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");

        // Create reference to the enveloped document (signing the whole document = URI
        // of "") and specify the SHA1 digest algorithm and the ENVELOPED Transform.
        Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null),
                Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null,
                null);

        // Create the SignedInfo
        SignedInfo si = fac.newSignedInfo(
                fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
                fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

        // Create KeyFactory
        KeyInfoFactory kif = fac.getKeyInfoFactory();

        // Use public key to sign
        KeyValue kv = kif.newKeyValue(cert.getPublicKey());

        // Create the KeyInfo containing the X509Data.
        List<X509Certificate> x509Content = new ArrayList<X509Certificate>();
        x509Content.add(cert);
        X509Data xd = kif.newX509Data(x509Content);

        // Add KeyValue and Certif X509Data to KeyInfo
        List<XMLStructure> xml_tag_list = new ArrayList<>();
        xml_tag_list.add(kv); // TAG KeyValue
        xml_tag_list.add(xd); // TAG X509Data

        KeyInfo ki = kif.newKeyInfo(xml_tag_list);

        // Transform string to Document
        Document doc = Utils.loadXMLFromString(stringToSing);

        // Create DOMSignContext, specify RSA PrivateKey and location of the resulting
        // XMLSignature's parent element
        DOMSignContext dsc = new DOMSignContext(privateKey, doc.getDocumentElement());

        // Create the XMLSignature (but don't sign it yet)
        XMLSignature signature = fac.newXMLSignature(si, ki); // antes ki.

        // Marshal, generate (and sign) the enveloped signature
        try {
            signature.sign(dsc);
        } catch (javax.xml.crypto.MarshalException e) {
            e.printStackTrace();
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

        StringWriter writer = new StringWriter();
        trans.transform(new DOMSource(doc), new StreamResult(writer));

        return "<?xml version=\"1.0\"?>" + writer.getBuffer().toString().trim();
    }

    private String addTagsToSign(String semilla) {
        if (semilla == null || semilla == "") {
            System.out.println("No hay semilla para firmar");
            return null;
        }
        return "<getToken><item><Semilla>" + semilla + "</Semilla></item></getToken>";
    }

}
