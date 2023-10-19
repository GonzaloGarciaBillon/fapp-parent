package cl.fapp.siiclient.boletas.domain.token;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

import cl.fapp.siiclient.boletas.domain.token.request.Item;
import cl.fapp.siiclient.boletas.domain.token.request.Signature;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
    /*
    <getToken>
        <item>
            <Semilla>030530912644</Semilla>
        </item>
        <Signature xmlns="http://www.w3.org/2000/09/xmldsig#">
            <SignatureValue>jlbzatII...</SignatureValue>
        </Signature>
    </getToken>
     */

@XmlRootElement(name = "getToken")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter @NoArgsConstructor @ToString
public class BoletaTokenRequest {
    
    @XmlElement(name="item")
	private Item item;

	@XmlElement(name="Signature")
	private Signature signature;


}
