package cl.fapp.restapi.freshdesk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.AuthSchemeBase;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FreshdeskHelpers {
	@Value("${freshdesk.api.url}")
	private String freshdeskApiUrl;

	@Value("${freshdesk.api.key}")
	private String freshdeskapiKey;

	/**
	 * Crea un ticket en Freshdesk
	 * 
	 * @param request propiedades del ticket
	 * @return httpStatus resultado de ejecutar operacion
	 */
	public FreshdeskCreateTicketResponse createTicket(FreshdeskCreateTicketRequest request) {

		FreshdeskCreateTicketResponse respuesta = new FreshdeskCreateTicketResponse();
		try {
			final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
			final RequestBuilder reqBuilder = RequestBuilder.post();
			final RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();

			URL url = new URL(freshdeskApiUrl);
			final String urlHost = url.getHost();
			final int urlPort = url.getPort();
			final String urlProtocol = url.getProtocol();
			reqBuilder.setUri(url.toURI());

			// autenticacion
			List<String> authPrefs = new ArrayList<>();
			authPrefs.add(AuthSchemes.BASIC);
			requestConfigBuilder.setTargetPreferredAuthSchemes(authPrefs);

			// configura el cliente http
			CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(new AuthScope(urlHost, urlPort, AuthScope.ANY_REALM), new UsernamePasswordCredentials(freshdeskapiKey, "X"));

			httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

			AuthCache authCache = new BasicAuthCache();
			AuthSchemeBase authSchemeBase = new BasicScheme();
			authCache.put(new HttpHost(urlHost, urlPort, urlProtocol), authSchemeBase);

			HttpClientContext httpClientContext = HttpClientContext.create();
			httpClientContext.setAuthCache(authCache);

			// body
			ObjectMapper mapeador = new ObjectMapper();
			final String jsonBody = mapeador.writeValueAsString(request);

			HttpEntity entity = new StringEntity(jsonBody, ContentType.APPLICATION_JSON.withCharset(Charset.forName("utf-8")));
			reqBuilder.setEntity(entity);

			// configura el request
			RequestConfig requestConfig = requestConfigBuilder.build();
			reqBuilder.setConfig(requestConfig);

			// realiza la invocacion
			HttpClient httpClient = httpClientBuilder.build();
			HttpUriRequest req = reqBuilder.build();
			HttpResponse response = httpClient.execute(req, httpClientContext);

			// recupera la respuesta
			HttpEntity body = response.getEntity();
			InputStream is = body.getContent();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("utf-8")));
			String line;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			int responseStatus = response.getStatusLine().getStatusCode();
			String responseBody = sb.toString();

			log.debug("Response Status: " + responseStatus);
			log.debug("Body:" + responseBody);
			if (responseStatus > 400) {
				log.error("X-Request-Id: " + response.getFirstHeader("x-request-id").getValue());
				respuesta.setCreated(false);
				respuesta.setRequest(jsonBody);
				respuesta.setResponse(responseBody);
				respuesta.setTicketValue(null);

			} else if (responseStatus == 201) {
				//For creation response_status is 201 where are as for other actions it is 200
				try {
					JsonNode responseJson = mapeador.readTree(responseBody);
					respuesta.setCreated(true);
					respuesta.setRequest(jsonBody);
					respuesta.setResponse(responseBody);
					respuesta.setTicketValue(responseJson.get("id").asText());
					log.info("Ticket Creation Successfull. Ticket ID: " + responseJson.get("id") + "Location : " + response.getFirstHeader("location").getValue());

				} catch (JsonProcessingException e) {
					log.warn("El ticket fue creado, pero no es posible obtener su id => no se registra como creado en entidad SupportTicket");
					log.warn("Request=" + jsonBody);
					log.warn("Respuesta=" + responseBody);
					respuesta.setCreated(false);
					log.error("Error in JSON Parsing :" + e.getMessage());
				}
			}
			return respuesta;

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
			respuesta.setMessage("MalformedURLException");
			respuesta.setCreated(false);
			return respuesta;

		} catch (URISyntaxException e1) {
			e1.printStackTrace();
			respuesta.setMessage("URISyntaxException");
			respuesta.setCreated(false);
			return respuesta;

		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
			respuesta.setMessage("JsonProcessingException");
			respuesta.setCreated(false);
			return respuesta;

		} catch (ClientProtocolException e1) {
			e1.printStackTrace();
			respuesta.setMessage("ClientProtocolException");
			respuesta.setCreated(false);
			return respuesta;

		} catch (IOException e1) {
			e1.printStackTrace();
			respuesta.setMessage("IOException");
			respuesta.setCreated(false);
			return respuesta;
		}
	}
}
