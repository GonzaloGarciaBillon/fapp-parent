package cl.fapp.siiclient.boletas;

import java.io.StringReader;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Optional;

import javax.net.ssl.SSLException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioRequest;
import cl.fapp.siiclient.boletas.domain.envio.BoletaEnvioResponse;
import cl.fapp.siiclient.boletas.domain.envio.DteEnvioRequest;
import cl.fapp.siiclient.boletas.domain.envio.DteEnvioResponse;
import cl.fapp.siiclient.boletas.domain.envio.status.BoletaEnvioStatusResponse;
import cl.fapp.siiclient.boletas.domain.semilla.BoletaSemillaResponse;
import cl.fapp.siiclient.boletas.domain.status.BoletaStatusResponse;
import cl.fapp.siiclient.boletas.domain.token.BoletaTokenResponse;
import cl.fapp.siiclient.boletas.exception.SiiClientNotAuthorizeException;
import cl.fapp.siiclient.boletas.exception.SiiClientWebClientException;
import cl.fapp.siiclient.digitalsignature.SignatureSemillaFactory;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
// import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
// import sun.misc.BASE64Encoder;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
@PropertySource("classpath:siiclient-${spring.profiles.active:cert}.properties")

/**
 * Servicio Rest de comunicación con el SII
 */
@Service
public class SiiClientServiceRestImp implements SiiClientService {

	private static final Logger logger = LoggerFactory.getLogger(SiiClientServiceRestImp.class);

	private WebClient webClient;

	@Value("${boleta.api}")
	private String boletaApi;

	@Value("${boleta.api.envio}")
	private String boletaApiEnvio;

	@Value("${boleta.semilla.url}")
	private String boletaSemillaUrl;

	@Value("${boleta.token.url}")
	private String boletaTokenUrl;

	@Value("${boleta.envio.url}")
	private String boletaEnvioUrl;

	@Value("${boleta.status.url}")
	private String boletaStatusUrl;
	
	@Value("${dte.api}")
	private String dteApi;
	
	@Value("${dte.envio.url}")
	private String dteEnvioUrl;

