package cl.fapp.restapi.controller.emisoractividad;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.repository.model.ActividadEconomica;
import cl.fapp.repository.model.EmisorActividad;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.ActividadEconomicaRepository;
import cl.fapp.repository.repos.EmisorActividadRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.emisoractividad.dto.EmisorActividadRequest;
import cl.fapp.restapi.controller.emisoractividad.dto.EmisorActividadResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}/emisorActividad")
public class EmisorActividadController {
    @Autowired
    private EmisoresRepository emisoresRepository;

    @Autowired
    private EmisorActividadRepository emisorActividadRepository;

    @Autowired
    private ActividadEconomicaRepository actividadEconomicaRepository;

    @PostMapping("/agregar")
    public ResponseEntity<EmisorActividadResponse> agregarEmisorActividad(@RequestBody EmisorActividadRequest request) {
        EmisorActividadResponse response = new EmisorActividadResponse();
        try {
            // Validar campos obligatorios
            if (request.getRutEmisor() == null || request.getRutEmisor().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El RUT es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            if (request.getCodigoActividad() == null || request.getCodigoActividad().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El código de actividad es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar emisor
            Emisores emisor = emisoresRepository.findByRutemisor(request.getRutEmisor());
            if (emisor == null) {
                response.setStatus("FAILED");
                response.setMessage("No se encontró el emisor con RUT " + request.getRutEmisor());
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar actividad económica
            Optional<ActividadEconomica> actividadEconomica = actividadEconomicaRepository
                    .findByCodigo(request.getCodigoActividad());
            if (actividadEconomica == null) {
                response.setStatus("FAILED");
                response.setMessage("No se encontró la actividad económica con código " + request.getCodigoActividad());
                return ResponseEntity.badRequest().body(response);
            }

            // Crear la relación entre el emisor y la actividad económica
            EmisorActividad emisorActividad = new EmisorActividad();
            emisorActividad.setEmisor(emisor);
            emisorActividad.setActividadEconomica(actividadEconomica.get());
            EmisorActividad saved = emisorActividadRepository.save(emisorActividad);

            response.setStatus("SUCCESS");
            response.setMessage("Se ha agregado la relación entre el emisor y la actividad económica. con id = "
                    + saved.getIdEmisorActividad());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/eliminar")
    public ResponseEntity<EmisorActividadResponse> eliminarEmisorActividad(
            @RequestBody EmisorActividadRequest request) {
        EmisorActividadResponse response = new EmisorActividadResponse();
        try {
            // Validar campos obligatorios
            if (request.getRutEmisor() == null || request.getRutEmisor().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El RUT es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            if (request.getCodigoActividad() == null || request.getCodigoActividad().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El código de actividad es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar emisor
            Emisores emisor = emisoresRepository.findByRutemisor(request.getRutEmisor());
            if (emisor == null) {
                response.setStatus("FAILED");
                response.setMessage("No se encontró el emisor con RUT " + request.getRutEmisor());
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar actividad económica
            Optional<ActividadEconomica> actividadEconomica = actividadEconomicaRepository
                    .findByCodigo(request.getCodigoActividad());
            if (actividadEconomica == null) {
                response.setStatus("FAILED");
                response.setMessage("No se encontró la actividad económica con código " + request.getCodigoActividad());
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar la relación entre el emisor y la actividad económica
            EmisorActividad emisorActividad = emisorActividadRepository.findByEmisorAndActividadEconomica(emisor,
                    actividadEconomica.get()).get(0);
            if (emisorActividad == null) {
                response.setStatus("FAILED");
                response.setMessage("No se encontró la relación entre el emisor y la actividad económica.");
                return ResponseEntity.badRequest().body(response);
            }

            // Eliminar la relación
            emisorActividadRepository.delete(emisorActividad);

            response.setStatus("SUCCESS");
            response.setMessage("Se ha eliminado la relación entre el emisor y la actividad económica.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error al eliminar la relacion ", e);
            response.setStatus("FAILED");
            response.setMessage("Error al eliminar la relación entre el emisor y la actividad económica.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/listarPorRut")
    public ResponseEntity<EmisorActividadResponse> listarPorRut(@RequestBody EmisorActividadRequest request) {
        EmisorActividadResponse response = new EmisorActividadResponse();
        try {
            // Validar campos obligatorios
            if (request.getRutEmisor() == null || request.getRutEmisor().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El RUT es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar el emisor
            Emisores emisor = emisoresRepository.findByRutemisor(request.getRutEmisor());
            if (emisor == null) {
                response.setStatus("FAILED");
                response.setMessage("No se encontró el emisor con RUT " + request.getRutEmisor());
                return ResponseEntity.badRequest().body(response);
            }

            // Buscar las actividades económicas asociadas al emisor
            List<EmisorActividad> emisorActividades = emisorActividadRepository.findByEmisor(emisor);

            // Extraer las actividades económicas de la entidad intermedia
            List<ActividadEconomica> actividades = new ArrayList<>();
            for (EmisorActividad emisorActividad : emisorActividades) {
                actividades.add(emisorActividad.getActividadEconomica());
            }

            // Configurar la respuesta con las actividades encontradas
            response.setActividadEconomica(actividades);
            response.setStatus("SUCCESS");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            log.error("Error al listar las actividades económicas del emisor", e);
            response.setStatus("FAILED");
            response.setMessage("Error al listar las actividades económicas del emisor.");
            return ResponseEntity.badRequest().body(response);
        }
    }
}
