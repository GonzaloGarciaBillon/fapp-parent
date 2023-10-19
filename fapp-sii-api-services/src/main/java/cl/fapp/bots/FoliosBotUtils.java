package cl.fapp.bots;

import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * Utilitarios para la ejecucion/configuracio del bot de folios
 */
@Slf4j
public class FoliosBotUtils {

	/**
	 * Crea el issuer a utilizar en el atributo 'filter' en la configuracion de Chrome para establecer certificado de cliente por dominio
	 * 
	 * @param issuer issuer extraido desde el certificado
	 * @return issuer a utilizar en el filtro de Chrome. Retorna null si ocurre un error.
	 */
	public static String getIssuerForFoliosBot(String issuer) {
		try {
			log.debug("Issuer original = [" + issuer + "]");

			String[] elements = issuer.split(",");
			HashMap<String, String> holder = new HashMap<String, String>();
			for (String a : elements) {
				String[] parts = a.split("=", 2);
				holder.put(parts[0], parts[1]);
			}

			holder.forEach((key, value) -> log.debug(key + " -> " + value));

			String issuerResponse = "";
			issuerResponse += "\"CN\":\"" + holder.get("CN") + "\",";
			issuerResponse += " \"L\":\"" + holder.get("L") + "\",";
			issuerResponse += " \"O\":\"" + holder.get("O") + "\",";
			issuerResponse += " \"OU\":\"" + holder.get("OU") + "\"";

			issuerResponse = "{\"ISSUER\":{" + issuerResponse + "}}";
			log.debug("Issuer generado = [" + issuerResponse + "]");

			return issuerResponse;

		} catch (Exception ex) {
			log.error("Se produjo un error obteniendo el Issuer para utilizar en bot de folios. Error=" + ex.getMessage());
			return null;
		}
	}
}
