package cl.fapp.common.xml;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Implementacion propia de XMLStreamWriter. Extraida del codigo de Apache CXF. 
 */
public class DelegatingXMLStreamWriter implements XMLStreamWriter {
	protected final XMLStreamWriter delegate;

	public DelegatingXMLStreamWriter(XMLStreamWriter del) {
		delegate = del;
	}

	public void close() throws XMLStreamException {
		delegate.close();
	}

	public void flush() throws XMLStreamException {
		delegate.flush();
	}

	public NamespaceContext getNamespaceContext() {
		return delegate.getNamespaceContext();
	}

	public String getPrefix(String uri) throws XMLStreamException {
		return delegate.getPrefix(uri);
	}

	public Object getProperty(String name) {
		return delegate.getProperty(name);
	}

	public void setDefaultNamespace(String uri) throws XMLStreamException {
		delegate.setDefaultNamespace(uri);
	}

	public void setNamespaceContext(NamespaceContext ctx) throws XMLStreamException {
		delegate.setNamespaceContext(ctx);
	}

	public void setPrefix(String pfx, String uri) throws XMLStreamException {
		delegate.setPrefix(pfx, uri);
	}

	public void writeAttribute(String prefix, String uri, String local, String value) throws XMLStreamException {
		delegate.writeAttribute(prefix, uri, local, value);
	}

	public void writeAttribute(String uri, String local, String value) throws XMLStreamException {
		delegate.writeAttribute(uri, local, value);
	}

	public void writeAttribute(String local, String value) throws XMLStreamException {
		delegate.writeAttribute(local, value);
	}

	public void writeCData(String cdata) throws XMLStreamException {
		delegate.writeCData(cdata);
	}

	public void writeCharacters(char[] arg0, int arg1, int arg2) throws XMLStreamException {
		delegate.writeCharacters(arg0, arg1, arg2);
	}

	public void writeCharacters(String text) throws XMLStreamException {
		delegate.writeCharacters(text);
	}

	public void writeComment(String text) throws XMLStreamException {
		delegate.writeComment(text);
	}

	public void writeDefaultNamespace(String uri) throws XMLStreamException {
		delegate.writeDefaultNamespace(uri);
	}

	public void writeDTD(String dtd) throws XMLStreamException {
		delegate.writeDTD(dtd);
	}

	public void writeEmptyElement(String prefix, String local, String uri) throws XMLStreamException {
		delegate.writeEmptyElement(prefix, local, uri);
	}

	public void writeEmptyElement(String uri, String local) throws XMLStreamException {
		delegate.writeEmptyElement(uri, local);
	}

	public void writeEmptyElement(String localName) throws XMLStreamException {
		delegate.writeEmptyElement(localName);
	}

	public void writeEndDocument() throws XMLStreamException {
		delegate.writeEndDocument();
	}

	public void writeEndElement() throws XMLStreamException {
		delegate.writeEndElement();
	}

	public void writeEntityRef(String ent) throws XMLStreamException {
		delegate.writeEntityRef(ent);
	}

	public void writeNamespace(String prefix, String uri) throws XMLStreamException {
		delegate.writeNamespace(prefix, uri);
	}

	public void writeProcessingInstruction(String target, String data) throws XMLStreamException {
		delegate.writeProcessingInstruction(target, data);
	}

	public void writeProcessingInstruction(String target) throws XMLStreamException {
		delegate.writeProcessingInstruction(target);
	}

	public void writeStartDocument() throws XMLStreamException {
		delegate.writeStartDocument();
	}

	public void writeStartDocument(String encoding, String ver) throws XMLStreamException {
		delegate.writeStartDocument(encoding, ver);
	}

	public void writeStartDocument(String ver) throws XMLStreamException {
		delegate.writeStartDocument(ver);
	}

	public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
		delegate.writeStartElement(prefix, local, uri);
	}

	public void writeStartElement(String uri, String local) throws XMLStreamException {
		delegate.writeStartElement(uri, local);
	}

	public void writeStartElement(String local) throws XMLStreamException {
		delegate.writeStartElement(local);
	}

}