package cl.fapp;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import cl.fapp.common.crypto.EncryptDecrypt;

public class PruebaCrypto {

	public static void main(String[] args) throws IOException, GeneralSecurityException {
		String text = "passwordnormal";
		
		//IvParameterSpec ivParameterSpec = EncryptDecrypt.getIvParameterSpec();
		IvParameterSpec ivParameterSpec = EncryptDecrypt.getIVSecureRandom();
		
		SecretKey secretKey = EncryptDecrypt.getKeyFromPassword("pepitopagadoble", "2233");
		
		byte[] encrypted = EncryptDecrypt.cbcEncrypt(secretKey, ivParameterSpec, text.getBytes());
		
		byte[] base64encrypted = Base64.getEncoder().encode(encrypted);
		System.out.println("Encriptado=" + new String(base64encrypted));
		
		byte[] bytesDecrypted = Base64.getDecoder().decode(base64encrypted);

		byte[] decrypted = EncryptDecrypt.cbcDecrypt(secretKey, ivParameterSpec, bytesDecrypted);
		
		System.out.println("Desencriptado=" + new String(decrypted));
	}
}
