
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


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
 *         &lt;element name="IDENTIFICACION"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="RUTEMISOR"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RUTENVIA"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TRACKID" type="{}EnteroType"/&gt;
 *                   &lt;element name="TMSTRECEPCION" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ESTADISTICA" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="SUBTOTAL" maxOccurs="5"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="TIPODOC" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                             &lt;element name="INFORMADO" type="{}EnteroType"/&gt;
 *                             &lt;element name="RECHAZO" type="{}EnteroType" minOccurs="0"/&gt;
 *                             &lt;element name="REPARO" type="{}EnteroType" minOccurs="0"/&gt;
 *                             &lt;element name="ACEPTA" type="{}EnteroType" minOccurs="0"/&gt;
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
 *         &lt;element name="ERRORENVIO" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DETERRENVIO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="REVISIONENVIO" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="REVISIONDTE" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="FOLIO" type="{}EnteroType"/&gt;
 *                             &lt;element name="TIPODTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                             &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="DETALLE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
    "identificacion",
    "estadistica",
    "errorenvio",
    "revisionenvio"
})
@XmlRootElement(name = "RESULTADO_ENVIO")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
public class RESULTADOENVIO
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "IDENTIFICACION", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    protected RESULTADOENVIO.IDENTIFICACION identificacion;
    @XmlElement(name = "ESTADISTICA")
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    protected RESULTADOENVIO.ESTADISTICA estadistica;
    @XmlElement(name = "ERRORENVIO")
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    protected RESULTADOENVIO.ERRORENVIO errorenvio;
    @XmlElement(name = "REVISIONENVIO")
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    protected RESULTADOENVIO.REVISIONENVIO revisionenvio;

    /**
     * Obtiene el valor de la propiedad identificacion.
     * 
     * @return
     *     possible object is
     *     {@link RESULTADOENVIO.IDENTIFICACION }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public RESULTADOENVIO.IDENTIFICACION getIDENTIFICACION() {
        return identificacion;
    }

    /**
     * Define el valor de la propiedad identificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link RESULTADOENVIO.IDENTIFICACION }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public void setIDENTIFICACION(RESULTADOENVIO.IDENTIFICACION value) {
        this.identificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadistica.
     * 
     * @return
     *     possible object is
     *     {@link RESULTADOENVIO.ESTADISTICA }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public RESULTADOENVIO.ESTADISTICA getESTADISTICA() {
        return estadistica;
    }

    /**
     * Define el valor de la propiedad estadistica.
     * 
     * @param value
     *     allowed object is
     *     {@link RESULTADOENVIO.ESTADISTICA }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public void setESTADISTICA(RESULTADOENVIO.ESTADISTICA value) {
        this.estadistica = value;
    }

    /**
     * Obtiene el valor de la propiedad errorenvio.
     * 
     * @return
     *     possible object is
     *     {@link RESULTADOENVIO.ERRORENVIO }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public RESULTADOENVIO.ERRORENVIO getERRORENVIO() {
        return errorenvio;
    }

    /**
     * Define el valor de la propiedad errorenvio.
     * 
     * @param value
     *     allowed object is
     *     {@link RESULTADOENVIO.ERRORENVIO }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public void setERRORENVIO(RESULTADOENVIO.ERRORENVIO value) {
        this.errorenvio = value;
    }

    /**
     * Obtiene el valor de la propiedad revisionenvio.
     * 
     * @return
     *     possible object is
     *     {@link RESULTADOENVIO.REVISIONENVIO }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public RESULTADOENVIO.REVISIONENVIO getREVISIONENVIO() {
        return revisionenvio;
    }

    /**
     * Define el valor de la propiedad revisionenvio.
     * 
     * @param value
     *     allowed object is
     *     {@link RESULTADOENVIO.REVISIONENVIO }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public void setREVISIONENVIO(RESULTADOENVIO.REVISIONENVIO value) {
        this.revisionenvio = value;
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
     *         &lt;element name="DETERRENVIO" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
        "deterrenvios"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public static class ERRORENVIO
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "DETERRENVIO", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected List<String> deterrenvios;

        /**
         * Gets the value of the deterrenvios property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the deterrenvios property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDETERRENVIOS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public List<String> getDETERRENVIOS() {
            if (deterrenvios == null) {
                deterrenvios = new ArrayList<String>();
            }
            return this.deterrenvios;
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
     *         &lt;element name="SUBTOTAL" maxOccurs="5"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TIPODOC" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                   &lt;element name="INFORMADO" type="{}EnteroType"/&gt;
     *                   &lt;element name="RECHAZO" type="{}EnteroType" minOccurs="0"/&gt;
     *                   &lt;element name="REPARO" type="{}EnteroType" minOccurs="0"/&gt;
     *                   &lt;element name="ACEPTA" type="{}EnteroType" minOccurs="0"/&gt;
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
        "subtotals"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public static class ESTADISTICA
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "SUBTOTAL", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected List<RESULTADOENVIO.ESTADISTICA.SUBTOTAL> subtotals;

        /**
         * Gets the value of the subtotals property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the subtotals property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSUBTOTALS().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RESULTADOENVIO.ESTADISTICA.SUBTOTAL }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public List<RESULTADOENVIO.ESTADISTICA.SUBTOTAL> getSUBTOTALS() {
            if (subtotals == null) {
                subtotals = new ArrayList<RESULTADOENVIO.ESTADISTICA.SUBTOTAL>();
            }
            return this.subtotals;
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
         *         &lt;element name="TIPODOC" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *         &lt;element name="INFORMADO" type="{}EnteroType"/&gt;
         *         &lt;element name="RECHAZO" type="{}EnteroType" minOccurs="0"/&gt;
         *         &lt;element name="REPARO" type="{}EnteroType" minOccurs="0"/&gt;
         *         &lt;element name="ACEPTA" type="{}EnteroType" minOccurs="0"/&gt;
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
            "tipodoc",
            "informado",
            "rechazo",
            "reparo",
            "acepta"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public static class SUBTOTAL
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TIPODOC", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger tipodoc;
            @XmlElement(name = "INFORMADO", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger informado;
            @XmlElement(name = "RECHAZO")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger rechazo;
            @XmlElement(name = "REPARO")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger reparo;
            @XmlElement(name = "ACEPTA")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger acepta;

            /**
             * Obtiene el valor de la propiedad tipodoc.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getTIPODOC() {
                return tipodoc;
            }

            /**
             * Define el valor de la propiedad tipodoc.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setTIPODOC(BigInteger value) {
                this.tipodoc = value;
            }

            /**
             * Obtiene el valor de la propiedad informado.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getINFORMADO() {
                return informado;
            }

            /**
             * Define el valor de la propiedad informado.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setINFORMADO(BigInteger value) {
                this.informado = value;
            }

            /**
             * Obtiene el valor de la propiedad rechazo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getRECHAZO() {
                return rechazo;
            }

            /**
             * Define el valor de la propiedad rechazo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setRECHAZO(BigInteger value) {
                this.rechazo = value;
            }

            /**
             * Obtiene el valor de la propiedad reparo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getREPARO() {
                return reparo;
            }

            /**
             * Define el valor de la propiedad reparo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setREPARO(BigInteger value) {
                this.reparo = value;
            }

            /**
             * Obtiene el valor de la propiedad acepta.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getACEPTA() {
                return acepta;
            }

            /**
             * Define el valor de la propiedad acepta.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setACEPTA(BigInteger value) {
                this.acepta = value;
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
     *         &lt;element name="RUTEMISOR"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RUTENVIA"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.sii.cl/SiiDte}RUTType"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TRACKID" type="{}EnteroType"/&gt;
     *         &lt;element name="TMSTRECEPCION" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "rutemisor",
        "rutenvia",
        "trackid",
        "tmstrecepcion",
        "estado"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public static class IDENTIFICACION
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "RUTEMISOR", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected String rutemisor;
        @XmlElement(name = "RUTENVIA", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected String rutenvia;
        @XmlElement(name = "TRACKID", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected BigInteger trackid;
        @XmlElement(name = "TMSTRECEPCION", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected String tmstrecepcion;
        @XmlElement(name = "ESTADO", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected String estado;

        /**
         * Obtiene el valor de la propiedad rutemisor.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public String getRUTEMISOR() {
            return rutemisor;
        }

        /**
         * Define el valor de la propiedad rutemisor.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setRUTEMISOR(String value) {
            this.rutemisor = value;
        }

        /**
         * Obtiene el valor de la propiedad rutenvia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public String getRUTENVIA() {
            return rutenvia;
        }

        /**
         * Define el valor de la propiedad rutenvia.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setRUTENVIA(String value) {
            this.rutenvia = value;
        }

        /**
         * Obtiene el valor de la propiedad trackid.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public BigInteger getTRACKID() {
            return trackid;
        }

        /**
         * Define el valor de la propiedad trackid.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setTRACKID(BigInteger value) {
            this.trackid = value;
        }

        /**
         * Obtiene el valor de la propiedad tmstrecepcion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public String getTMSTRECEPCION() {
            return tmstrecepcion;
        }

        /**
         * Define el valor de la propiedad tmstrecepcion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setTMSTRECEPCION(String value) {
            this.tmstrecepcion = value;
        }

        /**
         * Obtiene el valor de la propiedad estado.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public String getESTADO() {
            return estado;
        }

        /**
         * Define el valor de la propiedad estado.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public void setESTADO(String value) {
            this.estado = value;
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
     *         &lt;element name="REVISIONDTE" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="FOLIO" type="{}EnteroType"/&gt;
     *                   &lt;element name="TIPODTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                   &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="DETALLE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
        "revisiondtes"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
    public static class REVISIONENVIO
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "REVISIONDTE", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        protected List<RESULTADOENVIO.REVISIONENVIO.REVISIONDTE> revisiondtes;

        /**
         * Gets the value of the revisiondtes property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the revisiondtes property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getREVISIONDTES().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RESULTADOENVIO.REVISIONENVIO.REVISIONDTE }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public List<RESULTADOENVIO.REVISIONENVIO.REVISIONDTE> getREVISIONDTES() {
            if (revisiondtes == null) {
                revisiondtes = new ArrayList<RESULTADOENVIO.REVISIONENVIO.REVISIONDTE>();
            }
            return this.revisiondtes;
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
         *         &lt;element name="FOLIO" type="{}EnteroType"/&gt;
         *         &lt;element name="TIPODTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *         &lt;element name="ESTADO" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="DETALLE" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
            "folio",
            "tipodte",
            "estado",
            "detalles"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
        public static class REVISIONDTE
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "FOLIO", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger folio;
            @XmlElement(name = "TIPODTE", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected BigInteger tipodte;
            @XmlElement(name = "ESTADO", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected String estado;
            @XmlElement(name = "DETALLE", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            protected List<String> detalles;

            /**
             * Obtiene el valor de la propiedad folio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getFOLIO() {
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setFOLIO(BigInteger value) {
                this.folio = value;
            }

            /**
             * Obtiene el valor de la propiedad tipodte.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public BigInteger getTIPODTE() {
                return tipodte;
            }

            /**
             * Define el valor de la propiedad tipodte.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setTIPODTE(BigInteger value) {
                this.tipodte = value;
            }

            /**
             * Obtiene el valor de la propiedad estado.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public String getESTADO() {
                return estado;
            }

            /**
             * Define el valor de la propiedad estado.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public void setESTADO(String value) {
                this.estado = value;
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
             *    getDETALLES().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-01-23T03:15:17-03:00")
            public List<String> getDETALLES() {
                if (detalles == null) {
                    detalles = new ArrayList<String>();
                }
                return this.detalles;
            }

        }

    }

}
