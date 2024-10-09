package cl.fapp.common.crypto;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class AESDecryption {

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public static String decrypt(String encryptedData, SecretKey key, IvParameterSpec iv) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }
}
