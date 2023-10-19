package cl.fapp.restapi.controller.consultas;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.restapi.controller.consultas.dto.ConsultaDTERequest;
import cl.fapp.restapi.controller.consultas.dto.ConsultaDTEResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "CONSULTAS", description = "API para consulta de documentos")
public class ConsultaDTEController {

	@Autowired
	DteRepository repoDTE;

	/**
	 * Retorna lista de dte que cumplen con el criterio de busqueda
	 * 
	 * @param payload request para realizar consultas {@link ConsultaDTERequest}
	 * @return objeto {@link Jsend} simple con List<{@link Dte}>
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/listadte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> listaDTE(@RequestBody ConsultaDTERequest payload) {
		try {
			log.debug("Request procesado correctamente");

			if (payload == null || payload.getRutEmisor() == null) {
				throw new Exception("No se indica emisor");
			}

			List<String> estados = new ArrayList<String>();
			if (payload.getEstados() == null) {
				// si no se indican estados especificos, se busca por cualquiera
				Arrays.asList(EntityDTEStatuses.values()).forEach(status -> estados.add(status.toString()));

			} else {
				payload.getEstados().forEach(estado -> estados.add(estado));
			}

			List<Integer> tiposDocumento = new ArrayList<Integer>();
			if (payload.getTipos() == null) {
				// si no se indican tipos especificos, se busca por cualquiera
				Arrays.asList(ConstantesTipoDocumento.values()).forEach(tipo -> tiposDocumento.add(tipo.getValue()));

			} else {
				payload.getTipos().forEach(tipo -> tiposDocumento.add(tipo));
			}

			Optional<List<Dte>> listaDtes;
			if (payload.getFechaDesde() == null) {
				listaDtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoIn(payload.getRutEmisor(), tiposDocumento, estados);

			} else {
				LocalDateTime localDesde = LocalDateTime.parse(payload.getFechaDesde() + "T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				LocalDateTime localHasta;
				if (payload.getFechaHasta() == null) {
					LocalDate fechaProceso = LocalDate.now(ZoneId.systemDefault());
					localHasta = LocalDateTime.parse(fechaProceso.format(DateTimeFormatter.ISO_LOCAL_DATE) + "T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

				} else {
					localHasta = LocalDateTime.parse(payload.getFechaHasta() + "T23:59:59", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				}
				log.debug("Consultando desde=" + localDesde.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + ", hasta=" + localHasta.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

				Date fechaDesde = Date.from(localDesde.atZone(ZoneId.systemDefault()).toInstant());
				Date fechaHasta = Date.from(localHasta.atZone(ZoneId.systemDefault()).toInstant());

				listaDtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoInAndCreatedatBetween(payload.getRutEmisor(), tiposDocumento, estados, fechaDesde, fechaHasta);
			}

			if (!listaDtes.isPresent() || listaDtes.get().size() <= 0) {
				throw new Exception("No se encontraron DTEs");
			}

			List<ConsultaDTEResponse> response = listaDTEtoDTO(listaDtes.get());
			log.debug("Se retornan " + listaDtes.get().size() + " registros que cumplen el criterio de busqueda=" + payload);

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Se produjo un error consultando. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
	
	/**
	 * Convierte al objeto que retorna la API de listaDTE
	 * @param dtes lista de dte de tipo {@link Dte}
	 * @return lista de dte de tipo {@link ConsultaDTEResponse}
	 */
	private List<ConsultaDTEResponse> listaDTEtoDTO(List<Dte> dtes) {

		List<ConsultaDTEResponse> response = dtes.stream()
				.map(dte -> {
					ConsultaDTEResponse resp = new ConsultaDTEResponse();
					resp.setCreatedat(dte.getCreatedat());
					resp.setEstado(dte.getEstado());
					resp.setFolioAsignado(dte.getFolioAsignado());
					resp.setIdDocumento(dte.getIdDocumento());
					resp.setIdDte(dte.getIdDte());
					resp.setMonto(dte.getMonto());
					resp.setTipoDocumento(dte.getTipoDocumento());
					resp.setUpdatedat(dte.getUpdatedat());
					resp.setIdSetdte(dte.getSetdte().getIdSetdte());
					
					return resp;
				})
				.collect(Collectors.toList());
		
		return response;
	}
}
