package cl.fapp.siiclient.boletas;

import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ClientHttpRequest;
import org.springframework.http.client.reactive.ClientHttpRequestDecorator;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;

import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

public class MultipartExchangeFilterFunction implements ExchangeFilterFunction {

	private static final Logger logger = LoggerFactory.getLogger(MultipartExchangeFilterFunction.class);
	
	@Override
	@NonNull
	public Mono<ClientResponse> filter(@NonNull ClientRequest request, @NonNull ExchangeFunction next) {
		//logger.debug("Aplicando filtro: MultipartExchangeFilterFunction...");
		if (MediaType.MULTIPART_FORM_DATA.includes(request.headers().getContentType()) && (request.method() == HttpMethod.PUT || request.method() == HttpMethod.POST)) {
			//logger.debug("Es multipart y POST!!");
			return next.exchange(ClientRequest.from(request).body((outputMessage, context) -> request.body().insert(new BufferingDecorator(outputMessage), context)).build());
		} else {
			//logger.debug("NO Es multipart y POST!!");
			return next.exchange(request);
		}
	}

	private static final class BufferingDecorator extends ClientHttpRequestDecorator {

		private static final Logger logger = LoggerFactory.getLogger(BufferingDecorator.class);

		private BufferingDecorator(ClientHttpRequest delegate) {
			super(delegate);
			//logger.debug("Constructor BufferingDecorator...");
		}

		@Override
		@NonNull
		public Mono<Void> writeWith(@NonNull Publisher<? extends DataBuffer> body) {
			//logger.debug("writeWith...");

			return DataBufferUtils.join(body).flatMap(buffer -> {
				getHeaders().setContentLength(buffer.readableByteCount());
				logger.debug("Estableciendo content-length en " + buffer.readableByteCount());
				return super.writeWith(Mono.just(buffer));
			});
		}

	}

}