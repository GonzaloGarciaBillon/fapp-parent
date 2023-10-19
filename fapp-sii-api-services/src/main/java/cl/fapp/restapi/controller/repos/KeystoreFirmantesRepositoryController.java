package cl.fapp.restapi.controller.repos;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.Optional;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Firmantes;
import cl.fapp.repository.model.KeystoreFirmantes;
import cl.fapp.repository.repos.FirmantesRepository;
import cl.fapp.repository.repos.KeystoreFirmantesRepository;
import cl.fapp.restapi.controller.repos.dto.UploadKeystoreRequest;
import cl.fapp.sii.signer.common.KeyStoreInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.repo.base-path}")
@Tag(name = "ENTITIES")
public class KeystoreFirmantesRepositoryController {
	@Autowired
	FirmantesRepository firmantesRepo;

	@Autowired
	KeystoreFirmantesRepository keystorefirmantesRepo;

	/**
	 * Crea informacion en keyinfo asociado a un Emisor/Firmante
	 * 
	 * @param payload      request al servicio
	 * @param keystorefile stream bytes con el contenido del archivo que tiene el keyinfo
	 * @return estructura JSend simple
	 */
	@Operation(summary = "API para repositorio KEYSTOREFIRMANTES")
	@RequestMapping(method = RequestMethod.POST, value = "/keyinfo/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> create(@Validated @ModelAttribute @RequestBody UploadKeystoreRequest payload, @RequestParam MultipartFile keystorefile) { //@RequestBody KeystoreFirmantes firmante) {
		try {
			// recupera el contenido del archivo
			byte[] keystorecontent = keystorefile.getInputStream().readAllBytes();

			// determina que tipo de keystore instanciar utilizando la extension del archivo
			String filename = keystorefile.getOriginalFilename();
			String extension = FilenameUtils.getExtension(filename);

			String keystoreType;
			switch (extension) {
			case "jks":
				keystoreType = "JKS";
				break;
			case "pfx":
				keystoreType = "PKCS12";
				break;
			default:
				log.error("Extension de archivo Keystore no soportada. Extension=" + extension);
				return ResponseEntity.ok().body(JSend.error("Extension del Keystore no soportada"));
			}
			
			if( !payload.getTipoCertificado().equalsIgnoreCase(extension)) {
				log.error("Tipo de certificado y extension del archivo Keystore no coinciden. Tipo=" + payload.getTipoCertificado() + ", Extension=" + extension);
				return ResponseEntity.ok().body(JSend.error("Tipo de certificado y extension del archivo Keystore no coinciden"));
			}
			
			// verifica que exista el firmante para el cliente indicado, y recupera sus datos
			Optional<Firmantes> firmante = firmantesRepo.findByRutfirmanteAndEmisoreRutemisor(payload.getRutFirmante(), payload.getRutEmisor());

			if (firmante.isPresent()) {
				Firmantes currentfirmante = firmante.get();

				// verifica que la relacion Firmante/Emisor no tenga ya un keystoreinfo
				if (keystorefirmantesRepo.existsByFirmanteIdFirmante(currentfirmante.getIdFirmante())) {
					log.error("La relacion Firmante/Emisor ya posee informacion de KeystoreInfo. Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
					throw new Exception("La relacion Firmante/Emisor ya posee datos en KeystoreInfo");
				} else {
					Date ahora = new Date();
					KeystoreFirmantes newkesytorefirmante = new KeystoreFirmantes();
					newkesytorefirmante.setCertificatePassword(payload.getPasswordCertificate());
					newkesytorefirmante.setKeystorePassword(payload.getPasswordKeystore());
					newkesytorefirmante.setCreatedat(ahora);
					newkesytorefirmante.setFirmante(currentfirmante);
					newkesytorefirmante.setKeystoreAlias(payload.getAliasKeystore());
					newkesytorefirmante.setKeystoreContent(keystorecontent);
					newkesytorefirmante.setKeystorePath(null);
					newkesytorefirmante.setKeystoreTipo(keystoreType);
					newkesytorefirmante.setMetadata(null);

					KeyStoreInfo ki = new KeyStoreInfo(keystoreType, newkesytorefirmante.getKeystoreAlias(), newkesytorefirmante.getKeystorePassword());
					ki.load(new ByteArrayInputStream(keystorecontent));

					// escribe el issuer en la base
					log.debug("Issuer=" + ki.getIssuer());
					newkesytorefirmante.setCertificateIssuer(ki.getIssuer());

					// establece la fecha de expiracion del certificado
					newkesytorefirmante.setCertificateExpiryDate(ki.getCertExpiryDate());

					// actualiza columna updatedat
					newkesytorefirmante.setUpdatedat(ahora);

					KeystoreFirmantes newrecord = keystorefirmantesRepo.save(newkesytorefirmante);
					return ResponseEntity.ok().body(JSend.success("KeystoreInfo para relacion Firmante/Emisor creada con id=" + newrecord.getIdKeystore()));
				}

			} else {
				log.error("La relacion Firmante/Emisor no existe. Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
				throw new Exception("La relacion Firmante/Emisor no existe");
			}

		} catch (Exception ex) {
			log.error("No fue posible crear KeystoreInfo para el Firmante. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
	
	/**
	 * Actualiza informacion en keyinfo asociado a un Emisor/Firmante
	 * 
	 * @param payload      request al servicio
	 * @param keystorefile stream bytes con el contenido del archivo que tiene el keyinfo
	 * @return estructura JSend simple
	 */
	@Operation(summary = "API para repositorio KEYSTOREFIRMANTES")
	@RequestMapping(method = RequestMethod.POST, value = "/keyinfo/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> update(@Validated @ModelAttribute @RequestBody UploadKeystoreRequest payload, @RequestParam MultipartFile keystorefile) { //@RequestBody KeystoreFirmantes firmante) {
		try {
			// recupera el contenido del archivo
			byte[] keystorecontent = keystorefile.getInputStream().readAllBytes();

			// determina que tipo de keystore instanciar utilizando la extension del archivo
			String filename = keystorefile.getOriginalFilename();
			String extension = FilenameUtils.getExtension(filename);

			String keystoreType;
			switch (extension) {
			case "jks":
				keystoreType = "JKS";
				break;
			case "pfx":
				keystoreType = "PKCS12";
				break;
			default:
				log.error("Extension de archivo Keystore no soportada. Extension=" + extension);
				return ResponseEntity.ok().body(JSend.error("Extension del Keystore no soportada"));
			}
			
			if( !payload.getTipoCertificado().equalsIgnoreCase(extension)) {
				log.error("Tipo de certificado y extension del archivo Keystore no coinciden. Tipo=" + payload.getTipoCertificado() + ", Extension=" + extension);
				return ResponseEntity.ok().body(JSend.error("Tipo de certificado y extension del archivo Keystore no coinciden"));
			}
			
			// verifica que exista el firmante para el cliente indicado, y recupera sus datos
			Optional<Firmantes> firmante = firmantesRepo.findByRutfirmanteAndEmisoreRutemisor(payload.getRutFirmante(), payload.getRutEmisor());

			if (firmante.isPresent()) {
				Firmantes currentfirmante = firmante.get();

				// verifica que la relacion Firmante/Emisor tenga ya un keystoreinfo que actualizar
				if (keystorefirmantesRepo.existsByFirmanteIdFirmante(currentfirmante.getIdFirmante())) {
					log.warn("La relacion Firmante/Emisor ya posee informacion de KeystoreInfo. Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
					log.warn("Se actualizan los datos relativos a llaves para la relacion: Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
					
					Optional<KeystoreFirmantes> optKeyInfo = keystorefirmantesRepo.findByFirmanteIdFirmante(currentfirmante.getIdFirmante());
					if( !optKeyInfo.isPresent()) {
						log.error("No fue posible recuperar datos de KeystoreFirmantes. IdFirmante=" + currentfirmante.getIdFirmante() + ", Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
						throw new Exception("No se pudo recuperar datos de Firmante");
					}
					
					// recupera la instancia de keyStoreFirmantes
					KeystoreFirmantes currentKeyInfo = optKeyInfo.get();
					
					// crea/actualiza el registro
					Date ahora = new Date();
					currentKeyInfo.setCertificatePassword(payload.getPasswordCertificate());
					currentKeyInfo.setKeystorePassword(payload.getPasswordKeystore());
					currentKeyInfo.setCreatedat(ahora);
					currentKeyInfo.setFirmante(currentfirmante);
					currentKeyInfo.setKeystoreAlias(payload.getAliasKeystore());
					currentKeyInfo.setKeystoreContent(keystorecontent);
					currentKeyInfo.setKeystorePath(null);
					currentKeyInfo.setKeystoreTipo(keystoreType);
					currentKeyInfo.setMetadata(null);

					KeyStoreInfo ki = new KeyStoreInfo(keystoreType, currentKeyInfo.getKeystoreAlias(), currentKeyInfo.getKeystorePassword());
					ki.load(new ByteArrayInputStream(keystorecontent));

					// escribe el issuer en la base
					log.debug("Issuer=" + ki.getIssuer());
					currentKeyInfo.setCertificateIssuer(ki.getIssuer());

					// establece la fecha de expiracion del certificado
					currentKeyInfo.setCertificateExpiryDate(ki.getCertExpiryDate());

					// actualiza columna updatedat
					currentKeyInfo.setUpdatedat(ahora);

					KeystoreFirmantes updatedRecord = keystorefirmantesRepo.save(currentKeyInfo);
					return ResponseEntity.ok().body(JSend.success("KeystoreInfo para relacion Firmante/Emisor actualizado con id=" + updatedRecord.getIdKeystore()));					
					
				} else {
					log.error("La relacion Firmante/Emisor NO posee informacion de KeystoreInfo. Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
					throw new Exception("La relacion Firmante/Emisor no posee datos");

				}

			} else {
				log.error("La relacion Firmante/Emisor no existe. Firmante=" + payload.getRutFirmante() + ", Emisor=" + payload.getRutEmisor());
				throw new Exception("La relacion Firmante/Emisor no existe");
			}

		} catch (Exception ex) {
			log.error("No fue posible actualizar KeystoreInfo para el Firmante. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

}
