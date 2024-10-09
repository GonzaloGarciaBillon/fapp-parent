package cl.fapp.restapi.controller.rvd;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DocumentoConsumoFolio;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.restapi.controller.boleta.dto.EnviarBoletaSetDTERequest;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.rvd.dto.RVDRequest;
import cl.fapp.restapi.controller.rvd.mapper.VentasDiariasMapper;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.sii.jaxb.ConsumoFolios;
import cl.fapp.sii.jaxb.ConsumoFolios.DocumentoConsumoFolios;
import cl.fapp.sii.jaxb.ObjectFactory;
import cl.fapp.siiclient.axis.SOAPClientSIIAuthentication;
import cl.fapp.siiclient.axis.SOAPClientSIIEnvioDTE;
import cl.fapp.siiclient.axis.domain.envio.RECEPCIONDTE;
import cl.fapp.siiclient.boletas.SiiClientServiceRestImp;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "RVD", description = "API para generacion de documento RVD")
public class RVDController {
	static final Logger logger = LoggerFactory.getLogger(RVDController.class);

	@Autowired
	VentasDiariasMapper mapper;

	@Autowired
	EmisoresRepository repoEmisores;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	SiiClientServiceRestImp restClient;

	@Autowired
	SOAPClientSIIAuthentication soapAuthClient;

	@Autowired
	SOAPClientSIIEnvioDTE soapEnvioDTEClient;

	ObjectFactory jaxbFactory = new ObjectFactory();

