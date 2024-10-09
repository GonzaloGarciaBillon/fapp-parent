package cl.fapp;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import cl.fapp.common.crypto.*;


import lombok.extern.slf4j.Slf4j;
@Slf4j
public class EncryptDecryptTest {

    public static void main(String[] args) {
        try {
            String password = "K7@p9Lw!jR3#xQs7Zf8H";
            String salt = "wJdR3y5kjvP0sDd8V/ht7w==";
            String originalData = "TRANSFORMAPP";

            // Generar clave secreta a partir del password y el salt
            SecretKey secretKey = EncryptDecrypt.getKeyFromPassword(password, salt);
            log.info("Clave secreta: {}", bytesToHex(secretKey.getEncoded()));

            // Generar IV (Initialization Vector)
            IvParameterSpec ivParameterSpec = EncryptDecrypt.getIvParameterSpec();
            log.info("IV: {}", bytesToHex(ivParameterSpec.getIV()));

            // Encriptar los datos
            byte[] encryptedData = EncryptDecrypt.cbcEncrypt(secretKey, ivParameterSpec, originalData.getBytes());
            log.info("Data encriptada: {}", bytesToHex(encryptedData));

            log.info("Data encriptada para base de datos: "+ bytesToHex(ivParameterSpec.getIV())+":"+bytesToHex(encryptedData));

            // Desencriptar los datos
            byte[] decryptedData = EncryptDecrypt.cbcDecrypt(secretKey, ivParameterSpec, encryptedData);

            // Verificar que los datos desencriptados coinciden con los datos originales
            if (new String(decryptedData).equals(originalData)) {
                log.info("Los datos fueron desencriptados correctamente.");
            } else {
                log.error("Error: Los datos desencriptados no coinciden con los originales.");
            }

        } catch (Exception e) {
            log.error("Ocurrió un error durante el proceso de encriptación/desencriptación", e);
        }
    }

    // Método auxiliar para convertir bytes a una representación hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}

