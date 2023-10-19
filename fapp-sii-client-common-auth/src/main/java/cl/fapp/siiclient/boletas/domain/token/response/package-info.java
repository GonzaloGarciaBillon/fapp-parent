/**
 * Domain classes used to produce the JSON and XML output for the RESTful services. 
 * <p>
 * These classes contain the JAXB annotations.
 *
 * @since 1.0
 * @author gporto
 * @version 1.1
 */
@XmlSchema(
    namespace = "http://www.sii.cl/XMLSchema",
    elementFormDefault = XmlNsForm.UNSET,
    xmlns = {
        @XmlNs(prefix="SII", namespaceURI="http://www.sii.cl/XMLSchema")
    }
)
package cl.fapp.siiclient.boletas.domain.token.response;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlNsForm;