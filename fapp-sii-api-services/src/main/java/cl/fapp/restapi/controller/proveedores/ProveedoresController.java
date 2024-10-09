package cl.fapp.restapi.controller.proveedores;

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
import cl.fapp.repository.model.Proveedores;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.ProveedoresRepository;
import cl.fapp.restapi.controller.proveedores.dto.ProveedoresRequest;
import cl.fapp.restapi.controller.proveedores.dto.ProveedoresResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Service
public class ProveedoresController {

    @Autowired
    private EmisoresRepository emisoresRepository;

    @Autowired
    private ProveedoresRepository proveedoresRepo;

    ProveedoresController(ProveedoresRepository proveedoresRepo) {
        this.proveedoresRepo = proveedoresRepo;
    }

    private static final String SUCCESS = "success";

    /**
     * Agrega un proveedor a partir del request a la api y la escribe en la base de
     * datos.
     * 
     * @param payload request para agregar proveedores
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/agregarProveedor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedoresResponse> agregarProveedor(@RequestBody ProveedoresRequest payload) {
        ProveedoresResponse response = new ProveedoresResponse();
        try {
            Proveedores newProveedor = new Proveedores();
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getEmisor());
            newProveedor.setRut(payload.getRut());
            newProveedor.setRazonSocial(payload.getRazonSocial());
            newProveedor.setDireccion(payload.getDireccion());
            newProveedor.setEmail(payload.getEmail());
            newProveedor.setTelefono(payload.getTelefono());
            newProveedor.setEmisor(emisor);
            newProveedor.setCreateDate(ahora);
            newProveedor.setUpdateDate(ahora);

            Proveedores savedProveedor = proveedoresRepo.save(newProveedor);
            Long createdId = savedProveedor.getIdProveedor();

            log.debug("Proveedor agregado con id =" + savedProveedor.getIdProveedor());

            response.setStatus(SUCCESS);
            response.setCreatedId(createdId);
            response.setMessage("Proveedor agregado correctamente con id = " + createdId);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al agregar provedor", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Elimina un proveedor a partir del request a la api y las elimina en la base
     * de
     * datos.
     * 
     * @param payload request para eliminar proveedores
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/eliminarProveedor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedoresResponse> eliminarProveedor(@RequestBody ProveedoresRequest payload) {
        ProveedoresResponse response = new ProveedoresResponse();
        try {
            Proveedores provedor = proveedoresRepo.findById(payload.getIdProveedor()).get();
            proveedoresRepo.delete(provedor);

            log.debug("Proveedor eliminado con id =" + provedor.getIdProveedor());

            response.setStatus(SUCCESS);
            response.setMessage("Proveedor eliminado correctamente con id = " + provedor.getIdProveedor());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al eliminar el proveedor", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Actualiza un provedor a partir del request a la api y las actualiza en la
     * base de datos.
     * 
     * @param payload request para actualizar proveedores
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/actualizarProveedor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProveedoresResponse> actualizarProveedor(@RequestBody ProveedoresRequest payload) {
        ProveedoresResponse response = new ProveedoresResponse();
        try {
            Proveedores proveedor = proveedoresRepo.findById(payload.getIdProveedor()).get();
            if (proveedor == null) {
                response.setStatus("fail");
                response.setMessage("Proveedor no encontrado con id = " + payload.getIdProveedor());
                return ResponseEntity.badRequest().body(response);
            }
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getEmisor());
            proveedor.setRut(payload.getRut());
            proveedor.setRazonSocial(payload.getRazonSocial());
            proveedor.setDireccion(payload.getDireccion());
            proveedor.setEmail(payload.getEmail());
            proveedor.setTelefono(payload.getTelefono());
            // proveedor.setEmisor(emisor);
            proveedor.setUpdateDate(ahora);

            Proveedores updatedProveedor = proveedoresRepo.save(proveedor);

            log.debug("Proveedor actualizado con id =" + updatedProveedor.getIdProveedor());

            response.setStatus(SUCCESS);
            response.setMessage("Proveedor actualizado correctamente con id = " + updatedProveedor.getIdProveedor());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al actualizar provedor", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Lista los proveedores a partir del request a la API y los devuelve en un
     * JSON.
     * 
     * @param payload request para listar proveedores
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/listarProveedores", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSend> listarProveedores(@Validated @RequestBody ProveedoresRequest payload) {
        try {
            Emisores emisor = emisoresRepository.findByRutemisor(payload.getEmisor());
            if (emisor == null) {
                return ResponseEntity.badRequest().body(JSend.fail("Emisor no encontrado con el RUT especificado"));
            }

            List<Proveedores> listaProveedores = proveedoresRepo.findByEmisor(emisor);
            List<Map<String, Object>> proveedoresJson = new ArrayList<>();

            for (Proveedores proveedor : listaProveedores) {
                Map<String, Object> proveedoresMap = new HashMap<>();
                proveedoresMap.put("idProveedor", proveedor.getIdProveedor());
                proveedoresMap.put("rut", proveedor.getRut());
                proveedoresMap.put("razonSocial", proveedor.getRazonSocial());
                proveedoresMap.put("direccion", proveedor.getDireccion());
                proveedoresMap.put("email", proveedor.getEmail());
                proveedoresMap.put("telefono", proveedor.getTelefono());
                proveedoresMap.put("emisor", proveedor.getEmisor().getRutemisor());
                proveedoresMap.put("createDate", proveedor.getCreateDate());
                proveedoresMap.put("updateDate", proveedor.getUpdateDate());

                proveedoresJson.add(proveedoresMap);
            }

            if (listaProveedores != null && !listaProveedores.isEmpty()) {
                log.debug("Lista de proveedores recuperada");
                return ResponseEntity.ok().body(JSend.success(proveedoresJson));
            } else {
                return ResponseEntity.ok()
                        .body(JSend.success("No se encontraron proveedores para el cliente " + payload.getEmisor()));
            }
        } catch (Exception e) {
            log.error("No se pudo obtener la lista de proveedores: ", e);
            return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
        }
    }
}
