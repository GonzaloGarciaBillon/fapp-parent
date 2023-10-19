package cl.fapp;

import cl.fapp.docs.DTEDocumento;
import cl.fapp.docs.DTERoot;
import cl.fapp.docs.DocumentoBOLETADefType;
import cl.fapp.docs.DocumentoBOLETADefTypeDocumento;
import cl.fapp.docs.DocumentoCAFBoleta;
import cl.fapp.docs.DocumentoConsumoFolio;
import cl.fapp.docs.DocumentoEnvioBOLETA;
import cl.fapp.docs.DocumentoEnvioDTE;
import cl.fapp.docs.DocumentoLibroBoleta;
import cl.fapp.docs.DocumentoLibroCompraVenta;
import cl.fapp.sii.factory.SIIAbstractFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SIIDocumentFactoryProvider {
	public SIIAbstractFactory<?> getInstance(String choice) {

		switch (choice.toUpperCase()) {
		case "ENVIOBOLETA":
			log.debug("Creando instancia de DocumentoEnvioBOLETA. Tipo=" + choice);
			return new DocumentoEnvioBOLETA();		
		
		case "ENVIODTE":
			log.debug("Creando instancia de DocumentoEnvioDTE. Tipo=" + choice);
			return new DocumentoEnvioDTE();
		
		case "LIBROBOLETA":
			log.debug("Creando instancia de DocumentoLibroBoleta. Tipo=" + choice);
			return new DocumentoLibroBoleta();			
		
		case "CONSUMOFOLIOS":
			log.debug("Creando instancia de DocumentoConsumoFolio. Tipo=" + choice);
			return new DocumentoConsumoFolio();
		
		case "CAFBOLETA":
			log.debug("Creando instancia de DocumentoCAFBoleta. Tipo=" + choice);
			return new DocumentoCAFBoleta();
		
		case "DOCUMENTOBOLETADEFTYPEDOCUMENTO":
			log.debug("Creando instancia de DocumentoBOLETADefTypeDocumento. Tipo=" + choice);
			return new DocumentoBOLETADefTypeDocumento();

		case "DTEDOCUMENTO":
			log.debug("Creando instancia de DTE.Documento. Tipo=" + choice);
			return new DTEDocumento();
			
		case "DTE":
			log.debug("Creando instancia de DTE. Tipo=" + choice);
			return new DTERoot();
			
		case "BOLETADEFTYPE":
			log.debug("Creando instancia de BOLETADEFTYPE. Tipo=" + choice);
			return new DocumentoBOLETADefType();
			
		case "LIBROCOMPRAVENTA":
			log.debug("Creando instancia de LIBROCOMPRAVENTA. Tipo=" + choice);
			return new DocumentoLibroCompraVenta();

		default:
			log.error("Tipo de fabrica no implementado. Tipo=" + choice);
		}

		return null;
	}
}