	private String getSemilla() {

		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();

			final HttpClient httpClientForTls12 = HttpClient.create()
					//.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
					.secure(ssl -> ssl.sslContext(sslContextForTls12));

			WebClient webClient = WebClient.builder().baseUrl(boletaApi)
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12))
					.filter(logRequest())
					.build();

			Mono<String> result = webClient.get().uri(boletaSemillaUrl).accept(MediaType.APPLICATION_XML).retrieve()
					.onStatus(status -> status.value() != HttpStatus.OK.value(),
							response -> Mono.error(new SiiClientWebClientException("Problema con el servicio "
									+ boletaSemillaUrl + ". Status code " + response.statusCode().value())))
					.bodyToMono(String.class);
			
			JAXBContext jaxbContext;
			BoletaSemillaResponse boletaSemillaResponse = new BoletaSemillaResponse();
			try {
				jaxbContext = JAXBContext.newInstance(BoletaSemillaResponse.class);
				String respuesta = result.block();
				if (respuesta == null) {
					logger.warn("Ha ocurrido un error en la respuesta del servicio. La respuesta es null.");
					return null;
				}
				logger.debug("Response: " + respuesta);
				StringReader reader = new StringReader(respuesta);
				boletaSemillaResponse = (BoletaSemillaResponse) jaxbContext.createUnmarshaller().unmarshal(reader);
				if (boletaSemillaResponse.getRESP_HDR().getESTADO() != 0) {
					logger.error("Ha ocurrido un error en la respuesta del servicio. RESP_HDR.ESTADO no es 0");
					return null;
				}
			} catch (JAXBException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}
			return boletaSemillaResponse.getRESP_BODY().getSEMILLA();

		} catch (SSLException e) {
			e.printStackTrace();
			return null;

		}
	}

	
	/**
	 * Obtiene un token
	 * 
	 * @param cert
	 * @param privateKey
	 * @return token
	 */
	@Override
	public String getToken(X509Certificate cert, PrivateKey privateKey) {
		return doToken(cert, privateKey);
	}



	private String doToken(X509Certificate cert, PrivateKey privateKey) {

		// Get Semilla
		String semilla = this.getSemilla();
		logger.debug("Semilla obtenida " + semilla);
		if (semilla == null || semilla == "") {
			logger.error("No hay semilla para firmar");
			return null;
		}
		// Sign Semilla
		String firma;
		try {
			SignatureSemillaFactory signatureSemilla = SignatureSemillaFactory.getSigner();
			firma = signatureSemilla.signerWithCertAndPk(semilla, cert, privateKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		if (firma == null || firma == "") {
			logger.error("No se ha obtenido una firma");
			return null;
		}
		//-->logger.debug("Firma obtenida " + firma);

		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();

			final HttpClient httpClientForTls12 = HttpClient.create()
					//.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
					.secure(ssl -> ssl.sslContext(sslContextForTls12));

			this.webClient = WebClient.builder().baseUrl(boletaApi)
					.defaultHeader(HttpHeaders.CONTENT_TYPE, "application/xml")
					.defaultHeader(HttpHeaders.ACCEPT, "application/xml")
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12)).filter(logRequest()) // logging
					.build();

			Mono<String> result = webClient.post().uri(boletaTokenUrl)
					.contentType(MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML)
					.body(Mono.just(firma), String.class).retrieve()
					.onStatus(status -> status.value() != HttpStatus.OK.value(),
							response -> Mono.error(new SiiClientWebClientException("Problema con el servicio "
									+ boletaTokenUrl + ". Status code " + response.statusCode().value())))
					.bodyToMono(String.class);

			JAXBContext jaxbContextResponse;
			BoletaTokenResponse boletaTokenResponse = new BoletaTokenResponse();
			try {
				jaxbContextResponse = JAXBContext.newInstance(BoletaTokenResponse.class);
				// Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
				String respuesta = result.block();
				if (respuesta == null) {
					logger.warn("Ha ocurrido un error en la respusesta del servicio. La respuesta es null.");
					return null;
				}
				logger.debug("Response: " + respuesta);
				StringReader reader = new StringReader(respuesta);
				boletaTokenResponse = (BoletaTokenResponse) jaxbContextResponse.createUnmarshaller().unmarshal(reader);
				if (!boletaTokenResponse.getRESP_HDR().getESTADO().equalsIgnoreCase("00")) {
					logger.error("Error servicio " + boletaTokenUrl + " - RESP_HDR.ESTADO no es 00. Error SII: "
							+ boletaTokenResponse.getRESP_HDR().getGLOSA());
					return null;
				}
			} catch (JAXBException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}

			return boletaTokenResponse.getRESP_BODY().getTOKEN();

		} catch (SSLException e) {
			e.printStackTrace();
			return null;

		}

	}
	
	/**
	 * Envia dte
	 * 
	 * @param file
	 * @param token
	 * @return
	 * @throws SiiClientNotAuthorizeException
	 */
	@Override
	public DteEnvioResponse sendBDte(DteEnvioRequest dteEnvioRequest, byte[] file, String fileName, String token) throws SiiClientNotAuthorizeException {
		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();
			final HttpClient httpClientForTls12 = HttpClient.create().secure(ssl -> ssl.sslContext(sslContextForTls12));
			
			if (logger.isDebugEnabled()){
				httpClientForTls12.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}
			
			this.webClient = WebClient.builder().baseUrl(dteApi) // solo para post
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12))
					.filter(logRequest()) // logging
					.build();

			//-->final MultipartBodyBuilder builder = new MultipartBodyBuilder();
			//-->builder.part("archivo", new ByteArrayResource(file)).filename(fileName);
			

			final MultipartBodyBuilder builder = new MultipartBodyBuilder();
			builder.part("rutSender", dteEnvioRequest.getRutSender());
			builder.part("dvSender", dteEnvioRequest.getDvSender());
			builder.part("rutCompany", dteEnvioRequest.getRutCompany());
			builder.part("dvCompany", dteEnvioRequest.getDvCompany());

			builder.part("archivo", new ByteArrayResource(file)).filename(fileName);
			//builder.part("archivo", file);

			//Mono<DteEnvioResponse> result = webClient.post().uri(dteEnvioUrl)
					Mono<String> result = webClient.post().uri(dteEnvioUrl)
					.contentType(MediaType.MULTIPART_FORM_DATA)
					.header(HttpHeaders.COOKIE, "TOKEN=" + token + " ")
					.header(HttpHeaders.USER_AGENT, "Fapp/49.0 ( compatible; PROG 1.0; Windows NT)")
					.body(BodyInserters.fromMultipartData(builder.build()))
					.retrieve()
					
				.onStatus(status -> status.value() == HttpStatus.UNAUTHORIZED.value(), // 401
					response -> Mono.error(new SiiClientNotAuthorizeException("Error de autorización")))
	
				.onStatus(status -> status.value() != HttpStatus.OK.value(),
						response -> Mono.error(new SiiClientWebClientException("Problema con el servicio "
								+ dteEnvioUrl + ". Status code " + response.statusCode().value())))

					//.bodyToMono(DteEnvioResponse.class); // .block();
			.bodyToMono(String.class);
					
			// DteEnvioResponse respuesta = result.block();
					String strRespuesta = result.block();
					if (strRespuesta == null) {
						logger.warn("Ha ocurrido un error en la respusesta del servicio. La respuesta es null.");
						return null;
					}
					logger.debug("Response: " + strRespuesta);
					DteEnvioResponse respuesta = new DteEnvioResponse();
					respuesta.setEstado(strRespuesta);
					/*
					StringReader reader = new StringReader(respuesta);
					boletaSemillaResponse = (BoletaSemillaResponse) jaxbContext.createUnmarshaller().unmarshal(reader);
					if (boletaSemillaResponse.getRESP_HDR().getESTADO() != 0) {
						logger.error("Ha ocurrido un error en la respusesta del servicio. RESP_HDR.ESTADO no es 0");
						return null;
					}
					*/					
			
			return respuesta;

		} catch (SSLException e) {
			e.printStackTrace();
			return null;

		}
	}

	/**
	 * Envia set de boletas por FileSystemResource
	 * 
	 * @param boletaEnvioRequest
	 * @param file
	 * @param token
	 * @return
	 * @throws SiiClientNotAuthorizeException
	 */
	@Override
	public BoletaEnvioResponse sendBoletas(BoletaEnvioRequest boletaEnvioRequest, FileSystemResource file, String token)
			throws SiiClientNotAuthorizeException {

		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();
			final HttpClient httpClientForTls12 = HttpClient.create().secure(ssl -> ssl.sslContext(sslContextForTls12));
			
			if (logger.isDebugEnabled()){
				httpClientForTls12.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}
			
			this.webClient = WebClient.builder().baseUrl(boletaApiEnvio) // solo para post
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12))
					.filter(logRequest()) // logging
					.build();

			final MultipartBodyBuilder builder = new MultipartBodyBuilder();
			builder.part("rutSender", boletaEnvioRequest.getRutSender());
			builder.part("dvSender", boletaEnvioRequest.getDvSender());
			builder.part("rutCompany", boletaEnvioRequest.getRutCompany());
			builder.part("dvCompany", boletaEnvioRequest.getDvCompany());
			builder.part("archivo", file);

			Mono<BoletaEnvioResponse> result = webClient.post().uri(boletaEnvioUrl)
					.contentType(MediaType.MULTIPART_FORM_DATA)
					.header(HttpHeaders.COOKIE, "TOKEN=" + token + " ")
					.header(HttpHeaders.USER_AGENT, "Fapp/49.0 ( compatible; PROG 1.0; Windows NT)")
					.body(BodyInserters.fromMultipartData(builder.build()))
					.retrieve()
					
				.onStatus(status -> status.value() == HttpStatus.UNAUTHORIZED.value(), // 401
					response -> Mono.error(new SiiClientNotAuthorizeException("Error de autorización")))
	
				.onStatus(status -> status.value() != HttpStatus.OK.value(),
						response -> Mono.error(new SiiClientWebClientException("Problema con el servicio "
								+ boletaEnvioUrl + ". Status code " + response.statusCode().value())))

					.bodyToMono(BoletaEnvioResponse.class); // .block();
					
			BoletaEnvioResponse respuesta = result.block();
			return respuesta;

		} catch (SSLException e) {
			e.printStackTrace();
			return null;

		}
	}


	/**
	 * Envia set de boletas por byte[]
	 * 
	 * @param boletaEnvioRequest
	 * @param file               in byte[]
	 * @param fileName           default "sendBoletas.xml"
	 * @param token
	 * @return
	 * @throws SiiClientNotAuthorizeException
	 */
	@Override
	public BoletaEnvioResponse sendBoletas(BoletaEnvioRequest boletaEnvioRequest, byte[] file, String fileName,
			String token) throws SiiClientNotAuthorizeException {

		logger.debug("[SiiClientServiceRestImp.sendBoletas] - Parametros de entrada=" + boletaEnvioRequest);
		
		if (fileName == null) {
			fileName = "sendBoletas.xml";
		}

		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();
			final HttpClient httpClientForTls12;
			
			if( logger.isDebugEnabled() ) {
				logger.info("Client Rest con DEBUG habilitado...");
				httpClientForTls12 = HttpClient.create()
						.secure(ssl -> ssl.sslContext(sslContextForTls12));
						//.wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}else {
				logger.info("Client Rest con DEBUG deshabilitado...");
				httpClientForTls12 = HttpClient.create().secure(ssl -> ssl.sslContext(sslContextForTls12));
				//-->httpClientForTls12 = HttpClient.create()
				//-->		.secure(ssl -> ssl.sslContext(sslContextForTls12))
				//-->		.wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}

			/*
			if (logger.isDebugEnabled()){
				httpClientForTls12.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}
			*/

			this.webClient = WebClient.builder().baseUrl(boletaApiEnvio)
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12))
					.filter(new MultipartExchangeFilterFunction()) //logRequest())
					.build();

			final MultipartBodyBuilder builder = new MultipartBodyBuilder();
			builder.part("rutSender", boletaEnvioRequest.getRutSender());
			builder.part("dvSender", boletaEnvioRequest.getDvSender());
			builder.part("rutCompany", boletaEnvioRequest.getRutCompany());
			builder.part("dvCompany", boletaEnvioRequest.getDvCompany());
			builder.part("archivo", new ByteArrayResource(file)).filename(fileName);

			Mono<BoletaEnvioResponse> result = webClient.post()
					.uri(boletaEnvioUrl)
					.contentType(MediaType.MULTIPART_FORM_DATA)
					.header(HttpHeaders.COOKIE, "TOKEN=" + token + " ")
					.header(HttpHeaders.USER_AGENT, "Fapp/49.0 ( compatible; PROG 1.0; Windows NT)")
					.body(BodyInserters.fromMultipartData(builder.build()))
					.retrieve()
					
					.onStatus(status -> status.value() == HttpStatus.UNAUTHORIZED.value(), // 401
							response -> Mono.error(new SiiClientNotAuthorizeException("Error de autorización")))

					.onStatus(status -> status.value() != HttpStatus.OK.value(),
					response -> Mono.error(new SiiClientWebClientException("Problema con el servicio "
							+ boletaEnvioUrl + ". Status code " + response.statusCode().value())))

					.bodyToMono(BoletaEnvioResponse.class);

			BoletaEnvioResponse respuesta = result.block();
			return respuesta;

		} catch (SSLException e) {
			e.printStackTrace();
			return null;

		}

	}

	
	
	

	@Override
	public BoletaEnvioStatusResponse envioStatus(String rut, String dv, String trackid, String token)
			throws SiiClientNotAuthorizeException, SiiClientWebClientException {

		if (rut == null || dv == null || trackid == null || token == null) {
			logger.error("No puede haber parámtros null");
			return null;
		}

		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();
			final HttpClient httpClientForTls12 = HttpClient.create().secure(ssl -> ssl.sslContext(sslContextForTls12));
			
			if (logger.isDebugEnabled()){
				httpClientForTls12.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}

			this.webClient = WebClient.builder().baseUrl(boletaApi)
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12))
					.filter(logRequest())
					.build();

			Mono<BoletaEnvioStatusResponse> result = webClient.get()
					.uri(boletaEnvioUrl + "/" + rut + "-" + dv + "-" + trackid)
					.header(HttpHeaders.COOKIE, "TOKEN=" + token + " ") // con espacio
					.retrieve()

					.onStatus(status -> status.value() == HttpStatus.UNAUTHORIZED.value(), // 401
							response -> Mono.error(new SiiClientNotAuthorizeException("Error de autorización")))
					
					.onStatus(status -> status.value() != HttpStatus.OK.value(),
							response -> Mono.error(new SiiClientWebClientException("Problema con el servicio "
									+ boletaEnvioUrl + ". Status code " + response.statusCode().value())))


					.bodyToMono(BoletaEnvioStatusResponse.class); 

			BoletaEnvioStatusResponse respuesta = result.block();
			return respuesta;

		} catch (SSLException e) {
			logger.error(e.getMessage());
			return null;
		}

	}
	
	

	@Override
	public BoletaStatusResponse boletaStatus(String rutEmisor, String dvEmisor, Integer tipo, Long folio,
			String rutReceptor, String dvReceptor, BigInteger monto, String fechaEmision, String token)
			throws SiiClientNotAuthorizeException, SiiClientWebClientException {

		if (rutEmisor == null || dvEmisor == null || tipo == null || folio == null || token == null) {
			logger.error("parámtros insuficientes");
			return null;
		}

		try {
			final SslContext sslContextForTls12 = SslContextBuilder.forClient().protocols("TLSv1.2").build();
			final HttpClient httpClientForTls12 = HttpClient.create().secure(ssl -> ssl.sslContext(sslContextForTls12));
			
			if (logger.isDebugEnabled()){
				httpClientForTls12.wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);
			}

			this.webClient = WebClient.builder().baseUrl(boletaApi)
					.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.clientConnector(new ReactorClientHttpConnector(httpClientForTls12))
					.filter(logRequest())
					.build();
			
			String baseUrlParam = "/" + rutEmisor + "-" + dvEmisor + "-" + tipo + "-" + folio + "/estado";
						
			String urlcomplete = UriComponentsBuilder
		    .fromUriString(boletaStatusUrl + baseUrlParam)
		    .queryParamIfPresent("rut_receptor", Optional.ofNullable(rutReceptor))
		    .queryParamIfPresent("dv_receptor", Optional.ofNullable(dvReceptor))
		    .queryParamIfPresent("monto", Optional.ofNullable(monto))
		    .queryParamIfPresent("fechaEmision", Optional.ofNullable(fechaEmision))
		    .build().toUriString();
			
			Mono<BoletaStatusResponse> result = webClient.get().uri(urlcomplete)
					.header(HttpHeaders.COOKIE, "TOKEN=" + token + " ") // con espacio !
					.retrieve()
					
					.onStatus(status -> status.value() == HttpStatus.UNAUTHORIZED.value(), // 401
							response -> Mono.error(new SiiClientNotAuthorizeException("Error de autorización --->  " + response.statusCode().value()    )))
					
					.onStatus(status -> status.value() != HttpStatus.OK.value(),
							response -> Mono.error(new SiiClientWebClientException("Problema con el servicio"
							+ urlcomplete + ". Status code " + response.statusCode().value())))
					 
					.bodyToMono(BoletaStatusResponse.class);				

			BoletaStatusResponse respuesta = result.block();
			
			logger.info(respuesta.toString());
			return respuesta;
			
		} catch (SSLException e) {
			logger.error(e.getMessage());
			return null;
		}

	}

	
	
	
	/**
	 * Logging webClient
	 * 
	 */
	private static ExchangeFilterFunction logRequest() {
		return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
			logger.info("Request: {} {}", clientRequest.method(), clientRequest.url());
			clientRequest.headers()
					.forEach((name, values) -> values.forEach(value -> logger.info("{}={}", name, value)));
			return Mono.just(clientRequest);
		});
	}

}