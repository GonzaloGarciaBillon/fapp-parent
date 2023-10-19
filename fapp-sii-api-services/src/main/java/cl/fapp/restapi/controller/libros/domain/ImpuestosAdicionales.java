package cl.fapp.restapi.controller.libros.domain;

import java.math.BigDecimal;
import java.util.HashMap;

public class ImpuestosAdicionales {

	public static HashMap<Integer, ImpuestoAdicionalRecord> impuestos = new HashMap<Integer, ImpuestoAdicionalRecord>();
	static {
		impuestos.put(15, new ImpuestoAdicionalRecord("R", "IVA retenido", 19f));
		impuestos.put(17, new ImpuestoAdicionalRecord("A", "IVA anticipado faenamiento carne", 5f));
		impuestos.put(18, new ImpuestoAdicionalRecord("A", "IVA anticipado carne", 5f));
		impuestos.put(19, new ImpuestoAdicionalRecord("A", "IVA anticipado harina", 12f));
		impuestos.put(23, new ImpuestoAdicionalRecord("A", "Art 37 letras A, B, C", 15f));
		impuestos.put(24, new ImpuestoAdicionalRecord("A", "Licores, Piscos, Whisky", 31.5f));
		impuestos.put(25, new ImpuestoAdicionalRecord("A", "Vinos", 20.5f));
		impuestos.put(26, new ImpuestoAdicionalRecord("A", "Cervezas y Bebidas Alcoh.", 20.5f));
		impuestos.put(27, new ImpuestoAdicionalRecord("A", "Bebida Analcoh. y Mineral", 10f));
		impuestos.put(271, new ImpuestoAdicionalRecord("A", "Bebidas Azucaradas", 18f));
		impuestos.put(30, new ImpuestoAdicionalRecord("R", "IVA retenido legumbres", 10f));
		impuestos.put(31, new ImpuestoAdicionalRecord("R", "IVA retenido silvestres", 19f));
		impuestos.put(32, new ImpuestoAdicionalRecord("R", "IVA retenido ganado", 8f));
		impuestos.put(33, new ImpuestoAdicionalRecord("R", "IVA retenido madera", 8f));
		impuestos.put(34, new ImpuestoAdicionalRecord("R", "IVA retenido trigo", 4f));
		impuestos.put(36, new ImpuestoAdicionalRecord("R", "IVA retenido arroz", 10f));
		impuestos.put(37, new ImpuestoAdicionalRecord("R", "IVA retenido hidrobiológicas", 10f));
		impuestos.put(38, new ImpuestoAdicionalRecord("R", "IVA retenido chatarra", 19f));
		impuestos.put(39, new ImpuestoAdicionalRecord("R", "IVA retenido PPA", 19f));
		impuestos.put(41, new ImpuestoAdicionalRecord("R", "IVA retenido construcción", 19f));
		impuestos.put(44, new ImpuestoAdicionalRecord("A", "Art 37 letras E, H, I, L", 15f));
		impuestos.put(45, new ImpuestoAdicionalRecord("A", "Art 37 letra J", 50f));
		impuestos.put(47, new ImpuestoAdicionalRecord("R", "IVA retenido cartones", 19f));
		impuestos.put(48, new ImpuestoAdicionalRecord("R", "IVA retenido frambuesas y pasas", 14f));
	}

	public static String getTipo(Integer codigo) {
		if (impuestos != null && impuestos.get(codigo) != null) {
			return impuestos.get(codigo).getTipo();
		} else {
			return null;
		}
	}

	public static String getGlosa(Integer codigo) {
		if (impuestos != null && impuestos.get(codigo) != null) {
			return impuestos.get(codigo).getGlosa();
		} else {
			return null;
		}
	}

	public static Float getTasa(Integer codigo) {
		if (impuestos != null && impuestos.get(codigo) != null) {
			return impuestos.get(codigo).getTasa();
		} else {
			return null;
		}
	}

	public static BigDecimal getRetenido(ImpuestoRecord[] otrosImp) {
		BigDecimal retenido = BigDecimal.ZERO;
		for (ImpuestoRecord record : otrosImp) {
			if (record.getCodigoImpuesto().equalsIgnoreCase("R")) {
				retenido.add(record.getMontoImpuesto());
			}
		}
		return retenido;
	}
}
