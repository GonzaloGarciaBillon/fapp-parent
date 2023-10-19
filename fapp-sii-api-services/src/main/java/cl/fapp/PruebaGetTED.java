package cl.fapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.internal.build.AllowSysOut;

public class PruebaGetTED {

	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><BOLETADefType version=\"1.0\">\r\n"
				+ "<Documento ID=\"B202302271643160000000004\">\r\n"
				+ "<Encabezado>\r\n"
				+ "<IdDoc>\r\n"
				+ "<TipoDTE>39</TipoDTE>\r\n"
				+ "<Folio>4</Folio>\r\n"
				+ "<FchEmis>2023-02-27</FchEmis>\r\n"
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
				+ "<F>4</F>\r\n"
				+ "<FE>2023-02-27</FE>\r\n"
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
				+ "<TSTED>2023-02-27T04:43:16</TSTED>\r\n"
				+ "</DD>\r\n"
				+ "<FRMT algoritmo=\"SHA1withRSA\">cZmX0UqWgKuw4aLRwZic+xdcKVCxg2RGKGDTcR26So4DGBFyqHdtw29UgXCXeVce0GBXTumqz4OOR7qRBwJDEQ==</FRMT>\r\n"
				+ "</TED>\r\n"
				+ "<TmstFirma>2023-02-27T04:43:16</TmstFirma>\r\n"
				+ "</Documento>\r\n"
				+ "<Signature xmlns=\"http://www.w3.org/2000/09/xmldsig#\"><SignedInfo><CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/><SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/><Reference URI=\"#B202302271643160000000004\"><Transforms><Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/></Transforms><DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/><DigestValue>O6PvKquY7ACKjWzVVwlLWFRCGng=</DigestValue></Reference></SignedInfo><SignatureValue>MgxG5G/KRswI6HX1Zt2z48rY06oWqMVXJTvOI2SitfDctGodQuleEQBGLKFz+GrGDHKPRXAY2E3pRR55+ek2Ij/8XkCEA9XzBCql0Z1jcwF3nl3cUJoj4OJeho4CDQ/5cEXT6z6PTZrL8LCuaDuW1BdnOKn9K1dBn4ROlB4pM/h/Ds8fy5z80Q7bVdAOPO6+RFOWLD40DeCd18sCJBfhRVsdn6TVYF87JaePBwY7baiQLmrF8v262kvtnoG8QONhfU5OimCG3gO9JAVUqYxHf7T8zpdxnntH+KwDF/x5D1EyvMH77glYtd99dTM56yI/TNHwJ02U6i24cXo6GDakBQ==</SignatureValue><KeyInfo><KeyValue><RSAKeyValue><Modulus>ySS6FARwZZQ2P8zO+xwoB70bSKEQogcMIEMhmBTMoNbKXvkJ7haHtAciTMdKBPoDhLkadQb8xX15Th5DGH3iYWexBrAIKHzlBhj/W2XUYOQT9L+7Byo09ZVdNgrGNbdhdnkQ/O87uUdFRturqgW2zc4xJ02863lnFg+1350pLQDJfdEvtNblNMslie+KSBE+OwSspvTcVAy7to0heu376qPixH7mkUVKUyf/dLRnJ1QUP3fbfF5Q5FXvR1rQLsQeOPVmT7VVoykk/RQOSiKEMumag+YwSAEaUT/pB+SHcp/344bGhJqip4g8GaPkR2baNMc2BVrAhowdTxuR5GxiSw==</Modulus><Exponent>AQAB</Exponent></RSAKeyValue></KeyValue><X509Data><X509Certificate>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</X509Certificate></X509Data></KeyInfo></Signature></BOLETADefType>";

        Pattern pattern = Pattern.compile("<TED version=\"1.0\">(.*?)<\\/TED>" , Pattern.DOTALL);
        Matcher matcher = pattern.matcher(xml);
        if( matcher.find() ) {
        	System.out.println("!! Match TED = " + matcher.group() );
        }else {
        	System.out.println("No hay coincidencis!:.." );
    		String[] tds = StringUtils.substringsBetween(xml, "<TED version=\"1.0\">", "</TED>");
    		for (String td : tds) {
    			System.out.println("td value:" + td); // good
    		}
        }
	}

}
