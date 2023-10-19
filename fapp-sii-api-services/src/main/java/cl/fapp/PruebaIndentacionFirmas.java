package cl.fapp;

import java.io.ByteArrayOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import cl.fapp.sii.signer.common.XmlSigner;

public class PruebaIndentacionFirmas {

	final static String CARRIAGE_RETURN = "\r\n";

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		String encabezadoBoleta = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?><BOLETADefType xmlns:ns2=\"http://www.w3.org/2000/09/xmldsig#\" version=\"1.0\">\r\n";
		String xmlcontentDTE = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><BOLETADefType version=\"1.0\">\r\n"
				+ "<Documento ID=\"B202307191946430000000004\">\r\n"
				+ "<Encabezado>\r\n"
				+ "<IdDoc>\r\n"
				+ "<TipoDTE>39</TipoDTE>\r\n"
				+ "<Folio>4</Folio>\r\n"
				+ "<FchEmis>2023-07-19</FchEmis>\r\n"
				+ "<IndServicio>3</IndServicio>\r\n"
				+ "</IdDoc>\r\n"
				+ "<Emisor>\r\n"
				+ "<RUTEmisor>77571105-1</RUTEmisor>\r\n"
				+ "<RznSocEmisor>Solution Store</RznSocEmisor>\r\n"
				+ "<GiroEmisor>Empresa Tecnolog&#237;a</GiroEmisor>\r\n"
				+ "<DirOrigen>Club de campo 540</DirOrigen>\r\n"
				+ "<CmnaOrigen>Quilicura</CmnaOrigen>\r\n"
				+ "<CiudadOrigen>RM</CiudadOrigen>\r\n"
				+ "</Emisor>\r\n"
				+ "<Receptor>\r\n"
				+ "<RUTRecep>66666666-6</RUTRecep>\r\n"
				+ "<RznSocRecep>USUARIO COMODIN</RznSocRecep>\r\n"
				+ "</Receptor>\r\n"
				+ "<Totales>\r\n"
				+ "<MntNeto>25042</MntNeto>\r\n"
				+ "<MntExe>0</MntExe>\r\n"
				+ "<IVA>4758</IVA>\r\n"
				+ "<MntTotal>29800</MntTotal>\r\n"
				+ "</Totales>\r\n"
				+ "</Encabezado>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>1</NroLinDet>\r\n"
				+ "<NmbItem>Cambio de aceite</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>19900</PrcItem>\r\n"
				+ "<MontoItem>19900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>2</NroLinDet>\r\n"
				+ "<NmbItem>Alineacion y balanceo</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>9900</PrcItem>\r\n"
				+ "<MontoItem>9900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<TED version=\"1.0\">\r\n"
				+ "<DD>\r\n"
				+ "<RE>77571105-1</RE>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<F>4</F>\r\n"
				+ "<FE>2023-07-19</FE>\r\n"
				+ "<RR>66666666-6</RR>\r\n"
				+ "<RSR>USUARIO COMODIN</RSR>\r\n"
				+ "<MNT>29800</MNT>\r\n"
				+ "<IT1>Cambio de aceite</IT1>\r\n"
				+ "<CAF version=\"1.0\">\r\n"
				+ "<DA>\r\n"
				+ "<RE>77571105-1</RE>\r\n"
				+ "<RS>SOLUTION STORE INGENIER&#205;A Y AUTOMATIZACI</RS>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<RNG><D>1</D><H>10</H></RNG>\r\n"
				+ "<FA>2022-08-05</FA>\r\n"
				+ "<RSAPK><M>6T1Q/mn9pswUZgWHZ1ZzRO/DoCq9kcyFc5FoYT+UUpKLDbSEY17a4FlMHtq/c/F7X6MzvDvkFC551e/OZQBDew==</M><E>Aw==</E></RSAPK>\r\n"
				+ "<IDK>100</IDK>\r\n"
				+ "</DA>\r\n"
				+ "<FRMA algoritmo=\"SHA1withRSA\">se3v3tKxvXFLeuAi3P+I4PMeHqs75roMwmf9l6PQruRJfE4YXhiMY4DlgvMEVxeCwLvwNL2My7fbxg4nDi1Ifw==</FRMA>\r\n"
				+ "</CAF>\r\n"
				+ "<TSTED>2023-07-19T07:46:43</TSTED>\r\n"
				+ "</DD>\r\n"
				+ "<FRMT algoritmo=\"SHA1withRSA\">B/qR70kli1U+W46/58RC9czYlrl7tI8vrjatM+tZacNbqAeSZK9iiAtn42kObgdluEutkkk2yC4+TXOA1dNQWg==</FRMT>\r\n"
				+ "</TED>\r\n"
				+ "<TmstFirma>2023-07-19T07:46:43</TmstFirma>\r\n"
				+ "</Documento>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#B202307191946430000000004\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>UrOM7afioo31Zo6vPHDMbSwzwtE=</DigestValue></Reference></SignedInfo><SignatureValue>aHH88kNXczq942xMdm1HOvXMNka4GLo6kR+gETeHTCn2o2SXEtNLBiBU2mXfscZcFPZvnXvbYCp+IzmMWRok0mK7gFs+vlpAmXGu/YOFx528cKDQ6kyhnWZwQ6uU07zXWrv7VhsxI3lRauWJmn7Um//j+xBoNAy29YDvY+8rbpbTEsI4shmc5r0fgt7PV5QfqhsxPnwYULV8sPF4Fk5RtQJS+h1aa+QWz17QMiDGCm4nixjd63U8xl6N+bRs8UgHhgWqNWG+p305gv6quKUMqXgW2NJ8ORehynsRixYsho51Q6fRo/8a95zuxUiVUs/Fe1WcaXx9QqbGJooKQsGmJg==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>pu9ZpoMwkOqpRtlKZwb7UsND9quYQttCNiL47k+gMrQbY0yoeNCfiXfr7v8cO/3vsznIPnydGT/tErPl0PoXiyusc5Xn6TgT9Y6J48pIyIZYqU7Gf0mXWd0HJTOJLEaEpd4juE95T5s6RyzqYD4jo2qfzS767OjxolE7wMvYlqc3udeRfDFK3fBeTu+V/4zLQHD/j8YDms1zP+x2RszVUS1iYYP6NFEmhBWwcc1i1HUoBSgFo3fjTKojacgVcu6EdPKcQirj9Hx4OkZ/sQ3sabf4ouL+yzPnvNWovAoet5HHXSEM0Tz6N9LPggLx9QuFUgNlyL69v+57sA1UeroUfQ==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></BOLETADefType>";

