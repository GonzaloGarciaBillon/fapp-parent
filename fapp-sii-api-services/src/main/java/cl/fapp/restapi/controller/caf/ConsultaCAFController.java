package cl.fapp.restapi.controller.caf;

import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.repository.model.Caf;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Bitacora;
import cl.fapp.repository.model.BposSucursal;
import cl.fapp.repository.repos.CAFRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.BitacoraRepository;
import cl.fapp.repository.repos.BposSucursalRepository;
import cl.fapp.restapi.controller.caf.dto.ConsultaCAFRequest;
import cl.fapp.restapi.controller.caf.dto.ConsultaCAFResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name="CAF", description="API para operaciones relacionadas al CAF")
public class ConsultaCAFController {

    @Autowired
    CAFRepository repository;

    @Autowired
    EmisoresRepository emisoresRepo;

	@Autowired
	BposSucursalRepository bposSucursalRepository;

	@Autowired
	BitacoraRepository bitacoraRepository;

    /**
     * Consulta datos del CAF para un Emisor y Tipo de documento específico.
     * @param rutEmisor Rut del emisor para la búsqueda.
     * @param tipoDocumento Tipo de documento asociado al CAF.
     * @return estructura JSend simple con los datos del CAF o un error.
     */
	@PostMapping(value = "/reserva-caf", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<ConsultaCAFResponse> getCAF(@RequestBody ConsultaCAFRequest payload) {
        log.info("Iniciando consulta de CAF para rutEmisor={} y tipoDocumento={}, cantidadFolios={}", 
                 payload.getRutEmisor(), payload.getTipoDocumento(), payload.getCantidadFolios());
                 
        ConsultaCAFResponse response = new ConsultaCAFResponse();
        try {
            log.debug("Verificando si el emisor con rut={} existe en la base de datos", payload.getRutEmisor());
            
            // Verifica que el emisor existe en la base de datos
            Optional<Emisores> emisor = emisoresRepo.findById(payload.getRutEmisor());
            if (!emisor.isPresent()) {
                log.error("El emisor con rut={} no existe en la base de datos", payload.getRutEmisor());
                response.setMessage("El emisor no existe en la base de datos");
                return ResponseEntity.badRequest().body(response);
            }
            log.debug("Emisor con rut={} encontrado exitosamente", payload.getRutEmisor());

			Optional<BposSucursal> sucursal = bposSucursalRepository.findBySerieBpos(payload.getSucursal());
			if (!sucursal.isPresent()) {
				log.error("La sucursal con id={} no existe en la base de datos", payload.getSucursal());
				response.setMessage("La sucursal no existe en la base de datos");
				return ResponseEntity.badRequest().body(response);
			}
            // Verifica que la cantidad de folios solicitada es válida
            if (payload.getCantidadFolios() == null || payload.getCantidadFolios() <= 0) {
                log.error("La cantidad de folios solicitada no es válida: cantidadFolios={}", payload.getCantidadFolios());
                response.setMessage("La cantidad de folios solicitada no es válida");
                return ResponseEntity.badRequest().body(response);
            }

            // Busca el CAF por el rutEmisor, tipo de documento y estado DISPONIBLE
            Optional<Caf> cafOptional = repository.findByEmisoreRutemisorAndTipoDocumentoAndEstado(payload.getRutEmisor(), payload.getTipoDocumento(), "DISPONIBLE");
            if (!cafOptional.isPresent()) {
                log.error("No se encontró un CAF disponible para el emisor con rut={} y tipo de documento={}", payload.getRutEmisor(), payload.getTipoDocumento());
                response.setMessage("No se encontró un CAF disponible para el emisor y tipo de documento especificado");
                return ResponseEntity.badRequest().body(response);
            }

            Caf caf = cafOptional.get();
			Integer cantidadFolios = 0;
            // Verifica si hay suficientes folios disponibles
            if (payload.getCantidadFolios() > caf.getDisponibles()) {
                cantidadFolios = caf.getDisponibles();
            }else{
				cantidadFolios = payload.getCantidadFolios();
			}

            // Cálculo del nuevo folioMin para la respuesta (según los disponibles)
            Long folioMinCalculado = caf.getFolioMax() - caf.getDisponibles() + 1;

            // Cálculo temporal del nuevo folioMax basado en el folioMin calculado y la cantidad solicitada
            Long folioMaxTemporal = folioMinCalculado + cantidadFolios - 1;

            // Solo restar la cantidad de folios solicitados de los disponibles
			Integer foliosRestantes = caf.getDisponibles() - cantidadFolios;
			if(foliosRestantes <= 0){
				caf.setEstado("UTILIZADO");
			}
			caf.setDisponibles(foliosRestantes);

            // Guardamos los cambios solo en los folios disponibles (sin modificar folioMin o folioMax en la BD)
            repository.save(caf);

            // Modificamos la respuesta para incluir el folioMin calculado y el folioMax temporal
            log.info("CAF reservado exitosamente para la cantidad de folios: cantidadFolios={}, folioMinCalculado={}, folioMaxTemporal={}", 
                     payload.getCantidadFolios(), folioMinCalculado, folioMaxTemporal);

            // Crear una copia temporal del objeto CAF original para la respuesta y modificar algunos campos para el response
            Caf cafResponse = new Caf();

            cafResponse.setFolioMin(folioMinCalculado);  // folioMin calculado solo para el response
            cafResponse.setFolioMax(folioMaxTemporal);  // folioMax solo para el response
            cafResponse.setDisponibles(cantidadFolios);  // Mostramos la cantidad solicitada en lugar de la real
			cafResponse.setEmisore(caf.getEmisore());
			cafResponse.setTipoDocumento(caf.getTipoDocumento());
			cafResponse.setEstado("DISPONIBLE");
			cafResponse.setTagAutorizacion(caf.getTagAutorizacion());
			cafResponse.setTagCaf(caf.getTagCaf());
			cafResponse.setTagRsask(caf.getTagRsask());

            Date now = new Date();
            cafResponse.setCreatedat(now);  // Fecha de creación actualizada para la respuesta
            cafResponse.setUpdatedat(now);  // Fecha de actualización actualizada para la respuesta

			//Se guarda registro en bitacora
            Bitacora bitacora = new Bitacora();
            bitacora.setEstado(caf.getEstado());
            bitacora.setProceso("/reserva-caf");
            bitacora.setFechaActualizacion(now);
            bitacora.setModelo("CAF");
			bitacora.setIdModelo(caf.getIdCaf().toString());
			String detalle = cantidadFolios+" folios reservados desde "+folioMinCalculado+" hasta "+folioMaxTemporal+" para la sucursal "+sucursal.get().getNombre()+" con "+payload.getCantidadFolios()+" folios solicitados.";
			bitacora.setDetalle(detalle);
			bitacoraRepository.save(bitacora);

            response.setMessage("CAF reservado exitosamente");
			if (payload.getCantidadFolios() > caf.getDisponibles()) {
                response.setMessage("CAF reservado exitosamente, pero solo se reservaron "+cantidadFolios+" folios.");
            }else{
				response.setMessage("CAF reservado exitosamente.");
			}
            response.setCaf(cafResponse);  // Enviamos el CAF con la cantidad solicitada y fechas actualizadas
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("Error al procesar la solicitud de reserva de CAF para rutEmisor={} y tipoDocumento={}: {}", payload.getRutEmisor(), payload.getTipoDocumento(), e.getMessage(), e);
            response.setMessage("Error al procesar la solicitud de reserva de CAF");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
