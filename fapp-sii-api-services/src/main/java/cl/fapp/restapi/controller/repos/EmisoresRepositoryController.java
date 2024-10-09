package cl.fapp.restapi.controller.repos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
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
import cl.fapp.repository.model.ActividadEconomica;
import cl.fapp.repository.model.EmisorActividad;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.ActividadEconomicaRepository;
import cl.fapp.repository.repos.EmisorActividadRepository;
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

	@Autowired
	ActividadEconomicaRepository actEconomicaRepo;

	@Autowired
	EmisorActividadRepository emisorActRepo;

	@RequestMapping(method = RequestMethod.POST, value = "/emisor/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> create(@Validated @ModelAttribute @RequestBody UploadEmisorInfo payload,
			@RequestParam MultipartFile logofile) {
		try {
			byte[] logocontent = null;
			if (logofile != null) {
				logocontent = logofile.getInputStream().readAllBytes();
			}

			// verifica rut del emisor. Si es valido, lo formatea
			if (RUTUtils.isValid(payload.getRutemisor())) {
				payload.setRutemisor(RUTUtils.format(payload.getRutemisor()));
			} else {
				log.error("Rut-Emisor no es valido. Rut=" + payload.getRutemisor());
				return ResponseEntity.badRequest().body(JSend.error("Rut-Emisor no es valido"));
			}

			// verifica que el emisor que se quiere crear NO existe
			if (emisoresRepo.existsById(payload.getRutemisor())) {
				log.error("El emisor con rut=" + payload.getRutemisor() + " ya existe");
				return ResponseEntity.badRequest().body(JSend.error("El Emisor ya existe"));
			} else {
				log.debug("Creando Emisor rut=" + payload.getRutemisor() + "...");

				if (payload.getActividades().isEmpty()) {
					log.error("Agregar al menos una actividad economica");
					return ResponseEntity.badRequest().body(JSend.error("Agregar al menos una actividad economica"));
				}

				// convierte fecha de resolucion indicada en el request
				Date dateFechaResolucion;
				try {
					LocalDate date = LocalDate.parse(payload.getFechaResolucion());
					dateFechaResolucion = convertToDateUsingInstant(date);
				} catch (Exception ex) {
					log.error("No fue posible convertir fecha. Error=" + ex.getMessage());
					return ResponseEntity.badRequest().body(JSend.error("La fecha de resolucion no es valida"));
				}

				// fecha/hora en que se crea la entidad
				Date ahora = new Date();

				// crea una instancia de la entidad Emisor
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

				// almacena el emisor
				emisoresRepo.save(emisor);

				// Variable para verificar si al menos una actividad fue agregada
				boolean actividadAgregada = false;

				// almacena las actividades economicas del emisor
				log.debug("Agregando actividades economicas al Emisor rut=" + payload.getRutemisor() + "...");

				List<String> actividades = payload.getActividades();
				for (String act : actividades) {
					log.debug(act);
					Optional<ActividadEconomica> actEconomica = actEconomicaRepo.findByCodigo(act);
					if (actEconomica.isPresent()) {
						EmisorActividad emisorAct = new EmisorActividad();
						emisorAct.setEmisor(emisor);
						emisorAct.setActividadEconomica(actEconomica.get());
						emisorActRepo.save(emisorAct);
						log.debug("Actividad Economica = " + act + " agregada al Emisor rut=" + payload.getRutemisor());
						actividadAgregada = true; // Marca que al menos una actividad fue agregada
					} else {
						log.error("Actividad Economica = " + act + " no existe");
					}
				}

				// Si no se agregó ninguna actividad, cancela la operación
				if (!actividadAgregada) {
					return ResponseEntity.badRequest()
							.body(JSend.error("Debe agregar al menos una actividad existente"));
				}

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
	public ResponseEntity<JSend> update(@Validated @ModelAttribute @RequestBody UploadEmisorInfo payload,
			@RequestParam MultipartFile logofile) {
		try {
			byte[] logocontent = null;
			if (logofile != null) {
				logocontent = logofile.getInputStream().readAllBytes();
			}

			// verifica rut del emisor. Si es valido, lo formatea
			if (RUTUtils.isValid(payload.getRutemisor())) {
				payload.setRutemisor(RUTUtils.format(payload.getRutemisor()));
			} else {
				log.error("Rut-Emisor no es valido. Rut=" + payload.getRutemisor());
				return ResponseEntity.badRequest().body(JSend.error("Rut-Emisor no es valido"));
			}

			// verifica que el emisor que se quiere modificar existe
			if (emisoresRepo.existsById(payload.getRutemisor())) {
				// busca los datos del emisor existente
				Optional<Emisores> oldRecord = emisoresRepo.findById(payload.getRutemisor());
				if (!oldRecord.isPresent()) {
					log.error("El emisor con rut=" + payload.getRutemisor() + " NO existe");
					return ResponseEntity.badRequest().body(JSend.error("El Emisor no existe"));
				} else {
					Emisores oldEmisor = oldRecord.get();

					log.debug("Modificando datos de Emisor rut=" + oldEmisor.getRutemisor() + "...");

					// convierte fecha de resolucion indicada en el request
					Date dateFechaResolucion = null;
					try {
						if (payload.getFechaResolucion() != null && !payload.getFechaResolucion().isEmpty()) {
							LocalDate date = LocalDate.parse(payload.getFechaResolucion());
							dateFechaResolucion = convertToDateUsingInstant(date);
						}
					} catch (Exception ex) {
						log.error("No fue posible convertir fecha. Error=" + ex.getMessage());
						return ResponseEntity.badRequest().body(JSend.error("La fecha de resolucion no es valida"));
					}

					// fecha/hora en que se actualiza la entidad
					Date ahora = new Date();

					// Actualiza solo los campos que tienen algún valor
					if (logocontent != null) {
						oldEmisor.setLogo(logocontent);
					}
					if (payload.getGiro() != null && !payload.getGiro().isEmpty()) {
						oldEmisor.setGiro(payload.getGiro());
					}
					if (payload.getRazonSocial() != null && !payload.getRazonSocial().isEmpty()) {
						oldEmisor.setRazonSocial(payload.getRazonSocial());
					}
					if (payload.getComuna() != null && !payload.getComuna().isEmpty()) {
						oldEmisor.setComuna(payload.getComuna());
					}
					if (payload.getCiudad() != null && !payload.getCiudad().isEmpty()) {
						oldEmisor.setCiudad(payload.getCiudad());
					}
					if (payload.getDireccion() != null && !payload.getDireccion().isEmpty()) {
						oldEmisor.setDireccion(payload.getDireccion());
					}
					if (payload.getCodigoResolucion() != null && !payload.getCodigoResolucion().isEmpty()) {
						oldEmisor.setCodigoResolucion(payload.getCodigoResolucion());
					}
					if (dateFechaResolucion != null) {
						oldEmisor.setFechaResolucion(dateFechaResolucion);
					}

					// Actualiza la fecha de actualización
					oldEmisor.setUpdatedat(ahora);

					// Almacena el emisor actualizado
					emisoresRepo.save(oldEmisor);

					if (payload.getActividades() != null && !payload.getActividades().isEmpty()) {
						// **Eliminar las actividades económicas anteriores**
						log.debug("Eliminando actividades económicas anteriores para el Emisor rut = " + oldEmisor.getRutemisor());
						List<EmisorActividad> actExistentes = emisorActRepo.findByEmisor(oldEmisor); // <-- Se eliminan las actividades actuales
						for (EmisorActividad act : actExistentes) {
							emisorActRepo.delete(act);
						}
						// **Agregar las nuevas actividades económicas**
						log.debug("Agregando nuevas actividades económicas al Emisor rut=" + oldEmisor.getRutemisor());
						List<String> actividades = payload.getActividades();
						boolean actividadValida = false;
						for (String act : actividades) {
							Optional<ActividadEconomica> actEconomica = actEconomicaRepo.findByCodigo(act);
							if (actEconomica.isPresent()) {
								EmisorActividad emisorAct = new EmisorActividad();
								emisorAct.setEmisor(oldEmisor); // Relaciona con el emisor
								emisorAct.setActividadEconomica(actEconomica.get());
								emisorActRepo.save(emisorAct); // Guarda la nueva actividad
								log.debug("Actividad Económica=" + act + " agregada al Emisor rut="
										+ oldEmisor.getRutemisor());
								actividadValida = true;
							} else {
								log.warn("Actividad Económica con código " + act + " no existe");
							}
						}

						// Si no se pudo agregar ninguna actividad válida, devolver un error
						if (!actividadValida) {
							log.error("No se agregó ninguna actividad económica válida");
							return ResponseEntity.badRequest()
									.body(JSend.error("Debe agregar al menos una actividad económica válida"));
						}
					}
					// Responde al caller
					log.debug("Emisor rut=" + oldEmisor.getRutemisor() + " actualizado con éxito");
					return ResponseEntity.ok().body(JSend.success("Emisor actualizado con éxito"));
				}
			} else {
				log.error("El emisor rut=" + payload.getRutemisor() + " NO existe");
				return ResponseEntity.badRequest().body(JSend.error("El Emisor no existe"));
			}

		} catch (Exception ex) {
			log.error("No fue posible actualizar el Emisor. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	public static Date convertToDateUsingInstant(LocalDate date) {
		return java.util.Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
}