		String xmlSetdte = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n"
				+ "<EnvioBOLETA xmlns=\"http://www.sii.cl/SiiDte\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.0\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioBOLETA_v11.xsd\">\r\n"
				+ "<SetDTE ID=\"S20220824100818\">\r\n"
				+ "<Caratula version=\"1.0\">\r\n"
				+ "<RutEmisor>76447325-6</RutEmisor>\r\n"
				+ "<RutEnvia>14336960-9</RutEnvia>\r\n"
				+ "<RutReceptor>60803000-K</RutReceptor>\r\n"
				+ "<FchResol>2022-06-26</FchResol>\r\n"
				+ "<NroResol>0</NroResol>\r\n"
				+ "<TmstFirmaEnv>2022-08-24T10:08:18</TmstFirmaEnv>\r\n"
				+ "<SubTotDTE>\r\n"
				+ "<TpoDTE>39</TpoDTE>\r\n"
				+ "<NroDTE>2</NroDTE>\r\n"
				+ "</SubTotDTE>\r\n"
				+ "</Caratula>\r\n"
				+ "<DTE version=\"1.0\">\r\n"
				+ "<Documento ID=\"B202208241008040000000001\">\r\n"
				+ "<Encabezado>\r\n"
				+ "<IdDoc>\r\n"
				+ "<TipoDTE>39</TipoDTE>\r\n"
				+ "<Folio>1</Folio>\r\n"
				+ "<FchEmis>2022-08-24</FchEmis>\r\n"
				+ "<IndServicio>3</IndServicio>\r\n"
				+ "</IdDoc>\r\n"
				+ "<Emisor>\r\n"
				+ "<RUTEmisor>76447325-6</RUTEmisor>\r\n"
				+ "<RznSocEmisor>INVERSIONES RECABARREN CLARO SPA</RznSocEmisor>\r\n"
				+ "<GiroEmisor>INMOBILIARIA</GiroEmisor>\r\n"
				+ "<DirOrigen>MIRAFLORES 383</DirOrigen>\r\n"
				+ "<CmnaOrigen>SANTIAGO</CmnaOrigen>\r\n"
				+ "<CiudadOrigen>SANTIAGO</CiudadOrigen>\r\n"
				+ "</Emisor>\r\n"
				+ "<Receptor>\r\n"
				+ "<RUTRecep>66666666-6</RUTRecep>\r\n"
				+ "<RznSocRecep>USUARIO COMODIN</RznSocRecep>\r\n"
				+ "</Receptor>\r\n"
				+ "<Totales>\r\n"
				+ "<MntNeto>25042</MntNeto>\r\n"
				+ "<MntExe>0</MntExe>\r\n"
				+ "<IVA>4758</IVA>\r\n"
				+ "<MntTotal>29800</MntTotal>\r\n"
				+ "</Totales>\r\n"
				+ "</Encabezado>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>1</NroLinDet>\r\n"
				+ "<NmbItem>Cambio de aceite</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>19900</PrcItem>\r\n"
				+ "<MontoItem>19900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>2</NroLinDet>\r\n"
				+ "<NmbItem>Alineacion y balanceo</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>9900</PrcItem>\r\n"
				+ "<MontoItem>9900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<Referencia>\r\n"
				+ "<NroLinRef>1</NroLinRef>\r\n"
				+ "<CodRef>SET</CodRef>\r\n"
				+ "<RazonRef>CASO-1</RazonRef>\r\n"
				+ "</Referencia>\r\n"
				+ "<TED version=\"1.0\">\r\n"
				+ "<DD>\r\n"
				+ "<RE>76447325-6</RE>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<F>1</F>\r\n"
				+ "<FE>2022-08-24</FE>\r\n"
				+ "<RR>66666666-6</RR>\r\n"
				+ "<RSR>USUARIO COMODIN</RSR>\r\n"
				+ "<MNT>29800</MNT>\r\n"
				+ "<IT1>Cambio de aceite</IT1>\r\n"
				+ "<CAF version=\"1.0\">\r\n"
				+ "<DA>\r\n"
				+ "<RE>76447325-6</RE>\r\n"
				+ "<RS>INVERSIONES RECABARREN CLARO SPA</RS>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<RNG><D>1</D><H>5</H></RNG>\r\n"
				+ "<FA>2022-05-16</FA>\r\n"
				+ "<RSAPK><M>2TkioiaNFL1dIYnHJH9bsgb+6uH0zj2jTVKBzcVt1zqVE4BlxzSP6Sr5svFV2axubZu8MAHwqeczLoF+EmqGGQ==</M><E>Aw==</E></RSAPK>\r\n"
				+ "<IDK>100</IDK>\r\n"
				+ "</DA>\r\n"
				+ "<FRMA algoritmo=\"SHA1withRSA\">uh5f61ql47lcwGLVly6eefviM5VLk1dyz7LGdZOxNSnVXHkAxX3e5wkJ6BRU66NWFZZxA+jKmu8/PqEPzWCa9g==</FRMA>\r\n"
				+ "</CAF>\r\n"
				+ "<TSTED>2022-08-24T10:08:04</TSTED>\r\n"
				+ "</DD>\r\n"
				+ "<FRMT algoritmo=\"SHA1withRSA\">ux3WTQmacsN2s5rn8y+IQVLmg4YF/Lz8UdKLlccD7SGeaIZJFPqLcwlyBYikrOogiGINRI3F4s5hmDQ4guW4uA==</FRMT>\r\n"
				+ "</TED>\r\n"
				+ "<TmstFirma>2022-08-24T10:08:04</TmstFirma>\r\n"
				+ "</Documento>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#B202208241008040000000001\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>EcHyoDZga1Dd4Rk2wsyTi8y/42k=</DigestValue></Reference></SignedInfo><SignatureValue>h4euZ6llPX8G9P7IUWyU+8TJO7mzJe5t0CcX9B4GLuRKKkEI4u6Kpy7J6UDncdhpQl5ckzEYe8TwPf+H/EIgyBzEDWH1EZI9C9IRgv02P5UdwTxq6cFeqIg1BYZBh+YDV6Lh/Fw4Dz4bZO7DQXvxjl3TJI0WuIRPt+SR1yU9xIjS1PobOBfGuL8vD7nslcgq8jM9SBB9ES/PGyk6LnQyGWFZWw4ez1Xt41xUHGhe92r6K85crmpZqL5ci5EJlBQxDvwfMOGHKXV2SnZUJSyikLlbjj6kIRplD33khGWke/eMTI/iIJ+sCDP28RXnlv8zMal8IJQc9zdQtm9l2M5wMg==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>ySS6FARwZZQ2P8zO+xwoB70bSKEQogcMIEMhmBTMoNbKXvkJ7haHtAciTMdKBPoDhLkadQb8xX15Th5DGH3iYWexBrAIKHzlBhj/W2XUYOQT9L+7Byo09ZVdNgrGNbdhdnkQ/O87uUdFRturqgW2zc4xJ02863lnFg+1350pLQDJfdEvtNblNMslie+KSBE+OwSspvTcVAy7to0heu376qPixH7mkUVKUyf/dLRnJ1QUP3fbfF5Q5FXvR1rQLsQeOPVmT7VVoykk/RQOSiKEMumag+YwSAEaUT/pB+SHcp/344bGhJqip4g8GaPkR2baNMc2BVrAhowdTxuR5GxiSw==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></DTE>\r\n"
				+ "<DTE version=\"1.0\">\r\n"
				+ "<Documento ID=\"B202208241008130000000002\">\r\n"
				+ "<Encabezado>\r\n"
				+ "<IdDoc>\r\n"
				+ "<TipoDTE>39</TipoDTE>\r\n"
				+ "<Folio>2</Folio>\r\n"
				+ "<FchEmis>2022-08-24</FchEmis>\r\n"
				+ "<IndServicio>3</IndServicio>\r\n"
				+ "</IdDoc>\r\n"
				+ "<Emisor>\r\n"
				+ "<RUTEmisor>76447325-6</RUTEmisor>\r\n"
				+ "<RznSocEmisor>INVERSIONES RECABARREN CLARO SPA</RznSocEmisor>\r\n"
				+ "<GiroEmisor>INMOBILIARIA</GiroEmisor>\r\n"
				+ "<DirOrigen>MIRAFLORES 383</DirOrigen>\r\n"
				+ "<CmnaOrigen>SANTIAGO</CmnaOrigen>\r\n"
				+ "<CiudadOrigen>SANTIAGO</CiudadOrigen>\r\n"
				+ "</Emisor>\r\n"
				+ "<Receptor>\r\n"
				+ "<RUTRecep>66666666-6</RUTRecep>\r\n"
				+ "<RznSocRecep>USUARIO COMODIN</RznSocRecep>\r\n"
				+ "</Receptor>\r\n"
				+ "<Totales>\r\n"
				+ "<MntNeto>25042</MntNeto>\r\n"
				+ "<MntExe>0</MntExe>\r\n"
				+ "<IVA>4758</IVA>\r\n"
				+ "<MntTotal>29800</MntTotal>\r\n"
				+ "</Totales>\r\n"
				+ "</Encabezado>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>1</NroLinDet>\r\n"
				+ "<NmbItem>Cambio de aceite</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>19900</PrcItem>\r\n"
				+ "<MontoItem>19900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>2</NroLinDet>\r\n"
				+ "<NmbItem>Alineacion y balanceo</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>9900</PrcItem>\r\n"
				+ "<MontoItem>9900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<Referencia>\r\n"
				+ "<NroLinRef>1</NroLinRef>\r\n"
				+ "<CodRef>SET</CodRef>\r\n"
				+ "<RazonRef>CASO-1</RazonRef>\r\n"
				+ "</Referencia>\r\n"
				+ "<TED version=\"1.0\">\r\n"
				+ "<DD>\r\n"
				+ "<RE>76447325-6</RE>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<F>2</F>\r\n"
				+ "<FE>2022-08-24</FE>\r\n"
				+ "<RR>66666666-6</RR>\r\n"
				+ "<RSR>USUARIO COMODIN</RSR>\r\n"
				+ "<MNT>29800</MNT>\r\n"
				+ "<IT1>Cambio de aceite</IT1>\r\n"
				+ "<CAF version=\"1.0\">\r\n"
				+ "<DA>\r\n"
				+ "<RE>76447325-6</RE>\r\n"
				+ "<RS>INVERSIONES RECABARREN CLARO SPA</RS>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<RNG><D>1</D><H>5</H></RNG>\r\n"
				+ "<FA>2022-05-16</FA>\r\n"
				+ "<RSAPK><M>2TkioiaNFL1dIYnHJH9bsgb+6uH0zj2jTVKBzcVt1zqVE4BlxzSP6Sr5svFV2axubZu8MAHwqeczLoF+EmqGGQ==</M><E>Aw==</E></RSAPK>\r\n"
				+ "<IDK>100</IDK>\r\n"
				+ "</DA>\r\n"
				+ "<FRMA algoritmo=\"SHA1withRSA\">uh5f61ql47lcwGLVly6eefviM5VLk1dyz7LGdZOxNSnVXHkAxX3e5wkJ6BRU66NWFZZxA+jKmu8/PqEPzWCa9g==</FRMA>\r\n"
				+ "</CAF>\r\n"
				+ "<TSTED>2022-08-24T10:08:13</TSTED>\r\n"
				+ "</DD>\r\n"
				+ "<FRMT algoritmo=\"SHA1withRSA\">tRY+aelhlwNKxlf30htfhjQ+Gv4OnkklKG3tj/F3s1vobgSPHvHdMnoutbhdDHDrSh8avDX+5dtOXhlllRxxMw==</FRMT>\r\n"
				+ "</TED>\r\n"
				+ "<TmstFirma>2022-08-24T10:08:13</TmstFirma>\r\n"
				+ "</Documento>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#B202208241008130000000002\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>SzGEsuBsrsKzbrN7pmQivvXjgYQ=</DigestValue></Reference></SignedInfo><SignatureValue>XHRBOkcAMGIH00C0k8fB+anlhuIgEHxG6MmnLG44Ta9Dqg9tMdM5lc7GH968kMCxn42oMCBpq7IEy4PhY8XAhTMWVs609BaqJ2tyvJHjOB6SwrAPgQIBxywHMFl6umxRBGDCUbU+B4y7pwJvkIDD+V+RRJ0jKkRDiyfrW4zrszVAr+SapunVxCsdVtCtNUmgjzJkB81FLhjJWrsGObF1WyNiabxf/tJ9LqW6ZM0/+/9y3OXrws7ZHniD6Xt3OnLaKvAPLycaewUkXXon43j5dW/njifScywJNf9GDo4WPR2X1Ng37zU68qaPVCrewjj4sUN6I3Kg5Vc1PnvgEhIUWA==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>ySS6FARwZZQ2P8zO+xwoB70bSKEQogcMIEMhmBTMoNbKXvkJ7haHtAciTMdKBPoDhLkadQb8xX15Th5DGH3iYWexBrAIKHzlBhj/W2XUYOQT9L+7Byo09ZVdNgrGNbdhdnkQ/O87uUdFRturqgW2zc4xJ02863lnFg+1350pLQDJfdEvtNblNMslie+KSBE+OwSspvTcVAy7to0heu376qPixH7mkUVKUyf/dLRnJ1QUP3fbfF5Q5FXvR1rQLsQeOPVmT7VVoykk/RQOSiKEMumag+YwSAEaUT/pB+SHcp/344bGhJqip4g8GaPkR2baNMc2BVrAhowdTxuR5GxiSw==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></DTE>\r\n"
				+ "</SetDTE>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#S20220824100818\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>V+FKDQ4a3/71msQyPL3Viy45gU4=</DigestValue></Reference></SignedInfo><SignatureValue>xyqjv9Yhm2xGwpC9wz7FoCFpNaMJmA11dSertYq5nWossm0cA4xVIRF78wlTftNlHWEoDpkS0GszUTQRFuC9rLhR5O49aoXJyJpL58o8HSmD0a4MWt0T19zyv3RsVfBEoPP0sciuamBA/6FiHOAH1XGhlFh/fzQTZikHUEEriYspOh2H3/VlJXWN0Q7FODoLws7YfxUi6FciL7LNWMDfztyzYtN6EcDLVyRKgcQRK1BlJadA+h1UwzUHQsiRgCZNtnUH13UFOW9MCzWu/5OG1MuUaAeFuQtsf8xHqzbRLetlb+BPyExokAohzeSxiB7DBBEj+IzArB6X+a9Nf92JAA==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>ySS6FARwZZQ2P8zO+xwoB70bSKEQogcMIEMhmBTMoNbKXvkJ7haHtAciTMdKBPoDhLkadQb8xX15Th5DGH3iYWexBrAIKHzlBhj/W2XUYOQT9L+7Byo09ZVdNgrGNbdhdnkQ/O87uUdFRturqgW2zc4xJ02863lnFg+1350pLQDJfdEvtNblNMslie+KSBE+OwSspvTcVAy7to0heu376qPixH7mkUVKUyf/dLRnJ1QUP3fbfF5Q5FXvR1rQLsQeOPVmT7VVoykk/RQOSiKEMumag+YwSAEaUT/pB+SHcp/344bGhJqip4g8GaPkR2baNMc2BVrAhowdTxuR5GxiSw==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></EnvioBOLETA>";
		
