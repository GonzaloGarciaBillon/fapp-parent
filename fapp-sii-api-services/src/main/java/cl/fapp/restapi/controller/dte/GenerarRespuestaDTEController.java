package cl.fapp.restapi.controller.dte;

import org.mapstruct.factory.Mappers;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.jsend.JSend;
import cl.fapp.common.jsend.JSendStatus;
import cl.fapp.restapi.dte.dto.GenerarDTERequest;
import cl.fapp.restapi.dte.dto.GenerarNotaCreditoRequest;
import cl.fapp.restapi.dte.mapper.NotaCreditoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR-RESPUESTA-DTE", description = "API para generacion de DTE de tipo: GenerarRespuestaDTE")
public class GenerarRespuestaDTEController {
	/*
	@RequestMapping(method = RequestMethod.POST, value = "/generarrespuestadte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarRespuestaDTE(@Validated @RequestBody GenerarRespuestaDTERequest payload) {
		try {
			// establece tipo de documento a generar
			Integer tipoDocumento = ConstantesTipoDocumento.NOTA_CREDITO.getValue();
			
			// transforma el payload particular para nota de debito al general de documento dte
			NotaCreditoMapper mapper = Mappers.getMapper(NotaCreditoMapper.class);
			GenerarDTERequest dtePayload = mapper.toGenerarDTERequest(payload);
			
			// utiliza el metodo generico de construccion de DTE indicando el tipo de documento a generar
			JSend result = internalGenerarDTE(dtePayload, tipoDocumento);
			if (result.getStatus() == JSendStatus.error) {
				log.debug("Error generando tipoDocumento=" + tipoDocumento + ". Message=" + result.getMessage());
				return ResponseEntity.badRequest().body(result);

			} else {
				log.debug("Request procesado correctamente");
				return ResponseEntity.ok().body(result);
			}
		} catch (Exception ex) {
			log.error("Se produjo un error generando DTE tipo=" + ConstantesTipoDocumento.NOTA_CREDITO + ". Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
	*/
}
