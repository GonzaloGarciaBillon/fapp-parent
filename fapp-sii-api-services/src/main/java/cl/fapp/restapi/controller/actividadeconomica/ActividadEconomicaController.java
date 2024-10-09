package cl.fapp.restapi.controller.actividadeconomica;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.repository.model.ActividadEconomica;
import cl.fapp.repository.model.SubRubro;
import cl.fapp.repository.repos.ActividadEconomicaRepository;
import cl.fapp.repository.repos.SubRubroRepository;
import cl.fapp.restapi.controller.actividadeconomica.dto.ActividadEconomicaRequest;
import cl.fapp.restapi.controller.actividadeconomica.dto.ActividadEconomicaResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequestMapping("${fapp.api.controller.base-path}/actividadEconomica")
public class ActividadEconomicaController {
    @Autowired
    private ActividadEconomicaRepository actEconomicaRepo;

    @Autowired
    private SubRubroRepository subRubroRepository;

    @PostMapping("/agregar")
    public ResponseEntity<ActividadEconomicaResponse> agregarActividad(@RequestBody ActividadEconomicaRequest request) {
        ActividadEconomicaResponse response = new ActividadEconomicaResponse();
        try {
            // Validar campos obligatorios
            if (request.getCodigo() == null || request.getCodigo().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El código es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            if (request.getActividad() == null || request.getActividad().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("La actividad es obligatoria.");
                return ResponseEntity.badRequest().body(response);
            }

            if (request.getAfectaIva() == null || request.getAfectaIva().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El campo afecta IVA es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            if (request.getCategoriaTributaria() == null || request.getCategoriaTributaria().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("La categoría tributaria es obligatoria.");
                return ResponseEntity.badRequest().body(response);
            }

            // Validar que el código no exista previamente
            if (actEconomicaRepo.existsByCodigo(request.getCodigo())) {
                response.setStatus("FAILED");
                response.setMessage("El código ya existe en el sistema.");
                return ResponseEntity.badRequest().body(response);
            }

            // Crear una nueva entidad de ActividadEconomica
            ActividadEconomica actividadEconomica = new ActividadEconomica();
            actividadEconomica.setCodigo(request.getCodigo());
            actividadEconomica.setActividad(request.getActividad());
            actividadEconomica.setAfectaIva(request.getAfectaIva());
            actividadEconomica.setCategoriaTributaria(request.getCategoriaTributaria());
            actividadEconomica.setDisponibleInternet(request.isDisponibleInternet());

            // Validar y asignar el SubRubro si existe
            SubRubro subRubro = subRubroRepository.findById(request.getSubRubro())
                    .orElseThrow(() -> new RuntimeException("SubRubro no encontrado."));
            actividadEconomica.setSubRubro(subRubro);

            // Guardar la entidad en la base de datos
            actividadEconomica = actEconomicaRepo.save(actividadEconomica);

            // Preparar el Response
            response.setId(actividadEconomica.getIdActividadEconomica());
            response.setStatus("SUCCESS");
            response.setMessage("Actividad económica agregada exitosamente.");

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al agregar Actividad Economica", e);
            response.setStatus("FAILED");
            response.setMessage("Ocurrió un error inesperado al agregar la actividad económica.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ActividadEconomicaResponse> actualizarActividad(
            @PathVariable Long id,
            @RequestBody ActividadEconomicaRequest request) {

        ActividadEconomicaResponse response = new ActividadEconomicaResponse();
        try {
            // Buscar la actividad económica por id
            ActividadEconomica actividadExistente = actEconomicaRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Actividad económica no encontrada."));

            // Validar y actualizar los campos
            if (request.getCodigo() == null || request.getCodigo().isEmpty()) {
                response.setStatus("FAILED");
                response.setMessage("El código es obligatorio.");
                return ResponseEntity.badRequest().body(response);
            }

            actividadExistente.setCodigo(request.getCodigo());
            actividadExistente.setActividad(request.getActividad());
            actividadExistente.setAfectaIva(request.getAfectaIva());
            actividadExistente.setCategoriaTributaria(request.getCategoriaTributaria());
            actividadExistente.setDisponibleInternet(request.isDisponibleInternet());

            // Validar y asignar el SubRubro si existe
            SubRubro subRubro = subRubroRepository.findById(request.getSubRubro())
                    .orElseThrow(() -> new RuntimeException("SubRubro no encontrado."));
            actividadExistente.setSubRubro(subRubro);

            // Guardar la actividad actualizada
            actEconomicaRepo.save(actividadExistente);

            // Preparar el response
            response.setId(actividadExistente.getIdActividadEconomica());
            response.setStatus("SUCCESS");
            response.setMessage("Actividad económica actualizada exitosamente.");

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al actualizar la Actividad Económica", e);
            response.setStatus("FAILED");
            response.setMessage("Ocurrió un error inesperado al actualizar la actividad económica.");
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ActividadEconomicaResponse>> listarActividades() {
        List<ActividadEconomicaResponse> responses = new ArrayList<>();

        try {
            List<ActividadEconomica> actividades = actEconomicaRepo.findAll();

            // Convertir cada entidad en un objeto de respuesta completo
            for (ActividadEconomica actividad : actividades) {
                ActividadEconomicaResponse response = new ActividadEconomicaResponse();
                response.setId(actividad.getIdActividadEconomica());
                response.setStatus("SUCCESS");
                response.setMessage("Actividad encontrada.");

                // Llenar los detalles de la actividad económica
                response.setCodigo(actividad.getCodigo());
                response.setActividad(actividad.getActividad());
                response.setAfectaIva(actividad.getAfectaIva());
                response.setCategoriaTributaria(actividad.getCategoriaTributaria());
                response.setDisponibleInternet(actividad.getDisponibleInternet());
                response.setSubRubro(actividad.getSubRubro() != null ? actividad.getSubRubro().getIdSubRubro() : null);

                responses.add(response);
            }

            return ResponseEntity.ok().body(responses);
        } catch (Exception e) {
            log.error("Error al listar las Actividades Económicas", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ActividadEconomicaResponse> eliminarActividad(@PathVariable Long id) {
        ActividadEconomicaResponse response = new ActividadEconomicaResponse();
        try {
            // Verificar si la actividad económica existe
            ActividadEconomica actividadEconomica = actEconomicaRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Actividad económica no encontrada."));

            // Eliminar la actividad económica
            actEconomicaRepo.delete(actividadEconomica);

            // Preparar la respuesta
            response.setId(actividadEconomica.getIdActividadEconomica());
            response.setStatus("SUCCESS");
            response.setMessage("Actividad económica eliminada exitosamente.");

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al eliminar la Actividad Económica", e);
            response.setStatus("FAILED");
            response.setMessage("Ocurrió un error inesperado al eliminar la actividad económica.");
            return ResponseEntity.badRequest().body(response);
        }
    }

}