	/**
	 * Genera archivo de consumo de folios
	 * 
	 * @param payload request de tipo {@link EnviarBoletaSetDTERequest}
	 * @return estructura jsend simple
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/rvd", produces = MediaType.APPLICATION_JSON_VALUE)
	// public ResponseEntity<JSend> consumoFolio(@Validated @RequestBody RVDRequest
	// payload) {
	public ResponseEntity<?> consumoFolio(@Validated @RequestBody RVDRequest payload) {

		try {
			// String trackid = "sin-trackid";
			String addToResponse = "";

			// busca al emisor
			Optional<Emisores> optEmisor = repoEmisores.findById(payload.getRutEmisor());
			if (!optEmisor.isPresent()) {
				logger.error("El emisor no existe. rut=" + payload.getRutEmisor());
				throw new Exception("El emisor no existe");
			}

			// recupera instancia de la entidad emisor
			Emisores emisor = optEmisor.get();

			logger.debug("RESUMEN DE VENTAS DIARIAS PARA=" + emisor.getRutemisor());

			// periodo a considerar
			// determina el periodo para el cual se obtienen los totales
			// -->LocalDate fechaProceso =
			// LocalDate.now(ZoneId.systemDefault()).minusDays(2);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaProceso = LocalDate.parse(payload.getFechaProceso(), formatter);
			LocalDate ayer = fechaProceso.minusDays(1);

			LocalDateTime localDesde = LocalDateTime.parse(ayer.format(DateTimeFormatter.ISO_LOCAL_DATE) + "T00:00:00",
					DateTimeFormatter.ISO_LOCAL_DATE_TIME);
			LocalDateTime localHasta = LocalDateTime.parse(ayer.format(DateTimeFormatter.ISO_LOCAL_DATE) + "T23:59:59",
					DateTimeFormatter.ISO_LOCAL_DATE_TIME);

			Date fechaDesde = Date.from(localDesde.atZone(ZoneId.systemDefault()).toInstant());
			Date fechaHasta = Date.from(localHasta.atZone(ZoneId.systemDefault()).toInstant());

			// TODO: incluye en el RVD solo boletas afectas. El RVD ya no es obligatorio.
			// Solo se utiliza para cumplir el proceso de certificacion
			// tipos de documento a incluir en el RVD
			List<Integer> tiposDocumento = new ArrayList<Integer>();
			tiposDocumento.add(ConstantesTipoDocumento.BOLETA_AFECTA.getValue());

			// realiza los calculos
			logger.debug("Consultando periodo: Emisor=" + emisor.getRutemisor() + ", tiposDocumento=" + tiposDocumento
					+ ", desde=" + localDesde.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + ", hasta="
					+ localHasta.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
			Map<Integer, VentasDiariasMapper.Resumen> resumenTipoDocumento = mapper.cacularTotales(fechaDesde,
					fechaHasta, emisor.getRutemisor(), EntityDTEStatuses.SETDTEASIGNADO, tiposDocumento);

			if (resumenTipoDocumento == null) {
				logger.info("No se obtuvieron boletas para emisor=" + payload.getRutEmisor() + ", fecha="
						+ payload.getFechaProceso());
				throw new Exception("No se obtuvieron boletas para emisor=" + payload.getRutEmisor() + ", fecha="
						+ payload.getFechaProceso());
			}

			// determina que correlativo y secuencia utilizar
			BigInteger correlativo = null; // --> no se describe 'correlativo' en la documentacion
			BigInteger seqno = BigInteger.valueOf(payload.getSecuenciaEnvio());

			logger.debug("Utilizando: correlativo=" + correlativo + ", seqno=" + seqno);

			// traspasa los resultados a un objeto jaxb ConsumoFolios, y acumula todos los
			// folios utilizados en el periodo
			List<ConsumoFolios.DocumentoConsumoFolios.Resumen> resumenes = new ArrayList<ConsumoFolios.DocumentoConsumoFolios.Resumen>();
			List<BigInteger> listaTotalFolios = new ArrayList<BigInteger>();
			resumenTipoDocumento.forEach((k, v) -> {
				listaTotalFolios.addAll(v.getListaFolios());
				ConsumoFolios.DocumentoConsumoFolios.Resumen resumen = v.toJAXBResumen(BigInteger.valueOf(k),
						BigDecimal.valueOf(SiiDocumentFactoryConfiguration.TASA_IVA));
				resumenes.add(resumen);
			});

			// genera un ID para el RVD
			String idConsumoFolios = BuilderXmlID.getIDforRVD();

			// crea la caratula
			Date fechaFirma = new Date();
			ConsumoFolios.DocumentoConsumoFolios.Caratula caratula = obtenerCaratula(fechaFirma, emisor,
					payload.getRutFirmante(), fechaDesde, fechaHasta, correlativo, seqno);
			if (caratula == null) {
				logger.error("No fue posible crear la caratula");
				throw new Exception("No se pudo crear la caratula");
			}

			// crea el documento
			ConsumoFolios.DocumentoConsumoFolios documentoConsumoFolios = jaxbFactory
					.createConsumoFoliosDocumentoConsumoFolios();
			documentoConsumoFolios.setCaratula(caratula);
			documentoConsumoFolios.setID(idConsumoFolios);
			documentoConsumoFolios.getResumens().addAll(resumenes);

			// crea el objeto ConsumoFolios
			ConsumoFolios consumoFolios = jaxbFactory.createConsumoFolios();
			consumoFolios.setVersion(BigDecimal.valueOf(1.0));
			consumoFolios.setDocumentoConsumoFolios(documentoConsumoFolios);

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DocumentoConsumoFolio docxml = (DocumentoConsumoFolio) provider.getInstance("CONSUMOFOLIOS");
			if (docxml == null) {
				logger.error("No fue posible crear instancia de DocumentoConsumoFolio");
				throw new Exception("No es posible crear instancia de DocumentoConsumoFolio");
			}

			// hace el marshall
			String xmlcontent = docxml.toXml(consumoFolios, null);

			// reemplaza el encabezado
			String encabezadoReemplazarPor = /*
												 * "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
												 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
												 */ "<ConsumoFolios xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.sii.cl/SiiDte\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte ConsumoFolio_v10.xsd\" version=\"1.0\">"
					+ SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;
			// -->String encabezadoReemplazarPor = /* "<?xml version=\"1.0\"
			// encoding=\"ISO-8859-1\"?>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
			// + */ "<ConsumoFolios version=\"1.0\">" +
			// SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;
			xmlcontent = xmlcontent.replaceFirst(".*?" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN,
					encabezadoReemplazarPor);

