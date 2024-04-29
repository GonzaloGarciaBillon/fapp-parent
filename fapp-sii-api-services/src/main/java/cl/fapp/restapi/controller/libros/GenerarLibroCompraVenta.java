package cl.fapp.restapi.controller.libros;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cl.fapp.SIIDocumentFactoryProvider;
import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.domain.ConstantesTipoEnvioLibro;
import cl.fapp.common.domain.ConstantesTipoLibro;
import cl.fapp.common.domain.ConstantesTipoOperacionLibro;
import cl.fapp.common.domain.statuses.EntityDTEStatuses;
import cl.fapp.common.jsend.JSend;
import cl.fapp.docs.DTERoot;
import cl.fapp.docs.DocumentoLibroCompraVenta;
import cl.fapp.repository.model.Dte;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.repos.DteRepository;
import cl.fapp.repository.repos.EmisoresRepository;
import cl.fapp.repository.repos.FirmantesRepository;
import cl.fapp.repository.repos.KeystoreFirmantesRepository;
import cl.fapp.restapi.controller.libros.domain.ImpuestoRecord;
import cl.fapp.restapi.controller.libros.domain.ImpuestosAdicionales;
import cl.fapp.restapi.controller.libros.dto.FirmarLibroCompraVentaRequest;
import cl.fapp.restapi.controller.libros.dto.FirmarLibroCompraVentaResponse;
import cl.fapp.restapi.controller.libros.dto.GenerarLibroCompraVentaRequest;
import cl.fapp.restapi.controller.repos.dto.KeyinfoFindResponse;
import cl.fapp.restapi.controller.utils.KeystoreFirmanteUtils;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.LceCal;
import cl.fapp.sii.jaxb.LceCoCertif;
import cl.fapp.sii.jaxb.LibroCompraVenta;
import cl.fapp.sii.jaxb.LibroCompraVenta.EnvioLibro.Detalle.IVANoRec;
import cl.fapp.sii.jaxb.LibroCompraVenta.EnvioLibro.Detalle.OtrosImp;
import cl.fapp.sii.jaxb.LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento;
import cl.fapp.sii.jaxb.ObjectFactory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Tag(name = "GENERAR", description = "API para generacion de libros contables")
public class GenerarLibroCompraVenta {
	@Autowired
	FirmantesRepository firmantesRepo;

	@Autowired
	KeystoreFirmanteUtils ksfirmanteUtils;

	@Autowired
	KeystoreFirmantesRepository keystorefirmantesRepo;

	@Autowired
	DteRepository repoDTE;

	@Autowired
	EmisoresRepository repoEmisores;

	ObjectFactory jaxbFactory = new ObjectFactory();

