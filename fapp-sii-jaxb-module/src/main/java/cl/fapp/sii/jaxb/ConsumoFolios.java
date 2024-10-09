
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
 *         &lt;element name="DocumentoConsumoFolios"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Caratula"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                             &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="NroResol" type="{http://www.sii.cl/SiiDte}NroResolType"/&gt;
 *                             &lt;element name="FchInicio" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="FchFinal" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                             &lt;element name="Correlativo" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="SecEnvio"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TmstFirmaEnv" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Resumen" maxOccurs="3"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="TipoDocumento" type="{http://www.sii.cl/SiiDte}TipoConsumoType"/&gt;
 *                             &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="MntIva" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
 *                             &lt;element name="MntExento" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                             &lt;element name="FoliosEmitidos"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FoliosAnulados"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FoliosUtilizados"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RangoUtilizados" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                       &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RangoAnulados" maxOccurs="unbounded" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                       &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType" minOccurs="0"/&gt;
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
    "documentoConsumoFolios",
    "signature"
})
@XmlRootElement(name = "ConsumoFolios", namespace = "http://www.sii.cl/SiiDte")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
public class ConsumoFolios
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "DocumentoConsumoFolios", namespace = "http://www.sii.cl/SiiDte", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected ConsumoFolios.DocumentoConsumoFolios documentoConsumoFolios;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad documentoConsumoFolios.
     * 
     * @return
     *     possible object is
     *     {@link ConsumoFolios.DocumentoConsumoFolios }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public ConsumoFolios.DocumentoConsumoFolios getDocumentoConsumoFolios() {
        return documentoConsumoFolios;
    }

    /**
     * Define el valor de la propiedad documentoConsumoFolios.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumoFolios.DocumentoConsumoFolios }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public void setDocumentoConsumoFolios(ConsumoFolios.DocumentoConsumoFolios value) {
        this.documentoConsumoFolios = value;
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
     *         &lt;element name="Caratula"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                   &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="NroResol" type="{http://www.sii.cl/SiiDte}NroResolType"/&gt;
     *                   &lt;element name="FchInicio" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="FchFinal" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                   &lt;element name="Correlativo" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="SecEnvio"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TmstFirmaEnv" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" fixed="1.0" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Resumen" maxOccurs="3"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="TipoDocumento" type="{http://www.sii.cl/SiiDte}TipoConsumoType"/&gt;
     *                   &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="MntIva" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
     *                   &lt;element name="MntExento" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                   &lt;element name="FoliosEmitidos"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FoliosAnulados"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FoliosUtilizados"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RangoUtilizados" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                             &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RangoAnulados" maxOccurs="unbounded" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                             &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType" minOccurs="0"/&gt;
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
        "resumens"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
    public static class DocumentoConsumoFolios
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "Caratula", namespace = "http://www.sii.cl/SiiDte", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected ConsumoFolios.DocumentoConsumoFolios.Caratula caratula;
        @XmlElement(name = "Resumen", namespace = "http://www.sii.cl/SiiDte", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        protected List<ConsumoFolios.DocumentoConsumoFolios.Resumen> resumens;
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
         *     {@link ConsumoFolios.DocumentoConsumoFolios.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public ConsumoFolios.DocumentoConsumoFolios.Caratula getCaratula() {
            return caratula;
        }

        /**
         * Define el valor de la propiedad caratula.
         * 
         * @param value
         *     allowed object is
         *     {@link ConsumoFolios.DocumentoConsumoFolios.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public void setCaratula(ConsumoFolios.DocumentoConsumoFolios.Caratula value) {
            this.caratula = value;
        }

        /**
         * Gets the value of the resumens property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the resumens property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResumens().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ConsumoFolios.DocumentoConsumoFolios.Resumen }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public List<ConsumoFolios.DocumentoConsumoFolios.Resumen> getResumens() {
            if (resumens == null) {
                resumens = new ArrayList<ConsumoFolios.DocumentoConsumoFolios.Resumen>();
            }
            return this.resumens;
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
         *         &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="RutEnvia" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *         &lt;element name="FchResol" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="NroResol" type="{http://www.sii.cl/SiiDte}NroResolType"/&gt;
         *         &lt;element name="FchInicio" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="FchFinal" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *         &lt;element name="Correlativo" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="SecEnvio"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TmstFirmaEnv" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
            "fchResol",
            "nroResol",
            "fchInicio",
            "fchFinal",
            "correlativo",
            "secEnvio",
            "tmstFirmaEnv"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public static class Caratula
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "RutEmisor", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutEmisor;
            @XmlElement(name = "RutEnvia", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected String rutEnvia;
            @XmlElement(name = "FchResol", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date fchResol;
            @XmlElement(name = "NroResol", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger nroResol;
            @XmlElement(name = "FchInicio", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date fchInicio;
            @XmlElement(name = "FchFinal", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date fchFinal;
            @XmlElement(name = "Correlativo", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger correlativo;
            @XmlElement(name = "SecEnvio", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger secEnvio;
            @XmlElement(name = "TmstFirmaEnv", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateTimeAdapter.class)
            @XmlSchemaType(name = "dateTime")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected Date tmstFirmaEnv;
            @XmlAttribute(name = "version", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigDecimal version;

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
             * Obtiene el valor de la propiedad fchResol.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setNroResol(BigInteger value) {
                this.nroResol = value;
            }

            /**
             * Obtiene el valor de la propiedad fchInicio.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public Date getFchInicio() {
                return fchInicio;
            }

            /**
             * Define el valor de la propiedad fchInicio.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFchInicio(Date value) {
                this.fchInicio = value;
            }

            /**
             * Obtiene el valor de la propiedad fchFinal.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public Date getFchFinal() {
                return fchFinal;
            }

            /**
             * Define el valor de la propiedad fchFinal.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFchFinal(Date value) {
                this.fchFinal = value;
            }

            /**
             * Obtiene el valor de la propiedad correlativo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getCorrelativo() {
                return correlativo;
            }

            /**
             * Define el valor de la propiedad correlativo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setCorrelativo(BigInteger value) {
                this.correlativo = value;
            }

            /**
             * Obtiene el valor de la propiedad secEnvio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getSecEnvio() {
                return secEnvio;
            }

            /**
             * Define el valor de la propiedad secEnvio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setSecEnvio(BigInteger value) {
                this.secEnvio = value;
            }

            /**
             * Obtiene el valor de la propiedad tmstFirmaEnv.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setTmstFirmaEnv(Date value) {
                this.tmstFirmaEnv = value;
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
         *         &lt;element name="TipoDocumento" type="{http://www.sii.cl/SiiDte}TipoConsumoType"/&gt;
         *         &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="MntIva" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="TasaIVA" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
         *         &lt;element name="MntExento" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *         &lt;element name="FoliosEmitidos"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FoliosAnulados"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FoliosUtilizados"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RangoUtilizados" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                   &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RangoAnulados" maxOccurs="unbounded" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                   &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType" minOccurs="0"/&gt;
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
            "tipoDocumento",
            "mntNeto",
            "mntIva",
            "tasaIVA",
            "mntExento",
            "mntTotal",
            "foliosEmitidos",
            "foliosAnulados",
            "foliosUtilizados",
            "rangoUtilizados",
            "rangoAnulados"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
        public static class Resumen
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TipoDocumento", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger tipoDocumento;
            @XmlElement(name = "MntNeto", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger mntNeto;
            @XmlElement(name = "MntIva", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger mntIva;
            @XmlElement(name = "TasaIVA", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigDecimal tasaIVA;
            @XmlElement(name = "MntExento", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger mntExento;
            @XmlElement(name = "MntTotal", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger mntTotal;
            @XmlElement(name = "FoliosEmitidos", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger foliosEmitidos;
            @XmlElement(name = "FoliosAnulados", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger foliosAnulados;
            @XmlElement(name = "FoliosUtilizados", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected BigInteger foliosUtilizados;
            @XmlElement(name = "RangoUtilizados", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected List<ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoUtilizados> rangoUtilizados;
            @XmlElement(name = "RangoAnulados", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            protected List<ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoAnulados> rangoAnulados;

            /**
             * Obtiene el valor de la propiedad tipoDocumento.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getTipoDocumento() {
                return tipoDocumento;
            }

            /**
             * Define el valor de la propiedad tipoDocumento.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setTipoDocumento(BigInteger value) {
                this.tipoDocumento = value;
            }

            /**
             * Obtiene el valor de la propiedad mntNeto.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getMntNeto() {
                return mntNeto;
            }

            /**
             * Define el valor de la propiedad mntNeto.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setMntNeto(BigInteger value) {
                this.mntNeto = value;
            }

            /**
             * Obtiene el valor de la propiedad mntIva.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getMntIva() {
                return mntIva;
            }

            /**
             * Define el valor de la propiedad mntIva.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setMntIva(BigInteger value) {
                this.mntIva = value;
            }

            /**
             * Obtiene el valor de la propiedad tasaIVA.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setTasaIVA(BigDecimal value) {
                this.tasaIVA = value;
            }

            /**
             * Obtiene el valor de la propiedad mntExento.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getMntExento() {
                return mntExento;
            }

            /**
             * Define el valor de la propiedad mntExento.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setMntExento(BigInteger value) {
                this.mntExento = value;
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
             * Obtiene el valor de la propiedad foliosEmitidos.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getFoliosEmitidos() {
                return foliosEmitidos;
            }

            /**
             * Define el valor de la propiedad foliosEmitidos.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFoliosEmitidos(BigInteger value) {
                this.foliosEmitidos = value;
            }

            /**
             * Obtiene el valor de la propiedad foliosAnulados.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getFoliosAnulados() {
                return foliosAnulados;
            }

            /**
             * Define el valor de la propiedad foliosAnulados.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFoliosAnulados(BigInteger value) {
                this.foliosAnulados = value;
            }

            /**
             * Obtiene el valor de la propiedad foliosUtilizados.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public BigInteger getFoliosUtilizados() {
                return foliosUtilizados;
            }

            /**
             * Define el valor de la propiedad foliosUtilizados.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public void setFoliosUtilizados(BigInteger value) {
                this.foliosUtilizados = value;
            }

            /**
             * Gets the value of the rangoUtilizados property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the rangoUtilizados property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRangoUtilizados().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoUtilizados }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public List<ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoUtilizados> getRangoUtilizados() {
                if (rangoUtilizados == null) {
                    rangoUtilizados = new ArrayList<ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoUtilizados>();
                }
                return this.rangoUtilizados;
            }

            /**
             * Gets the value of the rangoAnulados property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the rangoAnulados property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getRangoAnulados().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoAnulados }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public List<ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoAnulados> getRangoAnulados() {
                if (rangoAnulados == null) {
                    rangoAnulados = new ArrayList<ConsumoFolios.DocumentoConsumoFolios.Resumen.RangoAnulados>();
                }
                return this.rangoAnulados;
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
             *         &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
             *         &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType" minOccurs="0"/&gt;
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
                "inicial",
                "_final"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public static class RangoAnulados
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "Inicial", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger inicial;
                @XmlElement(name = "Final", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger _final;

                /**
                 * Obtiene el valor de la propiedad inicial.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getInicial() {
                    return inicial;
                }

                /**
                 * Define el valor de la propiedad inicial.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setInicial(BigInteger value) {
                    this.inicial = value;
                }

                /**
                 * Obtiene el valor de la propiedad final.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getFinal() {
                    return _final;
                }

                /**
                 * Define el valor de la propiedad final.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setFinal(BigInteger value) {
                    this._final = value;
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
             *         &lt;element name="Inicial" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
             *         &lt;element name="Final" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
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
                "inicial",
                "_final"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
            public static class RangoUtilizados
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "Inicial", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger inicial;
                @XmlElement(name = "Final", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                protected BigInteger _final;

                /**
                 * Obtiene el valor de la propiedad inicial.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getInicial() {
                    return inicial;
                }

                /**
                 * Define el valor de la propiedad inicial.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setInicial(BigInteger value) {
                    this.inicial = value;
                }

                /**
                 * Obtiene el valor de la propiedad final.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public BigInteger getFinal() {
                    return _final;
                }

                /**
                 * Define el valor de la propiedad final.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2024-08-21T03:38:52-04:00")
                public void setFinal(BigInteger value) {
                    this._final = value;
                }

            }

        }

    }

}
