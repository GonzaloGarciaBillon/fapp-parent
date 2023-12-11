
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.datatype.XMLGregorianCalendar;
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
 *         &lt;element name="DocumentoCal"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RutDistribuidor" type="{http://www.sii.cl/SiiLce}RUTType"/&gt;
 *                   &lt;element name="TipoCertificado"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="C"/&gt;
 *                         &lt;enumeration value="P"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Clase"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                         &lt;enumeration value="3"/&gt;
 *                         &lt;enumeration value="4"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TipoLCE"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                         &lt;enumeration value="1"/&gt;
 *                         &lt;enumeration value="2"/&gt;
 *                         &lt;enumeration value="3"/&gt;
 *                         &lt;enumeration value="4"/&gt;
 *                         &lt;enumeration value="5"/&gt;
 *                         &lt;enumeration value="6"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="FchEmision" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element name="PeriodoVigencia" type="{http://www.w3.org/2001/XMLSchema}gYear"/&gt;
 *                   &lt;element name="TmstFirma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
    "documentoCal",
    "signature"
})
@XmlRootElement(name = "LceCal", namespace = "http://www.sii.cl/SiiLce")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
public class LceCal
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DocumentoCal", namespace = "http://www.sii.cl/SiiLce", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected LceCal.DocumentoCal documentoCal;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad documentoCal.
     * 
     * @return
     *     possible object is
     *     {@link LceCal.DocumentoCal }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public LceCal.DocumentoCal getDocumentoCal() {
        return documentoCal;
    }

    /**
     * Define el valor de la propiedad documentoCal.
     * 
     * @param value
     *     allowed object is
     *     {@link LceCal.DocumentoCal }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setDocumentoCal(LceCal.DocumentoCal value) {
        this.documentoCal = value;
    }

    /**
     * Firma Digital sobre Documento
     * 
     * @return
     *     possible object is
     *     {@link Signature }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
     *         &lt;element name="RutDistribuidor" type="{http://www.sii.cl/SiiLce}RUTType"/&gt;
     *         &lt;element name="TipoCertificado"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="C"/&gt;
     *               &lt;enumeration value="P"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Clase"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *               &lt;enumeration value="3"/&gt;
     *               &lt;enumeration value="4"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TipoLCE"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *               &lt;enumeration value="1"/&gt;
     *               &lt;enumeration value="2"/&gt;
     *               &lt;enumeration value="3"/&gt;
     *               &lt;enumeration value="4"/&gt;
     *               &lt;enumeration value="5"/&gt;
     *               &lt;enumeration value="6"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="FchEmision" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element name="PeriodoVigencia" type="{http://www.w3.org/2001/XMLSchema}gYear"/&gt;
     *         &lt;element name="TmstFirma" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
        "rutDistribuidor",
        "tipoCertificado",
        "clase",
        "tipoLCE",
        "fchEmision",
        "periodoVigencia",
        "tmstFirma"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public static class DocumentoCal
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "RutDistribuidor", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected String rutDistribuidor;
        @XmlElement(name = "TipoCertificado", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected String tipoCertificado;
        @XmlElement(name = "Clase", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected String clase;
        @XmlElement(name = "TipoLCE", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected BigInteger tipoLCE;
        @XmlElement(name = "FchEmision", namespace = "http://www.sii.cl/SiiLce", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateAdapter.class)
        @XmlSchemaType(name = "date")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected Date fchEmision;
        @XmlElement(name = "PeriodoVigencia", namespace = "http://www.sii.cl/SiiLce", required = true)
        @XmlSchemaType(name = "gYear")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected XMLGregorianCalendar periodoVigencia;
        @XmlElement(name = "TmstFirma", namespace = "http://www.sii.cl/SiiLce", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateTimeAdapter.class)
        @XmlSchemaType(name = "dateTime")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected Date tmstFirma;
        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected String id;

        /**
         * Obtiene el valor de la propiedad rutDistribuidor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public String getRutDistribuidor() {
            return rutDistribuidor;
        }

        /**
         * Define el valor de la propiedad rutDistribuidor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setRutDistribuidor(String value) {
            this.rutDistribuidor = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoCertificado.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public String getTipoCertificado() {
            return tipoCertificado;
        }

        /**
         * Define el valor de la propiedad tipoCertificado.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setTipoCertificado(String value) {
            this.tipoCertificado = value;
        }

        /**
         * Obtiene el valor de la propiedad clase.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public String getClase() {
            return clase;
        }

        /**
         * Define el valor de la propiedad clase.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setClase(String value) {
            this.clase = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoLCE.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public BigInteger getTipoLCE() {
            return tipoLCE;
        }

        /**
         * Define el valor de la propiedad tipoLCE.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setTipoLCE(BigInteger value) {
            this.tipoLCE = value;
        }

        /**
         * Obtiene el valor de la propiedad fchEmision.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public Date getFchEmision() {
            return fchEmision;
        }

        /**
         * Define el valor de la propiedad fchEmision.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setFchEmision(Date value) {
            this.fchEmision = value;
        }

        /**
         * Obtiene el valor de la propiedad periodoVigencia.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public XMLGregorianCalendar getPeriodoVigencia() {
            return periodoVigencia;
        }

        /**
         * Define el valor de la propiedad periodoVigencia.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setPeriodoVigencia(XMLGregorianCalendar value) {
            this.periodoVigencia = value;
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

    }

}
