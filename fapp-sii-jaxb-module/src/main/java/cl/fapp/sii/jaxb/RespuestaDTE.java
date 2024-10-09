
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cl.fapp.sii.factory.adapters.Base64Adapter;
import cl.fapp.sii.factory.adapters.DateAdapter;
import cl.fapp.sii.factory.adapters.DateTimeAdapter;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Resultado"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Caratula"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="RutResponde"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RutRecibe" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="IdRespuesta"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="NroDetalles"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="4"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="NmbContacto" type="{http://www.sii.cl/SiiDte}NombreType" minOccurs="0"/&gt;
 *                             &lt;element name="FonoContacto" type="{http://www.sii.cl/SiiDte}FonoType" minOccurs="0"/&gt;
 *                             &lt;element name="MailContacto" type="{http://www.sii.cl/SiiDte}MailType" minOccurs="0"/&gt;
 *                             &lt;element name="TmstFirmaResp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;choice&gt;
 *                     &lt;element name="RecepcionEnvio" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="NmbEnvio"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;maxLength value="80"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="FchRecep" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                               &lt;element name="CodEnvio"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                     &lt;totalDigits value="10"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="EnvioDTEID"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;maxLength value="80"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="Digest" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *                               &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
 *                               &lt;element name="RutReceptor" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
 *                               &lt;element name="EstadoRecepEnv"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                     &lt;totalDigits value="2"/&gt;
 *                                     &lt;enumeration value="0"/&gt;
 *                                     &lt;enumeration value="1"/&gt;
 *                                     &lt;enumeration value="2"/&gt;
 *                                     &lt;enumeration value="3"/&gt;
 *                                     &lt;enumeration value="90"/&gt;
 *                                     &lt;enumeration value="91"/&gt;
 *                                     &lt;enumeration value="99"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="RecepEnvGlosa"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;maxLength value="256"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="NroDTE" minOccurs="0"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                     &lt;totalDigits value="4"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="RecepcionDTE" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                                         &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                         &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                         &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                         &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                         &lt;element name="EstadoRecepDTE"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                               &lt;totalDigits value="2"/&gt;
 *                                               &lt;enumeration value="0"/&gt;
 *                                               &lt;enumeration value="1"/&gt;
 *                                               &lt;enumeration value="2"/&gt;
 *                                               &lt;enumeration value="3"/&gt;
 *                                               &lt;enumeration value="4"/&gt;
 *                                               &lt;enumeration value="99"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                         &lt;element name="RecepDTEGlosa"&gt;
 *                                           &lt;simpleType&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                               &lt;maxLength value="256"/&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/simpleType&gt;
 *                                         &lt;/element&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ResultadoDTE" maxOccurs="unbounded" minOccurs="0"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                               &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                               &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                               &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                               &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                               &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                               &lt;element name="CodEnvio"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                     &lt;totalDigits value="10"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="EstadoDTE"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                     &lt;totalDigits value="2"/&gt;
 *                                     &lt;enumeration value="0"/&gt;
 *                                     &lt;enumeration value="1"/&gt;
 *                                     &lt;enumeration value="2"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="EstadoDTEGlosa"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                     &lt;maxLength value="256"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="CodRchDsc" minOccurs="0"&gt;
 *                                 &lt;simpleType&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}negativeInteger"&gt;
 *                                     &lt;totalDigits value="3"/&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/simpleType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/sequence&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/choice&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "resultado",
    "signature"
})
@XmlRootElement(name = "RespuestaDTE", namespace = "http://www.sii.cl/SiiDte")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
public class RespuestaDTE
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "Resultado", namespace = "http://www.sii.cl/SiiDte", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected RespuestaDTE.Resultado resultado;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad resultado.
     * 
     * @return
     *     possible object is
     *     {@link RespuestaDTE.Resultado }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public RespuestaDTE.Resultado getResultado() {
        return resultado;
    }

    /**
     * Define el valor de la propiedad resultado.
     * 
     * @param value
     *     allowed object is
     *     {@link RespuestaDTE.Resultado }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setResultado(RespuestaDTE.Resultado value) {
        this.resultado = value;
    }

    /**
     * Firma Digital sobre SetDTE
     * 
     * @return
     *     possible object is
     *     {@link Signature }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public Signature getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link Signature }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setSignature(Signature value) {
        this.signature = value;
    }

    /**
     * Obtiene el valor de la propiedad version.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public BigDecimal getVersion() {
        if (version == null) {
            return new BigDecimal("1.0");
        } else {
            return version;
        }
    }

    /**
     * Define el valor de la propiedad version.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setVersion(BigDecimal value) {
        this.version = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Caratula"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="RutResponde"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RutRecibe" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="IdRespuesta"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="NroDetalles"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="4"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="NmbContacto" type="{http://www.sii.cl/SiiDte}NombreType" minOccurs="0"/&gt;
     *                   &lt;element name="FonoContacto" type="{http://www.sii.cl/SiiDte}FonoType" minOccurs="0"/&gt;
     *                   &lt;element name="MailContacto" type="{http://www.sii.cl/SiiDte}MailType" minOccurs="0"/&gt;
     *                   &lt;element name="TmstFirmaResp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;choice&gt;
     *           &lt;element name="RecepcionEnvio" maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="NmbEnvio"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;maxLength value="80"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="FchRecep" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                     &lt;element name="CodEnvio"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                           &lt;totalDigits value="10"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="EnvioDTEID"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;maxLength value="80"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="Digest" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
     *                     &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
     *                     &lt;element name="RutReceptor" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
     *                     &lt;element name="EstadoRecepEnv"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                           &lt;totalDigits value="2"/&gt;
     *                           &lt;enumeration value="0"/&gt;
     *                           &lt;enumeration value="1"/&gt;
     *                           &lt;enumeration value="2"/&gt;
     *                           &lt;enumeration value="3"/&gt;
     *                           &lt;enumeration value="90"/&gt;
     *                           &lt;enumeration value="91"/&gt;
     *                           &lt;enumeration value="99"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="RecepEnvGlosa"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;maxLength value="256"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="NroDTE" minOccurs="0"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                           &lt;totalDigits value="4"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="RecepcionDTE" maxOccurs="unbounded" minOccurs="0"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                               &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                               &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                               &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                               &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                               &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                               &lt;element name="EstadoRecepDTE"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                                     &lt;totalDigits value="2"/&gt;
     *                                     &lt;enumeration value="0"/&gt;
     *                                     &lt;enumeration value="1"/&gt;
     *                                     &lt;enumeration value="2"/&gt;
     *                                     &lt;enumeration value="3"/&gt;
     *                                     &lt;enumeration value="4"/&gt;
     *                                     &lt;enumeration value="99"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                               &lt;element name="RecepDTEGlosa"&gt;
     *                                 &lt;simpleType&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                     &lt;maxLength value="256"/&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/simpleType&gt;
     *                               &lt;/element&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *           &lt;element name="ResultadoDTE" maxOccurs="unbounded" minOccurs="0"&gt;
     *             &lt;complexType&gt;
     *               &lt;complexContent&gt;
     *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                   &lt;sequence&gt;
     *                     &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                     &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                     &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                     &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                     &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                     &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                     &lt;element name="CodEnvio"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                           &lt;totalDigits value="10"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="EstadoDTE"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                           &lt;totalDigits value="2"/&gt;
     *                           &lt;enumeration value="0"/&gt;
     *                           &lt;enumeration value="1"/&gt;
     *                           &lt;enumeration value="2"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="EstadoDTEGlosa"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                           &lt;maxLength value="256"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="CodRchDsc" minOccurs="0"&gt;
     *                       &lt;simpleType&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}negativeInteger"&gt;
     *                           &lt;totalDigits value="3"/&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/simpleType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/sequence&gt;
     *                 &lt;/restriction&gt;
     *               &lt;/complexContent&gt;
     *             &lt;/complexType&gt;
     *           &lt;/element&gt;
     *         &lt;/choice&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "caratula",
        "resultadoDTEs",
        "recepcionEnvios"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public static class Resultado
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "Caratula", namespace = "http://www.sii.cl/SiiDte", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected RespuestaDTE.Resultado.Caratula caratula;
        @XmlElement(name = "ResultadoDTE", namespace = "http://www.sii.cl/SiiDte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected List<RespuestaDTE.Resultado.ResultadoDTE> resultadoDTEs;
        @XmlElement(name = "RecepcionEnvio", namespace = "http://www.sii.cl/SiiDte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected List<RespuestaDTE.Resultado.RecepcionEnvio> recepcionEnvios;
        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String id;

        /**
         * Obtiene el valor de la propiedad caratula.
         * 
         * @return
         *     possible object is
         *     {@link RespuestaDTE.Resultado.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public RespuestaDTE.Resultado.Caratula getCaratula() {
            return caratula;
        }

        /**
         * Define el valor de la propiedad caratula.
         * 
         * @param value
         *     allowed object is
         *     {@link RespuestaDTE.Resultado.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setCaratula(RespuestaDTE.Resultado.Caratula value) {
            this.caratula = value;
        }

        /**
         * Gets the value of the resultadoDTEs property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the resultadoDTEs property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResultadoDTEs().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RespuestaDTE.Resultado.ResultadoDTE }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public List<RespuestaDTE.Resultado.ResultadoDTE> getResultadoDTEs() {
            if (resultadoDTEs == null) {
                resultadoDTEs = new ArrayList<RespuestaDTE.Resultado.ResultadoDTE>();
            }
            return this.resultadoDTEs;
        }

        /**
         * Gets the value of the recepcionEnvios property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the recepcionEnvios property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRecepcionEnvios().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RespuestaDTE.Resultado.RecepcionEnvio }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public List<RespuestaDTE.Resultado.RecepcionEnvio> getRecepcionEnvios() {
            if (recepcionEnvios == null) {
                recepcionEnvios = new ArrayList<RespuestaDTE.Resultado.RecepcionEnvio>();
            }
            return this.recepcionEnvios;
        }

        /**
         * Obtiene el valor de la propiedad id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getID() {
            return id;
        }

        /**
         * Define el valor de la propiedad id.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setID(String value) {
            this.id = value;
        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="RutResponde"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RutRecibe" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="IdRespuesta"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NroDetalles"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NmbContacto" type="{http://www.sii.cl/SiiDte}NombreType" minOccurs="0"/&gt;
         *         &lt;element name="FonoContacto" type="{http://www.sii.cl/SiiDte}FonoType" minOccurs="0"/&gt;
         *         &lt;element name="MailContacto" type="{http://www.sii.cl/SiiDte}MailType" minOccurs="0"/&gt;
         *         &lt;element name="TmstFirmaResp" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "rutResponde",
            "rutRecibe",
            "idRespuesta",
            "nroDetalles",
            "nmbContacto",
            "fonoContacto",
            "mailContacto",
            "tmstFirmaResp"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public static class Caratula
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "RutResponde", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutResponde;
            @XmlElement(name = "RutRecibe", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutRecibe;
            @XmlElement(name = "IdRespuesta", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger idRespuesta;
            @XmlElement(name = "NroDetalles", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger nroDetalles;
            @XmlElement(name = "NmbContacto", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String nmbContacto;
            @XmlElement(name = "FonoContacto", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String fonoContacto;
            @XmlElement(name = "MailContacto", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String mailContacto;
            @XmlElement(name = "TmstFirmaResp", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateTimeAdapter.class)
            @XmlSchemaType(name = "dateTime")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date tmstFirmaResp;
            @XmlAttribute(name = "version", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigDecimal version;

            /**
             * Obtiene el valor de la propiedad rutResponde.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRutResponde() {
                return rutResponde;
            }

            /**
             * Define el valor de la propiedad rutResponde.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRutResponde(String value) {
                this.rutResponde = value;
            }

            /**
             * Obtiene el valor de la propiedad rutRecibe.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRutRecibe() {
                return rutRecibe;
            }

            /**
             * Define el valor de la propiedad rutRecibe.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRutRecibe(String value) {
                this.rutRecibe = value;
            }

            /**
             * Obtiene el valor de la propiedad idRespuesta.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getIdRespuesta() {
                return idRespuesta;
            }

            /**
             * Define el valor de la propiedad idRespuesta.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setIdRespuesta(BigInteger value) {
                this.idRespuesta = value;
            }

            /**
             * Obtiene el valor de la propiedad nroDetalles.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getNroDetalles() {
                return nroDetalles;
            }

            /**
             * Define el valor de la propiedad nroDetalles.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setNroDetalles(BigInteger value) {
                this.nroDetalles = value;
            }

            /**
             * Obtiene el valor de la propiedad nmbContacto.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getNmbContacto() {
                return nmbContacto;
            }

            /**
             * Define el valor de la propiedad nmbContacto.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setNmbContacto(String value) {
                this.nmbContacto = value;
            }

            /**
             * Obtiene el valor de la propiedad fonoContacto.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getFonoContacto() {
                return fonoContacto;
            }

            /**
             * Define el valor de la propiedad fonoContacto.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFonoContacto(String value) {
                this.fonoContacto = value;
            }

            /**
             * Obtiene el valor de la propiedad mailContacto.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getMailContacto() {
                return mailContacto;
            }

            /**
             * Define el valor de la propiedad mailContacto.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setMailContacto(String value) {
                this.mailContacto = value;
            }

            /**
             * Obtiene el valor de la propiedad tmstFirmaResp.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public Date getTmstFirmaResp() {
                return tmstFirmaResp;
            }

            /**
             * Define el valor de la propiedad tmstFirmaResp.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setTmstFirmaResp(Date value) {
                this.tmstFirmaResp = value;
            }

            /**
             * Obtiene el valor de la propiedad version.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigDecimal getVersion() {
                if (version == null) {
                    return new BigDecimal("1.0");
                } else {
                    return version;
                }
            }

            /**
             * Define el valor de la propiedad version.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setVersion(BigDecimal value) {
                this.version = value;
            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="NmbEnvio"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="80"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FchRecep" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="CodEnvio"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="EnvioDTEID"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="80"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Digest" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
         *         &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
         *         &lt;element name="RutReceptor" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
         *         &lt;element name="EstadoRecepEnv"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="2"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *               &lt;enumeration value="90"/&gt;
         *               &lt;enumeration value="91"/&gt;
         *               &lt;enumeration value="99"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RecepEnvGlosa"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="256"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NroDTE" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RecepcionDTE" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *                   &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                   &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                   &lt;element name="EstadoRecepDTE"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *                         &lt;totalDigits value="2"/&gt;
         *                         &lt;enumeration value="0"/&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                         &lt;enumeration value="3"/&gt;
         *                         &lt;enumeration value="4"/&gt;
         *                         &lt;enumeration value="99"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="RecepDTEGlosa"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="256"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "nmbEnvio",
            "fchRecep",
            "codEnvio",
            "envioDTEID",
            "digest",
            "rutEmisor",
            "rutReceptor",
            "estadoRecepEnv",
            "recepEnvGlosa",
            "nroDTE",
            "recepcionDTEs"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public static class RecepcionEnvio
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "NmbEnvio", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String nmbEnvio;
            @XmlElement(name = "FchRecep", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateTimeAdapter.class)
            @XmlSchemaType(name = "dateTime")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date fchRecep;
            @XmlElement(name = "CodEnvio", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger codEnvio;
            @XmlElement(name = "EnvioDTEID", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String envioDTEID;
            @XmlElement(name = "Digest", namespace = "http://www.sii.cl/SiiDte", type = String.class)
            @XmlJavaTypeAdapter(Base64Adapter.class)
            @XmlSchemaType(name = "base64Binary")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected byte[] digest;
            @XmlElement(name = "RutEmisor", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutEmisor;
            @XmlElement(name = "RutReceptor", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutReceptor;
            @XmlElement(name = "EstadoRecepEnv", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger estadoRecepEnv;
            @XmlElement(name = "RecepEnvGlosa", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String recepEnvGlosa;
            @XmlElement(name = "NroDTE", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger nroDTE;
            @XmlElement(name = "RecepcionDTE", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected List<RespuestaDTE.Resultado.RecepcionEnvio.RecepcionDTE> recepcionDTEs;

            /**
             * Obtiene el valor de la propiedad nmbEnvio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getNmbEnvio() {
                return nmbEnvio;
            }

            /**
             * Define el valor de la propiedad nmbEnvio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setNmbEnvio(String value) {
                this.nmbEnvio = value;
            }

            /**
             * Obtiene el valor de la propiedad fchRecep.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public Date getFchRecep() {
                return fchRecep;
            }

            /**
             * Define el valor de la propiedad fchRecep.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFchRecep(Date value) {
                this.fchRecep = value;
            }

            /**
             * Obtiene el valor de la propiedad codEnvio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getCodEnvio() {
                return codEnvio;
            }

            /**
             * Define el valor de la propiedad codEnvio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setCodEnvio(BigInteger value) {
                this.codEnvio = value;
            }

            /**
             * Obtiene el valor de la propiedad envioDTEID.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getEnvioDTEID() {
                return envioDTEID;
            }

            /**
             * Define el valor de la propiedad envioDTEID.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setEnvioDTEID(String value) {
                this.envioDTEID = value;
            }

            /**
             * Obtiene el valor de la propiedad digest.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public byte[] getDigest() {
                return digest;
            }

            /**
             * Define el valor de la propiedad digest.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setDigest(byte[] value) {
                this.digest = value;
            }

            /**
             * Obtiene el valor de la propiedad rutEmisor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRutEmisor() {
                return rutEmisor;
            }

            /**
             * Define el valor de la propiedad rutEmisor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRutEmisor(String value) {
                this.rutEmisor = value;
            }

            /**
             * Obtiene el valor de la propiedad rutReceptor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRutReceptor() {
                return rutReceptor;
            }

            /**
             * Define el valor de la propiedad rutReceptor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRutReceptor(String value) {
                this.rutReceptor = value;
            }

            /**
             * Obtiene el valor de la propiedad estadoRecepEnv.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getEstadoRecepEnv() {
                return estadoRecepEnv;
            }

            /**
             * Define el valor de la propiedad estadoRecepEnv.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setEstadoRecepEnv(BigInteger value) {
                this.estadoRecepEnv = value;
            }

            /**
             * Obtiene el valor de la propiedad recepEnvGlosa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRecepEnvGlosa() {
                return recepEnvGlosa;
            }

            /**
             * Define el valor de la propiedad recepEnvGlosa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRecepEnvGlosa(String value) {
                this.recepEnvGlosa = value;
            }

            /**
             * Obtiene el valor de la propiedad nroDTE.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getNroDTE() {
                return nroDTE;
            }

            /**
             * Define el valor de la propiedad nroDTE.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setNroDTE(BigInteger value) {
                this.nroDTE = value;
            }

            /**
             * Gets the value of the recepcionDTEs property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the recepcionDTEs property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRecepcionDTEs().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link RespuestaDTE.Resultado.RecepcionEnvio.RecepcionDTE }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public List<RespuestaDTE.Resultado.RecepcionEnvio.RecepcionDTE> getRecepcionDTEs() {
                if (recepcionDTEs == null) {
                    recepcionDTEs = new ArrayList<RespuestaDTE.Resultado.RecepcionEnvio.RecepcionDTE>();
                }
                return this.recepcionDTEs;
            }


            /**
             * <p>Clase Java para anonymous complex type.
             * 
             * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
             * 
             * <pre>
             * &lt;complexType&gt;
             *   &lt;complexContent&gt;
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *       &lt;sequence&gt;
             *         &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
             *         &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
             *         &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
             *         &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
             *         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *         &lt;element name="EstadoRecepDTE"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
             *               &lt;totalDigits value="2"/&gt;
             *               &lt;enumeration value="0"/&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *               &lt;enumeration value="3"/&gt;
             *               &lt;enumeration value="4"/&gt;
             *               &lt;enumeration value="99"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="RecepDTEGlosa"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="256"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *       &lt;/sequence&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "tipoDTE",
                "folio",
                "fchEmis",
                "rutEmisor",
                "rutRecep",
                "mntTotal",
                "estadoRecepDTE",
                "recepDTEGlosa"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public static class RecepcionDTE
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TipoDTE", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger tipoDTE;
                @XmlElement(name = "Folio", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger folio;
                @XmlElement(name = "FchEmis", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
                @XmlJavaTypeAdapter(DateAdapter.class)
                @XmlSchemaType(name = "date")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected Date fchEmis;
                @XmlElement(name = "RUTEmisor", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected String rutEmisor;
                @XmlElement(name = "RUTRecep", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected String rutRecep;
                @XmlElement(name = "MntTotal", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger mntTotal;
                @XmlElement(name = "EstadoRecepDTE", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger estadoRecepDTE;
                @XmlElement(name = "RecepDTEGlosa", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected String recepDTEGlosa;

                /**
                 * Obtiene el valor de la propiedad tipoDTE.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getTipoDTE() {
                    return tipoDTE;
                }

                /**
                 * Define el valor de la propiedad tipoDTE.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setTipoDTE(BigInteger value) {
                    this.tipoDTE = value;
                }

                /**
                 * Obtiene el valor de la propiedad folio.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getFolio() {
                    return folio;
                }

                /**
                 * Define el valor de la propiedad folio.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setFolio(BigInteger value) {
                    this.folio = value;
                }

                /**
                 * Obtiene el valor de la propiedad fchEmis.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public Date getFchEmis() {
                    return fchEmis;
                }

                /**
                 * Define el valor de la propiedad fchEmis.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setFchEmis(Date value) {
                    this.fchEmis = value;
                }

                /**
                 * Obtiene el valor de la propiedad rutEmisor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public String getRUTEmisor() {
                    return rutEmisor;
                }

                /**
                 * Define el valor de la propiedad rutEmisor.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setRUTEmisor(String value) {
                    this.rutEmisor = value;
                }

                /**
                 * Obtiene el valor de la propiedad rutRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public String getRUTRecep() {
                    return rutRecep;
                }

                /**
                 * Define el valor de la propiedad rutRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setRUTRecep(String value) {
                    this.rutRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad mntTotal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getMntTotal() {
                    return mntTotal;
                }

                /**
                 * Define el valor de la propiedad mntTotal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setMntTotal(BigInteger value) {
                    this.mntTotal = value;
                }

                /**
                 * Obtiene el valor de la propiedad estadoRecepDTE.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getEstadoRecepDTE() {
                    return estadoRecepDTE;
                }

                /**
                 * Define el valor de la propiedad estadoRecepDTE.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setEstadoRecepDTE(BigInteger value) {
                    this.estadoRecepDTE = value;
                }

                /**
                 * Obtiene el valor de la propiedad recepDTEGlosa.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public String getRecepDTEGlosa() {
                    return recepDTEGlosa;
                }

                /**
                 * Define el valor de la propiedad recepDTEGlosa.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setRecepDTEGlosa(String value) {
                    this.recepDTEGlosa = value;
                }

            }

        }


        /**
         * <p>Clase Java para anonymous complex type.
         * 
         * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *         &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *         &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *         &lt;element name="CodEnvio"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="EstadoDTE"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="2"/&gt;
         *               &lt;enumeration value="0"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="EstadoDTEGlosa"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="256"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CodRchDsc" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}negativeInteger"&gt;
         *               &lt;totalDigits value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "tipoDTE",
            "folio",
            "fchEmis",
            "rutEmisor",
            "rutRecep",
            "mntTotal",
            "codEnvio",
            "estadoDTE",
            "estadoDTEGlosa",
            "codRchDsc"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public static class ResultadoDTE
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TipoDTE", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger tipoDTE;
            @XmlElement(name = "Folio", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger folio;
            @XmlElement(name = "FchEmis", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date fchEmis;
            @XmlElement(name = "RUTEmisor", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutEmisor;
            @XmlElement(name = "RUTRecep", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutRecep;
            @XmlElement(name = "MntTotal", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger mntTotal;
            @XmlElement(name = "CodEnvio", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger codEnvio;
            @XmlElement(name = "EstadoDTE", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger estadoDTE;
            @XmlElement(name = "EstadoDTEGlosa", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String estadoDTEGlosa;
            @XmlElement(name = "CodRchDsc", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger codRchDsc;

            /**
             * Obtiene el valor de la propiedad tipoDTE.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getTipoDTE() {
                return tipoDTE;
            }

            /**
             * Define el valor de la propiedad tipoDTE.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setTipoDTE(BigInteger value) {
                this.tipoDTE = value;
            }

            /**
             * Obtiene el valor de la propiedad folio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getFolio() {
                return folio;
            }

            /**
             * Define el valor de la propiedad folio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFolio(BigInteger value) {
                this.folio = value;
            }

            /**
             * Obtiene el valor de la propiedad fchEmis.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public Date getFchEmis() {
                return fchEmis;
            }

            /**
             * Define el valor de la propiedad fchEmis.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFchEmis(Date value) {
                this.fchEmis = value;
            }

            /**
             * Obtiene el valor de la propiedad rutEmisor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRUTEmisor() {
                return rutEmisor;
            }

            /**
             * Define el valor de la propiedad rutEmisor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRUTEmisor(String value) {
                this.rutEmisor = value;
            }

            /**
             * Obtiene el valor de la propiedad rutRecep.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getRUTRecep() {
                return rutRecep;
            }

            /**
             * Define el valor de la propiedad rutRecep.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setRUTRecep(String value) {
                this.rutRecep = value;
            }

            /**
             * Obtiene el valor de la propiedad mntTotal.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getMntTotal() {
                return mntTotal;
            }

            /**
             * Define el valor de la propiedad mntTotal.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setMntTotal(BigInteger value) {
                this.mntTotal = value;
            }

            /**
             * Obtiene el valor de la propiedad codEnvio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getCodEnvio() {
                return codEnvio;
            }

            /**
             * Define el valor de la propiedad codEnvio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setCodEnvio(BigInteger value) {
                this.codEnvio = value;
            }

            /**
             * Obtiene el valor de la propiedad estadoDTE.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getEstadoDTE() {
                return estadoDTE;
            }

            /**
             * Define el valor de la propiedad estadoDTE.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setEstadoDTE(BigInteger value) {
                this.estadoDTE = value;
            }

            /**
             * Obtiene el valor de la propiedad estadoDTEGlosa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public String getEstadoDTEGlosa() {
                return estadoDTEGlosa;
            }

            /**
             * Define el valor de la propiedad estadoDTEGlosa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setEstadoDTEGlosa(String value) {
                this.estadoDTEGlosa = value;
            }

            /**
             * Obtiene el valor de la propiedad codRchDsc.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getCodRchDsc() {
                return codRchDsc;
            }

            /**
             * Define el valor de la propiedad codRchDsc.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setCodRchDsc(BigInteger value) {
                this.codRchDsc = value;
            }

        }

    }

}
