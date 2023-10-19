package cl.fapp.docs;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.LibroBoleta;
import cl.fapp.sii.jaxb.LibroBoleta.EnvioLibro;
import cl.fapp.sii.jaxb.LibroBoleta.EnvioLibro.Caratula;
import cl.fapp.sii.jaxb.LibroBoleta.EnvioLibro.ResumenPeriodo;
import cl.fapp.sii.jaxb.LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo;
import cl.fapp.sii.jaxb.LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotalesServicio;
import cl.fapp.sii.jaxb.LibroBoleta.EnvioLibro.ResumenSegmento;

public class DocumentoLibroBoleta extends SIIAbstractFactory<LibroBoleta>{

	@Override
	public String toXml(LibroBoleta data, String urlSchemaLocation) throws UnsupportedEncodingException {
		LibroBoleta libroboleta = new LibroBoleta();
		Caratula caratula = new Caratula();
		
		EnvioLibro enviolibro = new EnvioLibro();
		enviolibro.setCaratula(caratula);
		enviolibro.setID("ID_001");
		
		ResumenPeriodo resumenperiodo = new ResumenPeriodo();
		List<TotalesPeriodo> settotalesperiodos = new ArrayList<TotalesPeriodo>();
		TotalesPeriodo totalesperiodos = new TotalesPeriodo();
		totalesperiodos.setTotAnulado(BigInteger.valueOf(0));
		totalesperiodos.setTpoDoc(BigInteger.valueOf(1));
		
		List<TotalesServicio> settotalesServicios = new ArrayList<TotalesServicio>();
		TotalesServicio totalesServicio = new TotalesServicio();

		Date periododevengado = new Date();
		totalesServicio.setPeriodoDevengado(periododevengado);
		totalesServicio.setTasaIVA(new BigDecimal(19.0));
		
		settotalesServicios.add(totalesServicio);
		resumenperiodo.getTotalesPeriodos().addAll(settotalesperiodos);
		
		
		enviolibro.setResumenPeriodo(resumenperiodo );
		
		ResumenSegmento resumensegmento = new ResumenSegmento();
		enviolibro.setResumenSegmento(resumensegmento);
		
		Date tmsfirma = new Date();
		enviolibro.setTmstFirma(tmsfirma);

		
		libroboleta.setVersion(new BigDecimal(1.0));
		libroboleta.setEnvioLibro(enviolibro);
		
		String xmlContent = getXml(data, "http://www.sii.cl/SiiDte LibroBOLETA_v10.xsd", false);
		return xmlContent;
	}
}
