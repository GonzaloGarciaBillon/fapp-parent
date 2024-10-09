package cl.fapp.domain.boleta;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.BOLETADefType.Documento.Detalle.InfoTicket;
import cl.fapp.sii.jaxb.BOLETADefType.Documento.TED.DD.CAF;
import cl.fapp.sii.jaxb.EnvioBOLETA;
import cl.fapp.sii.jaxb.EnvioDTE;
import cl.fapp.sii.jaxb.Signature;

public class BoletaEnvioDTEMapper {

	public EnvioBOLETA fromRestToJAXB(BoletaEnvioDTE source) {
		BigDecimal enviodteVersion = new BigDecimal(1.1);
		BigDecimal caratulaVersion = new BigDecimal(1.0);
		BigDecimal documentoVersion = new BigDecimal(1.0);
		String tedVersion = "1.0";

		Date tmstfirma = new Date();
		Date fchresol = new Date();
		Date tmstfirmaenv = new Date();
		String rutenvia = "2222";
		
		BigInteger nroresol = BigInteger.valueOf(0);
		BigInteger cdgsiisucur = BigInteger.valueOf(100);
		String ciudadorigen = "CIUDAD_ORIGEN";
		String cmnaorigen = "COMUNA_ORIGEN";
		String dirorigen = "DIR_ORIGEN";
		String giroemisor = "GIRO_EMISOR";
		String rutemisor = "1111";
		String rznsocemisor = "RZN_SOCIAL_EMISOR";

		Date fchemis = new Date();
		Date fchvenc = new Date();
		BigInteger folio = BigInteger.valueOf(200);
		BigInteger indmntneto = BigInteger.valueOf(1);
		BigInteger indservicio = BigInteger.valueOf(1);
		Date periododesde = new Date();
		Date periodohasta = new Date();
		BigInteger tipodte = BigInteger.valueOf(39);
		
		
		String cdgintrecep = "CODIGO_INT_RECEP";
		String ciudadpostal = "CIUDAD_POSTAL";
		String ciudadrecep = "CIUDAD_RECEP";
		String cmnapostal = "COMUNA_POSTAL";
		String cmnarecep = "COMUNA_RECEP";
		String contacto = "CONTACTO_RECEP";
		String dirpostal = "DIR_POSTAL";
		String dirrecep = "DIR_RECEP";
		String rutrecep = "RUT_RECEP";
		String rznsocrecep = "RAZON_SOCIAL_RECEP";
		

		BigInteger totalesiva = BigInteger.valueOf(19);
		BigInteger totales_montoexento = BigInteger.valueOf(1000);
		BigInteger totales_montoneto = BigInteger.valueOf(10000);
		BigInteger totales_montototal = BigInteger.valueOf(11000);
		BigInteger totales_montonf = BigInteger.valueOf(11200);
		BigInteger totales_saldoanterior = BigInteger.valueOf(11300);
		BigInteger totales_totalperiodo = BigInteger.valueOf(11400);
		BigInteger totales_vlrpagar = BigInteger.valueOf(10234);


		CAF caf = new CAF();
		BigInteger F = BigInteger.valueOf(11200);
		Date FE = new Date();
		String IT1 = "IT1";
		BigInteger MNT = BigInteger.valueOf(11200);
		String RE = "RE";
		String RR = "RR";
		String RSR = "RSR";
		BigInteger TD = BigInteger.valueOf(11200);
		Date TSTED = new Date();

		String frmt_Algoritmo = "SHA1Rsa";
		byte[] frmt_value = "valor de la llave".getBytes();
		
		String documento_id = "ID_DOCUMENTO";
		
		String setdte_id = "ID_SETDTE";

		BigInteger subtotdte_nrodte = BigInteger.valueOf(11);
		BigInteger subtotdte_tpodte = BigInteger.valueOf(12);

		// ******-------------------------******
		BigInteger detalle_descuentomonto = BigInteger.valueOf(1000);
		BigDecimal detalle_descuentopct = new BigDecimal(3);
		String detalle_dscitem = "detalle_dscitem";
		BigInteger detalle_indexe = BigInteger.valueOf(13);
		Integer detalle_itemespectaculo= 14;
		BigInteger detalle_montoitem = BigInteger.valueOf(15);
		String detalle_nmbitem = "detalle_nmbitem";
		BigInteger detalle_nrolindet = BigInteger.valueOf(16);
		BigDecimal detaller_prcitem = new BigDecimal(4);
		BigDecimal detalle_qtyitem = new BigDecimal(5);
		BigInteger detalle_recargomonto = BigInteger.valueOf(17);
		BigDecimal detalle_recargopct = new BigDecimal(6);
		String detalle_rutmandante = "detalle_rutmandante";
		String detalle_unmditem = "detalle_unmditem";
		
		// -------------------------
		String cdgitem_tpocodigo = "cdgitem_tpocodigo";
		String cdgitem_vlrcodigo = "cdgitem_vlrcodigo";
		// -------------------------
		
		String referencia_codcaja = "referencia_codcaja";
		String referencia_codref = "referencia_codref";
		String referencia_codvndor = "referencia_codvndor";
		int referencia_nrolinref = 18;
		String referencia_razonref = "referencia_razonref";

		// ---------------------------
		String subtotinfos_glosaSTI = "subtotinfos_glosaSTI";
		int subtotinfos_nroSTI = 19;
		int subtotinfos_ordenSTI = 20;
		BigDecimal subtotinfos_subtotAdicSTI = new BigDecimal(7);
		BigDecimal subtotinfos_subtotExeSTI = new BigDecimal(8);
		BigDecimal subtotinfos_subtotIVASTI = new BigDecimal(9);
		BigDecimal subtotinfos_subtotNetoSTI = new BigDecimal(10);
		BigDecimal subtotinfos_valsubtotSTI = new BigDecimal(11);
		
		// ---------------------------
		
		String dscrcgglobals_glosaDR = "dscrcgglobals_glosaDR";
		BigInteger dscrcgglobals_indexeDR = BigInteger.valueOf(19);
		int dscrcgglobals_nrolindr = 21;
		String dscrcgglobals_tpomov = "dscrcgglobals_tpomov";
		String dscrcgglobals_tpovalor = "dscrcgglobals_tpovalor";
		BigDecimal dscrcgglobals_valorDR = new BigDecimal(12);
		// ---------------------------
		
		String infoticket_asntoubicevento = "infoticket_asntoubicevento";
		String infoticket_cdgevento = "infoticket_cdgevento";
		Date infoticket_fchevento = new Date();
		Date infoticket_fchgenera = new Date();
		String infoticket_filaubicevento = "infoticket_filaubicevento";
		BigInteger infoticket_folioticket = BigInteger.valueOf(22);
		String infoticket_lugarevento = "infoticket_lugarevento";
		String infoticket_nmbevento = "infoticket_nmbevento";
		String infoticket_tpoticket = "infoticket_tpoticket";
		String infoticket_ubicevento = "infoticket_ubicevento";
		
		// ---------------------------------------------------------------
		// ---------------------------------------------------------------
		EnvioDTE enviodte = new EnvioDTE();
		enviodte.setVersion(enviodteVersion);
		enviodte.setSignature(null);
		
		EnvioBOLETA.SetDTE.Caratula caratula = new EnvioBOLETA.SetDTE.Caratula();
		caratula.setFchResol(fchresol);
		caratula.setNroResol(nroresol);
		caratula.setRutEmisor(rutemisor);
		caratula.setRutEnvia(rutenvia);
		caratula.setRutReceptor(source.getEncabezado().getRutReceptor());
		caratula.setTmstFirmaEnv(tmstfirmaenv);
		caratula.setVersion(caratulaVersion);
		
		List<EnvioBOLETA.SetDTE.Caratula.SubTotDTE> list_subtotdtes = new ArrayList<EnvioBOLETA.SetDTE.Caratula.SubTotDTE>();
		EnvioBOLETA.SetDTE.Caratula.SubTotDTE subtotdte = new EnvioBOLETA.SetDTE.Caratula.SubTotDTE();
		subtotdte.setNroDTE(subtotdte_nrodte);
		subtotdte.setTpoDTE(subtotdte_tpodte);
		list_subtotdtes.add(subtotdte);
		
		caratula.getSubTotDTEs().addAll(list_subtotdtes);
		
		List<BOLETADefType> list_dte = new ArrayList<BOLETADefType>();
	
		for(int i=0; i<source.getDetalle().size(); i++) {
			@SuppressWarnings("unused")
			BoletaEnvioDTEBody body = source.getDetalle().get(i);
			BOLETADefType dte = new BOLETADefType();
			
			// encabezado
			BOLETADefType.Documento.Encabezado.Emisor emisor = new BOLETADefType.Documento.Encabezado.Emisor();
			emisor.setCdgSIISucur(cdgsiisucur);
			emisor.setCiudadOrigen(ciudadorigen);
			emisor.setCmnaOrigen(cmnaorigen);
			emisor.setDirOrigen(dirorigen);
			emisor.setGiroEmisor(giroemisor);
			emisor.setRUTEmisor(rutemisor);
			emisor.setRznSocEmisor(rznsocemisor);

			// encabezado - identificador del documento
			BOLETADefType.Documento.Encabezado.IdDoc iddoc = new BOLETADefType.Documento.Encabezado.IdDoc();
			iddoc.setFchEmis(fchemis);
			iddoc.setFchVenc(fchvenc);
			iddoc.setFolio(folio);
			iddoc.setIndMntNeto(indmntneto);
			iddoc.setIndServicio(indservicio);
			iddoc.setPeriodoDesde(periododesde);
			iddoc.setPeriodoHasta(periodohasta);
			iddoc.setTipoDTE(tipodte);
			
			// encabezado - receptor
			BOLETADefType.Documento.Encabezado.Receptor receptor = new BOLETADefType.Documento.Encabezado.Receptor();
			receptor.setCdgIntRecep(cdgintrecep);
			receptor.setCiudadPostal(ciudadpostal);
			receptor.setCiudadRecep(ciudadrecep);
			receptor.setCmnaPostal(cmnapostal);
			receptor.setCmnaRecep(cmnarecep);
			receptor.setContacto(contacto);
			receptor.setDirPostal(dirpostal);
			receptor.setDirRecep(dirrecep);
			receptor.setRUTRecep(rutrecep);
			receptor.setRznSocRecep(rznsocrecep);
			
			// encabezado - totales
			BOLETADefType.Documento.Encabezado.Totales totales = new BOLETADefType.Documento.Encabezado.Totales();
			totales.setIVA(totalesiva);
			totales.setMntExe(totales_montoexento);
			totales.setMntNeto(totales_montoneto);
			totales.setMntTotal(totales_montototal);
			totales.setMontoNF(totales_montonf);
			totales.setSaldoAnterior(totales_saldoanterior);
			totales.setTotalPeriodo(totales_totalperiodo);
			totales.setVlrPagar(totales_vlrpagar);
			
			// encabezado
			BOLETADefType.Documento.Encabezado encabezado = new BOLETADefType.Documento.Encabezado();
			encabezado.setEmisor(emisor);
			encabezado.setIdDoc(iddoc);
			encabezado.setReceptor(receptor);
			encabezado.setTotales(totales);
			
			// documento - TED - DD
			BOLETADefType.Documento.TED.DD dd = new BOLETADefType.Documento.TED.DD();
			dd.setCAF(caf);
			dd.setF(F);
			dd.setFE(FE);
			dd.setIT1(IT1);
			dd.setMNT(MNT);
			dd.setRE(RE);
			dd.setRR(RR);
			dd.setRSR(RSR);
			dd.setTD(TD);
			dd.setTSTED(TSTED);
			
			// documento - TED - FRMT
			BOLETADefType.Documento.TED.FRMT frmt = new BOLETADefType.Documento.TED.FRMT();
			frmt.setAlgoritmo(frmt_Algoritmo);
			frmt.setValue(frmt_value);

			// documento - TED			
			BOLETADefType.Documento.TED ted = new BOLETADefType.Documento.TED();
			ted.setDD(dd);
			ted.setFRMT(frmt);
			ted.setVersion(tedVersion);
			
			// documento
			BOLETADefType.Documento documento = new BOLETADefType.Documento();
			documento.setEncabezado(encabezado);
			documento.setID(documento_id);
			documento.setTED(ted);
			documento.setTmstFirma(tmstfirma);
			
			List<BOLETADefType.Documento.Detalle> list_detalles = new ArrayList<BOLETADefType.Documento.Detalle>();
			BOLETADefType.Documento.Detalle detalle = new BOLETADefType.Documento.Detalle();
			// TODO: llenar detalle
			detalle.setDescuentoMonto(detalle_descuentomonto);
			detalle.setDescuentoPct(detalle_descuentopct);
			detalle.setDscItem(detalle_dscitem);
			detalle.setIndExe(detalle_indexe);
			
			InfoTicket detalle_infoticket = new InfoTicket();
			detalle_infoticket.setAsntoUbicEvento(infoticket_asntoubicevento);
			detalle_infoticket.setCdgEvento(infoticket_cdgevento);
			detalle_infoticket.setFchEvento(infoticket_fchevento);
			detalle_infoticket.setFchGenera(infoticket_fchgenera);
			detalle_infoticket.setFilaUbicEvento(infoticket_filaubicevento);
			detalle_infoticket.setFolioTicket(infoticket_folioticket);
			detalle_infoticket.setLugarEvento(infoticket_lugarevento);
			detalle_infoticket.setNmbEvento(infoticket_nmbevento);
			detalle_infoticket.setTpoTiket(infoticket_tpoticket);
			detalle_infoticket.setUbicEvento(infoticket_ubicevento);
			detalle.setInfoTicket(detalle_infoticket);
			
			detalle.setItemEspectaculo(detalle_itemespectaculo);
			detalle.setMontoItem(detalle_montoitem);
			detalle.setNmbItem(detalle_nmbitem);
			detalle.setNroLinDet(detalle_nrolindet);
			detalle.setPrcItem(detaller_prcitem);
			detalle.setQtyItem(detalle_qtyitem);
			detalle.setRecargoMonto(detalle_recargomonto);
			detalle.setRecargoPct(detalle_recargopct);
			detalle.setRUTMandante(detalle_rutmandante);
			detalle.setUnmdItem(detalle_unmditem);

			List<BOLETADefType.Documento.Detalle.CdgItem> list_cdgitem = new ArrayList<BOLETADefType.Documento.Detalle.CdgItem>();
			BOLETADefType.Documento.Detalle.CdgItem cdgitem = new BOLETADefType.Documento.Detalle.CdgItem();
			cdgitem.setTpoCodigo(cdgitem_tpocodigo);
			cdgitem.setVlrCodigo(cdgitem_vlrcodigo);
			list_cdgitem.add(cdgitem);
			detalle.getCdgItems().addAll(list_cdgitem);
			
			list_detalles.add(detalle);
			documento.getDetalles().addAll(list_detalles);
			
			List<BOLETADefType.Documento.DscRcgGlobal> list_dscrcgglobals = new ArrayList<BOLETADefType.Documento.DscRcgGlobal>();
			BOLETADefType.Documento.DscRcgGlobal dscrcgglobals = new BOLETADefType.Documento.DscRcgGlobal();
			// TODO: llenar dscrcgglobals
			dscrcgglobals.setGlosaDR(dscrcgglobals_glosaDR);
			dscrcgglobals.setIndExeDR(dscrcgglobals_indexeDR);
			dscrcgglobals.setNroLinDR(dscrcgglobals_nrolindr);
			dscrcgglobals.setTpoMov(dscrcgglobals_tpomov);
			dscrcgglobals.setTpoValor(dscrcgglobals_tpovalor);
			dscrcgglobals.setValorDR(dscrcgglobals_valorDR);
			list_dscrcgglobals.add(dscrcgglobals);
			
			documento.getDscRcgGlobals().addAll(list_dscrcgglobals);
			
			List<BOLETADefType.Documento.Referencia> list_referencias = new ArrayList<BOLETADefType.Documento.Referencia>();
			BOLETADefType.Documento.Referencia referencia = new BOLETADefType.Documento.Referencia();
			// TODO: llenar doc_referencias
			referencia.setCodCaja(referencia_codcaja);
			referencia.setCodRef(referencia_codref);
			referencia.setCodVndor(referencia_codvndor);
			referencia.setNroLinRef(referencia_nrolinref);
			referencia.setRazonRef(referencia_razonref);
			list_referencias.add(referencia);
			
			documento.getReferencias().addAll(list_referencias);
			
			List<BOLETADefType.Documento.SubTotInfo> list_subtotinfos = new ArrayList<BOLETADefType.Documento.SubTotInfo>();
			BOLETADefType.Documento.SubTotInfo subtotinfos = new BOLETADefType.Documento.SubTotInfo();
			// TODO: llenar doc_subtotinfos
			subtotinfos.setGlosaSTI(subtotinfos_glosaSTI);
			subtotinfos.setNroSTI(subtotinfos_nroSTI);
			subtotinfos.setOrdenSTI(subtotinfos_ordenSTI);
			subtotinfos.setSubTotAdicSTI(subtotinfos_subtotAdicSTI);
			subtotinfos.setSubTotExeSTI(subtotinfos_subtotExeSTI);
			subtotinfos.setSubTotIVASTI(subtotinfos_subtotIVASTI);
			subtotinfos.setSubTotNetoSTI(subtotinfos_subtotNetoSTI);
			subtotinfos.setValSubtotSTI(subtotinfos_valsubtotSTI);
			List<Integer> list_lineasdetas = new ArrayList<Integer>();
			list_lineasdetas.add(1);
			list_lineasdetas.add(2);
			subtotinfos.getLineasDetas().addAll(list_lineasdetas);

			list_subtotinfos.add(subtotinfos);
			
			documento.getSubTotInfos().addAll(list_subtotinfos);
			
			// DTE - Boleta
			dte.setDocumento(documento);
			dte.setSignature(null);
			dte.setVersion(documentoVersion);
			
			// coleccion de dte (boletas)
			list_dte.add(dte);
		}

		EnvioBOLETA.SetDTE setdte = new EnvioBOLETA.SetDTE();
		setdte.setID(setdte_id);
		setdte.setCaratula(caratula);
		setdte.getDTES().addAll(list_dte);
		
		EnvioBOLETA envioboleta = new EnvioBOLETA();
		envioboleta.setSetDTE(setdte);
		
		Signature envioboleta_signature = null;
		envioboleta.setSignature(envioboleta_signature);
		
		BigDecimal envioboletaVersion = new BigDecimal(1.0);
		envioboleta.setVersion(envioboletaVersion);
		
		return envioboleta;
	}

}
