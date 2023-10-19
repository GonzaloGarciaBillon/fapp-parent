package cl.fapp.restapi.controller.dte;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import cl.fapp.common.rut.RUTUtils;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.siiclient.axis.SOAPClientSIIAuthentication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SIITokenServiceUtils {
	
	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	SOAPClientSIIAuthentication soapAuthClient;

	@Autowired
	EmisoresRepository repoEmisores;
	
	/**
	 * Obtiene un token para poder utilizar los servicios
	 * 
	 * @param rutemisor   rut + dv del emisor
	 * @param rutfirmante rut + dv del certificado a utilizar para firmar solicitu de token
	 * @return un token entregado por el sii
	 * @throws Exception
	 */
	@Cacheable("tokencache")
	public String getToken(String rutemisor, String rutfirmante) throws Exception {
		String token = "sin-token";
		log.debug("Obteniendo token...");
		if (!RUTUtils.isValid(rutemisor)) {
			throw new Exception("El rut del emisor no es valido");
		}

		if (!RUTUtils.isValid(rutfirmante)) {
			throw new Exception("El rut del firmante no es valido");
		}

		// busca al emisor
		Optional<Emisores> optEmisor = repoEmisores.findById(rutemisor);
		if (!optEmisor.isPresent()) {
			log.error("El emisor no existe. rut=" + rutemisor);
			throw new Exception("El emisor no existe");
		}

		// recupera instancia de la entidad emisor
		//-->Emisores emisor = optEmisor.get();

		// recupera los datos para firmas
		KeyinfoFindResponse kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
		if (kinfo == null) {
			log.error("No fue posible obtener informacion del keystore");
			throw new Exception("No es posible obtener KeyStoreInfo");
		}

		// solicita un token para utilizar el servicio
		token = soapAuthClient.getToken(kinfo.getCertificate(), kinfo.getPrivatekey());
		if (token == null) {
			log.error("No se pudo obtener un token para operar");
			throw new Exception("No se pudo obtener token");
		} else {
			log.debug("Se obtiene token para operar TOKEN=" + token);
		}

		return token;
	}
}
