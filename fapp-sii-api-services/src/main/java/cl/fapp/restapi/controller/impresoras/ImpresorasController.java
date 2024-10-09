package cl.fapp.restapi.controller.impresoras;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import org.hibernate.mapping.Map;
import cl.fapp.restapi.controller.impresoras.dto.ImpresorasResponse;
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
import cl.fapp.repository.model.Impresoras;
import cl.fapp.repository.repos.ImpresorasRepository;
import cl.fapp.restapi.controller.impresoras.dto.ImpresorasRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Service
public class ImpresorasController {

	final ImpresorasRepository impresorasRepo;

	ImpresorasController(ImpresorasRepository impresorasRepo) {
		this.impresorasRepo = impresorasRepo;
	}

	/**
	 * Agrega impresora a partir del request a la api y la escribe en la base de
	 * datos.
	 * 
	 * @param payload request para agregar impresoras
	 * @return objeto {@link JSend} simple
	 */
	@PostMapping(value = "/agregarImpresora", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ImpresorasResponse> agregarImpresora(@RequestBody ImpresorasRequest payload) {
		ImpresorasResponse response = new ImpresorasResponse();
		try {
			Impresoras newImpresora = new Impresoras();
			Date ahora = new Date();

			Emisores emisor = new Emisores();
			emisor.setRutemisor(payload.getCliente());

			newImpresora.setNombre(payload.getNombre());
			newImpresora.setIp(payload.getIp());
			// newImpresora.setPuerto(payload.getPuerto());
			newImpresora.setTipo(payload.getTipo());
			newImpresora.setEstado("ACTIVA");
			newImpresora.setCliente(emisor);
			newImpresora.setCreateDate(ahora);
			newImpresora.setUpdateDate(ahora);

			Impresoras savedImpresoras = impresorasRepo.save(newImpresora);
			Long createdId = savedImpresoras.getIdImpresora();

			log.debug("Impresora agregada con id =" + savedImpresoras.getIdImpresora());

			response.setStatus("success");
			response.setCreatedId(createdId);
			response.setMessage("Impresora agregada correctamente con id = " + createdId);

			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			log.error("No se pudo agregar la impresora: ", e.getMessage());
			response.setStatus("error");
			response.setMessage(e.getMessage());
			return ResponseEntity.badRequest().body(response);
		}
	}

	/**
	 * ELimina impresora a partir del request a la api y las elimina en la base de
	 * datos.
	 * 
	 * @param payload request para eliminar impresoras
	 * @return objeto {@link JSend} simple
	 */
	@PostMapping(value = "/quitarImpresora", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> quitarImpresora(@Validated @RequestBody ImpresorasRequest payload) {
		try {
			Long idImpresora = payload.getIdImpresora(); // Asegúrate de tener un método getIdImpresora() en
															// ImpresorasRequest
			impresorasRepo.deleteById(idImpresora);
			log.debug("Impresora eliminada con id =" + idImpresora);
			return ResponseEntity.ok().body(JSend.success("Impresora eliminada correctamente"));
		} catch (Exception e) {
			log.error("No se pudo eliminar la impresora: ", e.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
		}
	}

	/**
	 * Lista las impresoras a partir del request a la api y las devuelve en un json.
	 * 
	 * @param payload request para listar impresoras
	 * @return objeto {@link JSend} simple
	 */
	@PostMapping(value = "/listarImpresoras", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> listarImpresoras(@Validated @RequestBody ImpresorasRequest payload) {
		try {
			Emisores emisor = new Emisores();
			emisor.setRutemisor(payload.getCliente());

			List<Impresoras> listaImpresoras = impresorasRepo.findByCliente(emisor);

			List<Map<String, Object>> impresorasJson = new ArrayList<>();

			for (Impresoras impresora : listaImpresoras) {
				Map<String, Object> impresoraMap = new HashMap<>();
				impresoraMap.put("idImpresora", impresora.getIdImpresora());
				impresoraMap.put("estado", impresora.getEstado());
				impresoraMap.put("nombre", impresora.getNombre());
				impresoraMap.put("ip", impresora.getIp());
				impresoraMap.put("puerto", impresora.getPuerto());
				impresoraMap.put("tipo", impresora.getTipo());

				impresorasJson.add(impresoraMap);
			}

			if (listaImpresoras != null && !listaImpresoras.isEmpty()) {
				log.debug("Lista de impresoras recuperada");
				return ResponseEntity.ok().body(JSend.success(impresorasJson));
			} else {
				return ResponseEntity.ok().body(JSend.success("No se encontraron impresoras para el cliente"));
			}
		} catch (Exception e) {
			log.error("No se pudo obtener la lista de impresoras: ", e.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
		}
	}
}
