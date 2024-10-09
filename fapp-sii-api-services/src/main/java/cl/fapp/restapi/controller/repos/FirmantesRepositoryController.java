package cl.fapp.restapi.controller.repos;

import java.util.Base64;
import java.util.Date;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.domain.statuses.EntityFirmantesStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.common.rut.RUTUtils;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Firmantes;
import cl.fapp.repository.model.KeystoreFirmantes;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.FirmantesRepository;
import cl.fapp.repository.repos.KeystoreFirmantesRepository;
import cl.fapp.restapi.controller.repos.dto.KeyInfoFirmanteRequest;
import cl.fapp.restapi.controller.repos.dto.KeyInfoFirmanteResponse;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindRequest;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.repo.base-path}")
@Tag(name = "ENTITIES")
public class FirmantesRepositoryController {
	@Autowired
	FirmantesRepository firmantesRepo;

	@Autowired
	EmisoresRepository emisoresRepo;

	@Autowired
	DteRepository dteRepo;

	@Autowired
	KeystoreFirmantesRepository keystorefirmantesRepo;

	@Autowired
	KeystoreFirmanteUtils ksfirmantesUtil;

	@Operation(summary = "API para repositorio FIRMANTES")
	@PostMapping("/firmantes/create")
	public ResponseEntity<JSend> create(@RequestBody Firmantes firmante) {
		try {
			// verifica que el emisor referenciado existe en la base de datos
			String rutEmisor = firmante.getEmisore().getRutemisor();
			if( RUTUtils.isValid(rutEmisor) ) {
				rutEmisor = RUTUtils.format(rutEmisor);
			}else {
				log.error("Rut-Emisor no es valido. Rut=" + rutEmisor);
				throw new Exception("Rut-Emisor no es valido");
			}
			
			String rutFirmante = firmante.getRutfirmante();
			if( RUTUtils.isValid(rutFirmante) ) {
				rutFirmante = RUTUtils.format(rutFirmante);
			}else {
				log.error("Rut-Firmante no es valido. Rut=" + rutFirmante);
				throw new Exception("Rut-Firmante no es valido");
			}			
			
			Optional<Emisores> emisor = emisoresRepo.findById(rutEmisor);
			if (!emisor.isPresent()) {
				log.error("El Emisor rut=" + rutEmisor + " no existe en la base de datos");
				throw new Exception("El Emisor no existe");
			} else {
				log.debug("El emisor rut=" + rutEmisor + " existe");

				// verifica si existe la relacion rutfirmante/rutemisor
				if (firmantesRepo.existsByRutfirmanteAndEmisoreRutemisor(rutFirmante, rutEmisor)) {
					log.error("La relacion Firmante/Emisor ya existe en la base de datos. Firmante=" + rutFirmante + ", Emisor=" + rutEmisor);
					throw new Exception("La relacion Firmante/Emisor ya existe en la base de datos");

				} else {
					// crea un registro en la base de datos
					Date ahora = new Date();
					firmante.setRutfirmante(rutFirmante);
					firmante.setCreatedat(ahora);
					firmante.setUpdatedat(ahora);
					firmante.setEstado(EntityFirmantesStatuses.ACTIVO.toString());
					firmante.setEmisore(emisor.get());

					Firmantes newfirmante = firmantesRepo.save(firmante);

					return ResponseEntity.ok().body(JSend.success("Relacion Firmante/Emisor creada con id=" + newfirmante.getIdFirmante()));
				}
			}

		} catch (Exception ex) {
			log.error("No fue posible crear el Firmante. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	@Operation(summary = "Obtiene informacion del keystore a utilizar")
	@PostMapping("/keyinfo/find")
	public ResponseEntity<JSend> find(@RequestBody KeyinfoFindRequest payload) {
		try {
			String rutemisor = payload.getRutemisor();
			String rutfirmante = payload.getRutfirmante();

			KeyinfoFindResponse ksinfo = ksfirmantesUtil.getKeystoreInfo(rutemisor, rutfirmante);
			if (ksinfo != null) {
				log.debug("Informacion del Keystore asociado a Firmante=" + rutfirmante + ", Emisor=" + rutemisor);
				log.debug("Certificado=" + Base64.getEncoder().encodeToString(ksinfo.getCertificate().getEncoded()));
				log.debug("PublicKey=" + Base64.getEncoder().encodeToString(ksinfo.getPublickey().getEncoded()));
				log.debug("PrivateKey=" + Base64.getEncoder().encodeToString(ksinfo.getPrivatekey().getEncoded()));
				return ResponseEntity.ok().body(JSend.success("KeystoreInfo recuperado exitosamente"));

			} else {
				return ResponseEntity.badRequest().body(JSend.error("No se encontro informacion del keystore asociado a Firmante/Emisor"));

			}

		} catch (Exception ex) {
			log.error("No fue posible crear el Firmante. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	@Operation(summary = "Obtiene informacion del keystore y firmante a utilizar")
	@PostMapping("/keyinfoFirmante/find")
	public ResponseEntity<KeyInfoFirmanteResponse> findKeyInfoFirmante(@RequestBody KeyInfoFirmanteRequest payload) {
		KeyInfoFirmanteResponse response = new KeyInfoFirmanteResponse();
		try {
			log.debug("Iniciando el proceso para obtener KeyInfoFirmante");

			// Obteniendo rutEmisor desde el payload
			String rutEmisor = payload.getRutEmisor();
			log.debug("RutEmisor recibido: {}", rutEmisor);
			Emisores emisor = emisoresRepo.findByRutemisor(rutEmisor);
			if (emisor == null) {
			log.error("No se encontró información de emisor para el rutEmisor: {}", rutEmisor);
			return ResponseEntity.badRequest().body(null);
			}
			String rutFirmante = null;

			// Buscando firmantes asociados al rutEmisor
			List<Firmantes> firmantes = firmantesRepo.findByEmisoreRutemisor(emisor.getRutemisor());
			log.error("Firmantes encontrados para rutEmisor {}: {}", rutEmisor, firmantes.size());

			KeystoreFirmantes ksInfoFirmante = null;

			// Iterando sobre la lista de firmantes
			for (Firmantes firmante : firmantes) {
				log.debug("Procesando firmante con ID: {}", firmante.getIdFirmante());

				// Buscando keystore asociado al firmante
				Optional<KeystoreFirmantes> ksinfo = keystorefirmantesRepo
				.findByFirmanteIdFirmante(firmante.getIdFirmante());
				log.debug("Keystore encontrado para firmante {}: {}", firmante.getRutfirmante(), ksinfo.isPresent());

				if (ksinfo.isPresent()) {
				// Almacenando datos del firmante y su keystore
				rutFirmante = firmante.getRutfirmante();
				ksInfoFirmante = ksinfo.get();
				log.debug("Firmante encontrado: {} con keystore tipo: {}", rutFirmante,
				ksInfoFirmante.getKeystoreTipo());
				} else {
					log.debug("Firmante {} no posee keystore", firmante.getRutfirmante());
				}
			}

			// Validando si se encontró información de keystore
			if (ksInfoFirmante != null) {
			log.debug("Keystore encontrado para firmante: {}. Preparando la respuesta", rutFirmante);

			// Populando la respuesta con los detalles del keystore
			response.setRutFirmante(rutFirmante);
			response.setKeystoreTipo(ksInfoFirmante.getKeystoreTipo());
			response.setKeystorePath(ksInfoFirmante.getKeystorePath());
			response.setKeystoreContent(ksInfoFirmante.getKeystoreContent());
			response.setKeystoreAlias(ksInfoFirmante.getKeystoreAlias());
			response.setKeystorePassword(ksInfoFirmante.getKeystorePassword());
			response.setCertificatePassword(ksInfoFirmante.getCertificatePassword());
			response.setCertificateExpiryDate(ksInfoFirmante.getCertificateExpiryDate());
			response.setIssuer(ksInfoFirmante.getCertificateIssuer());
			response.setFechaCreacion(ksInfoFirmante.getCreatedat());

			log.debug("Respuesta preparada con éxito para firmante: {}", rutFirmante);
			return ResponseEntity.ok().body(response);

			} else {
				log.debug("No se encontró información de keystore para el rutEmisor: {}", rutEmisor);
				return ResponseEntity.badRequest().body(null);
			}

		} catch (Exception ex) {
			log.info("Error al procesar la solicitud para el rutEmisor {}. Mensaje de error: {}", payload.getRutEmisor(),
			ex.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
	}
}
