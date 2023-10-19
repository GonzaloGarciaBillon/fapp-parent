
package cl.fapp.sii.jaxb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import cl.fapp.sii.factory.adapters.Base64Adapter;
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
import jakarta.xml.bind.annotation.XmlValue;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Boleta Electronica
 * 
 * <p>Clase Java para BOLETADefType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="BOLETADefType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Documento"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Encabezado"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="IdDoc"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                                       &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                       &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                       &lt;element name="IndServicio"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;enumeration value="1"/&gt;
 *                                             &lt;enumeration value="2"/&gt;
 *                                             &lt;enumeration value="3"/&gt;
 *                                             &lt;enumeration value="4"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="IndMntNeto" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
 *                                             &lt;enumeration value="2"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                                       &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                                       &lt;element name="FchVenc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Emisor"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                       &lt;element name="RznSocEmisor" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="100"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="GiroEmisor" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="80"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CdgSIISucur" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="9"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="DirOrigen" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="70"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CmnaOrigen" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CiudadOrigen" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Receptor"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                       &lt;element name="CdgIntRecep" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="RznSocRecep" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="100"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="Contacto" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="80"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="DirRecep" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="70"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CmnaRecep" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CiudadRecep" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="DirPostal" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="70"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CmnaPostal" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CiudadPostal" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="Totales"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="IVA" type="{http://www.sii.cl/SiiDte}MntImpType" minOccurs="0"/&gt;
 *                                       &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                                       &lt;element name="MontoNF" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="TotalPeriodo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
 *                                       &lt;element name="SaldoAnterior" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
 *                                       &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
 *                   &lt;element name="Detalle" maxOccurs="1000" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="NroLinDet" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *                             &lt;element name="CdgItem" maxOccurs="5" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="TpoCodigo"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="VlrCodigo"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="35"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="IndExe" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                   &lt;enumeration value="6"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ItemEspectaculo" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;maxInclusive value="2"/&gt;
 *                                   &lt;totalDigits value="2"/&gt;
 *                                   &lt;enumeration value="01"/&gt;
 *                                   &lt;enumeration value="02"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RUTMandante" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
 *                             &lt;element name="NmbItem"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="80"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="InfoTicket" minOccurs="0"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="FolioTicket"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                             &lt;totalDigits value="6"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="FchGenera"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
 *                                             &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
 *                                             &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="NmbEvento"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="80"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TpoTicket"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="10"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CdgEvento"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="5"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="FchEvento"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
 *                                             &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
 *                                             &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="LugarEvento"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="80"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="UbicEvento"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="20"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="FilaUbicEvento" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="3"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="AsntoUbicEvento" minOccurs="0"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="3"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DscItem" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="1000"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="QtyItem" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{}Dec5Type"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="UnmdItem" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="4"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="PrcItem" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{}Dec5Type"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DescuentoPct" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{}PctType"&gt;
 *                                   &lt;minInclusive value="0.00"/&gt;
 *                                   &lt;maxInclusive value="100.00"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="DescuentoMonto" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RecargoPct" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{}PctType"&gt;
 *                                   &lt;maxInclusive value="100.00"/&gt;
 *                                   &lt;minInclusive value="0.00"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RecargoMonto" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
 *                                   &lt;totalDigits value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="MontoItem" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="SubTotInfo" maxOccurs="20" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="NroSTI"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;maxInclusive value="99"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="GlosaSTI" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="80"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="OrdenSTI" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;maxInclusive value="99"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="SubTotNetoSTI" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{}Dec1Type"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="SubTotIVASTI" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{}Dec1Type"&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="SubTotAdicSTI" type="{}Dec1Type" minOccurs="0"/&gt;
 *                             &lt;element name="SubTotExeSTI" type="{}Dec1Type" minOccurs="0"/&gt;
 *                             &lt;element name="ValSubtotSTI" type="{}Dec1Type" minOccurs="0"/&gt;
 *                             &lt;element name="LineasDeta" maxOccurs="1000" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;maxInclusive value="1000"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="DscRcgGlobal" maxOccurs="20" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="NroLinDR"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;maxInclusive value="99"/&gt;
 *                                   &lt;minInclusive value="1"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TpoMov"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="D"/&gt;
 *                                   &lt;enumeration value="R"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="GlosaDR" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="45"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TpoValor"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;enumeration value="%"/&gt;
 *                                   &lt;enumeration value="$"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="ValorDR" type="{}Dec1Type"/&gt;
 *                             &lt;element name="IndExeDR" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;enumeration value="1"/&gt;
 *                                   &lt;enumeration value="2"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Referencia" maxOccurs="40" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="NroLinRef"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
 *                                   &lt;maxInclusive value="40"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="TpoDocRef" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="3"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FolioRef" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CodRef" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="18"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="RazonRef" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="90"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CodVndor" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="8"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="CodCaja" minOccurs="0"&gt;
 *                               &lt;simpleType&gt;
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                   &lt;maxLength value="8"/&gt;
 *                                 &lt;/restriction&gt;
 *                               &lt;/simpleType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="TED"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="DD"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                       &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                                       &lt;element name="F" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                       &lt;element name="FE" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                       &lt;element name="RR" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                       &lt;element name="RSR"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="40"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="MNT" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/&gt;
 *                                       &lt;element name="IT1"&gt;
 *                                         &lt;simpleType&gt;
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                             &lt;maxLength value="40"/&gt;
 *                                           &lt;/restriction&gt;
 *                                         &lt;/simpleType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="CAF"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element name="DA"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;complexContent&gt;
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                         &lt;sequence&gt;
 *                                                           &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
 *                                                           &lt;element name="RS"&gt;
 *                                                             &lt;simpleType&gt;
 *                                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                                                 &lt;maxLength value="40"/&gt;
 *                                                               &lt;/restriction&gt;
 *                                                             &lt;/simpleType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
 *                                                           &lt;element name="RNG"&gt;
 *                                                             &lt;complexType&gt;
 *                                                               &lt;complexContent&gt;
 *                                                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                   &lt;sequence&gt;
 *                                                                     &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                                                     &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
 *                                                                   &lt;/sequence&gt;
 *                                                                 &lt;/restriction&gt;
 *                                                               &lt;/complexContent&gt;
 *                                                             &lt;/complexType&gt;
 *                                                           &lt;/element&gt;
 *                                                           &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *                                                           &lt;choice&gt;
 *                                                             &lt;element name="RSAPK"&gt;
 *                                                               &lt;complexType&gt;
 *                                                                 &lt;complexContent&gt;
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                     &lt;sequence&gt;
 *                                                                       &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                                                       &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                                                     &lt;/sequence&gt;
 *                                                                   &lt;/restriction&gt;
 *                                                                 &lt;/complexContent&gt;
 *                                                               &lt;/complexType&gt;
 *                                                             &lt;/element&gt;
 *                                                             &lt;element name="DSAPK"&gt;
 *                                                               &lt;complexType&gt;
 *                                                                 &lt;complexContent&gt;
 *                                                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                                                     &lt;sequence&gt;
 *                                                                       &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                                                       &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                                                       &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                                                       &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *                                                                     &lt;/sequence&gt;
 *                                                                   &lt;/restriction&gt;
 *                                                                 &lt;/complexContent&gt;
 *                                                               &lt;/complexType&gt;
 *                                                             &lt;/element&gt;
 *                                                           &lt;/choice&gt;
 *                                                           &lt;element name="IDK" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *                                                         &lt;/sequence&gt;
 *                                                       &lt;/restriction&gt;
 *                                                     &lt;/complexContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                                 &lt;element name="FRMA"&gt;
 *                                                   &lt;complexType&gt;
 *                                                     &lt;simpleContent&gt;
 *                                                       &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
 *                                                         &lt;attribute name="algoritmo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="SHA1withRSA" /&gt;
 *                                                       &lt;/extension&gt;
 *                                                     &lt;/simpleContent&gt;
 *                                                   &lt;/complexType&gt;
 *                                                 &lt;/element&gt;
 *                                               &lt;/sequence&gt;
 *                                               &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.0" /&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                       &lt;element name="TSTED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                             &lt;element name="FRMT"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;simpleContent&gt;
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
 *                                     &lt;attribute name="algoritmo" use="required"&gt;
 *                                       &lt;simpleType&gt;
 *                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                                           &lt;enumeration value="SHA1withRSA"/&gt;
 *                                           &lt;enumeration value="SHA1withDSA"/&gt;
 *                                         &lt;/restriction&gt;
 *                                       &lt;/simpleType&gt;
 *                                     &lt;/attribute&gt;
 *                                   &lt;/extension&gt;
 *                                 &lt;/simpleContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.0" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlType(name = "BOLETADefType", propOrder = {
    "documento",
    "signature"
})
@XmlRootElement(name = "BOLETADefType")
@Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
public class BOLETADefType
    implements Serializable
{

    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    private final static long serialVersionUID = -1L;
    @XmlElement(name = "Documento", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    protected BOLETADefType.Documento documento;
    @XmlElement(name = "Signature", namespace = "http://www.w3.org/2000/09/xmldsig#", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    protected Signature signature;
    @XmlAttribute(name = "version", required = true)
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    protected BigDecimal version;

    /**
     * Obtiene el valor de la propiedad documento.
     * 
     * @return
     *     possible object is
     *     {@link BOLETADefType.Documento }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    public BOLETADefType.Documento getDocumento() {
        return documento;
    }

    /**
     * Define el valor de la propiedad documento.
     * 
     * @param value
     *     allowed object is
     *     {@link BOLETADefType.Documento }
     *     
     */
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    public void setDocumento(BOLETADefType.Documento value) {
        this.documento = value;
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
     *         &lt;element name="Encabezado"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="IdDoc"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                             &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                             &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="IndServicio"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;enumeration value="1"/&gt;
     *                                   &lt;enumeration value="2"/&gt;
     *                                   &lt;enumeration value="3"/&gt;
     *                                   &lt;enumeration value="4"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="IndMntNeto" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
     *                                   &lt;enumeration value="2"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                             &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                             &lt;element name="FchVenc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Emisor"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                             &lt;element name="RznSocEmisor" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="100"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="GiroEmisor" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="80"/&gt;
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
     *                             &lt;element name="DirOrigen" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="70"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CmnaOrigen" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CiudadOrigen" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Receptor"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                             &lt;element name="CdgIntRecep" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="RznSocRecep" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="100"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="Contacto" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="80"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="DirRecep" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="70"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CmnaRecep" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CiudadRecep" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="DirPostal" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="70"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CmnaPostal" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CiudadPostal" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="Totales"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="IVA" type="{http://www.sii.cl/SiiDte}MntImpType" minOccurs="0"/&gt;
     *                             &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                             &lt;element name="MontoNF" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="TotalPeriodo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
     *                             &lt;element name="SaldoAnterior" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
     *                             &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
     *         &lt;element name="Detalle" maxOccurs="1000" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="NroLinDet" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
     *                   &lt;element name="CdgItem" maxOccurs="5" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="TpoCodigo"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="VlrCodigo"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="35"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="IndExe" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                         &lt;enumeration value="6"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ItemEspectaculo" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;maxInclusive value="2"/&gt;
     *                         &lt;totalDigits value="2"/&gt;
     *                         &lt;enumeration value="01"/&gt;
     *                         &lt;enumeration value="02"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RUTMandante" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
     *                   &lt;element name="NmbItem"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="80"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="InfoTicket" minOccurs="0"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="FolioTicket"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                                   &lt;totalDigits value="6"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="FchGenera"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
     *                                   &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
     *                                   &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="NmbEvento"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="80"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TpoTicket"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="10"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CdgEvento"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="5"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="FchEvento"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
     *                                   &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
     *                                   &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="LugarEvento"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="80"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="UbicEvento"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="20"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="FilaUbicEvento" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="3"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="AsntoUbicEvento" minOccurs="0"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="3"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DscItem" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="1000"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="QtyItem" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{}Dec5Type"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="UnmdItem" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="4"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="PrcItem" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{}Dec5Type"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DescuentoPct" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{}PctType"&gt;
     *                         &lt;minInclusive value="0.00"/&gt;
     *                         &lt;maxInclusive value="100.00"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="DescuentoMonto" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RecargoPct" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{}PctType"&gt;
     *                         &lt;maxInclusive value="100.00"/&gt;
     *                         &lt;minInclusive value="0.00"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RecargoMonto" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
     *                         &lt;totalDigits value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="MontoItem" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="SubTotInfo" maxOccurs="20" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="NroSTI"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;maxInclusive value="99"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="GlosaSTI" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="80"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="OrdenSTI" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;maxInclusive value="99"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="SubTotNetoSTI" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{}Dec1Type"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="SubTotIVASTI" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{}Dec1Type"&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="SubTotAdicSTI" type="{}Dec1Type" minOccurs="0"/&gt;
     *                   &lt;element name="SubTotExeSTI" type="{}Dec1Type" minOccurs="0"/&gt;
     *                   &lt;element name="ValSubtotSTI" type="{}Dec1Type" minOccurs="0"/&gt;
     *                   &lt;element name="LineasDeta" maxOccurs="1000" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;maxInclusive value="1000"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="DscRcgGlobal" maxOccurs="20" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="NroLinDR"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;maxInclusive value="99"/&gt;
     *                         &lt;minInclusive value="1"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TpoMov"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="D"/&gt;
     *                         &lt;enumeration value="R"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="GlosaDR" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="45"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TpoValor"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;enumeration value="%"/&gt;
     *                         &lt;enumeration value="$"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="ValorDR" type="{}Dec1Type"/&gt;
     *                   &lt;element name="IndExeDR" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;enumeration value="1"/&gt;
     *                         &lt;enumeration value="2"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Referencia" maxOccurs="40" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="NroLinRef"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
     *                         &lt;maxInclusive value="40"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="TpoDocRef" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="3"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FolioRef" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CodRef" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="18"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="RazonRef" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="90"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CodVndor" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="8"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="CodCaja" minOccurs="0"&gt;
     *                     &lt;simpleType&gt;
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                         &lt;maxLength value="8"/&gt;
     *                       &lt;/restriction&gt;
     *                     &lt;/simpleType&gt;
     *                   &lt;/element&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="TED"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="DD"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                             &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                             &lt;element name="F" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                             &lt;element name="FE" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                             &lt;element name="RR" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                             &lt;element name="RSR"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="40"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="MNT" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/&gt;
     *                             &lt;element name="IT1"&gt;
     *                               &lt;simpleType&gt;
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                   &lt;maxLength value="40"/&gt;
     *                                 &lt;/restriction&gt;
     *                               &lt;/simpleType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="CAF"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element name="DA"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;complexContent&gt;
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                               &lt;sequence&gt;
     *                                                 &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
     *                                                 &lt;element name="RS"&gt;
     *                                                   &lt;simpleType&gt;
     *                                                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                                       &lt;maxLength value="40"/&gt;
     *                                                     &lt;/restriction&gt;
     *                                                   &lt;/simpleType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
     *                                                 &lt;element name="RNG"&gt;
     *                                                   &lt;complexType&gt;
     *                                                     &lt;complexContent&gt;
     *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                         &lt;sequence&gt;
     *                                                           &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                                                           &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
     *                                                         &lt;/sequence&gt;
     *                                                       &lt;/restriction&gt;
     *                                                     &lt;/complexContent&gt;
     *                                                   &lt;/complexType&gt;
     *                                                 &lt;/element&gt;
     *                                                 &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
     *                                                 &lt;choice&gt;
     *                                                   &lt;element name="RSAPK"&gt;
     *                                                     &lt;complexType&gt;
     *                                                       &lt;complexContent&gt;
     *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                           &lt;sequence&gt;
     *                                                             &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                                                             &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                                                           &lt;/sequence&gt;
     *                                                         &lt;/restriction&gt;
     *                                                       &lt;/complexContent&gt;
     *                                                     &lt;/complexType&gt;
     *                                                   &lt;/element&gt;
     *                                                   &lt;element name="DSAPK"&gt;
     *                                                     &lt;complexType&gt;
     *                                                       &lt;complexContent&gt;
     *                                                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                                           &lt;sequence&gt;
     *                                                             &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                                                             &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                                                             &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                                                             &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
     *                                                           &lt;/sequence&gt;
     *                                                         &lt;/restriction&gt;
     *                                                       &lt;/complexContent&gt;
     *                                                     &lt;/complexType&gt;
     *                                                   &lt;/element&gt;
     *                                                 &lt;/choice&gt;
     *                                                 &lt;element name="IDK" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
     *                                               &lt;/sequence&gt;
     *                                             &lt;/restriction&gt;
     *                                           &lt;/complexContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                       &lt;element name="FRMA"&gt;
     *                                         &lt;complexType&gt;
     *                                           &lt;simpleContent&gt;
     *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
     *                                               &lt;attribute name="algoritmo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="SHA1withRSA" /&gt;
     *                                             &lt;/extension&gt;
     *                                           &lt;/simpleContent&gt;
     *                                         &lt;/complexType&gt;
     *                                       &lt;/element&gt;
     *                                     &lt;/sequence&gt;
     *                                     &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.0" /&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                             &lt;element name="TSTED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
     *                   &lt;element name="FRMT"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;simpleContent&gt;
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
     *                           &lt;attribute name="algoritmo" use="required"&gt;
     *                             &lt;simpleType&gt;
     *                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *                                 &lt;enumeration value="SHA1withRSA"/&gt;
     *                                 &lt;enumeration value="SHA1withDSA"/&gt;
     *                               &lt;/restriction&gt;
     *                             &lt;/simpleType&gt;
     *                           &lt;/attribute&gt;
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
        "encabezado",
        "detalles",
        "subTotInfos",
        "dscRcgGlobals",
        "referencias",
        "ted",
        "tmstFirma"
    })
    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
    public static class Documento
        implements Serializable
    {

        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        private final static long serialVersionUID = -1L;
        @XmlElement(name = "Encabezado", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected BOLETADefType.Documento.Encabezado encabezado;
        @XmlElement(name = "Detalle")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected List<BOLETADefType.Documento.Detalle> detalles;
        @XmlElement(name = "SubTotInfo")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected List<BOLETADefType.Documento.SubTotInfo> subTotInfos;
        @XmlElement(name = "DscRcgGlobal")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected List<BOLETADefType.Documento.DscRcgGlobal> dscRcgGlobals;
        @XmlElement(name = "Referencia")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected List<BOLETADefType.Documento.Referencia> referencias;
        @XmlElement(name = "TED", required = true)
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected BOLETADefType.Documento.TED ted;
        @XmlElement(name = "TmstFirma", required = true, type = String.class)
        @XmlJavaTypeAdapter(DateTimeAdapter.class)
        @XmlSchemaType(name = "dateTime")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected Date tmstFirma;
        @XmlAttribute(name = "ID", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        protected String id;

        /**
         * Obtiene el valor de la propiedad encabezado.
         * 
         * @return
         *     possible object is
         *     {@link BOLETADefType.Documento.Encabezado }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public BOLETADefType.Documento.Encabezado getEncabezado() {
            return encabezado;
        }

        /**
         * Define el valor de la propiedad encabezado.
         * 
         * @param value
         *     allowed object is
         *     {@link BOLETADefType.Documento.Encabezado }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public void setEncabezado(BOLETADefType.Documento.Encabezado value) {
            this.encabezado = value;
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
         * {@link BOLETADefType.Documento.Detalle }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public List<BOLETADefType.Documento.Detalle> getDetalles() {
            if (detalles == null) {
                detalles = new ArrayList<BOLETADefType.Documento.Detalle>();
            }
            return this.detalles;
        }

        /**
         * Gets the value of the subTotInfos property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the subTotInfos property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSubTotInfos().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BOLETADefType.Documento.SubTotInfo }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public List<BOLETADefType.Documento.SubTotInfo> getSubTotInfos() {
            if (subTotInfos == null) {
                subTotInfos = new ArrayList<BOLETADefType.Documento.SubTotInfo>();
            }
            return this.subTotInfos;
        }

        /**
         * Gets the value of the dscRcgGlobals property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the dscRcgGlobals property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDscRcgGlobals().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BOLETADefType.Documento.DscRcgGlobal }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public List<BOLETADefType.Documento.DscRcgGlobal> getDscRcgGlobals() {
            if (dscRcgGlobals == null) {
                dscRcgGlobals = new ArrayList<BOLETADefType.Documento.DscRcgGlobal>();
            }
            return this.dscRcgGlobals;
        }

        /**
         * Gets the value of the referencias property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the referencias property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReferencias().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BOLETADefType.Documento.Referencia }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public List<BOLETADefType.Documento.Referencia> getReferencias() {
            if (referencias == null) {
                referencias = new ArrayList<BOLETADefType.Documento.Referencia>();
            }
            return this.referencias;
        }

        /**
         * Obtiene el valor de la propiedad ted.
         * 
         * @return
         *     possible object is
         *     {@link BOLETADefType.Documento.TED }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public BOLETADefType.Documento.TED getTED() {
            return ted;
        }

        /**
         * Define el valor de la propiedad ted.
         * 
         * @param value
         *     allowed object is
         *     {@link BOLETADefType.Documento.TED }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public void setTED(BOLETADefType.Documento.TED value) {
            this.ted = value;
        }

        /**
         * Obtiene el valor de la propiedad tmstFirma.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
         *         &lt;element name="NroLinDet" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
         *         &lt;element name="CdgItem" maxOccurs="5" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TpoCodigo"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="VlrCodigo"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="35"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="IndExe" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
         *               &lt;enumeration value="6"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ItemEspectaculo" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;maxInclusive value="2"/&gt;
         *               &lt;totalDigits value="2"/&gt;
         *               &lt;enumeration value="01"/&gt;
         *               &lt;enumeration value="02"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RUTMandante" type="{http://www.sii.cl/SiiDte}RUTType" minOccurs="0"/&gt;
         *         &lt;element name="NmbItem"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="80"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="InfoTicket" minOccurs="0"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="FolioTicket"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;totalDigits value="6"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="FchGenera"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
         *                         &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
         *                         &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="NmbEvento"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="80"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TpoTicket"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="10"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CdgEvento"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="5"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="FchEvento"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
         *                         &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
         *                         &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="LugarEvento"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="80"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="UbicEvento"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="FilaUbicEvento" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="3"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="AsntoUbicEvento" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="3"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DscItem" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="1000"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="QtyItem" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{}Dec5Type"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="UnmdItem" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="4"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="PrcItem" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{}Dec5Type"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DescuentoPct" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{}PctType"&gt;
         *               &lt;minInclusive value="0.00"/&gt;
         *               &lt;maxInclusive value="100.00"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="DescuentoMonto" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RecargoPct" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{}PctType"&gt;
         *               &lt;maxInclusive value="100.00"/&gt;
         *               &lt;minInclusive value="0.00"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RecargoMonto" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"&gt;
         *               &lt;totalDigits value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="MontoItem" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
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
            "nroLinDet",
            "cdgItems",
            "indExe",
            "itemEspectaculo",
            "rutMandante",
            "nmbItem",
            "infoTicket",
            "dscItem",
            "qtyItem",
            "unmdItem",
            "prcItem",
            "descuentoPct",
            "descuentoMonto",
            "recargoPct",
            "recargoMonto",
            "montoItem"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class Detalle
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "NroLinDet", required = true)
            @XmlSchemaType(name = "positiveInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger nroLinDet;
            @XmlElement(name = "CdgItem")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected List<BOLETADefType.Documento.Detalle.CdgItem> cdgItems;
            @XmlElement(name = "IndExe")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger indExe;
            @XmlElement(name = "ItemEspectaculo")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected Integer itemEspectaculo;
            @XmlElement(name = "RUTMandante")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String rutMandante;
            @XmlElement(name = "NmbItem", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String nmbItem;
            @XmlElement(name = "InfoTicket")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.Detalle.InfoTicket infoTicket;
            @XmlElement(name = "DscItem")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String dscItem;
            @XmlElement(name = "QtyItem")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal qtyItem;
            @XmlElement(name = "UnmdItem")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String unmdItem;
            @XmlElement(name = "PrcItem")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal prcItem;
            @XmlElement(name = "DescuentoPct")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal descuentoPct;
            @XmlElement(name = "DescuentoMonto")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger descuentoMonto;
            @XmlElement(name = "RecargoPct")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal recargoPct;
            @XmlElement(name = "RecargoMonto")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger recargoMonto;
            @XmlElement(name = "MontoItem", required = true)
            @XmlSchemaType(name = "nonNegativeInteger")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger montoItem;

            /**
             * Obtiene el valor de la propiedad nroLinDet.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigInteger getNroLinDet() {
                return nroLinDet;
            }

            /**
             * Define el valor de la propiedad nroLinDet.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setNroLinDet(BigInteger value) {
                this.nroLinDet = value;
            }

            /**
             * Gets the value of the cdgItems property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the cdgItems property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCdgItems().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link BOLETADefType.Documento.Detalle.CdgItem }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public List<BOLETADefType.Documento.Detalle.CdgItem> getCdgItems() {
                if (cdgItems == null) {
                    cdgItems = new ArrayList<BOLETADefType.Documento.Detalle.CdgItem>();
                }
                return this.cdgItems;
            }

            /**
             * Obtiene el valor de la propiedad indExe.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigInteger getIndExe() {
                return indExe;
            }

            /**
             * Define el valor de la propiedad indExe.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setIndExe(BigInteger value) {
                this.indExe = value;
            }

            /**
             * Obtiene el valor de la propiedad itemEspectaculo.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public Integer getItemEspectaculo() {
                return itemEspectaculo;
            }

            /**
             * Define el valor de la propiedad itemEspectaculo.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setItemEspectaculo(Integer value) {
                this.itemEspectaculo = value;
            }

            /**
             * Obtiene el valor de la propiedad rutMandante.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getRUTMandante() {
                return rutMandante;
            }

            /**
             * Define el valor de la propiedad rutMandante.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRUTMandante(String value) {
                this.rutMandante = value;
            }

            /**
             * Obtiene el valor de la propiedad nmbItem.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getNmbItem() {
                return nmbItem;
            }

            /**
             * Define el valor de la propiedad nmbItem.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setNmbItem(String value) {
                this.nmbItem = value;
            }

            /**
             * Obtiene el valor de la propiedad infoTicket.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.Detalle.InfoTicket }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.Detalle.InfoTicket getInfoTicket() {
                return infoTicket;
            }

            /**
             * Define el valor de la propiedad infoTicket.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.Detalle.InfoTicket }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setInfoTicket(BOLETADefType.Documento.Detalle.InfoTicket value) {
                this.infoTicket = value;
            }

            /**
             * Obtiene el valor de la propiedad dscItem.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getDscItem() {
                return dscItem;
            }

            /**
             * Define el valor de la propiedad dscItem.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setDscItem(String value) {
                this.dscItem = value;
            }

            /**
             * Obtiene el valor de la propiedad qtyItem.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getQtyItem() {
                return qtyItem;
            }

            /**
             * Define el valor de la propiedad qtyItem.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setQtyItem(BigDecimal value) {
                this.qtyItem = value;
            }

            /**
             * Obtiene el valor de la propiedad unmdItem.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getUnmdItem() {
                return unmdItem;
            }

            /**
             * Define el valor de la propiedad unmdItem.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setUnmdItem(String value) {
                this.unmdItem = value;
            }

            /**
             * Obtiene el valor de la propiedad prcItem.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getPrcItem() {
                return prcItem;
            }

            /**
             * Define el valor de la propiedad prcItem.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setPrcItem(BigDecimal value) {
                this.prcItem = value;
            }

            /**
             * Obtiene el valor de la propiedad descuentoPct.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getDescuentoPct() {
                return descuentoPct;
            }

            /**
             * Define el valor de la propiedad descuentoPct.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setDescuentoPct(BigDecimal value) {
                this.descuentoPct = value;
            }

            /**
             * Obtiene el valor de la propiedad descuentoMonto.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigInteger getDescuentoMonto() {
                return descuentoMonto;
            }

            /**
             * Define el valor de la propiedad descuentoMonto.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setDescuentoMonto(BigInteger value) {
                this.descuentoMonto = value;
            }

            /**
             * Obtiene el valor de la propiedad recargoPct.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getRecargoPct() {
                return recargoPct;
            }

            /**
             * Define el valor de la propiedad recargoPct.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRecargoPct(BigDecimal value) {
                this.recargoPct = value;
            }

            /**
             * Obtiene el valor de la propiedad recargoMonto.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigInteger getRecargoMonto() {
                return recargoMonto;
            }

            /**
             * Define el valor de la propiedad recargoMonto.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRecargoMonto(BigInteger value) {
                this.recargoMonto = value;
            }

            /**
             * Obtiene el valor de la propiedad montoItem.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigInteger getMontoItem() {
                return montoItem;
            }

            /**
             * Define el valor de la propiedad montoItem.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setMontoItem(BigInteger value) {
                this.montoItem = value;
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
             *         &lt;element name="TpoCodigo"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="VlrCodigo"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="35"/&gt;
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
                "tpoCodigo",
                "vlrCodigo"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class CdgItem
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TpoCodigo", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String tpoCodigo;
                @XmlElement(name = "VlrCodigo", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String vlrCodigo;

                /**
                 * Obtiene el valor de la propiedad tpoCodigo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getTpoCodigo() {
                    return tpoCodigo;
                }

                /**
                 * Define el valor de la propiedad tpoCodigo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTpoCodigo(String value) {
                    this.tpoCodigo = value;
                }

                /**
                 * Obtiene el valor de la propiedad vlrCodigo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getVlrCodigo() {
                    return vlrCodigo;
                }

                /**
                 * Define el valor de la propiedad vlrCodigo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setVlrCodigo(String value) {
                    this.vlrCodigo = value;
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
             *         &lt;element name="FolioTicket"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;totalDigits value="6"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="FchGenera"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
             *               &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
             *               &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="NmbEvento"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="80"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="TpoTicket"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="10"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CdgEvento"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="5"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="FchEvento"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}dateTime"&gt;
             *               &lt;minInclusive value="2010-03-10T00:00:00"/&gt;
             *               &lt;maxInclusive value="2050-12-31T23:59:59"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="LugarEvento"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="80"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="UbicEvento"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="FilaUbicEvento" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="3"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="AsntoUbicEvento" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
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
                "folioTicket",
                "fchGenera",
                "nmbEvento",
                "tpoTicket",
                "cdgEvento",
                "fchEvento",
                "lugarEvento",
                "ubicEvento",
                "filaUbicEvento",
                "asntoUbicEvento"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class InfoTicket
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "FolioTicket", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger folioTicket;
                @XmlElement(name = "FchGenera", required = true, type = String.class)
                @XmlJavaTypeAdapter(DateTimeAdapter.class)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date fchGenera;
                @XmlElement(name = "NmbEvento", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String nmbEvento;
                @XmlElement(name = "TpoTicket", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String tpoTicket;
                @XmlElement(name = "CdgEvento", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String cdgEvento;
                @XmlElement(name = "FchEvento", required = true, type = String.class)
                @XmlJavaTypeAdapter(DateTimeAdapter.class)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date fchEvento;
                @XmlElement(name = "LugarEvento", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String lugarEvento;
                @XmlElement(name = "UbicEvento", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String ubicEvento;
                @XmlElement(name = "FilaUbicEvento")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String filaUbicEvento;
                @XmlElement(name = "AsntoUbicEvento")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String asntoUbicEvento;

                /**
                 * Obtiene el valor de la propiedad folioTicket.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getFolioTicket() {
                    return folioTicket;
                }

                /**
                 * Define el valor de la propiedad folioTicket.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFolioTicket(BigInteger value) {
                    this.folioTicket = value;
                }

                /**
                 * Obtiene el valor de la propiedad fchGenera.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public Date getFchGenera() {
                    return fchGenera;
                }

                /**
                 * Define el valor de la propiedad fchGenera.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFchGenera(Date value) {
                    this.fchGenera = value;
                }

                /**
                 * Obtiene el valor de la propiedad nmbEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getNmbEvento() {
                    return nmbEvento;
                }

                /**
                 * Define el valor de la propiedad nmbEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setNmbEvento(String value) {
                    this.nmbEvento = value;
                }

                /**
                 * Obtiene el valor de la propiedad tpoTicket.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getTpoTicket() {
                    return tpoTicket;
                }

                /**
                 * Define el valor de la propiedad tpoTicket.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTpoTicket(String value) {
                    this.tpoTicket = value;
                }

                /**
                 * Obtiene el valor de la propiedad cdgEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCdgEvento() {
                    return cdgEvento;
                }

                /**
                 * Define el valor de la propiedad cdgEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCdgEvento(String value) {
                    this.cdgEvento = value;
                }

                /**
                 * Obtiene el valor de la propiedad fchEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public Date getFchEvento() {
                    return fchEvento;
                }

                /**
                 * Define el valor de la propiedad fchEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFchEvento(Date value) {
                    this.fchEvento = value;
                }

                /**
                 * Obtiene el valor de la propiedad lugarEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getLugarEvento() {
                    return lugarEvento;
                }

                /**
                 * Define el valor de la propiedad lugarEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setLugarEvento(String value) {
                    this.lugarEvento = value;
                }

                /**
                 * Obtiene el valor de la propiedad ubicEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getUbicEvento() {
                    return ubicEvento;
                }

                /**
                 * Define el valor de la propiedad ubicEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setUbicEvento(String value) {
                    this.ubicEvento = value;
                }

                /**
                 * Obtiene el valor de la propiedad filaUbicEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getFilaUbicEvento() {
                    return filaUbicEvento;
                }

                /**
                 * Define el valor de la propiedad filaUbicEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFilaUbicEvento(String value) {
                    this.filaUbicEvento = value;
                }

                /**
                 * Obtiene el valor de la propiedad asntoUbicEvento.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getAsntoUbicEvento() {
                    return asntoUbicEvento;
                }

                /**
                 * Define el valor de la propiedad asntoUbicEvento.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setAsntoUbicEvento(String value) {
                    this.asntoUbicEvento = value;
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
         *         &lt;element name="NroLinDR"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;maxInclusive value="99"/&gt;
         *               &lt;minInclusive value="1"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TpoMov"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="D"/&gt;
         *               &lt;enumeration value="R"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="GlosaDR" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="45"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TpoValor"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;enumeration value="%"/&gt;
         *               &lt;enumeration value="$"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="ValorDR" type="{}Dec1Type"/&gt;
         *         &lt;element name="IndExeDR" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;enumeration value="1"/&gt;
         *               &lt;enumeration value="2"/&gt;
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
            "nroLinDR",
            "tpoMov",
            "glosaDR",
            "tpoValor",
            "valorDR",
            "indExeDR"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class DscRcgGlobal
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "NroLinDR")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected int nroLinDR;
            @XmlElement(name = "TpoMov", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String tpoMov;
            @XmlElement(name = "GlosaDR")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String glosaDR;
            @XmlElement(name = "TpoValor", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String tpoValor;
            @XmlElement(name = "ValorDR", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal valorDR;
            @XmlElement(name = "IndExeDR")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigInteger indExeDR;

            /**
             * Obtiene el valor de la propiedad nroLinDR.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public int getNroLinDR() {
                return nroLinDR;
            }

            /**
             * Define el valor de la propiedad nroLinDR.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setNroLinDR(int value) {
                this.nroLinDR = value;
            }

            /**
             * Obtiene el valor de la propiedad tpoMov.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getTpoMov() {
                return tpoMov;
            }

            /**
             * Define el valor de la propiedad tpoMov.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setTpoMov(String value) {
                this.tpoMov = value;
            }

            /**
             * Obtiene el valor de la propiedad glosaDR.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getGlosaDR() {
                return glosaDR;
            }

            /**
             * Define el valor de la propiedad glosaDR.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setGlosaDR(String value) {
                this.glosaDR = value;
            }

            /**
             * Obtiene el valor de la propiedad tpoValor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getTpoValor() {
                return tpoValor;
            }

            /**
             * Define el valor de la propiedad tpoValor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setTpoValor(String value) {
                this.tpoValor = value;
            }

            /**
             * Obtiene el valor de la propiedad valorDR.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getValorDR() {
                return valorDR;
            }

            /**
             * Define el valor de la propiedad valorDR.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setValorDR(BigDecimal value) {
                this.valorDR = value;
            }

            /**
             * Obtiene el valor de la propiedad indExeDR.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigInteger getIndExeDR() {
                return indExeDR;
            }

            /**
             * Define el valor de la propiedad indExeDR.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setIndExeDR(BigInteger value) {
                this.indExeDR = value;
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
         *         &lt;element name="IdDoc"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *                   &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                   &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="IndServicio"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *                         &lt;enumeration value="1"/&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                         &lt;enumeration value="3"/&gt;
         *                         &lt;enumeration value="4"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="IndMntNeto" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
         *                         &lt;enumeration value="2"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *                   &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *                   &lt;element name="FchVenc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Emisor"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="RznSocEmisor" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="100"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="GiroEmisor" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="80"/&gt;
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
         *                   &lt;element name="DirOrigen" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="70"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CmnaOrigen" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CiudadOrigen" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Receptor"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="CdgIntRecep" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="RznSocRecep" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="100"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="Contacto" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="80"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="DirRecep" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="70"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CmnaRecep" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CiudadRecep" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="DirPostal" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="70"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CmnaPostal" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CiudadPostal" minOccurs="0"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="20"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="Totales"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="IVA" type="{http://www.sii.cl/SiiDte}MntImpType" minOccurs="0"/&gt;
         *                   &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
         *                   &lt;element name="MontoNF" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="TotalPeriodo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
         *                   &lt;element name="SaldoAnterior" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
         *                   &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
            "idDoc",
            "emisor",
            "receptor",
            "totales"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class Encabezado
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "IdDoc", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.Encabezado.IdDoc idDoc;
            @XmlElement(name = "Emisor", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.Encabezado.Emisor emisor;
            @XmlElement(name = "Receptor", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.Encabezado.Receptor receptor;
            @XmlElement(name = "Totales", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.Encabezado.Totales totales;

            /**
             * Obtiene el valor de la propiedad idDoc.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.Encabezado.IdDoc }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.Encabezado.IdDoc getIdDoc() {
                return idDoc;
            }

            /**
             * Define el valor de la propiedad idDoc.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.Encabezado.IdDoc }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setIdDoc(BOLETADefType.Documento.Encabezado.IdDoc value) {
                this.idDoc = value;
            }

            /**
             * Obtiene el valor de la propiedad emisor.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.Encabezado.Emisor }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.Encabezado.Emisor getEmisor() {
                return emisor;
            }

            /**
             * Define el valor de la propiedad emisor.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.Encabezado.Emisor }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setEmisor(BOLETADefType.Documento.Encabezado.Emisor value) {
                this.emisor = value;
            }

            /**
             * Obtiene el valor de la propiedad receptor.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.Encabezado.Receptor }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.Encabezado.Receptor getReceptor() {
                return receptor;
            }

            /**
             * Define el valor de la propiedad receptor.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.Encabezado.Receptor }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setReceptor(BOLETADefType.Documento.Encabezado.Receptor value) {
                this.receptor = value;
            }

            /**
             * Obtiene el valor de la propiedad totales.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.Encabezado.Totales }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.Encabezado.Totales getTotales() {
                return totales;
            }

            /**
             * Define el valor de la propiedad totales.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.Encabezado.Totales }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setTotales(BOLETADefType.Documento.Encabezado.Totales value) {
                this.totales = value;
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
             *         &lt;element name="RUTEmisor" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
             *         &lt;element name="RznSocEmisor" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="100"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="GiroEmisor" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="80"/&gt;
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
             *         &lt;element name="DirOrigen" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="70"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CmnaOrigen" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CiudadOrigen" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
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
                "rutEmisor",
                "rznSocEmisor",
                "giroEmisor",
                "cdgSIISucur",
                "dirOrigen",
                "cmnaOrigen",
                "ciudadOrigen"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class Emisor
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "RUTEmisor", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String rutEmisor;
                @XmlElement(name = "RznSocEmisor")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String rznSocEmisor;
                @XmlElement(name = "GiroEmisor")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String giroEmisor;
                @XmlElement(name = "CdgSIISucur")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger cdgSIISucur;
                @XmlElement(name = "DirOrigen")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String dirOrigen;
                @XmlElement(name = "CmnaOrigen")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String cmnaOrigen;
                @XmlElement(name = "CiudadOrigen")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String ciudadOrigen;

                /**
                 * Obtiene el valor de la propiedad rutEmisor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getRUTEmisor() {
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
                public void setRUTEmisor(String value) {
                    this.rutEmisor = value;
                }

                /**
                 * Obtiene el valor de la propiedad rznSocEmisor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getRznSocEmisor() {
                    return rznSocEmisor;
                }

                /**
                 * Define el valor de la propiedad rznSocEmisor.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setRznSocEmisor(String value) {
                    this.rznSocEmisor = value;
                }

                /**
                 * Obtiene el valor de la propiedad giroEmisor.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getGiroEmisor() {
                    return giroEmisor;
                }

                /**
                 * Define el valor de la propiedad giroEmisor.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setGiroEmisor(String value) {
                    this.giroEmisor = value;
                }

                /**
                 * Obtiene el valor de la propiedad cdgSIISucur.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCdgSIISucur(BigInteger value) {
                    this.cdgSIISucur = value;
                }

                /**
                 * Obtiene el valor de la propiedad dirOrigen.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getDirOrigen() {
                    return dirOrigen;
                }

                /**
                 * Define el valor de la propiedad dirOrigen.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setDirOrigen(String value) {
                    this.dirOrigen = value;
                }

                /**
                 * Obtiene el valor de la propiedad cmnaOrigen.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCmnaOrigen() {
                    return cmnaOrigen;
                }

                /**
                 * Define el valor de la propiedad cmnaOrigen.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCmnaOrigen(String value) {
                    this.cmnaOrigen = value;
                }

                /**
                 * Obtiene el valor de la propiedad ciudadOrigen.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCiudadOrigen() {
                    return ciudadOrigen;
                }

                /**
                 * Define el valor de la propiedad ciudadOrigen.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCiudadOrigen(String value) {
                    this.ciudadOrigen = value;
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
             *         &lt;element name="TipoDTE" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
             *         &lt;element name="Folio" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
             *         &lt;element name="FchEmis" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="IndServicio"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
             *               &lt;enumeration value="1"/&gt;
             *               &lt;enumeration value="2"/&gt;
             *               &lt;enumeration value="3"/&gt;
             *               &lt;enumeration value="4"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="IndMntNeto" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer"&gt;
             *               &lt;enumeration value="2"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="PeriodoDesde" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
             *         &lt;element name="PeriodoHasta" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
             *         &lt;element name="FchVenc" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
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
                "tipoDTE",
                "folio",
                "fchEmis",
                "indServicio",
                "indMntNeto",
                "periodoDesde",
                "periodoHasta",
                "fchVenc"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class IdDoc
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "TipoDTE", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger tipoDTE;
                @XmlElement(name = "Folio", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger folio;
                @XmlElement(name = "FchEmis", required = true, type = String.class)
                @XmlJavaTypeAdapter(DateAdapter.class)
                @XmlSchemaType(name = "date")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date fchEmis;
                @XmlElement(name = "IndServicio", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger indServicio;
                @XmlElement(name = "IndMntNeto")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger indMntNeto;
                @XmlElement(name = "PeriodoDesde", type = String.class)
                @XmlJavaTypeAdapter(DateAdapter.class)
                @XmlSchemaType(name = "date")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date periodoDesde;
                @XmlElement(name = "PeriodoHasta", type = String.class)
                @XmlJavaTypeAdapter(DateAdapter.class)
                @XmlSchemaType(name = "date")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date periodoHasta;
                @XmlElement(name = "FchVenc", type = String.class)
                @XmlJavaTypeAdapter(DateAdapter.class)
                @XmlSchemaType(name = "date")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date fchVenc;

                /**
                 * Obtiene el valor de la propiedad tipoDTE.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getTipoDTE() {
                    return tipoDTE;
                }

                /**
                 * Define el valor de la propiedad tipoDTE.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTipoDTE(BigInteger value) {
                    this.tipoDTE = value;
                }

                /**
                 * Obtiene el valor de la propiedad folio.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getFolio() {
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFolio(BigInteger value) {
                    this.folio = value;
                }

                /**
                 * Obtiene el valor de la propiedad fchEmis.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public Date getFchEmis() {
                    return fchEmis;
                }

                /**
                 * Define el valor de la propiedad fchEmis.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFchEmis(Date value) {
                    this.fchEmis = value;
                }

                /**
                 * Obtiene el valor de la propiedad indServicio.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setIndServicio(BigInteger value) {
                    this.indServicio = value;
                }

                /**
                 * Obtiene el valor de la propiedad indMntNeto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getIndMntNeto() {
                    return indMntNeto;
                }

                /**
                 * Define el valor de la propiedad indMntNeto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setIndMntNeto(BigInteger value) {
                    this.indMntNeto = value;
                }

                /**
                 * Obtiene el valor de la propiedad periodoDesde.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setPeriodoHasta(Date value) {
                    this.periodoHasta = value;
                }

                /**
                 * Obtiene el valor de la propiedad fchVenc.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public Date getFchVenc() {
                    return fchVenc;
                }

                /**
                 * Define el valor de la propiedad fchVenc.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFchVenc(Date value) {
                    this.fchVenc = value;
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
             *         &lt;element name="RUTRecep" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
             *         &lt;element name="CdgIntRecep" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="RznSocRecep" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="100"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="Contacto" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="80"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="DirRecep" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="70"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CmnaRecep" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CiudadRecep" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="DirPostal" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="70"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CmnaPostal" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="CiudadPostal" minOccurs="0"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="20"/&gt;
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
                "rutRecep",
                "cdgIntRecep",
                "rznSocRecep",
                "contacto",
                "dirRecep",
                "cmnaRecep",
                "ciudadRecep",
                "dirPostal",
                "cmnaPostal",
                "ciudadPostal"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class Receptor
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "RUTRecep", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String rutRecep;
                @XmlElement(name = "CdgIntRecep")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String cdgIntRecep;
                @XmlElement(name = "RznSocRecep")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String rznSocRecep;
                @XmlElement(name = "Contacto")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String contacto;
                @XmlElement(name = "DirRecep")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String dirRecep;
                @XmlElement(name = "CmnaRecep")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String cmnaRecep;
                @XmlElement(name = "CiudadRecep")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String ciudadRecep;
                @XmlElement(name = "DirPostal")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String dirPostal;
                @XmlElement(name = "CmnaPostal")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String cmnaPostal;
                @XmlElement(name = "CiudadPostal")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String ciudadPostal;

                /**
                 * Obtiene el valor de la propiedad rutRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getRUTRecep() {
                    return rutRecep;
                }

                /**
                 * Define el valor de la propiedad rutRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setRUTRecep(String value) {
                    this.rutRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad cdgIntRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCdgIntRecep() {
                    return cdgIntRecep;
                }

                /**
                 * Define el valor de la propiedad cdgIntRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCdgIntRecep(String value) {
                    this.cdgIntRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad rznSocRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getRznSocRecep() {
                    return rznSocRecep;
                }

                /**
                 * Define el valor de la propiedad rznSocRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setRznSocRecep(String value) {
                    this.rznSocRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad contacto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getContacto() {
                    return contacto;
                }

                /**
                 * Define el valor de la propiedad contacto.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setContacto(String value) {
                    this.contacto = value;
                }

                /**
                 * Obtiene el valor de la propiedad dirRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getDirRecep() {
                    return dirRecep;
                }

                /**
                 * Define el valor de la propiedad dirRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setDirRecep(String value) {
                    this.dirRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad cmnaRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCmnaRecep() {
                    return cmnaRecep;
                }

                /**
                 * Define el valor de la propiedad cmnaRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCmnaRecep(String value) {
                    this.cmnaRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad ciudadRecep.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCiudadRecep() {
                    return ciudadRecep;
                }

                /**
                 * Define el valor de la propiedad ciudadRecep.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCiudadRecep(String value) {
                    this.ciudadRecep = value;
                }

                /**
                 * Obtiene el valor de la propiedad dirPostal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getDirPostal() {
                    return dirPostal;
                }

                /**
                 * Define el valor de la propiedad dirPostal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setDirPostal(String value) {
                    this.dirPostal = value;
                }

                /**
                 * Obtiene el valor de la propiedad cmnaPostal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCmnaPostal() {
                    return cmnaPostal;
                }

                /**
                 * Define el valor de la propiedad cmnaPostal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCmnaPostal(String value) {
                    this.cmnaPostal = value;
                }

                /**
                 * Obtiene el valor de la propiedad ciudadPostal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getCiudadPostal() {
                    return ciudadPostal;
                }

                /**
                 * Define el valor de la propiedad ciudadPostal.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCiudadPostal(String value) {
                    this.ciudadPostal = value;
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
             *         &lt;element name="MntNeto" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="MntExe" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="IVA" type="{http://www.sii.cl/SiiDte}MntImpType" minOccurs="0"/&gt;
             *         &lt;element name="MntTotal" type="{http://www.sii.cl/SiiDte}MontoType"/&gt;
             *         &lt;element name="MontoNF" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="TotalPeriodo" type="{http://www.sii.cl/SiiDte}MontoType" minOccurs="0"/&gt;
             *         &lt;element name="SaldoAnterior" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
             *         &lt;element name="VlrPagar" type="{http://www.sii.cl/SiiDte}ValorType" minOccurs="0"/&gt;
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
                "mntNeto",
                "mntExe",
                "iva",
                "mntTotal",
                "montoNF",
                "totalPeriodo",
                "saldoAnterior",
                "vlrPagar"
            })
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class Totales
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "MntNeto")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger mntNeto;
                @XmlElement(name = "MntExe")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger mntExe;
                @XmlElement(name = "IVA")
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger iva;
                @XmlElement(name = "MntTotal", required = true)
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger mntTotal;
                @XmlElement(name = "MontoNF")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger montoNF;
                @XmlElement(name = "TotalPeriodo")
                @XmlSchemaType(name = "nonNegativeInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger totalPeriodo;
                @XmlElement(name = "SaldoAnterior")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger saldoAnterior;
                @XmlElement(name = "VlrPagar")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger vlrPagar;

                /**
                 * Obtiene el valor de la propiedad mntNeto.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setMntNeto(BigInteger value) {
                    this.mntNeto = value;
                }

                /**
                 * Obtiene el valor de la propiedad mntExe.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setMntExe(BigInteger value) {
                    this.mntExe = value;
                }

                /**
                 * Obtiene el valor de la propiedad iva.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getIVA() {
                    return iva;
                }

                /**
                 * Define el valor de la propiedad iva.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setIVA(BigInteger value) {
                    this.iva = value;
                }

                /**
                 * Obtiene el valor de la propiedad mntTotal.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setMntTotal(BigInteger value) {
                    this.mntTotal = value;
                }

                /**
                 * Obtiene el valor de la propiedad montoNF.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getMontoNF() {
                    return montoNF;
                }

                /**
                 * Define el valor de la propiedad montoNF.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setMontoNF(BigInteger value) {
                    this.montoNF = value;
                }

                /**
                 * Obtiene el valor de la propiedad totalPeriodo.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getTotalPeriodo() {
                    return totalPeriodo;
                }

                /**
                 * Define el valor de la propiedad totalPeriodo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTotalPeriodo(BigInteger value) {
                    this.totalPeriodo = value;
                }

                /**
                 * Obtiene el valor de la propiedad saldoAnterior.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getSaldoAnterior() {
                    return saldoAnterior;
                }

                /**
                 * Define el valor de la propiedad saldoAnterior.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setSaldoAnterior(BigInteger value) {
                    this.saldoAnterior = value;
                }

                /**
                 * Obtiene el valor de la propiedad vlrPagar.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setVlrPagar(BigInteger value) {
                    this.vlrPagar = value;
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
         *         &lt;element name="NroLinRef"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;maxInclusive value="40"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="TpoDocRef" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="3"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FolioRef" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CodRef" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="18"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="RazonRef" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="90"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CodVndor" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="8"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="CodCaja" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="8"/&gt;
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
            "nroLinRef",
            "tpoDocRef",
            "folioRef",
            "codRef",
            "razonRef",
            "codVndor",
            "codCaja"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class Referencia
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "NroLinRef")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected int nroLinRef;
            @XmlElement(name = "TpoDocRef")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String tpoDocRef;
            @XmlElement(name = "FolioRef")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String folioRef;
            @XmlElement(name = "CodRef")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String codRef;
            @XmlElement(name = "RazonRef")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String razonRef;
            @XmlElement(name = "CodVndor")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String codVndor;
            @XmlElement(name = "CodCaja")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String codCaja;

            /**
             * Obtiene el valor de la propiedad nroLinRef.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public int getNroLinRef() {
                return nroLinRef;
            }

            /**
             * Define el valor de la propiedad nroLinRef.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setNroLinRef(int value) {
                this.nroLinRef = value;
            }

            /**
             * Obtiene el valor de la propiedad tpoDocRef.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getTpoDocRef() {
                return tpoDocRef;
            }

            /**
             * Define el valor de la propiedad tpoDocRef.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setTpoDocRef(String value) {
                this.tpoDocRef = value;
            }

            /**
             * Obtiene el valor de la propiedad folioRef.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getFolioRef() {
                return folioRef;
            }

            /**
             * Define el valor de la propiedad folioRef.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setFolioRef(String value) {
                this.folioRef = value;
            }

            /**
             * Obtiene el valor de la propiedad codRef.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getCodRef() {
                return codRef;
            }

            /**
             * Define el valor de la propiedad codRef.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setCodRef(String value) {
                this.codRef = value;
            }

            /**
             * Obtiene el valor de la propiedad razonRef.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getRazonRef() {
                return razonRef;
            }

            /**
             * Define el valor de la propiedad razonRef.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setRazonRef(String value) {
                this.razonRef = value;
            }

            /**
             * Obtiene el valor de la propiedad codVndor.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getCodVndor() {
                return codVndor;
            }

            /**
             * Define el valor de la propiedad codVndor.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setCodVndor(String value) {
                this.codVndor = value;
            }

            /**
             * Obtiene el valor de la propiedad codCaja.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getCodCaja() {
                return codCaja;
            }

            /**
             * Define el valor de la propiedad codCaja.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setCodCaja(String value) {
                this.codCaja = value;
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
         *         &lt;element name="NroSTI"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;maxInclusive value="99"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="GlosaSTI" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *               &lt;maxLength value="80"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="OrdenSTI" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;maxInclusive value="99"/&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="SubTotNetoSTI" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{}Dec1Type"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="SubTotIVASTI" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{}Dec1Type"&gt;
         *             &lt;/restriction&gt;
         *           &lt;/simpleType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="SubTotAdicSTI" type="{}Dec1Type" minOccurs="0"/&gt;
         *         &lt;element name="SubTotExeSTI" type="{}Dec1Type" minOccurs="0"/&gt;
         *         &lt;element name="ValSubtotSTI" type="{}Dec1Type" minOccurs="0"/&gt;
         *         &lt;element name="LineasDeta" maxOccurs="1000" minOccurs="0"&gt;
         *           &lt;simpleType&gt;
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger"&gt;
         *               &lt;maxInclusive value="1000"/&gt;
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
            "nroSTI",
            "glosaSTI",
            "ordenSTI",
            "subTotNetoSTI",
            "subTotIVASTI",
            "subTotAdicSTI",
            "subTotExeSTI",
            "valSubtotSTI",
            "lineasDetas"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class SubTotInfo
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "NroSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected int nroSTI;
            @XmlElement(name = "GlosaSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String glosaSTI;
            @XmlElement(name = "OrdenSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected Integer ordenSTI;
            @XmlElement(name = "SubTotNetoSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal subTotNetoSTI;
            @XmlElement(name = "SubTotIVASTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal subTotIVASTI;
            @XmlElement(name = "SubTotAdicSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal subTotAdicSTI;
            @XmlElement(name = "SubTotExeSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal subTotExeSTI;
            @XmlElement(name = "ValSubtotSTI")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BigDecimal valSubtotSTI;
            @XmlElement(name = "LineasDeta", type = Integer.class)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected List<Integer> lineasDetas;

            /**
             * Obtiene el valor de la propiedad nroSTI.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public int getNroSTI() {
                return nroSTI;
            }

            /**
             * Define el valor de la propiedad nroSTI.
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setNroSTI(int value) {
                this.nroSTI = value;
            }

            /**
             * Obtiene el valor de la propiedad glosaSTI.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public String getGlosaSTI() {
                return glosaSTI;
            }

            /**
             * Define el valor de la propiedad glosaSTI.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setGlosaSTI(String value) {
                this.glosaSTI = value;
            }

            /**
             * Obtiene el valor de la propiedad ordenSTI.
             * 
             * @return
             *     possible object is
             *     {@link Integer }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public Integer getOrdenSTI() {
                return ordenSTI;
            }

            /**
             * Define el valor de la propiedad ordenSTI.
             * 
             * @param value
             *     allowed object is
             *     {@link Integer }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setOrdenSTI(Integer value) {
                this.ordenSTI = value;
            }

            /**
             * Obtiene el valor de la propiedad subTotNetoSTI.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getSubTotNetoSTI() {
                return subTotNetoSTI;
            }

            /**
             * Define el valor de la propiedad subTotNetoSTI.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setSubTotNetoSTI(BigDecimal value) {
                this.subTotNetoSTI = value;
            }

            /**
             * Obtiene el valor de la propiedad subTotIVASTI.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getSubTotIVASTI() {
                return subTotIVASTI;
            }

            /**
             * Define el valor de la propiedad subTotIVASTI.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setSubTotIVASTI(BigDecimal value) {
                this.subTotIVASTI = value;
            }

            /**
             * Obtiene el valor de la propiedad subTotAdicSTI.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getSubTotAdicSTI() {
                return subTotAdicSTI;
            }

            /**
             * Define el valor de la propiedad subTotAdicSTI.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setSubTotAdicSTI(BigDecimal value) {
                this.subTotAdicSTI = value;
            }

            /**
             * Obtiene el valor de la propiedad subTotExeSTI.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getSubTotExeSTI() {
                return subTotExeSTI;
            }

            /**
             * Define el valor de la propiedad subTotExeSTI.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setSubTotExeSTI(BigDecimal value) {
                this.subTotExeSTI = value;
            }

            /**
             * Obtiene el valor de la propiedad valSubtotSTI.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BigDecimal getValSubtotSTI() {
                return valSubtotSTI;
            }

            /**
             * Define el valor de la propiedad valSubtotSTI.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setValSubtotSTI(BigDecimal value) {
                this.valSubtotSTI = value;
            }

            /**
             * Gets the value of the lineasDetas property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the lineasDetas property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getLineasDetas().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Integer }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public List<Integer> getLineasDetas() {
                if (lineasDetas == null) {
                    lineasDetas = new ArrayList<Integer>();
                }
                return this.lineasDetas;
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
         *         &lt;element name="DD"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *                   &lt;element name="F" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                   &lt;element name="FE" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                   &lt;element name="RR" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                   &lt;element name="RSR"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="40"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="MNT" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/&gt;
         *                   &lt;element name="IT1"&gt;
         *                     &lt;simpleType&gt;
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                         &lt;maxLength value="40"/&gt;
         *                       &lt;/restriction&gt;
         *                     &lt;/simpleType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="CAF"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element name="DA"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;complexContent&gt;
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                     &lt;sequence&gt;
         *                                       &lt;element name="RE" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
         *                                       &lt;element name="RS"&gt;
         *                                         &lt;simpleType&gt;
         *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                                             &lt;maxLength value="40"/&gt;
         *                                           &lt;/restriction&gt;
         *                                         &lt;/simpleType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
         *                                       &lt;element name="RNG"&gt;
         *                                         &lt;complexType&gt;
         *                                           &lt;complexContent&gt;
         *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                               &lt;sequence&gt;
         *                                                 &lt;element name="D" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                                                 &lt;element name="H" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
         *                                               &lt;/sequence&gt;
         *                                             &lt;/restriction&gt;
         *                                           &lt;/complexContent&gt;
         *                                         &lt;/complexType&gt;
         *                                       &lt;/element&gt;
         *                                       &lt;element name="FA" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
         *                                       &lt;choice&gt;
         *                                         &lt;element name="RSAPK"&gt;
         *                                           &lt;complexType&gt;
         *                                             &lt;complexContent&gt;
         *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                 &lt;sequence&gt;
         *                                                   &lt;element name="M" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                                                   &lt;element name="E" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                                                 &lt;/sequence&gt;
         *                                               &lt;/restriction&gt;
         *                                             &lt;/complexContent&gt;
         *                                           &lt;/complexType&gt;
         *                                         &lt;/element&gt;
         *                                         &lt;element name="DSAPK"&gt;
         *                                           &lt;complexType&gt;
         *                                             &lt;complexContent&gt;
         *                                               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                                                 &lt;sequence&gt;
         *                                                   &lt;element name="P" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                                                   &lt;element name="Q" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                                                   &lt;element name="G" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                                                   &lt;element name="Y" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
         *                                                 &lt;/sequence&gt;
         *                                               &lt;/restriction&gt;
         *                                             &lt;/complexContent&gt;
         *                                           &lt;/complexType&gt;
         *                                         &lt;/element&gt;
         *                                       &lt;/choice&gt;
         *                                       &lt;element name="IDK" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
         *                                     &lt;/sequence&gt;
         *                                   &lt;/restriction&gt;
         *                                 &lt;/complexContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                             &lt;element name="FRMA"&gt;
         *                               &lt;complexType&gt;
         *                                 &lt;simpleContent&gt;
         *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
         *                                     &lt;attribute name="algoritmo" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="SHA1withRSA" /&gt;
         *                                   &lt;/extension&gt;
         *                                 &lt;/simpleContent&gt;
         *                               &lt;/complexType&gt;
         *                             &lt;/element&gt;
         *                           &lt;/sequence&gt;
         *                           &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="1.0" /&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
         *                   &lt;element name="TSTED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
         *                 &lt;/sequence&gt;
         *               &lt;/restriction&gt;
         *             &lt;/complexContent&gt;
         *           &lt;/complexType&gt;
         *         &lt;/element&gt;
         *         &lt;element name="FRMT"&gt;
         *           &lt;complexType&gt;
         *             &lt;simpleContent&gt;
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
         *                 &lt;attribute name="algoritmo" use="required"&gt;
         *                   &lt;simpleType&gt;
         *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
         *                       &lt;enumeration value="SHA1withRSA"/&gt;
         *                       &lt;enumeration value="SHA1withDSA"/&gt;
         *                     &lt;/restriction&gt;
         *                   &lt;/simpleType&gt;
         *                 &lt;/attribute&gt;
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
            "dd",
            "frmt"
        })
        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
        public static class TED
            implements Serializable
        {

            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            private final static long serialVersionUID = -1L;
            @XmlElement(name = "DD", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.TED.DD dd;
            @XmlElement(name = "FRMT", required = true)
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected BOLETADefType.Documento.TED.FRMT frmt;
            @XmlAttribute(name = "version", required = true)
            @XmlSchemaType(name = "anySimpleType")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            protected String version;

            /**
             * Obtiene el valor de la propiedad dd.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.TED.DD }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.TED.DD getDD() {
                return dd;
            }

            /**
             * Define el valor de la propiedad dd.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.TED.DD }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setDD(BOLETADefType.Documento.TED.DD value) {
                this.dd = value;
            }

            /**
             * Obtiene el valor de la propiedad frmt.
             * 
             * @return
             *     possible object is
             *     {@link BOLETADefType.Documento.TED.FRMT }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public BOLETADefType.Documento.TED.FRMT getFRMT() {
                return frmt;
            }

            /**
             * Define el valor de la propiedad frmt.
             * 
             * @param value
             *     allowed object is
             *     {@link BOLETADefType.Documento.TED.FRMT }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public void setFRMT(BOLETADefType.Documento.TED.FRMT value) {
                this.frmt = value;
            }

            /**
             * Obtiene el valor de la propiedad version.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
             *         &lt;element name="TD" type="{http://www.sii.cl/SiiDte}DTEType"/&gt;
             *         &lt;element name="F" type="{http://www.sii.cl/SiiDte}FolioType"/&gt;
             *         &lt;element name="FE" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
             *         &lt;element name="RR" type="{http://www.sii.cl/SiiDte}RUTType"/&gt;
             *         &lt;element name="RSR"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="40"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
             *         &lt;element name="MNT" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/&gt;
             *         &lt;element name="IT1"&gt;
             *           &lt;simpleType&gt;
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *               &lt;maxLength value="40"/&gt;
             *             &lt;/restriction&gt;
             *           &lt;/simpleType&gt;
             *         &lt;/element&gt;
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
             *         &lt;element name="TSTED" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
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
                "td",
                "f",
                "fe",
                "rr",
                "rsr",
                "mnt",
                "it1",
                "caf",
                "tsted"
            })
            @XmlRootElement(name = "DD")
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class DD
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlElement(name = "RE", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String re;
                @XmlElement(name = "TD", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger td;
                @XmlElement(name = "F", required = true)
                @XmlSchemaType(name = "positiveInteger")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger f;
                @XmlElement(name = "FE", required = true, type = String.class)
                @XmlJavaTypeAdapter(DateAdapter.class)
                @XmlSchemaType(name = "date")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date fe;
                @XmlElement(name = "RR", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String rr;
                @XmlElement(name = "RSR", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String rsr;
                @XmlElement(name = "MNT", required = true)
                @XmlSchemaType(name = "unsignedLong")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BigInteger mnt;
                @XmlElement(name = "IT1", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String it1;
                @XmlElement(name = "CAF", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected BOLETADefType.Documento.TED.DD.CAF caf;
                @XmlElement(name = "TSTED", required = true, type = String.class)
                @XmlJavaTypeAdapter(DateTimeAdapter.class)
                @XmlSchemaType(name = "dateTime")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected Date tsted;

                /**
                 * Obtiene el valor de la propiedad re.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setRE(String value) {
                    this.re = value;
                }

                /**
                 * Obtiene el valor de la propiedad td.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTD(BigInteger value) {
                    this.td = value;
                }

                /**
                 * Obtiene el valor de la propiedad f.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getF() {
                    return f;
                }

                /**
                 * Define el valor de la propiedad f.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setF(BigInteger value) {
                    this.f = value;
                }

                /**
                 * Obtiene el valor de la propiedad fe.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public Date getFE() {
                    return fe;
                }

                /**
                 * Define el valor de la propiedad fe.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setFE(Date value) {
                    this.fe = value;
                }

                /**
                 * Obtiene el valor de la propiedad rr.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getRR() {
                    return rr;
                }

                /**
                 * Define el valor de la propiedad rr.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setRR(String value) {
                    this.rr = value;
                }

                /**
                 * Obtiene el valor de la propiedad rsr.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getRSR() {
                    return rsr;
                }

                /**
                 * Define el valor de la propiedad rsr.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setRSR(String value) {
                    this.rsr = value;
                }

                /**
                 * Obtiene el valor de la propiedad mnt.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BigInteger getMNT() {
                    return mnt;
                }

                /**
                 * Define el valor de la propiedad mnt.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BigInteger }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setMNT(BigInteger value) {
                    this.mnt = value;
                }

                /**
                 * Obtiene el valor de la propiedad it1.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getIT1() {
                    return it1;
                }

                /**
                 * Define el valor de la propiedad it1.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setIT1(String value) {
                    this.it1 = value;
                }

                /**
                 * Obtiene el valor de la propiedad caf.
                 * 
                 * @return
                 *     possible object is
                 *     {@link BOLETADefType.Documento.TED.DD.CAF }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public BOLETADefType.Documento.TED.DD.CAF getCAF() {
                    return caf;
                }

                /**
                 * Define el valor de la propiedad caf.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link BOLETADefType.Documento.TED.DD.CAF }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setCAF(BOLETADefType.Documento.TED.DD.CAF value) {
                    this.caf = value;
                }

                /**
                 * Obtiene el valor de la propiedad tsted.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public Date getTSTED() {
                    return tsted;
                }

                /**
                 * Define el valor de la propiedad tsted.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setTSTED(Date value) {
                    this.tsted = value;
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public static class CAF
                    implements Serializable
                {

                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    private final static long serialVersionUID = -1L;
                    @XmlElement(name = "DA", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    protected BOLETADefType.Documento.TED.DD.CAF.DA da;
                    @XmlElement(name = "FRMA", required = true)
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    protected BOLETADefType.Documento.TED.DD.CAF.FRMA frma;
                    @XmlAttribute(name = "version", required = true)
                    @XmlSchemaType(name = "anySimpleType")
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    protected String version;

                    /**
                     * Obtiene el valor de la propiedad da.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BOLETADefType.Documento.TED.DD.CAF.DA }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    public BOLETADefType.Documento.TED.DD.CAF.DA getDA() {
                        return da;
                    }

                    /**
                     * Define el valor de la propiedad da.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BOLETADefType.Documento.TED.DD.CAF.DA }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    public void setDA(BOLETADefType.Documento.TED.DD.CAF.DA value) {
                        this.da = value;
                    }

                    /**
                     * Obtiene el valor de la propiedad frma.
                     * 
                     * @return
                     *     possible object is
                     *     {@link BOLETADefType.Documento.TED.DD.CAF.FRMA }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    public BOLETADefType.Documento.TED.DD.CAF.FRMA getFRMA() {
                        return frma;
                    }

                    /**
                     * Define el valor de la propiedad frma.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link BOLETADefType.Documento.TED.DD.CAF.FRMA }
                     *     
                     */
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    public void setFRMA(BOLETADefType.Documento.TED.DD.CAF.FRMA value) {
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
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    public static class DA
                        implements Serializable
                    {

                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        private final static long serialVersionUID = -1L;
                        @XmlElement(name = "RE", required = true)
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected String re;
                        @XmlElement(name = "RS", required = true)
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected String rs;
                        @XmlElement(name = "TD", required = true)
                        @XmlSchemaType(name = "positiveInteger")
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected BigInteger td;
                        @XmlElement(name = "RNG", required = true)
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected BOLETADefType.Documento.TED.DD.CAF.DA.RNG rng;
                        @XmlElement(name = "FA", required = true, type = String.class)
                        @XmlJavaTypeAdapter(DateAdapter.class)
                        @XmlSchemaType(name = "date")
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected Date fa;
                        @XmlElement(name = "DSAPK")
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected BOLETADefType.Documento.TED.DD.CAF.DA.DSAPK dsapk;
                        @XmlElement(name = "RSAPK")
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected BOLETADefType.Documento.TED.DD.CAF.DA.RSAPK rsapk;
                        @XmlElement(name = "IDK")
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected long idk;

                        /**
                         * Obtiene el valor de la propiedad re.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public void setTD(BigInteger value) {
                            this.td = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad rng.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BOLETADefType.Documento.TED.DD.CAF.DA.RNG }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public BOLETADefType.Documento.TED.DD.CAF.DA.RNG getRNG() {
                            return rng;
                        }

                        /**
                         * Define el valor de la propiedad rng.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BOLETADefType.Documento.TED.DD.CAF.DA.RNG }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public void setRNG(BOLETADefType.Documento.TED.DD.CAF.DA.RNG value) {
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public void setFA(Date value) {
                            this.fa = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad dsapk.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BOLETADefType.Documento.TED.DD.CAF.DA.DSAPK }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public BOLETADefType.Documento.TED.DD.CAF.DA.DSAPK getDSAPK() {
                            return dsapk;
                        }

                        /**
                         * Define el valor de la propiedad dsapk.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BOLETADefType.Documento.TED.DD.CAF.DA.DSAPK }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public void setDSAPK(BOLETADefType.Documento.TED.DD.CAF.DA.DSAPK value) {
                            this.dsapk = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad rsapk.
                         * 
                         * @return
                         *     possible object is
                         *     {@link BOLETADefType.Documento.TED.DD.CAF.DA.RSAPK }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public BOLETADefType.Documento.TED.DD.CAF.DA.RSAPK getRSAPK() {
                            return rsapk;
                        }

                        /**
                         * Define el valor de la propiedad rsapk.
                         * 
                         * @param value
                         *     allowed object is
                         *     {@link BOLETADefType.Documento.TED.DD.CAF.DA.RSAPK }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public void setRSAPK(BOLETADefType.Documento.TED.DD.CAF.DA.RSAPK value) {
                            this.rsapk = value;
                        }

                        /**
                         * Obtiene el valor de la propiedad idk.
                         * 
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public long getIDK() {
                            return idk;
                        }

                        /**
                         * Define el valor de la propiedad idk.
                         * 
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public static class DSAPK
                            implements Serializable
                        {

                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            private final static long serialVersionUID = -1L;
                            @XmlElement(name = "P", required = true, type = String.class)
                            @XmlJavaTypeAdapter(Base64Adapter.class)
                            @XmlSchemaType(name = "base64Binary")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected byte[] p;
                            @XmlElement(name = "Q", required = true, type = String.class)
                            @XmlJavaTypeAdapter(Base64Adapter.class)
                            @XmlSchemaType(name = "base64Binary")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected byte[] q;
                            @XmlElement(name = "G", required = true, type = String.class)
                            @XmlJavaTypeAdapter(Base64Adapter.class)
                            @XmlSchemaType(name = "base64Binary")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected byte[] g;
                            @XmlElement(name = "Y", required = true, type = String.class)
                            @XmlJavaTypeAdapter(Base64Adapter.class)
                            @XmlSchemaType(name = "base64Binary")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected byte[] y;

                            /**
                             * Obtiene el valor de la propiedad p.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public static class RNG
                            implements Serializable
                        {

                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            private final static long serialVersionUID = -1L;
                            @XmlElement(name = "D", required = true)
                            @XmlSchemaType(name = "positiveInteger")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected BigInteger d;
                            @XmlElement(name = "H", required = true)
                            @XmlSchemaType(name = "positiveInteger")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected BigInteger h;

                            /**
                             * Obtiene el valor de la propiedad d.
                             * 
                             * @return
                             *     possible object is
                             *     {@link BigInteger }
                             *     
                             */
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public static class RSAPK
                            implements Serializable
                        {

                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            private final static long serialVersionUID = -1L;
                            @XmlElement(name = "M", required = true, type = String.class)
                            @XmlJavaTypeAdapter(Base64Adapter.class)
                            @XmlSchemaType(name = "base64Binary")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected byte[] m;
                            @XmlElement(name = "E", required = true, type = String.class)
                            @XmlJavaTypeAdapter(Base64Adapter.class)
                            @XmlSchemaType(name = "base64Binary")
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                            protected byte[] e;

                            /**
                             * Obtiene el valor de la propiedad m.
                             * 
                             * @return
                             *     possible object is
                             *     {@link String }
                             *     
                             */
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                    @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                    public static class FRMA
                        implements Serializable
                    {

                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        private final static long serialVersionUID = -1L;
                        @XmlValue
                        @XmlJavaTypeAdapter(Base64Adapter.class)
                        @XmlSchemaType(name = "base64Binary")
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected byte[] value;
                        @XmlAttribute(name = "algoritmo", required = true)
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        protected String algoritmo;

                        /**
                         * Obtiene el valor de la propiedad value.
                         * 
                         * @return
                         *     possible object is
                         *     {@link String }
                         *     
                         */
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                        @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                        public void setAlgoritmo(String value) {
                            this.algoritmo = value;
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
             *   &lt;simpleContent&gt;
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;base64Binary"&gt;
             *       &lt;attribute name="algoritmo" use="required"&gt;
             *         &lt;simpleType&gt;
             *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
             *             &lt;enumeration value="SHA1withRSA"/&gt;
             *             &lt;enumeration value="SHA1withDSA"/&gt;
             *           &lt;/restriction&gt;
             *         &lt;/simpleType&gt;
             *       &lt;/attribute&gt;
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
            @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
            public static class FRMT
                implements Serializable
            {

                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                private final static long serialVersionUID = -1L;
                @XmlValue
                @XmlJavaTypeAdapter(Base64Adapter.class)
                @XmlSchemaType(name = "base64Binary")
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected byte[] value;
                @XmlAttribute(name = "algoritmo", required = true)
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                protected String algoritmo;

                /**
                 * Obtiene el valor de la propiedad value.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
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
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public String getAlgoritmo() {
                    return algoritmo;
                }

                /**
                 * Define el valor de la propiedad algoritmo.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                @Generated(value = "com.sun.tools.xjc.Driver", comments = "JAXB RI v3.0.0", date = "2023-09-27T11:34:31-03:00")
                public void setAlgoritmo(String value) {
                    this.algoritmo = value;
                }

            }

        }

    }

}
