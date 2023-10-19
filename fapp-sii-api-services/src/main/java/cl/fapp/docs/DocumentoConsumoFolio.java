package cl.fapp.docs;

import java.io.UnsupportedEncodingException;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.ConsumoFolios;

public class DocumentoConsumoFolio extends SIIAbstractFactory<ConsumoFolios> {

	@Override
	public String toXml(ConsumoFolios data, String urlSchemaLocation) throws UnsupportedEncodingException {

		String xmlContent = getXml(data, urlSchemaLocation, false);
		return xmlContent;
	}
}
