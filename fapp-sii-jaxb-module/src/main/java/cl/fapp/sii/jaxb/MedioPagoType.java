
package cl.fapp.sii.jaxb;

import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para MedioPagoType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <pre>
 * &lt;simpleType name="MedioPagoType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="CH"/&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="EF"/&gt;
 *     &lt;enumeration value="PE"/&gt;
 *     &lt;enumeration value="TC"/&gt;
 *     &lt;enumeration value="CF"/&gt;
 *     &lt;enumeration value="OT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MedioPagoType", namespace = "http://www.sii.cl/SiiDte")
@XmlEnum
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
public enum MedioPagoType {


    /**
     * Cheque
     * 
     */
    CH,

    /**
     * Letra
     * 
     */
    LT,

    /**
     * Efectivo
     * 
     */
    EF,

    /**
     * Pago a Cuenta Corriente
     * 
     */
    PE,

    /**
     * Tarjeta de Credito
     * 
     */
    TC,

    /**
     * Cheque a Fecha
     * 
     */
    CF,

    /**
     * Otro
     * 
     */
    OT;

    public String value() {
        return name();
    }

    public static MedioPagoType fromValue(String v) {
        return valueOf(v);
    }

}
