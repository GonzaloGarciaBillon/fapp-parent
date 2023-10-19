package cl.fapp.restapi.controller.utils;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	FirmantesRepository firmantesRepo;

	@Autowired
	KeystoreFirmantesRepository keystorefirmantesRepo;

	/**
	 * Recupera datos del keystore a utilizar
	 * 
	 * @param rutemisor   rut del emisor
	 * @param rutfirmante rut del firmante
	 * @return keystoreinfo a utilizar. Null si no es posible recuperarlo.
	 */
	public KeyinfoFindResponse getKeystoreInfo(String rutemisor, String rutfirmante) {
		try {
			// verifica que existe relacion Emisor/Firmante
			Optional<Firmantes> currentFirmante = firmantesRepo.findByRutfirmanteAndEmisoreRutemisor(rutfirmante, rutemisor);
			if (currentFirmante.isPresent()) {
				// verifica que existe informacion del keystore asociado
				Optional<KeystoreFirmantes> currentKeystore = keystorefirmantesRepo.findByFirmanteIdFirmante(currentFirmante.get().getIdFirmante());
				if (currentKeystore.isPresent()) {
					KeyStoreInfo ksinfo = new KeyStoreInfo(currentKeystore.get().getKeystoreTipo(), currentKeystore.get().getKeystoreAlias(), currentKeystore.get().getKeystorePassword());
					ksinfo.load(new ByteArrayInputStream(currentKeystore.get().getKeystoreContent()));

					KeyinfoFindResponse response = new KeyinfoFindResponse();
					response.setCertificate(ksinfo.getCertificate());
					response.setPublickey(ksinfo.getPublicKey());
					response.setPrivatekey(ksinfo.getPrivateKey(currentKeystore.get().getKeystorePassword()));

					// TODO: completar con el issuer cuando la base lo tenga. REVISAR IMPLEMENTACION
					response.setIssuer(ksinfo.getIssuer());

					return response;

				} else {
					log.error("No existen datos de keystore para la relacion Firmante/Emisor. Firmante=" + rutfirmante + ", Emisor=" + rutemisor);
					throw new Exception("No existen datos de keystore a utilizar");
				}
			} else {
				log.error("No existe relacion Firmante/Emisor. Firmante=" + rutfirmante + ", Emisor=" + rutemisor);
				throw new Exception("No existe relacion Firmante/Emisor");
			}

		} catch (Exception ex) {
			log.error("No fue posible generar la boleta. Error=" + ex.getMessage());
			return null;
		}
	}

}
