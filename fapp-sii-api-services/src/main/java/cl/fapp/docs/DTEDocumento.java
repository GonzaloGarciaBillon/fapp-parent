package cl.fapp.docs;

import java.io.UnsupportedEncodingException;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.DTE;

public class DTEDocumento extends SIIAbstractFactory<DTE.Documento> {

	@Override
	public String toXml(DTE.Documento data, String urlSchemaLocation) throws UnsupportedEncodingException {
		
		String xmlContent = getXml(data, urlSchemaLocation, false);
		return xmlContent;
	}

}
