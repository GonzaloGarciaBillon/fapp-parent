
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
 *         &lt;element name="DocumentoCoCertif"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RutContribuyente" type="{http://www.sii.cl/SiiLce}RUTType"/&gt;
 *                   &lt;element name="FchEmision" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                   &lt;element ref="{http://www.sii.cl/SiiLce}LceCal"/&gt;
 *                   &lt;element name="RutFirmanteDistribuidor" type="{http://www.sii.cl/SiiLce}RUTType"/&gt;
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
    "documentoCoCertif",
    "signature"
})
@XmlRootElement(name = "LceCoCertif", namespace = "http://www.sii.cl/SiiLce")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
public class LceCoCertif
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DocumentoCoCertif", namespace = "http://www.sii.cl/SiiLce", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected LceCoCertif.DocumentoCoCertif documentoCoCertif;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad documentoCoCertif.
     * 
     * @return
     *     possible object is
     *     {@link LceCoCertif.DocumentoCoCertif }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public LceCoCertif.DocumentoCoCertif getDocumentoCoCertif() {
        return documentoCoCertif;
    }

    /**
     * Define el valor de la propiedad documentoCoCertif.
     * 
     * @param value
     *     allowed object is
     *     {@link LceCoCertif.DocumentoCoCertif }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setDocumentoCoCertif(LceCoCertif.DocumentoCoCertif value) {
        this.documentoCoCertif = value;
    }

    /**
     * Firma Digital sobre Documento
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
     *         &lt;element name="RutContribuyente" type="{http://www.sii.cl/SiiLce}RUTType"/&gt;
     *         &lt;element name="FchEmision" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *         &lt;element ref="{http://www.sii.cl/SiiLce}LceCal"/&gt;
     *         &lt;element name="RutFirmanteDistribuidor" type="{http://www.sii.cl/SiiLce}RUTType"/&gt;
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
        "rutContribuyente",
        "fchEmision",
        "lceCal",
        "rutFirmanteDistribuidor",
        "tmstFirma"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public static class DocumentoCoCertif
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "RutContribuyente", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String rutContribuyente;
        @XmlElement(name = "FchEmision", namespace = "http://www.sii.cl/SiiLce", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateAdapter.class)
        @XmlSchemaType(name = "date")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected Date fchEmision;
        @XmlElement(name = "LceCal", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected LceCal lceCal;
        @XmlElement(name = "RutFirmanteDistribuidor", namespace = "http://www.sii.cl/SiiLce", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String rutFirmanteDistribuidor;
        @XmlElement(name = "TmstFirma", namespace = "http://www.sii.cl/SiiLce", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateTimeAdapter.class)
        @XmlSchemaType(name = "dateTime")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected Date tmstFirma;
        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String id;

        /**
         * Obtiene el valor de la propiedad rutContribuyente.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getRutContribuyente() {
            return rutContribuyente;
        }

        /**
         * Define el valor de la propiedad rutContribuyente.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setRutContribuyente(String value) {
            this.rutContribuyente = value;
        }

        /**
         * Obtiene el valor de la propiedad fchEmision.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setFchEmision(Date value) {
            this.fchEmision = value;
        }

        /**
         * Obtiene el valor de la propiedad lceCal.
         * 
         * @return
         *     possible object is
         *     {@link LceCal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public LceCal getLceCal() {
            return lceCal;
        }

        /**
         * Define el valor de la propiedad lceCal.
         * 
         * @param value
         *     allowed object is
         *     {@link LceCal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setLceCal(LceCal value) {
            this.lceCal = value;
        }

        /**
         * Obtiene el valor de la propiedad rutFirmanteDistribuidor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getRutFirmanteDistribuidor() {
            return rutFirmanteDistribuidor;
        }

        /**
         * Define el valor de la propiedad rutFirmanteDistribuidor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setRutFirmanteDistribuidor(String value) {
            this.rutFirmanteDistribuidor = value;
        }

        /**
         * Obtiene el valor de la propiedad tmstFirma.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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

    }

}
