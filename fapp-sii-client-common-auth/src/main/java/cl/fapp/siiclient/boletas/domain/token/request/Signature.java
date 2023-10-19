package cl.fapp.siiclient.boletas.domain.token.request;


import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Signature {

    @XmlAttribute(name="xmlns")
    String xmlns = "http://www.w3.org/2000/09/xmldsig#";
    
    @XmlElement
    private String SignatureValue;
}