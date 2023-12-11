
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import cl.fapp.sii.factory.adapters.Base64Adapter;
import jakarta.annotation.Generated;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Firma Digital con Restricciones
 * 
 * <p>Clase Java para SignatureType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SignatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SignedInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CanonicalizationMethod"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="SignatureMethod"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="Algorithm" use="required"&gt;
 *                             &lt;simpleType&gt;
 *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI"&gt;
 *                                 &lt;enumeration value="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/&gt;
 *                                 &lt;enumeration value="http://www.w3.org/2000/09/xmldsig#dsa-sha1"/&gt;
 *                               &lt;/restriction&gt;
 *                             &lt;/simpleType&gt;
 *                           &lt;/attribute&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Reference"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Transforms" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Transform"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DigestMethod"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#sha1" /&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DigestValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="URI" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="SignatureValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="KeyInfo"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="KeyValue"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;choice&gt;
 *                             &lt;element name="RSAKeyValue"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="Modulus" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                       &lt;element name="Exponent" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DSAKeyValue"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                       &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                       &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                       &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/choice&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="X509Data"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="X509Certificate" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
@XmlType(name = "SignatureType", propOrder = {
    "signedInfo",
    "signatureValue",
    "keyInfo"
})
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
public class SignatureType
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "SignedInfo", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected SignatureType.SignedInfo signedInfo;
    @XmlElement(name = "SignatureValue", required = true, type = String.class)
    @XmlJavaTypeAdapter(Base64Adapter.class)
    @XmlSchemaType(name = "base64Binary")
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected byte[] signatureValue;
    @XmlElement(name = "KeyInfo", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected SignatureType.KeyInfo keyInfo;

    /**
     * Obtiene el valor de la propiedad signedInfo.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType.SignedInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public SignatureType.SignedInfo getSignedInfo() {
        return signedInfo;
    }

    /**
     * Define el valor de la propiedad signedInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType.SignedInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setSignedInfo(SignatureType.SignedInfo value) {
        this.signedInfo = value;
    }

    /**
     * Obtiene el valor de la propiedad signatureValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public byte[] getSignatureValue() {
        return signatureValue;
    }

    /**
     * Define el valor de la propiedad signatureValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setSignatureValue(byte[] value) {
        this.signatureValue = value;
    }

    /**
     * Obtiene el valor de la propiedad keyInfo.
     * 
     * @return
     *     possible object is
     *     {@link SignatureType.KeyInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public SignatureType.KeyInfo getKeyInfo() {
        return keyInfo;
    }

    /**
     * Define el valor de la propiedad keyInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link SignatureType.KeyInfo }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setKeyInfo(SignatureType.KeyInfo value) {
        this.keyInfo = value;
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
     *         &lt;element name="KeyValue"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;choice&gt;
     *                   &lt;element name="RSAKeyValue"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Modulus" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                             &lt;element name="Exponent" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DSAKeyValue"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                             &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                             &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                             &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/choice&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="X509Data"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="X509Certificate" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
        "keyValue",
        "x509Data"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public static class KeyInfo
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "KeyValue", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected SignatureType.KeyInfo.KeyValue keyValue;
        @XmlElement(name = "X509Data", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected SignatureType.KeyInfo.X509Data x509Data;

        /**
         * Obtiene el valor de la propiedad keyValue.
         * 
         * @return
         *     possible object is
         *     {@link SignatureType.KeyInfo.KeyValue }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public SignatureType.KeyInfo.KeyValue getKeyValue() {
            return keyValue;
        }

        /**
         * Define el valor de la propiedad keyValue.
         * 
         * @param value
         *     allowed object is
         *     {@link SignatureType.KeyInfo.KeyValue }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setKeyValue(SignatureType.KeyInfo.KeyValue value) {
            this.keyValue = value;
        }

        /**
         * Obtiene el valor de la propiedad x509Data.
         * 
         * @return
         *     possible object is
         *     {@link SignatureType.KeyInfo.X509Data }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public SignatureType.KeyInfo.X509Data getX509Data() {
            return x509Data;
        }

        /**
         * Define el valor de la propiedad x509Data.
         * 
         * @param value
         *     allowed object is
         *     {@link SignatureType.KeyInfo.X509Data }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setX509Data(SignatureType.KeyInfo.X509Data value) {
            this.x509Data = value;
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
         *       &lt;choice&gt;
         *         &lt;element name="RSAKeyValue"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Modulus" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                   &lt;element name="Exponent" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DSAKeyValue"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                   &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                   &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                   &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *       &lt;/choice&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "dsaKeyValue",
            "rsaKeyValue"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class KeyValue
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "DSAKeyValue")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected SignatureType.KeyInfo.KeyValue.DSAKeyValue dsaKeyValue;
            @XmlElement(name = "RSAKeyValue")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected SignatureType.KeyInfo.KeyValue.RSAKeyValue rsaKeyValue;

            /**
             * Obtiene el valor de la propiedad dsaKeyValue.
             * 
             * @return
             *     possible object is
             *     {@link SignatureType.KeyInfo.KeyValue.DSAKeyValue }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public SignatureType.KeyInfo.KeyValue.DSAKeyValue getDSAKeyValue() {
                return dsaKeyValue;
            }

            /**
             * Define el valor de la propiedad dsaKeyValue.
             * 
             * @param value
             *     allowed object is
             *     {@link SignatureType.KeyInfo.KeyValue.DSAKeyValue }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setDSAKeyValue(SignatureType.KeyInfo.KeyValue.DSAKeyValue value) {
                this.dsaKeyValue = value;
            }

            /**
             * Obtiene el valor de la propiedad rsaKeyValue.
             * 
             * @return
             *     possible object is
             *     {@link SignatureType.KeyInfo.KeyValue.RSAKeyValue }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public SignatureType.KeyInfo.KeyValue.RSAKeyValue getRSAKeyValue() {
                return rsaKeyValue;
            }

            /**
             * Define el valor de la propiedad rsaKeyValue.
             * 
             * @param value
             *     allowed object is
             *     {@link SignatureType.KeyInfo.KeyValue.RSAKeyValue }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setRSAKeyValue(SignatureType.KeyInfo.KeyValue.RSAKeyValue value) {
                this.rsaKeyValue = value;
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class DSAKeyValue
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "P", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected byte[] p;
                @XmlElement(name = "Q", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected byte[] q;
                @XmlElement(name = "G", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected byte[] g;
                @XmlElement(name = "Y", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected byte[] y;

                /**
                 * Obtiene el valor de la propiedad p.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
             *         &lt;element name="Modulus" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
             *         &lt;element name="Exponent" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
                "modulus",
                "exponent"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class RSAKeyValue
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "Modulus", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected byte[] modulus;
                @XmlElement(name = "Exponent", required = true, type = String.class)
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected byte[] exponent;

                /**
                 * Obtiene el valor de la propiedad modulus.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public byte[] getModulus() {
                    return modulus;
                }

                /**
                 * Define el valor de la propiedad modulus.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setModulus(byte[] value) {
                    this.modulus = value;
                }

                /**
                 * Obtiene el valor de la propiedad exponent.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public byte[] getExponent() {
                    return exponent;
                }

                /**
                 * Define el valor de la propiedad exponent.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setExponent(byte[] value) {
                    this.exponent = value;
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
         *         &lt;element name="X509Certificate" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
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
            "x509Certificate"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class X509Data
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "X509Certificate", required = true, type = String.class)
            @XmlJavaTypeAdapter(Base64Adapter.class)
            @XmlSchemaType(name = "base64Binary")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected byte[] x509Certificate;

            /**
             * Obtiene el valor de la propiedad x509Certificate.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public byte[] getX509Certificate() {
                return x509Certificate;
            }

            /**
             * Define el valor de la propiedad x509Certificate.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setX509Certificate(byte[] value) {
                this.x509Certificate = value;
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
     *         &lt;element name="CanonicalizationMethod"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SignatureMethod"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="Algorithm" use="required"&gt;
     *                   &lt;simpleType&gt;
     *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI"&gt;
     *                       &lt;enumeration value="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/&gt;
     *                       &lt;enumeration value="http://www.w3.org/2000/09/xmldsig#dsa-sha1"/&gt;
     *                     &lt;/restriction&gt;
     *                   &lt;/simpleType&gt;
     *                 &lt;/attribute&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Reference"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Transforms" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="Transform"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DigestMethod"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#sha1" /&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DigestValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="URI" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
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
        "canonicalizationMethod",
        "signatureMethod",
        "reference"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public static class SignedInfo
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "CanonicalizationMethod", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected SignatureType.SignedInfo.CanonicalizationMethod canonicalizationMethod;
        @XmlElement(name = "SignatureMethod", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected SignatureType.SignedInfo.SignatureMethod signatureMethod;
        @XmlElement(name = "Reference", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected SignatureType.SignedInfo.Reference reference;

        /**
         * Obtiene el valor de la propiedad canonicalizationMethod.
         * 
         * @return
         *     possible object is
         *     {@link SignatureType.SignedInfo.CanonicalizationMethod }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public SignatureType.SignedInfo.CanonicalizationMethod getCanonicalizationMethod() {
            return canonicalizationMethod;
        }

        /**
         * Define el valor de la propiedad canonicalizationMethod.
         * 
         * @param value
         *     allowed object is
         *     {@link SignatureType.SignedInfo.CanonicalizationMethod }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setCanonicalizationMethod(SignatureType.SignedInfo.CanonicalizationMethod value) {
            this.canonicalizationMethod = value;
        }

        /**
         * Obtiene el valor de la propiedad signatureMethod.
         * 
         * @return
         *     possible object is
         *     {@link SignatureType.SignedInfo.SignatureMethod }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public SignatureType.SignedInfo.SignatureMethod getSignatureMethod() {
            return signatureMethod;
        }

        /**
         * Define el valor de la propiedad signatureMethod.
         * 
         * @param value
         *     allowed object is
         *     {@link SignatureType.SignedInfo.SignatureMethod }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setSignatureMethod(SignatureType.SignedInfo.SignatureMethod value) {
            this.signatureMethod = value;
        }

        /**
         * Obtiene el valor de la propiedad reference.
         * 
         * @return
         *     possible object is
         *     {@link SignatureType.SignedInfo.Reference }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public SignatureType.SignedInfo.Reference getReference() {
            return reference;
        }

        /**
         * Define el valor de la propiedad reference.
         * 
         * @param value
         *     allowed object is
         *     {@link SignatureType.SignedInfo.Reference }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setReference(SignatureType.SignedInfo.Reference value) {
            this.reference = value;
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
         *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/TR/2001/REC-xml-c14n-20010315" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class CanonicalizationMethod
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlAttribute(name = "Algorithm", required = true)
            @XmlSchemaType(name = "anyURI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String algorithm;

            /**
             * Obtiene el valor de la propiedad algorithm.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getAlgorithm() {
                if (algorithm == null) {
                    return "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
                } else {
                    return algorithm;
                }
            }

            /**
             * Define el valor de la propiedad algorithm.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setAlgorithm(String value) {
                this.algorithm = value;
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
         *         &lt;element name="Transforms" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="Transform"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DigestMethod"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#sha1" /&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DigestValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="URI" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "transforms",
            "digestMethod",
            "digestValue"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class Reference
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "Transforms")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected SignatureType.SignedInfo.Reference.Transforms transforms;
            @XmlElement(name = "DigestMethod", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected SignatureType.SignedInfo.Reference.DigestMethod digestMethod;
            @XmlElement(name = "DigestValue", required = true, type = String.class)
            @XmlJavaTypeAdapter(Base64Adapter.class)
            @XmlSchemaType(name = "base64Binary")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected byte[] digestValue;
            @XmlAttribute(name = "URI", required = true)
            @XmlSchemaType(name = "anyURI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String uri;

            /**
             * Obtiene el valor de la propiedad transforms.
             * 
             * @return
             *     possible object is
             *     {@link SignatureType.SignedInfo.Reference.Transforms }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public SignatureType.SignedInfo.Reference.Transforms getTransforms() {
                return transforms;
            }

            /**
             * Define el valor de la propiedad transforms.
             * 
             * @param value
             *     allowed object is
             *     {@link SignatureType.SignedInfo.Reference.Transforms }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTransforms(SignatureType.SignedInfo.Reference.Transforms value) {
                this.transforms = value;
            }

            /**
             * Obtiene el valor de la propiedad digestMethod.
             * 
             * @return
             *     possible object is
             *     {@link SignatureType.SignedInfo.Reference.DigestMethod }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public SignatureType.SignedInfo.Reference.DigestMethod getDigestMethod() {
                return digestMethod;
            }

            /**
             * Define el valor de la propiedad digestMethod.
             * 
             * @param value
             *     allowed object is
             *     {@link SignatureType.SignedInfo.Reference.DigestMethod }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setDigestMethod(SignatureType.SignedInfo.Reference.DigestMethod value) {
                this.digestMethod = value;
            }

            /**
             * Obtiene el valor de la propiedad digestValue.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public byte[] getDigestValue() {
                return digestValue;
            }

            /**
             * Define el valor de la propiedad digestValue.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setDigestValue(byte[] value) {
                this.digestValue = value;
            }

            /**
             * Obtiene el valor de la propiedad uri.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getURI() {
                return uri;
            }

            /**
             * Define el valor de la propiedad uri.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setURI(String value) {
                this.uri = value;
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
             *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" fixed="http://www.w3.org/2000/09/xmldsig#sha1" /&gt;
             *     &lt;/restriction&gt;
             *   &lt;/complexContent&gt;
             * &lt;/complexType&gt;
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class DigestMethod
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlAttribute(name = "Algorithm", required = true)
                @XmlSchemaType(name = "anyURI")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected String algorithm;

                /**
                 * Obtiene el valor de la propiedad algorithm.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public String getAlgorithm() {
                    if (algorithm == null) {
                        return "http://www.w3.org/2000/09/xmldsig#sha1";
                    } else {
                        return algorithm;
                    }
                }

                /**
                 * Define el valor de la propiedad algorithm.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setAlgorithm(String value) {
                    this.algorithm = value;
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
             *         &lt;element name="Transform"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
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
                "transform"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class Transforms
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "Transform", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected SignatureType.SignedInfo.Reference.Transforms.Transform transform;

                /**
                 * Obtiene el valor de la propiedad transform.
                 * 
                 * @return
                 *     possible object is
                 *     {@link SignatureType.SignedInfo.Reference.Transforms.Transform }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public SignatureType.SignedInfo.Reference.Transforms.Transform getTransform() {
                    return transform;
                }

                /**
                 * Define el valor de la propiedad transform.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link SignatureType.SignedInfo.Reference.Transforms.Transform }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTransform(SignatureType.SignedInfo.Reference.Transforms.Transform value) {
                    this.transform = value;
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
                 *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
                 *     &lt;/restriction&gt;
                 *   &lt;/complexContent&gt;
                 * &lt;/complexType&gt;
                 * </pre>
                 * 
                 * 
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class Transform
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlAttribute(name = "Algorithm", required = true)
                    @XmlSchemaType(name = "anyURI")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected String algorithm;

                    /**
                     * Obtiene el valor de la propiedad algorithm.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public String getAlgorithm() {
                        return algorithm;
                    }

                    /**
                     * Define el valor de la propiedad algorithm.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setAlgorithm(String value) {
                        this.algorithm = value;
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
         *       &lt;attribute name="Algorithm" use="required"&gt;
         *         &lt;simpleType&gt;
         *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyURI"&gt;
         *             &lt;enumeration value="http://www.w3.org/2000/09/xmldsig#rsa-sha1"/&gt;
         *             &lt;enumeration value="http://www.w3.org/2000/09/xmldsig#dsa-sha1"/&gt;
         *           &lt;/restriction&gt;
         *         &lt;/simpleType&gt;
         *       &lt;/attribute&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class SignatureMethod
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlAttribute(name = "Algorithm", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String algorithm;

            /**
             * Obtiene el valor de la propiedad algorithm.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getAlgorithm() {
                return algorithm;
            }

            /**
             * Define el valor de la propiedad algorithm.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setAlgorithm(String value) {
                this.algorithm = value;
            }

        }

    }

}
