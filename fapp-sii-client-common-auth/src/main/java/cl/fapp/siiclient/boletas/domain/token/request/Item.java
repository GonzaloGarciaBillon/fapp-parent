package cl.fapp.siiclient.boletas.domain.token.request;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlElement
    private String Semilla;
}