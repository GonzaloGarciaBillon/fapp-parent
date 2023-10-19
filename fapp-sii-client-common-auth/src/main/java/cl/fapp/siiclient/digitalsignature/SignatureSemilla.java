package cl.fapp.siiclient.digitalsignature;

import java.io.FileNotFoundException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.transform.TransformerException;

public interface SignatureSemilla {
    
    public String signerWithCertAndPk(String stringToSing, X509Certificate cert, PrivateKey privateKey ) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyException,
            XMLSignatureException, FileNotFoundException, TransformerException;
}
