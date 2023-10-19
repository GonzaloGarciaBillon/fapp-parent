package cl.fapp.docs;

import java.io.UnsupportedEncodingException;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.EnvioBOLETA;

public class DocumentoEnvioBOLETA extends SIIAbstractFactory<EnvioBOLETA> {

	@Override
	public String toXml(EnvioBOLETA data, String urlSchemaLocation) throws UnsupportedEncodingException {

		String xmlContent = getXml(data, urlSchemaLocation, false);
		return xmlContent;

	}
}
