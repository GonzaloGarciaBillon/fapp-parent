package cl.fapp.restapi.controller.consultas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.awt.image.BufferedImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBContext;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Setdte;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.SetDTERepository;
import cl.fapp.restapi.controller.consultas.dto.ConsultaDTERequest;
import cl.fapp.restapi.controller.consultas.dto.ConsultaDTEResponse;
import cl.fapp.restapi.controller.consultas.dto.ResumenDTERequest;
import cl.fapp.restapi.controller.consultas.dto.ResumenDTEResponse;
import cl.fapp.restapi.controller.pdf.GetDataFromDTERequest;
import cl.fapp.restapi.controller.pdf.GetDataFromDTEResponse;
import cl.fapp.restapi.controller.pdf.GenerarPDFController;
import cl.fapp.services.dtelocator.ServiceDTELocatorSimple;
import cl.fapp.services.dtelocator.dto.ServiceDTELocatorSimpleRequest;
import cl.fapp.services.dtelocator.dto.ServiceDTELocatorSimpleResponse;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.restapi.security.service.RateLimitingService;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "CONSULTAS", description = "API para consulta de documentos")
public class ConsultaDTEController {

	@Autowired
	DteRepository repoDTE;

	@Autowired
	SetDTERepository repoSetDTE;

	@Autowired
	ServiceDTELocatorSimple dteLocator;

	@Autowired
	RateLimitingService rateLimitingService;

