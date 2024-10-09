package cl.fapp.restapi.controller.clientes;

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
import cl.fapp.repository.model.Clientes;
import cl.fapp.repository.repos.ClientesRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.ProveedoresRepository;
import cl.fapp.restapi.controller.clientes.dto.ClientesRequest;
import cl.fapp.restapi.controller.clientes.dto.ClientesResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Service
public class ClientesController {

    @Autowired
    private EmisoresRepository emisoresRepository;

    @Autowired
    private ClientesRepository clientesRepo;

    ClientesController(ClientesRepository clientesRepo) {
        this.clientesRepo = clientesRepo;
    }

    private static final String SUCCESS = "success";

    /**
     * Agrega un cliente a partir del request a la api y la escribe en la base de
     * datos.
     * 
     * @param payload request para agregar clientes
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/agregarCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientesResponse> agregarCliente(@RequestBody ClientesRequest payload) {
        ClientesResponse response = new ClientesResponse();
        try {
            Emisores emisor = emisoresRepository.findByRutemisor(payload.getEmisor());
            if (emisor == null) {
                response.setStatus("fail");
                response.setMessage("Emisor no encontrado con el RUT especificado");
                return ResponseEntity.badRequest().body(response);
            }
            Clientes newCliente = new Clientes();
            Date ahora = new Date();

            newCliente.setRut(payload.getRut());
            newCliente.setRazonSocial(payload.getRazonSocial());
            newCliente.setDireccion(payload.getDireccion());
            newCliente.setEmail(payload.getEmail());
            newCliente.setTelefono(payload.getTelefono());
            newCliente.setEmisor(emisor);
            newCliente.setCreateDate(ahora);
            newCliente.setUpdateDate(ahora);

            Clientes savedCliente = clientesRepo.save(newCliente);
            Long createdId = savedCliente.getIdCliente();

            log.debug("cliente agregado con id =" + savedCliente.getIdCliente());

            response.setStatus(SUCCESS);
            response.setCreatedId(createdId);
            response.setMessage("cliente agregado correctamente con id = " + createdId);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al agregar al cliente", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Elimina un cliente a partir del request a la api y las elimina en la base
     * de
     * datos.
     * 
     * @param payload request para eliminar clientes
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/eliminarCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientesResponse> eliminarCliente(@RequestBody ClientesRequest payload) {
        ClientesResponse response = new ClientesResponse();
        try {
            Clientes cliente = clientesRepo.findById(payload.getIdCliente()).get();
            clientesRepo.delete(cliente);

            log.debug("cliente eliminado con id =" + cliente.getIdCliente());

            response.setStatus(SUCCESS);
            response.setMessage("cliente eliminado correctamente con id = " + cliente.getIdCliente());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al eliminar el cliente", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Actualiza un cliente a partir del request a la api y las actualiza en la
     * base de datos.
     * 
     * @param payload request para actualizar clientes
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/actualizarCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientesResponse> actualizarCliente(@RequestBody ClientesRequest payload) {
        ClientesResponse response = new ClientesResponse();
        try {
            Clientes cliente = clientesRepo.findById(payload.getIdCliente()).get();
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getEmisor());

            cliente.setRazonSocial(payload.getRazonSocial());
            cliente.setDireccion(payload.getDireccion());
            cliente.setEmail(payload.getEmail());
            cliente.setTelefono(payload.getTelefono());
            // cliente.setEmisor(emisor);
            cliente.setUpdateDate(ahora);

            Clientes updatedCliente = clientesRepo.save(cliente);

            log.debug("cliente actualizado con id =" + updatedCliente.getIdCliente());

            response.setStatus(SUCCESS);
            response.setMessage("cliente actualizado correctamente con id = " + updatedCliente.getIdCliente());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al actualizar al cliente", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Lista los clientes a partir del request a la API y los devuelve en un
     * JSON.
     * 
     * @param payload request para listar clientes
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/listarClientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSend> listarClientes(@Validated @RequestBody ClientesRequest payload) {
        try {
            Emisores emisor = emisoresRepository.findByRutemisor(payload.getEmisor());
            if (emisor == null) {
                return ResponseEntity.badRequest().body(JSend.fail("Emisor no encontrado con el RUT especificado"));
            }

            List<Clientes> listaClientes = clientesRepo.findByEmisor(emisor);

            List<Map<String, Object>> clientesJson = new ArrayList<>();

            for (Clientes cliente : listaClientes) {
                Map<String, Object> clientesMap = new HashMap<>();
                clientesMap.put("idCliente", cliente.getIdCliente());
                clientesMap.put("rut", cliente.getRut());
                clientesMap.put("razonSocial", cliente.getRazonSocial());
                clientesMap.put("direccion", cliente.getDireccion());
                clientesMap.put("email", cliente.getEmail());
                clientesMap.put("telefono", cliente.getTelefono());

                clientesJson.add(clientesMap);
            }

            if (listaClientes != null && !listaClientes.isEmpty()) {
                log.debug("Lista de clientes recuperada");
                return ResponseEntity.ok().body(JSend.success(clientesJson));
            } else {
                return ResponseEntity.ok()
                        .body(JSend.success("No se encontraron clientes para el cliente " + payload.getEmisor()));
            }
        } catch (Exception e) {
            log.error("No se pudo obtener la lista de clientes: ", e);
            return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
        }
    }
}
