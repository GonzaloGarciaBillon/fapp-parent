package cl.fapp.common.xml;

import java.io.Writer;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Extension a XMLWriter que no escribe los namespace
 */
public class NoNamespaceWriter extends DelegatingXMLStreamWriter {

	public NoNamespaceWriter(XMLStreamWriter writer) {
		super(writer);
	}

	public static XMLStreamWriter filter(Writer writer) throws XMLStreamException {
		return new NoNamespaceWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(writer));
	}

	@Override
	public void writeNamespace(String prefix, String uri) throws XMLStreamException {
		// intencionalmente no hace nada
	}

	@Override
	public void writeDefaultNamespace(String uri) throws XMLStreamException {
		// intencionalmente no hace nada
	}

	@Override
	public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
		super.writeStartElement(null, local, null);
	}

	@Override
	public void writeStartElement(String uri, String local) throws XMLStreamException {
		super.writeStartElement(null, local);
	}

	@Override
	public void writeEmptyElement(String uri, String local) throws XMLStreamException {
		super.writeEmptyElement(null, local);
	}

	@Override
	public void writeEmptyElement(String prefix, String local, String uri) throws XMLStreamException {
		super.writeEmptyElement(null, local, null);
	}

	@Override
	public void writeAttribute(String prefix, String uri, String local, String value) throws XMLStreamException {
		super.writeAttribute(null, null, local, value);
	}

	@Override
	public void writeAttribute(String uri, String local, String value) throws XMLStreamException {
		super.writeAttribute(null, local, value);
	}

	/*
	 * private static final NamespaceContext emptyNamespaceContext = new
	 * NamespaceContext() {
	 * 
	 * @Override
	 * public String getNamespaceURI(String prefix) {
	 * return "";
	 * }
	 * 
	 * @Override
	 * public String getPrefix(String namespaceURI) {
	 * return "";
	 * }
	 * 
	 * @Override
	 * public Iterator<String> getPrefixes(String namespaceURI) {
	 * return null;
	 * }
	 * 
	 * };
	 * 
	 * public static XMLStreamWriter filter(Writer writer) throws XMLStreamException
	 * {
	 * return new
	 * NoNamesWriter(XMLOutputFactory.newInstance().createXMLStreamWriter(writer));
	 * }
	 * 
	 * @Override
	 * public NamespaceContext getNamespaceContext() {
	 * return emptyNamespaceContext;
	 * }
	 */

}
