package cl.fapp.sii.signer.common;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Almacena un xml firmado
 */
public class SignedXml {

	private String content;

	public SignedXml(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public String toBase64() throws UnsupportedEncodingException {
		return Base64.getEncoder().encodeToString(content.getBytes("ISO-8859-1"));
	}
}
