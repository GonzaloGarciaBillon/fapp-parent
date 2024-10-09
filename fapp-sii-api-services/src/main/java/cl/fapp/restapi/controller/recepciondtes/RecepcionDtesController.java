package cl.fapp.restapi.controller.recepciondtes;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Recepcion;
import cl.fapp.repository.model.RecepcionDte;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.RecepcionDteRepository;
import cl.fapp.repository.repos.RecepcionRepository;
import cl.fapp.restapi.controller.recepciondtes.dto.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Service
public class RecepcionDtesController {

    private final EmisoresRepository emisoresRepository;
    private final RecepcionRepository recepcionRepository;
    private final RecepcionDteRepository recepcionDtesRepo;

    RecepcionDtesController(EmisoresRepository emisoresRepository, RecepcionRepository recepcionRepository,
            RecepcionDteRepository recepcionDtesRepo) {
        this.emisoresRepository = emisoresRepository;
        this.recepcionRepository = recepcionRepository;
        this.recepcionDtesRepo = recepcionDtesRepo;
    }

    private static final String SUCCESS = "success";

    /**
     * Agrega una recepcion a partir del request a la api y la escribe en la base de
     * datos.
     * 
     * @param payload request para agregar recepcion
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/agregarDteRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecepcionDtesResponse> agregarRecepcionDte(@RequestBody RecepcionDtesRequest payload) {
        RecepcionDtesResponse response = new RecepcionDtesResponse();
        try {
            RecepcionDte newRecepcionDte = new RecepcionDte();
            Date ahora = new Date();

            Emisores emisor = emisoresRepository.findByRutemisor(payload.getRutReceptor());
            if (emisor == null) {
                response.setStatus("fail");
                response.setMessage("Emisor no encontrado con rut = " + payload.getRutReceptor());
                return ResponseEntity.badRequest().body(response);
            }

            Recepcion recepcion = recepcionRepository.findById(payload.getIdRecepcion()).get();
            if (recepcion == null) {
                response.setStatus("fail");
                response.setMessage("Recepcion no encontrada con id = " + payload.getIdRecepcion());
                return ResponseEntity.badRequest().body(response);
            }

            newRecepcionDte.setRutEmisor(payload.getRutEmisor());
            newRecepcionDte.setRutReceptor(emisor);
            newRecepcionDte.setEstado(payload.getEstado());
            newRecepcionDte.setFolioAsignado(payload.getFolioAsignado());
            newRecepcionDte.setTipoDocumento(payload.getTipoDocumento());
            newRecepcionDte.setMonto(payload.getMonto());
            newRecepcionDte.setDocumentoXml(payload.getDocumentoXml());
            newRecepcionDte.setFchEmis(payload.getFchEmis());
            newRecepcionDte.setFchFirma(payload.getFchFirma());
            newRecepcionDte.setRecepcion(recepcion);
            newRecepcionDte.setCreatedate(ahora);
            newRecepcionDte.setUpdatedate(ahora);

            RecepcionDte savedRecepcionDte = recepcionDtesRepo.save(newRecepcionDte);
            Long createdId = savedRecepcionDte.getIdRecepcionDte();

            log.debug("Recepcion agregada con id =" + savedRecepcionDte.getIdRecepcionDte());

            response.setStatus(SUCCESS);
            response.setCreatedId(createdId);
            response.setMessage("DTE de Recepcion agregado correctamente con id = " + createdId);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al agregar el DTE de recepcion", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Elimina una recepcion a partir del request a la api y las elimina en la base
     * de
     * datos.
     * 
     * @param payload request para eliminar recepciones
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/eliminarDteRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecepcionDtesResponse> eliminarRecepcionDte(@RequestBody RecepcionDtesRequest payload) {
        RecepcionDtesResponse response = new RecepcionDtesResponse();
        try {
            RecepcionDte recepcionDte = recepcionDtesRepo.findById(payload.getIdRecepcionDte()).get();
            recepcionDtesRepo.delete(recepcionDte);

            log.debug("DTE de recepcion eliminado con id =" + recepcionDte.getIdRecepcionDte());

            response.setStatus(SUCCESS);
            response.setMessage(
                    "DTE de recepcion eliminado correctamente con id = " + recepcionDte.getIdRecepcionDte());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al eliminar el DTE de recepcion", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Actualiza un recepcion a partir del request a la api y las actualiza en la
     * base de datos.
     * 
     * @param payload request para actualizar una recepcion
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/actualizarDteRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecepcionDtesResponse> actualizarRecepcionDte(@RequestBody RecepcionDtesRequest payload) {
        RecepcionDtesResponse response = new RecepcionDtesResponse();
        try {
            RecepcionDte recepcionDte = recepcionDtesRepo.findById(payload.getIdRecepcionDte()).get();
            if (recepcionDte == null) {
                response.setStatus("fail");
                response.setMessage("DTE de recepcion no encontrado con id = " + payload.getIdRecepcionDte());
                return ResponseEntity.badRequest().body(response);
            }
            Date ahora = new Date();

            recepcionDte.setEstado(payload.getEstado());
            recepcionDte.setFolioAsignado(payload.getFolioAsignado());
            recepcionDte.setTipoDocumento(payload.getTipoDocumento());
            recepcionDte.setMonto(payload.getMonto());
            recepcionDte.setDocumentoXml(payload.getDocumentoXml());
            recepcionDte.setFchEmis(payload.getFchEmis());
            recepcionDte.setFchFirma(payload.getFchFirma());

            // recepcion.setEmisor(emisor);
            recepcionDte.setUpdatedate(ahora);

            RecepcionDte updatedRecepcionDte = recepcionDtesRepo.save(recepcionDte);

            log.debug("DTE de recepcion actualizado con id =" + updatedRecepcionDte.getIdRecepcionDte());

            response.setStatus(SUCCESS);
            response.setMessage(
                    "DTE de recepcion actualizado correctamente con id = " + updatedRecepcionDte.getIdRecepcionDte());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al actualizar el DTE de recepcion", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Lista los recepciones a partir del request a la API y los devuelve en un
     * JSON.
     * 
     * @param payload request para listar recepciones
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/listarDtesRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSend> listarDtesRecepcion(@Validated @RequestBody RecepcionDtesRequest payload) {
        try {
            Emisores emisor = emisoresRepository.findByRutemisor(payload.getRutEmisor());
            if (emisor == null) {
                return ResponseEntity.badRequest().body(JSend.fail("Emisor no encontrado con el RUT especificado"));
            }

            List<RecepcionDte> listaRecepcionDtes = recepcionDtesRepo.findByRutReceptor(emisor);
            List<Map<String, Object>> recepcionDtesJson = new ArrayList<>();

            for (RecepcionDte recepcionDte : listaRecepcionDtes) {
                Map<String, Object> recepcionDtesMap = new HashMap<>();
                recepcionDtesMap.put("idRecepcionDte", recepcionDte.getIdRecepcionDte());
                recepcionDtesMap.put("rutEmisor", recepcionDte.getRutEmisor());
                recepcionDtesMap.put("rutReceptor", emisor.getRutemisor());
                recepcionDtesMap.put("estado", recepcionDte.getEstado());
                recepcionDtesMap.put("folioAsignado", recepcionDte.getFolioAsignado());
                recepcionDtesMap.put("tipoDocumento", recepcionDte.getTipoDocumento());
                recepcionDtesMap.put("monto", recepcionDte.getMonto());
                recepcionDtesMap.put("documentoXml", recepcionDte.getDocumentoXml());
                recepcionDtesMap.put("fchEmis", recepcionDte.getFchEmis());
                recepcionDtesMap.put("fchFirma", recepcionDte.getFchFirma());
                recepcionDtesMap.put("createdat", recepcionDte.getCreatedate());
                recepcionDtesMap.put("updatedat", recepcionDte.getUpdatedate());
                log.debug(recepcionDtesMap.toString());

                recepcionDtesJson.add(recepcionDtesMap);
            }

            if (listaRecepcionDtes != null && !listaRecepcionDtes.isEmpty()) {
                log.debug("Lista de recepciones recuperada");
                return ResponseEntity.ok().body(JSend.success(recepcionDtesJson));
            } else {
                return ResponseEntity.ok()
                        .body(JSend.success(
                                "No se encontraron DTES de recepcion para el cliente " + payload.getRutReceptor()));
            }
        } catch (Exception e) {
            log.error("No se pudo obtener la lista de DTE de recepcion: ", e);
            return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
        }
    }
}
