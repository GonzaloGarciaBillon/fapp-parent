package cl.fapp.common.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESKeyGenerator {
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Tamaño de la clave en bits
        return keyGen.generateKey();
    }
}
