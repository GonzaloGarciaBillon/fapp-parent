package cl.fapp.docs;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.fapp.sii.factory.SIIAbstractFactory;
import cl.fapp.sii.jaxb.AUTORIZACION;

public class DocumentoCAFBoleta extends SIIAbstractFactory<AUTORIZACION> {
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public String toXml(AUTORIZACION data, String urlSchemaLocation) throws UnsupportedEncodingException {

		AUTORIZACION autorizacion = new AUTORIZACION();
		AUTORIZACION.CAF caf = new AUTORIZACION.CAF();

		AUTORIZACION.CAF.DA da = new AUTORIZACION.CAF.DA();
		AUTORIZACION.CAF.DA.DSAPK dsapk = new AUTORIZACION.CAF.DA.DSAPK();
		dsapk.setG("G".getBytes());
		dsapk.setP("P".getBytes());
		dsapk.setQ("Q".getBytes());
		dsapk.setY("Y".getBytes());

		da.setDSAPK(dsapk);
		da.setFA(new Date());
		da.setIDK(100);
		da.setRE("RE");

		AUTORIZACION.CAF.DA.RNG rng = new AUTORIZACION.CAF.DA.RNG();
		rng.setD(BigInteger.valueOf(10));
		rng.setH(BigInteger.valueOf(20));

		da.setRNG(rng);
		da.setRS("RS");

		AUTORIZACION.CAF.DA.RSAPK rsapk = new AUTORIZACION.CAF.DA.RSAPK();
		rsapk.setE("EXPONENT".getBytes());
		rsapk.setM("MODULUS".getBytes());
		da.setRSAPK(rsapk);
		da.setTD(BigInteger.valueOf(39));

		caf.setDA(da);

		AUTORIZACION.CAF.FRMA frma = new AUTORIZACION.CAF.FRMA();
		frma.setAlgoritmo("RSAWith");
		frma.setValue("VALUE".getBytes());

		caf.setFRMA(frma);
		String version = "1.0";
		caf.setVersion(version);

		autorizacion.setCAF(caf);

		String xmlContent = getXml(autorizacion, null, false); //"http://www.sii.cl/SiiDte ConsumoFolio_v10.xsd");
		logger.info(xmlContent);
		
		return xmlContent;
	}
}
