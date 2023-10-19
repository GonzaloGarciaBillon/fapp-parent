package cl.fapp.restapi.controller.dte.notacredito.mapper;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
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

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.domain.BuilderXmlID;
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
import cl.fapp.restapi.dte.dto.GenerarNotaCreditoRequest;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GenerarNotaCreditoDTEControllerMapper {

	@Autowired
	FolioManager foliomanager;

	ObjectFactory jaxbFactory = new ObjectFactory();

	/**
	 * Mapping del request DTO {@link GenerarNotaCreditoRequest} a JAXB List<{@link DTE}>
	 * 
	 * @param request DTO
	 * @param tipoDocumento Integer representando el tipo de documento que se debe procesar
	 * @return tantos List<{@link DTEAndVerbatimCAF}> como documentos se indican en el request, adjuntando el CAF apropiado (segun tipoDocumento) en cada caso
	 */
	public List<DTEAndVerbatimCAF> toDTEDocumento(GenerarNotaCreditoRequest request, Integer tipoDocumento) {
		// valores globales
		Date fechaEmision = new Date();

		// visita cada documento especificado en el arreglo
		Folio folio;

		List<DTEAndVerbatimCAF> jaxbBoletas = new ArrayList<DTEAndVerbatimCAF>();
		for (DTEDocumento documento : request.getDtes()) {
			documento.setTipodocumento(tipoDocumento);
			try {
				// se crea cada porcion del documento por separado (el folio se establece posteriormente, por eso el ultimo parametro es null)
				DTE.Documento.Encabezado encabezado = obtenerEncabezado(request.getEmisor(), documento, fechaEmision, null);
				List<DTE.Documento.Detalle> jaxbDetalles = obtenerDetalles(documento);
				List<DTE.Documento.Referencia> jaxbReferencias = obtenerReferencias(documento);
				List<DTE.Documento.DscRcgGlobal> jaxbDescuentosRecargos = obtenerDescuentosRecargos(documento);
				List<DTE.Documento.SubTotInfo> jaxbSubtotinfos = obtenerSubtotInfo(documento);

				// agrega totales al encabezado
				DTE.Documento.Encabezado.Totales jaxbTotales = obtenerTotales(documento, SiiDocumentFactoryConfiguration.TASA_IVA);
				encabezado.setTotales(jaxbTotales);

				// obtiene un folio para asignar al documento
				try {
					folio = foliomanager.getFolio(request.getRutEmisor(), tipoDocumento); // BoletaConstantes.Boleta.TipoDocumento.NOTA_CREDITO);
					
					// actualiza el folio en el encabezado del documento
					encabezado.getIdDoc().setFolio(BigInteger.valueOf(folio.getCardinal()));
					log.debug("Se obtuvo folio=" + folio.getCardinal() + ", para tipo_documento=" + tipoDocumento); //BoletaConstantes.Boleta.TipoDocumento.NOTA_CREDITO);
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

				// - quita encabezados pkcs1 (BEGIN RSA PRIVATE KEY)
				String rsask = tagRsask;
				rsask = rsask.replaceAll("<RSASK>-----BEGIN RSA PRIVATE KEY-----" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN, "");
				rsask = rsask.replaceAll("-----END RSA PRIVATE KEY-----" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "</RSASK>", "");
				rsask = rsask.replaceAll(SiiDocumentFactoryConfiguration.CARRIAGE_RETURN, "");

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

				// el esquema de DTE incluye declaracion de namespace, pero este no es aceptado por SII cuando se obtiene el TED
				// por lo que deben eliminarse las declaraciones de namespace, para ello se implementa un XMLWriter que descarta 
				// la escritura de namespaces del xml resultante
				XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
				XMLStreamWriter xmlStreamWriter  = outputFactory.createXMLStreamWriter(swxmlDD);

				NoNamespaceWriter mywriter = new NoNamespaceWriter(xmlStreamWriter);
				marshallerDD.marshal(dd, mywriter);
				mywriter.flush();
				xmlStreamWriter.flush();

				// convierte el stream a string
				String xmlDD = swxmlDD.toString();

				log.debug("DD a firmar: " + xmlDD);
				//-->log.debug("DD despues: " + marshalledObject);
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
				// entonces, en esta fase, solo se crea espacio para el tag CAF, no para DA ni FRMT
				// ese tag servira para reemplazar por el texto del sii
				DTE.Documento.TED.DD.CAF emptycaf = jaxbFactory.createDTEDocumentoTEDDDCAF();
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
				DTE.Documento documentoDTE = jaxbFactory.createDTEDocumento();
				documentoDTE.setEncabezado(encabezado);
				documentoDTE.getDetalles().addAll(jaxbDetalles);
				documentoDTE.getDscRcgGlobals().addAll(jaxbDescuentosRecargos);
				documentoDTE.getReferencias().addAll(jaxbReferencias);
				documentoDTE.getSubTotInfos().addAll(jaxbSubtotinfos);

				// propiedades del documento
				String idNotaCredito = BuilderXmlID.getIDforNotaCredito(folio.getCardinal());
				documentoDTE.setID(idNotaCredito);
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
				
				jaxbBoletas.add(element);

			} catch (Exception ex) {
				log.error("No fue posible construir DTE. Error: " + ex.getMessage(), ex);
				return null;
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
	private DTE.Documento.Encabezado obtenerEncabezado(DTEEmisor emisor, DTEDocumento request, Date fechaEmision, BigInteger folio) {

		try {
			DTEReceptor receptor = request.getReceptor();

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
			
			// TODO: boleta afecta/exenta
			jaxbIddoc.setTipoDTE( BigInteger.valueOf(request.getTipodocumento()) ); //-->BigInteger.valueOf(request.getTipodocumento().getValue()));
			//-->iddoc.setFchVenc(fchvenc);
			//-->iddoc.setPeriodoDesde(periododesde);
			//-->iddoc.setPeriodoHasta(periodohasta);

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

			// traspasa el detalle de cada boleta
			for (DTEDetalle detalle : documento.getDetalle()) {
				nrolinea++;
				DTE.Documento.Detalle jaxbDetalle = new DTE.Documento.Detalle();
				jaxbDetalle.setNroLinDet(nrolinea);
				jaxbDetalle.setIndExe(detalle.getIndicadorExencion()==null?null:BigInteger.valueOf(detalle.getIndicadorExencion()));
				//-->jaxbDetalle.setItemEspectaculo(null);
				//-->jaxbDetalle.setRUTMandante(detalle.getRutMandante());
				jaxbDetalle.setNmbItem(XMLUtils.replaceSiiEspecialChars(detalle.getNombreproducto()));
				//-->jaxbDetalle.setInfoTicket(null);
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
			List<DTE.Documento.Referencia> jaxbReferencias = new ArrayList<DTE.Documento.Referencia>();
			for (DTEReferencia referencia : documento.getReferencias()) {
				nrolinea++;
				DTE.Documento.Referencia jaxbReferencia = jaxbFactory.createDTEDocumentoReferencia();
				//-->jaxbReferencia.setCodCaja(referencia.getCodcaja());
				jaxbReferencia.setCodRef(new BigInteger(referencia.getCodref()));
				//-->jaxbReferencia.setCodVndor(referencia.getCodvndor());
				jaxbReferencia.setNroLinRef(nrolinea);
				jaxbReferencia.setRazonRef(XMLUtils.replaceSiiEspecialChars(referencia.getRazonref()));

				if( referencia.getFolioRef()!=null ) {
					jaxbReferencia.setFolioRef(String.valueOf(referencia.getFolioRef()));
				}
				
				if( referencia.getIndGlobal() != null) {
					jaxbReferencia.setIndGlobal(BigInteger.valueOf(referencia.getIndGlobal()));
				}
				
				if( referencia.getRutOtro()!= null ) {
					jaxbReferencia.setRUTOtr(referencia.getRutOtro());					
				}
				
				if( referencia.getTipoDocRef()!=null ) {
					jaxbReferencia.setTpoDocRef(referencia.getTipoDocRef());
				}

				if( referencia.getFchRef() !=null ) {
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
				jaxbDsctoRecargo.setGlosaDR(descrecargo.getGlosaDR());
				jaxbDsctoRecargo.setIndExeDR(BigInteger.valueOf(descrecargo.getIndicadorExencionDR()));
				jaxbDsctoRecargo.setNroLinDR(BigInteger.valueOf(nrolinea));
				jaxbDsctoRecargo.setTpoMov(descrecargo.getTpomov());
				jaxbDsctoRecargo.setTpoValor(descrecargo.getTpovalor());
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
			log.error("No fue posible crear SubtotInfo del DTE. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param documento documento al que se le calculan totales. Se utiliza la version jaxb del documento (la que se informara como xml)
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
				//-->Double precioItem = detalle.getPrecioItem() == null ? 0 : detalle.getPrecioItem().doubleValue();

				// cantidad del item
				//-->Double qtyItem = detalle.getCantidadproducto() == null ? 0 : detalle.getCantidadproducto().doubleValue();

				// este no es necesario. El calculo ya debiera venir echo y considerado en el monto del detalle
				//-->Double precioXcantidad = precioItem * qtyItem;

				// porcentaje de descuento, TODO: NO se esta considerando descuentoPorcentaje en Totales
				//-->Double descuentoPorcentaje = detalle.getDescuentoPct() == null ? 0 : detalle.getDescuentoPct().doubleValue();

				// porcentaje de recargo, TODO: NO se esta considerando recargoPorcentaje en Totales
				//-->Double recargoPorcentaje = detalle.getRecargoPct() == null ? 0 : detalle.getRecargoPct().doubleValue();

				// monto por linea de detalle. Corresponde al monto bruto a menos que indMontoNetoEnDetalle indique lo contrario
				Long montoXlineaDeDetalle = detalle.getMontoitem() == null ? 0 : detalle.getMontoitem().longValue();

				// monto de descuento, TODO: se esta considerando descuentoMonto en Totales, pero revisar su uso
				Double descuentoMonto = detalle.getDescuentoMonto() == null ? 0 : detalle.getDescuentoMonto().doubleValue();

				// monto de recargo, TODO: se esta considerando recargoMonto en Totales, pero revisar su uso
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

			// los totales se llenan despues de cargar el detalle de las boletas
			DTE.Documento.Encabezado.Totales jaxbTotales = jaxbFactory.createDTEDocumentoEncabezadoTotales();
			jaxbTotales.setIVA(BigInteger.valueOf(total_IVA.longValue()));
			jaxbTotales.setMntExe(BigInteger.valueOf(totalMontoExento.longValue()));
			jaxbTotales.setMntNeto(monto_neto);
			jaxbTotales.setMntTotal(jaxbTotales.getMntNeto().add(jaxbTotales.getIVA().add(jaxbTotales.getMntExe()))); // neto + iva + exento

			// TODO: los que vienen en 0. Hay que dar soporte a ellos 
			jaxbTotales.setMontoNF(null);
			jaxbTotales.setSaldoAnterior(null);
			//-->jaxbTotales.setTotalPeriodo(null);
			jaxbTotales.setVlrPagar(null);

			return jaxbTotales;

		} catch (Exception ex) {
			log.error("No fue posible crear Totales. Error: " + ex.getMessage());
			return null;
		}
	}
}
