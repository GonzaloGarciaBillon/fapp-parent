package cl.fapp.restapi.controller.recepciones;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.RecepcionRepository;
import cl.fapp.restapi.controller.recepciones.dto.RecepcionesRequest;
import cl.fapp.restapi.controller.recepciones.dto.RecepcionesResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Service
public class RecepcionesController {

    @Autowired
    private EmisoresRepository emisoresRepository;

    @Autowired
    private RecepcionRepository recepcionesRepo;

    RecepcionesController(RecepcionRepository recepcionesRepo) {
        this.recepcionesRepo = recepcionesRepo;
    }

    private static final String SUCCESS = "success";

    /**
     * Agrega una recepcion a partir del request a la api y la escribe en la base de
     * datos.
     * 
     * @param payload request para agregar recepcion
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/agregarRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecepcionesResponse> agregarRecepcion(@RequestBody RecepcionesRequest payload) {
        RecepcionesResponse response = new RecepcionesResponse();
        try {
            Recepcion newRecepcion = new Recepcion();
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getRutReceptor());
            newRecepcion.setFrom(payload.getFrom());
            newRecepcion.setTo(payload.getTo());
            newRecepcion.setSubject(payload.getSubject());
            newRecepcion.setDate(payload.getDate());
            newRecepcion.setCc(payload.getCc());
            newRecepcion.setReplyTo(payload.getReplyTo());
            newRecepcion.setMessageId(payload.getMessageId());
            newRecepcion.setReceived(payload.getReceived());
            newRecepcion.setDkimSignature(payload.getDkimSignature());
            newRecepcion.setContentType(payload.getContentType());
            newRecepcion.setReturnPath(payload.getReturnPath());
            newRecepcion.setAutoSubmitted(payload.getAutoSubmitted());
            newRecepcion.setRutEnvia(payload.getRutEnvia());
            newRecepcion.setRutReceptor(emisor);
            newRecepcion.setTpoDTE(payload.getTpoDTE());
            newRecepcion.setNroDTE(payload.getNroDTE());
            newRecepcion.setTmstFirmaEnv(payload.getTmstFirmaEnv());
            newRecepcion.setXml(payload.getXml());
            newRecepcion.setRutEmisor(payload.getEmisor());
            newRecepcion.setCreateDate(ahora);
            newRecepcion.setUpdateDate(ahora);

            Recepcion savedRecepcion = recepcionesRepo.save(newRecepcion);
            Long createdId = savedRecepcion.getIdRecepcion();

            log.debug("Recepcion agregada con id =" + savedRecepcion.getIdRecepcion());

            response.setStatus(SUCCESS);
            response.setCreatedId(createdId);
            response.setMessage("Recepcion agregada correctamente con id = " + createdId);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al agregar la recepcion", e);
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
    @PostMapping(value = "/eliminarRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecepcionesResponse> eliminarRecepcion(@RequestBody RecepcionesRequest payload) {
        RecepcionesResponse response = new RecepcionesResponse();
        try {
            Recepcion recepcion = recepcionesRepo.findById(payload.getIdRecepcion()).get();
            recepcionesRepo.delete(recepcion);

            log.debug("Recepcion eliminada con id =" + recepcion.getIdRecepcion());

            response.setStatus(SUCCESS);
            response.setMessage("Recepcion eliminada correctamente con id = " + recepcion.getIdRecepcion());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al eliminar la recepcion", e);
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
    @PostMapping(value = "/actualizarRecepcion", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RecepcionesResponse> actualizarRecepcion(@RequestBody RecepcionesRequest payload) {
        RecepcionesResponse response = new RecepcionesResponse();
        try {
            Recepcion recepcion = recepcionesRepo.findById(payload.getIdRecepcion()).get();
            if (recepcion == null) {
                response.setStatus("fail");
                response.setMessage("Recepcion no encontrada con id = " + payload.getIdRecepcion());
                return ResponseEntity.badRequest().body(response);
            }
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getRutReceptor());

            recepcion.setFrom(payload.getFrom());
            recepcion.setTo(payload.getTo());
            recepcion.setSubject(payload.getSubject());
            recepcion.setDate(payload.getDate());
            recepcion.setCc(payload.getCc());
            recepcion.setReplyTo(payload.getReplyTo());
            recepcion.setMessageId(payload.getMessageId());
            recepcion.setReceived(payload.getReceived());
            recepcion.setDkimSignature(payload.getDkimSignature());
            recepcion.setContentType(payload.getContentType());
            recepcion.setReturnPath(payload.getReturnPath());
            recepcion.setAutoSubmitted(payload.getAutoSubmitted());
            recepcion.setXml(payload.getXml());
            recepcion.setRutEnvia(payload.getRutEnvia());
            recepcion.setRutReceptor(emisor);
            recepcion.setTpoDTE(payload.getTpoDTE());
            recepcion.setNroDTE(payload.getNroDTE());
            recepcion.setTmstFirmaEnv(payload.getTmstFirmaEnv());

            // recepcion.setEmisor(emisor);
            recepcion.setUpdateDate(ahora);

            Recepcion updatedRecepcion = recepcionesRepo.save(recepcion);

            log.debug("Recepcion actualizada con id =" + updatedRecepcion.getIdRecepcion());

            response.setStatus(SUCCESS);
            response.setMessage("Recepcion actualizada correctamente con id = " + updatedRecepcion.getIdRecepcion());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al actualizar la recepcion", e);
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
    @PostMapping(value = "/listarRecepciones", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSend> listarRecepciones(@Validated @RequestBody RecepcionesRequest payload) {
        try {
            Emisores emisor = emisoresRepository.findByRutemisor(payload.getEmisor());
            if (emisor == null) {
                return ResponseEntity.badRequest().body(JSend.fail("Emisor no encontrado con el RUT especificado"));
            }

            List<Recepcion> listaRecepciones = recepcionesRepo.findByRutReceptor(emisor);
            List<Map<String, Object>> recepcionesJson = new ArrayList<>();

            for (Recepcion recepcion : listaRecepciones) {
                Map<String, Object> recepcionesMap = new HashMap<>();
                recepcionesMap.put("idRecepcion", recepcion.getIdRecepcion());
                recepcionesMap.put("from", recepcion.getFrom());
                recepcionesMap.put("to", recepcion.getTo());
                recepcionesMap.put("subject", recepcion.getSubject());
                recepcionesMap.put("date", recepcion.getDate());
                recepcionesMap.put("cc", recepcion.getCc());
                recepcionesMap.put("replyTo", recepcion.getReplyTo());
                recepcionesMap.put("messageId", recepcion.getMessageId());
                recepcionesMap.put("received", recepcion.getReceived());
                recepcionesMap.put("dkimSignature", recepcion.getDkimSignature());
                recepcionesMap.put("contentType", recepcion.getContentType());
                recepcionesMap.put("returnPath", recepcion.getReturnPath());
                recepcionesMap.put("autoSubmitted", recepcion.getAutoSubmitted());
                recepcionesMap.put("rutEnvia", recepcion.getRutEnvia());
                recepcionesMap.put("rutReceptor", recepcion.getRutReceptor().getRutemisor());
                recepcionesMap.put("tpoDTE", recepcion.getTpoDTE());
                recepcionesMap.put("nroDTE", recepcion.getNroDTE());
                recepcionesMap.put("tmstFirmaEnv", recepcion.getTmstFirmaEnv());
                recepcionesMap.put("xml", recepcion.getXml());
                recepcionesMap.put("rutEmisor", recepcion.getRutEmisor());
                recepcionesMap.put("createDate", recepcion.getCreateDate());
                recepcionesMap.put("updateDate", recepcion.getUpdateDate());

                recepcionesJson.add(recepcionesMap);
            }

            if (listaRecepciones != null && !listaRecepciones.isEmpty()) {
                log.debug("Lista de recepciones recuperada");
                return ResponseEntity.ok().body(JSend.success(recepcionesJson));
            } else {
                return ResponseEntity.ok()
                        .body(JSend.success("No se encontraron recepciones para el cliente " + payload.getEmisor()));
            }
        } catch (Exception e) {
            log.error("No se pudo obtener la lista de recepciones: ", e);
            return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
        }
    }
}
