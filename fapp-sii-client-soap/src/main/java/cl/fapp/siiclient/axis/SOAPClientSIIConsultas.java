package cl.fapp.siiclient.axis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.fapp.siiclient.axis.domain.consultas.EstadoDteAVRequest;
import cl.fapp.siiclient.axis.domain.consultas.EstadoDteRequest;
import cl.fapp.siiclient.axis.domain.consultas.EstadoUploadRequest;
import cl.fapp.siiclient.axis.query.estdte.QueryEstDteServiceStub;
import cl.fapp.siiclient.axis.query.estdte.QueryEstDteServiceStub.GetEstDte;
import cl.fapp.siiclient.axis.query.estdte.QueryEstDteServiceStub.GetEstDteResponse;
import cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub;
import cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAv;
import cl.fapp.siiclient.axis.query.estdteav.QueryEstDteAvServiceStub.GetEstDteAvResponse;
import cl.fapp.siiclient.axis.query.estup.QueryEstUpServiceStub;
import cl.fapp.siiclient.axis.query.estup.QueryEstUpServiceStub.GetEstUp;
import cl.fapp.common.os.OsController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Configuration
@PropertySource("classpath:soap-siiclient-${spring.profiles.active:cert}.properties")
public class SOAPClientSIIConsultas {

	@Value("${soap.query.estado.dte.url}")
	private String soapEstadoDteUrl;

	@Value("${soap.query.estado.dte.av.url}")
	private String soapEstadoDteAvanzadaUrl;

	@Value("${soap.query.estado.upload.url}")
	private String soapEstadoUploadUrl;

	
	OsController osController;

	/**
	 * Invoca servicio SOAP de consulta de estado de un DTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeEstadoDteService(String token, EstadoDteRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ConsultaEstado=" + params);
			QueryEstDteServiceStub stub = new QueryEstDteServiceStub(soapEstadoDteUrl);

			GetEstDte request = new GetEstDte();
			request.setToken(token);
			request.setDvCompania(params.getDvCompania());
			request.setDvConsultante(params.getDvConsultante());
			request.setDvReceptor(params.getDvReceptor());
			request.setFechaEmisionDte(params.getFechaEmisionDte());
			request.setFolioDte(params.getFolioDte());
			request.setMontoDte(params.getMontoDte());
			request.setRutCompania(params.getRutCompania());
			request.setRutConsultante(params.getRutConsultante());
			request.setRutReceptor(params.getRutReceptor());
			request.setTipoDte(params.getTipoDte());
			request.setToken(token);

			GetEstDteResponse response = stub.getEstDte(request);
			return response.getGetEstDteReturn();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Invoca servicio SOAP de consulta de estado avanzada de un DTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeEstadoDteAVService(String token, EstadoDteAVRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ConsultaEstadoAvanzada=" + params);
			QueryEstDteAvServiceStub stub = new QueryEstDteAvServiceStub(soapEstadoDteAvanzadaUrl);

			GetEstDteAv request = new GetEstDteAv();
			request.setToken(token);
			request.setDvEmpresa(params.getDvEmpresa());
			request.setDvReceptor(params.getDvReceptor());
			request.setFechaEmisionDte(params.getFechaEmisionDte());
			request.setFirmaDte(params.getFirmaDte());
			request.setFolioDte(params.getFolioDte());
			request.setMontoDte(params.getMontoDte());
			request.setRutEmpresa(params.getRutEmpresa());
			request.setRutReceptor(params.getRutReceptor());
			request.setTipoDte(params.getTipoDte());

			GetEstDteAvResponse response = stub.getEstDteAv(request);
			return response.getGetEstDteAvReturn();

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Invoca servicio SOAP de consulta el estado de un EnvioDTE
	 * 
	 * @param token  token a utilizar
	 * @param params input del servicio
	 * @return respuesta del servicio SOAP del SII
	 */
	public String invokeEstadoUploadService(String token, EstadoUploadRequest params) {
		try {
			log.debug("Parametros para SOAP-DTE-ConsultaEstadoUpload=" + params);
			log.debug("URL Upload: "+soapEstadoUploadUrl);
			QueryEstUpServiceStub stub = new QueryEstUpServiceStub(soapEstadoUploadUrl);

			GetEstUp request = new GetEstUp();
			request.setToken(token);
			request.setDvCompania(params.getDvCompania());
			request.setRutCompania(params.getRutCompania());
			request.setTrackId(params.getTrackId());

			// GetEstUpResponse response = stub.getEstUp(request);
			String response = makeSoapRequest(soapEstadoUploadUrl, request, token);
			log.debug("Respuesta estado upload: "+response);
			return response;

		} catch (Exception ex) {
			log.error("Se produjo un error invocando el servicio SOAP. Error=" + ex.getMessage());
			return null;
		}
	}

	private String makeSoapRequest(String urlConsulta, GetEstUp  request, String token) {
		try {
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(urlConsulta);
			httpPost.addHeader("Accept", "application/xml");
			httpPost.addHeader("Cookie", "TOKEN=" + token);

			StringBody stringBodyRutCompany = new StringBody(request.getRutCompania(), ContentType.TEXT_PLAIN);
			StringBody stringBodyDvCompany = new StringBody(request.getDvCompania(), ContentType.TEXT_PLAIN);
			StringBody stringBodyTrackId = new StringBody(request.getTrackId(), ContentType.TEXT_PLAIN);

			// crea el cuerpo del mensaje
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("trackId", stringBodyTrackId);
			builder.addPart("rutCompania", stringBodyRutCompany);
			builder.addPart("dvCompaia", stringBodyDvCompany);
			

			// establece parametros
			HttpEntity entity = builder.build();
			httpPost.setEntity(entity);

			// realiza el post al servicio
			CloseableHttpResponse httpResponse = httpClient.execute(httpPost);

			log.debug("POST response status-code=" + httpResponse.getStatusLine().getStatusCode());

			BufferedReader reader = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));

			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();

			// muestra la respuesta acumulada
			log.debug("Response=" + response.toString());
			httpClient.close();

			return response.toString();

		} catch (Exception ex) {
			log.error("Ocurrio un error realizado SOAP-request. Error=" + ex.getMessage());
			return null;
		}
	}
}