		String xmlcontentSetDTE2 = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\r\n"
				+ "<EnvioBOLETA xmlns=\"http://www.sii.cl/SiiDte\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" version=\"1.0\" xsi:schemaLocation=\"http://www.sii.cl/SiiDte EnvioBOLETA_v11.xsd\">\r\n"
				+ "<SetDTE ID=\"S20230721101138\">\r\n"
				+ "<Caratula version=\"1.0\">\r\n"
				+ "<RutEmisor>77571105-1</RutEmisor>\r\n"
				+ "<RutEnvia>15782311-6</RutEnvia>\r\n"
				+ "<RutReceptor>60803000-K</RutReceptor>\r\n"
				+ "<FchResol>2022-08-12</FchResol>\r\n"
				+ "<NroResol>0</NroResol>\r\n"
				+ "<TmstFirmaEnv>2023-07-21T10:11:38</TmstFirmaEnv>\r\n"
				+ "<SubTotDTE>\r\n"
				+ "<TpoDTE>39</TpoDTE>\r\n"
				+ "<NroDTE>1</NroDTE>\r\n"
				+ "</SubTotDTE>\r\n"
				+ "</Caratula>\r\n"
				+ "<DTE version=\"1.0\">\r\n"
				+ "<Documento ID=\"B202307211010080000000153\">\r\n"
				+ "<Encabezado>\r\n"
				+ "<IdDoc>\r\n"
				+ "<TipoDTE>39</TipoDTE>\r\n"
				+ "<Folio>153</Folio>\r\n"
				+ "<FchEmis>2023-07-21</FchEmis>\r\n"
				+ "<IndServicio>3</IndServicio>\r\n"
				+ "</IdDoc>\r\n"
				+ "<Emisor>\r\n"
				+ "<RUTEmisor>77571105-1</RUTEmisor>\r\n"
				+ "<RznSocEmisor>Solution Store</RznSocEmisor>\r\n"
				+ "<GiroEmisor>Empresa Tecnolog&#237;a</GiroEmisor>\r\n"
				+ "<DirOrigen>Club de campo 540</DirOrigen>\r\n"
				+ "<CmnaOrigen>Quilicura</CmnaOrigen>\r\n"
				+ "<CiudadOrigen>RM</CiudadOrigen>\r\n"
				+ "</Emisor>\r\n"
				+ "<Receptor>\r\n"
				+ "<RUTRecep>66666666-6</RUTRecep>\r\n"
				+ "<RznSocRecep>USUARIO COMODIN</RznSocRecep>\r\n"
				+ "</Receptor>\r\n"
				+ "<Totales>\r\n"
				+ "<MntNeto>25042</MntNeto>\r\n"
				+ "<MntExe>0</MntExe>\r\n"
				+ "<IVA>4758</IVA>\r\n"
				+ "<MntTotal>29800</MntTotal>\r\n"
				+ "</Totales>\r\n"
				+ "</Encabezado>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>1</NroLinDet>\r\n"
				+ "<NmbItem>Cambio de aceite</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>19900</PrcItem>\r\n"
				+ "<MontoItem>19900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<Detalle>\r\n"
				+ "<NroLinDet>2</NroLinDet>\r\n"
				+ "<NmbItem>Alineacion y balanceo</NmbItem>\r\n"
				+ "<QtyItem>1</QtyItem>\r\n"
				+ "<PrcItem>9900</PrcItem>\r\n"
				+ "<MontoItem>9900</MontoItem>\r\n"
				+ "</Detalle>\r\n"
				+ "<TED version=\"1.0\">\r\n"
				+ "<DD>\r\n"
				+ "<RE>77571105-1</RE>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<F>153</F>\r\n"
				+ "<FE>2023-07-21</FE>\r\n"
				+ "<RR>66666666-6</RR>\r\n"
				+ "<RSR>USUARIO COMODIN</RSR>\r\n"
				+ "<MNT>29800</MNT>\r\n"
				+ "<IT1>Cambio de aceite</IT1>\r\n"
				+ "<CAF version=\"1.0\">\r\n"
				+ "<DA>\r\n"
				+ "<RE>77571105-1</RE>\r\n"
				+ "<RS>SOLUTION STORE INGENIER&#205;A Y AUTOMATIZACI</RS>\r\n"
				+ "<TD>39</TD>\r\n"
				+ "<RNG><D>1</D><H>10</H></RNG>\r\n"
				+ "<FA>2022-08-05</FA>\r\n"
				+ "<RSAPK><M>6T1Q/mn9pswUZgWHZ1ZzRO/DoCq9kcyFc5FoYT+UUpKLDbSEY17a4FlMHtq/c/F7X6MzvDvkFC551e/OZQBDew==</M><E>Aw==</E></RSAPK>\r\n"
				+ "<IDK>100</IDK>\r\n"
				+ "</DA>\r\n"
				+ "<FRMA algoritmo=\"SHA1withRSA\">se3v3tKxvXFLeuAi3P+I4PMeHqs75roMwmf9l6PQruRJfE4YXhiMY4DlgvMEVxeCwLvwNL2My7fbxg4nDi1Ifw==</FRMA>\r\n"
				+ "</CAF>\r\n"
				+ "<TSTED>2023-07-21T10:10:07</TSTED>\r\n"
				+ "</DD>\r\n"
				+ "<FRMT algoritmo=\"SHA1withRSA\">qRSC4nd21XJD8A0V+VG3veZE+UAINII7oUOSNIYXRLFVdb3NRgXODSbo2P9agg4/T1apDZLglXQ57+5U8oWk7w==</FRMT>\r\n"
				+ "</TED>\r\n"
				+ "<TmstFirma>2023-07-21T10:10:07</TmstFirma>\r\n"
				+ "</Documento>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#B202307211010080000000153\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>QnIr/G0DwskALmt3wuvwAm8bAao=</DigestValue></Reference></SignedInfo><SignatureValue>eGO4nDrMYuVy2JjSm/4v/OQ1vY/uojdImeUhB4nceZHNC5W5ap5b7TXi1x4j8gz/9q3jnhKlWhhP\r\n"
				+ "FjZwksuTHybyF6xWrAbzPVTsDjVYAw9wBggKHV14+3zwGkzhy6WTYSD+yWHHhP64x7dLZGPO05eL\r\n"
				+ "s4OTT1KNhv8kncROUbfqJOwXvdg2cQTMBfqBT1O0xccec3kXhVrNKprSMk912esJrzm+V89JZYP/\r\n"
				+ "pvsFA3+qgeWE0pR3jJKGvb/U22l6BzjmauF6Xhv5hEMAsnEPq9sA2W7S0/1ndbqRkIidjfayg7hP\r\n"
				+ "Pw6EBh+6OixB9dCEsiVcZBkuwn3pfxH/vteVJw==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>pu9ZpoMwkOqpRtlKZwb7UsND9quYQttCNiL47k+gMrQbY0yoeNCfiXfr7v8cO/3vsznIPnydGT/t\r\n"
				+ "ErPl0PoXiyusc5Xn6TgT9Y6J48pIyIZYqU7Gf0mXWd0HJTOJLEaEpd4juE95T5s6RyzqYD4jo2qf\r\n"
				+ "zS767OjxolE7wMvYlqc3udeRfDFK3fBeTu+V/4zLQHD/j8YDms1zP+x2RszVUS1iYYP6NFEmhBWw\r\n"
				+ "cc1i1HUoBSgFo3fjTKojacgVcu6EdPKcQirj9Hx4OkZ/sQ3sabf4ouL+yzPnvNWovAoet5HHXSEM\r\n"
				+ "0Tz6N9LPggLx9QuFUgNlyL69v+57sA1UeroUfQ==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>MIIH1jCCBb6gAwIBAgIKEeb1+wABAAX8TjANBgkqhkiG9w0BAQsFADCBvzELMAkGA1UEBhMCQ0wx\r\n"
				+ "HTAbBgNVBAgTFFJlZ2lvbiBNZXRyb3BvbGl0YW5hMREwDwYDVQQHEwhTYW50aWFnbzEUMBIGA1UE\r\n"
				+ "ChMLRS1DRVJUQ0hJTEUxIDAeBgNVBAsTF0F1dG9yaWRhZCBDZXJ0aWZpY2Fkb3JhMR4wHAYDVQQD\r\n"
				+ "ExVFLUNFUlRDSElMRSBDQSBGRVMgMDIxJjAkBgkqhkiG9w0BCQEWF3NjbGllbnRlQGUtY2VydGNo\r\n"
				+ "aWxlLmNsMB4XDTIzMDUyMDE5MTYzNVoXDTI2MDUxOTE5MTYzNVowgdIxCzAJBgNVBAYTAkNMMSIw\r\n"
				+ "IAYDVQQIExlNRVRST1BPTElUQU5BIERFIFNBTlRJQUdPMREwDwYDVQQHEwhTQU5USUFHTzEmMCQG\r\n"
				+ "A1UEChMdU09MVVRJT04gU1RPUkUgSU5HRU5JRVJJQSBTUEExCjAIBgNVBAsMASoxKjAoBgNVBAMT\r\n"
				+ "IUZSQU5DSVMgSVZPTk5FIERFIExBIFRPUlJFIENIQVZFWjEsMCoGCSqGSIb3DQEJARYdRlJBTkNJ\r\n"
				+ "Uy5ERUxBVE9SUkVDSEBHTUFJTC5DT00wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCm\r\n"
				+ "71mmgzCQ6qlG2UpnBvtSw0P2q5hC20I2IvjuT6AytBtjTKh40J+Jd+vu/xw7/e+zOcg+fJ0ZP+0S\r\n"
				+ "s+XQ+heLK6xzlefpOBP1jonjykjIhlipTsZ/SZdZ3QclM4ksRoSl3iO4T3lPmzpHLOpgPiOjap/N\r\n"
				+ "Lvrs6PGiUTvAy9iWpze515F8MUrd8F5O75X/jMtAcP+PxgOazXM/7HZGzNVRLWJhg/o0USaEFbBx\r\n"
				+ "zWLUdSgFKAWjd+NMqiNpyBVy7oR08pxCKuP0fHg6Rn+xDexpt/ii4v7LM+e81ai8Ch63kcddIQzR\r\n"
				+ "PPo30s+CAvH1C4VSA2XIvr2/7nuwDVR6uhR9AgMBAAGjggK9MIICuTCCAV8GA1UdIASCAVYwggFS\r\n"
				+ "MIIBTgYIKwYBBAHDUgUwggFAMD0GCCsGAQUFBwIBFjFodHRwczovL3d3dy5lLWNlcnRjaGlsZS5j\r\n"
				+ "bC9wb2xpdGljYXMteS1wcmFjdGljYXMvMIH+BggrBgEFBQcCAjCB8R6B7gBFAGwAIAByAGUAcwBw\r\n"
				+ "AG8AbgBkAGUAcgAgAGUAcwB0AGUAIABmAG8AcgBtAHUAbABhAHIAaQBvACAAZQBzACAAdQBuACAA\r\n"
				+ "cgBlAHEAdQBpAHMAaQB0AG8AIABpAG4AZABpAHMAcABlAG4AcwBhAGIAbABlACAAcABhAHIAYQAg\r\n"
				+ "AGQAYQByACAAaQBuAGkAYwBpAG8AIABhAGwAIABwAHIAbwBjAGUAcwBvACAAZABlACAAYwBlAHIA\r\n"
				+ "dABpAGYAaQBjAGEAYwBpAPMAbgAuACAAUABvAHMAdABlAHIAaQBvAHIAbQBlAG4AdABlACwwHQYD\r\n"
				+ "VR0OBBYEFJ7sfkOJIyfyQtcRKaUft94ozAD6MAsGA1UdDwQEAwIE8DAjBgNVHREEHDAaoBgGCCsG\r\n"
				+ "AQQBwQEBoAwWCjE1NzgyMzExLTYwHwYDVR0jBBgwFoAUdNYhs/Ra6C18u1kGY0PvabQ6kwQwQAYD\r\n"
				+ "VR0fBDkwNzA1oDOgMYYvaHR0cDovL2NybC5lY2VydGNoaWxlLmNsL0UtQ0VSVENISUxFQ0FGRVMw\r\n"
				+ "Mi5jcmwwPQYIKwYBBQUHAQEEMTAvMC0GCCsGAQUFBzABhiFodHRwOi8vb2NzcGZlcy5lY2VydGNo\r\n"
				+ "aWxlLmNsL29jc3AwPAYJKwYBBAGCNxUHBC8wLQYlKwYBBAGCNxUIgd3STZfUOoaJnQaHiM5vg6/M\r\n"
				+ "YEWG0uwIhsfKfQIBZAIBBzAjBgNVHRIEHDAaoBgGCCsGAQQBwQECoAwWCjk2OTI4MTgwLTUwDQYJ\r\n"
				+ "KoZIhvcNAQELBQADggIBAE0ZplGx5eErW+RT4LAUxZFopWUPWbFcSAxnZ6m9Uk1xh4qaPJ6xpGgs\r\n"
				+ "SGMrCxDDdDt44NcjCN7V1hYmKwc52IRLFj0Ekfv/qIuwN7j5cHgjMNzHVaLzpOUMDCYoB0rq8nxp\r\n"
				+ "axq1JTrQbSqSfUge3UL+ICgkYFko8Pzq66MsHByeI5Y94H0780Sm/xr0TtvF/D6Uvn30WjTAWDp5\r\n"
				+ "Y3sIC8TgwRM228V4z6jkCieJPJUlicSo6jJkl3pf/PBoLSu/FgMf/pE7ENL1XVpk+W4srXOjFPEx\r\n"
				+ "o55UzS3GBRExpBWGVXQIliHBJRvXofSP0vegKLpht3y9Xz6ngE7jYrHEb1AkuZ1YgUvFh3Ydydhc\r\n"
				+ "XSbzkput6KZzIxZxsDZrt7ZbZ71/ALNKoP8JhUrTDTXlmbzK9LVz56InpAeulhJJZdEW9nQys+fl\r\n"
				+ "IY8PS3Kpr7mVfVA2lgwFXy7P1SN6xw6ZYAmkyX4fSocC7p4FySM+5XFSAjzNAAz8freePJrJ/t2y\r\n"
				+ "QNWuBmOBt23wN/UM+hgIe5g+R9ARqDFhPY9KbFpyD6vNeqaCYAZtzZkbSjg5O2qyWAZNCAruUmwM\r\n"
				+ "h1uoXIivGNcFwMx7Ax+8HXcMYGdxl4DAzpmQFVr/1ry5w+MT8gSLM17TBIzbhC0v3/3hPsZT/ASr\r\n"
				+ "Oz0KYWC+A5NdFex/iyOD</X509Certificate></X509Data></KeyInfo></Signature></DTE>\r\n"
				+ "</SetDTE>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#S20230721101138\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>wo8ZvfWkEat2wUAoI8qPf0l2X+0=</DigestValue></Reference></SignedInfo><SignatureValue>fOxr1/UhygKJQFSRz3tQwS7euj8gKP3jgOTcCl8zmMwRSENbe5YiyS3gMOrXNTVTC+rBiWkQwMkK\r\n"
				+ "ZPXF9w971a0IJds0rrgGN2/4KyiSeFhXxuS4MsIn9xlGkO2IFspaHWay4YG7p7lVDHoyZUaT8Z/Z\r\n"
				+ "32onOzHZvr02bxu62F4NUCTaUFBJOnzSrlHYdw2xbeCRUHZna8/Yvv2VYFSwQQYREMs9SsMcHS5G\r\n"
				+ "JUmscR7eWYYKPZeYkYqlkhrxg1GQe6uVmad0Nbr4lmBcHmn/6jvDxjtNcPCuZ12W9Yj1hnzOSk4Q\r\n"
				+ "ZfMlOEnVwYD6ZnliSszww63lWramIv1rBdcZbw==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>pu9ZpoMwkOqpRtlKZwb7UsND9quYQttCNiL47k+gMrQbY0yoeNCfiXfr7v8cO/3vsznIPnydGT/t\r\n"
				+ "ErPl0PoXiyusc5Xn6TgT9Y6J48pIyIZYqU7Gf0mXWd0HJTOJLEaEpd4juE95T5s6RyzqYD4jo2qf\r\n"
				+ "zS767OjxolE7wMvYlqc3udeRfDFK3fBeTu+V/4zLQHD/j8YDms1zP+x2RszVUS1iYYP6NFEmhBWw\r\n"
				+ "cc1i1HUoBSgFo3fjTKojacgVcu6EdPKcQirj9Hx4OkZ/sQ3sabf4ouL+yzPnvNWovAoet5HHXSEM\r\n"
				+ "0Tz6N9LPggLx9QuFUgNlyL69v+57sA1UeroUfQ==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>MIIH1jCCBb6gAwIBAgIKEeb1+wABAAX8TjANBgkqhkiG9w0BAQsFADCBvzELMAkGA1UEBhMCQ0wx\r\n"
				+ "HTAbBgNVBAgTFFJlZ2lvbiBNZXRyb3BvbGl0YW5hMREwDwYDVQQHEwhTYW50aWFnbzEUMBIGA1UE\r\n"
				+ "ChMLRS1DRVJUQ0hJTEUxIDAeBgNVBAsTF0F1dG9yaWRhZCBDZXJ0aWZpY2Fkb3JhMR4wHAYDVQQD\r\n"
				+ "ExVFLUNFUlRDSElMRSBDQSBGRVMgMDIxJjAkBgkqhkiG9w0BCQEWF3NjbGllbnRlQGUtY2VydGNo\r\n"
				+ "aWxlLmNsMB4XDTIzMDUyMDE5MTYzNVoXDTI2MDUxOTE5MTYzNVowgdIxCzAJBgNVBAYTAkNMMSIw\r\n"
				+ "IAYDVQQIExlNRVRST1BPTElUQU5BIERFIFNBTlRJQUdPMREwDwYDVQQHEwhTQU5USUFHTzEmMCQG\r\n"
				+ "A1UEChMdU09MVVRJT04gU1RPUkUgSU5HRU5JRVJJQSBTUEExCjAIBgNVBAsMASoxKjAoBgNVBAMT\r\n"
				+ "IUZSQU5DSVMgSVZPTk5FIERFIExBIFRPUlJFIENIQVZFWjEsMCoGCSqGSIb3DQEJARYdRlJBTkNJ\r\n"
				+ "Uy5ERUxBVE9SUkVDSEBHTUFJTC5DT00wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCm\r\n"
				+ "71mmgzCQ6qlG2UpnBvtSw0P2q5hC20I2IvjuT6AytBtjTKh40J+Jd+vu/xw7/e+zOcg+fJ0ZP+0S\r\n"
				+ "s+XQ+heLK6xzlefpOBP1jonjykjIhlipTsZ/SZdZ3QclM4ksRoSl3iO4T3lPmzpHLOpgPiOjap/N\r\n"
				+ "Lvrs6PGiUTvAy9iWpze515F8MUrd8F5O75X/jMtAcP+PxgOazXM/7HZGzNVRLWJhg/o0USaEFbBx\r\n"
				+ "zWLUdSgFKAWjd+NMqiNpyBVy7oR08pxCKuP0fHg6Rn+xDexpt/ii4v7LM+e81ai8Ch63kcddIQzR\r\n"
				+ "PPo30s+CAvH1C4VSA2XIvr2/7nuwDVR6uhR9AgMBAAGjggK9MIICuTCCAV8GA1UdIASCAVYwggFS\r\n"
				+ "MIIBTgYIKwYBBAHDUgUwggFAMD0GCCsGAQUFBwIBFjFodHRwczovL3d3dy5lLWNlcnRjaGlsZS5j\r\n"
				+ "bC9wb2xpdGljYXMteS1wcmFjdGljYXMvMIH+BggrBgEFBQcCAjCB8R6B7gBFAGwAIAByAGUAcwBw\r\n"
				+ "AG8AbgBkAGUAcgAgAGUAcwB0AGUAIABmAG8AcgBtAHUAbABhAHIAaQBvACAAZQBzACAAdQBuACAA\r\n"
				+ "cgBlAHEAdQBpAHMAaQB0AG8AIABpAG4AZABpAHMAcABlAG4AcwBhAGIAbABlACAAcABhAHIAYQAg\r\n"
				+ "AGQAYQByACAAaQBuAGkAYwBpAG8AIABhAGwAIABwAHIAbwBjAGUAcwBvACAAZABlACAAYwBlAHIA\r\n"
				+ "dABpAGYAaQBjAGEAYwBpAPMAbgAuACAAUABvAHMAdABlAHIAaQBvAHIAbQBlAG4AdABlACwwHQYD\r\n"
				+ "VR0OBBYEFJ7sfkOJIyfyQtcRKaUft94ozAD6MAsGA1UdDwQEAwIE8DAjBgNVHREEHDAaoBgGCCsG\r\n"
				+ "AQQBwQEBoAwWCjE1NzgyMzExLTYwHwYDVR0jBBgwFoAUdNYhs/Ra6C18u1kGY0PvabQ6kwQwQAYD\r\n"
				+ "VR0fBDkwNzA1oDOgMYYvaHR0cDovL2NybC5lY2VydGNoaWxlLmNsL0UtQ0VSVENISUxFQ0FGRVMw\r\n"
				+ "Mi5jcmwwPQYIKwYBBQUHAQEEMTAvMC0GCCsGAQUFBzABhiFodHRwOi8vb2NzcGZlcy5lY2VydGNo\r\n"
				+ "aWxlLmNsL29jc3AwPAYJKwYBBAGCNxUHBC8wLQYlKwYBBAGCNxUIgd3STZfUOoaJnQaHiM5vg6/M\r\n"
				+ "YEWG0uwIhsfKfQIBZAIBBzAjBgNVHRIEHDAaoBgGCCsGAQQBwQECoAwWCjk2OTI4MTgwLTUwDQYJ\r\n"
				+ "KoZIhvcNAQELBQADggIBAE0ZplGx5eErW+RT4LAUxZFopWUPWbFcSAxnZ6m9Uk1xh4qaPJ6xpGgs\r\n"
				+ "SGMrCxDDdDt44NcjCN7V1hYmKwc52IRLFj0Ekfv/qIuwN7j5cHgjMNzHVaLzpOUMDCYoB0rq8nxp\r\n"
				+ "axq1JTrQbSqSfUge3UL+ICgkYFko8Pzq66MsHByeI5Y94H0780Sm/xr0TtvF/D6Uvn30WjTAWDp5\r\n"
				+ "Y3sIC8TgwRM228V4z6jkCieJPJUlicSo6jJkl3pf/PBoLSu/FgMf/pE7ENL1XVpk+W4srXOjFPEx\r\n"
				+ "o55UzS3GBRExpBWGVXQIliHBJRvXofSP0vegKLpht3y9Xz6ngE7jYrHEb1AkuZ1YgUvFh3Ydydhc\r\n"
				+ "XSbzkput6KZzIxZxsDZrt7ZbZ71/ALNKoP8JhUrTDTXlmbzK9LVz56InpAeulhJJZdEW9nQys+fl\r\n"
				+ "IY8PS3Kpr7mVfVA2lgwFXy7P1SN6xw6ZYAmkyX4fSocC7p4FySM+5XFSAjzNAAz8freePJrJ/t2y\r\n"
				+ "QNWuBmOBt23wN/UM+hgIe5g+R9ARqDFhPY9KbFpyD6vNeqaCYAZtzZkbSjg5O2qyWAZNCAruUmwM\r\n"
				+ "h1uoXIivGNcFwMx7Ax+8HXcMYGdxl4DAzpmQFVr/1ry5w+MT8gSLM17TBIzbhC0v3/3hPsZT/ASr\r\n"
				+ "Oz0KYWC+A5NdFex/iyOD</X509Certificate></X509Data></KeyInfo></Signature></EnvioBOLETA>";
		
