
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import cl.fapp.sii.factory.adapters.Base64Adapter;
import cl.fapp.sii.factory.adapters.DateAdapter;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
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
 *         &lt;element name="CAF"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DA"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="RS"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="40"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                             &lt;element name="RNG"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                       &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;choice&gt;
 *                               &lt;element name="RSAPK"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                         &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                               &lt;element name="DSAPK"&gt;
 *                                 &lt;complexType&gt;
 *                                   &lt;complexContent&gt;
 *                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                       &lt;sequence&gt;
 *                                         &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                         &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                         &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                       &lt;/sequence&gt;
 *                                     &lt;/restriction&gt;
 *                                   &lt;/complexContent&gt;
 *                                 &lt;/complexType&gt;
 *                               &lt;/element&gt;
 *                             &lt;/choice&gt;
 *                             &lt;element name="IDK" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="FRMA"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
 *                           &lt;attribute name="algoritmo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="SHA1withRSA" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.0" /&gt;
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
    "caf"
})
@XmlRootElement(name = "AUTORIZACION")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
public class AUTORIZACION
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "CAF", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    protected AUTORIZACION.CAF caf;

    /**
     * Obtiene el valor de la propiedad caf.
     * 
     * @return
     *     possible object is
     *     {@link AUTORIZACION.CAF }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public AUTORIZACION.CAF getCAF() {
        return caf;
    }

    /**
     * Define el valor de la propiedad caf.
     * 
     * @param value
     *     allowed object is
     *     {@link AUTORIZACION.CAF }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public void setCAF(AUTORIZACION.CAF value) {
        this.caf = value;
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
     *         &lt;element name="DA"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="RS"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="40"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                   &lt;element name="RNG"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                             &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;choice&gt;
     *                     &lt;element name="RSAPK"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                               &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                     &lt;element name="DSAPK"&gt;
     *                       &lt;complexType&gt;
     *                         &lt;complexContent&gt;
     *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                             &lt;sequence&gt;
     *                               &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                               &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                               &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                               &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                             &lt;/sequence&gt;
     *                           &lt;/restriction&gt;
     *                         &lt;/complexContent&gt;
     *                       &lt;/complexType&gt;
     *                     &lt;/element&gt;
     *                   &lt;/choice&gt;
     *                   &lt;element name="IDK" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="FRMA"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
     *                 &lt;attribute name="algoritmo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="SHA1withRSA" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.0" /&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "da",
        "frma"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public static class CAF
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "DA", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected AUTORIZACION.CAF.DA da;
        @XmlElement(name = "FRMA", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected AUTORIZACION.CAF.FRMA frma;
        @XmlAttribute(name = "version", required = true)
        @XmlSchemaType(name = "anySimpleType")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected String version;

        /**
         * Obtiene el valor de la propiedad da.
         * 
         * @return
         *     possible object is
         *     {@link AUTORIZACION.CAF.DA }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public AUTORIZACION.CAF.DA getDA() {
            return da;
        }

        /**
         * Define el valor de la propiedad da.
         * 
         * @param value
         *     allowed object is
         *     {@link AUTORIZACION.CAF.DA }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setDA(AUTORIZACION.CAF.DA value) {
            this.da = value;
        }

        /**
         * Obtiene el valor de la propiedad frma.
         * 
         * @return
         *     possible object is
         *     {@link AUTORIZACION.CAF.FRMA }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public AUTORIZACION.CAF.FRMA getFRMA() {
            return frma;
        }

        /**
         * Define el valor de la propiedad frma.
         * 
         * @param value
         *     allowed object is
         *     {@link AUTORIZACION.CAF.FRMA }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setFRMA(AUTORIZACION.CAF.FRMA value) {
            this.frma = value;
        }

        /**
         * Obtiene el valor de la propiedad version.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public String getVersion() {
            if (version == null) {
                return "1.0";
            } else {
                return version;
            }
        }

        /**
         * Define el valor de la propiedad version.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setVersion(String value) {
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
         *         &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="RS"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="40"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *         &lt;element name="RNG"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                   &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;choice&gt;
         *           &lt;element name="RSAPK"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                     &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *           &lt;element name="DSAPK"&gt;
         *             &lt;complexType&gt;
         *               &lt;complexContent&gt;
         *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                   &lt;sequence&gt;
         *                     &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                     &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                     &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                     &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                   &lt;/sequence&gt;
         *                 &lt;/restriction&gt;
         *               &lt;/complexContent&gt;
         *             &lt;/complexType&gt;
         *           &lt;/element&gt;
         *         &lt;/choice&gt;
         *         &lt;element name="IDK" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
            "re",
            "rs",
            "td",
            "rng",
            "fa",
            "dsapk",
            "rsapk",
            "idk"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public static class DA
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "RE", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected String re;
            @XmlElement(name = "RS", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected String rs;
            @XmlElement(name = "TD", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger td;
            @XmlElement(name = "RNG", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected AUTORIZACION.CAF.DA.RNG rng;
            @XmlElement(name = "FA", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected Date fa;
            @XmlElement(name = "DSAPK")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected AUTORIZACION.CAF.DA.DSAPK dsapk;
            @XmlElement(name = "RSAPK")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected AUTORIZACION.CAF.DA.RSAPK rsapk;
            @XmlElement(name = "IDK")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected long idk;

            /**
             * Obtiene el valor de la propiedad re.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public String getRE() {
                return re;
            }

            /**
             * Define el valor de la propiedad re.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setRE(String value) {
                this.re = value;
            }

            /**
             * Obtiene el valor de la propiedad rs.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public String getRS() {
                return rs;
            }

            /**
             * Define el valor de la propiedad rs.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setRS(String value) {
                this.rs = value;
            }

            /**
             * Obtiene el valor de la propiedad td.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getTD() {
                return td;
            }

            /**
             * Define el valor de la propiedad td.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setTD(BigInteger value) {
                this.td = value;
            }

            /**
             * Obtiene el valor de la propiedad rng.
             * 
             * @return
             *     possible object is
             *     {@link AUTORIZACION.CAF.DA.RNG }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public AUTORIZACION.CAF.DA.RNG getRNG() {
                return rng;
            }

            /**
             * Define el valor de la propiedad rng.
             * 
             * @param value
             *     allowed object is
             *     {@link AUTORIZACION.CAF.DA.RNG }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setRNG(AUTORIZACION.CAF.DA.RNG value) {
                this.rng = value;
            }

            /**
             * Obtiene el valor de la propiedad fa.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public Date getFA() {
                return fa;
            }

            /**
             * Define el valor de la propiedad fa.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setFA(Date value) {
                this.fa = value;
            }

            /**
             * Obtiene el valor de la propiedad dsapk.
             * 
             * @return
             *     possible object is
             *     {@link AUTORIZACION.CAF.DA.DSAPK }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public AUTORIZACION.CAF.DA.DSAPK getDSAPK() {
                return dsapk;
            }

            /**
             * Define el valor de la propiedad dsapk.
             * 
             * @param value
             *     allowed object is
             *     {@link AUTORIZACION.CAF.DA.DSAPK }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setDSAPK(AUTORIZACION.CAF.DA.DSAPK value) {
                this.dsapk = value;
            }

            /**
             * Obtiene el valor de la propiedad rsapk.
             * 
             * @return
             *     possible object is
             *     {@link AUTORIZACION.CAF.DA.RSAPK }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public AUTORIZACION.CAF.DA.RSAPK getRSAPK() {
                return rsapk;
            }

            /**
             * Define el valor de la propiedad rsapk.
             * 
             * @param value
             *     allowed object is
             *     {@link AUTORIZACION.CAF.DA.RSAPK }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setRSAPK(AUTORIZACION.CAF.DA.RSAPK value) {
                this.rsapk = value;
            }

            /**
             * Obtiene el valor de la propiedad idk.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public long getIDK() {
                return idk;
            }

            /**
             * Define el valor de la propiedad idk.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setIDK(long value) {
                this.idk = value;
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
             *         &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
             *         &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
             *         &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
             *         &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
                "p",
                "q",
                "g",
                "y"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public static class DSAPK
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "P", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected byte[] p;
                @XmlElement(name = "Q", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected byte[] q;
                @XmlElement(name = "G", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected byte[] g;
                @XmlElement(name = "Y", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected byte[] y;

                /**
                 * Obtiene el valor de la propiedad p.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public byte[] getP() {
                    return p;
                }

                /**
                 * Define el valor de la propiedad p.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setP(byte[] value) {
                    this.p = value;
                }

                /**
                 * Obtiene el valor de la propiedad q.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public byte[] getQ() {
                    return q;
                }

                /**
                 * Define el valor de la propiedad q.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setQ(byte[] value) {
                    this.q = value;
                }

                /**
                 * Obtiene el valor de la propiedad g.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public byte[] getG() {
                    return g;
                }

                /**
                 * Define el valor de la propiedad g.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setG(byte[] value) {
                    this.g = value;
                }

                /**
                 * Obtiene el valor de la propiedad y.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public byte[] getY() {
                    return y;
                }

                /**
                 * Define el valor de la propiedad y.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setY(byte[] value) {
                    this.y = value;
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
             *         &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
             *         &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
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
                "d",
                "h"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public static class RNG
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "D", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected BigInteger d;
                @XmlElement(name = "H", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected BigInteger h;

                /**
                 * Obtiene el valor de la propiedad d.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public BigInteger getD() {
                    return d;
                }

                /**
                 * Define el valor de la propiedad d.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setD(BigInteger value) {
                    this.d = value;
                }

                /**
                 * Obtiene el valor de la propiedad h.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public BigInteger getH() {
                    return h;
                }

                /**
                 * Define el valor de la propiedad h.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setH(BigInteger value) {
                    this.h = value;
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
             *         &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
             *         &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
                "m",
                "e"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public static class RSAPK
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "M", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected byte[] m;
                @XmlElement(name = "E", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                protected byte[] e;

                /**
                 * Obtiene el valor de la propiedad m.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public byte[] getM() {
                    return m;
                }

                /**
                 * Define el valor de la propiedad m.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setM(byte[] value) {
                    this.m = value;
                }

                /**
                 * Obtiene el valor de la propiedad e.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public byte[] getE() {
                    return e;
                }

                /**
                 * Define el valor de la propiedad e.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
                public void setE(byte[] value) {
                    this.e = value;
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
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
         *       &lt;attribute name="algoritmo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="SHA1withRSA" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public static class FRMA
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            private final static long serialVersionUID = -1L;
            @XmlValue
            @XmlJavaTypeAdapter(Base64Adapter.class)
            @XmlSchemaType(name = "base64Binary")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected byte[] value;
            @XmlAttribute(name = "algoritmo", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected String algoritmo;

            /**
             * Obtiene el valor de la propiedad value.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public byte[] getValue() {
                return value;
            }

            /**
             * Define el valor de la propiedad value.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setValue(byte[] value) {
                this.value = value;
            }

            /**
             * Obtiene el valor de la propiedad algoritmo.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public String getAlgoritmo() {
                if (algoritmo == null) {
                    return "SHA1withRSA";
                } else {
                    return algoritmo;
                }
            }

            /**
             * Define el valor de la propiedad algoritmo.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setAlgoritmo(String value) {
                this.algoritmo = value;
            }

        }

    }

}
