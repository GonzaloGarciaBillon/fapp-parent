package cl.fapp.docs;

import java.io.UnsupportedEncodingException;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.LibroCompraVenta;

public class DocumentoLibroCompraVenta extends SIIAbstractFactory<LibroCompraVenta> {

	@Override
	public String toXml(LibroCompraVenta data, String urlSchemaLocation) throws UnsupportedEncodingException {

		String xmlContent = getXml(data, "http://www.sii.cl/SiiDte LibroCV_v10.xsd", false);
		return xmlContent;
	}
}
