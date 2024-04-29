package cl.fapp.restapi.controller.dte.mapper;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.xml.NoNamespaceWriter;
import cl.fapp.common.xml.XMLUtils;
import cl.fapp.domain.mapper.MapperUtils;
import cl.fapp.foliomanager.FolioManager;
import cl.fapp.foliomanager.domain.Folio;
import cl.fapp.restapi.controller.dte.dto.DTEAndVerbatimCAF;
import cl.fapp.restapi.dte.domain.DTEDescuentoRecargo;
import cl.fapp.restapi.dte.domain.DTEDetalle;
import cl.fapp.restapi.dte.domain.DTEDocumento;
import cl.fapp.restapi.dte.domain.DTEEmisor;
import cl.fapp.restapi.dte.domain.DTEReceptor;
import cl.fapp.restapi.dte.domain.DTEReferencia;
import cl.fapp.restapi.dte.dto.GenerarDTERequest;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerarDTEControllerMapper {
	private static final String MONTO_EXENTO = "MntExe";
	private static final String MONTO_NETO = "MntNeto";
	private static final String MONTO_TOTAL = "MntTotal";
	private static final String MONTO_NF = "MontoNF";

	@Autowired
	FolioManager foliomanager;

	ObjectFactory jaxbFactory = new ObjectFactory();

	private static String extractContent(String input) {
		// Definir el patrón de la expresión regular
		Pattern pattern = Pattern.compile("<RSASK>(.+?)</RSASK>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(input);

		// Encontrar la coincidencia y extraer el contenido
		if (matcher.find()) {
			return matcher.group(1).trim();
		} else {
			return "No se encontró contenido entre las etiquetas <RSASK>.";
		}
	}

	/**
	 * Mapping del request DTO {@link GenerarDTERequest} a JAXB List<{@link DTE}>
	 * 
	 * @param request       DTO
	 * @param tipoDocumento Integer representando el tipo de documento que se debe
	 *                      procesar
	 * @return tantos List<{@link DTEAndVerbatimCAF}> como documentos se indican en
	 *         el request, adjuntando el CAF apropiado (segun tipoDocumento) en cada
	 *         caso
	 */
	public List<DTEAndVerbatimCAF> toDTEDocumento(GenerarDTERequest request, Integer tipoDocumento) {
		// valores globales
		ConstantesTipoDocumento enumTipoDocumento = ConstantesTipoDocumento.valueOf(tipoDocumento);
		Date fechaEmision = new Date();

		// visita cada documento especificado en el arreglo
		Folio folio;

		List<DTEAndVerbatimCAF> jaxbDTE = new ArrayList<DTEAndVerbatimCAF>();
		for (DTEDocumento documento : request.getDtes()) {
			String idDocumento = "";
			documento.setTipodocumento(tipoDocumento);
			try {

				// se crea cada porcion del documento por separado (el folio se establece
				// posteriormente, por eso el ultimo parametro es null)
				DTE.Documento.Encabezado encabezado = obtenerEncabezado(request.getEmisor(), documento, fechaEmision,
						null);
				List<DTE.Documento.Detalle> jaxbDetalles = obtenerDetalles(documento);
				List<DTE.Documento.Referencia> jaxbReferencias = obtenerReferencias(documento);
				List<DTE.Documento.DscRcgGlobal> jaxbDescuentosRecargos = obtenerDescuentosRecargos(documento);
				List<DTE.Documento.SubTotInfo> jaxbSubtotinfos = obtenerSubtotInfo(documento);

				// agrega totales al encabezado
				DTE.Documento.Encabezado.Totales jaxbTotales = obtenerTotales(documento,
						SiiDocumentFactoryConfiguration.TASA_IVA);

				// se ajustan montos dependiendo si es afecta/exenta
				switch (enumTipoDocumento) {
					case FACTURA_EXENTA:
						log.debug("Ajustando montos (exento=null y total=0) en FACTURA_EXENTA...");
						jaxbTotales.setMntExe(null);
						jaxbTotales.setMntTotal(BigInteger.ZERO);
						break;
					case FACTURA_AFECTA:
						log.debug("No se ajustan montos en FACTURA_AFECTA...");
						break;
					default:
						log.warn("Tipo documento (" + enumTipoDocumento.getValue() + ") => No se ajustan montos...");
				}

				// establece totales en el encabezado
				encabezado.setTotales(jaxbTotales);

				// aplica descuentos/recargos
				log.debug("INICIO - Aplicando descuentos/recargos globales...");
				DTE.Documento.Encabezado encabezadoActualizado = aplicarDescuentosRecargosGlobales(encabezado,
						jaxbDescuentosRecargos);
				encabezado = encabezadoActualizado;
				log.debug("FIN - Aplicando descuentos/recargos globales.");

				// obtiene un folio para asignar al documento
				try {
					folio = foliomanager.getFolio(request.getRutEmisor(), tipoDocumento);

					// actualiza el folio en el encabezado del documento
					encabezado.getIdDoc().setFolio(BigInteger.valueOf(folio.getCardinal()));
					log.debug("Se obtuvo folio=" + folio.getCardinal() + ", para tipo_documento=" + tipoDocumento);

					// crea un string para identificar al documento. Incluye el folio en su nombre
					switch (enumTipoDocumento) {
						case FACTURA_AFECTA:
							idDocumento = BuilderXmlID.getIDforFacturaAfecta(folio.getCardinal());
							break;

						case FACTURA_EXENTA:
							idDocumento = BuilderXmlID.getIDforFacturaExenta(folio.getCardinal());
							break;

						case NOTA_CREDITO:
							idDocumento = BuilderXmlID.getIDforNotaCredito(folio.getCardinal());
							break;

						case NOTA_DEBITO:
							idDocumento = BuilderXmlID.getIDforNotaDebito(folio.getCardinal());
							break;

						default:
							log.error("No existe definición de Identificador de documento para el tipo de documento: "
									+ tipoDocumento);
							return null;
					}
				} catch (Exception ex) {
					log.error("No fue posible obtener un folio. Error: " + ex.getMessage());
					return null;
				}

				// hace el unmarshall al tagCaf del folio
				DTE.Documento.TED.DD.CAF cafDTE = MapperUtils.loadCafFromRepository(folio);
				DTE.Documento.TED.DD.CAF caf = MapperUtils.convertToDTECAF(cafDTE);

				// documento - TED - DD
				DTE.Documento.TED.DD dd = jaxbFactory.createDTEDocumentoTEDDD();

				// en la formacion del DD el CAF se maneja como jaxb
				dd.setCAF(caf);
				dd.setF(BigInteger.valueOf(folio.getCardinal()));
				dd.setFE(fechaEmision);
				dd.setIT1(jaxbDetalles.get(0).getNmbItem()); // .getDscItem());
				dd.setMNT(encabezado.getTotales().getMntTotal());
				dd.setRE(encabezado.getEmisor().getRUTEmisor());
				dd.setRR(encabezado.getReceptor().getRUTRecep());
				dd.setRSR(encabezado.getReceptor().getRznSocRecep());
				dd.setTD(encabezado.getIdDoc().getTipoDTE());
				dd.setTSTED(fechaEmision);
				// ===================================================================================

				// ---------------------
				// se firma el documento
				// ---------------------
				// - recupera la llave privada que esta en el caf
				String tagRsask = folio.getRsask();

				// Encabezados a buscar
				String beginMarker = "-----BEGIN RSA PRIVATE KEY-----";
				String endMarker = "-----END RSA PRIVATE KEY-----";

				// Encuentra las posiciones de los encabezados
				int beginIndex = tagRsask.indexOf(beginMarker);
				int endIndex = tagRsask.indexOf(endMarker) + endMarker.length();

				// Extrae la subcadena que contiene la llave
				String rsask = tagRsask.substring(beginIndex, endIndex);
				rsask = rsask.replaceAll(beginMarker, "")
						.replaceAll(endMarker, "")
						.replaceAll("\\s", "");

				// recupera la llave rsask
				byte[] keyBytes = Base64.getDecoder().decode(rsask);

				// construye una RSAPrivateKey a partir de los datos rsask almacenados en el caf
				RSAPrivateKey privateKey = (RSAPrivateKey) MapperUtils.readPkcs1PrivateKey(keyBytes);

				// crea una instancia jaxb del objeto DD
				JAXBContext contextDD = JAXBContext.newInstance(DTE.Documento.TED.DD.class);
				Marshaller marshallerDD = contextDD.createMarshaller();
				marshallerDD.setProperty(Marshaller.JAXB_ENCODING, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);
				marshallerDD.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
				marshallerDD.setProperty(Marshaller.JAXB_FRAGMENT, true);
				marshallerDD.setSchema(null);

				// -----------------------------------------------
				// crea un writer para acumular el xml resultante
				StringWriter swxmlDD = new StringWriter();

				// el esquema de DTE incluye declaracion de namespace, pero este no es aceptado
				// por SII cuando se obtiene el TED
				// por lo que deben eliminarse las declaraciones de namespace, para ello se
				// implementa un XMLWriter que descarta
				// la escritura de namespaces del xml resultante
				XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
				XMLStreamWriter xmlStreamWriter = outputFactory.createXMLStreamWriter(swxmlDD);

				NoNamespaceWriter mywriter = new NoNamespaceWriter(xmlStreamWriter);
				marshallerDD.marshal(dd, mywriter);
				mywriter.flush();
				xmlStreamWriter.flush();

				// convierte el stream a string
				String xmlDD = swxmlDD.toString();

				log.debug("DD a firmar: " + xmlDD);
				// -->log.debug("DD despues: " + marshalledObject);
				// -----------------------------------------------

				// se firma el xml del DD
				Signature dmSignature = Signature.getInstance(SiiDocumentFactoryConfiguration.DD.SIGNATURE_ALGORITHM);
				dmSignature.initSign(privateKey);
				dmSignature.update(xmlDD.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));

				// se codifica el dd firmado
				byte[] xmlsigned = dmSignature.sign();
				String signedDD = new String(xmlsigned, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);

				// documento - TED - FRMT
				DTE.Documento.TED.FRMT frmt = jaxbFactory.createDTEDocumentoTEDFRMT();
				frmt.setAlgoritmo(SiiDocumentFactoryConfiguration.DD.SIGNATURE_ALGORITHM);
				frmt.setValue(signedDD.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));

				// documento - TED
				DTE.Documento.TED ted = jaxbFactory.createDTEDocumentoTED();

				// -----------------------------------------------------------------------------------------------
				// el caf se reemplaza posteriormente con la porcion de xml entregada por el sii
				// entonces, en esta fase, solo se crea espacio para el tag CAF, no para DA ni
				// FRMT
				// ese tag servira para reemplazar por el texto del sii
				DTE.Documento.TED.DD.CAF emptycaf = jaxbFactory.createDTEDocumentoTEDDDCAF();
				emptycaf.setDA(null);
				emptycaf.setFRMA(null);
				emptycaf.setVersion(null);

				// se limpia la porcion caf de DD para ser reemplazada con el texto del sii,
				// pero se conserva la firma
				dd.setCAF(emptycaf);

				// -----------------------------------------------------------------------------------------------
				ted.setDD(dd);
				ted.setFRMT(frmt);
				ted.setVersion("1.0");

				// se crea el documento
				DTE.Documento documentoDTE = jaxbFactory.createDTEDocumento();
				documentoDTE.setEncabezado(encabezado);
				documentoDTE.getDetalles().addAll(jaxbDetalles);
				documentoDTE.getDscRcgGlobals().addAll(jaxbDescuentosRecargos);
				documentoDTE.getReferencias().addAll(jaxbReferencias);
				documentoDTE.getSubTotInfos().addAll(jaxbSubtotinfos);

				// propiedades del documento
				documentoDTE.setID(idDocumento);
				documentoDTE.setTED(ted);
				documentoDTE.setTmstFirma(fechaEmision);

				// crea el DTE (que puede ser firmado)
				DTE dte = jaxbFactory.createDTE();
				dte.setDocumento(documentoDTE);
				dte.setVersion(BigDecimal.valueOf(1.0));
				dte.setSignature(null);

				// agrega el DTE a la lista de DTEs
				DTEAndVerbatimCAF element = new DTEAndVerbatimCAF();
				element.setDte(dte);
				element.setVerbatimcaf(folio.getTagCaf());

				jaxbDTE.add(element);

			} catch (Exception ex) {
				log.error("No fue posible construir DTE. Error: " + ex.getMessage(), ex);
				return null;
			}
		}

		return jaxbDTE;
	}

	/**
	 * Crea un encabezado de tipo {@link DTE.Documento.Encabezado} para crear el DTE
	 *
	 * @param emisor       emisor del documento
	 * @param request      los datos del request al servicio
	 * @param fechaEmision fecha de emision del documento
	 * @param folio        numero de folio asignado
	 * @return un objeto jaxb del encabezado para agregar al documento
	 */
	private DTE.Documento.Encabezado obtenerEncabezado(DTEEmisor emisor, DTEDocumento request, Date fechaEmision,
			BigInteger folio) {

		try {
			if (request == null) {
				log.error("El objeto request es nulo.");
				throw new RuntimeException("El objeto request es nulo.");
			}
			DTEReceptor receptor = request.getReceptor();
			if (receptor == null) {
				log.error("El objeto receptor en request es nulo.");
				throw new RuntimeException("El receptor es nulo o le falta información.");
			}

			// encabezado del dte
			DTE.Documento.Encabezado.Emisor jaxbEmisor = jaxbFactory.createDTEDocumentoEncabezadoEmisor();
			jaxbEmisor.setGiroEmis(XMLUtils.replaceSiiEspecialChars(emisor.getGiroEmisor()));
			jaxbEmisor.setRUTEmisor(emisor.getRutEmisor());
			jaxbEmisor.setRznSoc(XMLUtils.replaceSiiEspecialChars(emisor.getRazonSocialEmisor()));

			jaxbEmisor.setCdgSIISucur(emisor.getCodigoSii() == null ? null : new BigInteger(emisor.getCodigoSii()));
			jaxbEmisor.setCmnaOrigen(emisor.getComunaEmisor());
			jaxbEmisor.setCiudadOrigen(emisor.getCiudadEmisor());
			jaxbEmisor.setDirOrigen(XMLUtils.replaceSiiEspecialChars(emisor.getDireccionEmisor()));

			jaxbEmisor.getActecos().addAll(emisor.getActecos());

			// encabezado - identificador del documento
			DTE.Documento.Encabezado.IdDoc jaxbIddoc = jaxbFactory.createDTEDocumentoEncabezadoIdDoc();
			jaxbIddoc.setFchEmis(fechaEmision);
			jaxbIddoc.setFolio(folio);
			jaxbIddoc.setIndServicio(BigInteger.valueOf(request.getIndicadorservicio()));

			// TODO: exponer indicador monto bruto en la api?
			jaxbIddoc.setMntBruto(BigInteger.valueOf(1));

			// factura afecta/exenta, nota credito/debito
			jaxbIddoc.setTipoDTE(BigInteger.valueOf(request.getTipodocumento())); // -->BigInteger.valueOf(request.getTipodocumento().getValue()));
			// -->iddoc.setFchVenc(fchvenc);
			// -->iddoc.setPeriodoDesde(periododesde);
			// -->iddoc.setPeriodoHasta(periodohasta);

			// encabezado - receptor
			DTE.Documento.Encabezado.Receptor jaxbReceptor = jaxbFactory.createDTEDocumentoEncabezadoReceptor();
			jaxbReceptor.setCdgIntRecep(receptor.getCodigoInterno());
			jaxbReceptor.setCiudadPostal(receptor.getCiudadPostal());
			jaxbReceptor.setCiudadRecep(receptor.getCiudad());
			jaxbReceptor.setCmnaPostal(receptor.getComunaPostal());
			jaxbReceptor.setCmnaRecep(receptor.getComuna());
			jaxbReceptor.setContacto(XMLUtils.replaceSiiEspecialChars(receptor.getContacto()));
			jaxbReceptor.setDirPostal(receptor.getDireccionPostal());
			jaxbReceptor.setDirRecep(XMLUtils.replaceSiiEspecialChars(receptor.getDireccion()));
			jaxbReceptor.setRUTRecep(receptor.getRut());
			jaxbReceptor.setRznSocRecep(XMLUtils.replaceSiiEspecialChars(receptor.getRazonsocial()));
			jaxbReceptor.setGiroRecep(XMLUtils.replaceSiiEspecialChars(receptor.getGiro()));
			jaxbReceptor.setCorreoRecep(receptor.getCorreo());
			// encabezado - totales (Montos totales del DTE)
			// se calcula en forma independiente, despues de procesar el detalle

			// encabezado - establece encabezado
			DTE.Documento.Encabezado encabezado = jaxbFactory.createDTEDocumentoEncabezado();
			encabezado.setEmisor(jaxbEmisor);
			encabezado.setIdDoc(jaxbIddoc);
			encabezado.setReceptor(jaxbReceptor);
			encabezado.setTotales(null);

			return encabezado;

		} catch (Exception ex) {
			log.error("No fue posible crear el encabezado del DTE. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea un detalle de tipo {@link List<DTE.Documento.Detalle>}
	 *
	 * @param documento documento especifico indicado en el request
	 * @return el detalle asociado al documento
	 */
	private List<DTE.Documento.Detalle> obtenerDetalles(DTEDocumento documento) {
		try {
			int nrolinea = 0;
			List<DTE.Documento.Detalle> jaxbDetalles = new ArrayList<DTE.Documento.Detalle>();

			// traspasa el detalle de cada DTE
			for (DTEDetalle detalle : documento.getDetalle()) {
				nrolinea++;
				DTE.Documento.Detalle jaxbDetalle = new DTE.Documento.Detalle();
				jaxbDetalle.setNroLinDet(nrolinea);
				jaxbDetalle.setIndExe(detalle.getIndicadorExencion() == null ? null
						: BigInteger.valueOf(detalle.getIndicadorExencion()));
				// -->jaxbDetalle.setItemEspectaculo(null);
				// -->jaxbDetalle.setRUTMandante(detalle.getRutMandante());
				jaxbDetalle.setNmbItem(XMLUtils.replaceSiiEspecialChars(detalle.getNombreproducto()));
				// -->jaxbDetalle.setInfoTicket(null);
				jaxbDetalle.setDscItem(XMLUtils.replaceSiiEspecialChars(detalle.getDescripcionItem()));
				jaxbDetalle.setQtyItem(new BigDecimal(detalle.getCantidadproducto()));
				jaxbDetalle.setUnmdItem(detalle.getUmproducto());
				jaxbDetalle.setPrcItem(detalle.getPrecioItem());
				jaxbDetalle.setDescuentoPct(detalle.getDescuentoPct());
				jaxbDetalle.setDescuentoMonto(detalle.getDescuentoMonto());
				jaxbDetalle.setRecargoPct(detalle.getRecargoPct());
				jaxbDetalle.setRecargoMonto(detalle.getRecargoMonto());
				jaxbDetalle.setMontoItem(BigInteger.valueOf(detalle.getMontoitem().longValue()));

				// TODO: no se establece valor para CdgItems
				jaxbDetalle.getCdgItems();

				// agrega a la lista de detalles
				jaxbDetalles.add(jaxbDetalle);
			}

			return jaxbDetalles;

		} catch (Exception ex) {
			log.error("No fue posible crear los detalles del DTE. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea la porcion referencias del documento
	 *
	 * @param documento el documento es pecifico indicado en el request
	 * @return lista de referencias asociadas al documento
	 */
	private List<DTE.Documento.Referencia> obtenerReferencias(DTEDocumento documento) {
		try {
			int nrolinea = 0;
			List<DTE.Documento.Referencia> jaxbReferencias = new ArrayList<>();
			for (DTEReferencia referencia : documento.getReferencias()) {
				nrolinea++;
				DTE.Documento.Referencia jaxbReferencia = jaxbFactory.createDTEDocumentoReferencia();
				// -->jaxbReferencia.setCodCaja(referencia.getCodcaja());
				jaxbReferencia.setCodRef(new BigInteger(referencia.getCodref()));
				log.info("CodRef: " + referencia.getCodref());
				// -->jaxbReferencia.setCodVndor(referencia.getCodvndor());
				jaxbReferencia.setNroLinRef(nrolinea);
				log.info("NroLinRef: " + nrolinea);
				jaxbReferencia.setRazonRef(XMLUtils.replaceSiiEspecialChars(referencia.getRazonref()));
				log.info("RazonRef: " + referencia.getRazonref());

				if (referencia.getFolioRef() != null) {
					jaxbReferencia.setFolioRef(String.valueOf(referencia.getFolioRef()));
					log.info("FolioRef: " + referencia.getFolioRef());
				}

				if (referencia.getIndGlobal() != null) {
					jaxbReferencia.setIndGlobal(BigInteger.valueOf(referencia.getIndGlobal()));
					log.info("IndGlobal: " + referencia.getIndGlobal());
				}

				if (referencia.getRutOtro() != null) {
					jaxbReferencia.setRUTOtr(referencia.getRutOtro());
					log.info("RUTOtr: " + referencia.getRutOtro());
				}

				if (referencia.getTipoDocRef() != null) {
					jaxbReferencia.setTpoDocRef(referencia.getTipoDocRef());
					log.info("TpoDocRef: " + referencia.getTipoDocRef());
				}

				if (referencia.getFchRef() != null) {
					// convierte fecha de resolucion indicada en el request
					Date dateFechaReferencia;
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
						String sDateInLocal = sdf.format(referencia.getFchRef());
						LocalDate date = LocalDate.parse(sDateInLocal);
						dateFechaReferencia = convertToDateUsingInstant(date);
					} catch (Exception ex) {
						log.error("No fue posible convertir fecha. Error=" + ex.getMessage());
						throw new Exception("La fecha de referencia no es valida");
					}
					jaxbReferencia.setFchRef(dateFechaReferencia);
				}

				// agrega a la lista de referencias
				jaxbReferencias.add(jaxbReferencia);
			}

			return jaxbReferencias;
		} catch (Exception ex) {
			log.error("No fue posible crear las referencias del DTE. Error: " + ex.getMessage());
			return null;
		}
	}

	public static Date convertToDateUsingInstant(LocalDate date) {
		return java.util.Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Crea la porcion de descuentos y recargos asociados al documento
	 *
	 * @param documento documento especifico indicado en el request
	 * @return lista de descuentos/recargos asociados al documento
	 */
	private List<DTE.Documento.DscRcgGlobal> obtenerDescuentosRecargos(DTEDocumento documento) {
		try {
			int nrolinea = 0;
			List<DTE.Documento.DscRcgGlobal> jaxbDescuentosRecargos = new ArrayList<DTE.Documento.DscRcgGlobal>();
			for (DTEDescuentoRecargo descrecargo : documento.getDescuentosRecargos()) {
				nrolinea++;
				DTE.Documento.DscRcgGlobal jaxbDsctoRecargo = jaxbFactory.createDTEDocumentoDscRcgGlobal();

				// nro secuencial de linea
				jaxbDsctoRecargo.setNroLinDR(BigInteger.valueOf(nrolinea));

				// descripcion descuento/recargo
				jaxbDsctoRecargo.setGlosaDR(descrecargo.getGlosaDR());

				// indica si el descuento/recargo:
				// afecta a productos exentos o no afectos (1)
				// afecta a productos no facturables (2)
				jaxbDsctoRecargo.setIndExeDR(BigInteger.valueOf(descrecargo.getIndicadorExencionDR()));

				// (D)escuento (R)ecargo
				jaxbDsctoRecargo.setTpoMov(descrecargo.getTpomov());

				// Unidad en que se expresa el valor (porcentaje '%' o pesos '$')
				jaxbDsctoRecargo.setTpoValor(descrecargo.getTpovalor());

				// valor del descuento/recargo
				jaxbDsctoRecargo.setValorDR(descrecargo.getValorDR());

				// agrega el descuento/recargo a la lista
				jaxbDescuentosRecargos.add(jaxbDsctoRecargo);
			}

			return jaxbDescuentosRecargos;

		} catch (Exception ex) {
			log.error("No fue posible crear descuentos y recargo asociados al DTE. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea la porcion de subtotales informativos
	 * 
	 * @param documento documento especifico indicado en el request
	 * @return lista de subtotales informativos
	 */
	private List<DTE.Documento.SubTotInfo> obtenerSubtotInfo(DTEDocumento documento) {
		try {
			List<DTE.Documento.SubTotInfo> jaxbSubtotinfos = new ArrayList<DTE.Documento.SubTotInfo>();

			// TODO: dar soporte a subtotinfo
			/*
			 * int nrolinea = 0;
			 * List<BOLETADefType.Documento.SubTotInfo> jaxbSubtotinfos = new
			 * ArrayList<BOLETADefType.Documento.SubTotInfo>();
			 * for(BoletaSubtotalInformativo subtotinfo:documento.getSubtotalInformativo())
			 * {
			 * nrolinea++;
			 * BOLETADefType.Documento.SubTotInfo jaxbSubtotinfo = new
			 * BOLETADefType.Documento.SubTotInfo();
			 * jaxbSubtotinfo.setGlosaSTI(subtotinfos_glosaSTI);
			 * jaxbSubtotinfo.setNroSTI(nrolinea);
			 * jaxbSubtotinfo.setOrdenSTI(subtotinfos_ordenSTI);
			 * jaxbSubtotinfo.setSubTotAdicSTI(subtotinfos_subtotAdicSTI);
			 * jaxbSubtotinfo.setSubTotExeSTI(subtotinfos_subtotExeSTI);
			 * jaxbSubtotinfo.setSubTotIVASTI(subtotinfos_subtotIVASTI);
			 * jaxbSubtotinfo.setSubTotNetoSTI(subtotinfos_subtotNetoSTI);
			 * jaxbSubtotinfo.setValSubtotSTI(subtotinfos_valsubtotSTI);
			 * 
			 * // agrega el subtotinfo a la lista
			 * jaxbSubtotinfos.add(jaxbSubtotinfo);
			 * }
			 */
			return jaxbSubtotinfos;

		} catch (Exception ex) {
			log.error("No fue posible crear SubtotInfo del DTE. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * @param documento documento al que se le calculan totales. Se utiliza la
	 *                  version jaxb del documento (la que se informara como xml)
	 * @param tasaIva   la tasa que se indique se divide por 100
	 * @return totales a informar en el encabezado del documento
	 */
	private DTE.Documento.Encabezado.Totales obtenerTotales(DTEDocumento documento, Double tasaIva) {
		try {
			Double totalMontoExento = 0d;
			Double totalMontoNeto = 0d;
			Double totalMontoBruto = 0d;

			// valor=2 => monto neto en detalle
			boolean indMontoNetoEnDetalle = documento.getIndMontoNeto() == 2 ? true : false;

			for (DTEDetalle detalle : documento.getDetalle()) {
				// --------------------------------------------------------------------------------------
				// precio unitario del item en pesos
				// -->Double precioItem = detalle.getPrecioItem() == null ? 0 :
				// detalle.getPrecioItem().doubleValue();

				// cantidad del item
				// -->Double qtyItem = detalle.getCantidadproducto() == null ? 0 :
				// detalle.getCantidadproducto().doubleValue();

				// este no es necesario. El calculo ya debiera venir echo y considerado en el
				// monto del detalle
				// -->Double precioXcantidad = precioItem * qtyItem;

				// monto por linea de detalle. Corresponde al monto bruto a menos que
				// indMontoNetoEnDetalle indique lo contrario
				Long montoXlineaDeDetalle = detalle.getMontoitem() == null ? 0 : detalle.getMontoitem().longValue();

				// porcentaje de descuento. Se esta considerando descuentoPorcentaje en Totales
				Double descuentoPorcentaje = detalle.getDescuentoPct() == null ? 0
						: (detalle.getDescuentoPct().doubleValue() / 100) * montoXlineaDeDetalle;

				// porcentaje de recargo. Se esta considerando recargoPorcentaje en Totales
				Double recargoPorcentaje = detalle.getRecargoPct() == null ? 0
						: (detalle.getRecargoPct().doubleValue() / 100) * montoXlineaDeDetalle;

				// monto de descuento. Se esta considerando descuentoMonto en Totales, pero
				// revisar su uso
				Double descuentoMonto = detalle.getDescuentoMonto() == null ? 0
						: detalle.getDescuentoMonto().doubleValue();

				// monto de recargo. Se esta considerando recargoMonto en Totales, pero revisar
				// su uso
				Long recargoMonto = detalle.getRecargoMonto() == null ? 0 : detalle.getRecargoMonto().longValue();

				// --------------------------------------------------------------------------------------
				// Indicador de exencion:
				// 1:producto o servicio es exento o no afecto
				// 2:producto o servicio no es facturable
				// 6:producto o servicio no es facturable (negativo)
				boolean itemExento = false;
				if (detalle.getIndicadorExencion() == null) {
					log.debug("Indicador de exencion es null. Se considera 'afecto'.");
				} else {
					Integer indExencion = detalle.getIndicadorExencion().intValue();
					if (indExencion.intValue() == 1 || indExencion.intValue() == 2 || indExencion.intValue() == 6) {
						log.debug("El item es exento. Detalle=" + detalle.getDescripcionItem());
						itemExento = true;
					} else {
						log.debug("El item NO es exento. Detalle=" + detalle.getDescripcionItem());
					}
				}

				// suma si el item es exento
				if (itemExento) {
					totalMontoExento += montoXlineaDeDetalle; // detalle.getMontoitem().doubleValue();
					totalMontoBruto += montoXlineaDeDetalle - descuentoMonto + recargoMonto;
				} else {
					if (indMontoNetoEnDetalle) {
						totalMontoNeto += montoXlineaDeDetalle - descuentoMonto + recargoMonto;
					} else {
						totalMontoBruto += montoXlineaDeDetalle - descuentoMonto + recargoMonto;
					}
				}
			}

			// calcula los totales
			Double total_IVA = null;
			Double total_monto = null;
			log.debug("Indicador monto neto en detalle=" + indMontoNetoEnDetalle);
			if (indMontoNetoEnDetalle) {
				total_monto = Math.abs((totalMontoNeto - totalMontoExento) / (1 + (tasaIva / 100)));
				total_IVA = total_monto * (tasaIva / 100);
			} else {
				total_monto = Math.abs((totalMontoBruto - totalMontoExento) / (1 + (tasaIva / 100)));
				total_IVA = total_monto * (tasaIva / 100);
			}

			total_IVA = Math.floor(total_IVA + 0.5);
			total_monto = Math.floor(total_monto + 0.5);
			totalMontoExento = Math.floor(totalMontoExento + 0.5);

			BigInteger monto_neto = BigInteger.valueOf(total_monto.longValue());

			// los totales se llenan despues de cargar el detalle de los DTEs
			DTE.Documento.Encabezado.Totales jaxbTotales = jaxbFactory.createDTEDocumentoEncabezadoTotales();
			jaxbTotales.setIVA(BigInteger.valueOf(total_IVA.longValue()));
			jaxbTotales.setMntExe(BigInteger.valueOf(totalMontoExento.longValue()));
			jaxbTotales.setMntNeto(monto_neto);
			jaxbTotales.setMntTotal(jaxbTotales.getMntNeto().add(jaxbTotales.getIVA().add(jaxbTotales.getMntExe()))); // neto
																														// +
																														// iva
																														// +
																														// exento

			// TODO: los que vienen en 0. Hay que dar soporte a ellos
			jaxbTotales.setMontoNF(null);
			jaxbTotales.setSaldoAnterior(null);
			// -->jaxbTotales.setTotalPeriodo(null);
			jaxbTotales.setVlrPagar(null);

			return jaxbTotales;

		} catch (Exception ex) {
			log.error("No fue posible crear Totales. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Aplica descuentos/recargos globales a los totales
	 *
	 * @param encabezado   jaxb correspondiente al encabezado del dte que se esta
	 *                     procesando. Ya debe tener calculado los valores en el
	 *                     objeto {@link DTE.Documento.Encabezado.Totales}
	 * @param dscRcgGlobal descuentos/recargos globales
	 * @return encabezado jaxb con sus totales actualizados segun
	 *         descuentos/recargos aplicados
	 */
	private DTE.Documento.Encabezado aplicarDescuentosRecargosGlobales(DTE.Documento.Encabezado encabezado,
			List<DTE.Documento.DscRcgGlobal> dscRcgGlobal) {
		MathContext mathContext = new MathContext(2, RoundingMode.HALF_EVEN);

		try {
			DTE.Documento.Encabezado.Totales totales = encabezado.getTotales();
			for (DTE.Documento.DscRcgGlobal item : dscRcgGlobal) {
				String nombreMonto = getNombreMonto(item, encabezado);
				BigInteger valorDescuentoRecargo = getValorDescuentoRecargo(item, nombreMonto, totales, mathContext);
				log.debug("Valor Descuento/Recargo: " + valorDescuentoRecargo);
				BigInteger finalDescuentoRecargo = getFinalDescuentoRecargo(item, valorDescuentoRecargo);

				log.debug("Nombre Monto: " + nombreMonto);
				log.debug("Final Descuento/Recargo: " + finalDescuentoRecargo);

				actualizarMonto(encabezado.getTotales(), nombreMonto, finalDescuentoRecargo);
			}
			return encabezado;

		} catch (Exception ex) {
			log.error("Se produjo un error aplicando descuentos/recargos globales. Error=" + ex.getMessage());
			return null;
		}
	}

	private String getNombreMonto(DTE.Documento.DscRcgGlobal item, DTE.Documento.Encabezado encabezado) {
		if (item.getIndExeDR() != null) {
			switch (item.getIndExeDR().intValue()) {
				case 1:
					return MONTO_EXENTO;
				case 2:
					return MONTO_NF;
				default:
					log.error("El indicador de  exencion no es valido. item.getIndExeDR()=" + item.getIndExeDR());
			}
		}
		return encabezado.getIdDoc().getTipoDTE().intValue() == ConstantesTipoDocumento.FACTURA_AFECTA.getValue()
				? MONTO_TOTAL
				: MONTO_NETO;
	}

	private BigInteger getValorDescuentoRecargo(DTE.Documento.DscRcgGlobal item, String nombreMonto,
			DTE.Documento.Encabezado.Totales totales, MathContext mathContext) {
		BigInteger valorDescuentoRecargo;

		switch (nombreMonto) {
			case MONTO_EXENTO:
				valorDescuentoRecargo = totales.getMntExe();
				break;
			case MONTO_NF:
				valorDescuentoRecargo = totales.getMontoNF();
				break;
			case MONTO_TOTAL:
				valorDescuentoRecargo = totales.getMntTotal();
				break;
			case MONTO_NETO:
				valorDescuentoRecargo = totales.getMntNeto();
				break;
			default:
				log.error("NombreMonto no es válido. nombreMonto=" + nombreMonto);
				valorDescuentoRecargo = BigInteger.ZERO;
		}

		if (item.getValorDR() != null) {
			if (!valorDescuentoRecargo.equals(BigInteger.ZERO)) { // Verificar si valorDescuentoRecargo no es cero
				if (item.getTpoValor().equalsIgnoreCase("$")) {
					valorDescuentoRecargo = item.getValorDR().round(mathContext).toBigInteger();
				} else if (item.getTpoValor().equalsIgnoreCase("%")) {
					valorDescuentoRecargo = item.getValorDR().toBigInteger()
							.divide(BigInteger.valueOf(100).multiply(valorDescuentoRecargo));
				} else {
					log.error("Tipo de valor no soportado. No se incluirá el valor. TipoValor=" + item.getTpoValor());
					valorDescuentoRecargo = BigInteger.ZERO;
				}
			} else {
				log.error("valorDescuentoRecargo es cero. No se realizará la operación de división.");
			}
		} else {
			valorDescuentoRecargo = BigInteger.ZERO;
		}

		return valorDescuentoRecargo;
	}

	private BigInteger getFinalDescuentoRecargo(DTE.Documento.DscRcgGlobal item, BigInteger valorDescuentoRecargo) {
		BigInteger finalDescuentoRecargo = BigInteger.ZERO;
		if (item.getTpoMov().equalsIgnoreCase("D")) {
			finalDescuentoRecargo = valorDescuentoRecargo.negate();
		} else if (item.getTpoMov().equalsIgnoreCase("R")) {
			finalDescuentoRecargo = valorDescuentoRecargo;
		} else {
			log.error("Tipo de movimiento no soportado. TipoMovimiento=" + item.getTpoMov());
		}
		return finalDescuentoRecargo;
	}

	private void actualizarMonto(DTE.Documento.Encabezado.Totales totales, String nombreMonto,
			BigInteger finalDescuentoRecargo) {
		switch (nombreMonto) {
			case MONTO_EXENTO:
				totales.setMntExe(totales.getMntExe().add(finalDescuentoRecargo));
				break;
			case MONTO_NF:
				totales.setMontoNF(totales.getMontoNF().add(finalDescuentoRecargo));
				break;
			case MONTO_TOTAL:
				totales.setMntTotal(totales.getMntTotal().add(finalDescuentoRecargo));
				break;
			case MONTO_NETO:
				totales.setMntNeto(totales.getMntNeto().add(finalDescuentoRecargo));
				break;
			default:
				log.error("Monto desconocido. nombreMonto=" + nombreMonto);
		}
	}

}
