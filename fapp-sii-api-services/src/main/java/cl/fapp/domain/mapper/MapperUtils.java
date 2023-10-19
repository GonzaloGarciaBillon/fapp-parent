package cl.fapp.domain.mapper;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;

import org.w3c.dom.Document;

import cl.fapp.SiiDocumentFactoryConfiguration;
import cl.fapp.common.xml.XMLUtils;
import cl.fapp.foliomanager.domain.Folio;
import cl.fapp.sii.jaxb.BOLETADefType;
import cl.fapp.sii.jaxb.DTE;
import cl.fapp.sii.jaxb.ObjectFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapperUtils {
	static ObjectFactory jaxbFactory = new ObjectFactory();
	
	/**
	 * Convierte un CAF de tipo {@link DTE.Documento.TED.DD.CAF} a {@link BOLETADefType.Documento.TED.DD.CAF}
	 * <br>Se utiliza para obtener el TED
	 * @param caf el CAF de tipo {@link DTE.Documento.TED.DD.CAF}
	 * @return el CAF de tipo {@link BOLETADefType.Documento.TED.DD.CAF}
	 */
	public static BOLETADefType.Documento.TED.DD.CAF convert(DTE.Documento.TED.DD.CAF caf) {
		
		BOLETADefType.Documento.TED.DD.CAF.DA.DSAPK dsapk = null;
		if( caf.getDA().getDSAPK()!=null) {
			dsapk = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAFDADSAPK();
			dsapk.setG(caf.getDA().getDSAPK().getG());
			dsapk.setP(caf.getDA().getDSAPK().getP());
			dsapk.setQ(caf.getDA().getDSAPK().getQ());
			dsapk.setY(caf.getDA().getDSAPK().getY());
		}
		
		BOLETADefType.Documento.TED.DD.CAF.DA.RSAPK rsapk = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAFDARSAPK();
		rsapk.setE(caf.getDA().getRSAPK().getE());
		rsapk.setM(caf.getDA().getRSAPK().getM());
		
		BOLETADefType.Documento.TED.DD.CAF.DA.RNG rng = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAFDARNG();
		rng.setD(caf.getDA().getRNG().getD());
		rng.setH(caf.getDA().getRNG().getH());
		
		BOLETADefType.Documento.TED.DD.CAF.FRMA frma = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAFFRMA();
		frma.setAlgoritmo(caf.getFRMA().getAlgoritmo());
		frma.setValue(caf.getFRMA().getValue());
		
		BOLETADefType.Documento.TED.DD.CAF.DA da = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAFDA();
		da.setDSAPK(dsapk);
		da.setFA(caf.getDA().getFA());
		da.setIDK(caf.getDA().getIDK());
		da.setRE(caf.getDA().getRE());
		da.setRNG(rng);
		da.setRS(caf.getDA().getRS());
		da.setRSAPK(rsapk);
		da.setTD(caf.getDA().getTD());
		
		BOLETADefType.Documento.TED.DD.CAF cafBoletaDeftype = jaxbFactory.createBOLETADefTypeDocumentoTEDDDCAF();
		cafBoletaDeftype.setDA(da);
		cafBoletaDeftype.setFRMA(frma);
		cafBoletaDeftype.setVersion(caf.getVersion());
		
		return cafBoletaDeftype;
	}
	
	/**
	 * Convierte un CAF de tipo {@link DTE.Documento.TED.DD.CAF} a {@link DTE.Documento.TED.DD.CAF}
	 * <br>Se utiliza para obtener el TED
	 * @param caf el CAF de tipo {@link DTE.Documento.TED.DD.CAF}
	 * @return el CAF de tipo {@link DTE.Documento.TED.DD.CAF}
	 */
	public static DTE.Documento.TED.DD.CAF convertToDTECAF(DTE.Documento.TED.DD.CAF caf) {
		
		DTE.Documento.TED.DD.CAF.DA.DSAPK dsapk = null;
		if( caf.getDA().getDSAPK()!=null) {
			dsapk = jaxbFactory.createDTEDocumentoTEDDDCAFDADSAPK();
			dsapk.setG(caf.getDA().getDSAPK().getG());
			dsapk.setP(caf.getDA().getDSAPK().getP());
			dsapk.setQ(caf.getDA().getDSAPK().getQ());
			dsapk.setY(caf.getDA().getDSAPK().getY());
		}
		
		DTE.Documento.TED.DD.CAF.DA.RSAPK rsapk = jaxbFactory.createDTEDocumentoTEDDDCAFDARSAPK();
		rsapk.setE(caf.getDA().getRSAPK().getE());
		rsapk.setM(caf.getDA().getRSAPK().getM());
		
		DTE.Documento.TED.DD.CAF.DA.RNG rng = jaxbFactory.createDTEDocumentoTEDDDCAFDARNG();
		rng.setD(caf.getDA().getRNG().getD());
		rng.setH(caf.getDA().getRNG().getH());
		
		DTE.Documento.TED.DD.CAF.FRMA frma = jaxbFactory.createDTEDocumentoTEDDDCAFFRMA();
		frma.setAlgoritmo(caf.getFRMA().getAlgoritmo());
		frma.setValue(caf.getFRMA().getValue());
		
		DTE.Documento.TED.DD.CAF.DA da = jaxbFactory.createDTEDocumentoTEDDDCAFDA();
		da.setDSAPK(dsapk);
		da.setFA(caf.getDA().getFA());
		da.setIDK(caf.getDA().getIDK());
		da.setRE(caf.getDA().getRE());
		da.setRNG(rng);
		da.setRS(caf.getDA().getRS());
		da.setRSAPK(rsapk);
		da.setTD(caf.getDA().getTD());
		
		DTE.Documento.TED.DD.CAF cafBoletaDeftype = jaxbFactory.createDTEDocumentoTEDDDCAF();
		cafBoletaDeftype.setDA(da);
		cafBoletaDeftype.setFRMA(frma);
		cafBoletaDeftype.setVersion(caf.getVersion());
		
		return cafBoletaDeftype;
	}
	
	/**
	 * Carga el CAF que se indica en el {@link Folio}
	 * @param folio estructura con los datos relacionados a un folio (principalmente datos del CAF)
	 * @return CAF en representacion jaxb
	 */
	public static DTE.Documento.TED.DD.CAF loadCafFromRepository(Folio folio) {
		try {
			// ===================================================================================
			//-->JAXBContext jaxbContextCAF = JAXBContext.newInstance(DTE.Documento.TED.DD.CAF.class);
			//-->Unmarshaller jaxbUnmarshaller = jaxbContextCAF.createUnmarshaller();
			//-->jaxbUnmarshaller.setSchema(null);
			//-->DTE.Documento.TED.DD.CAF caf = (DTE.Documento.TED.DD.CAF)jaxbUnmarshaller.unmarshal(new StringReader(folio.getTagCaf()));
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// unmarshall contenido del caf en la base. Parsea el contenido a un dom
			Document xmlcaf = XMLUtils.readXml(new ByteArrayInputStream(folio.getTagCaf().getBytes(SiiDocumentFactoryConfiguration.DEFAULT_ENCODING)));

			// crea instancias de objetos jaxb, dependiendo si poseen contenido
			
			// subnodo llave es RSA
			String da_rsapk_m = XMLUtils.getText(xmlcaf, "//CAF/DA/RSAPK/M/text()");
			String da_rsapk_e = XMLUtils.getText(xmlcaf, "//CAF/DA/RSAPK/E/text()");
			
			DTE.Documento.TED.DD.CAF.DA.RSAPK rsapk;
			if( da_rsapk_m.isBlank() && da_rsapk_e.isBlank() ) {
				rsapk = null;
			}else {
				rsapk = jaxbFactory.createDTEDocumentoTEDDDCAFDARSAPK();
				rsapk.setM(da_rsapk_m.isBlank() ? null : Base64.getDecoder().decode(da_rsapk_m));
				rsapk.setE(da_rsapk_e.isBlank() ? null : Base64.getDecoder().decode(da_rsapk_e));
			}
			
			// subnodo llave es DSA
			DTE.Documento.TED.DD.CAF.DA.DSAPK dsapk = jaxbFactory.createDTEDocumentoTEDDDCAFDADSAPK();
			String da_dsapk_p = XMLUtils.getText(xmlcaf, "//CAF/DA/DSAPK/P/text()").trim();
			String da_dsapk_q = XMLUtils.getText(xmlcaf, "//CAF/DA/DSAPK/Q/text()").trim();
			String da_dsapk_g = XMLUtils.getText(xmlcaf, "//CAF/DA/DSAPK/G/text()").trim();
			String da_dsapk_y = XMLUtils.getText(xmlcaf, "//CAF/DA/DSAPK/Y/text()").trim();
			
			if( da_dsapk_p.isBlank() && da_dsapk_p.isBlank() && da_dsapk_g.isBlank() && da_dsapk_y.isBlank() ) {
				dsapk = null;
			}else {
				dsapk.setP(da_dsapk_p.isBlank() ? null : da_dsapk_p.getBytes());
				dsapk.setQ(da_dsapk_q.isBlank() ? null : da_dsapk_q.getBytes());
				dsapk.setG(da_dsapk_g.isBlank() ? null : da_dsapk_g.getBytes());
				dsapk.setY(da_dsapk_y.isBlank() ? null : da_dsapk_y.getBytes());
			}

			// subnodo rango
			DTE.Documento.TED.DD.CAF.DA.RNG rng = jaxbFactory.createDTEDocumentoTEDDDCAFDARNG();
			String da_rng_d = XMLUtils.getText(xmlcaf, "//CAF/DA/RNG/D/text()");
			String da_rng_h = XMLUtils.getText(xmlcaf, "//CAF/DA/RNG/H/text()");
			
			if( da_rng_d.isBlank() && da_rng_h.isBlank() ) {
				rng = null;
			}else {
				rng.setD(da_rng_d.isBlank() ? null : BigInteger.valueOf(Integer.parseInt(da_rng_d)));
				rng.setH(da_rng_h.isBlank() ? null : BigInteger.valueOf(Integer.parseInt(da_rng_h)));
			}
			
			// porcion de la firma del caf
			DTE.Documento.TED.DD.CAF.FRMA frma = jaxbFactory.createDTEDocumentoTEDDDCAFFRMA();
			String caf_frma = XMLUtils.getText(xmlcaf, "//CAF/FRMA/text()");
			String caf_frma_alg = XMLUtils.getText(xmlcaf, "//CAF/FRMA/@algoritmo");
			
			if( caf_frma.isBlank() && caf_frma_alg.isBlank() ) {
				frma = null;
			}else {
				frma = jaxbFactory.createDTEDocumentoTEDDDCAFFRMA();
				frma.setAlgoritmo(caf_frma_alg.isBlank() ? null: caf_frma_alg);
				frma.setValue(Base64.getDecoder().decode(caf_frma));
			}

			// subnodo DA
			DTE.Documento.TED.DD.CAF.DA da;
			String da_re = XMLUtils.getText(xmlcaf, "//CAF/DA/RE/text()");
			String da_rs = XMLUtils.getText(xmlcaf, "//CAF/DA/RS/text()");
			String da_td = XMLUtils.getText(xmlcaf, "//CAF/DA/TD/text()");
			String da_idk = XMLUtils.getText(xmlcaf, "//CAF/DA/IDK/text()");
			String da_fa = XMLUtils.getText(xmlcaf, "//CAF/DA/FA/text()");
			
			if (da_re.isBlank() && da_rs.isBlank() && da_td.isBlank() && da_idk.isBlank() && da_fa.isBlank() && dsapk == null && rng == null && rsapk == null && frma == null) {
				da = null;
			} else {
				da = jaxbFactory.createDTEDocumentoTEDDDCAFDA();
				da.setRE(da_re.isBlank() ? null : da_re);
				da.setRS(da_rs.isBlank() ? null : da_rs);
				da.setTD(da_td.isBlank() ? null : BigInteger.valueOf(Integer.parseInt(da_td)));
				da.setIDK(da_idk.isBlank() ? null : Long.parseLong(da_idk));
				da.setFA(dateFormat.parse(da_fa));
				da.setDSAPK(dsapk);
				da.setRNG(rng);
				da.setRSAPK(rsapk);
			}

			// finalmente se crea el objeto caf
			DTE.Documento.TED.DD.CAF caf = jaxbFactory.createDTEDocumentoTEDDDCAF();
			String caf_version = XMLUtils.getText(xmlcaf, "//CAF/@version");
			if( caf_version.isBlank() ) {
				caf_version = null;
			}
			caf.setDA(da);
			caf.setVersion(caf_version);
			caf.setFRMA(frma);
			
			return caf;
			
		}catch(Exception ex) {
			log.debug("No fue posible cargar el caf desde la base de datos. Error:" + ex.getMessage());
			return null;
		}
	}
	
	/**
	 * Crea una primaryKey utilizando pkcs#8
	 * @param pkcs8Bytes bytes en formato pkcs8
	 * @return la llave privada
	 * @throws GeneralSecurityException
	 */
	private static PrivateKey readPkcs8PrivateKey(byte[] pkcs8Bytes) throws GeneralSecurityException {
	    KeyFactory keyFactory = KeyFactory.getInstance("RSA", "SunRsaSign");
	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pkcs8Bytes);
	    try {
	        return keyFactory.generatePrivate(keySpec);
	    } catch (InvalidKeySpecException e) {
	        throw new IllegalArgumentException("Unexpected key format!", e);
	    }
	}

	/**
	 * Crea una primaryKey utilizando pkcs#1
	 * @param pkcs1Bytes bytes en formato pkcs1
	 * @return la llave privadad
	 * @throws GeneralSecurityException
	 */
	public static PrivateKey readPkcs1PrivateKey(byte[] pkcs1Bytes) throws GeneralSecurityException {
	    // no es posible usar las apis de java para procesar estructuras asn.1, asi que se construye un pkcs8 que java si soporta
	    int pkcs1Length = pkcs1Bytes.length;
	    int totalLength = pkcs1Length + 22;
	    byte[] pkcs8Header = new byte[] {
	            0x30, (byte) 0x82, (byte) ((totalLength >> 8) & 0xff), (byte) (totalLength & 0xff), // Sequence + total length
	            0x2, 0x1, 0x0, // Integer (0)
	            0x30, 0xD, 0x6, 0x9, 0x2A, (byte) 0x86, 0x48, (byte) 0x86, (byte) 0xF7, 0xD, 0x1, 0x1, 0x1, 0x5, 0x0, // Sequence: 1.2.840.113549.1.1.1, NULL
	            0x4, (byte) 0x82, (byte) ((pkcs1Length >> 8) & 0xff), (byte) (pkcs1Length & 0xff) // Octet string + length
	    };
	    byte[] pkcs8bytes = join(pkcs8Header, pkcs1Bytes);
	    return readPkcs8PrivateKey(pkcs8bytes);
	}

	/**
	 * Junta dos arreglos de bytes en uno solo
	 * @param byteArray1 arreglo 1
	 * @param byteArray2 arreglo 2
	 * @return arreglo 1 U arreglo 2
	 */
	private static byte[] join(byte[] byteArray1, byte[] byteArray2){
	    byte[] bytes = new byte[byteArray1.length + byteArray2.length];
	    System.arraycopy(byteArray1, 0, bytes, 0, byteArray1.length);
	    System.arraycopy(byteArray2, 0, bytes, byteArray1.length, byteArray2.length);
	    return bytes;
	}

}
