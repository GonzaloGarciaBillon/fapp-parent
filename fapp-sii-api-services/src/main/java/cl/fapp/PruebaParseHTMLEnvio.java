package cl.fapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import cl.fapp.siiclient.axis.domain.envio.RECEPCIONDTE;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PruebaParseHTMLEnvio {

	public static void main(String[] args) {

		PruebaParseHTMLEnvio yo = new PruebaParseHTMLEnvio();
		
		String html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"   \"http://www.w3.org/TR/html4/loose.dtd\">"
		+ "<html><head><title>RESULTADO DEL UPLOAD DE DOCUMENTOS TRIBUTARIOS ELECTRONICOS</title></head><body link=\"003399\" >"
		+ "<div align=\"center\"><center><table border=\"1\" width=\"630\">  <tr>    <td>      <table width=\"630\">        <tr>          "
		+ "<td><font face=\"Arial\" size=\"2\">            <img src=\"/cvc/pcr/logo_oficial.gif\" width=\"200\" alt=\"\"></font>          </td>"
		+ "          <td></td>          <td align=\"right\" valign=\"top\">            <small><font face=\"Arial\">             "
		+ "Identificador de env&iacute;o :             <strong>0215305588</strong>            </font></small>          </td>        </tr>"
		+ "        <tr>          <td colSpan=\"3\"></td>        </tr>        <tr>          <td colSpan=\"3\">            <br>            "
		+ "<h3 align=\"center\"><font face=\"Arial\" size=\"2\">            DOCUMENTO TRIBUTARIO ELECTRONICO RECIBIDO            </font></h3>"
		+ "          </td>        </tr>        <!-- más contenido HTML aquí -->      </table>    </td>  </tr></table><center>  <br><br>  "
		+ "<font face=\"Arial\" size=\"2\">Se recomienda imprimir este aviso como comprobante y guardar   el n&uacute;mero de Identificador de env&iacute;o.</font></center><br><br><br>"
		+ "<a href=\"#\" onclick=\"window.print()\">Imprimir</a><a href=\"#\" onclick=\"window.close()\">Cerrar</a></center></div></body></html>";

		String respuesta = yo.extraerIdentificadorDeEnvio(html);
		log.debug("Respuesta=" + respuesta);
	}

	/**
     * Extrae el identificador de envío de un string HTML.
     * 
     * @param html string HTML
     * @return String representando el identificador de envío
     */
    public static String extraerIdentificadorDeEnvio(String html) {
        try {
            Document doc = Jsoup.parse(html);

            // Encuentra todos los elementos <strong> en el documento
            for (Element strong : doc.select("strong")) {
                // Encuentra el elemento <strong> que sigue al texto 'Identificador de envío :'
                if (strong.previousSibling() != null && strong.previousSibling().toString().contains("Identificador de envío :")) {
                    return strong.text();
                }
            }

            return null; // Identificador de envío no encontrado

        } catch (Exception ex) {
            System.err.println("Ocurrió un error al analizar el HTML: " + ex.getMessage());
            return null;
        }
    }

}
