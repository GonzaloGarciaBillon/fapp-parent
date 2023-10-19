package cl.fapp.sii.signer.common;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * Mantiene informacion del keystore
 */
public class KeyStoreInfo {

	private String tipo;
	private String alias;
	private String password;
	private KeyStore keyStore;
	private Date certExpiryDate;

	public KeyStoreInfo(String tipo, String alias, String password) {
		this.tipo = tipo.toUpperCase();
		this.alias = alias;
		this.password = password;
	}

	/**
	 * Carga el keystore desde el inputstream
	 */
	public void load(InputStream inputstream) {
		try {
			this.keyStore = KeyStore.getInstance(this.tipo);
			this.keyStore.load(inputstream, password.toCharArray());
            this.certExpiryDate = ((X509Certificate) this.keyStore.getCertificate(this.alias)).getNotAfter();
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e) {
			e.printStackTrace();
			throw new XmlSigningException("Error accediendo al KeyStore", e);
		}
	}
	
	public String getIssuer() {
		X509Certificate certificate = this.getCertificate();
		String issuer = ((X509Certificate) certificate).getIssuerX500Principal().getName();
		
		return issuer;
	}

	public String getAlias() {
		return alias;
	}

	public String getPassword() {
		return password;
	}

	public KeyStore getKeyStore() {
		return keyStore;
	}

	public X509Certificate getCertificate() {
		if( keyStore == null ) {
			System.out.println("Keystore no ha sido iniciado");
			return null;
		}
		
		X509Certificate certificate;
		try {
			certificate = (X509Certificate) keyStore.getCertificate(alias);
            
			return certificate;
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public PublicKey getPublicKey() {
		if( keyStore == null ) {
			System.out.println("Keystore no ha sido iniciado");
			return null;
		}
		
		X509Certificate certificate;
		try {
			certificate = (X509Certificate) keyStore.getCertificate(alias);
			return certificate.getPublicKey();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public PrivateKey getPrivateKey(String password) {
		if( keyStore == null ) {
			System.out.println("Keystore no ha sido iniciado");
			return null;
		}
		
		PrivateKey pKey = null;
		try {
			pKey = (PrivateKey) keyStore.getKey(alias, password.toCharArray());
			if (pKey == null) {
				System.out.println("No se encontro PrivateKey asociada al alias '" + alias + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pKey;
	}
	
	public Date getCertExpiryDate() {
		return certExpiryDate;
	}
	

}
