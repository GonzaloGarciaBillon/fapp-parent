package cl.fapp;

import cl.fapp.common.rut.RUTUtils;

public class PruebaRUT {

	public static void main(String[] args) {
		String rutOriginal = "116792982";

		if (RUTUtils.isValid(rutOriginal)) {
			String rutFormateado = RUTUtils.format(rutOriginal);
			System.out.println("Rut original=" + rutOriginal + ", Formateado=" + rutFormateado);

		} else {
			System.out.println("Rut original=" + rutOriginal + " --> NO ES VALIDO");

		}
	}
}
