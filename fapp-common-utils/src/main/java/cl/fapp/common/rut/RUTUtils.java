package cl.fapp.common.rut;

import lombok.extern.slf4j.Slf4j;

/**
 * Utiles para validar y dar formato a los rut.
 * El formato valido es solo con '.' y '-' (opcional)
 * El formato resultante valido solo contendra '-'.
 *
 */
@Slf4j
public class RUTUtils {

	/**
	 * Formatea un rut sin separador de miles
	 * 
	 * @param rut rut a formatear
	 * @return rut formateado
	 */
	public static String format(String rut) {
		return format(rut, "");
	}

	/**
	 * Retorna digito verificador del rut ingresado despues de formatearlo
	 * 
	 * @param rut rut
	 * @return digito verificador despues de formatear el rut
	 */
	public static String getDV(String rut) {
		String formattedrut = format(rut);
		return formattedrut.substring(formattedrut.length() - 1);
	}

	/**
	 * Retorna parte numerica del rut
	 * 
	 * @param rut rut. Antes de extraer su parte numerica, sera formateado
	 * @return parte numerica del rut, despues de ser formateado
	 */
	public static String getNumber(String rut) {
		String formattedrut = format(rut);
		return formattedrut.substring(0, formattedrut.length() - 2);
	}

	/**
	 * Estandariza formato de un rut para ser utilizado en el sistema.
	 * El formato estandarizado corresponde a: 99999999-DV
	 * 
	 * @param rut       string a estandarizar
	 * @param separador separador de miles utilizado
	 * @return rut formateado
	 */
	private static String format(String rut, String separador) {
		int cont = 0;
		String format;
		if (rut.length() == 0) {
			return "";
		} else {
			rut = rut.trim();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			format = "-" + rut.substring(rut.length() - 1).toUpperCase();
			for (int i = rut.length() - 2; i >= 0; i--) {
				format = rut.substring(i, i + 1) + format;
				cont++;
				if (cont == 3 && i != 0) {
					format = separador + format;
					cont = 0;
				}
			}
			return format;
		}
	}

	/**
	 * Valida un rut. Quita el formato, realiza el calculo del DV y compara con el
	 * indicado por parametro.
	 * Acepta rut con mantisa de largo 1.
	 * Si no se indica '-', se considera el ultimo digito como el digito verificador
	 * 
	 * @param rut rut con digito verificador
	 * @return true/false
	 */
	public static boolean isValid(String rut) {
		boolean validacion = false;
		try {
			char dvR;

			if (rut == null) {
				return false;
			}

			rut = rut.toUpperCase();
			rut = rut.replace(".", "");
			rut = rut.replace("-", "");
			rut = rut.trim();

			if (rut.length() == 0) {
				return false;
			}

			// verifica si despues de sacar el . y -, solo quedan numeros
			String tmp = rut.substring(0, rut.length() - 1);
			if (!tmp.matches("[0-9]+") || (tmp.length() < 1)) {
				return false;
			}

			int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
			dvR = rut.charAt(rut.length() - 1);
			int m = 0, s = 1;
			for (; rutAux != 0; rutAux /= 10) {
				s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
			}
			if (dvR == (char) (s != 0 ? s + 47 : 75)) {
				validacion = true;
			}

		} catch (java.lang.NumberFormatException e) {
			log.error("Ocurrio un error NumberFormatException validando el rut. Error=" + e.getMessage());
			System.out.println("Ocurrio un error NumberFormatException validando el rut. Error=" + e.getMessage());
			validacion = false;

		} catch (Exception e) {
			log.error("Ocurrio un error Exception validando el rut. Error=" + e.getMessage());
			System.out.println("Ocurrio un error Exception validando el rut. Error=" + e.getMessage());
			validacion = false;

		}

		return validacion;
	}
}