	/**
	 * Firma un xml que representa un libro de compra/venta
	 * 
	 * @param payload Emisor y Firmante a utilizar en la firma del archivo
	 * @param xmlfile archivo xml del libro compra/venta
	 * @return estructura JSend simple
	 */
	@Operation(summary = "API para firma de libro compra/venta")
	@RequestMapping(method = RequestMethod.POST, value = "/firmarlibro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> firmarLibroCompraVenta(@Validated @ModelAttribute @RequestBody FirmarLibroCompraVentaRequest payload, @RequestParam MultipartFile xmlfile) {
		FirmarLibroCompraVentaResponse response = new FirmarLibroCompraVentaResponse();
		try {
			byte[] xmlLibroContent = xmlfile.getInputStream().readAllBytes();
			String s = new String(xmlLibroContent); // Base64.getEncoder().encodeToString(xmlLibroContent);

			// obtiene el string xml del objeto
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DocumentoLibroCompraVenta docxml = (DocumentoLibroCompraVenta) provider.getInstance("LIBROCOMPRAVENTA");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DocumentoLibroCompraVenta");
				throw new Exception("No es posible crear instancia de DocumentoLibroCompraVenta");
			}

			LibroCompraVenta docLibroCompraVenta = docxml.unmarshallXml(s, LibroCompraVenta.class);
			
			// ---------------------------------------------------------
			// TODO: quita cualquier string extra en el xml que no este definido en el esquema
			// esto agregara declaraciones de namespace que modificaran el xml original
			s = docxml.toXml(docLibroCompraVenta, "");
			// ---------------------------------------------------------
			
			// ---------------------------------------------------------
			// TODO: en caso de querer modificar el ID indicado como parametro
			// --> docLibroCompraVenta.getEnvioLibro().setID(BuilderXmlID.getIDforLibroCompraVenta());
			// --> s = docxml.toXml(docLibroCompraVenta, "");
			// --> log.debug("S=" + s);
			// ---------------------------------------------------------

			// si es posible, lo firma. En caso contrario lo guarda no firmado
			String rutemisor = payload.getRutEmisor();
			String rutfirmante = payload.getRutFirmante();

			if (rutfirmante == null) {
				log.info("No se indica Rut Firmante, se utilizara Rut Emisor para informacion de certificado");
				rutfirmante = rutemisor;
			}

			KeyinfoFindResponse kinfo;
			if (rutfirmante == null) {
				// no se indica rutfirmante => se puede generar la boleta, pero no firmar
				log.info("No se indica rut firmante, solo se creara el documento del libro");
				kinfo = null;
			} else {

				// si se indica rutfirmante => obtiene datos con los cuales firmar
				log.debug("Se indica relacion Emisor/Firmante, se recuperan datos para firmar");
				kinfo = ksfirmanteUtils.getKeystoreInfo(rutemisor, rutfirmante);
				if (kinfo == null) {
					log.error("Se indica firmante, pero no es posible acceder a los datos del keystore.");
					throw new Exception("No se encuentran datos del keystore");

				} else {
					log.info("Se firma el documento. Se almacena xml firmado");

					// @formatter:off
					// firma la boleta
					String xmlLibroCompraVentaSigned = docxml
							.sign(new ByteArrayInputStream(s.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING)), 
									"LibroCompraVenta", 
									"EnvioLibro", 
									docLibroCompraVenta.getEnvioLibro().getID(), 
									kinfo.getCertificate(), 
									kinfo.getPrivatekey());
					// @formatter:on
					response.setEstado(0);
					response.setDescription("OK");
					response.setLibroCompraVentaFirmado(xmlLibroCompraVentaSigned);
					
					log.debug("XML Libro Compra/Venta firmado = " + xmlLibroCompraVentaSigned);
				}
			}