		// ----------------------------------------------------	
		String xml = new String(xmlcontentSetDTE2);

		// normaliza el xml para que el sii lo pueda procesar
		String output = replaceTagValue("SignatureValue", 76, xml);
		output = replaceTagValue("Modulus", 76, output);
		output = replaceTagValue("X509Certificate", 76, output);
		
		System.out.println("newXML=[" + output + "]");

		/*
		String newXmlcontent = normalizeXmlForSII(xmlcontentDTE);
		System.out.println(newXmlcontent);
		*/
	}
	
	/**
	 * Reemplaza cada valor de un tag en partes de 'numchar' caracteres. Reemplaza todas las ocurrencias del tag.
	 * @param tag tag al cual reemplazar su valor
	 * @param numchar numero de caracteres de cada porcion
	 * @param xml xml que contiene el tag a reemplazar
	 * @return el xml modificado
	 */
	private static String replaceTagValue(String tag, Integer numchar, String xml) {
		Pattern TAG_PATTERN = Pattern.compile("<" + tag + ">(.+?)</" + tag + ">", Pattern.DOTALL);
		String original = new String(xml);
		int lastIndex = 0;
		StringBuilder output = new StringBuilder();
		Matcher matcher = TAG_PATTERN.matcher(original);
		while (matcher.find()) {
			String tagValue = matcher.group(1);
			output.append(original, lastIndex, matcher.start()).append(splitTagValue(tag, numchar, tagValue));
			lastIndex = matcher.end();
		}

		if (lastIndex < original.length()) {
			output.append(original, lastIndex, original.length());
		}
		
		return output.toString();
	}
	
	/**
	 * Porciona el valor del tag en partes de 'numchar' caracteres
	 * @param tag nombre del tag (se utiliza para generar el nuevo string incluyendo el tag)
	 * @param numchar numero de caracteres de cada parte
	 * @param value valor del tag
	 * @return el tag formateado
	 */
	private static String splitTagValue(String tag, Integer numchar, String value) {
		String crlf = value.contains(CARRIAGE_RETURN) ? "" : CARRIAGE_RETURN;

		String parsedTagValue = value.replaceAll("(.{" + numchar + "})", "$1" + crlf);
		String newValue = "<" + tag + ">" + parsedTagValue + "</" + tag + ">";
		return newValue;
	}
	
	private static String normalizeXmlForSII2(String xml) {
		String newXmlcontent = new String(xml);
		newXmlcontent = splitTagValue2("SignatureValue", 76, newXmlcontent);
		newXmlcontent = splitTagValue2("Modulus", 76, newXmlcontent);
		newXmlcontent = splitTagValue2("X509Certificate", 76, newXmlcontent);
		
		return newXmlcontent;
	}
	
	/**
	 * Divide el valor de un tag en porciones de numchar caracteres. Cada porcion es terminada con un salto de linea
	 * @param tag tag
	 * @param numchar numero de caracteres de cada porcion
	 * @param xml xml con el contenido del documento
	 * @return string con el valor del tag porcionado
	 */
	private static String splitTagValue2(String tag, Integer numchar, String xml) {
		final Pattern pattern = Pattern.compile("<" + tag + ">(.+?)</" + tag + ">", Pattern.DOTALL);
		final Matcher matcher = pattern.matcher(xml);
		matcher.find();
		String tagValue = matcher.group(1);
		//System.out.println("<" + tag + ">==> " + tagValue); // Prints String I want to extract
		
		String parsedTagValue = tagValue.replaceAll("(.{" + numchar + "})", "$1" + CARRIAGE_RETURN);
		//System.out.println("<Parsed" + tag + ">==> " + parsedTagValue); // Prints String I want to extract
		
		String content = xml.replaceAll("<" + tag + ">(.*?)</" + tag + ">", "<" + tag + ">" + parsedTagValue + "</" + tag + ">");
		
		return content;
	}

}
