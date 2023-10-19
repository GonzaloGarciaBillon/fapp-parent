package cl.fapp.restapi.controller.repos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

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

import cl.fapp.common.domain.statuses.EntityEmisoresStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.common.rut.RUTUtils;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.repos.dto.UploadEmisorInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.repo.base-path}")
@Tag(name = "ENTITIES")
public class EmisoresRepositoryController {
	@Autowired
	EmisoresRepository emisoresRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/emisor/create", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<JSend> create(@Validated @ModelAttribute @RequestBody UploadEmisorInfo payload, @RequestParam MultipartFile logofile) {
		try {
			byte[] logocontent = null;
			if( logofile != null ) {
				logocontent = logofile.getInputStream().readAllBytes();				
			}
			
			// verifica rut del emisor. Si es valido, lo formatea
			if( RUTUtils.isValid(payload.getRutemisor())) {
				payload.setRutemisor(RUTUtils.format(payload.getRutemisor()));
			}else {
				log.error("Rut-Emisor no es valido. Rut=" + payload.getRutemisor());
				throw new Exception("Rut-Emisor no es valido");
			}

			// verifica que el emisor que se quiere crear NO existe
			if (emisoresRepo.existsById(payload.getRutemisor())) {
				log.error("El emisor con rut=" + payload.getRutemisor() + " ya existe");
				throw new Exception("El Emisor ya existe");
			} else {

				// convierte fecha de resolucion indicada en el request
				Date dateFechaResolucion;
				try {
					LocalDate date = LocalDate.parse(payload.getFechaResolucion());
					dateFechaResolucion = convertToDateUsingInstant(date);
				} catch (Exception ex) {
					log.error("No fue posible convertir fecha. Error=" + ex.getMessage());
					throw new Exception("La fecha de resolucion no es valida");
				}

				// fecha/hora en que se crea la entidad
				Date ahora = new Date();

				// crea una instancia de la entidad
				Emisores emisor = new Emisores();
				emisor.setRutemisor(payload.getRutemisor());
				emisor.setLogo(logocontent);
				emisor.setGiro(payload.getGiro());
				emisor.setRazonSocial(payload.getRazonSocial());
				emisor.setComuna(payload.getComuna());
				emisor.setCiudad(payload.getCiudad());
				emisor.setDireccion(payload.getDireccion());
				emisor.setCodigoResolucion(payload.getCodigoResolucion());
				emisor.setFechaResolucion(dateFechaResolucion);
				
				// establece valores por defecto
				emisor.setCreatedat(ahora);
				emisor.setUpdatedat(ahora);
				emisor.setEstado(EntityEmisoresStatuses.ACTIVO.toString());
				
				// almacena la entidad
				emisoresRepo.save(emisor);
				
				// responde al caller
				return ResponseEntity.ok().body(JSend.success("Emisor creado"));
			}

		} catch (Exception ex) {
			log.error("No fue posible crear el Emisor. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	@Operation(summary = "API para repositorio EMISORES")
	@RequestMapping(method = RequestMethod.POST, value = "/emisor/update", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<JSend> update(@Validated @ModelAttribute @RequestBody UploadEmisorInfo payload, @RequestParam MultipartFile logofile) {
		try {
			byte[] logocontent = null;
			if( logofile != null ) {
				logocontent = logofile.getInputStream().readAllBytes();				
			}
			
			// verifica rut del emisor. Si es valido, lo formatea
			if( RUTUtils.isValid(payload.getRutemisor())) {
				payload.setRutemisor(RUTUtils.format(payload.getRutemisor()));
			}else {
				log.error("Rut-Emisor no es valido. Rut=" + payload.getRutemisor());
				throw new Exception("Rut-Emisor no es valido");
			}

			// verifica que el emisor que se quiere modificar existe
			if (emisoresRepo.existsById(payload.getRutemisor())) {
				// busca los datos del emisor existente
				Optional<Emisores> oldRecord = emisoresRepo.findById(payload.getRutemisor());
				if( !oldRecord.isPresent() ) {
					log.error("El emisor con rut=" + payload.getRutemisor() + " NO existe");
					throw new Exception("El Emisor no existe");
				}else {
					Emisores oldEmisor = oldRecord.get();
					
					log.debug("Modificando datos de Emisor rut=" + oldEmisor.getRutemisor() + "...");
					
					// convierte fecha de resolucion indicada en el request
					Date dateFechaResolucion;
					try {
						LocalDate date = LocalDate.parse(payload.getFechaResolucion());
						dateFechaResolucion = convertToDateUsingInstant(date);
					} catch (Exception ex) {
						log.error("No fue posible convertir fecha. Error=" + ex.getMessage());
						throw new Exception("La fecha de resolucion no es valida");
					}

					// fecha/hora en que se crea la entidad
					Date ahora = new Date();

					// crea una instancia de la entidad
					// Emisores emisor = new Emisores();
					// oldEmisor.setRutemisor(payload.getRutemisor());
					oldEmisor.setLogo(logocontent);
					oldEmisor.setGiro(payload.getGiro());
					oldEmisor.setRazonSocial(payload.getRazonSocial());
					oldEmisor.setComuna(payload.getComuna());
					oldEmisor.setCiudad(payload.getCiudad());
					oldEmisor.setDireccion(payload.getDireccion());
					oldEmisor.setCodigoResolucion(payload.getCodigoResolucion());
					oldEmisor.setFechaResolucion(dateFechaResolucion);
					
					// establece valores por defecto
					// oldEmisor.setCreatedat(ahora);
					oldEmisor.setUpdatedat(ahora);
					oldEmisor.setEstado(oldEmisor.getEstado());
					
					// almacena la entidad
					Emisores updatedRecord = emisoresRepo.save(oldEmisor);
					
					// responde al caller
					log.debug("Emisor rut=" + updatedRecord.getRutemisor() + ", actualizado");
					return ResponseEntity.ok().body(JSend.success("Emisor actualizado"));
				}
				
			} else {
				log.error("El emisor rut=" + payload.getRutemisor() + " NO existe");
				throw new Exception("El Emisor no existe");
			}

		} catch (Exception ex) {
			log.error("No fue posible crear el Emisor. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	public static Date convertToDateUsingInstant(LocalDate date) {
		return java.util.Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
