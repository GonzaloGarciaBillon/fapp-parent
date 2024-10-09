package cl.fapp.siiclient.axis;

import java.io.StringReader;
import java.rmi.RemoteException;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.kernel.http.HTTPConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.fapp.siiclient.axis.crseed.CrSeedServiceStub;
import cl.fapp.siiclient.axis.crseed.CrSeedServiceStub.GetSeed;
import cl.fapp.siiclient.axis.crseed.CrSeedServiceStub.GetSeedResponse;
import cl.fapp.siiclient.axis.gettoken.GetTokenFromSeedServiceStub;
import cl.fapp.siiclient.axis.gettoken.GetTokenFromSeedServiceStub.GetToken;
import cl.fapp.siiclient.axis.gettoken.GetTokenFromSeedServiceStub.GetTokenResponse;
import cl.fapp.siiclient.boletas.domain.semilla.BoletaSemillaResponse;
import cl.fapp.siiclient.boletas.domain.token.BoletaTokenResponse;
import cl.fapp.siiclient.digitalsignature.SignatureSemillaFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * Servicios involucrados en la autenticacion para utilizar servicios SOAP del SII.
 */
@Slf4j
@Service
@Configuration
@PropertySource("classpath:soap-siiclient-${spring.profiles.active:cert}.properties")
public class SOAPClientSIIAuthentication {

	@Value("${soap.semilla.url}")
	private String soapSemillaUrl;

	@Value("${soap.token.url}")
	private String soapTokenUrl;

	/**
	 * Encapsula la obtencion de un token. Obtiene una semilla, la firma y solicita un token
	 * 
	 * @param cert certificado con el cual firmar la semilla
	 * @param pk   llave privada para encriptar la semilla
	 * @return un token
	 */
	public String getToken(X509Certificate cert, PrivateKey pk) {
		try {

			if (soapSemillaUrl == null || soapTokenUrl == null || cert == null || pk == null) {
				throw new Exception("Parametros incompletos");
			}

			// solicita una semilla
			String xmlGetSeed = invokeGetSeedService(soapSemillaUrl);
			if (xmlGetSeed == null) {
				throw new Exception("Error obteniendo semilla");
			}

			// obtiene semilla, a firma e invoca al servicio que entrega el token
			String seed = parseCrSeedResponse(xmlGetSeed);
			if (seed == null) {
				throw new Exception("Error leyendo semilla");
			}

			String signedseed = signSeed(seed, cert, pk);
			if (signedseed == null) {
				throw new Exception("Error firmando semilla");
			}

			String xmlGetToken = invokeGetTokenService(soapTokenUrl, seed, signedseed);
			if (xmlGetToken == null) {
				throw new Exception("Error obteniendo token");
			}

			// rescata el token del xml de respuesta
			String token = parseGetTokenResponse(xmlGetToken);
			if (token == null) {
				throw new Exception("Error leyendo token");
			}

			log.debug("Token asignado=" + token);

			return token;

		} catch (Exception ex) {
			log.error("No fue posible obtener un token utilizando servicios SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Invoca al servicio que entrega la semilla
	 * 
	 * @param urlCrSeed url del servicio
	 * @return xml de la semilla
	 */
	private String invokeGetSeedService(String urlCrSeed) {
		try {
			CrSeedServiceStub stub = new CrSeedServiceStub(urlCrSeed);
			GetSeed request = new GetSeed();

			GetSeedResponse response = stub.getSeed(request);
			return response.getGetSeedReturn();

		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Invoca servicio que obtiene un token
	 * 
	 * @param urlGetToken url del servicio
	 * @param seed        semilla
	 * @param signedSeed  semilla firmada
	 * @return un token
	 */
	private String invokeGetTokenService(String urlGetToken, String seed, String signedSeed) {
		try {
			GetTokenFromSeedServiceStub stub = new GetTokenFromSeedServiceStub(urlGetToken);
			Options options = stub._getServiceClient().getOptions();

			//-->Map<String, String> props = new HashMap<>();
			//-->props.put("COOKIE", "TOKEN=" + seed);

			//-->options.setProperty(HTTPConstants.HTTP_HEADERS, props);
			options.setProperty(org.apache.axis2.Constants.Configuration.CHARACTER_SET_ENCODING, "UTF-8");
			options.setProperty(HTTPConstants.HEADER_CONTENT_TYPE, "text/xml");
			stub._getServiceClient().setOptions(options);

			GetToken request = new GetToken();
			request.setPszXml(signedSeed);

			GetTokenResponse response = stub.getToken(request);
			return response.getGetTokenReturn();

		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Extrae la semilla de la respuesta del servicio CrSeed
	 * 
	 * @param xml respuesta del servicio
	 * @return semilla. null en caso de no poder recuperarla
	 */
	private String parseCrSeedResponse(String xml) {
		JAXBContext jaxbContext;
		BoletaSemillaResponse response = new BoletaSemillaResponse();
		try {
			jaxbContext = JAXBContext.newInstance(BoletaSemillaResponse.class);
			StringReader reader = new StringReader(xml);
			response = (BoletaSemillaResponse) jaxbContext.createUnmarshaller().unmarshal(reader);
			if (response.getRESP_HDR().getESTADO() != 0) {
				log.error("La respuesta del servicio indica error. RESP_HDR.ESTADO=" + response.getRESP_HDR().getESTADO());
				return null;
			}
			return response.getRESP_BODY().getSEMILLA();
		} catch (JAXBException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	/**
	 * Extrae el token de la respuesta del servicio GetTokenFromSeed
	 * 
	 * @param xml respuesta del servicio
	 * @return token. null en caso de no poder recuperarla
	 */
	private String parseGetTokenResponse(String xml) {
		JAXBContext jaxbContextResponse;
		BoletaTokenResponse response = new BoletaTokenResponse();
		try {
			jaxbContextResponse = JAXBContext.newInstance(BoletaTokenResponse.class);

			StringReader reader = new StringReader(xml);
			response = (BoletaTokenResponse) jaxbContextResponse.createUnmarshaller().unmarshal(reader);
			if (!response.getRESP_HDR().getESTADO().equalsIgnoreCase("00")) {
				log.error("La respuesta del servicio indica error. RESP_HDR.getGLOSA=" + response.getRESP_HDR().getGLOSA());
				return null;
			}
			return response.getRESP_BODY().getTOKEN();
		} catch (JAXBException e) {
			e.printStackTrace();
			log.error(e.getMessage());
			return null;
		}
	}

	/**
	 * Firma un string con el certificado y pk
	 * 
	 * @param seed       semilla
	 * @param cert       certificado
	 * @param privateKey llave privada
	 * @return semilla firmada
	 */
	private String signSeed(String seed, X509Certificate cert, PrivateKey privateKey) {
		String firma = null;
		try {
			SignatureSemillaFactory signatureSemilla = SignatureSemillaFactory.getSigner();
			firma = signatureSemilla.signerWithCertAndPk(seed, cert, privateKey);
			if (firma == null || firma == "") {
				log.error("No fue posible firmar la semilla");
				return null;
			}
			return firma;
		} catch (Exception ex) {
			log.error("Se produjo un error firmando la semilla. Error=" + ex.getMessage());
			return null;
		}
	}
}
