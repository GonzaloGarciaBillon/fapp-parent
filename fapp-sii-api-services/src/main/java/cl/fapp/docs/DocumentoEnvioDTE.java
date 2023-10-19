package cl.fapp.docs;

import java.io.UnsupportedEncodingException;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.EnvioDTE;

public class DocumentoEnvioDTE extends SIIAbstractFactory<EnvioDTE> {
	@Override
	public String toXml(EnvioDTE data, String urlSchemaLocation) throws UnsupportedEncodingException {

		String xmlContent = getXml(data, urlSchemaLocation, false);
		return xmlContent;
		
	}
}
