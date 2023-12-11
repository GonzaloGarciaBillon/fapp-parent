
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
 *                             &lt;element name="TipoOperacion"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="COMPRA"/&gt;
 *                                   &lt;enumeration value="VENTA"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TipoLibro"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="MENSUAL"/&gt;
 *                                   &lt;enumeration value="ESPECIAL"/&gt;
 *                                   &lt;enumeration value="RECTIFICA"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TipoEnvio"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;minLength value="5"/&gt;
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
 *                             &lt;element name="FolioNotificacion" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CodAutRec" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="10"/&gt;
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
 *                             &lt;element name="TotalesSegmento" maxOccurs="40"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
 *                                       &lt;element name="TpoImp" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="1"/&gt;
 *                                             &lt;enumeration value="1"/&gt;
 *                                             &lt;enumeration value="2"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotDoc"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotAnulado" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotOpExe" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotOpIVARec" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="CodIVANoRec"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                                       &lt;totalDigits value="1"/&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                       &lt;enumeration value="2"/&gt;
 *                                                       &lt;enumeration value="3"/&gt;
 *                                                       &lt;enumeration value="4"/&gt;
 *                                                       &lt;enumeration value="9"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                                       &lt;totalDigits value="10"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
 *                                                 &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
 *                             &lt;element name="TotalesPeriodo" maxOccurs="40"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
 *                                       &lt;element name="TpoImp" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="1"/&gt;
 *                                             &lt;enumeration value="1"/&gt;
 *                                             &lt;enumeration value="2"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotDoc"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotAnulado" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotOpExe" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotOpIVARec" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="CodIVANoRec"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                                       &lt;enumeration value="1"/&gt;
 *                                                       &lt;enumeration value="2"/&gt;
 *                                                       &lt;enumeration value="3"/&gt;
 *                                                       &lt;enumeration value="4"/&gt;
 *                                                       &lt;enumeration value="9"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                                       &lt;totalDigits value="10"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="FctProp" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                             &lt;fractionDigits value="3"/&gt;
 *                                             &lt;totalDigits value="5"/&gt;
 *                                             &lt;maxInclusive value="99.999"/&gt;
 *                                             &lt;minInclusive value="00.001"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotCredIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
 *                                                 &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                                 &lt;element name="FctImpAdic" minOccurs="0"&gt;
 *                                                   &lt;simpleType&gt;
 *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
 *                                                       &lt;totalDigits value="6"/&gt;
 *                                                       &lt;fractionDigits value="4"/&gt;
 *                                                       &lt;maxInclusive value="1.000"/&gt;
 *                                                       &lt;minInclusive value="0.001"/&gt;
 *                                                     &lt;/restriction&gt;
 *                                                   &lt;/simpleType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="TotCredImp" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                                 &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                       &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
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
 *                             &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
 *                             &lt;element name="Emisor" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="1"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IndFactCompra" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="1"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="NroDoc"&gt;
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
 *                             &lt;element name="Operacion" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TpoImp" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="1"/&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
 *                             &lt;element name="NumInt" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IndServicio" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IndSinCosto" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FchDoc" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
 *                                   &lt;minInclusive value="2000-01-01"/&gt;
 *                                   &lt;maxInclusive value="2050-12-31"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CdgSIISucur" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="9"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RUTDoc" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
 *                             &lt;element name="RznSoc" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="50"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Extranjero" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="NumId" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="Nacionalidad" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;minLength value="1"/&gt;
 *                                             &lt;maxLength value="3"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TpoDocRef" type="{http://www.sii.cl/SiiDte}DoctoType" minOccurs="0"/&gt;
 *                             &lt;element name="FolioDocRef" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;totalDigits value="10"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="MntIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="MntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="MntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="IVANoRec" maxOccurs="5" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="CodIVANoRec"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;enumeration value="1"/&gt;
 *                                             &lt;enumeration value="2"/&gt;
 *                                             &lt;enumeration value="3"/&gt;
 *                                             &lt;enumeration value="4"/&gt;
 *                                             &lt;enumeration value="9"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="MntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="IVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="IVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="IVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="Ley18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="OtrosImp" maxOccurs="20" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
 *                                       &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
 *                                       &lt;element name="MntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MntSinCred" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="IVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="IVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="CredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="DepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="Liquidaciones" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                       &lt;element name="ValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="ValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="ValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="IVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="MntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="MntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                             &lt;element name="PsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="PsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="TabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="TabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="TabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                             &lt;element name="ImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;choice minOccurs="0"&gt;
 *                     &lt;element ref="{http://www.sii.cl/SiiLce}LceCal"/&gt;
 *                     &lt;element ref="{http://www.sii.cl/SiiLce}LceCoCertif"/&gt;
 *                   &lt;/choice&gt;
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
    "envioLibro",
    "signature"
})
@XmlRootElement(name = "LibroCompraVenta", namespace = "http://www.sii.cl/SiiDte")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
public class LibroCompraVenta
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "EnvioLibro", namespace = "http://www.sii.cl/SiiDte", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected LibroCompraVenta.EnvioLibro envioLibro;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad envioLibro.
     * 
     * @return
     *     possible object is
     *     {@link LibroCompraVenta.EnvioLibro }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public LibroCompraVenta.EnvioLibro getEnvioLibro() {
        return envioLibro;
    }

    /**
     * Define el valor de la propiedad envioLibro.
     * 
     * @param value
     *     allowed object is
     *     {@link LibroCompraVenta.EnvioLibro }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public void setEnvioLibro(LibroCompraVenta.EnvioLibro value) {
        this.envioLibro = value;
    }

    /**
     * Firma Digital sobre SetDTE
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
     *                   &lt;element name="TipoOperacion"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="COMPRA"/&gt;
     *                         &lt;enumeration value="VENTA"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TipoLibro"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="MENSUAL"/&gt;
     *                         &lt;enumeration value="ESPECIAL"/&gt;
     *                         &lt;enumeration value="RECTIFICA"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TipoEnvio"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;minLength value="5"/&gt;
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
     *                   &lt;element name="FolioNotificacion" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CodAutRec" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="10"/&gt;
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
     *                   &lt;element name="TotalesSegmento" maxOccurs="40"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
     *                             &lt;element name="TpoImp" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="1"/&gt;
     *                                   &lt;enumeration value="1"/&gt;
     *                                   &lt;enumeration value="2"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotDoc"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotAnulado" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotOpExe" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotOpIVARec" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="CodIVANoRec"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                             &lt;totalDigits value="1"/&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                             &lt;enumeration value="2"/&gt;
     *                                             &lt;enumeration value="3"/&gt;
     *                                             &lt;enumeration value="4"/&gt;
     *                                             &lt;enumeration value="9"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                             &lt;totalDigits value="10"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
     *                                       &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
     *                   &lt;element name="TotalesPeriodo" maxOccurs="40"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
     *                             &lt;element name="TpoImp" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="1"/&gt;
     *                                   &lt;enumeration value="1"/&gt;
     *                                   &lt;enumeration value="2"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotDoc"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotAnulado" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotOpExe" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotOpIVARec" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="CodIVANoRec"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                             &lt;enumeration value="1"/&gt;
     *                                             &lt;enumeration value="2"/&gt;
     *                                             &lt;enumeration value="3"/&gt;
     *                                             &lt;enumeration value="4"/&gt;
     *                                             &lt;enumeration value="9"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                             &lt;totalDigits value="10"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="FctProp" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                   &lt;fractionDigits value="3"/&gt;
     *                                   &lt;totalDigits value="5"/&gt;
     *                                   &lt;maxInclusive value="99.999"/&gt;
     *                                   &lt;minInclusive value="00.001"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotCredIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
     *                                       &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                                       &lt;element name="FctImpAdic" minOccurs="0"&gt;
     *                                         &lt;simpleType&gt;
     *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
     *                                             &lt;totalDigits value="6"/&gt;
     *                                             &lt;fractionDigits value="4"/&gt;
     *                                             &lt;maxInclusive value="1.000"/&gt;
     *                                             &lt;minInclusive value="0.001"/&gt;
     *                                           &lt;/restriction&gt;
     *                                         &lt;/simpleType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="TotCredImp" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                       &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                             &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="TotImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
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
     *                   &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
     *                   &lt;element name="Emisor" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="1"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IndFactCompra" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="1"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="NroDoc"&gt;
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
     *                   &lt;element name="Operacion" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TpoImp" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="1"/&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
     *                   &lt;element name="NumInt" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IndServicio" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IndSinCosto" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FchDoc" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
     *                         &lt;minInclusive value="2000-01-01"/&gt;
     *                         &lt;maxInclusive value="2050-12-31"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CdgSIISucur" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="9"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RUTDoc" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
     *                   &lt;element name="RznSoc" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="50"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Extranjero" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="NumId" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="Nacionalidad" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;minLength value="1"/&gt;
     *                                   &lt;maxLength value="3"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TpoDocRef" type="{http://www.sii.cl/SiiDte}DoctoType" minOccurs="0"/&gt;
     *                   &lt;element name="FolioDocRef" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;totalDigits value="10"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="MntIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="MntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="MntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="IVANoRec" maxOccurs="5" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="CodIVANoRec"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;enumeration value="1"/&gt;
     *                                   &lt;enumeration value="2"/&gt;
     *                                   &lt;enumeration value="3"/&gt;
     *                                   &lt;enumeration value="4"/&gt;
     *                                   &lt;enumeration value="9"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="MntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="IVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="IVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="IVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="Ley18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="OtrosImp" maxOccurs="20" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
     *                             &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
     *                             &lt;element name="MntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MntSinCred" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="IVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="IVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="CredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="DepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="Liquidaciones" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                             &lt;element name="ValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="ValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="ValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="IVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="MntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="MntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                   &lt;element name="PsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="PsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="TabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="TabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="TabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                   &lt;element name="ImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;choice minOccurs="0"&gt;
     *           &lt;element ref="{http://www.sii.cl/SiiLce}LceCal"/&gt;
     *           &lt;element ref="{http://www.sii.cl/SiiLce}LceCoCertif"/&gt;
     *         &lt;/choice&gt;
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
        "lceCoCertif",
        "lceCal",
        "tmstFirma"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
    public static class EnvioLibro
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "Caratula", namespace = "http://www.sii.cl/SiiDte", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LibroCompraVenta.EnvioLibro.Caratula caratula;
        @XmlElement(name = "ResumenSegmento", namespace = "http://www.sii.cl/SiiDte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LibroCompraVenta.EnvioLibro.ResumenSegmento resumenSegmento;
        @XmlElement(name = "ResumenPeriodo", namespace = "http://www.sii.cl/SiiDte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LibroCompraVenta.EnvioLibro.ResumenPeriodo resumenPeriodo;
        @XmlElement(name = "Detalle", namespace = "http://www.sii.cl/SiiDte")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected List<LibroCompraVenta.EnvioLibro.Detalle> detalles;
        @XmlElement(name = "LceCoCertif", namespace = "http://www.sii.cl/SiiLce")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LceCoCertif lceCoCertif;
        @XmlElement(name = "LceCal", namespace = "http://www.sii.cl/SiiLce")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        protected LceCal lceCal;
        @XmlElement(name = "TmstFirma", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
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
         *     {@link LibroCompraVenta.EnvioLibro.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LibroCompraVenta.EnvioLibro.Caratula getCaratula() {
            return caratula;
        }

        /**
         * Define el valor de la propiedad caratula.
         * 
         * @param value
         *     allowed object is
         *     {@link LibroCompraVenta.EnvioLibro.Caratula }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setCaratula(LibroCompraVenta.EnvioLibro.Caratula value) {
            this.caratula = value;
        }

        /**
         * Obtiene el valor de la propiedad resumenSegmento.
         * 
         * @return
         *     possible object is
         *     {@link LibroCompraVenta.EnvioLibro.ResumenSegmento }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LibroCompraVenta.EnvioLibro.ResumenSegmento getResumenSegmento() {
            return resumenSegmento;
        }

        /**
         * Define el valor de la propiedad resumenSegmento.
         * 
         * @param value
         *     allowed object is
         *     {@link LibroCompraVenta.EnvioLibro.ResumenSegmento }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setResumenSegmento(LibroCompraVenta.EnvioLibro.ResumenSegmento value) {
            this.resumenSegmento = value;
        }

        /**
         * Obtiene el valor de la propiedad resumenPeriodo.
         * 
         * @return
         *     possible object is
         *     {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LibroCompraVenta.EnvioLibro.ResumenPeriodo getResumenPeriodo() {
            return resumenPeriodo;
        }

        /**
         * Define el valor de la propiedad resumenPeriodo.
         * 
         * @param value
         *     allowed object is
         *     {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setResumenPeriodo(LibroCompraVenta.EnvioLibro.ResumenPeriodo value) {
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
         * {@link LibroCompraVenta.EnvioLibro.Detalle }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public List<LibroCompraVenta.EnvioLibro.Detalle> getDetalles() {
            if (detalles == null) {
                detalles = new ArrayList<LibroCompraVenta.EnvioLibro.Detalle>();
            }
            return this.detalles;
        }

        /**
         * Obtiene el valor de la propiedad lceCoCertif.
         * 
         * @return
         *     possible object is
         *     {@link LceCoCertif }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public LceCoCertif getLceCoCertif() {
            return lceCoCertif;
        }

        /**
         * Define el valor de la propiedad lceCoCertif.
         * 
         * @param value
         *     allowed object is
         *     {@link LceCoCertif }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setLceCoCertif(LceCoCertif value) {
            this.lceCoCertif = value;
        }

        /**
         * Obtiene el valor de la propiedad lceCal.
         * 
         * @return
         *     possible object is
         *     {@link LceCal }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public void setLceCal(LceCal value) {
            this.lceCal = value;
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
         *         &lt;element name="TipoOperacion"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="COMPRA"/&gt;
         *               &lt;enumeration value="VENTA"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TipoLibro"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="MENSUAL"/&gt;
         *               &lt;enumeration value="ESPECIAL"/&gt;
         *               &lt;enumeration value="RECTIFICA"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TipoEnvio"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;minLength value="5"/&gt;
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
         *         &lt;element name="FolioNotificacion" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CodAutRec" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="10"/&gt;
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
            "tipoOperacion",
            "tipoLibro",
            "tipoEnvio",
            "nroSegmento",
            "folioNotificacion",
            "codAutRec"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class Caratula
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "RutEmisorLibro", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rutEmisorLibro;
            @XmlElement(name = "RutEnvia", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rutEnvia;
            @XmlElement(name = "PeriodoTributario", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(GYearMonthAdapter.class)
            @XmlSchemaType(name = "gYearMonth")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date periodoTributario;
            @XmlElement(name = "FchResol", namespace = "http://www.sii.cl/SiiDte", required = true, type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @XmlSchemaType(name = "date")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date fchResol;
            @XmlElement(name = "NroResol", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger nroResol;
            @XmlElement(name = "TipoOperacion", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String tipoOperacion;
            @XmlElement(name = "TipoLibro", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String tipoLibro;
            @XmlElement(name = "TipoEnvio", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String tipoEnvio;
            @XmlElement(name = "NroSegmento", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger nroSegmento;
            @XmlElement(name = "FolioNotificacion", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger folioNotificacion;
            @XmlElement(name = "CodAutRec", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String codAutRec;

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
             * Obtiene el valor de la propiedad tipoOperacion.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTipoOperacion(String value) {
                this.tipoOperacion = value;
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

            /**
             * Obtiene el valor de la propiedad codAutRec.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getCodAutRec() {
                return codAutRec;
            }

            /**
             * Define el valor de la propiedad codAutRec.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setCodAutRec(String value) {
                this.codAutRec = value;
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
         *         &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
         *         &lt;element name="Emisor" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="1"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IndFactCompra" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="1"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="NroDoc"&gt;
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
         *         &lt;element name="Operacion" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TpoImp" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="1"/&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
         *         &lt;element name="NumInt" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IndServicio" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IndSinCosto" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;enumeration value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FchDoc" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}date"&gt;
         *               &lt;minInclusive value="2000-01-01"/&gt;
         *               &lt;maxInclusive value="2050-12-31"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CdgSIISucur" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="9"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RUTDoc" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
         *         &lt;element name="RznSoc" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="50"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Extranjero" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="NumId" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="Nacionalidad" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;minLength value="1"/&gt;
         *                         &lt;maxLength value="3"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TpoDocRef" type="{http://www.sii.cl/SiiDte}DoctoType" minOccurs="0"/&gt;
         *         &lt;element name="FolioDocRef" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;totalDigits value="10"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="MntIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="MntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="MntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="IVANoRec" maxOccurs="5" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="CodIVANoRec"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                         &lt;enumeration value="3"/&gt;
         *                         &lt;enumeration value="4"/&gt;
         *                         &lt;enumeration value="9"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="MntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="IVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="IVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="IVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="Ley18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="OtrosImp" maxOccurs="20" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
         *                   &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
         *                   &lt;element name="MntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MntSinCred" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="IVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="IVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="CredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="DepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="Liquidaciones" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="ValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="ValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="ValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="IVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="MntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="MntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *         &lt;element name="PsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="PsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="TabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="TabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="TabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *         &lt;element name="ImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
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
            "emisor",
            "indFactCompra",
            "nroDoc",
            "anulado",
            "operacion",
            "tpoImp",
            "tasaImp",
            "numInt",
            "indServicio",
            "indSinCosto",
            "fchDoc",
            "cdgSIISucur",
            "rutDoc",
            "rznSoc",
            "extranjero",
            "tpoDocRef",
            "folioDocRef",
            "mntExe",
            "mntNeto",
            "mntIVA",
            "mntActivoFijo",
            "mntIVAActivoFijo",
            "ivaNoRecs",
            "ivaUsoComun",
            "ivaFueraPlazo",
            "ivaPropio",
            "ivaTerceros",
            "ley18211",
            "otrosImps",
            "mntSinCred",
            "ivaRetTotal",
            "ivaRetParcial",
            "credEC",
            "depEnvase",
            "liquidaciones",
            "mntTotal",
            "ivaNoRetenido",
            "mntNoFact",
            "mntPeriodo",
            "psjNac",
            "psjInt",
            "tabPuros",
            "tabCigarrillos",
            "tabElaborado",
            "impVehiculo"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
        public static class Detalle
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "TpoDoc", namespace = "http://www.sii.cl/SiiDte", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tpoDoc;
            @XmlElement(name = "Emisor", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger emisor;
            @XmlElement(name = "IndFactCompra", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger indFactCompra;
            @XmlElement(name = "NroDoc", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger nroDoc;
            @XmlElement(name = "Anulado", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String anulado;
            @XmlElement(name = "Operacion", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger operacion;
            @XmlElement(name = "TpoImp", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tpoImp;
            @XmlElement(name = "TasaImp", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigDecimal tasaImp;
            @XmlElement(name = "NumInt", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String numInt;
            @XmlElement(name = "IndServicio", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger indServicio;
            @XmlElement(name = "IndSinCosto", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger indSinCosto;
            @XmlElement(name = "FchDoc", namespace = "http://www.sii.cl/SiiDte", type = String.class)
            @XmlJavaTypeAdapter(DateAdapter.class)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected Date fchDoc;
            @XmlElement(name = "CdgSIISucur", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger cdgSIISucur;
            @XmlElement(name = "RUTDoc", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rutDoc;
            @XmlElement(name = "RznSoc", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected String rznSoc;
            @XmlElement(name = "Extranjero", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected LibroCompraVenta.EnvioLibro.Detalle.Extranjero extranjero;
            @XmlElement(name = "TpoDocRef", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tpoDocRef;
            @XmlElement(name = "FolioDocRef", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger folioDocRef;
            @XmlElement(name = "MntExe", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntExe;
            @XmlElement(name = "MntNeto", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntNeto;
            @XmlElement(name = "MntIVA", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntIVA;
            @XmlElement(name = "MntActivoFijo", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntActivoFijo;
            @XmlElement(name = "MntIVAActivoFijo", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntIVAActivoFijo;
            @XmlElement(name = "IVANoRec", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected List<LibroCompraVenta.EnvioLibro.Detalle.IVANoRec> ivaNoRecs;
            @XmlElement(name = "IVAUsoComun", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaUsoComun;
            @XmlElement(name = "IVAFueraPlazo", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaFueraPlazo;
            @XmlElement(name = "IVAPropio", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaPropio;
            @XmlElement(name = "IVATerceros", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaTerceros;
            @XmlElement(name = "Ley18211", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ley18211;
            @XmlElement(name = "OtrosImp", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected List<LibroCompraVenta.EnvioLibro.Detalle.OtrosImp> otrosImps;
            @XmlElement(name = "MntSinCred", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntSinCred;
            @XmlElement(name = "IVARetTotal", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaRetTotal;
            @XmlElement(name = "IVARetParcial", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaRetParcial;
            @XmlElement(name = "CredEC", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger credEC;
            @XmlElement(name = "DepEnvase", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger depEnvase;
            @XmlElement(name = "Liquidaciones", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected LibroCompraVenta.EnvioLibro.Detalle.Liquidaciones liquidaciones;
            @XmlElement(name = "MntTotal", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntTotal;
            @XmlElement(name = "IVANoRetenido", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger ivaNoRetenido;
            @XmlElement(name = "MntNoFact", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntNoFact;
            @XmlElement(name = "MntPeriodo", namespace = "http://www.sii.cl/SiiDte")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger mntPeriodo;
            @XmlElement(name = "PsjNac", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger psjNac;
            @XmlElement(name = "PsjInt", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger psjInt;
            @XmlElement(name = "TabPuros", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tabPuros;
            @XmlElement(name = "TabCigarrillos", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tabCigarrillos;
            @XmlElement(name = "TabElaborado", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger tabElaborado;
            @XmlElement(name = "ImpVehiculo", namespace = "http://www.sii.cl/SiiDte")
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected BigInteger impVehiculo;

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
             * Obtiene el valor de la propiedad emisor.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getEmisor() {
                return emisor;
            }

            /**
             * Define el valor de la propiedad emisor.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setEmisor(BigInteger value) {
                this.emisor = value;
            }

            /**
             * Obtiene el valor de la propiedad indFactCompra.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIndFactCompra() {
                return indFactCompra;
            }

            /**
             * Define el valor de la propiedad indFactCompra.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIndFactCompra(BigInteger value) {
                this.indFactCompra = value;
            }

            /**
             * Obtiene el valor de la propiedad nroDoc.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getNroDoc() {
                return nroDoc;
            }

            /**
             * Define el valor de la propiedad nroDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setNroDoc(BigInteger value) {
                this.nroDoc = value;
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
             * Obtiene el valor de la propiedad operacion.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getOperacion() {
                return operacion;
            }

            /**
             * Define el valor de la propiedad operacion.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setOperacion(BigInteger value) {
                this.operacion = value;
            }

            /**
             * Obtiene el valor de la propiedad tpoImp.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTpoImp() {
                return tpoImp;
            }

            /**
             * Define el valor de la propiedad tpoImp.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTpoImp(BigInteger value) {
                this.tpoImp = value;
            }

            /**
             * Obtiene el valor de la propiedad tasaImp.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigDecimal getTasaImp() {
                return tasaImp;
            }

            /**
             * Define el valor de la propiedad tasaImp.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTasaImp(BigDecimal value) {
                this.tasaImp = value;
            }

            /**
             * Obtiene el valor de la propiedad numInt.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getNumInt() {
                return numInt;
            }

            /**
             * Define el valor de la propiedad numInt.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setNumInt(String value) {
                this.numInt = value;
            }

            /**
             * Obtiene el valor de la propiedad indServicio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIndServicio() {
                return indServicio;
            }

            /**
             * Define el valor de la propiedad indServicio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIndServicio(BigInteger value) {
                this.indServicio = value;
            }

            /**
             * Obtiene el valor de la propiedad indSinCosto.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIndSinCosto() {
                return indSinCosto;
            }

            /**
             * Define el valor de la propiedad indSinCosto.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIndSinCosto(BigInteger value) {
                this.indSinCosto = value;
            }

            /**
             * Obtiene el valor de la propiedad fchDoc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public Date getFchDoc() {
                return fchDoc;
            }

            /**
             * Define el valor de la propiedad fchDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFchDoc(Date value) {
                this.fchDoc = value;
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
             * Obtiene el valor de la propiedad rutDoc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getRUTDoc() {
                return rutDoc;
            }

            /**
             * Define el valor de la propiedad rutDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setRUTDoc(String value) {
                this.rutDoc = value;
            }

            /**
             * Obtiene el valor de la propiedad rznSoc.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public String getRznSoc() {
                return rznSoc;
            }

            /**
             * Define el valor de la propiedad rznSoc.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setRznSoc(String value) {
                this.rznSoc = value;
            }

            /**
             * Obtiene el valor de la propiedad extranjero.
             * 
             * @return
             *     possible object is
             *     {@link LibroCompraVenta.EnvioLibro.Detalle.Extranjero }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public LibroCompraVenta.EnvioLibro.Detalle.Extranjero getExtranjero() {
                return extranjero;
            }

            /**
             * Define el valor de la propiedad extranjero.
             * 
             * @param value
             *     allowed object is
             *     {@link LibroCompraVenta.EnvioLibro.Detalle.Extranjero }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setExtranjero(LibroCompraVenta.EnvioLibro.Detalle.Extranjero value) {
                this.extranjero = value;
            }

            /**
             * Obtiene el valor de la propiedad tpoDocRef.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTpoDocRef() {
                return tpoDocRef;
            }

            /**
             * Define el valor de la propiedad tpoDocRef.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTpoDocRef(BigInteger value) {
                this.tpoDocRef = value;
            }

            /**
             * Obtiene el valor de la propiedad folioDocRef.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getFolioDocRef() {
                return folioDocRef;
            }

            /**
             * Define el valor de la propiedad folioDocRef.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setFolioDocRef(BigInteger value) {
                this.folioDocRef = value;
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
             * Obtiene el valor de la propiedad mntNeto.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntNeto(BigInteger value) {
                this.mntNeto = value;
            }

            /**
             * Obtiene el valor de la propiedad mntIVA.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntIVA() {
                return mntIVA;
            }

            /**
             * Define el valor de la propiedad mntIVA.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntIVA(BigInteger value) {
                this.mntIVA = value;
            }

            /**
             * Obtiene el valor de la propiedad mntActivoFijo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntActivoFijo() {
                return mntActivoFijo;
            }

            /**
             * Define el valor de la propiedad mntActivoFijo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntActivoFijo(BigInteger value) {
                this.mntActivoFijo = value;
            }

            /**
             * Obtiene el valor de la propiedad mntIVAActivoFijo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntIVAActivoFijo() {
                return mntIVAActivoFijo;
            }

            /**
             * Define el valor de la propiedad mntIVAActivoFijo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntIVAActivoFijo(BigInteger value) {
                this.mntIVAActivoFijo = value;
            }

            /**
             * Gets the value of the ivaNoRecs property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the ivaNoRecs property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getIVANoRecs().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LibroCompraVenta.EnvioLibro.Detalle.IVANoRec }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public List<LibroCompraVenta.EnvioLibro.Detalle.IVANoRec> getIVANoRecs() {
                if (ivaNoRecs == null) {
                    ivaNoRecs = new ArrayList<LibroCompraVenta.EnvioLibro.Detalle.IVANoRec>();
                }
                return this.ivaNoRecs;
            }

            /**
             * Obtiene el valor de la propiedad ivaUsoComun.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVAUsoComun() {
                return ivaUsoComun;
            }

            /**
             * Define el valor de la propiedad ivaUsoComun.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVAUsoComun(BigInteger value) {
                this.ivaUsoComun = value;
            }

            /**
             * Obtiene el valor de la propiedad ivaFueraPlazo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVAFueraPlazo() {
                return ivaFueraPlazo;
            }

            /**
             * Define el valor de la propiedad ivaFueraPlazo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVAFueraPlazo(BigInteger value) {
                this.ivaFueraPlazo = value;
            }

            /**
             * Obtiene el valor de la propiedad ivaPropio.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVAPropio() {
                return ivaPropio;
            }

            /**
             * Define el valor de la propiedad ivaPropio.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVAPropio(BigInteger value) {
                this.ivaPropio = value;
            }

            /**
             * Obtiene el valor de la propiedad ivaTerceros.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVATerceros() {
                return ivaTerceros;
            }

            /**
             * Define el valor de la propiedad ivaTerceros.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVATerceros(BigInteger value) {
                this.ivaTerceros = value;
            }

            /**
             * Obtiene el valor de la propiedad ley18211.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getLey18211() {
                return ley18211;
            }

            /**
             * Define el valor de la propiedad ley18211.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setLey18211(BigInteger value) {
                this.ley18211 = value;
            }

            /**
             * Gets the value of the otrosImps property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the otrosImps property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getOtrosImps().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link LibroCompraVenta.EnvioLibro.Detalle.OtrosImp }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public List<LibroCompraVenta.EnvioLibro.Detalle.OtrosImp> getOtrosImps() {
                if (otrosImps == null) {
                    otrosImps = new ArrayList<LibroCompraVenta.EnvioLibro.Detalle.OtrosImp>();
                }
                return this.otrosImps;
            }

            /**
             * Obtiene el valor de la propiedad mntSinCred.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getMntSinCred() {
                return mntSinCred;
            }

            /**
             * Define el valor de la propiedad mntSinCred.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setMntSinCred(BigInteger value) {
                this.mntSinCred = value;
            }

            /**
             * Obtiene el valor de la propiedad ivaRetTotal.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVARetTotal() {
                return ivaRetTotal;
            }

            /**
             * Define el valor de la propiedad ivaRetTotal.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVARetTotal(BigInteger value) {
                this.ivaRetTotal = value;
            }

            /**
             * Obtiene el valor de la propiedad ivaRetParcial.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVARetParcial() {
                return ivaRetParcial;
            }

            /**
             * Define el valor de la propiedad ivaRetParcial.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVARetParcial(BigInteger value) {
                this.ivaRetParcial = value;
            }

            /**
             * Obtiene el valor de la propiedad credEC.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getCredEC() {
                return credEC;
            }

            /**
             * Define el valor de la propiedad credEC.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setCredEC(BigInteger value) {
                this.credEC = value;
            }

            /**
             * Obtiene el valor de la propiedad depEnvase.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getDepEnvase() {
                return depEnvase;
            }

            /**
             * Define el valor de la propiedad depEnvase.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setDepEnvase(BigInteger value) {
                this.depEnvase = value;
            }

            /**
             * Obtiene el valor de la propiedad liquidaciones.
             * 
             * @return
             *     possible object is
             *     {@link LibroCompraVenta.EnvioLibro.Detalle.Liquidaciones }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public LibroCompraVenta.EnvioLibro.Detalle.Liquidaciones getLiquidaciones() {
                return liquidaciones;
            }

            /**
             * Define el valor de la propiedad liquidaciones.
             * 
             * @param value
             *     allowed object is
             *     {@link LibroCompraVenta.EnvioLibro.Detalle.Liquidaciones }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setLiquidaciones(LibroCompraVenta.EnvioLibro.Detalle.Liquidaciones value) {
                this.liquidaciones = value;
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
             * Obtiene el valor de la propiedad ivaNoRetenido.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getIVANoRetenido() {
                return ivaNoRetenido;
            }

            /**
             * Define el valor de la propiedad ivaNoRetenido.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setIVANoRetenido(BigInteger value) {
                this.ivaNoRetenido = value;
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
             * Obtiene el valor de la propiedad psjNac.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getPsjNac() {
                return psjNac;
            }

            /**
             * Define el valor de la propiedad psjNac.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setPsjNac(BigInteger value) {
                this.psjNac = value;
            }

            /**
             * Obtiene el valor de la propiedad psjInt.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getPsjInt() {
                return psjInt;
            }

            /**
             * Define el valor de la propiedad psjInt.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setPsjInt(BigInteger value) {
                this.psjInt = value;
            }

            /**
             * Obtiene el valor de la propiedad tabPuros.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTabPuros() {
                return tabPuros;
            }

            /**
             * Define el valor de la propiedad tabPuros.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTabPuros(BigInteger value) {
                this.tabPuros = value;
            }

            /**
             * Obtiene el valor de la propiedad tabCigarrillos.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTabCigarrillos() {
                return tabCigarrillos;
            }

            /**
             * Define el valor de la propiedad tabCigarrillos.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTabCigarrillos(BigInteger value) {
                this.tabCigarrillos = value;
            }

            /**
             * Obtiene el valor de la propiedad tabElaborado.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getTabElaborado() {
                return tabElaborado;
            }

            /**
             * Define el valor de la propiedad tabElaborado.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setTabElaborado(BigInteger value) {
                this.tabElaborado = value;
            }

            /**
             * Obtiene el valor de la propiedad impVehiculo.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public BigInteger getImpVehiculo() {
                return impVehiculo;
            }

            /**
             * Define el valor de la propiedad impVehiculo.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public void setImpVehiculo(BigInteger value) {
                this.impVehiculo = value;
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
             *         &lt;element name="NumId" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="Nacionalidad" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;minLength value="1"/&gt;
             *               &lt;maxLength value="3"/&gt;
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
                "numId",
                "nacionalidad"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class Extranjero
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "NumId", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected String numId;
                @XmlElement(name = "Nacionalidad", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected String nacionalidad;

                /**
                 * Obtiene el valor de la propiedad numId.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public String getNumId() {
                    return numId;
                }

                /**
                 * Define el valor de la propiedad numId.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setNumId(String value) {
                    this.numId = value;
                }

                /**
                 * Obtiene el valor de la propiedad nacionalidad.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public String getNacionalidad() {
                    return nacionalidad;
                }

                /**
                 * Define el valor de la propiedad nacionalidad.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setNacionalidad(String value) {
                    this.nacionalidad = value;
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
             *         &lt;element name="CodIVANoRec"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *               &lt;enumeration value="3"/&gt;
             *               &lt;enumeration value="4"/&gt;
             *               &lt;enumeration value="9"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="MntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
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
                "codIVANoRec",
                "mntIVANoRec"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class IVANoRec
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "CodIVANoRec", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger codIVANoRec;
                @XmlElement(name = "MntIVANoRec", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger mntIVANoRec;

                /**
                 * Obtiene el valor de la propiedad codIVANoRec.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getCodIVANoRec() {
                    return codIVANoRec;
                }

                /**
                 * Define el valor de la propiedad codIVANoRec.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setCodIVANoRec(BigInteger value) {
                    this.codIVANoRec = value;
                }

                /**
                 * Obtiene el valor de la propiedad mntIVANoRec.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getMntIVANoRec() {
                    return mntIVANoRec;
                }

                /**
                 * Define el valor de la propiedad mntIVANoRec.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setMntIVANoRec(BigInteger value) {
                    this.mntIVANoRec = value;
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
             *         &lt;element name="RutEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
             *         &lt;element name="ValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="ValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="ValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
                "rutEmisor",
                "valComNeto",
                "valComExe",
                "valComIVA"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class Liquidaciones
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "RutEmisor", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected String rutEmisor;
                @XmlElement(name = "ValComNeto", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger valComNeto;
                @XmlElement(name = "ValComExe", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger valComExe;
                @XmlElement(name = "ValComIVA", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger valComIVA;

                /**
                 * Obtiene el valor de la propiedad rutEmisor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setRutEmisor(String value) {
                    this.rutEmisor = value;
                }

                /**
                 * Obtiene el valor de la propiedad valComNeto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getValComNeto() {
                    return valComNeto;
                }

                /**
                 * Define el valor de la propiedad valComNeto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setValComNeto(BigInteger value) {
                    this.valComNeto = value;
                }

                /**
                 * Obtiene el valor de la propiedad valComExe.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getValComExe() {
                    return valComExe;
                }

                /**
                 * Define el valor de la propiedad valComExe.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setValComExe(BigInteger value) {
                    this.valComExe = value;
                }

                /**
                 * Obtiene el valor de la propiedad valComIVA.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getValComIVA() {
                    return valComIVA;
                }

                /**
                 * Define el valor de la propiedad valComIVA.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setValComIVA(BigInteger value) {
                    this.valComIVA = value;
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
             *         &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
             *         &lt;element name="TasaImp" type="{http://www.sii.cl/SiiDte}PctType" minOccurs="0"/&gt;
             *         &lt;element name="MntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
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
                "codImp",
                "tasaImp",
                "mntImp"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class OtrosImp
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "CodImp", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger codImp;
                @XmlElement(name = "TasaImp", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigDecimal tasaImp;
                @XmlElement(name = "MntImp", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger mntImp;

                /**
                 * Obtiene el valor de la propiedad codImp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getCodImp() {
                    return codImp;
                }

                /**
                 * Define el valor de la propiedad codImp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setCodImp(BigInteger value) {
                    this.codImp = value;
                }

                /**
                 * Obtiene el valor de la propiedad tasaImp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigDecimal getTasaImp() {
                    return tasaImp;
                }

                /**
                 * Define el valor de la propiedad tasaImp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTasaImp(BigDecimal value) {
                    this.tasaImp = value;
                }

                /**
                 * Obtiene el valor de la propiedad mntImp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getMntImp() {
                    return mntImp;
                }

                /**
                 * Define el valor de la propiedad mntImp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setMntImp(BigInteger value) {
                    this.mntImp = value;
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
         *         &lt;element name="TotalesPeriodo" maxOccurs="40"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
         *                   &lt;element name="TpoImp" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="1"/&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotDoc"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotAnulado" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotOpExe" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotOpIVARec" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="CodIVANoRec"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                   &lt;enumeration value="2"/&gt;
         *                                   &lt;enumeration value="3"/&gt;
         *                                   &lt;enumeration value="4"/&gt;
         *                                   &lt;enumeration value="9"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                                   &lt;totalDigits value="10"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="FctProp" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                         &lt;fractionDigits value="3"/&gt;
         *                         &lt;totalDigits value="5"/&gt;
         *                         &lt;maxInclusive value="99.999"/&gt;
         *                         &lt;minInclusive value="00.001"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotCredIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
         *                             &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                             &lt;element name="FctImpAdic" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
         *                                   &lt;totalDigits value="6"/&gt;
         *                                   &lt;fractionDigits value="4"/&gt;
         *                                   &lt;maxInclusive value="1.000"/&gt;
         *                                   &lt;minInclusive value="0.001"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TotCredImp" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="TotImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
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
            @XmlElement(name = "TotalesPeriodo", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo> totalesPeriodos;

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
             * {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo> getTotalesPeriodos() {
                if (totalesPeriodos == null) {
                    totalesPeriodos = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo>();
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
             *         &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
             *         &lt;element name="TpoImp" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="1"/&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotDoc"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotAnulado" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotOpExe" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotOpIVARec" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="CodIVANoRec"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                         &lt;enumeration value="2"/&gt;
             *                         &lt;enumeration value="3"/&gt;
             *                         &lt;enumeration value="4"/&gt;
             *                         &lt;enumeration value="9"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *                         &lt;totalDigits value="10"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="FctProp" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *               &lt;fractionDigits value="3"/&gt;
             *               &lt;totalDigits value="5"/&gt;
             *               &lt;maxInclusive value="99.999"/&gt;
             *               &lt;minInclusive value="00.001"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotCredIVAUsoComun" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
             *                   &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *                   &lt;element name="FctImpAdic" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
             *                         &lt;totalDigits value="6"/&gt;
             *                         &lt;fractionDigits value="4"/&gt;
             *                         &lt;maxInclusive value="1.000"/&gt;
             *                         &lt;minInclusive value="0.001"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TotCredImp" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="TotImpVehiculo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
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
                "tpoImp",
                "totDoc",
                "totAnulado",
                "totOpExe",
                "totMntExe",
                "totMntNeto",
                "totOpIVARec",
                "totMntIVA",
                "totOpActivoFijo",
                "totMntActivoFijo",
                "totMntIVAActivoFijo",
                "totIVANoRecs",
                "totOpIVAUsoComun",
                "totIVAUsoComun",
                "fctProp",
                "totCredIVAUsoComun",
                "totIVAFueraPlazo",
                "totIVAPropio",
                "totIVATerceros",
                "totLey18211",
                "totOtrosImps",
                "totImpSinCredito",
                "totOpIVARetTotal",
                "totIVARetTotal",
                "totOpIVARetParcial",
                "totIVARetParcial",
                "totCredEC",
                "totDepEnvase",
                "totLiquidaciones",
                "totMntTotal",
                "totOpIVANoRetenido",
                "totIVANoRetenido",
                "totMntNoFact",
                "totMntPeriodo",
                "totPsjNac",
                "totPsjInt",
                "totTabPuros",
                "totTabCigarrillos",
                "totTabElaborado",
                "totImpVehiculo"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class TotalesPeriodo
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TpoDoc", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger tpoDoc;
                @XmlElement(name = "TpoImp", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger tpoImp;
                @XmlElement(name = "TotDoc", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totDoc;
                @XmlElement(name = "TotAnulado", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totAnulado;
                @XmlElement(name = "TotOpExe", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpExe;
                @XmlElement(name = "TotMntExe", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntExe;
                @XmlElement(name = "TotMntNeto", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntNeto;
                @XmlElement(name = "TotOpIVARec", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVARec;
                @XmlElement(name = "TotMntIVA", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntIVA;
                @XmlElement(name = "TotOpActivoFijo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpActivoFijo;
                @XmlElement(name = "TotMntActivoFijo", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntActivoFijo;
                @XmlElement(name = "TotMntIVAActivoFijo", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntIVAActivoFijo;
                @XmlElement(name = "TotIVANoRec", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotIVANoRec> totIVANoRecs;
                @XmlElement(name = "TotOpIVAUsoComun", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVAUsoComun;
                @XmlElement(name = "TotIVAUsoComun", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVAUsoComun;
                @XmlElement(name = "FctProp", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigDecimal fctProp;
                @XmlElement(name = "TotCredIVAUsoComun", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totCredIVAUsoComun;
                @XmlElement(name = "TotIVAFueraPlazo", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVAFueraPlazo;
                @XmlElement(name = "TotIVAPropio", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVAPropio;
                @XmlElement(name = "TotIVATerceros", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVATerceros;
                @XmlElement(name = "TotLey18211", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totLey18211;
                @XmlElement(name = "TotOtrosImp", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotOtrosImp> totOtrosImps;
                @XmlElement(name = "TotImpSinCredito", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totImpSinCredito;
                @XmlElement(name = "TotOpIVARetTotal", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVARetTotal;
                @XmlElement(name = "TotIVARetTotal", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVARetTotal;
                @XmlElement(name = "TotOpIVARetParcial", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVARetParcial;
                @XmlElement(name = "TotIVARetParcial", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVARetParcial;
                @XmlElement(name = "TotCredEC", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totCredEC;
                @XmlElement(name = "TotDepEnvase", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totDepEnvase;
                @XmlElement(name = "TotLiquidaciones", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotLiquidaciones totLiquidaciones;
                @XmlElement(name = "TotMntTotal", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntTotal;
                @XmlElement(name = "TotOpIVANoRetenido", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVANoRetenido;
                @XmlElement(name = "TotIVANoRetenido", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVANoRetenido;
                @XmlElement(name = "TotMntNoFact", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntNoFact;
                @XmlElement(name = "TotMntPeriodo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntPeriodo;
                @XmlElement(name = "TotPsjNac", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totPsjNac;
                @XmlElement(name = "TotPsjInt", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totPsjInt;
                @XmlElement(name = "TotTabPuros", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totTabPuros;
                @XmlElement(name = "TotTabCigarrillos", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totTabCigarrillos;
                @XmlElement(name = "TotTabElaborado", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totTabElaborado;
                @XmlElement(name = "TotImpVehiculo", namespace = "http://www.sii.cl/SiiDte")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totImpVehiculo;

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
                 * Obtiene el valor de la propiedad tpoImp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTpoImp() {
                    return tpoImp;
                }

                /**
                 * Define el valor de la propiedad tpoImp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTpoImp(BigInteger value) {
                    this.tpoImp = value;
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
                 * Obtiene el valor de la propiedad totOpExe.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpExe() {
                    return totOpExe;
                }

                /**
                 * Define el valor de la propiedad totOpExe.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpExe(BigInteger value) {
                    this.totOpExe = value;
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
                 * Obtiene el valor de la propiedad totOpIVARec.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVARec() {
                    return totOpIVARec;
                }

                /**
                 * Define el valor de la propiedad totOpIVARec.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVARec(BigInteger value) {
                    this.totOpIVARec = value;
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
                 * Obtiene el valor de la propiedad totOpActivoFijo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpActivoFijo() {
                    return totOpActivoFijo;
                }

                /**
                 * Define el valor de la propiedad totOpActivoFijo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpActivoFijo(BigInteger value) {
                    this.totOpActivoFijo = value;
                }

                /**
                 * Obtiene el valor de la propiedad totMntActivoFijo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotMntActivoFijo() {
                    return totMntActivoFijo;
                }

                /**
                 * Define el valor de la propiedad totMntActivoFijo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotMntActivoFijo(BigInteger value) {
                    this.totMntActivoFijo = value;
                }

                /**
                 * Obtiene el valor de la propiedad totMntIVAActivoFijo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotMntIVAActivoFijo() {
                    return totMntIVAActivoFijo;
                }

                /**
                 * Define el valor de la propiedad totMntIVAActivoFijo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotMntIVAActivoFijo(BigInteger value) {
                    this.totMntIVAActivoFijo = value;
                }

                /**
                 * Gets the value of the totIVANoRecs property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the totIVANoRecs property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTotIVANoRecs().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotIVANoRec }
                 * 
                 * 
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotIVANoRec> getTotIVANoRecs() {
                    if (totIVANoRecs == null) {
                        totIVANoRecs = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotIVANoRec>();
                    }
                    return this.totIVANoRecs;
                }

                /**
                 * Obtiene el valor de la propiedad totOpIVAUsoComun.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVAUsoComun() {
                    return totOpIVAUsoComun;
                }

                /**
                 * Define el valor de la propiedad totOpIVAUsoComun.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVAUsoComun(BigInteger value) {
                    this.totOpIVAUsoComun = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVAUsoComun.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVAUsoComun() {
                    return totIVAUsoComun;
                }

                /**
                 * Define el valor de la propiedad totIVAUsoComun.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVAUsoComun(BigInteger value) {
                    this.totIVAUsoComun = value;
                }

                /**
                 * Obtiene el valor de la propiedad fctProp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigDecimal }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigDecimal getFctProp() {
                    return fctProp;
                }

                /**
                 * Define el valor de la propiedad fctProp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigDecimal }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setFctProp(BigDecimal value) {
                    this.fctProp = value;
                }

                /**
                 * Obtiene el valor de la propiedad totCredIVAUsoComun.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotCredIVAUsoComun() {
                    return totCredIVAUsoComun;
                }

                /**
                 * Define el valor de la propiedad totCredIVAUsoComun.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotCredIVAUsoComun(BigInteger value) {
                    this.totCredIVAUsoComun = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVAFueraPlazo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVAFueraPlazo() {
                    return totIVAFueraPlazo;
                }

                /**
                 * Define el valor de la propiedad totIVAFueraPlazo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVAFueraPlazo(BigInteger value) {
                    this.totIVAFueraPlazo = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVAPropio.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVAPropio() {
                    return totIVAPropio;
                }

                /**
                 * Define el valor de la propiedad totIVAPropio.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVAPropio(BigInteger value) {
                    this.totIVAPropio = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVATerceros.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVATerceros() {
                    return totIVATerceros;
                }

                /**
                 * Define el valor de la propiedad totIVATerceros.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVATerceros(BigInteger value) {
                    this.totIVATerceros = value;
                }

                /**
                 * Obtiene el valor de la propiedad totLey18211.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotLey18211() {
                    return totLey18211;
                }

                /**
                 * Define el valor de la propiedad totLey18211.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotLey18211(BigInteger value) {
                    this.totLey18211 = value;
                }

                /**
                 * Gets the value of the totOtrosImps property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the totOtrosImps property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTotOtrosImps().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotOtrosImp }
                 * 
                 * 
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public List<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotOtrosImp> getTotOtrosImps() {
                    if (totOtrosImps == null) {
                        totOtrosImps = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotOtrosImp>();
                    }
                    return this.totOtrosImps;
                }

                /**
                 * Obtiene el valor de la propiedad totImpSinCredito.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotImpSinCredito() {
                    return totImpSinCredito;
                }

                /**
                 * Define el valor de la propiedad totImpSinCredito.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotImpSinCredito(BigInteger value) {
                    this.totImpSinCredito = value;
                }

                /**
                 * Obtiene el valor de la propiedad totOpIVARetTotal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVARetTotal() {
                    return totOpIVARetTotal;
                }

                /**
                 * Define el valor de la propiedad totOpIVARetTotal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVARetTotal(BigInteger value) {
                    this.totOpIVARetTotal = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVARetTotal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVARetTotal() {
                    return totIVARetTotal;
                }

                /**
                 * Define el valor de la propiedad totIVARetTotal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVARetTotal(BigInteger value) {
                    this.totIVARetTotal = value;
                }

                /**
                 * Obtiene el valor de la propiedad totOpIVARetParcial.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVARetParcial() {
                    return totOpIVARetParcial;
                }

                /**
                 * Define el valor de la propiedad totOpIVARetParcial.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVARetParcial(BigInteger value) {
                    this.totOpIVARetParcial = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVARetParcial.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVARetParcial() {
                    return totIVARetParcial;
                }

                /**
                 * Define el valor de la propiedad totIVARetParcial.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVARetParcial(BigInteger value) {
                    this.totIVARetParcial = value;
                }

                /**
                 * Obtiene el valor de la propiedad totCredEC.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotCredEC() {
                    return totCredEC;
                }

                /**
                 * Define el valor de la propiedad totCredEC.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotCredEC(BigInteger value) {
                    this.totCredEC = value;
                }

                /**
                 * Obtiene el valor de la propiedad totDepEnvase.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotDepEnvase() {
                    return totDepEnvase;
                }

                /**
                 * Define el valor de la propiedad totDepEnvase.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotDepEnvase(BigInteger value) {
                    this.totDepEnvase = value;
                }

                /**
                 * Obtiene el valor de la propiedad totLiquidaciones.
                 * 
                 * @return
                 *     possible object is
                 *     {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotLiquidaciones }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotLiquidaciones getTotLiquidaciones() {
                    return totLiquidaciones;
                }

                /**
                 * Define el valor de la propiedad totLiquidaciones.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotLiquidaciones }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotLiquidaciones(LibroCompraVenta.EnvioLibro.ResumenPeriodo.TotalesPeriodo.TotLiquidaciones value) {
                    this.totLiquidaciones = value;
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
                 * Obtiene el valor de la propiedad totOpIVANoRetenido.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVANoRetenido() {
                    return totOpIVANoRetenido;
                }

                /**
                 * Define el valor de la propiedad totOpIVANoRetenido.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVANoRetenido(BigInteger value) {
                    this.totOpIVANoRetenido = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVANoRetenido.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVANoRetenido() {
                    return totIVANoRetenido;
                }

                /**
                 * Define el valor de la propiedad totIVANoRetenido.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVANoRetenido(BigInteger value) {
                    this.totIVANoRetenido = value;
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
                 * Obtiene el valor de la propiedad totPsjNac.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotPsjNac() {
                    return totPsjNac;
                }

                /**
                 * Define el valor de la propiedad totPsjNac.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotPsjNac(BigInteger value) {
                    this.totPsjNac = value;
                }

                /**
                 * Obtiene el valor de la propiedad totPsjInt.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotPsjInt() {
                    return totPsjInt;
                }

                /**
                 * Define el valor de la propiedad totPsjInt.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotPsjInt(BigInteger value) {
                    this.totPsjInt = value;
                }

                /**
                 * Obtiene el valor de la propiedad totTabPuros.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotTabPuros() {
                    return totTabPuros;
                }

                /**
                 * Define el valor de la propiedad totTabPuros.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotTabPuros(BigInteger value) {
                    this.totTabPuros = value;
                }

                /**
                 * Obtiene el valor de la propiedad totTabCigarrillos.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotTabCigarrillos() {
                    return totTabCigarrillos;
                }

                /**
                 * Define el valor de la propiedad totTabCigarrillos.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotTabCigarrillos(BigInteger value) {
                    this.totTabCigarrillos = value;
                }

                /**
                 * Obtiene el valor de la propiedad totTabElaborado.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotTabElaborado() {
                    return totTabElaborado;
                }

                /**
                 * Define el valor de la propiedad totTabElaborado.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotTabElaborado(BigInteger value) {
                    this.totTabElaborado = value;
                }

                /**
                 * Obtiene el valor de la propiedad totImpVehiculo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotImpVehiculo() {
                    return totImpVehiculo;
                }

                /**
                 * Define el valor de la propiedad totImpVehiculo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotImpVehiculo(BigInteger value) {
                    this.totImpVehiculo = value;
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
                 *         &lt;element name="CodIVANoRec"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *               &lt;enumeration value="2"/&gt;
                 *               &lt;enumeration value="3"/&gt;
                 *               &lt;enumeration value="4"/&gt;
                 *               &lt;enumeration value="9"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
                 *               &lt;totalDigits value="10"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
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
                    "codIVANoRec",
                    "totOpIVANoRec",
                    "totMntIVANoRec"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotIVANoRec
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "CodIVANoRec", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger codIVANoRec;
                    @XmlElement(name = "TotOpIVANoRec", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totOpIVANoRec;
                    @XmlElement(name = "TotMntIVANoRec", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntIVANoRec;

                    /**
                     * Obtiene el valor de la propiedad codIVANoRec.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getCodIVANoRec() {
                        return codIVANoRec;
                    }

                    /**
                     * Define el valor de la propiedad codIVANoRec.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setCodIVANoRec(BigInteger value) {
                        this.codIVANoRec = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totOpIVANoRec.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotOpIVANoRec() {
                        return totOpIVANoRec;
                    }

                    /**
                     * Define el valor de la propiedad totOpIVANoRec.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotOpIVANoRec(BigInteger value) {
                        this.totOpIVANoRec = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntIVANoRec.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntIVANoRec() {
                        return totMntIVANoRec;
                    }

                    /**
                     * Define el valor de la propiedad totMntIVANoRec.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntIVANoRec(BigInteger value) {
                        this.totMntIVANoRec = value;
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
                 *         &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
                    "totValComNeto",
                    "totValComExe",
                    "totValComIVA"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotLiquidaciones
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "TotValComNeto", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totValComNeto;
                    @XmlElement(name = "TotValComExe", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totValComExe;
                    @XmlElement(name = "TotValComIVA", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totValComIVA;

                    /**
                     * Obtiene el valor de la propiedad totValComNeto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotValComNeto() {
                        return totValComNeto;
                    }

                    /**
                     * Define el valor de la propiedad totValComNeto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotValComNeto(BigInteger value) {
                        this.totValComNeto = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totValComExe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotValComExe() {
                        return totValComExe;
                    }

                    /**
                     * Define el valor de la propiedad totValComExe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotValComExe(BigInteger value) {
                        this.totValComExe = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totValComIVA.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotValComIVA() {
                        return totValComIVA;
                    }

                    /**
                     * Define el valor de la propiedad totValComIVA.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotValComIVA(BigInteger value) {
                        this.totValComIVA = value;
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
                 *         &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
                 *         &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
                 *         &lt;element name="FctImpAdic" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}decimal"&gt;
                 *               &lt;totalDigits value="6"/&gt;
                 *               &lt;fractionDigits value="4"/&gt;
                 *               &lt;maxInclusive value="1.000"/&gt;
                 *               &lt;minInclusive value="0.001"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TotCredImp" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
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
                    "codImp",
                    "totMntImp",
                    "fctImpAdic",
                    "totCredImp"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotOtrosImp
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "CodImp", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @XmlSchemaType(name = "positiveInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger codImp;
                    @XmlElement(name = "TotMntImp", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntImp;
                    @XmlElement(name = "FctImpAdic", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigDecimal fctImpAdic;
                    @XmlElement(name = "TotCredImp", namespace = "http://www.sii.cl/SiiDte")
                    @XmlSchemaType(name = "nonNegativeInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totCredImp;

                    /**
                     * Obtiene el valor de la propiedad codImp.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getCodImp() {
                        return codImp;
                    }

                    /**
                     * Define el valor de la propiedad codImp.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setCodImp(BigInteger value) {
                        this.codImp = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntImp.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntImp() {
                        return totMntImp;
                    }

                    /**
                     * Define el valor de la propiedad totMntImp.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntImp(BigInteger value) {
                        this.totMntImp = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad fctImpAdic.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigDecimal }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigDecimal getFctImpAdic() {
                        return fctImpAdic;
                    }

                    /**
                     * Define el valor de la propiedad fctImpAdic.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigDecimal }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setFctImpAdic(BigDecimal value) {
                        this.fctImpAdic = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totCredImp.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotCredImp() {
                        return totCredImp;
                    }

                    /**
                     * Define el valor de la propiedad totCredImp.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotCredImp(BigInteger value) {
                        this.totCredImp = value;
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
         *         &lt;element name="TotalesSegmento" maxOccurs="40"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
         *                   &lt;element name="TpoImp" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="1"/&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotDoc"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotAnulado" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotOpExe" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotOpIVARec" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="CodIVANoRec"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                                   &lt;totalDigits value="1"/&gt;
         *                                   &lt;enumeration value="1"/&gt;
         *                                   &lt;enumeration value="2"/&gt;
         *                                   &lt;enumeration value="3"/&gt;
         *                                   &lt;enumeration value="4"/&gt;
         *                                   &lt;enumeration value="9"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
         *                               &lt;simpleType&gt;
         *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                                   &lt;totalDigits value="10"/&gt;
         *                                 &lt;/restriction&gt;
         *                               &lt;/simpleType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
         *                             &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                             &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
         *                   &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;totalDigits value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
            @XmlElement(name = "TotalesSegmento", namespace = "http://www.sii.cl/SiiDte", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            protected List<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento> totalesSegmentos;

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
             * {@link LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public List<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento> getTotalesSegmentos() {
                if (totalesSegmentos == null) {
                    totalesSegmentos = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento>();
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
             *         &lt;element name="TpoDoc" type="{http://www.sii.cl/SiiDte}DoctoType"/&gt;
             *         &lt;element name="TpoImp" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="1"/&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotDoc"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotAnulado" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotOpExe" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntExe" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotMntNeto" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotOpIVARec" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntIVA" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotOpActivoFijo" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotMntIVAActivoFijo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVANoRec" maxOccurs="5" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="CodIVANoRec"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *                         &lt;totalDigits value="1"/&gt;
             *                         &lt;enumeration value="1"/&gt;
             *                         &lt;enumeration value="2"/&gt;
             *                         &lt;enumeration value="3"/&gt;
             *                         &lt;enumeration value="4"/&gt;
             *                         &lt;enumeration value="9"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
             *                     &lt;simpleType&gt;
             *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *                         &lt;totalDigits value="10"/&gt;
             *                       &lt;/restriction&gt;
             *                     &lt;/simpleType&gt;
             *                   &lt;/element&gt;
             *                   &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotOpIVAUsoComun" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVAUsoComun" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVAFueraPlazo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVAPropio" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotIVATerceros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotLey18211" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotOtrosImp" maxOccurs="20" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
             *                   &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotImpSinCredito" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotOpIVARetTotal" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVARetTotal" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotOpIVARetParcial" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVARetParcial" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotCredEC" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotDepEnvase" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotLiquidaciones" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                   &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *                 &lt;/sequence&gt;
             *               &lt;/restriction&gt;
             *             &lt;/complexContent&gt;
             *           &lt;/complexType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotMntTotal" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
             *         &lt;element name="TotOpIVANoRetenido" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;totalDigits value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TotIVANoRetenido" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotMntNoFact" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotMntPeriodo" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotPsjNac" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotPsjInt" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotTabPuros" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotTabCigarrillos" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotTabElaborado" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
                "tpoImp",
                "totDoc",
                "totAnulado",
                "totOpExe",
                "totMntExe",
                "totMntNeto",
                "totOpIVARec",
                "totMntIVA",
                "totOpActivoFijo",
                "totMntActivoFijo",
                "totMntIVAActivoFijo",
                "totIVANoRecs",
                "totOpIVAUsoComun",
                "totIVAUsoComun",
                "totIVAFueraPlazo",
                "totIVAPropio",
                "totIVATerceros",
                "totLey18211",
                "totOtrosImps",
                "totImpSinCredito",
                "totOpIVARetTotal",
                "totIVARetTotal",
                "totOpIVARetParcial",
                "totIVARetParcial",
                "totCredEC",
                "totDepEnvase",
                "totLiquidaciones",
                "totMntTotal",
                "totOpIVANoRetenido",
                "totIVANoRetenido",
                "totMntNoFact",
                "totMntPeriodo",
                "totPsjNac",
                "totPsjInt",
                "totTabPuros",
                "totTabCigarrillos",
                "totTabElaborado"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
            public static class TotalesSegmento
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TpoDoc", namespace = "http://www.sii.cl/SiiDte", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger tpoDoc;
                @XmlElement(name = "TpoImp", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger tpoImp;
                @XmlElement(name = "TotDoc", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totDoc;
                @XmlElement(name = "TotAnulado", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totAnulado;
                @XmlElement(name = "TotOpExe", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpExe;
                @XmlElement(name = "TotMntExe", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntExe;
                @XmlElement(name = "TotMntNeto", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntNeto;
                @XmlElement(name = "TotOpIVARec", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVARec;
                @XmlElement(name = "TotMntIVA", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntIVA;
                @XmlElement(name = "TotOpActivoFijo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpActivoFijo;
                @XmlElement(name = "TotMntActivoFijo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntActivoFijo;
                @XmlElement(name = "TotMntIVAActivoFijo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntIVAActivoFijo;
                @XmlElement(name = "TotIVANoRec", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected List<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotIVANoRec> totIVANoRecs;
                @XmlElement(name = "TotOpIVAUsoComun", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVAUsoComun;
                @XmlElement(name = "TotIVAUsoComun", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVAUsoComun;
                @XmlElement(name = "TotIVAFueraPlazo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVAFueraPlazo;
                @XmlElement(name = "TotIVAPropio", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVAPropio;
                @XmlElement(name = "TotIVATerceros", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVATerceros;
                @XmlElement(name = "TotLey18211", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totLey18211;
                @XmlElement(name = "TotOtrosImp", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected List<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotOtrosImp> totOtrosImps;
                @XmlElement(name = "TotImpSinCredito", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totImpSinCredito;
                @XmlElement(name = "TotOpIVARetTotal", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVARetTotal;
                @XmlElement(name = "TotIVARetTotal", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVARetTotal;
                @XmlElement(name = "TotOpIVARetParcial", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVARetParcial;
                @XmlElement(name = "TotIVARetParcial", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVARetParcial;
                @XmlElement(name = "TotCredEC", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totCredEC;
                @XmlElement(name = "TotDepEnvase", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totDepEnvase;
                @XmlElement(name = "TotLiquidaciones", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotLiquidaciones totLiquidaciones;
                @XmlElement(name = "TotMntTotal", namespace = "http://www.sii.cl/SiiDte", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntTotal;
                @XmlElement(name = "TotOpIVANoRetenido", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totOpIVANoRetenido;
                @XmlElement(name = "TotIVANoRetenido", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totIVANoRetenido;
                @XmlElement(name = "TotMntNoFact", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntNoFact;
                @XmlElement(name = "TotMntPeriodo", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totMntPeriodo;
                @XmlElement(name = "TotPsjNac", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totPsjNac;
                @XmlElement(name = "TotPsjInt", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totPsjInt;
                @XmlElement(name = "TotTabPuros", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totTabPuros;
                @XmlElement(name = "TotTabCigarrillos", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totTabCigarrillos;
                @XmlElement(name = "TotTabElaborado", namespace = "http://www.sii.cl/SiiDte")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                protected BigInteger totTabElaborado;

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
                 * Obtiene el valor de la propiedad tpoImp.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTpoImp() {
                    return tpoImp;
                }

                /**
                 * Define el valor de la propiedad tpoImp.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTpoImp(BigInteger value) {
                    this.tpoImp = value;
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
                 * Obtiene el valor de la propiedad totOpExe.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpExe() {
                    return totOpExe;
                }

                /**
                 * Define el valor de la propiedad totOpExe.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpExe(BigInteger value) {
                    this.totOpExe = value;
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
                 * Obtiene el valor de la propiedad totOpIVARec.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVARec() {
                    return totOpIVARec;
                }

                /**
                 * Define el valor de la propiedad totOpIVARec.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVARec(BigInteger value) {
                    this.totOpIVARec = value;
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
                 * Obtiene el valor de la propiedad totOpActivoFijo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpActivoFijo() {
                    return totOpActivoFijo;
                }

                /**
                 * Define el valor de la propiedad totOpActivoFijo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpActivoFijo(BigInteger value) {
                    this.totOpActivoFijo = value;
                }

                /**
                 * Obtiene el valor de la propiedad totMntActivoFijo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotMntActivoFijo() {
                    return totMntActivoFijo;
                }

                /**
                 * Define el valor de la propiedad totMntActivoFijo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotMntActivoFijo(BigInteger value) {
                    this.totMntActivoFijo = value;
                }

                /**
                 * Obtiene el valor de la propiedad totMntIVAActivoFijo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotMntIVAActivoFijo() {
                    return totMntIVAActivoFijo;
                }

                /**
                 * Define el valor de la propiedad totMntIVAActivoFijo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotMntIVAActivoFijo(BigInteger value) {
                    this.totMntIVAActivoFijo = value;
                }

                /**
                 * Gets the value of the totIVANoRecs property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the totIVANoRecs property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTotIVANoRecs().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotIVANoRec }
                 * 
                 * 
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public List<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotIVANoRec> getTotIVANoRecs() {
                    if (totIVANoRecs == null) {
                        totIVANoRecs = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotIVANoRec>();
                    }
                    return this.totIVANoRecs;
                }

                /**
                 * Obtiene el valor de la propiedad totOpIVAUsoComun.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVAUsoComun() {
                    return totOpIVAUsoComun;
                }

                /**
                 * Define el valor de la propiedad totOpIVAUsoComun.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVAUsoComun(BigInteger value) {
                    this.totOpIVAUsoComun = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVAUsoComun.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVAUsoComun() {
                    return totIVAUsoComun;
                }

                /**
                 * Define el valor de la propiedad totIVAUsoComun.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVAUsoComun(BigInteger value) {
                    this.totIVAUsoComun = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVAFueraPlazo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVAFueraPlazo() {
                    return totIVAFueraPlazo;
                }

                /**
                 * Define el valor de la propiedad totIVAFueraPlazo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVAFueraPlazo(BigInteger value) {
                    this.totIVAFueraPlazo = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVAPropio.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVAPropio() {
                    return totIVAPropio;
                }

                /**
                 * Define el valor de la propiedad totIVAPropio.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVAPropio(BigInteger value) {
                    this.totIVAPropio = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVATerceros.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVATerceros() {
                    return totIVATerceros;
                }

                /**
                 * Define el valor de la propiedad totIVATerceros.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVATerceros(BigInteger value) {
                    this.totIVATerceros = value;
                }

                /**
                 * Obtiene el valor de la propiedad totLey18211.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotLey18211() {
                    return totLey18211;
                }

                /**
                 * Define el valor de la propiedad totLey18211.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotLey18211(BigInteger value) {
                    this.totLey18211 = value;
                }

                /**
                 * Gets the value of the totOtrosImps property.
                 * 
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the Jakarta XML Binding object.
                 * This is why there is not a <CODE>set</CODE> method for the totOtrosImps property.
                 * 
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getTotOtrosImps().add(newItem);
                 * </pre>
                 * 
                 * 
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotOtrosImp }
                 * 
                 * 
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public List<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotOtrosImp> getTotOtrosImps() {
                    if (totOtrosImps == null) {
                        totOtrosImps = new ArrayList<LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotOtrosImp>();
                    }
                    return this.totOtrosImps;
                }

                /**
                 * Obtiene el valor de la propiedad totImpSinCredito.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotImpSinCredito() {
                    return totImpSinCredito;
                }

                /**
                 * Define el valor de la propiedad totImpSinCredito.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotImpSinCredito(BigInteger value) {
                    this.totImpSinCredito = value;
                }

                /**
                 * Obtiene el valor de la propiedad totOpIVARetTotal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVARetTotal() {
                    return totOpIVARetTotal;
                }

                /**
                 * Define el valor de la propiedad totOpIVARetTotal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVARetTotal(BigInteger value) {
                    this.totOpIVARetTotal = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVARetTotal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVARetTotal() {
                    return totIVARetTotal;
                }

                /**
                 * Define el valor de la propiedad totIVARetTotal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVARetTotal(BigInteger value) {
                    this.totIVARetTotal = value;
                }

                /**
                 * Obtiene el valor de la propiedad totOpIVARetParcial.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVARetParcial() {
                    return totOpIVARetParcial;
                }

                /**
                 * Define el valor de la propiedad totOpIVARetParcial.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVARetParcial(BigInteger value) {
                    this.totOpIVARetParcial = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVARetParcial.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVARetParcial() {
                    return totIVARetParcial;
                }

                /**
                 * Define el valor de la propiedad totIVARetParcial.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVARetParcial(BigInteger value) {
                    this.totIVARetParcial = value;
                }

                /**
                 * Obtiene el valor de la propiedad totCredEC.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotCredEC() {
                    return totCredEC;
                }

                /**
                 * Define el valor de la propiedad totCredEC.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotCredEC(BigInteger value) {
                    this.totCredEC = value;
                }

                /**
                 * Obtiene el valor de la propiedad totDepEnvase.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotDepEnvase() {
                    return totDepEnvase;
                }

                /**
                 * Define el valor de la propiedad totDepEnvase.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotDepEnvase(BigInteger value) {
                    this.totDepEnvase = value;
                }

                /**
                 * Obtiene el valor de la propiedad totLiquidaciones.
                 * 
                 * @return
                 *     possible object is
                 *     {@link LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotLiquidaciones }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotLiquidaciones getTotLiquidaciones() {
                    return totLiquidaciones;
                }

                /**
                 * Define el valor de la propiedad totLiquidaciones.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotLiquidaciones }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotLiquidaciones(LibroCompraVenta.EnvioLibro.ResumenSegmento.TotalesSegmento.TotLiquidaciones value) {
                    this.totLiquidaciones = value;
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
                 * Obtiene el valor de la propiedad totOpIVANoRetenido.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotOpIVANoRetenido() {
                    return totOpIVANoRetenido;
                }

                /**
                 * Define el valor de la propiedad totOpIVANoRetenido.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotOpIVANoRetenido(BigInteger value) {
                    this.totOpIVANoRetenido = value;
                }

                /**
                 * Obtiene el valor de la propiedad totIVANoRetenido.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotIVANoRetenido() {
                    return totIVANoRetenido;
                }

                /**
                 * Define el valor de la propiedad totIVANoRetenido.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotIVANoRetenido(BigInteger value) {
                    this.totIVANoRetenido = value;
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
                 * Obtiene el valor de la propiedad totPsjNac.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotPsjNac() {
                    return totPsjNac;
                }

                /**
                 * Define el valor de la propiedad totPsjNac.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotPsjNac(BigInteger value) {
                    this.totPsjNac = value;
                }

                /**
                 * Obtiene el valor de la propiedad totPsjInt.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotPsjInt() {
                    return totPsjInt;
                }

                /**
                 * Define el valor de la propiedad totPsjInt.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotPsjInt(BigInteger value) {
                    this.totPsjInt = value;
                }

                /**
                 * Obtiene el valor de la propiedad totTabPuros.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotTabPuros() {
                    return totTabPuros;
                }

                /**
                 * Define el valor de la propiedad totTabPuros.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotTabPuros(BigInteger value) {
                    this.totTabPuros = value;
                }

                /**
                 * Obtiene el valor de la propiedad totTabCigarrillos.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotTabCigarrillos() {
                    return totTabCigarrillos;
                }

                /**
                 * Define el valor de la propiedad totTabCigarrillos.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotTabCigarrillos(BigInteger value) {
                    this.totTabCigarrillos = value;
                }

                /**
                 * Obtiene el valor de la propiedad totTabElaborado.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public BigInteger getTotTabElaborado() {
                    return totTabElaborado;
                }

                /**
                 * Define el valor de la propiedad totTabElaborado.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public void setTotTabElaborado(BigInteger value) {
                    this.totTabElaborado = value;
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
                 *         &lt;element name="CodIVANoRec"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
                 *               &lt;totalDigits value="1"/&gt;
                 *               &lt;enumeration value="1"/&gt;
                 *               &lt;enumeration value="2"/&gt;
                 *               &lt;enumeration value="3"/&gt;
                 *               &lt;enumeration value="4"/&gt;
                 *               &lt;enumeration value="9"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TotOpIVANoRec" minOccurs="0"&gt;
                 *           &lt;simpleType&gt;
                 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
                 *               &lt;totalDigits value="10"/&gt;
                 *             &lt;/restriction&gt;
                 *           &lt;/simpleType&gt;
                 *         &lt;/element&gt;
                 *         &lt;element name="TotMntIVANoRec" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
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
                    "codIVANoRec",
                    "totOpIVANoRec",
                    "totMntIVANoRec"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotIVANoRec
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "CodIVANoRec", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger codIVANoRec;
                    @XmlElement(name = "TotOpIVANoRec", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totOpIVANoRec;
                    @XmlElement(name = "TotMntIVANoRec", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntIVANoRec;

                    /**
                     * Obtiene el valor de la propiedad codIVANoRec.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getCodIVANoRec() {
                        return codIVANoRec;
                    }

                    /**
                     * Define el valor de la propiedad codIVANoRec.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setCodIVANoRec(BigInteger value) {
                        this.codIVANoRec = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totOpIVANoRec.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotOpIVANoRec() {
                        return totOpIVANoRec;
                    }

                    /**
                     * Define el valor de la propiedad totOpIVANoRec.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotOpIVANoRec(BigInteger value) {
                        this.totOpIVANoRec = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntIVANoRec.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntIVANoRec() {
                        return totMntIVANoRec;
                    }

                    /**
                     * Define el valor de la propiedad totMntIVANoRec.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntIVANoRec(BigInteger value) {
                        this.totMntIVANoRec = value;
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
                 *         &lt;element name="TotValComNeto" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotValComExe" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
                 *         &lt;element name="TotValComIVA" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
                    "totValComNeto",
                    "totValComExe",
                    "totValComIVA"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotLiquidaciones
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "TotValComNeto", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totValComNeto;
                    @XmlElement(name = "TotValComExe", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totValComExe;
                    @XmlElement(name = "TotValComIVA", namespace = "http://www.sii.cl/SiiDte")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totValComIVA;

                    /**
                     * Obtiene el valor de la propiedad totValComNeto.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotValComNeto() {
                        return totValComNeto;
                    }

                    /**
                     * Define el valor de la propiedad totValComNeto.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotValComNeto(BigInteger value) {
                        this.totValComNeto = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totValComExe.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotValComExe() {
                        return totValComExe;
                    }

                    /**
                     * Define el valor de la propiedad totValComExe.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotValComExe(BigInteger value) {
                        this.totValComExe = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totValComIVA.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotValComIVA() {
                        return totValComIVA;
                    }

                    /**
                     * Define el valor de la propiedad totValComIVA.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotValComIVA(BigInteger value) {
                        this.totValComIVA = value;
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
                 *         &lt;element name="CodImp" type="{http://www.sii.cl/SiiDte}ImptoType"/&gt;
                 *         &lt;element name="TotMntImp" type="{http://www.sii.cl/SiiDte}ValorType"/&gt;
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
                    "codImp",
                    "totMntImp"
                })
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                public static class TotOtrosImp
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "CodImp", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @XmlSchemaType(name = "positiveInteger")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger codImp;
                    @XmlElement(name = "TotMntImp", namespace = "http://www.sii.cl/SiiDte", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    protected BigInteger totMntImp;

                    /**
                     * Obtiene el valor de la propiedad codImp.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getCodImp() {
                        return codImp;
                    }

                    /**
                     * Define el valor de la propiedad codImp.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setCodImp(BigInteger value) {
                        this.codImp = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad totMntImp.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public BigInteger getTotMntImp() {
                        return totMntImp;
                    }

                    /**
                     * Define el valor de la propiedad totMntImp.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BigInteger }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-11-29T11:10:48-03:00")
                    public void setTotMntImp(BigInteger value) {
                        this.totMntImp = value;
                    }

                }

            }

        }

    }

}