			// si es posible, lo firma
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante();
			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar el rvd, pero no firmar
				logger.info("No se indica rut firmante, solo se creara el documento del rvd");
				logger.info(xmlcontent);
				kinfo = null;
			} else {
				// si se indica rutfirmante => obtiene datos con los cuales firmar
				logger.debug("Se indica relacion Emisor/Firmante, se recuperan datos para firmar");
				kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					logger.error("Se indica firmante, pero no es posible acceder a los datos del keystore.");
					throw new Exception("No se encuentran datos del keystore");

				} else {
					logger.info("Se firma ConsumoFolios");
					String ID = consumoFolios.getDocumentoConsumoFolios().getID();
					String setdteURI = "#" + ID;
					String xmlconsumofoliosSigned = docxml.sign(
							new ByteArrayInputStream(
									xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING)),
							"ConsumoFolios", "DocumentoConsumoFolios",
							consumoFolios.getDocumentoConsumoFolios().getID(), kinfo.getCertificate(),
							kinfo.getPrivatekey());
					if (xmlconsumofoliosSigned == null) {
						logger.error("Ocurrio un error firmando URI=" + setdteURI);
						throw new Exception("No fue posible generar boleta ID=" + ID);
					}

					// xmlconsumofoliosSigned = xmlconsumofoliosSigned.replace("<?xml
					// version=\"1.0\" encoding=\"ISO-8859-1\"?>", "<?xml version=\"1.0\"
					// encoding=\"ISO-8859-1\"?>" +
					// SiiDocumentFactoryConfiguration.CARRIAGE_RETURN);
					xmlconsumofoliosSigned = xmlconsumofoliosSigned
							.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>", "");

					String buscar = "version=\"1.0\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte ConsumoFolio_v10.xsd\"";
					String reemplazaPor = "xsi:schemaLocation=\"http://www.sii.cl/SiiDte ConsumoFolio_v10.xsd\" version=\"1.0\"";
					xmlconsumofoliosSigned = xmlconsumofoliosSigned.replace(buscar, reemplazaPor);

					logger.debug("XML ConsumoFolios ID=" + ID + ", firmado."); // XML-resultante=\n" +
																				// xmlconsumofoliosSigned);

					// -------------------------------------------------------------------------------------------------------
					// TODO: se agrega caratula al 'setDte', para ver si es lo que requiere el sii
					String strCaratula = "";
					strCaratula = "<Caratula version=\"1.0\">" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							+ "<RutEmisor>#rutemisor#</RutEmisor>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							+ "<RutEnvia>#rutenvia#</RutEnvia>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							+ "<RutReceptor>60803000-K</RutReceptor>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							+ "<FchResol>#fchresol#</FchResol>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							+ "<NroResol>#nroresol#</NroResol>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							+ "<TmstFirmaEnv>#tmstfirmaenv#</TmstFirmaEnv>"
							+ SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							/*
							 * + "<SubTotDTE>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							 * + "<TpoDTE>#tipodte#</TpoDTE>" +
							 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							 * + "<NroDTE>#nrodte#</NroDTE>" +
							 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							 * + "</SubTotDTE>" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN
							 */
							+ "</Caratula>";

					strCaratula = strCaratula.replace("#rutemisor#", rutemisor);
					strCaratula = strCaratula.replace("#rutenvia#", rutfirmante);

					Date fechaEmisionCaratulaSetDte = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

					strCaratula = strCaratula.replace("#fchresol#", dateFormat.format(emisor.getFechaResolucion()));
					strCaratula = strCaratula.replace("#nroresol#", emisor.getCodigoResolucion());
					strCaratula = strCaratula.replace("#tmstfirmaenv#",
							dateTimeFormat.format(fechaEmisionCaratulaSetDte));
					strCaratula = strCaratula.replace("#tipodte#", rutemisor);
					strCaratula = strCaratula.replace("#nrodte#", rutemisor);

					// logger.debug("Caratula a agregar=" + strCaratula);

					// -------------------------------------------------------------------------------------------------------

					/*
					 * String sobreEnvioDTE = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "<EnvioDTE xmlns=\"http://www.sii.cl/SiiDte\"" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioDTE_v10.xsd\""
					 * + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "version=\"1.0\">" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<SetDTE ID=\"DocRVD\">" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + xmlconsumofoliosSigned +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "</SetDTE>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "</EnvioDTE>";
					 */

					/*
					 * String sobreEnvioDTE = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "<EnvioDTE xmlns=\"http://www.sii.cl/SiiDte\"" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioDTE_v10.xsd\""
					 * + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "version=\"1.0\">" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "<SetDTE ID=\"DocRVD\">" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + strCaratula +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + xmlconsumofoliosSigned +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "</SetDTE>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "</EnvioDTE>";
					 */

					String sobreEnvioDTE = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"
							+ SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + xmlconsumofoliosSigned
							+ SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;

					// logger.debug("Sobre: EnvioDTE=" + sobreEnvioDTE);

					/*
					 * String encabezadoSobreReemplazarPor =
					 * "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "<ConsumoFolios xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"http://www.sii.cl/SiiDte\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte ConsumoFolio_v10.xsd\" version=\"1.0\">"
					 * + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;
					 * //-->String encabezadoReemplazarPor =
					 * "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN +
					 * "<ConsumoFolios version=\"1.0\">" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN;
					 * sobreEnvioDTE = sobreEnvioDTE.replaceFirst(".*?" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN,
					 * encabezadoSobreReemplazarPor);
					 */

					// firma el sobre
					/*
					 * //-->String xmlenviodteSigned = docxml.sign(new
					 * ByteArrayInputStream(sobreEnvioDTE.getBytes(SiiDocumentFactoryConfiguration.
					 * DEFAULT_ENCODING)), "EnvioDTE", "SetDTE", "DocRVD", kinfo.getCertificate(),
					 * kinfo.getPrivatekey());
					 * String xmlenviodteSigned = docxml.sign(new
					 * ByteArrayInputStream(sobreEnvioDTE.getBytes(SiiDocumentFactoryConfiguration.
					 * DEFAULT_ENCODING)), "ConsumoFolios", "DocumentoConsumoFolios", ID,
					 * kinfo.getCertificate(), kinfo.getPrivatekey());
					 * if (xmlenviodteSigned == null) {
					 * logger.error("Ocurrio un error firmando URI=" + setdteURI);
					 * throw new Exception("No fue posible firmar sobre EnvioDTE ID=DocRVD");
					 * }
					 * xmlenviodteSigned =
					 * xmlenviodteSigned.replace("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>",
					 * "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
					 * SiiDocumentFactoryConfiguration.CARRIAGE_RETURN);
					 */

					String xmlenviodteSigned = sobreEnvioDTE;
					addToResponse = xmlenviodteSigned;
					logger.debug("XML ENVIO-DTE--ConsumoFolios ID=" + ID + ", firmado. XML-resultante=\n"
							+ xmlenviodteSigned);

					logger.info("*************  SKIP ENVIO DE ENVIODTE **************");

					/*
					 * if (payload == null || !payload.getEnviar()) {
					 * logger.debug("NO se envia al SII el RVD generado...");
					 * addToResponse = "NO se envia al SII";
					 * 
					 * } else {
					 * logger.debug("Se intenta enviar al SII el RVD generado...");
					 * addToResponse = "Se intenta enviar al SII";
					 * 
					 * // se envia el xml recien generado
					 * // recupera un token para enviar las boletas
					 * String token = soapAuthClient.getToken(kinfo.getCertificate(),
					 * kinfo.getPrivatekey());
					 * if (token == null) {
					 * logger.error("No se pudo obtener un token para operar");
					 * throw new Exception("No se pudo obtener token");
					 * } else {
					 * logger.debug("Se obtiene token para operar TOKEN=" + token);
					 * }
					 * 
					 * // envia el archivo
					 * String filename = "rvd-" + consumoFolios.getDocumentoConsumoFolios().getID()
					 * + ".xml";
					 * logger.debug("Enviando RVD=" + filename);
					 * 
					 * 
					 * 
					 * /*
					 * // recupera un token para enviar las boletas
					 * String token = restClient.getToken(kinfo.getCertificate(),
					 * kinfo.getPrivatekey());
					 * if (token == null) {
					 * logger.error("No se pudo obtener un token para operar");
					 * throw new Exception("No se pudo obtener token");
					 * } else {
					 * logger.debug("Se obtiene token para operar TOKEN=" + token);
					 * }
					 * 
					 * // envia el archivo
					 * String filename = "rvd-" + consumoFolios.getDocumentoConsumoFolios().getID()
					 * + ".xml";
					 * logger.debug("Enviando RVD=" + filename);
					 * /
					 * 
					 * // @param usuario RUN del usuario que envía el DTE
					 * // @param empresa RUT de la empresa emisora del DTE
					 * String sender = rutfirmante;
					 * String company = rutemisor;
					 * 
					 * String[] parts = sender.split("-");
					 * String senderRut = parts[0];
					 * String senderDV = parts[1];
					 * 
					 * parts = company.split("-");
					 * String companyRut = parts[0];
					 * String companyDV = parts[1];
					 * 
					 * DTEEnvioRequest request = new DTEEnvioRequest();
					 * request.setRutSender(senderRut);
					 * request.setRutCompany(companyRut);
					 * request.setDvCompany(companyDV);
					 * request.setDvSender(senderDV);
					 * 
					 * String xmlResponse = soapEnvioDTEClient.sendDTE(request,
					 * xmlcontent.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING),
					 * filename, token);
					 * if (xmlResponse == null) {
					 * logger.error("Respuesta nula del cliente de envioDTE..");
					 * throw new
					 * Exception("No se obtuvo respuesta esperada del servicio de envio de DTE");
					 * }
					 * 
					 * // parsea la respuesta xml a un pojo
					 * RECEPCIONDTE response = xmlToPojo(xmlResponse);
					 * if( response == null ) {
					 * logger.error("Ocurrio un error obteniendo POJO a partir del XML=" +
					 * xmlResponse);
					 * throw new Exception("No fue posible parsear la respuesta XML-RECEPCIONDTE");
					 * }
					 * 
					 * // verifica el estado de retorno. Solo status=0 => almacenar respuesta en la
					 * base de datos
					 * if (response.getSTATUS().trim().equalsIgnoreCase("0")) {
					 * trackid = String.valueOf(response.getTRACKID());
					 * logger.info("DTE enviado correctamente. TrackID=" + trackid);
					 * 
					 * } else {
					 * logger.error("El envio de DTE's resulto con error. Status=" +
					 * response.getSTATUS() + ", DETAIL=" + response.getDETAIL().getERROR());
					 * throw new Exception("No fue posible realizar el envio");
					 * }
					 * /*
					 * DteEnvioResponse response = restClient.sendBDte(request,
					 * xmlenviodteSigned.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING),
					 * filename, token);
					 * if( response == null ) {
					 * logger.error("Respuesta nula del cliente EnvioDTE..");
					 * throw new
					 * Exception("No se obtuvo respuesta esperada del servicio EnvioDTE para RVD");
					 * }
					 * 
					 * logger.info("Respuesta recibida=" + response);
					 * /
					 * }
					 */
				}
			}

			String filename = "rcof-" + rutemisor.replace("-", "") + "-" + payload.getFechaProceso().replace("/", "")
					+ ".xml";
			String contentType = "application/octet-stream";
			String headerValue = "attachment; filename=\"" + filename + "\"";

			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
					.body(addToResponse);

			// return ResponseEntity.ok().body(addToResponse); //JSend.success("Finalizado.
			// " + addToResponse));

		} catch (Exception ex) {
			logger.error("Se produjo un error creando/enviando RVD. Error=" + ex.getMessage());
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Crea la caratula del RVD
	 * 
	 * @param fechaFirma  timestamp de cuando se realiza la firma
	 * @param emisor      instancia de la entidad {@link Emisores}
	 * @param rutenvia    rut de quien envia
	 * @param fechaInicio rango de fecha inicial
	 * @param fechaFinal  rango de fecha final
	 * @param correlativo correlativo correspondiente al numero de envio
	 * @param seqEnvio    secuencia de envio
	 * @return
	 */
	private DocumentoConsumoFolios.Caratula obtenerCaratula(Date fechaFirma, Emisores emisor, String rutenvia,
			Date fechaInicio, Date fechaFinal, BigInteger correlativo, BigInteger seqEnvio) {
		try {
			// obtiene la caratula del RVD
			DocumentoConsumoFolios.Caratula caratula = jaxbFactory.createConsumoFoliosDocumentoConsumoFoliosCaratula();
			caratula.setCorrelativo(correlativo);
			caratula.setFchFinal(fechaFinal);
			caratula.setFchInicio(fechaInicio);

			if (emisor.getFechaResolucion() != null) {
				caratula.setFchResol(emisor.getFechaResolucion());
			}
			if (emisor.getCodigoResolucion() != null) {
				caratula.setNroResol(new BigInteger(emisor.getCodigoResolucion()));
			}

			caratula.setRutEmisor(emisor.getRutemisor());
			caratula.setRutEnvia(rutenvia);
			caratula.setSecEnvio(seqEnvio);
			caratula.setTmstFirmaEnv(fechaFirma);
			caratula.setVersion(new BigDecimal("1.0"));

			return caratula;

		} catch (Exception ex) {
			logger.debug("Ocurrio un error creando la caratula. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Convierte un string xml simple a un POJO
	 * 
	 * @param xml string xml simple
	 * @return POJO de respuesta al envio del DTE
	 */
	private RECEPCIONDTE xmlToPojo(String xml) {
		try {
			JacksonXmlModule module = new JacksonXmlModule();
			module.setDefaultUseWrapper(false);
			XmlMapper xmlMapper = new XmlMapper(module);

			RECEPCIONDTE pojo = xmlMapper.readValue(xml, RECEPCIONDTE.class);
			return pojo;

		} catch (Exception ex) {
			logger.error("Ocurrio un error convirtiendo xml a objeto. Error=" + ex.getMessage());
			return null;
		}
	}
}
