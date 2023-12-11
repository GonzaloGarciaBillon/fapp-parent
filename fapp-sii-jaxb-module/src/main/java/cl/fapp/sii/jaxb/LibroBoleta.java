
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cl.fapp.sii.factory.adapters.DateAdapter;
import cl.fapp.sii.factory.adapters.DateTimeAdapter;
import cl.fapp.sii.factory.adapters.GYearMonthAdapter;
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
 *         &lt;element name="EnvioLibro"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Caratula"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="RutEmisorLibro" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="PeriodoTributario" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
 *                             &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="NroResol"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TipoLibro"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="10"/&gt;
 *                                   &lt;enumeration value="ESPECIAL"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TipoEnvio" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="PARCIAL"/&gt;
 *                                   &lt;enumeration value="FINAL"/&gt;
 *                                   &lt;enumeration value="TOTAL"/&gt;
 *                                   &lt;enumeration value="AJUSTE"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="NroSegmento" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FolioNotificacion"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ResumenSegmento" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="TotalesSegmento" maxOccurs="2"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
 *                                       &lt;element name="TotAnulado" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotalesServicio" maxOccurs="9" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="TpoServ"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                                       &lt;totalDigits value="1"/&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                       &lt;enumeration value="2"/&gt;
 *                                                       &lt;enumeration value="3"/&gt;
 *                                                       &lt;enumeration value="4"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="PeriodoDevengo" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotDoc"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                                       &lt;totalDigits value="10"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                                 &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotTicket" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
 *                                                       &lt;totalDigits value="7"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="ResumenPeriodo" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="TotalesPeriodo" maxOccurs="2"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
 *                                       &lt;element name="TotAnulado" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotalesServicio" maxOccurs="9"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="TpoServ"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                                       &lt;totalDigits value="1"/&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                       &lt;enumeration value="2"/&gt;
 *                                                       &lt;enumeration value="3"/&gt;
 *                                                       &lt;enumeration value="4"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="PeriodoDevengado" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotDoc" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                                                 &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                                 &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                                 &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                                 &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotTicket" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
 *                                                       &lt;totalDigits value="7"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Detalle" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
 *                             &lt;element name="FolioDoc"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Anulado" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="A"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TpoServ" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="1"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                   &lt;enumeration value="4"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FchEmiDoc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="FchVencDoc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                             &lt;element name="CdgSIISucur" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="8"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RUTCliente" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
 *                             &lt;element name="CodIntCli" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="80"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="MntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="MntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="SaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="TotTicketBoleta" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
 *                                   &lt;totalDigits value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TmstFirma"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Signature" type="{}SignatureType"/&gt;
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
    "envioLibro",
    "signature"
})
@XmlRootElement(name = "LibroBoleta")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
public class LibroBoleta
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "EnvioLibro", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected LibroBoleta.EnvioLibro envioLibro;
    @XmlElement(name = "Signature", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected SignatureType signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad envioLibro.
     * 
     * @return
     *     possible object is
     *     {@link LibroBoleta.EnvioLibro }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public LibroBoleta.EnvioLibro getEnvioLibro() {
        return envioLibro;
    }

    /**
     * Define el valor de la propiedad envioLibro.
     * 
     * @param value
     *     allowed object is
     *     {@link LibroBoleta.EnvioLibro }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setEnvioLibro(LibroBoleta.EnvioLibro value) {
        this.envioLibro = value;
    }

    /**
     * Obtiene el valor de la propiedad signature.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Define el valor de la propiedad signature.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setSignature(SignatureType value) {
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
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
     *                   &lt;element name="RutEmisorLibro" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="PeriodoTributario" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
     *                   &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="NroResol"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TipoLibro"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="10"/&gt;
     *                         &lt;enumeration value="ESPECIAL"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TipoEnvio" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="PARCIAL"/&gt;
     *                         &lt;enumeration value="FINAL"/&gt;
     *                         &lt;enumeration value="TOTAL"/&gt;
     *                         &lt;enumeration value="AJUSTE"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="NroSegmento" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FolioNotificacion"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ResumenSegmento" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TotalesSegmento" maxOccurs="2"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
     *                             &lt;element name="TotAnulado" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotalesServicio" maxOccurs="9" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="TpoServ"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                             &lt;totalDigits value="1"/&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                             &lt;enumeration value="2"/&gt;
     *                                             &lt;enumeration value="3"/&gt;
     *                                             &lt;enumeration value="4"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="PeriodoDevengo" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
     *                                       &lt;element name="TotDoc"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                             &lt;totalDigits value="10"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                                       &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotTicket" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
     *                                             &lt;totalDigits value="7"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ResumenPeriodo" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TotalesPeriodo" maxOccurs="2"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
     *                             &lt;element name="TotAnulado" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotalesServicio" maxOccurs="9"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="TpoServ"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                             &lt;totalDigits value="1"/&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                             &lt;enumeration value="2"/&gt;
     *                                             &lt;enumeration value="3"/&gt;
     *                                             &lt;enumeration value="4"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="PeriodoDevengado" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
     *                                       &lt;element name="TotDoc" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                                       &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                                       &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                                       &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                                       &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotTicket" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
     *                                             &lt;totalDigits value="7"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Detalle" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
     *                   &lt;element name="FolioDoc"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Anulado" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="A"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TpoServ" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="1"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                         &lt;enumeration value="4"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FchEmiDoc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="FchVencDoc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                   &lt;element name="CdgSIISucur" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="8"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RUTCliente" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
     *                   &lt;element name="CodIntCli" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="80"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="MntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="MntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="SaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="TotTicketBoleta" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
     *                         &lt;totalDigits value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TmstFirma"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
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
        "resumenSegmento",
        "resumenPeriodo",
        "detalles",
        "tmstFirma"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public static class EnvioLibro
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "Caratula", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LibroBoleta.EnvioLibro.Caratula caratula;
        @XmlElement(name = "ResumenSegmento")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LibroBoleta.EnvioLibro.ResumenSegmento resumenSegmento;
        @XmlElement(name = "ResumenPeriodo")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LibroBoleta.EnvioLibro.ResumenPeriodo resumenPeriodo;
        @XmlElement(name = "Detalle")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected List<LibroBoleta.EnvioLibro.Detalle> detalles;
        @XmlElement(name = "TmstFirma", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateTimeAdapter.class)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected Date tmstFirma;
        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected String id;

        /**
         * Obtiene el valor de la propiedad caratula.
         * 
         * @return
         *     possible object is
         *     {@link LibroBoleta.EnvioLibro.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LibroBoleta.EnvioLibro.Caratula getCaratula() {
            return caratula;
        }

        /**
         * Define el valor de la propiedad caratula.
         * 
         * @param value
         *     allowed object is
         *     {@link LibroBoleta.EnvioLibro.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setCaratula(LibroBoleta.EnvioLibro.Caratula value) {
            this.caratula = value;
        }

        /**
         * Obtiene el valor de la propiedad resumenSegmento.
         * 
         * @return
         *     possible object is
         *     {@link LibroBoleta.EnvioLibro.ResumenSegmento }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LibroBoleta.EnvioLibro.ResumenSegmento getResumenSegmento() {
            return resumenSegmento;
        }

        /**
         * Define el valor de la propiedad resumenSegmento.
         * 
         * @param value
         *     allowed object is
         *     {@link LibroBoleta.EnvioLibro.ResumenSegmento }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setResumenSegmento(LibroBoleta.EnvioLibro.ResumenSegmento value) {
            this.resumenSegmento = value;
        }

        /**
         * Obtiene el valor de la propiedad resumenPeriodo.
         * 
         * @return
         *     possible object is
         *     {@link LibroBoleta.EnvioLibro.ResumenPeriodo }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LibroBoleta.EnvioLibro.ResumenPeriodo getResumenPeriodo() {
            return resumenPeriodo;
        }

        /**
         * Define el valor de la propiedad resumenPeriodo.
         * 
         * @param value
         *     allowed object is
         *     {@link LibroBoleta.EnvioLibro.ResumenPeriodo }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setResumenPeriodo(LibroBoleta.EnvioLibro.ResumenPeriodo value) {
            this.resumenPeriodo = value;
        }

        /**
         * Gets the value of the detalles property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the detalles property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetalles().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LibroBoleta.EnvioLibro.Detalle }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public List<LibroBoleta.EnvioLibro.Detalle> getDetalles() {
            if (detalles == null) {
                detalles = new ArrayList<LibroBoleta.EnvioLibro.Detalle>();
            }
            return this.detalles;
        }

        /**
         * Obtiene el valor de la propiedad tmstFirma.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public Date getTmstFirma() {
            return tmstFirma;
        }

        /**
         * Define el valor de la propiedad tmstFirma.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setTmstFirma(Date value) {
            this.tmstFirma = value;
        }

        /**
         * Obtiene el valor de la propiedad id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
         *         &lt;element name="RutEmisorLibro" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="PeriodoTributario" type="{http://www.w3.org/2001/XMLSchema}gYearMonth"/&gt;
         *         &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="NroResol"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TipoLibro"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="10"/&gt;
         *               &lt;enumeration value="ESPECIAL"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TipoEnvio" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="PARCIAL"/&gt;
         *               &lt;enumeration value="FINAL"/&gt;
         *               &lt;enumeration value="TOTAL"/&gt;
         *               &lt;enumeration value="AJUSTE"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NroSegmento" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FolioNotificacion"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="18"/&gt;
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
            "rutEmisorLibro",
            "rutEnvia",
            "periodoTributario",
            "fchResol",
            "nroResol",
            "tipoLibro",
            "tipoEnvio",
            "nroSegmento",
            "folioNotificacion"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class Caratula
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "RutEmisorLibro", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rutEmisorLibro;
            @XmlElement(name = "RutEnvia", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rutEnvia;
            @XmlElement(name = "PeriodoTributario", required = true, type = String.class)
            @XmlJavaTypeAdapter(GYearMonthAdapter.class)
            @XmlSchemaType(name = "gYearMonth")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date periodoTributario;
            @XmlElement(name = "FchResol", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date fchResol;
            @XmlElement(name = "NroResol", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger nroResol;
            @XmlElement(name = "TipoLibro", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String tipoLibro;
            @XmlElement(name = "TipoEnvio")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String tipoEnvio;
            @XmlElement(name = "NroSegmento")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger nroSegmento;
            @XmlElement(name = "FolioNotificacion", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger folioNotificacion;

            /**
             * Obtiene el valor de la propiedad rutEmisorLibro.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getRutEmisorLibro() {
                return rutEmisorLibro;
            }

            /**
             * Define el valor de la propiedad rutEmisorLibro.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setRutEmisorLibro(String value) {
                this.rutEmisorLibro = value;
            }

            /**
             * Obtiene el valor de la propiedad rutEnvia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getRutEnvia() {
                return rutEnvia;
            }

            /**
             * Define el valor de la propiedad rutEnvia.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setRutEnvia(String value) {
                this.rutEnvia = value;
            }

            /**
             * Obtiene el valor de la propiedad periodoTributario.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getPeriodoTributario() {
                return periodoTributario;
            }

            /**
             * Define el valor de la propiedad periodoTributario.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setPeriodoTributario(Date value) {
                this.periodoTributario = value;
            }

            /**
             * Obtiene el valor de la propiedad fchResol.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getFchResol() {
                return fchResol;
            }

            /**
             * Define el valor de la propiedad fchResol.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFchResol(Date value) {
                this.fchResol = value;
            }

            /**
             * Obtiene el valor de la propiedad nroResol.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getNroResol() {
                return nroResol;
            }

            /**
             * Define el valor de la propiedad nroResol.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setNroResol(BigInteger value) {
                this.nroResol = value;
            }

            /**
             * Obtiene el valor de la propiedad tipoLibro.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getTipoLibro() {
                return tipoLibro;
            }

            /**
             * Define el valor de la propiedad tipoLibro.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTipoLibro(String value) {
                this.tipoLibro = value;
            }

            /**
             * Obtiene el valor de la propiedad tipoEnvio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getTipoEnvio() {
                return tipoEnvio;
            }

            /**
             * Define el valor de la propiedad tipoEnvio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTipoEnvio(String value) {
                this.tipoEnvio = value;
            }

            /**
             * Obtiene el valor de la propiedad nroSegmento.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getNroSegmento() {
                return nroSegmento;
            }

            /**
             * Define el valor de la propiedad nroSegmento.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setNroSegmento(BigInteger value) {
                this.nroSegmento = value;
            }

            /**
             * Obtiene el valor de la propiedad folioNotificacion.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getFolioNotificacion() {
                return folioNotificacion;
            }

            /**
             * Define el valor de la propiedad folioNotificacion.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFolioNotificacion(BigInteger value) {
                this.folioNotificacion = value;
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
         *         &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
         *         &lt;element name="FolioDoc"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Anulado" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="A"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TpoServ" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="1"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *               &lt;enumeration value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FchEmiDoc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="FchVencDoc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *         &lt;element name="CdgSIISucur" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="8"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RUTCliente" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
         *         &lt;element name="CodIntCli" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="80"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="MntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="MntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="SaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="TotTicketBoleta" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
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
            "tpoDoc",
            "folioDoc",
            "anulado",
            "tpoServ",
            "fchEmiDoc",
            "fchVencDoc",
            "periodoDesde",
            "periodoHasta",
            "cdgSIISucur",
            "rutCliente",
            "codIntCli",
            "mntExe",
            "mntTotal",
            "mntNoFact",
            "mntPeriodo",
            "saldoAnt",
            "vlrPagar",
            "totTicketBoleta"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class Detalle
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TpoDoc", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tpoDoc;
            @XmlElement(name = "FolioDoc", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger folioDoc;
            @XmlElement(name = "Anulado")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String anulado;
            @XmlElement(name = "TpoServ")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tpoServ;
            @XmlElement(name = "FchEmiDoc", type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date fchEmiDoc;
            @XmlElement(name = "FchVencDoc", type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date fchVencDoc;
            @XmlElement(name = "PeriodoDesde", type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date periodoDesde;
            @XmlElement(name = "PeriodoHasta", type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date periodoHasta;
            @XmlElement(name = "CdgSIISucur")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger cdgSIISucur;
            @XmlElement(name = "RUTCliente")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rutCliente;
            @XmlElement(name = "CodIntCli")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String codIntCli;
            @XmlElement(name = "MntExe")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntExe;
            @XmlElement(name = "MntTotal")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntTotal;
            @XmlElement(name = "MntNoFact")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntNoFact;
            @XmlElement(name = "MntPeriodo")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntPeriodo;
            @XmlElement(name = "SaldoAnt")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger saldoAnt;
            @XmlElement(name = "VlrPagar")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger vlrPagar;
            @XmlElement(name = "TotTicketBoleta")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger totTicketBoleta;

            /**
             * Obtiene el valor de la propiedad tpoDoc.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTpoDoc() {
                return tpoDoc;
            }

            /**
             * Define el valor de la propiedad tpoDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTpoDoc(BigInteger value) {
                this.tpoDoc = value;
            }

            /**
             * Obtiene el valor de la propiedad folioDoc.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getFolioDoc() {
                return folioDoc;
            }

            /**
             * Define el valor de la propiedad folioDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFolioDoc(BigInteger value) {
                this.folioDoc = value;
            }

            /**
             * Obtiene el valor de la propiedad anulado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getAnulado() {
                return anulado;
            }

            /**
             * Define el valor de la propiedad anulado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setAnulado(String value) {
                this.anulado = value;
            }

            /**
             * Obtiene el valor de la propiedad tpoServ.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTpoServ() {
                return tpoServ;
            }

            /**
             * Define el valor de la propiedad tpoServ.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTpoServ(BigInteger value) {
                this.tpoServ = value;
            }

            /**
             * Obtiene el valor de la propiedad fchEmiDoc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getFchEmiDoc() {
                return fchEmiDoc;
            }

            /**
             * Define el valor de la propiedad fchEmiDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFchEmiDoc(Date value) {
                this.fchEmiDoc = value;
            }

            /**
             * Obtiene el valor de la propiedad fchVencDoc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getFchVencDoc() {
                return fchVencDoc;
            }

            /**
             * Define el valor de la propiedad fchVencDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFchVencDoc(Date value) {
                this.fchVencDoc = value;
            }

            /**
             * Obtiene el valor de la propiedad periodoDesde.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getPeriodoDesde() {
                return periodoDesde;
            }

            /**
             * Define el valor de la propiedad periodoDesde.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setPeriodoDesde(Date value) {
                this.periodoDesde = value;
            }

            /**
             * Obtiene el valor de la propiedad periodoHasta.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getPeriodoHasta() {
                return periodoHasta;
            }

            /**
             * Define el valor de la propiedad periodoHasta.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setPeriodoHasta(Date value) {
                this.periodoHasta = value;
            }

            /**
             * Obtiene el valor de la propiedad cdgSIISucur.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getCdgSIISucur() {
                return cdgSIISucur;
            }

            /**
             * Define el valor de la propiedad cdgSIISucur.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setCdgSIISucur(BigInteger value) {
                this.cdgSIISucur = value;
            }

            /**
             * Obtiene el valor de la propiedad rutCliente.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getRUTCliente() {
                return rutCliente;
            }

            /**
             * Define el valor de la propiedad rutCliente.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setRUTCliente(String value) {
                this.rutCliente = value;
            }

            /**
             * Obtiene el valor de la propiedad codIntCli.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getCodIntCli() {
                return codIntCli;
            }

            /**
             * Define el valor de la propiedad codIntCli.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setCodIntCli(String value) {
                this.codIntCli = value;
            }

            /**
             * Obtiene el valor de la propiedad mntExe.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntExe() {
                return mntExe;
            }

            /**
             * Define el valor de la propiedad mntExe.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntExe(BigInteger value) {
                this.mntExe = value;
            }

            /**
             * Obtiene el valor de la propiedad mntTotal.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntTotal(BigInteger value) {
                this.mntTotal = value;
            }

            /**
             * Obtiene el valor de la propiedad mntNoFact.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntNoFact() {
                return mntNoFact;
            }

            /**
             * Define el valor de la propiedad mntNoFact.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntNoFact(BigInteger value) {
                this.mntNoFact = value;
            }

            /**
             * Obtiene el valor de la propiedad mntPeriodo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntPeriodo() {
                return mntPeriodo;
            }

            /**
             * Define el valor de la propiedad mntPeriodo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntPeriodo(BigInteger value) {
                this.mntPeriodo = value;
            }

            /**
             * Obtiene el valor de la propiedad saldoAnt.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getSaldoAnt() {
                return saldoAnt;
            }

            /**
             * Define el valor de la propiedad saldoAnt.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setSaldoAnt(BigInteger value) {
                this.saldoAnt = value;
            }

            /**
             * Obtiene el valor de la propiedad vlrPagar.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getVlrPagar() {
                return vlrPagar;
            }

            /**
             * Define el valor de la propiedad vlrPagar.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setVlrPagar(BigInteger value) {
                this.vlrPagar = value;
            }

            /**
             * Obtiene el valor de la propiedad totTicketBoleta.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTotTicketBoleta() {
                return totTicketBoleta;
            }

            /**
             * Define el valor de la propiedad totTicketBoleta.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTotTicketBoleta(BigInteger value) {
                this.totTicketBoleta = value;
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
         *         &lt;element name="TotalesPeriodo" maxOccurs="2"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
         *                   &lt;element name="TotAnulado" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotalesServicio" maxOccurs="9"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="TpoServ"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                                   &lt;totalDigits value="1"/&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                   &lt;enumeration value="2"/&gt;
         *                                   &lt;enumeration value="3"/&gt;
         *                                   &lt;enumeration value="4"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="PeriodoDevengado" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
         *                             &lt;element name="TotDoc" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *                             &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                             &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                             &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
         *                             &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                             &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                             &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                             &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                             &lt;element name="TotTicket" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
         *                                   &lt;totalDigits value="7"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
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
            "totalesPeriodos"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class ResumenPeriodo
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TotalesPeriodo", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected List<LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo> totalesPeriodos;

            /**
             * Gets the value of the totalesPeriodos property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the totalesPeriodos property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTotalesPeriodos().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public List<LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo> getTotalesPeriodos() {
                if (totalesPeriodos == null) {
                    totalesPeriodos = new ArrayList<LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo>();
                }
                return this.totalesPeriodos;
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
             *         &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
             *         &lt;element name="TotAnulado" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotalesServicio" maxOccurs="9"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="TpoServ"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *                         &lt;totalDigits value="1"/&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                         &lt;enumeration value="2"/&gt;
             *                         &lt;enumeration value="3"/&gt;
             *                         &lt;enumeration value="4"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="PeriodoDevengado" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
             *                   &lt;element name="TotDoc" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
             *                   &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *                   &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *                   &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
             *                   &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *                   &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *                   &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *                   &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *                   &lt;element name="TotTicket" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
             *                         &lt;totalDigits value="7"/&gt;
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
                "tpoDoc",
                "totAnulado",
                "totalesServicios"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class TotalesPeriodo
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TpoDoc", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger tpoDoc;
                @XmlElement(name = "TotAnulado")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totAnulado;
                @XmlElement(name = "TotalesServicio", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected List<LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotalesServicio> totalesServicios;

                /**
                 * Obtiene el valor de la propiedad tpoDoc.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTpoDoc() {
                    return tpoDoc;
                }

                /**
                 * Define el valor de la propiedad tpoDoc.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTpoDoc(BigInteger value) {
                    this.tpoDoc = value;
                }

                /**
                 * Obtiene el valor de la propiedad totAnulado.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotAnulado() {
                    return totAnulado;
                }

                /**
                 * Define el valor de la propiedad totAnulado.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotAnulado(BigInteger value) {
                    this.totAnulado = value;
                }

                /**
                 * Gets the value of the totalesServicios property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the totalesServicios property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTotalesServicios().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotalesServicio }
                 * 
                 * 
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public List<LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotalesServicio> getTotalesServicios() {
                    if (totalesServicios == null) {
                        totalesServicios = new ArrayList<LibroBoleta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotalesServicio>();
                    }
                    return this.totalesServicios;
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
                 *         &lt;element name="TpoServ"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
                 *               &lt;totalDigits value="1"/&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *               &lt;enumeration value="2"/&gt;
                 *               &lt;enumeration value="3"/&gt;
                 *               &lt;enumeration value="4"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="PeriodoDevengado" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
                 *         &lt;element name="TotDoc" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
                 *         &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
                 *         &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
                 *         &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
                 *         &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
                 *         &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
                 *         &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
                 *         &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
                 *         &lt;element name="TotTicket" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
                 *               &lt;totalDigits value="7"/&gt;
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
                    "tpoServ",
                    "periodoDevengado",
                    "totDoc",
                    "totMntExe",
                    "totMntNeto",
                    "tasaIVA",
                    "totMntIVA",
                    "totMntTotal",
                    "totMntNoFact",
                    "totMntPeriodo",
                    "totSaldoAnt",
                    "totVlrPagar",
                    "totTicket"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotalesServicio
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "TpoServ", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger tpoServ;
                    @XmlElement(name = "PeriodoDevengado", type = String.class)
                    @XmlJavaTypeAdapter(GYearMonthAdapter.class)
                    @XmlSchemaType(name = "gYearMonth")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected Date periodoDevengado;
                    @XmlElement(name = "TotDoc", required = true)
                    @XmlSchemaType(name = "positiveInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totDoc;
                    @XmlElement(name = "TotMntExe")
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntExe;
                    @XmlElement(name = "TotMntNeto", required = true)
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntNeto;
                    @XmlElement(name = "TasaIVA")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigDecimal tasaIVA;
                    @XmlElement(name = "TotMntIVA", required = true)
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntIVA;
                    @XmlElement(name = "TotMntTotal", required = true)
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntTotal;
                    @XmlElement(name = "TotMntNoFact")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntNoFact;
                    @XmlElement(name = "TotMntPeriodo")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntPeriodo;
                    @XmlElement(name = "TotSaldoAnt")
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totSaldoAnt;
                    @XmlElement(name = "TotVlrPagar")
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totVlrPagar;
                    @XmlElement(name = "TotTicket")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totTicket;

                    /**
                     * Obtiene el valor de la propiedad tpoServ.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTpoServ() {
                        return tpoServ;
                    }

                    /**
                     * Define el valor de la propiedad tpoServ.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTpoServ(BigInteger value) {
                        this.tpoServ = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad periodoDevengado.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public Date getPeriodoDevengado() {
                        return periodoDevengado;
                    }

                    /**
                     * Define el valor de la propiedad periodoDevengado.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setPeriodoDevengado(Date value) {
                        this.periodoDevengado = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totDoc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotDoc() {
                        return totDoc;
                    }

                    /**
                     * Define el valor de la propiedad totDoc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotDoc(BigInteger value) {
                        this.totDoc = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntExe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntExe() {
                        return totMntExe;
                    }

                    /**
                     * Define el valor de la propiedad totMntExe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntExe(BigInteger value) {
                        this.totMntExe = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntNeto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntNeto() {
                        return totMntNeto;
                    }

                    /**
                     * Define el valor de la propiedad totMntNeto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntNeto(BigInteger value) {
                        this.totMntNeto = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad tasaIVA.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigDecimal getTasaIVA() {
                        return tasaIVA;
                    }

                    /**
                     * Define el valor de la propiedad tasaIVA.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTasaIVA(BigDecimal value) {
                        this.tasaIVA = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntIVA.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntIVA() {
                        return totMntIVA;
                    }

                    /**
                     * Define el valor de la propiedad totMntIVA.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntIVA(BigInteger value) {
                        this.totMntIVA = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntTotal.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntTotal() {
                        return totMntTotal;
                    }

                    /**
                     * Define el valor de la propiedad totMntTotal.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntTotal(BigInteger value) {
                        this.totMntTotal = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntNoFact.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntNoFact() {
                        return totMntNoFact;
                    }

                    /**
                     * Define el valor de la propiedad totMntNoFact.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntNoFact(BigInteger value) {
                        this.totMntNoFact = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntPeriodo.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntPeriodo() {
                        return totMntPeriodo;
                    }

                    /**
                     * Define el valor de la propiedad totMntPeriodo.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntPeriodo(BigInteger value) {
                        this.totMntPeriodo = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totSaldoAnt.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotSaldoAnt() {
                        return totSaldoAnt;
                    }

                    /**
                     * Define el valor de la propiedad totSaldoAnt.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotSaldoAnt(BigInteger value) {
                        this.totSaldoAnt = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totVlrPagar.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotVlrPagar() {
                        return totVlrPagar;
                    }

                    /**
                     * Define el valor de la propiedad totVlrPagar.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotVlrPagar(BigInteger value) {
                        this.totVlrPagar = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totTicket.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotTicket() {
                        return totTicket;
                    }

                    /**
                     * Define el valor de la propiedad totTicket.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotTicket(BigInteger value) {
                        this.totTicket = value;
                    }

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
         *         &lt;element name="TotalesSegmento" maxOccurs="2"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
         *                   &lt;element name="TotAnulado" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotalesServicio" maxOccurs="9" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="TpoServ"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                                   &lt;totalDigits value="1"/&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                   &lt;enumeration value="2"/&gt;
         *                                   &lt;enumeration value="3"/&gt;
         *                                   &lt;enumeration value="4"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="PeriodoDevengo" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
         *                             &lt;element name="TotDoc"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                                   &lt;totalDigits value="10"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                             &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                             &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotTicket" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
         *                                   &lt;totalDigits value="7"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
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
            "totalesSegmentos"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class ResumenSegmento
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TotalesSegmento", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected List<LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento> totalesSegmentos;

            /**
             * Gets the value of the totalesSegmentos property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the totalesSegmentos property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTotalesSegmentos().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public List<LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento> getTotalesSegmentos() {
                if (totalesSegmentos == null) {
                    totalesSegmentos = new ArrayList<LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento>();
                }
                return this.totalesSegmentos;
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
             *         &lt;element name="TpoDoc" type="{}DoctoType"/&gt;
             *         &lt;element name="TotAnulado" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotalesServicio" maxOccurs="9" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="TpoServ"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *                         &lt;totalDigits value="1"/&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                         &lt;enumeration value="2"/&gt;
             *                         &lt;enumeration value="3"/&gt;
             *                         &lt;enumeration value="4"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="PeriodoDevengo" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
             *                   &lt;element name="TotDoc"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *                         &lt;totalDigits value="10"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *                   &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *                   &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotTicket" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
             *                         &lt;totalDigits value="7"/&gt;
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
                "tpoDoc",
                "totAnulado",
                "totalesServicios"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class TotalesSegmento
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TpoDoc", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger tpoDoc;
                @XmlElement(name = "TotAnulado")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totAnulado;
                @XmlElement(name = "TotalesServicio")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected List<LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotalesServicio> totalesServicios;

                /**
                 * Obtiene el valor de la propiedad tpoDoc.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTpoDoc() {
                    return tpoDoc;
                }

                /**
                 * Define el valor de la propiedad tpoDoc.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTpoDoc(BigInteger value) {
                    this.tpoDoc = value;
                }

                /**
                 * Obtiene el valor de la propiedad totAnulado.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotAnulado() {
                    return totAnulado;
                }

                /**
                 * Define el valor de la propiedad totAnulado.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotAnulado(BigInteger value) {
                    this.totAnulado = value;
                }

                /**
                 * Gets the value of the totalesServicios property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the totalesServicios property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTotalesServicios().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotalesServicio }
                 * 
                 * 
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public List<LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotalesServicio> getTotalesServicios() {
                    if (totalesServicios == null) {
                        totalesServicios = new ArrayList<LibroBoleta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotalesServicio>();
                    }
                    return this.totalesServicios;
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
                 *         &lt;element name="TpoServ"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
                 *               &lt;totalDigits value="1"/&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *               &lt;enumeration value="2"/&gt;
                 *               &lt;enumeration value="3"/&gt;
                 *               &lt;enumeration value="4"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="PeriodoDevengo" type="{http://www.w3.org/2001/XMLSchema}gYearMonth" minOccurs="0"/&gt;
                 *         &lt;element name="TotDoc"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                 *               &lt;totalDigits value="10"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
                 *         &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
                 *         &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotSaldoAnt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotVlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotTicket" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.sii.cl/SiiDte}MontoType"&gt;
                 *               &lt;totalDigits value="7"/&gt;
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
                    "tpoServ",
                    "periodoDevengo",
                    "totDoc",
                    "totMntExe",
                    "totMntTotal",
                    "totMntNoFact",
                    "totMntPeriodo",
                    "totSaldoAnt",
                    "totVlrPagar",
                    "totTicket"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotalesServicio
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "TpoServ", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger tpoServ;
                    @XmlElement(name = "PeriodoDevengo", type = String.class)
                    @XmlJavaTypeAdapter(GYearMonthAdapter.class)
                    @XmlSchemaType(name = "gYearMonth")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected Date periodoDevengo;
                    @XmlElement(name = "TotDoc", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totDoc;
                    @XmlElement(name = "TotMntExe")
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntExe;
                    @XmlElement(name = "TotMntTotal", required = true)
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntTotal;
                    @XmlElement(name = "TotMntNoFact")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntNoFact;
                    @XmlElement(name = "TotMntPeriodo")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntPeriodo;
                    @XmlElement(name = "TotSaldoAnt")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totSaldoAnt;
                    @XmlElement(name = "TotVlrPagar")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totVlrPagar;
                    @XmlElement(name = "TotTicket")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totTicket;

                    /**
                     * Obtiene el valor de la propiedad tpoServ.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTpoServ() {
                        return tpoServ;
                    }

                    /**
                     * Define el valor de la propiedad tpoServ.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTpoServ(BigInteger value) {
                        this.tpoServ = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad periodoDevengo.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public Date getPeriodoDevengo() {
                        return periodoDevengo;
                    }

                    /**
                     * Define el valor de la propiedad periodoDevengo.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setPeriodoDevengo(Date value) {
                        this.periodoDevengo = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totDoc.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotDoc() {
                        return totDoc;
                    }

                    /**
                     * Define el valor de la propiedad totDoc.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotDoc(BigInteger value) {
                        this.totDoc = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntExe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntExe() {
                        return totMntExe;
                    }

                    /**
                     * Define el valor de la propiedad totMntExe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntExe(BigInteger value) {
                        this.totMntExe = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntTotal.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntTotal() {
                        return totMntTotal;
                    }

                    /**
                     * Define el valor de la propiedad totMntTotal.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntTotal(BigInteger value) {
                        this.totMntTotal = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntNoFact.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntNoFact() {
                        return totMntNoFact;
                    }

                    /**
                     * Define el valor de la propiedad totMntNoFact.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntNoFact(BigInteger value) {
                        this.totMntNoFact = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntPeriodo.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntPeriodo() {
                        return totMntPeriodo;
                    }

                    /**
                     * Define el valor de la propiedad totMntPeriodo.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntPeriodo(BigInteger value) {
                        this.totMntPeriodo = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totSaldoAnt.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotSaldoAnt() {
                        return totSaldoAnt;
                    }

                    /**
                     * Define el valor de la propiedad totSaldoAnt.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotSaldoAnt(BigInteger value) {
                        this.totSaldoAnt = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totVlrPagar.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotVlrPagar() {
                        return totVlrPagar;
                    }

                    /**
                     * Define el valor de la propiedad totVlrPagar.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotVlrPagar(BigInteger value) {
                        this.totVlrPagar = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totTicket.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotTicket() {
                        return totTicket;
                    }

                    /**
                     * Define el valor de la propiedad totTicket.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotTicket(BigInteger value) {
                        this.totTicket = value;
                    }

                }

            }

        }

    }

}
