package cl.fapp.restapi.controller.repos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.SetDTERepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="${fapp.api.controller.repo.base-path}")
@Tag(name = "ENTITIES")
public class SetDTERepositoryController {
	@Autowired
	SetDTERepository setdteRepo;

	@Operation(summary = "API para repositorio SETDTE")
	@PostMapping("/setdte/create")
	public ResponseEntity<JSend> create(@RequestBody Setdte setdte) {
		try {
			setdte.setEstado("OK");
			setdte.setDocumentoXml("<xml>un xml con ñ</xml>");
			setdte.setCreatedat(new Date());
			Setdte newsetdte = setdteRepo.save(setdte);

			return ResponseEntity.ok().body(JSend.success("SetDTE creado con id=" + newsetdte.getIdSetdte()));
			
		}catch(Exception ex) {
			log.error("No fue posible crear el Firmante. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
			
		}
	}
}
