package cl.fapp.restapi.controller.repos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Caf;
import cl.fapp.repository.repos.CAFRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.repo.base-path}")
@Tag(name = "ENTITIES", description="API para operaciones sobre las Entidades")
public class CAFRepositoryController {
	@Autowired
	CAFRepository repository;

	@Operation(summary = "API para repositorio CAF")
	@RequestMapping(method = RequestMethod.GET, value = "/caf/{idcaf}/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> create(@PathVariable Optional<Long> idcaf) {

		Caf resp = null;
		if (idcaf.isPresent()) {
			Optional<Caf> currentcaf = repository.findById(idcaf.get());
			if (currentcaf.isPresent()) {
				resp = currentcaf.get();
				log.debug("AUTORIZACION=" + resp.getTagAutorizacion());
				log.debug("CAF=" + resp.getTagCaf());
				log.debug("RSASK=" + resp.getTagRsask());
				
				return ResponseEntity.ok().body(JSend.success(resp.getTagAutorizacion()));
			} else {
				return ResponseEntity.ok().body(JSend.error("El CAF con id=" + idcaf + ", no existe"));
			}

		} else {
			return ResponseEntity.ok().body(JSend.error("No se indico idcaf que buscar"));
		}
	}
}
