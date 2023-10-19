package cl.fapp.common.crypto;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Metodos para encriptar y desencriptar datos
 * Los secretos debieran ser guardados en Vault
 *
 */
public class EncryptDecrypt {
	
	private static String cipherTransformation = "AES/CBC/PKCS5Padding";
	private static String rngAlgorithm = "SHA1PRNG"; // (RNG=RandomNumberGenerator)
	private static String secretKeyAlgorithm = "PBKDF2WithHmacSHA256";
	private static int iterationCount = 65536;
	private static int keyLength = 256;

	/**
	 * Encripta con AES/CBC/PKCS5Padding
	 * @param key {@link SecretKey}
	 * @param iv {@link IvParameterSpec}
	 * @param data datos a encriptar
	 * @return la data encriptada
	 * @throws GeneralSecurityException
	 */
	public static byte[] cbcEncrypt(SecretKey key, IvParameterSpec iv, byte[] data) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		return cipher.doFinal(data);
	}

	/**
	 * Desencripta con AES/CBC/PKCS5Padding
	 * @param key {@link SecretKey}
	 * @param iv {@link IvParameterSpec}
	 * @param cipherText datos encriptados
	 * @return datos desencriptados
	 * @throws GeneralSecurityException
	 */
	public static byte[] cbcDecrypt(SecretKey key, IvParameterSpec iv, byte[] cipherText) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(cipherTransformation);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		return cipher.doFinal(cipherText);
	}

	/**
	 * Genera un SecretKey utilizando un password y un salt
	 * @param password password
	 * @param salt bytes aleatorios
	 * @return un {@link SecretKey}
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public static SecretKey getKeyFromPassword(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(secretKeyAlgorithm);
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterationCount, keyLength);
		SecretKey originalKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		return originalKey;
	}

	/**
	 * Crea un {@link IvParameterSpec} utilizando SHA1 como algoritmo para generar un numero random 
	 * @return un {@link IvParameterSpec}
	 * @throws NoSuchAlgorithmException
	 */
	public static IvParameterSpec getIvParameterSpec() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstance(rngAlgorithm);
		byte[] random = new byte[16];
		secureRandom.nextBytes(random);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(random);
		return ivParameterSpec;
	}

	/**
	 * Crea un {@link IvParameterSpec} utilizando un algoritmo fuerte (definido en jdk) para generar un numero random (RNG=RandomNumberGenerator)
	 * @param algorithm transformacion a emplear en el cifrador
	 * @return un {@link IvParameterSpec}
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 */
	public static IvParameterSpec getIVSecureRandom() throws NoSuchAlgorithmException, NoSuchPaddingException {
		SecureRandom random = SecureRandom.getInstanceStrong();
		byte[] iv = new byte[Cipher.getInstance(cipherTransformation).getBlockSize()];
		random.nextBytes(iv);
		return new IvParameterSpec(iv);
	}
}