			return ResponseEntity.ok().body(JSend.success(response));

		} catch (Exception ex) {
			log.error("Error firmando el xml indicado. Error=" + ex.getMessage());
			log.error("STACKTRACE", ex);
			//ex.printStackTrace();
			response.setEstado(1);
			response.setDescription("No fue posible firmar xml libro compra/venta. Error=");
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Genera libros jaxb a partir del request a la api, y las escribe en la base de datos.
	 * 
	 * @param payload request para generar libros de compra/venta. Utiliza objetos de tipo {@link DTE}
	 * @return objeto {@link JSend} simple
	 */
	@RolesAllowed("user")
	@RequestMapping(method = RequestMethod.POST, value = "/generarlibro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSend> generarLibro(@RequestBody GenerarLibroCompraVentaRequest payload) {
		try {
			// busca al emisor
			Optional<Emisores> optEmisor = repoEmisores.findById(payload.getRutEmisor());
			if (!optEmisor.isPresent()) {
				log.error("El emisor no existe. rut=" + payload.getRutEmisor());
				throw new Exception("El emisor no existe");
			}

			// recupera instancia de la entidad emisor
			Emisores emisor = optEmisor.get();

			log.debug("libro conteniendo tipo operacion=" + payload.getTipoOperacionLibro() + ", PARA=" + emisor.getRutemisor());

			ConstantesTipoOperacionLibro tipoLibro = ConstantesTipoOperacionLibro.valueOf(payload.getTipoOperacionLibro());
			EntityDTEStatuses estadoDocumento = EntityDTEStatuses.SETDTEASIGNADO;

			Date fechaDesde = convertToDate(payload.getFechaDesde(), "dd/MM/yyyy");
			Date fechaHasta = convertToDate(payload.getFechaHasta(), "dd/MM/yyyy");

			// realiza los calculos
			log.debug("Consultando periodo: Emisor=" + emisor.getRutemisor() + ", desde=" + fechaDesde + ", hasta=" + fechaHasta);
			List<DTE> documentos = getDtesParaLibro(tipoLibro, emisor.getRutemisor(), estadoDocumento, fechaDesde, fechaHasta);

			return ResponseEntity.ok().body(JSend.success("Documentos ha incluir en el libro=" + documentos.size()));

		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(JSend.error(ex.getMessage()));
		}
	}

	/**
	 * Busca todos los dte que seran informados en el libro. <br>
	 * Tipos de documentos considerados corresponden a factura (afecta/exenta) y nota credito/debito
	 * 
	 * @param tipoLibro       tipo del libro a generar {@link ConstantesTipoOperacionLibro}
	 * @param rutEmisor       rut del emisor
	 * @param estadoDocumento estado en que deben encontrarse las boletas para ser consideradas
	 * @param fechaDesde      desde que dia se buscaran dte's no informadas
	 * @param fechaHasta      hasta que dia se buscaran dte's no informadas
	 */
	public List<DTE> getDtesParaLibro(ConstantesTipoOperacionLibro tipoLibro, String rutEmisor, EntityDTEStatuses estadoDocumento, Date fechaDesde, Date fechaHasta) {
		try {
			// busca dte's aplicando el filtro indicado
			// @formatter:off
			List<Dte> dtes;
			List<Integer> tiposDocumento = Arrays.asList(
					new Integer[]{
							ConstantesTipoDocumento.FACTURA_AFECTA.getValue(),
							ConstantesTipoDocumento.FACTURA_EXENTA.getValue(),
							ConstantesTipoDocumento.NOTA_CREDITO.getValue(),
							ConstantesTipoDocumento.NOTA_DEBITO.getValue()
							});
			List<String> estadosDocumento = Arrays.asList(new String[]{estadoDocumento.getValue()});
			Optional<List<Dte>> optDtes = repoDTE.findAllByEmisoreRutemisorAndTipoDocumentoInAndEstadoInAndCreatedatBetween(
					rutEmisor, 
					tiposDocumento, 
					estadosDocumento, 
					fechaDesde, 
					fechaHasta);
			// @formatter:on

			if (!optDtes.isPresent() || optDtes.isEmpty()) {
				log.warn("No se encontraron DTE's para Emisor=" + rutEmisor + ", en el periodo=[" + fechaDesde + ", " + fechaHasta + "]");
				throw new Exception("No se encontraron dte que incluir en el libro");
			} else {
				dtes = optDtes.get();
			}

			// obtiene una instancia del documento DTEDefType
			SIIDocumentFactoryProvider provider = new SIIDocumentFactoryProvider();
			DTERoot docxml = (DTERoot) provider.getInstance("DTE");
			if (docxml == null) {
				log.error("No fue posible crear instancia de DTE");
				throw new Exception("No es posible crear instancia de DTE");
			}

			// revisa los dte del emisor
			List<DTE> result = new ArrayList<DTE>();
			for (Dte dte : dtes) {
				log.debug("Procesando dte=" + dte.getIdDocumento());
				DTE unmarshallxml = docxml.unmarshallXmlWithoutNamespace("http://www.sii.cl/SiiDte", dte.getDocumentoXml(), DTE.class);

				log.debug("- Unmarshall documento ID=" + unmarshallxml.getDocumento().getID());//.getDocumento().getID());
				result.add(unmarshallxml);
			}

			String ids = result.stream().map(a -> String.valueOf(a.getDocumento().getID())).collect(Collectors.joining(","));
			log.debug("Incluidos " + result.size() + ". ID documentos incluidos = {" + ids + "}");
			return result;

		} catch (Exception ex) {
			log.error("Se produjo un error construyendo el Resumen de Ventas Diarias. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * =========================================================================================================== ===========================================================================================================
	 */

	/**
	 * Crea un objeto Date a partir de una fecha como string <b>(ignora timestamp)</b>
	 * 
	 * @param fecha   fecha en formato String
	 * @param formato solo indicar formato incluyendo dd, MM y yyyy. <b>El timestamp sera ignorado durante la conversion</b>
	 * @return la fecha convertida a {@link java.util.Date}. Se establece la hora en 00:00:00
	 */
	private static Date convertToDate(String fecha, String formato) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
		LocalDate fechaProcesoDesde = LocalDate.parse(fecha, formatter);

		LocalDateTime localDesde = LocalDateTime.parse(fechaProcesoDesde.format(DateTimeFormatter.ISO_LOCAL_DATE) + "T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);

		Date fechaDesde = Date.from(localDesde.atZone(ZoneId.systemDefault()).toInstant());

		return fechaDesde;
	}

	/**
	 * Identificacion (Caratula) del Envio del Libro Electronico
	 * 
	 * @param emisor        rut del contribuyente Emisor
	 * @param rutFirmante   rut del usuario autorizado que hace el envio al SII
	 * @param fechaProceso  Periodo tributario en formato AAAA-MM. <br>
	 *                      Si el tipo de libro es ESPECIAL y abarca mas de un periodo se debe indicar la fecha del primer periodo tributario. <br>
	 *                      Para la DJ3328, debe indicarse el periodo del libro enviado. <b>Se debe enviar un libro por cada periodo</b>
	 * @param tipoOperacion Tipos de operacion que se declara en el Libro contable ({@link ConstantesTipoOperacionLibro}
	 * @param tipoLibro     Tipo de Libro de Compra o Venta Enviado ({@link ConstantesTipoLibro})
	 * @param tipoEnvio     Tipo de Envio del Libro Electronico ({@link ConstantesTipoEnvioLibro})
	 * @return Caratula del Libro
	 */
	public LibroCompraVenta.EnvioLibro.Caratula libroCrearCaratula(Emisores emisor, String rutFirmante, Date fechaProceso, ConstantesTipoOperacionLibro tipoOperacion, ConstantesTipoLibro tipoLibro, ConstantesTipoEnvioLibro tipoEnvio) {
		try {
			LibroCompraVenta.EnvioLibro.Caratula caratula = jaxbFactory.createLibroCompraVentaEnvioLibroCaratula();
			caratula.setFchResol(emisor.getFechaResolucion());
			caratula.setNroResol(new BigInteger(emisor.getCodigoResolucion()));

			caratula.setRutEmisorLibro(emisor.getRutemisor());
			caratula.setRutEnvia(rutFirmante);
			caratula.setTipoEnvio(tipoEnvio.getValue());
			caratula.setTipoLibro(tipoLibro.getValue());
			caratula.setTipoOperacion(tipoOperacion.getValue());

			// Periodo Tributario , en formato AAAA-MM (Año (4),Mes (2)).
			// Si tipo de Libro es ESPECIAL y abarca más de un período se debe indicar la fecha del primer período tributario.
			// Para la DJ 3328:
			// Periodo Tributario, en formato AAAA-MM (Año (4),Mes (2)).
			// Debe indicarse el período del libro enviado. Se debe enviar un libro por cada período.
			caratula.setPeriodoTributario(fechaProceso); // el tipo en jaxb tiene un adapter que extrae solo el año y mes

			// Se utiliza cuando un libro reemplaza a uno ya recibido por el SII.
			// Requiere un Código de Autorización de Reemplazo de Libro Electrónico
			// en la etiqueta <CodAutRec>
			caratula.setCodAutRec(null);

			// Folio de notificación.
			// Obligatorio si es un tipo de envío ESPECIAL
			// Para la DJ3328: Debe ser de valor fijo: 102006
			caratula.setFolioNotificacion(null);

			// Número del segmento. Sólo si el TIPO DE ENVIO es PARCIAL
			caratula.setNroSegmento(null);

			return caratula;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public LibroCompraVenta.EnvioLibro.Detalle crearDetalle(RegistroCompraVentaCSVPositionBean data, Integer fctProp) {
		try {
			LibroCompraVenta.EnvioLibro.Detalle record = jaxbFactory.createLibroCompraVentaEnvioLibroDetalle();

			if (data.getAnulado() != null && data.getAnulado().trim().equalsIgnoreCase("A")) {
				// el documento fue anulado
				log.debug("Documento NroDoc=" + data.getNroDoc() + ", ANULADO. Se informa lo minimo en el registro");
				record.setTpoDoc(data.getTpoDoc());
				record.setNroDoc(data.getNroDoc());
				record.setAnulado(data.getAnulado().trim().toUpperCase());

				return record;
			}
			record.setCdgSIISucur(data.getCdgSIISucur());
			record.setCredEC(null); // para normalizar
			record.setDepEnvase(null); // para normalizar
			record.setEmisor(data.getEmisor());

			// --------------------------------------------------------------
			// atributos compuestos
			// --------------------------------------------------------------

			// extranjero
			//--> LibroCompraVenta.EnvioLibro.Detalle.Extranjero extranjero = jaxbFactory.createLibroCompraVentaEnvioLibroDetalleExtranjero();
			//--> extranjero.setNacionalidad(null);
			//--> extranjero.setNumId(null);
			//--> record.setExtranjero(extranjero);
			record.setExtranjero(null); // para normalizar

			// liquidaciones
			//--> LibroCompraVenta.EnvioLibro.Detalle.Liquidaciones liquidaciones = jaxbFactory.createLibroCompraVentaEnvioLibroDetalleLiquidaciones();
			//--> liquidaciones.setRutEmisor(null);
			//--> liquidaciones.setValComExe(null);
			//--> liquidaciones.setValComIVA(null);
			//--> liquidaciones.setValComNeto(null);
			//--> record.setLiquidaciones(liquidaciones);
			record.setLiquidaciones(null); // para normalizar

			// ==================================================================

			// resto de los atributos
			Locale loc = new Locale("es", "CL");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", loc);
			Date dateFchDoc = formatter.parse(data.getFchDoc());

			record.setFchDoc(dateFchDoc);
			record.setFolioDocRef(null); // para normalizar
			record.setImpVehiculo(data.getImpVehiculo());
			record.setIndFactCompra(null); // para normalizar
			record.setIndServicio(null); // para normalizar
			record.setIndSinCosto(null); // para normalizar
			record.setIVAFueraPlazo(null); // para normalizar
			record.setIVANoRetenido(null); // para normalizar
			record.setIVAPropio(null); // para normalizar
			record.setIVARetParcial(null); // para normalizar
			record.setIVARetTotal(null); // para normalizar
			record.setIVATerceros(null); // para normalizar
			record.setIVAUsoComun(null); // para normalizar
			record.setLey18211(null); // para normalizar

			record.setMntActivoFijo(data.getMntActivoFijo());
			record.setMntExe(data.getMntExe());
			record.setMntIVA(data.getMntIVA());

			record.setMntIVAActivoFijo(data.getMntIVAActivoFijo());
			record.setMntNeto(data.getMntNeto());
			record.setMntNoFact(null); // para normalizar
			record.setMntPeriodo(null); // para normalizar
			record.setMntSinCred(data.getMntSinCred());
			record.setMntTotal(null /** TODO: SUMAR RESTAR */
			); // *************************************
			record.setNroDoc(data.getNroDoc());
			record.setNumInt(data.getNumInt());
			//--> record.setOperacion(null);
			record.setPsjInt(null); // para normalizar
			record.setPsjNac(null); // para normalizar
			record.setRUTDoc(data.getRUTDoc());
			record.setRznSoc(data.getRznSoc() != null ? data.getRznSoc().substring(0, 50) : null);

			record.setTabCigarrillos(data.getTabCigarrillos());
			record.setTabElaborado(data.getTabElaborado());
			record.setTabPuros(data.getTabPuros());
			record.setTasaImp(data.getTasaImp());
			record.setTpoDoc(data.getTpoDoc());
			record.setTpoDocRef(null); // para normalizar
			record.setTpoImp(data.getTpoImp());

			// factor de proporcionalidad
			// se define en el proceso. no es parte del 'record'
			if (fctProp != null) {
				if (record.getIVAUsoComun() == null) {
					BigDecimal temp = (new BigDecimal(record.getMntNeto())).multiply(record.getTasaImp().divide(new BigDecimal(100)));
					record.setIVAUsoComun(temp.toBigInteger());
				}
			} else {
				if (data.getMntIVA() != null && !isArray(data.getIVANoRec()) && data.getTasaImp() != null && data.getMntNeto() != null) {
					BigDecimal temp = (new BigDecimal(record.getMntNeto()).multiply(record.getTasaImp().divide(new BigDecimal(100))));
					record.setMntIVA(temp.toBigInteger());
				}
			}

			// si el monto total es 0, y no se ha asignado neto => se asigna neto 0
			if (record.getMntExe() == null && record.getMntNeto() == null && record.getMntTotal() == BigInteger.ZERO) {
				record.setMntNeto(BigInteger.ZERO);
			}

			// colocar montos que faltan
			if (record.getMntNeto() == null && record.getMntExe() == null) {
				record.setTasaImp(new BigDecimal(SiiDocumentFactoryConfiguration.TASA_IVA));
				record.setMntNeto(BigInteger.ZERO);
				record.setMntIVA(BigInteger.ZERO);
			}

			// TODO: REVISAR -- normalizar iva no recuperable
			if (!data.getIVANoRec().isEmpty()) {
				//--> if(record.getIVANoRecs().get(0) == null) 
				if (data.getIVANoRec_CodIVANoRec().indexOf(",") >= 0) {
					String[] codIvaNoRec = data.getIVANoRec_CodIVANoRec().split(",");
					String[] mntIvaNoRec = data.getIVANoRec_MntIVANoRec().split(",");
					for (int i = 0; i < codIvaNoRec.length; i++) {
						// IVA No Rec
						LibroCompraVenta.EnvioLibro.Detalle.IVANoRec ivaNoRec = jaxbFactory.createLibroCompraVentaEnvioLibroDetalleIVANoRec();
						ivaNoRec.setCodIVANoRec(new BigInteger(codIvaNoRec[i]));
						ivaNoRec.setMntIVANoRec(new BigInteger(mntIvaNoRec[i]));
						record.getIVANoRecs().add(ivaNoRec);
					}
				}

			} else {
				record.getIVANoRecs().clear(); // para normalizar				
			}

			// otros impuestos
			if (!data.getOtrosImp().isEmpty()) {
				//--> if(record.getOtrosImps().get(0) == null ) record.getOtrosImps().add(data.getOtrosImp());
				if (data.getOtrosImp_CodImp().indexOf(",") >= 0) {
					String[] codImp = data.getOtrosImp_CodImp().split(",");
					String[] tasaImp = data.getOtrosImp_TasaImp().split(",");
					String[] mntImp = data.getOtrosImp_MntImp().split(",");
					for (int i = 0; i < codImp.length; i++) {
						LibroCompraVenta.EnvioLibro.Detalle.OtrosImp otrosImp = jaxbFactory.createLibroCompraVentaEnvioLibroDetalleOtrosImp();
						otrosImp.setCodImp(new BigInteger(codImp[i]));
						otrosImp.setMntImp(new BigInteger(mntImp[i]));
						if (tasaImp[i] != null) {
							otrosImp.setTasaImp(new BigDecimal(tasaImp[i]));
						}
						record.getOtrosImps().add(otrosImp);
					}
				}

				// calcular y agregar iva no retenido
				int idx = 0;
				ImpuestoRecord[] impuestoRecord = new ImpuestoRecord[record.getOtrosImps().size()];
				for (LibroCompraVenta.EnvioLibro.Detalle.OtrosImp xx : record.getOtrosImps()) {
					impuestoRecord[idx].setCodigoImpuesto(xx.getCodImp().toString().trim().toUpperCase());
					impuestoRecord[idx].setMontoImpuesto(new BigDecimal(xx.getMntImp()));
				}
				BigDecimal retenido = ImpuestosAdicionales.getRetenido(impuestoRecord);

				if (BigDecimal.ZERO.compareTo(retenido) != 0) {
					if (record.getMntIVA().equals(retenido.toBigInteger())) {
						// el iva retenido es total
						record.setIVARetTotal(retenido.toBigInteger());
					} else {
						// el iva retenido es parcial
						record.setIVARetParcial(retenido.toBigInteger());
						record.setIVANoRetenido(record.getMntIVA().subtract(retenido.toBigInteger()));
					}
				}
			}

			// calcula monto total si no se especifico
			if(data.getMntTotal()==null) {
				// calcula monto total inicial
				BigInteger montoTotal = data.getMntExe().add(data.getMntNeto()).add(data.getMntIVA());
				
				// agrega iva no recuperable al total
				if( record.getIVANoRecs().size() > 0 ) {
					for(IVANoRec item:record.getIVANoRecs()) {
						montoTotal.add(item.getMntIVANoRec());
					}
				}
				
				// agregar iva de uso comun al monto total
				if (fctProp != null) {
					montoTotal.add(record.getIVAUsoComun());
				}
				
				// descontar del total la retencion total del IVA
				if(record.getOtrosImps().size()>0) {
					for(OtrosImp item:record.getOtrosImps()) {
						montoTotal.subtract(item.getMntImp());
					}
				}
				
				// agregar otros montos e impuestos al total
				montoTotal.add(data.getMntSinCred()).add(data.getTabPuros()).add(data.getTabCigarrillos()).add(data.getTabElaborado()).add(data.getImpVehiculo());
				
				// asigna el monto total resultante
				record.setMntTotal(montoTotal);
			}

			// si no hay monto neto, campos del iva son null
			if( data.getMntNeto() == null ) {
				record.setMntNeto(null);
				record.setTasaImp(null);
				record.setMntIVA(null);
			}
			
			// si no se indica codigo de sucursal se pone en nulo
			if( data.getCdgSIISucur()==null) {
				record.setCdgSIISucur(null);
			}
			
			// retorna el registro calculado
			return record;

		} catch (Exception ex) {
			log.error("Se produjo un error creando registro de  venta. Error=" + ex.getMessage());
			return null;
		}
	}

	private boolean isArray(Object abc) {
		boolean x = abc.getClass().isArray();
		return x;
	}

	/**
	 * Resumen del Segmento de Informacion Enviado
	 * 
	 * @return
	 */
	public LibroCompraVenta.EnvioLibro.ResumenSegmento libroCrearResumenSegmento() {
		try {
			LibroCompraVenta.EnvioLibro.ResumenSegmento resumenSegmento = jaxbFactory.createLibroCompraVentaEnvioLibroResumenSegmento();

			List<TotalesSegmento> totalesSegmentos = new ArrayList<TotalesSegmento>();

			TotalesSegmento totalSegmento = jaxbFactory.createLibroCompraVentaEnvioLibroResumenSegmentoTotalesSegmento();
			totalSegmento.setTotAnulado(null);
			totalSegmento.setTotCredEC(null);
			totalSegmento.setTotDepEnvase(null);
			totalSegmento.setTotDoc(null);
			totalSegmento.setTotImpSinCredito(null);
			totalSegmento.setTotIVAFueraPlazo(null);
			totalSegmento.setTotIVANoRetenido(null);
			totalSegmento.setTotIVAPropio(null);
			totalSegmento.setTotIVARetParcial(null);
			totalSegmento.setTotIVARetTotal(null);
			totalSegmento.setTotIVATerceros(null);
			totalSegmento.setTotIVAUsoComun(null);
			totalSegmento.setTotLey18211(null);

			LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotLiquidaciones totLiquidaciones = jaxbFactory.createLibroCompraVentaEnvioLibroResumenSegmentoTotalesSegmentoTotLiquidaciones();
			totLiquidaciones.setTotValComExe(null);
			totLiquidaciones.setTotValComIVA(null);
			totLiquidaciones.setTotValComNeto(null);

			totalSegmento.setTotLiquidaciones(totLiquidaciones);

			totalSegmento.setTotMntActivoFijo(null);
			totalSegmento.setTotMntExe(null);
			totalSegmento.setTotMntIVA(null);
			totalSegmento.setTotMntIVAActivoFijo(null);
			totalSegmento.setTotMntNeto(null);
			totalSegmento.setTotMntNoFact(null);
			totalSegmento.setTotMntPeriodo(null);
			totalSegmento.setTotMntTotal(null);
			totalSegmento.setTotOpActivoFijo(null);
			totalSegmento.setTotOpExe(null);
			totalSegmento.setTotOpIVANoRetenido(null);
			totalSegmento.setTotOpIVARec(null);
			totalSegmento.setTotOpIVARetParcial(null);
			totalSegmento.setTotOpIVARetTotal(null);
			totalSegmento.setTotOpIVAUsoComun(null);
			totalSegmento.setTotPsjInt(null);
			totalSegmento.setTotPsjNac(null);
			totalSegmento.setTotTabCigarrillos(null);
			totalSegmento.setTotTabElaborado(null);
			totalSegmento.setTotTabPuros(null);
			totalSegmento.setTpoDoc(null);
			totalSegmento.setTpoImp(null);

			totalesSegmentos.add(totalSegmento);

			resumenSegmento.getTotalesSegmentos().addAll(totalesSegmentos);

			return resumenSegmento;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Resumen Para el Periodo Tributario
	 * 
	 * @return
	 */
	public LibroCompraVenta.EnvioLibro.ResumenPeriodo libroCrearResumenPeriodo() {
		try {
			LibroCompraVenta.EnvioLibro.ResumenPeriodo resumenPeriodo = jaxbFactory.createLibroCompraVentaEnvioLibroResumenPeriodo();

			List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo> totalesPeriodos = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo>();
			LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo totalPeriodo = jaxbFactory.createLibroCompraVentaEnvioLibroResumenPeriodoTotalesPeriodo();
			totalPeriodo.setFctProp(null);
			totalPeriodo.setTotAnulado(null);
			totalPeriodo.setTotCredEC(null);
			totalPeriodo.setTotCredIVAUsoComun(null);
			totalPeriodo.setTotDepEnvase(null);
			totalPeriodo.setTotDoc(null);
			totalPeriodo.setTotImpSinCredito(null);
			totalPeriodo.setTotImpVehiculo(null);
			totalPeriodo.setTotIVAFueraPlazo(null);
			totalPeriodo.setTotIVANoRetenido(null);
			totalPeriodo.setTotIVAPropio(null);
			totalPeriodo.setTotIVARetParcial(null);
			totalPeriodo.setTotIVARetTotal(null);
			totalPeriodo.setTotIVATerceros(null);
			totalPeriodo.setTotIVAUsoComun(null);
			totalPeriodo.setTotLey18211(null);

			LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotLiquidaciones totalLiquidaciones = jaxbFactory.createLibroCompraVentaEnvioLibroResumenPeriodoTotalesPeriodoTotLiquidaciones();
			totalLiquidaciones.setTotValComExe(null);
			totalLiquidaciones.setTotValComIVA(null);
			totalLiquidaciones.setTotValComNeto(null);
			totalPeriodo.setTotLiquidaciones(totalLiquidaciones);

			totalPeriodo.setTotMntActivoFijo(null);
			totalPeriodo.setTotMntExe(null);
			totalPeriodo.setTotMntIVA(null);
			totalPeriodo.setTotMntIVAActivoFijo(null);
			totalPeriodo.setTotMntNeto(null);
			totalPeriodo.setTotMntNoFact(null);
			totalPeriodo.setTotMntPeriodo(null);
			totalPeriodo.setTotMntTotal(null);
			totalPeriodo.setTotOpActivoFijo(null);
			totalPeriodo.setTotOpExe(null);
			totalPeriodo.setTotOpIVANoRetenido(null);
			totalPeriodo.setTotOpIVARec(null);
			totalPeriodo.setTotOpIVARetParcial(null);
			totalPeriodo.setTotOpIVARetTotal(null);
			totalPeriodo.setTotOpIVAUsoComun(null);
			totalPeriodo.setTotPsjInt(null);
			totalPeriodo.setTotPsjNac(null);
			totalPeriodo.setTotTabCigarrillos(null);
			totalPeriodo.setTotTabElaborado(null);
			totalPeriodo.setTotTabPuros(null);
			totalPeriodo.setTpoDoc(null);
			totalPeriodo.setTpoImp(null);

			totalesPeriodos.add(totalPeriodo);

			resumenPeriodo.getTotalesPeriodos().addAll(totalesPeriodos);

			return resumenPeriodo;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Comprobante de Certificacion
	 * 
	 * @return
	 */
	public LceCoCertif libroCrearLceCoCertif() {
		try {
			// Documento de Comprobante de Certificacion
			LceCal.DocumentoCal documentoCal = jaxbFactory.createLceCalDocumentoCal();
			documentoCal.setClase("clase");
			documentoCal.setFchEmision(null);
			documentoCal.setID(null);
			documentoCal.setPeriodoVigencia(null);
			documentoCal.setRutDistribuidor(null);
			documentoCal.setTipoCertificado(null);
			documentoCal.setTipoLCE(null);
			documentoCal.setTmstFirma(null);

			LceCal lcecal = jaxbFactory.createLceCal();
			lcecal.setDocumentoCal(documentoCal);
			lcecal.setSignature(null);
			lcecal.setVersion(null);

			LceCoCertif.DocumentoCoCertif documentoCertif = jaxbFactory.createLceCoCertifDocumentoCoCertif();
			documentoCertif.setFchEmision(null);
			documentoCertif.setID(null);
			documentoCertif.setLceCal(lcecal);
			documentoCertif.setRutContribuyente(null);
			documentoCertif.setRutFirmanteDistribuidor(null);
			documentoCertif.setTmstFirma(null);

			LceCoCertif lcecoCertif = jaxbFactory.createLceCoCertif();
			lcecoCertif.setDocumentoCoCertif(documentoCertif);
			lcecoCertif.setSignature(null);
			lcecoCertif.setVersion(null);

			return lcecoCertif;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/**
	 * Certificado Autorizacion de Libros, generado por el SII
	 * 
	 * @return
	 */
	public LceCal libroCrearLceCal() {
		try {
			LceCal.DocumentoCal documentoCal = jaxbFactory.createLceCalDocumentoCal();
			documentoCal.setClase("clase");
			documentoCal.setFchEmision(null);
			documentoCal.setID(null);
			documentoCal.setPeriodoVigencia(null);
			documentoCal.setRutDistribuidor(null);
			documentoCal.setTipoCertificado(null);
			documentoCal.setTipoLCE(null);
			documentoCal.setTmstFirma(null);

			LceCal lcecal = jaxbFactory.createLceCal();
			lcecal.setDocumentoCal(documentoCal);
			lcecal.setSignature(null);
			lcecal.setVersion(null);

			return lcecal;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
