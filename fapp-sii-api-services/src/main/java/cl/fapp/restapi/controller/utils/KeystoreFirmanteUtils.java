package cl.fapp.restapi.controller.utils;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import cl.fapp.common.crypto.EncryptDecrypt;
import cl.fapp.repository.model.Firmantes;
import cl.fapp.repository.model.KeystoreFirmantes;
import cl.fapp.repository.repos.FirmantesRepository;
import cl.fapp.repository.repos.KeystoreFirmantesRepository;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.sii.signer.common.KeyStoreInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KeystoreFirmanteUtils {

	@Autowired
	private FirmantesRepository firmantesRepo;

	@Autowired
	private KeystoreFirmantesRepository keystorefirmantesRepo;

	@Value("${decrypt.secretKey}")
    private String secretKey;
	
	/**
	 * Recupera datos del keystore a utilizar
	 * 
	 * @param rutemisor   rut del emisor
	 * @param rutfirmante rut del firmante
	 * @return keystoreinfo a utilizar. Null si no es posible recuperarlo.
	 */
	public KeyinfoFindResponse getKeystoreInfo(String rutemisor, String rutfirmante) {
		try {
			// Verifica que existe relación Emisor/Firmante
			Optional<Firmantes> currentFirmante = firmantesRepo.findByRutfirmanteAndEmisoreRutemisor(rutfirmante, rutemisor);
			if (currentFirmante.isPresent()) {
				// Verifica que existe información del keystore asociado
				Optional<KeystoreFirmantes> currentKeystore = keystorefirmantesRepo.findByFirmanteIdFirmante(currentFirmante.get().getIdFirmante());
				if (currentKeystore.isPresent()) {
					// Desencriptar la contraseña del keystore
					String encryptedPassword = currentKeystore.get().getKeystorePassword();
					String decryptedPassword = decryptKeystorePassword(encryptedPassword);

					KeyStoreInfo ksinfo = new KeyStoreInfo(currentKeystore.get().getKeystoreTipo(),
							currentKeystore.get().getKeystoreAlias(), decryptedPassword);
					ksinfo.load(new ByteArrayInputStream(currentKeystore.get().getKeystoreContent()));

					KeyinfoFindResponse response = new KeyinfoFindResponse();
					response.setCertificate(ksinfo.getCertificate());
					response.setPublickey(ksinfo.getPublicKey());
					response.setPrivatekey(ksinfo.getPrivateKey(decryptedPassword));

					// TODO: Completar con el issuer cuando la base lo tenga. REVISAR IMPLEMENTACIÓN
					response.setIssuer(ksinfo.getIssuer());

					return response;

				} else {
					log.error("No existen datos de keystore para la relación Firmante/Emisor. Firmante=" + rutfirmante + ", Emisor=" + rutemisor);
					throw new Exception("No existen datos de keystore a utilizar");
				}
			} else {
				log.error("No existe relación Firmante/Emisor. Firmante=" + rutfirmante + ", Emisor=" + rutemisor);
				throw new Exception("No existe relación Firmante/Emisor");
			}

		} catch (Exception ex) {
			log.error("No fue posible generar la boleta. Error=" + ex.getMessage());
			return null;
		}
	}

	// Método para desencriptar la contraseña del keystore
	private String decryptKeystorePassword(String encryptedPasswordWithIv) throws Exception {
		try {
			// Separar el IV y la data encriptada
			String[] parts = encryptedPasswordWithIv.split(":");
			if (parts.length != 2) {
				throw new IllegalArgumentException("Formato incorrecto para el dato encriptado con IV");
			}
			String ivHex = parts[0];
			String encryptedDataHex = parts[1];

			// Decodificar clave secreta, IV y data encriptada desde Hexadecimal
			byte[] decodedKey = hexStringToByteArray(secretKey);  // Usa tu método para obtener la clave en bytes
			byte[] decodedIv = hexStringToByteArray(ivHex);
			byte[] encryptedData = hexStringToByteArray(encryptedDataHex);

			SecretKey sk = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
			IvParameterSpec ivParameterSpec = new IvParameterSpec(decodedIv);

			// Desencriptar la data
			byte[] decryptedData = EncryptDecrypt.cbcDecrypt(sk, ivParameterSpec, encryptedData);
			return new String(decryptedData);
		} catch (Exception e) {
			log.error("Error al desencriptar la contraseña del keystore", e);
			throw new Exception("No fue posible desencriptar la contraseña del keystore");
		}
	}

	// Método para convertir Hexadecimal a Byte Array (si estás trabajando con Hexadecimal)
	private static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
}
