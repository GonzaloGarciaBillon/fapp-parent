package cl.fapp.domain.mapper;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import cl.fapp.foliomanager.FolioManager;
import cl.fapp.foliomanager.domain.Folio;
import cl.fapp.restapi.controller.boleta.domain.BoletaDescuentoRecargo;
import cl.fapp.restapi.controller.boleta.domain.BoletaDetalle;
import cl.fapp.restapi.controller.boleta.domain.BoletaDocumento;
import cl.fapp.restapi.controller.boleta.domain.BoletaEmisor;
import cl.fapp.restapi.controller.boleta.domain.BoletaReceptor;
import cl.fapp.restapi.controller.boleta.domain.BoletaReferencia;
import cl.fapp.restapi.controller.boleta.dto.GenerarBoletaRequest;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FromBoletaEnvioRequestToDTEDocumento {
	@Autowired
	FolioManager foliomanager;
	
	ObjectFactory jaxbFactory = new ObjectFactory();

	/**
	 * Mapping del request DTO {@link GenerarBoletaRequest} a JAXB List<{@link ListDTE.Documento}>
	 * 
	 * @param request DTO
	 * @return tantos List<{@link DTE}> como boletas se indican en el request
	 */
	public List<DTE> toDTEDocumento(GenerarBoletaRequest request) {

		// valores globales
		Date fechaEmision = new Date();

		// visita cada documento especificado en el arreglo
		Folio folio;

		List<DTE> jaxbBoletas = new ArrayList<DTE>();																																																
		for (BoletaDocumento documento : request.getDtes()) {
			try {
				folio = foliomanager.getFolio(request.getRutEmisor(), ConstantesTipoDocumento.BOLETA_AFECTA.getValue());
				log.debug("Se obtuvo folio=" + folio.getCardinal());
			} catch (Exception ex) {
				log.error("No fue posible obtener un folio. Error: " + ex.getMessage());
				return null;
			}

			try {
				// se crea cada porcion del documento por separado
				DTE.Documento.Encabezado encabezado = obtenerEncabezado(request.getEmisor(), documento, fechaEmision, BigInteger.valueOf(folio.getCardinal()));
				List<DTE.Documento.Detalle> jaxbDetalles = obtenerDetalles(documento);
				List<DTE.Documento.Referencia> jaxbReferencias = obtenerReferencias(documento);
				List<DTE.Documento.DscRcgGlobal> jaxbDescuentosRecargos = obtenerDescuentosRecargos(documento);
				List<DTE.Documento.SubTotInfo> jaxbSubtotinfos = obtenerSubtotInfo(documento);

				// agrega totales al encabezado
				DTE.Documento.Encabezado.Totales jaxbTotales = obtenerTotales(documento, 19d);
				encabezado.setTotales(jaxbTotales);

				// hace el unmarshall al tagCaf del folio
				DTE.Documento.TED.DD.CAF caf = MapperUtils.loadCafFromRepository(folio);
				
				// documento - TED - DD
				DTE.Documento.TED.DD dd = jaxbFactory.createDTEDocumentoTEDDD(); // new DTE.Documento.TED.DD();
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
				
				// - quita encabezados pkcs1 (BEGIN RSA PRIVATE KEY)
				String rsask = tagRsask;
				rsask = rsask.replaceAll("<RSASK>-----BEGIN RSA PRIVATE KEY-----" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN, "");
				rsask = rsask.replaceAll("-----END RSA PRIVATE KEY-----" + SiiDocumentFactoryConfiguration.CARRIAGE_RETURN + "</RSASK>", "");
				rsask = rsask.replaceAll(SiiDocumentFactoryConfiguration.CARRIAGE_RETURN, "");
				
				byte[] keyBytes = Base64.getDecoder().decode(rsask);
				
				// construye una RSAPrivateKey a partir de los datos rsask almacenados en el caf
				RSAPrivateKey privateKey = (RSAPrivateKey)MapperUtils.readPkcs1PrivateKey(keyBytes);
				
				// crea una instancia jaxb del objeto DD
				JAXBContext contextDD = JAXBContext.newInstance(DTE.Documento.TED.DD.class);
				Marshaller marshallerDD = contextDD.createMarshaller();
				marshallerDD.setProperty(Marshaller.JAXB_ENCODING, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);
				marshallerDD.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
				marshallerDD.setProperty(Marshaller.JAXB_FRAGMENT, true);
				marshallerDD.setSchema(null);
				
				// crea un writer para acumular el xml resultante
				StringWriter swxmlDD = new StringWriter();
				marshallerDD.marshal(dd, swxmlDD);
				
				String marshalledObject = swxmlDD.toString().replace("<DD xmlns=\"http://www.sii.cl/SiiDte\">", "<DD>");

				log.debug("DD a firmar: " + marshalledObject);
				
				// se firma el xml del DD
				Signature dmSignature = Signature.getInstance(SiiDocumentFactoryConfiguration.DD.SIGNATURE_ALGORITHM);
				dmSignature.initSign(privateKey);
				dmSignature.update(marshalledObject.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));

				// se codifica el dd firmado
				byte[] xmlsigned = dmSignature.sign();
				String signedMessage = new String(xmlsigned, SiiDocumentFactoryConfiguration.DEFAULT_ENCODING);

				// documento - TED - FRMT
				DTE.Documento.TED.FRMT frmt = jaxbFactory.createDTEDocumentoTEDFRMT(); // new DTE.Documento.TED.FRMT();
				frmt.setAlgoritmo(SiiDocumentFactoryConfiguration.DD.SIGNATURE_ALGORITHM);
				frmt.setValue(signedMessage.getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING));
				//frmt.setValue(Base64.getEncoder().encode(signedMessage.getBytes("UTF-8")));

				// documento - TED			
				DTE.Documento.TED ted = jaxbFactory.createDTEDocumentoTED(); // new DTE.Documento.TED();
				ted.setDD(dd);
				ted.setFRMT(frmt);
				ted.setVersion("1.0");

				// se crea el documento
				DTE.Documento boleta = jaxbFactory.createDTEDocumento(); // new DTE.Documento();
				boleta.setEncabezado(encabezado);
				boleta.getDetalles().addAll(jaxbDetalles);
				boleta.getDscRcgGlobals().addAll(jaxbDescuentosRecargos);
				boleta.getReferencias().addAll(jaxbReferencias);
				boleta.getSubTotInfos().addAll(jaxbSubtotinfos);

				// propiedades del documento
				boleta.setID(BuilderXmlID.getIDforDte(folio.getCardinal()));
				boleta.setTED(ted);
				boleta.setTmstFirma(fechaEmision);

				// crea el DTE (que puede ser firmado)
				DTE dte = jaxbFactory.createDTE(); // new DTE();
				dte.setDocumento(boleta);
				dte.setExportaciones(null);
				dte.setLiquidacion(null);
				dte.setVersion(BigDecimal.valueOf(1.0));

				// agrega el dte a la lista de respuesta
				jaxbBoletas.add(dte);

			} catch (Exception ex) {
				log.error("No fue posible construir el DTE. Error: " + ex.getMessage(), ex);
				return null;
			}
		}

		return jaxbBoletas;
	}

	/**
	 * Crea un encabezado de tipo {@link DTE.Documento.Encabezado} para crear la boleta
	 * 
	 * @param emisor       emisor de la boleta
	 * @param request      los datos del request al servicio
	 * @param fechaEmision fecha de emision del documento
	 * @param folio        numero de folio asignado
	 * @return un objeto jaxb del encabezado de la boleta, para agregar al documento
	 */
	private DTE.Documento.Encabezado obtenerEncabezado(BoletaEmisor emisor, BoletaDocumento request, Date fechaEmision, BigInteger folio) {

		try {
			BoletaReceptor receptor = request.getReceptor();

			// encabezado del dte
			DTE.Documento.Encabezado.Emisor jaxbEmisor = jaxbFactory.createDTEDocumentoEncabezadoEmisor(); // new DTE.Documento.Encabezado.Emisor();
			jaxbEmisor.setGiroEmis(emisor.getGiroEmisor());
			jaxbEmisor.setRUTEmisor(emisor.getRutEmisor());
			jaxbEmisor.setRznSoc(emisor.getRazonSocialEmisor());
			jaxbEmisor.setCdgSIISucur(emisor.getCodigoSii() == null ? null : new BigInteger(emisor.getCodigoSii()));
			jaxbEmisor.setCmnaOrigen(emisor.getComunaEmisor());
			jaxbEmisor.setCiudadOrigen(emisor.getCiudadEmisor());
			jaxbEmisor.setDirOrigen(emisor.getDireccionEmisor());
			jaxbEmisor.setCorreoEmisor(emisor.getCorreoEmisor());
			jaxbEmisor.setSucursal(emisor.getCodigoSucursalEmisor());
			
			// TODO: establecer codigo vendedor
			jaxbEmisor.setCdgVendedor(null);

			// encabezado - identificador del documento
			DTE.Documento.Encabezado.IdDoc jaxbIddoc = jaxbFactory.createDTEDocumentoEncabezadoIdDoc(); // new DTE.Documento.Encabezado.IdDoc();
			jaxbIddoc.setFchEmis(fechaEmision);
			jaxbIddoc.setFolio(folio);
			//-->jaxbIddoc.setIndMntNeto(BigInteger.valueOf(request.getIndMontoNeto()));
			jaxbIddoc.setIndServicio(BigInteger.valueOf(request.getIndicadorservicio()));
			jaxbIddoc.setTipoDTE(BigInteger.valueOf(request.getTipodocumento().getValue())); //   BoletaConstantes.Boleta.TipoDocumento.BOLETA_AFECTA));

			//-->iddoc.setFchVenc(fchvenc);
			//-->iddoc.setPeriodoDesde(periododesde);
			//-->iddoc.setPeriodoHasta(periodohasta);

			// encabezado - receptor
			DTE.Documento.Encabezado.Receptor jaxbReceptor = jaxbFactory.createDTEDocumentoEncabezadoReceptor(); // new DTE.Documento.Encabezado.Receptor();
			jaxbReceptor.setCdgIntRecep(receptor.getCodigoInterno());
			jaxbReceptor.setCiudadPostal(receptor.getCiudadPostal());
			jaxbReceptor.setCiudadRecep(receptor.getCiudad());
			jaxbReceptor.setCmnaPostal(receptor.getComunaPostal());
			jaxbReceptor.setCmnaRecep(receptor.getComuna());
			jaxbReceptor.setContacto(receptor.getContacto());
			jaxbReceptor.setDirPostal(receptor.getDireccionPostal());
			jaxbReceptor.setDirRecep(receptor.getDireccion());
			jaxbReceptor.setRUTRecep(receptor.getRut());
			jaxbReceptor.setRznSocRecep(receptor.getRazonsocial());

			// encabezado - totales (Montos totales del DTE)
			// se calcula en forma independiente, despues de procesar el detalle

			// encabezado - establece encabezado
			DTE.Documento.Encabezado encabezado = jaxbFactory.createDTEDocumentoEncabezado(); // new DTE.Documento.Encabezado();
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
	 * Crea un detalle de tipo List<{@link DTE.Documento.Detalle}>
	 * 
	 * @param documento documento especifico indicado en el request
	 * @return el detalle asociado al documento
	 */
	private List<DTE.Documento.Detalle> obtenerDetalles(BoletaDocumento documento) {
		try {
			int nrolinea = 0;
			List<DTE.Documento.Detalle> jaxbDetalles = new ArrayList<DTE.Documento.Detalle>();

			// traspasa el detalle de cada boleta
			for (BoletaDetalle detalle : documento.getDetalle()) {
				++nrolinea;
				DTE.Documento.Detalle jaxbDetalle = jaxbFactory.createDTEDocumentoDetalle(); // new DTE.Documento.Detalle();
				jaxbDetalle.setNroLinDet(nrolinea);
				jaxbDetalle.setIndExe(BigInteger.valueOf(detalle.getIndicadorExencion()));
				//-->jaxbDetalle.setItemEspectaculo(null);
				//-->jaxbDetalle.setRUTMandante(detalle.getRutMandante());
				jaxbDetalle.setNmbItem(detalle.getNombreproducto());
				//-->jaxbDetalle.setInfoTicket(null);
				jaxbDetalle.setDscItem(detalle.getDescripcionItem());
				jaxbDetalle.setQtyItem(detalle.getCantidadproducto());
				jaxbDetalle.setUnmdItem(detalle.getUmproducto());
				jaxbDetalle.setPrcItem(detalle.getPrecioItem());
				jaxbDetalle.setDescuentoPct(detalle.getDescuentoPct());
				jaxbDetalle.setDescuentoMonto(detalle.getDescuentoMonto());
				jaxbDetalle.setRecargoPct(detalle.getRecargoPct());
				jaxbDetalle.setRecargoMonto(detalle.getMontoitem().toBigInteger());
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
	 * Crea Referencias de tipo List<{@link DTE.Documento.Referencia}>
	 * 
	 * @param documento el documento es pecifico indicado en el request
	 * @return lista de referencias asociadas al documento
	 */
	private List<DTE.Documento.Referencia> obtenerReferencias(BoletaDocumento documento) {
		try {
			int nrolinea = 0;
			List<DTE.Documento.Referencia> jaxbReferencias = new ArrayList<DTE.Documento.Referencia>();
			for (BoletaReferencia referencia : documento.getReferencias()) {
				++nrolinea;
				DTE.Documento.Referencia jaxbReferencia = jaxbFactory.createDTEDocumentoReferencia(); // new DTE.Documento.Referencia();
				//-->jaxbReferencia.setCodCaja(referencia.getCodcaja());
				//-->jaxbReferencia.setCodRef(referencia.getCodref());
				//-->jaxbReferencia.setCodVndor(referencia.getCodvndor());
				jaxbReferencia.setNroLinRef(nrolinea);
				jaxbReferencia.setRazonRef(referencia.getRazonref());

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
	 * Crea descuentos y recargos de tipo List<{@link DTE.Documento.DscRcgGlobal}> asociados al documento
	 * 
	 * @param documento documento especifico indicado en el request
	 * @return lista de descuentos/recargos asociados al documento
	 */
	private List<DTE.Documento.DscRcgGlobal> obtenerDescuentosRecargos(BoletaDocumento documento) {
		try {
			int nrolinea = 0;
			List<DTE.Documento.DscRcgGlobal> jaxbDescuentosRecargos = new ArrayList<DTE.Documento.DscRcgGlobal>();
			for (BoletaDescuentoRecargo descrecargo : documento.getDescuentosRecargos()) {
				++nrolinea;
				DTE.Documento.DscRcgGlobal jaxbDsctoRecargo = jaxbFactory.createDTEDocumentoDscRcgGlobal(); // new DTE.Documento.DscRcgGlobal();
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
			log.error("No fue posible crear descuentos y recargo asociados al documento. Error: " + ex.getMessage());
			return null;
		}
	}

	/**
	 * Crea Subtotales Informativos de tipo List<{@link DTE.Documento.SubTotInfo}> asociados al documento
	 * 
	 * @param documento documento especifico indicado en el request
	 * @return lista de subtotales informativos
	 */
	private List<DTE.Documento.SubTotInfo> obtenerSubtotInfo(BoletaDocumento documento) {
		try {
			List<DTE.Documento.SubTotInfo> jaxbSubtotinfos = new ArrayList<DTE.Documento.SubTotInfo>();

			// TODO: dar soporte a subtotinfo
			/*
			int nrolinea = 0;
			List<BOLETADefType.Documento.SubTotInfo> jaxbSubtotinfos = new ArrayList<BOLETADefType.Documento.SubTotInfo>();
			for(BoletaSubtotalInformativo subtotinfo:documento.getSubtotalInformativo()) {
			    ++nrolinea;
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
	 * Crea Totales de tipo {@link DTE.Documento.Encabezado.Totales} para agregar al encabezado del documento
	 * @param documento documento al que se le calculan totales
	 * @param tasaIva   la tasa que se indique se divide por 100
	 * @return totales a informar en el encabezado del documento
	 */
	private DTE.Documento.Encabezado.Totales obtenerTotales(BoletaDocumento documento, Double tasaIva) {
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
					totalMontoExento += montoXlineaDeDetalle;
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
				total_monto = (totalMontoNeto - totalMontoExento) / (1 + (tasaIva / 100));
				total_IVA = total_monto * (tasaIva / 100);
			} else {
				total_monto = (totalMontoBruto - totalMontoExento) / (1 + (tasaIva / 100));
				total_IVA = total_monto * (tasaIva / 100);
			}

			total_IVA = Math.floor(total_IVA + 0.5);
			total_monto = Math.floor(total_monto + 0.5);
			totalMontoExento = Math.floor(totalMontoExento + 0.5);
			
			BigInteger monto_neto = BigInteger.valueOf(total_monto.longValue());

			// los totales se llenan despues de cargar el detalle de las boletas
			DTE.Documento.Encabezado.Totales jaxbTotales = jaxbFactory.createDTEDocumentoEncabezadoTotales(); // new DTE.Documento.Encabezado.Totales();
			jaxbTotales.setIVA(BigInteger.valueOf(total_IVA.longValue()));
			jaxbTotales.setMntExe(BigInteger.valueOf(totalMontoExento.longValue()));
			jaxbTotales.setMntNeto(monto_neto);
			jaxbTotales.setMntTotal(jaxbTotales.getMntNeto().add(jaxbTotales.getIVA().add(jaxbTotales.getMntExe()))); // neto + iva + exento

			// TODO: los que vienen en 0. Hay que dar soporte a ellos 
			jaxbTotales.setMontoNF(null);
			jaxbTotales.setSaldoAnterior(null);
			jaxbTotales.setVlrPagar(null);

			return jaxbTotales;

		} catch (Exception ex) {
			log.error("No fue posible crear Totales. Error: " + ex.getMessage());
			return null;
		}
	}
}
