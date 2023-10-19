package cl.fapp.restapi.controller.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;

import cl.fapp.sii.jaxb.DTE;
import lombok.extern.slf4j.Slf4j;

/**
 * Metodos para utilizar sobre estructuras de tipo {@link DTE}
 */
@Slf4j
public class DTEUtils {

	/**
	 * Crea un resumen con las propiedades mas relevantes de un DTE. Se utiliza cuando se realizan calculos.
	 * 
	 * @param dte DTE original
	 * @return un resumen del DTE
	 */
	public HashMap<String, Object> getResumen(DTE dte) {
		HashMap<String, Object> resumen = new HashMap<String, Object>();
		try {
			resumen.put("TpoDoc", dte.getDocumento().getEncabezado().getIdDoc().getTipoDTE());
			resumen.put("NroDoc", dte.getDocumento().getEncabezado().getIdDoc().getFolio());
			resumen.put("TasaImp", 0);
			resumen.put("FchDoc", dte.getDocumento().getEncabezado().getIdDoc().getFchEmis());
			resumen.put("CdgSIISucur", dte.getDocumento().getEncabezado().getEmisor().getCdgSIISucur());
			resumen.put("RUTDoc", dte.getDocumento().getEncabezado().getReceptor().getRUTRecep());
			resumen.put("RznSoc", dte.getDocumento().getEncabezado().getReceptor().getRznSocRecep());

			BigInteger montoExento = dte.getDocumento().getEncabezado().getTotales().getMntExe();
			BigInteger montoNeto = dte.getDocumento().getEncabezado().getTotales().getMntNeto();
			BigInteger montoIVA = dte.getDocumento().getEncabezado().getTotales().getIVA();
			BigInteger montoTotal = dte.getDocumento().getEncabezado().getTotales().getMntTotal();
			BigDecimal tasaImpuesto = dte.getDocumento().getEncabezado().getTotales().getTasaIVA();

			if (montoExento != null)
				resumen.put("MntExe", montoExento);
			if (montoNeto != null)
				resumen.put("MntNeto", montoNeto);
			if (montoIVA != null)
				resumen.put("MntIVA", montoIVA);
			if (montoTotal != null)
				resumen.put("MntTotal", montoTotal);
			if (tasaImpuesto != null) {
				resumen.replace("TasaImp", tasaImpuesto);
			}

			return resumen;
		} catch (Exception ex) {
			log.error("Error recuperando resumen de DTE. Error=" + ex.getMessage());
			return null;
		}
	}
}
