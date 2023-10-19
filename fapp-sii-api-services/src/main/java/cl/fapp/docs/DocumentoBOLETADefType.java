package cl.fapp.docs;

import java.io.UnsupportedEncodingException;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.BOLETADefType;

public class DocumentoBOLETADefType extends SIIAbstractFactory<BOLETADefType> {

	@Override
	public String toXml(BOLETADefType data, String urlSchemaLocation) throws UnsupportedEncodingException {
		
		String xmlContent = getXml(data, urlSchemaLocation, false);
		return xmlContent;
	}

}
