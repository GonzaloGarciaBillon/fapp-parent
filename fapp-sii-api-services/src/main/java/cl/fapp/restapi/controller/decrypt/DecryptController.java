package cl.fapp.restapi.controller.decrypt;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.security.SecureRandom; // Add this import

import cl.fapp.common.crypto.EncryptDecrypt;
import cl.fapp.restapi.controller.decrypt.dto.DecryptRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "${fapp.api.controller.base-path}")
public class DecryptController {

    @PostMapping(value = "/decrypt", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> decryptData(@RequestBody DecryptRequest decryptRequest) {
        try {
            // Decodificar clave secreta e IV desde Hexadecimal
            byte[] decodedKey = hexStringToByteArray(decryptRequest.getSecretKey());
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

            byte[] decodedIv = hexStringToByteArray(decryptRequest.getIv());
            IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIv);

            // Decodificar los datos encriptados desde Hexadecimal
            byte[] encryptedData = hexStringToByteArray(decryptRequest.getEncryptedData());

            // Desencriptar los datos
            byte[] decryptedData = EncryptDecrypt.cbcDecrypt(secretKey, ivParameterSpec, encryptedData);
            log.info("Data desencriptada exitosamente: {}", new String(decryptedData));
            return ResponseEntity.ok(new String(decryptedData));

        } catch (Exception e) {
            log.error("Error al desencriptar los datos", e);
            return ResponseEntity.status(500).body("Error al desencriptar los datos: " + e.getMessage());
        }
    }

    // Método para convertir Hexadecimal a Byte Array
    private static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}

