package cl.fapp;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import cl.fapp.siiclient.axis.domain.envio.RECEPCIONDTE;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PruebaParseXMLEnvio {

	public static void main(String[] args) {

		PruebaParseXMLEnvio yo = new PruebaParseXMLEnvio();

//		String xml = "<RECEPCIONDTE><RUTSENDER>1-9</RUTSENDER><RUTCOMPANY >3-5</RUTCOMPANY>\r\n"
//				+ "<FILE>EnvioEjemplo.xml</FILE><TIMESTAMP>2002-11-25 18:51:44</TIMESTAMP>\r\n"
//				+ "<STATUS>5</STATUS></RECEPCIONDTE>";
		
		String xml = "<RECEPCIONDTE>\r\n"
				+ "<RUTSENDER>07880442-4</RUTSENDER>\r\n"
				+ "<RUTCOMPANY>88888888-8</RUTCOMPANY>\r\n"
				+ "<FILE>ENVFIN_100_sign.xml</FILE>\r\n"
				+ "<TIMESTAMP>2003-10-31 10:04:26</TIMESTAMP>\r\n"
				+ "<STATUS>7</STATUS>\r\n"
				+ "<DETAIL>\r\n"
				+ "<ERROR>LSX-00265: attribute \"version\" value \"3.2\" is wrong (must be \".2\")</ERROR>\r\n"
				+ "<ERROR>LSX-00213: only 0 occurrences of particle \"sequence\", minimum is 1</ERROR>\r\n"
				+ "</DETAIL>\r\n"
				+ "</RECEPCIONDTE>";

		RECEPCIONDTE respuesta = yo.xmlToPojo(xml);
		log.debug("Respuesta=" + respuesta);
	}

	/**
	 * Convierte un string xml simple a un POJO
	 * @param xml string xml simple
	 * @return POJO de respuesta al envio del DTE
	 */
	private RECEPCIONDTE xmlToPojo(String xml) {
		try {
		    JacksonXmlModule module = new JacksonXmlModule();
		    module.setDefaultUseWrapper(false);
		    XmlMapper xmlMapper = new XmlMapper(module);
		    
			RECEPCIONDTE pojo = xmlMapper.readValue(xml, RECEPCIONDTE.class);
			return pojo;

		} catch (Exception ex) {
			log.error("Ocurrio un error convirtiendo xml a objeto. Error=" + ex.getMessage());
			return null;
		}
	}

}