	/**
	 * Retorna lista de dte que cumplen con el criterio de busqueda
	 * 
	 * @param payload request para realizar consultas {@link ConsultaDTERequest}
	 * @return objeto {@link Jsend} simple con List<{@link Dte}>
	 */
	@PostMapping(value = "/listadte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> listaDTE(@RequestBody ConsultaDTERequest payload, HttpServletRequest request) {
		try {
			List<String> estados = new ArrayList<>();
			if (payload.getEstados() == null) {
				// si no se indican estados especificos, se busca por cualquiera
				Arrays.asList(EntityDTEStatuses.values()).forEach(status -> estados.add(status.toString()));

			} else {
				payload.getEstados().forEach(estados::add);
			}

			List<Integer> tiposDocumento = new ArrayList<>();
			if (payload.getTipos() == null) {
				// si no se indican tipos especificos, se busca por cualquiera
				Arrays.asList(ConstantesTipoDocumento.values()).forEach(tipo -> tiposDocumento.add(tipo.getValue()));

			} else {
				payload.getTipos().forEach(tiposDocumento::add);
			}

			Optional<List<Dte>> listaDtes;
			if (payload.getFechaDesde() == null) {
				listaDtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoIn(payload.getRutEmisor(),
						tiposDocumento, estados);

			} else {
				LocalDateTime localDesde = LocalDateTime.parse(payload.getFechaDesde() + "T00:00:00",
						DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				LocalDateTime localHasta;
				if (payload.getFechaHasta() == null) {
					LocalDate fechaProceso = LocalDate.now(ZoneId.systemDefault());
					localHasta = LocalDateTime.parse(
							fechaProceso.format(DateTimeFormatter.ISO_LOCAL_DATE) + "T23:59:59",
							DateTimeFormatter.ISO_LOCAL_DATE_TIME);

				} else {
					localHasta = LocalDateTime.parse(payload.getFechaHasta() + "T23:59:59",
							DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				}
				log.debug("Consultando desde=" + localDesde.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + ", hasta="
						+ localHasta.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

				Date fechaDesde = Date.from(localDesde.atZone(ZoneId.systemDefault()).toInstant());
				Date fechaHasta = Date.from(localHasta.atZone(ZoneId.systemDefault()).toInstant());

				listaDtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoInAndCreatedatBetween(
						payload.getRutEmisor(), tiposDocumento, estados, fechaDesde, fechaHasta);
			}

			if (!listaDtes.isPresent() || listaDtes.get().isEmpty()) {
				throw new Exception("No se encontraron DTEs");
			}

			List<ConsultaDTEResponse> response = listaDTEtoDTO(listaDtes.get());
			log.debug("Se retornan " + listaDtes.get().size() + " registros que cumplen el criterio de busqueda="
					+ payload);

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Se produjo un error consultando. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	// Método en ConsultaDTEController
	@PostMapping(value = "/resumendte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> resumenDTE(@RequestBody ResumenDTERequest payload, HttpServletRequest request) {
		try {
			List<String> estados = new ArrayList<>();
			if (payload.getEstados() == null) {
				// si no se indican estados especificos, se busca por cualquiera
				Arrays.asList(EntityDTEStatuses.values()).forEach(status -> estados.add(status.toString()));

			} else {
				payload.getEstados().forEach(estados::add);
			}

			List<Integer> tiposDocumento = new ArrayList<>();
			if (payload.getTipos() == null) {
				// si no se indican tipos especificos, se busca por cualquiera
				Arrays.asList(ConstantesTipoDocumento.values()).forEach(tipo -> tiposDocumento.add(tipo.getValue()));

			} else {
				payload.getTipos().forEach(tiposDocumento::add);
			}
			Optional<List<Dte>> dtes;
			if (payload.getFechaDesde() != null) {
				// Parseo de fechas
				LocalDateTime desde = LocalDateTime.parse(payload.getFechaDesde() + "T00:00:00",
						DateTimeFormatter.ISO_LOCAL_DATE_TIME);
				LocalDateTime hasta = payload.getFechaHasta() == null
						? LocalDateTime.now()
						: LocalDateTime.parse(payload.getFechaHasta() + "T23:59:59",
								DateTimeFormatter.ISO_LOCAL_DATE_TIME);

				Date fechaDesde = Date.from(desde.atZone(ZoneId.systemDefault()).toInstant());
				Date fechaHasta = Date.from(hasta.atZone(ZoneId.systemDefault()).toInstant());
				dtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoInAndCreatedatBetween(
						payload.getRutEmisor(), tiposDocumento, estados, fechaDesde, fechaHasta);
			} else {
				dtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoIn(payload.getRutEmisor(),
						tiposDocumento, estados);
			}

			// Obtener lista de DTE

			// Calcular resumen
			int totalBoletas = dtes.map(List::size).orElse(0);

			long totalMontos = dtes.get().stream().mapToLong(dte -> dte.getMonto().longValue()).sum();

			BigDecimal totalIVA = dtes.map(list -> list.stream()
					.map(dte -> calcularIVA(dte.getMonto()))
					.reduce(BigDecimal.ZERO, BigDecimal::add))
					.orElse(BigDecimal.ZERO);
			totalIVA = totalIVA.setScale(0, RoundingMode.HALF_UP);
			BigDecimal totalNeto = dtes.map(list -> list.stream()
					.map(dte -> calcularNeto(dte.getMonto()))
					.reduce(BigDecimal.ZERO, BigDecimal::add))
					.orElse(BigDecimal.ZERO);
			totalNeto = totalNeto.setScale(0, RoundingMode.HALF_UP);

			// long totalFolios = dtes.map(List::size).orElse(0);

			// Crear respuesta
			ResumenDTEResponse resumen = new ResumenDTEResponse();
			resumen.setCantidadVentas(totalBoletas);
			resumen.setMontoVentas(totalMontos);
			resumen.setMontoNeto(totalNeto);
			resumen.setIvaRecaudado(totalIVA);
			// resumen.setFoliosUtilizados(totalFolios);

			return ResponseEntity.ok().body(JSend.success(resumen));
		} catch (Exception ex) {
			log.error("Error en resumenDTE: " + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	private BigDecimal calcularIVA(BigInteger bigInteger) {
		final BigDecimal tasaIVA = new BigDecimal("19"); // Tasa de IVA, ajustar según sea necesario
		BigDecimal valor = new BigDecimal(bigInteger);
		return valor.multiply(tasaIVA).divide(new BigDecimal("119"), 2, RoundingMode.HALF_UP);
	}

	private BigDecimal calcularNeto(BigInteger bigInteger) {
		BigDecimal valor = new BigDecimal(bigInteger);
		return valor.multiply(new BigDecimal("100")).divide(new BigDecimal("119"), 2, RoundingMode.HALF_UP);
	}

	/**
	 * Convierte al objeto que retorna la API de listaDTE
	 * 
	 * @param dtes lista de dte de tipo {@link Dte}
	 * @return lista de dte de tipo {@link ConsultaDTEResponse}
	 */
	private List<ConsultaDTEResponse> listaDTEtoDTO(List<Dte> dtes) {

		return dtes.stream()
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
					// resp.setIdSetdte(dte.getSetdte().getIdSetdte());

					return resp;
				})
				.collect(Collectors.toList());
	}

	/**
	 * Recupera el xml de un DTE, realiza unmarshall, y retorna un objeto json que
	 * contiene los datos del xml
	 * 
	 * @param payload datos a aplicar como filtros en la busqueda del DTE.
	 * @return la api retornara los datos del DTE que se encuentran en el xml
	 */
	@PostMapping(value = "/consulta-dte", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> getDataFromDTE(@RequestBody GetDataFromDTERequest payload) {
		try {
			ServiceDTELocatorSimpleRequest newRequest = new ServiceDTELocatorSimpleRequest();
			newRequest.setEmailReceptor(null);
			newRequest.setDteFolioAsignado(payload.getDteFolioAsignado());
			newRequest.setDteMonto(payload.getDteMonto());
			newRequest.setDteRutEmisor(payload.getDteRutEmisor());
			newRequest.setDteTipoDocumento(payload.getDteTipoDocumento());
			newRequest.setDteUUID(payload.getDteUUID());

			// ubica un dte en base al request
			ServiceDTELocatorSimpleResponse dtelocatorResponse = dteLocator.locatorSimple(newRequest);
			if (dtelocatorResponse == null) {
				log.error("No fue posible localizar DTE utilizando los filtros indicados. Payload=" + payload);
				throw new Exception("No se localiza Boleta");
			} else {
				log.debug("Localizado DTE=" + dtelocatorResponse.getDte().getIdDte());
				try {
					GetDataFromDTEResponse response = new GetDataFromDTEResponse();
					String xml = dtelocatorResponse.getDte().getDocumentoXml();
					// se retornan los datos de la boleta
					// response.setDte(dtelocatorResponse.getDte());
					response.setXml(xml);
					String idSetDte = dtelocatorResponse.getDte().getSetdte() == null ? null
							: dtelocatorResponse.getDte().getSetdte().getIdSetdte().toString();
					Optional<Setdte> setdteEntity = null;
					String trackid = null;
					response.setTrackid(trackid);
					if (idSetDte != null) {
						setdteEntity = repoSetDTE.findById(Long.parseLong(idSetDte));
						if (setdteEntity.get().getTrackid() != null) {
							trackid = setdteEntity.get().getTrackid();
							response.setTrackid(trackid);
							log.debug(trackid);
						}
					}
					return ResponseEntity.ok().body(JSend.success(response));
				} catch (Exception ex) {
					log.error("Ocurrio un error realizando unmarshalling del xml. Error=" + ex.getMessage());
					return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
				}
			}
		} catch (Exception ex) {
			log.error("Ocurrio un error extrayendo data del xml. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Recupera el xml de un DTE, realiza unmarshall, y retorna un objeto json que
	 * contiene los datos del xml
	 * 
	 * @param payload datos a aplicar como filtros en la busqueda del DTE.
	 * @return la api retornara los datos del DTE que se encuentran en el xml
	 */
	@PostMapping(value = "/consulta-folio", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> getDataFromDTE(@RequestBody GetDataFromDTERequest payload,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		String requestPath = request.getRequestURI();
		if (!rateLimitingService.isAllowed(clientIp, requestPath)) {
			return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).body(JSend.error("Demasiadas solicitudes"));
		}
		try {
			ServiceDTELocatorSimpleRequest newRequest = new ServiceDTELocatorSimpleRequest();
			newRequest.setDteFolioAsignado(payload.getDteFolioAsignado());
			newRequest.setDteRutEmisor(payload.getDteRutEmisor());
			newRequest.setDteTipoDocumento(payload.getDteTipoDocumento());
			// ubica un dte en base al request
			String logo = null;
			ServiceDTELocatorSimpleResponse dtelocatorResponse = dteLocator.locatorSimple(newRequest);
			if (dtelocatorResponse == null) {
				log.error("No fue posible localizar DTE utilizando los filtros indicados. Payload=" + payload);
				throw new Exception("No se localiza Boleta");
			} else {
				try {
					GetDataFromDTEResponse response = new GetDataFromDTEResponse();
					int tipoDocumento = payload.getDteTipoDocumento();
					Object unmarshalledType = null;
					if (tipoDocumento == ConstantesTipoDocumento.BOLETA_AFECTA.getValue()
							|| tipoDocumento == ConstantesTipoDocumento.BOLETA_EXENTA.getValue()) {
						// hace el unmarshall del xml contenido en la entidad dte
						JAXBContext context = JAXBContext.newInstance(BOLETADefType.class);
						BOLETADefType unmarshallDbDte = (BOLETADefType) context.createUnmarshaller()
								.unmarshal(new StringReader(dtelocatorResponse.getDte().getDocumentoXml()));
						unmarshallDbDte.getDocumento().setTED(null);
						unmarshalledType = unmarshallDbDte;

					} else {
						if (tipoDocumento == ConstantesTipoDocumento.NOTA_CREDITO.getValue()) {
							// hace el unmarshall del xml contenido en la entidad dte
							JAXBContext context = JAXBContext.newInstance(DTE.class);
							DTE unmarshallDbDte = (DTE) context.createUnmarshaller()
									.unmarshal(new StringReader(dtelocatorResponse.getDte().getDocumentoXml()));
							unmarshallDbDte.getDocumento().setTED(null);
							unmarshalledType = unmarshallDbDte;
						} else {
							log.error("Tipo de documento no soportado. Tipo=" + tipoDocumento);
							throw new Exception("Tipo de documento no soportado");
						}
					}

					// se retornan los datos de la boleta
					response.setDte(unmarshalledType);

					return ResponseEntity.ok().body(JSend.success(response));

				} catch (Exception ex) {
					log.error("Ocurrio un error realizando unmarshalling del xml. Error=" + ex.getMessage());
					return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
				}
			}
		} catch (Exception ex) {
			log.error("Ocurrio un error extrayendo data del xml. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}
}
