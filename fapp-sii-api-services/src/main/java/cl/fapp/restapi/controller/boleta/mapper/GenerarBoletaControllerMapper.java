package cl.fapp.restapi.controller.boleta.mapper;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
import cl.fapp.common.domain.ConstantesTipoDocumento;
import cl.fapp.common.xml.XMLUtils;
import cl.fapp.domain.mapper.MapperUtils;
import cl.fapp.foliomanager.FolioManager;
import cl.fapp.foliomanager.domain.Folio;
import cl.fapp.foliomanager.exception.*;
import cl.fapp.restapi.controller.boleta.domain.BoletaDescuentoRecargo;
import cl.fapp.restapi.controller.boleta.domain.BoletaDetalle;
import cl.fapp.restapi.controller.boleta.domain.BoletaDocumento;
import cl.fapp.restapi.controller.boleta.domain.BoletaEmisor;
import cl.fapp.restapi.controller.boleta.domain.BoletaReceptor;
import cl.fapp.restapi.controller.boleta.domain.BoletaReferencia;
import cl.fapp.restapi.controller.boleta.dto.BOLETADefTypeAndVerbatimCAF;
import cl.fapp.restapi.controller.boleta.dto.GenerarBoletaRequest;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.BOLETADefType.Documento.DscRcgGlobal;
import cl.fapp.sii.jaxb.BOLETADefType.Documento.Encabezado;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerarBoletaControllerMapper {
	private static final String MONTO_EXENTO = "MntExe";
	private static final String MONTO_NETO = "MntNeto";
	private static final String MONTO_TOTAL = "MntTotal";
	private static final String MONTO_NF = "MontoNF";

	@Autowired
	FolioManager foliomanager;

	ObjectFactory jaxbFactory = new ObjectFactory();

	/**
	 * Mapping del request DTO {@link GenerarBoletaRequest} a JAXB List<{@link BOLETADefType}>
	 * 
	 * @param request DTO
	 * @return tantos List<{@link BOLETADefType}> como boletas se indican en el request
	 */
	public List<BOLETADefTypeAndVerbatimCAF> toBOLETADefTypeDocumento(GenerarBoletaRequest request) 
	throws FoliosNotAvailableException, FoliosNotExistException {
		// valores globales
		Date fechaEmision = new Date();

		// visita cada documento especificado en el arreglo
		Folio folio;

		//List<BOLETADefType> jaxbBoletas = new ArrayList<BOLETADefType>();
		List<BOLETADefTypeAndVerbatimCAF> jaxbBoletas = new ArrayList<BOLETADefTypeAndVerbatimCAF>();
		for (BoletaDocumento documentoPayload : request.getDtes()) {
			try {
				// se crea cada porcion del documento por separado
				BOLETADefType.Documento.Encabezado encabezado = obtenerEncabezado(request.getEmisor(), documentoPayload, fechaEmision, null);
				List<BOLETADefType.Documento.Detalle> jaxbDetalles = obtenerDetalles(documentoPayload);
				List<BOLETADefType.Documento.Referencia> jaxbReferencias = obtenerReferencias(documentoPayload);
				List<BOLETADefType.Documento.DscRcgGlobal> jaxbDescuentosRecargos = obtenerDescuentosRecargos(documentoPayload);
				List<BOLETADefType.Documento.SubTotInfo> jaxbSubtotinfos = obtenerSubtotInfo(documentoPayload);

				// agrega totales al encabezado
				BOLETADefType.Documento.Encabezado.Totales jaxbTotales = obtenerTotales(documentoPayload, SiiDocumentFactoryConfiguration.TASA_IVA);
				
				// se ajustan montos dependiendo si es afecta/exenta
				ConstantesTipoDocumento tipodoc = ConstantesTipoDocumento.valueOf(encabezado.getIdDoc().getTipoDTE().intValue());
				switch(tipodoc) {
				case BOLETA_EXENTA:
					log.debug("Ajustando montos (exento=0 y total=0) en BOLETA_EXENTA...");
					jaxbTotales.setMntExe(BigInteger.ZERO);
					jaxbTotales.setMntTotal(BigInteger.ZERO);
					break;
				case BOLETA_AFECTA:
					log.debug("No se ajustan montos en BOLETA_AFECTA...");
					break;
				default:
					log.warn("Tipo documento (" + tipodoc.getValue() + ") no soportado. No se ajustan montos...");
				}
				
				// establece totales en el encabezado
				encabezado.setTotales(jaxbTotales);
				
				// aplica descuentos/recargos
				log.debug("INICIO - Aplicando descuentos/recargos globales...");
				Encabezado encabezadoActualizado = aplicarDescuentosRecargosGlobales(encabezado, jaxbDescuentosRecargos);
				encabezado = encabezadoActualizado;
				log.debug("FIN - Aplicando descuentos/recargos globales.");
				
				try {
					folio = foliomanager.getFolio(request.getRutEmisor(), tipodoc.getValue());
					
					// actualiza el folio en el encabezado del documento
					encabezado.getIdDoc().setFolio(BigInteger.valueOf(folio.getCardinal()));
					log.debug("Se obtuvo folio=" + encabezado.getIdDoc().getFolio() + ", para tipo_documento=" + tipodoc);
					
				} catch (FoliosNotExistException ex) {
					log.error("No existen folios disponibles para el tipo de documento solicitado. Error: " + ex.getMessage());
					// Lanza una excepción personalizada indicando que no hay folios disponibles
					throw new FoliosNotExistException("No existen folios disponibles.");
				} catch (FoliosNotAvailableException ex) {
					log.error("No hay folios disponibles. Error: " + ex.getMessage());
					// Lanza una excepción personalizada indicando que no hay folios disponibles
					throw new FoliosNotAvailableException("No hay folios disponibles.");
				}

				// hace el unmarshall al tagCaf del folio
				DTE.Documento.TED.DD.CAF cafDTE = MapperUtils.loadCafFromRepository(folio);
				BOLETADefType.Documento.TED.DD.CAF caf = MapperUtils.convert(cafDTE);

				// documento - TED - DD
				BOLETADefType.Documento.TED.DD dd = jaxbFactory.createBOLETADefTypeDocumentoTEDDD();

				// en la formacion del DD el CAF se maneja como jaxb
				dd.setCAF(caf);
				dd.setF(BigInteger.valueOf(folio.getCardinal()));
				dd.setFE(fechaEmision);
				dd.setIT1(jaxbDetalles.get(0).getNmbItem()); //.getDscItem());
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

				log.debug(tagRsask);
				// Encabezados a buscar
				String beginMarker = "-----BEGIN RSA PRIVATE KEY-----";
				String endMarker = "-----END RSA PRIVATE KEY-----";

				// Encuentra las posiciones de los encabezados
				int beginIndex = tagRsask.indexOf(beginMarker);
				int endIndex = tagRsask.indexOf(endMarker) + endMarker.length();

				// Extrae la subcadena que contiene la llave
				String rsask = tagRsask.substring(beginIndex, endIndex);
				log.debug(rsask);
				rsask = rsask.replace(beginMarker, "")
							 .replace(endMarker, "")
							 .replaceAll("\\s", "");

				log.debug(rsask);
				// recupera la llave rsask
				byte[] keyBytes = Base64.getDecoder().decode(rsask);

				// construye una RSAPrivateKey a partir de los datos rsask almacenados en el caf
				RSAPrivateKey privateKey = (RSAPrivateKey) MapperUtils.readPkcs1PrivateKey(keyBytes);

				// crea una instancia jaxb del objeto DD
				JAXBContext contextDD = JAXBContext.newInstance(BOLETADefType.Documento.TED.DD.class);
				Marshaller marshallerDD = contextDD.createMarshaller();
				marshallerDD.setProperty(Marshaller.JAXB_ENCODING, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);
				marshallerDD.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
				marshallerDD.setProperty(Marshaller.JAXB_FRAGMENT, true);
				marshallerDD.setSchema(null);

				// crea un writer para acumular el xml resultante
				StringWriter swxmlDD = new StringWriter();
				marshallerDD.marshal(dd, swxmlDD);

				String xmlDD = swxmlDD.toString();

				//-->String marshalledObject = xmlDD.replace("<DD xmlns=\"http://www.sii.cl/SiiDte\">", "<DD>");

				log.debug("DD a firmar: " + xmlDD);
				//-->log.debug("DD despues: " + marshalledObject);

				// se firma el xml del DD
				Signature dmSignature = Signature.getInstance(SiiDocumentFactoryConfiguration.DD.SIGNATURE_ALGORITHM);
				dmSignature.initSign(privateKey);
				dmSignature.update(xmlDD.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));

				// se codifica el dd firmado
				byte[] xmlsigned = dmSignature.sign();
				String signedDD = new String(xmlsigned, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);

				// documento - TED - FRMT
				BOLETADefType.Documento.TED.FRMT frmt = jaxbFactory.createBOLETADefTypeDocumentoTEDFRMT();
				frmt.setAlgoritmo(SiiDocumentFactoryConfiguration.DD.SIGNATURE_ALGORITHM);
				frmt.setValue(signedDD.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));

				// documento - TED			
				BOLETADefType.Documento.TED ted = jaxbFactory.createBOLETADefTypeDocumentoTED();

				// -----------------------------------------------------------------------------------------------
				// el caf se reemplaza posteriormente con la porcion de xml entregada por el sii
				// entonces, en esta fase, solo se crea espacio para el tag CAF, no para DA ni FRMT
				// ese tag servira para reemplazar por el texto del sii
				BOLETADefType.Documento.TED.DD.CAF emptycaf = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAF();
				emptycaf.setDA(null);
				emptycaf.setFRMA(null);
				emptycaf.setVersion(null);

				// se limpia la porcion caf de DD para ser reemplazada con el texto del sii, pero se conserva la firma
				dd.setCAF(emptycaf);

				// -----------------------------------------------------------------------------------------------
				ted.setDD(dd);
				ted.setFRMT(frmt);
				ted.setVersion("1.0");

				// se crea el documento
				BOLETADefType.Documento boleta = jaxbFactory.createBOLETADefTypeDocumento(); // new DTE.Documento();
				boleta.setEncabezado(encabezado);
				boleta.getDetalles().addAll(jaxbDetalles);
				boleta.getDscRcgGlobals().addAll(jaxbDescuentosRecargos);
				boleta.getReferencias().addAll(jaxbReferencias);
				boleta.getSubTotInfos().addAll(jaxbSubtotinfos);

				// propiedades del documento
				boleta.setID(BuilderXmlID.getIDforBoleta(folio.getCardinal()));
				boleta.setTED(ted);
				boleta.setTmstFirma(fechaEmision);

				// crea el DTE (que puede ser firmado)
				BOLETADefType dte = jaxbFactory.createBOLETADefType(); // new DTE();
				dte.setDocumento(boleta);
				dte.setVersion(BigDecimal.valueOf(1.0));
				dte.setSignature(null);

				// agrega la boleta a la lista de boletas
				//jaxbBoletas.add(dte);
				BOLETADefTypeAndVerbatimCAF element = new BOLETADefTypeAndVerbatimCAF();
				element.setBoleta(dte);
				element.setVerbatimcaf(folio.getTagCaf());

				jaxbBoletas.add(element);

			} catch (Exception ex) {
				log.error("No fue posible construir BOLETADefType_DTE. Error: " + ex.getMessage(), ex);
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		return jaxbBoletas;
	}

	/**
	 * Crea un encabezado de tipo {@link BOLETADefType.Documento.Encabezado} para crear la boleta
	 * 
	 * @param emisor       emisor de la boleta
	 * @param request      los datos del request al servicio
	 * @param fechaEmision fecha de emision del documento
	 * @param folio        numero de folio asignado
	 * @return un objeto jaxb del encabezado de la boleta, para agregar al documento
	 */
	private BOLETADefType.Documento.Encabezado obtenerEncabezado(BoletaEmisor emisor, BoletaDocumento request, Date fechaEmision, BigInteger folio) {

		try {
			BoletaReceptor receptor = request.getReceptor();

			// encabezado del dte
			BOLETADefType.Documento.Encabezado.Emisor jaxbEmisor = new BOLETADefType.Documento.Encabezado.Emisor();
			jaxbEmisor.setGiroEmisor(XMLUtils.replaceSiiEspecialChars(emisor.getGiroEmisor()));
			jaxbEmisor.setRUTEmisor(emisor.getRutEmisor());
			jaxbEmisor.setRznSocEmisor(XMLUtils.replaceSiiEspecialChars(emisor.getRazonSocialEmisor()));

			jaxbEmisor.setCdgSIISucur(emisor.getCodigoSii() == null ? null : new BigInteger(emisor.getCodigoSii()));
			jaxbEmisor.setCmnaOrigen(emisor.getComunaEmisor());
			jaxbEmisor.setCiudadOrigen(emisor.getCiudadEmisor());
			jaxbEmisor.setDirOrigen(XMLUtils.replaceSiiEspecialChars(emisor.getDireccionEmisor()));

			// encabezado - identificador del documento
			BOLETADefType.Documento.Encabezado.IdDoc jaxbIddoc = new BOLETADefType.Documento.Encabezado.IdDoc();
			jaxbIddoc.setFchEmis(fechaEmision);
			jaxbIddoc.setFolio(folio);

			if (request.getIndMontoNeto() == null || request.getIndMontoNeto() != 2) {
				jaxbIddoc.setIndMntNeto(null);
			} else {
				jaxbIddoc.setIndMntNeto(BigInteger.valueOf(request.getIndMontoNeto()));
			}

			jaxbIddoc.setIndServicio(BigInteger.valueOf(request.getIndicadorservicio()));

			// TODO: boleta afecta/exenta
			jaxbIddoc.setTipoDTE(BigInteger.valueOf(request.getTipodocumento().getValue())); //.Boleta.TipoDocumento.BOLETA_AFECTA));
			//-->iddoc.setFchVenc(fchvenc);
			//-->iddoc.setPeriodoDesde(periododesde);
			//-->iddoc.setPeriodoHasta(periodohasta);

			// encabezado - receptor
			BOLETADefType.Documento.Encabezado.Receptor jaxbReceptor = new BOLETADefType.Documento.Encabezado.Receptor();
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

			// encabezado - totales (Montos totales del DTE)
			// se calcula en forma independiente, despues de procesar el detalle

			// encabezado - establece encabezado
			BOLETADefType.Documento.Encabezado encabezado = new BOLETADefType.Documento.Encabezado();
			encabezado.setEmisor(jaxbEmisor);
			encabezado.setIdDoc(jaxbIddoc);
			encabezado.setReceptor(jaxbReceptor);
			encabezado.setTotales(null);

			return encabezado;

		} catch (Exception ex) {
			log.error("No fue posible crear el encabezado. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea un detalle de tipo {@link List<BOLETADefType.Documento.Detalle>}
	 * 
	 * @param documento documento especifico indicado en el request
	 * @return el detalle asociado al documento
	 */
	private List<BOLETADefType.Documento.Detalle> obtenerDetalles(BoletaDocumento documento) {
		try {
			int nrolinea = 0;
			List<BOLETADefType.Documento.Detalle> jaxbDetalles = new ArrayList<BOLETADefType.Documento.Detalle>();

			// traspasa el detalle de cada boleta
			for (BoletaDetalle detalle : documento.getDetalle()) {
				nrolinea++;
				BOLETADefType.Documento.Detalle jaxbDetalle = new BOLETADefType.Documento.Detalle();
				jaxbDetalle.setNroLinDet(BigInteger.valueOf(nrolinea));
				jaxbDetalle.setIndExe(detalle.getIndicadorExencion() == null ? null : BigInteger.valueOf(detalle.getIndicadorExencion()));
				jaxbDetalle.setItemEspectaculo(null);
				jaxbDetalle.setRUTMandante(detalle.getRutMandante());
				jaxbDetalle.setNmbItem(XMLUtils.replaceSiiEspecialChars(detalle.getNombreproducto()));
				jaxbDetalle.setInfoTicket(null);
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
			log.error("No fue posible crear los detalles. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea la porcion referencias del documento
	 * 
	 * @param documento el documento es pecifico indicado en el request
	 * @return lista de referencias asociadas al documento
	 */
	private List<BOLETADefType.Documento.Referencia> obtenerReferencias(BoletaDocumento documento) {
		try {
			int nrolinea = 0;
			List<BOLETADefType.Documento.Referencia> jaxbReferencias = new ArrayList<BOLETADefType.Documento.Referencia>();
			for (BoletaReferencia referencia : documento.getReferencias()) {
				nrolinea++;
				BOLETADefType.Documento.Referencia jaxbReferencia = new BOLETADefType.Documento.Referencia();
				jaxbReferencia.setCodCaja(referencia.getCodcaja());
				jaxbReferencia.setCodRef(referencia.getCodref());
				jaxbReferencia.setCodVndor(referencia.getCodvndor());
				jaxbReferencia.setNroLinRef(nrolinea);
				jaxbReferencia.setRazonRef(XMLUtils.replaceSiiEspecialChars(referencia.getRazonref()));
				
				// tipo de documento de referencia, y folio de referencia
				//jaxbReferencia.setTpoDocRef(referencia.getTpodocref());
				//jaxbReferencia.setFolioRef(referencia.getFolioref());

				// agrega a la lista de referencias
				jaxbReferencias.add(jaxbReferencia);
			}

			return jaxbReferencias;
		} catch (Exception ex) {
			log.error("No fue posible crear las referencias. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea la porcion de descuentos y recargos asociados al documento
	 * 
	 * @param documentoPayload documento especifico indicado en el request
	 * @return lista de descuentos/recargos asociados al documento
	 */
	private List<BOLETADefType.Documento.DscRcgGlobal> obtenerDescuentosRecargos(BoletaDocumento documentoPayload) {
		try {
			int nrolinea = 0;
			List<BOLETADefType.Documento.DscRcgGlobal> jaxbDescuentosRecargos = new ArrayList<BOLETADefType.Documento.DscRcgGlobal>();
			for (BoletaDescuentoRecargo descrecargo : documentoPayload.getDescuentosRecargos()) {
				nrolinea++;
				BOLETADefType.Documento.DscRcgGlobal jaxbDsctoRecargo = jaxbFactory.createBOLETADefTypeDocumentoDscRcgGlobal();

				// nro secuencial de linea
				jaxbDsctoRecargo.setNroLinDR(nrolinea);

				// descripcion descuento/recargo
				jaxbDsctoRecargo.setGlosaDR(descrecargo.getGlosaDR());

				// indica si el descuento/recargo:
				// afecta a productos exentos o no afectos (1) 
				// afecta a productos no facturables (2)
				jaxbDsctoRecargo.setIndExeDR(BigInteger.valueOf(descrecargo.getIndicadorExencionDR()));

				//(D)escuento (R)ecargo
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
			log.error("No fue posible crear descuentos y recargo asociados a la boleta. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea la porcion de subtotales informativos
	 * 
	 * @param documento documento especifico indicado en el request
	 * @return lista de subtotales informativos
	 */
	private List<BOLETADefType.Documento.SubTotInfo> obtenerSubtotInfo(BoletaDocumento documento) {
		try {
			List<BOLETADefType.Documento.SubTotInfo> jaxbSubtotinfos = new ArrayList<BOLETADefType.Documento.SubTotInfo>();

			// TODO: dar soporte a subtotinfo
			/*
			int nrolinea = 0;
			List<BOLETADefType.Documento.SubTotInfo> jaxbSubtotinfos = new ArrayList<BOLETADefType.Documento.SubTotInfo>();
			for(BoletaSubtotalInformativo subtotinfo:documento.getSubtotalInformativo()) {
			    nrolinea++;
				BOLETADefType.Documento.SubTotInfo jaxbSubtotinfo = new BOLETADefType.Documento.SubTotInfo();
				jaxbSubtotinfo.setGlosaSTI(subtotinfos_glosaSTI);
				jaxbSubtotinfo.setNroSTI(nrolinea);
				jaxbSubtotinfo.setOrdenSTI(subtotinfos_ordenSTI);
				jaxbSubtotinfo.setSubTotAdicSTI(subtotinfos_subtotAdicSTI);
				jaxbSubtotinfo.setSubTotExeSTI(subtotinfos_subtotExeSTI);
				jaxbSubtotinfo.setSubTotIVASTI(subtotinfos_subtotIVASTI);
				jaxbSubtotinfo.setSubTotNetoSTI(subtotinfos_subtotNetoSTI);
				jaxbSubtotinfo.setValSubtotSTI(subtotinfos_valsubtotSTI);
				
				// agrega el subtotinfo a la lista
				jaxbSubtotinfos.add(jaxbSubtotinfo);
			}
			*/
			return jaxbSubtotinfos;

		} catch (Exception ex) {
			log.error("No fue posible crear SubtotInfo. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param documento documento al que se le calculan totales. Se utiliza la version jaxb del documento (la que se informara como xml)
	 * @param tasaIva   la tasa que se indique se divide por 100
	 * @return totales a informar en el encabezado del documento
	 */
	private BOLETADefType.Documento.Encabezado.Totales obtenerTotales(BoletaDocumento documento, Double tasaIva) {
		try {
			Double totalMontoExento = 0d;
			Double totalMontoNeto = 0d;
			Double totalMontoBruto = 0d;

			// valor=2 => monto neto en detalle
			boolean indMontoNetoEnDetalle = documento.getIndMontoNeto() == 2 ? true : false;

			for (BoletaDetalle detalle : documento.getDetalle()) {
				// --------------------------------------------------------------------------------------
				// precio unitario del item en pesos
				//-->Double precioItem = detalle.getPrecioItem() == null ? 0 : detalle.getPrecioItem().doubleValue();

				// cantidad del item
				//-->Double qtyItem = detalle.getCantidadproducto() == null ? 0 : detalle.getCantidadproducto().doubleValue();

				// este no es necesario. El calculo ya debiera venir echo y considerado en el monto del detalle
				//-->Double precioXcantidad = precioItem * qtyItem;

				// monto por linea de detalle. Corresponde al monto bruto a menos que indMontoNetoEnDetalle indique lo contrario
				Long montoXlineaDeDetalle = detalle.getMontoitem() == null ? 0 : detalle.getMontoitem().longValue();

				// porcentaje de descuento. Se esta considerando descuentoPorcentaje en Totales
				Double descuentoPorcentaje = detalle.getDescuentoPct() == null ? 0 : (detalle.getDescuentoPct().doubleValue() / 100) * montoXlineaDeDetalle;

				// porcentaje de recargo. Se esta considerando recargoPorcentaje en Totales
				Double recargoPorcentaje = detalle.getRecargoPct() == null ? 0 : (detalle.getRecargoPct().doubleValue() / 100) * montoXlineaDeDetalle;

				// monto de descuento, Se esta considerando descuentoMonto en Totales, revisar su uso
				Double descuentoMonto = detalle.getDescuentoMonto() == null ? 0 : detalle.getDescuentoMonto().doubleValue();

				// monto de recargo, Se esta considerando recargoMonto en Totales, revisar su uso
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
					totalMontoBruto += montoXlineaDeDetalle - descuentoMonto + recargoMonto - descuentoPorcentaje + recargoPorcentaje;
				} else {
					if (indMontoNetoEnDetalle) {
						totalMontoNeto += montoXlineaDeDetalle - descuentoMonto + recargoMonto - descuentoPorcentaje + recargoPorcentaje;
					} else {
						totalMontoBruto += montoXlineaDeDetalle - descuentoMonto + recargoMonto - descuentoPorcentaje + recargoPorcentaje;
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

			// los totales se llenan despues de cargar el detalle de las boletas
			BOLETADefType.Documento.Encabezado.Totales jaxbTotales = jaxbFactory.createBOLETADefTypeDocumentoEncabezadoTotales(); // new BOLETADefType.Documento.Encabezado.Totales();
			jaxbTotales.setIVA(BigInteger.valueOf(total_IVA.longValue()));
			jaxbTotales.setMntExe(BigInteger.valueOf(totalMontoExento.longValue()));
			jaxbTotales.setMntNeto(monto_neto);
			jaxbTotales.setMntTotal(jaxbTotales.getMntNeto().add(jaxbTotales.getIVA().add(jaxbTotales.getMntExe()))); // neto + iva + exento

			// TODO: los que vienen en 0. Hay que dar soporte a ellos 
			jaxbTotales.setMontoNF(null); // MontoNF: Monto No Facturable, Corresponde a Bienes o Servicios Facturados Previamente
			jaxbTotales.setSaldoAnterior(null);
			jaxbTotales.setTotalPeriodo(null);
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
	 * @param encabezado  jaxb correspondiente al encabezado del dte que se esta procesando. Ya debe tener calculado los valores en el objeto {@link BOLETADefType.Documento.Encabezado.Totales}
	 * @param dscRcgGlobal descuentos/recargos globales
	 * @return encabezado jaxb con sus totales actualizados segun descuentos/recargos aplicados
	 */
	private BOLETADefType.Documento.Encabezado aplicarDescuentosRecargosGlobales(BOLETADefType.Documento.Encabezado encabezado, List<BOLETADefType.Documento.DscRcgGlobal> dscRcgGlobal) {
		MathContext mathContext = new MathContext(2, RoundingMode.HALF_EVEN);

		try {
			//Encabezado encabezado = documento.getEncabezado();
			BOLETADefType.Documento.Encabezado.Totales totales = encabezado.getTotales();
			for (DscRcgGlobal item : dscRcgGlobal) {
				String nombreMonto = null;
				if (item.getIndExeDR() != null) {
					// @formatter:off
					switch (item.getIndExeDR().intValue()) {
					        case 1:	nombreMonto = MONTO_EXENTO;	break;
					        case 2:	nombreMonto = MONTO_NF; break;
					        default:
					        	log.error("El indicador de  exencion no es valido. item.getIndExeDR()=" + item.getIndExeDR());
					}
					// @formatter:on
				} else {
					nombreMonto = encabezado.getIdDoc().getTipoDTE().intValue() == ConstantesTipoDocumento.BOLETA_AFECTA.getValue() ? MONTO_TOTAL : MONTO_NETO;
				}

				BigInteger valorDescuentoRecargo = BigInteger.ZERO;
				// @formatter:off
				switch(nombreMonto) {
				        case MONTO_EXENTO: valorDescuentoRecargo = totales.getMntExe(); break;
				        case MONTO_NF: valorDescuentoRecargo = totales.getMontoNF(); break;
				        case MONTO_TOTAL: valorDescuentoRecargo = totales.getMntTotal(); break;
				        case MONTO_NETO: valorDescuentoRecargo = totales.getMntNeto(); break;
				        default:
				        	log.error("NombreMonto no es valido. nombreMonto=" + nombreMonto);
				}
				// @formatter:on

				// calcula valor del descuento/recargo
				if (item.getValorDR() != null) {
					if (item.getTpoValor().equalsIgnoreCase("$")) {
						valorDescuentoRecargo = item.getValorDR().round(mathContext).toBigInteger();
					} else if (item.getTpoValor().equalsIgnoreCase("%")) {
						valorDescuentoRecargo = (item.getValorDR().toBigInteger().divide(BigInteger.valueOf(100).multiply(valorDescuentoRecargo)));
					} else {
						log.error("Tipo de valor no soportado. No se incluira el valor. TipoValor=" + item.getTpoValor());
						valorDescuentoRecargo = BigInteger.ZERO;
					}
				} else {
					valorDescuentoRecargo = BigInteger.ZERO;
				}

				// aplica descuento/recargo
				BigInteger finalDescuentoRecargo = BigInteger.ZERO;
				if (item.getTpoMov().equalsIgnoreCase("D")) {
					finalDescuentoRecargo = valorDescuentoRecargo.negate();
				} else if (item.getTpoMov().equalsIgnoreCase("R")) {
					finalDescuentoRecargo = valorDescuentoRecargo;
				} else {
					log.error("Tipo de movimiento no soportado. TipoMovimiento=" + item.getTpoMov());
				}

				// actualiza el monto correspondiente
				log.debug("Aplicando descuento/recargo: tipoMovimiento=[" + item.getTpoMov() + "], monto=[" + nombreMonto + "], valor=[" + finalDescuentoRecargo + "]");
				// @formatter:off
				switch (nombreMonto) {
				        case MONTO_EXENTO: encabezado.getTotales().setMntExe(totales.getMntExe().add(finalDescuentoRecargo)); break;
				        case MONTO_NF:	encabezado.getTotales().setMontoNF(totales.getMontoNF().add(finalDescuentoRecargo)); break;
				        case MONTO_TOTAL: encabezado.getTotales().setMntTotal(totales.getMntTotal().add(finalDescuentoRecargo)); break;
				        case MONTO_NETO:	encabezado.getTotales().setMntNeto(totales.getMntNeto().add(finalDescuentoRecargo)); break;
				        default:
				        	log.error("Monto desconocido. nombreMonto=" + nombreMonto);
				}
				// @formatter:on
			}
			return encabezado;

		} catch (Exception ex) {
			log.error("Se produjo un error aplicando descuentos/recargos globales. Error=" + ex.getMessage());
			return null;
		}
	}
}
