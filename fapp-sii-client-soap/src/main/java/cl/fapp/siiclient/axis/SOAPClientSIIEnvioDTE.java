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
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import cl.fapp.siiclient.axis.domain.envio.DTEEnvioRequest;
import cl.fapp.siiclient.axis.domain.envio.RECEPCIONDTE;
import lombok.extern.slf4j.Slf4j;

/**
 * Servicio de envio de DTE's.
 * Utiliza la version SOAP de los servicios del SII.
 * Se emplea para el envio de documentos diferentes a Boleta.
 * 
 */
@Slf4j
@Configuration
@PropertySource("classpath:soap-siiclient.properties")
@Service
public class SOAPClientSIIEnvioDTE {

	@Value("${soap.dte.api.envio}")
	private String dteApiEnvio;

	@Value("${soap.dte.envio.url}")
	private String dteEnvioUrl;

	@Value("${soap.dte.status.url}")
	private String dteStatusUrl;

	/**
	 * Envia un DTE empleando servicios SOAP de SII.
	 * 
	 * @param request  parametros de entrada
	 * @param file     contenido del archivo a enviar
	 * @param filename nombre con el cual denominar el contenido del archivo
	 * @param token    token obtenido desde los servicios de autenticacion SOAP
	 * @return resultado del envio. Un String XML de tipo {@link RECEPCIONDTE}
	 */
	public String sendDTE(DTEEnvioRequest request, byte[] file, String filename, String token) {

		// verifica si se indica nombre del archivo. Si no se indica, establece un nombre por defecto
		if (filename == null) {
			filename = "sendDTE.xml";
		}

		// realiza la llamada al servicio
		try {
			log.debug("Enviando DTE con: filename=" + filename + ", token=" + token + ", request=" + request);

			String response = makeSoapRequest(dteApiEnvio, dteApiEnvio + dteEnvioUrl, request, file, filename, token);
			if (response == null) {
				log.error("Ocurrio un error realizando el envio del DTE");
				throw new Exception("Error enviando el DTE");

			} else {

				//String result = EntityUtils.toString(response.getEntity());
				log.debug("Respuesta makeSoapRequest recibida=" + response);
				return response;
			}

		} catch (Exception ex) {
			log.error("Se produjo un error enviando DTE. Error=" + ex.getMessage());
			return null;
		}
	}

	/**
	 * Realiza la llamada SOAP al servicio de EnvioDTE del SII
	 * 
	 * @param hostEnvio host al cual enviar el request
	 * @param urlEnvio  url del servicio (sin host)
	 * @param request   request con el cual invocar el servicio
	 * @param file      archivo con el xml que se envia
	 * @param filename  nombre del archivo
	 * @param token     token a utilizar (obtenido mediante los servicios getSemilla y getToken del SII
	 * @return String con la respuesta del servicio SOAP
	 */
	private String makeSoapRequest(String hostEnvio, String urlEnvio, DTEEnvioRequest request, byte[] file, String filename, String token) {
		try {
			// define el contexto ssl a utilizar en la comunicacion
			//-->TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
			//-->SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, acceptingTrustStrategy).build();

			// crea una instancia del cliente http
			//-->//-->CloseableHttpClient clientInstance = HttpClients.custom().setSSLContext(sslContext).setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
			CloseableHttpClient httpClient = HttpClients.createDefault();
			HttpPost httpPost = new HttpPost(urlEnvio);
			httpPost.addHeader("Accept", "application/xml");
			httpPost.addHeader("Cookie", "TOKEN=" + token);
			//-->//-->httpPost.addHeader(new BasicHeader(HttpHeaders.USER_AGENT, "Fapp/49.0 ( compatible; PROG 1.0; Windows NT)"));

			// prepara el contenido del mensaje
			//-->//FileBody bin = new FileBody();
			File tempFile = File.createTempFile(filename, "xml");
			FileOutputStream fos = new FileOutputStream(tempFile);
			fos.write(file);
			fos.close();

			//-->ContentBody contentBody = new InputStreamBody(new ByteArrayInputStream(file), filename);
			FileBody bin = new FileBody(tempFile);

			StringBody stringBodyRutSender = new StringBody(request.getRutSender(), ContentType.TEXT_PLAIN);
			StringBody stringBodyDvSender = new StringBody(request.getDvSender(), ContentType.TEXT_PLAIN);
			StringBody stringBodyRutCompany = new StringBody(request.getRutCompany(), ContentType.TEXT_PLAIN);
			StringBody stringBodyDvCompany = new StringBody(request.getDvCompany(), ContentType.TEXT_PLAIN);

			// crea el cuerpo del mensaje
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.addPart("rutSender", stringBodyRutSender);
			builder.addPart("dvSender", stringBodyDvSender);
			builder.addPart("rutCompany", stringBodyRutCompany);
			builder.addPart("dvCompany", stringBodyDvCompany);
			//-->//-->builder.addPart("archivo", contentBody);
			builder.addPart("archivo", bin);

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
