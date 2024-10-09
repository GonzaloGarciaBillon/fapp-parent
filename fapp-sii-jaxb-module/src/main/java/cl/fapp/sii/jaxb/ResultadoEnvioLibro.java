
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cl.fapp.sii.factory.adapters.DateTimeAdapter;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
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
 *         &lt;element name="Identificacion"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TrackId" type="{}EnteroType"/&gt;
 *                   &lt;element name="RutEmisor"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{}RUTType"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="RutEnvia"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{}RUTType"&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TmstRecepcion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                   &lt;element name="EstadoEnvio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="TipoSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="NroSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="TipoLibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="TipoOperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="PeriodoTributario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                   &lt;element name="EstadoLibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ErrorEnvioLibro" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DetErrEnvio" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
    "errorEnvioLibro"
})
@XmlRootElement(name = "ResultadoEnvioLibro")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
public class ResultadoEnvioLibro
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "Identificacion", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected ResultadoEnvioLibro.Identificacion identificacion;
    @XmlElement(name = "ErrorEnvioLibro")
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected ResultadoEnvioLibro.ErrorEnvioLibro errorEnvioLibro;

    /**
     * Obtiene el valor de la propiedad identificacion.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoEnvioLibro.Identificacion }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public ResultadoEnvioLibro.Identificacion getIdentificacion() {
        return identificacion;
    }

    /**
     * Define el valor de la propiedad identificacion.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoEnvioLibro.Identificacion }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setIdentificacion(ResultadoEnvioLibro.Identificacion value) {
        this.identificacion = value;
    }

    /**
     * Obtiene el valor de la propiedad errorEnvioLibro.
     * 
     * @return
     *     possible object is
     *     {@link ResultadoEnvioLibro.ErrorEnvioLibro }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public ResultadoEnvioLibro.ErrorEnvioLibro getErrorEnvioLibro() {
        return errorEnvioLibro;
    }

    /**
     * Define el valor de la propiedad errorEnvioLibro.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultadoEnvioLibro.ErrorEnvioLibro }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setErrorEnvioLibro(ResultadoEnvioLibro.ErrorEnvioLibro value) {
        this.errorEnvioLibro = value;
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
     *         &lt;element name="DetErrEnvio" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/&gt;
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
        "detErrEnvios"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public static class ErrorEnvioLibro
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "DetErrEnvio", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected List<String> detErrEnvios;

        /**
         * Gets the value of the detErrEnvios property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the detErrEnvios property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDetErrEnvios().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public List<String> getDetErrEnvios() {
            if (detErrEnvios == null) {
                detErrEnvios = new ArrayList<String>();
            }
            return this.detErrEnvios;
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
     *         &lt;element name="TrackId" type="{}EnteroType"/&gt;
     *         &lt;element name="RutEmisor"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{}RUTType"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="RutEnvia"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{}RUTType"&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TmstRecepcion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *         &lt;element name="EstadoEnvio" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="TipoSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="NroSegmento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="TipoLibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="TipoOperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="PeriodoTributario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
     *         &lt;element name="EstadoLibro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
        "trackId",
        "rutEmisor",
        "rutEnvia",
        "tmstRecepcion",
        "estadoEnvio",
        "tipoSegmento",
        "nroSegmento",
        "tipoLibro",
        "tipoOperacion",
        "periodoTributario",
        "estadoLibro"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public static class Identificacion
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "TrackId", required = true)
        @XmlSchemaType(name = "nonNegativeInteger")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected BigInteger trackId;
        @XmlElement(name = "RutEmisor", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String rutEmisor;
        @XmlElement(name = "RutEnvia", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String rutEnvia;
        @XmlElement(name = "TmstRecepcion", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateTimeAdapter.class)
        @XmlSchemaType(name = "dateTime")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected Date tmstRecepcion;
        @XmlElement(name = "EstadoEnvio", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String estadoEnvio;
        @XmlElement(name = "TipoSegmento")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String tipoSegmento;
        @XmlElement(name = "NroSegmento")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String nroSegmento;
        @XmlElement(name = "TipoLibro")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String tipoLibro;
        @XmlElement(name = "TipoOperacion")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String tipoOperacion;
        @XmlElement(name = "PeriodoTributario")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String periodoTributario;
        @XmlElement(name = "EstadoLibro")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected String estadoLibro;

        /**
         * Obtiene el valor de la propiedad trackId.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public BigInteger getTrackId() {
            return trackId;
        }

        /**
         * Define el valor de la propiedad trackId.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setTrackId(BigInteger value) {
            this.trackId = value;
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
         * Obtiene el valor de la propiedad rutEnvia.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setRutEnvia(String value) {
            this.rutEnvia = value;
        }

        /**
         * Obtiene el valor de la propiedad tmstRecepcion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public Date getTmstRecepcion() {
            return tmstRecepcion;
        }

        /**
         * Define el valor de la propiedad tmstRecepcion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setTmstRecepcion(Date value) {
            this.tmstRecepcion = value;
        }

        /**
         * Obtiene el valor de la propiedad estadoEnvio.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getEstadoEnvio() {
            return estadoEnvio;
        }

        /**
         * Define el valor de la propiedad estadoEnvio.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setEstadoEnvio(String value) {
            this.estadoEnvio = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoSegmento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getTipoSegmento() {
            return tipoSegmento;
        }

        /**
         * Define el valor de la propiedad tipoSegmento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setTipoSegmento(String value) {
            this.tipoSegmento = value;
        }

        /**
         * Obtiene el valor de la propiedad nroSegmento.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getNroSegmento() {
            return nroSegmento;
        }

        /**
         * Define el valor de la propiedad nroSegmento.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setNroSegmento(String value) {
            this.nroSegmento = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoLibro.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setTipoLibro(String value) {
            this.tipoLibro = value;
        }

        /**
         * Obtiene el valor de la propiedad tipoOperacion.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getTipoOperacion() {
            return tipoOperacion;
        }

        /**
         * Define el valor de la propiedad tipoOperacion.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setTipoOperacion(String value) {
            this.tipoOperacion = value;
        }

        /**
         * Obtiene el valor de la propiedad periodoTributario.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getPeriodoTributario() {
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setPeriodoTributario(String value) {
            this.periodoTributario = value;
        }

        /**
         * Obtiene el valor de la propiedad estadoLibro.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public String getEstadoLibro() {
            return estadoLibro;
        }

        /**
         * Define el valor de la propiedad estadoLibro.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setEstadoLibro(String value) {
            this.estadoLibro = value;
        }

    }

}
