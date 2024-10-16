
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
 *         &lt;element name="SetDTE"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Caratula"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="RutEmisor"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="RutReceptor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="NroResol"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TmstFirmaEnv" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                             &lt;element name="SubTotDTE" maxOccurs="2"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TpoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                                       &lt;element name="NroDTE" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="DTE" type="{}BOLETADefType" maxOccurs="500"/&gt;
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
    "setDTE",
    "signature"
})
@XmlRootElement(name = "EnvioBOLETA")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
public class EnvioBOLETA
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "SetDTE", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    protected EnvioBOLETA.SetDTE setDTE;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad setDTE.
     * 
     * @return
     *     possible object is
     *     {@link EnvioBOLETA.SetDTE }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    public EnvioBOLETA.SetDTE getSetDTE() {
        return setDTE;
    }

    /**
     * Define el valor de la propiedad setDTE.
     * 
     * @param value
     *     allowed object is
     *     {@link EnvioBOLETA.SetDTE }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    public void setSetDTE(EnvioBOLETA.SetDTE value) {
        this.setDTE = value;
    }

    /**
     * Obtiene el valor de la propiedad signature.
     * 
     * @return
     *     possible object is
     *     {@link Signature }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
     *                   &lt;element name="RutEmisor"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="RutReceptor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="NroResol"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TmstFirmaEnv" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                   &lt;element name="SubTotDTE" maxOccurs="2"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TpoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                             &lt;element name="NroDTE" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DTE" type="{}BOLETADefType" maxOccurs="500"/&gt;
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
        "dtes"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    public static class SetDTE
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "Caratula", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected EnvioBOLETA.SetDTE.Caratula caratula;
        @XmlElement(name = "DTE", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected List<BOLETADefType> dtes;
        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected String id;

        /**
         * Obtiene el valor de la propiedad caratula.
         * 
         * @return
         *     possible object is
         *     {@link EnvioBOLETA.SetDTE.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public EnvioBOLETA.SetDTE.Caratula getCaratula() {
            return caratula;
        }

        /**
         * Define el valor de la propiedad caratula.
         * 
         * @param value
         *     allowed object is
         *     {@link EnvioBOLETA.SetDTE.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public void setCaratula(EnvioBOLETA.SetDTE.Caratula value) {
            this.caratula = value;
        }

        /**
         * Gets the value of the dtes property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the dtes property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDTES().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BOLETADefType }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public List<BOLETADefType> getDTES() {
            if (dtes == null) {
                dtes = new ArrayList<BOLETADefType>();
            }
            return this.dtes;
        }

        /**
         * Obtiene el valor de la propiedad id.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
         *         &lt;element name="RutEmisor"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="RutReceptor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="NroResol"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TmstFirmaEnv" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *         &lt;element name="SubTotDTE" maxOccurs="2"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TpoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *                   &lt;element name="NroDTE" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
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
            "rutEmisor",
            "rutEnvia",
            "rutReceptor",
            "fchResol",
            "nroResol",
            "tmstFirmaEnv",
            "subTotDTEs"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class Caratula
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "RutEmisor", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String rutEmisor;
            @XmlElement(name = "RutEnvia", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String rutEnvia;
            @XmlElement(name = "RutReceptor", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String rutReceptor;
            @XmlElement(name = "FchResol", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected Date fchResol;
            @XmlElement(name = "NroResol", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger nroResol;
            @XmlElement(name = "TmstFirmaEnv", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateTimeAdapter.class)
            @XmlSchemaType(name = "dateTime")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected Date tmstFirmaEnv;
            @XmlElement(name = "SubTotDTE", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected List<EnvioBOLETA.SetDTE.Caratula.SubTotDTE> subTotDTEs;
            @XmlAttribute(name = "version", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal version;

            /**
             * Obtiene el valor de la propiedad rutEmisor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRutEmisor(String value) {
                this.rutEmisor = value;
            }

            /**
             * Obtiene el valor de la propiedad rutEnvia.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRutEnvia(String value) {
                this.rutEnvia = value;
            }

            /**
             * Obtiene el valor de la propiedad rutReceptor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRutReceptor(String value) {
                this.rutReceptor = value;
            }

            /**
             * Obtiene el valor de la propiedad fchResol.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setNroResol(BigInteger value) {
                this.nroResol = value;
            }

            /**
             * Obtiene el valor de la propiedad tmstFirmaEnv.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public Date getTmstFirmaEnv() {
                return tmstFirmaEnv;
            }

            /**
             * Define el valor de la propiedad tmstFirmaEnv.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setTmstFirmaEnv(Date value) {
                this.tmstFirmaEnv = value;
            }

            /**
             * Gets the value of the subTotDTEs property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the subTotDTEs property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getSubTotDTEs().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link EnvioBOLETA.SetDTE.Caratula.SubTotDTE }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public List<EnvioBOLETA.SetDTE.Caratula.SubTotDTE> getSubTotDTEs() {
                if (subTotDTEs == null) {
                    subTotDTEs = new ArrayList<EnvioBOLETA.SetDTE.Caratula.SubTotDTE>();
                }
                return this.subTotDTEs;
            }

            /**
             * Obtiene el valor de la propiedad version.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
             *         &lt;element name="TpoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
             *         &lt;element name="NroDTE" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
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
                "tpoDTE",
                "nroDTE"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class SubTotDTE
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TpoDTE", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger tpoDTE;
                @XmlElement(name = "NroDTE", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger nroDTE;

                /**
                 * Obtiene el valor de la propiedad tpoDTE.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getTpoDTE() {
                    return tpoDTE;
                }

                /**
                 * Define el valor de la propiedad tpoDTE.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTpoDTE(BigInteger value) {
                    this.tpoDTE = value;
                }

                /**
                 * Obtiene el valor de la propiedad nroDTE.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setNroDTE(BigInteger value) {
                    this.nroDTE = value;
                }

            }

        }

    }

}
