package cl.fapp.restapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.restapi.controller.rvd.mapper.VentasDiariasMapper;
import cl.fapp.sii.jaxb.ConsumoFolios;
import cl.fapp.sii.jaxb.EnvioBOLETA;
import cl.fapp.sii.jaxb.EnvioDTE;
import cl.fapp.sii.jaxb.LibroBoleta;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="${fapp.api.controller.base-path}")
@Tag(name="DOCUMENTOS", description="Uso de objetos jaxb como input a los servicios")
public class SIIDocumentsController {
	static final Logger logger = LoggerFactory.getLogger(SIIDocumentsController.class);

	@Autowired
	VentasDiariasMapper mapper;

	@RequestMapping(method = RequestMethod.POST, value = "/envioboleta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnvioBOLETA> envioBoleta(@Validated @RequestBody EnvioBOLETA payload) {

		return ResponseEntity.ok().body(payload);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/libroboleta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LibroBoleta> libroBoleta(@Validated @RequestBody LibroBoleta payload) {

		return ResponseEntity.ok().body(payload);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/enviodte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EnvioDTE> envioDTE(@Validated @RequestBody EnvioDTE payload) {

		return ResponseEntity.ok().body(payload);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/consumofolio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConsumoFolios> consumoFolio(@Validated @RequestBody ConsumoFolios payload) {

		return ResponseEntity.ok().body(payload);
	}
}
