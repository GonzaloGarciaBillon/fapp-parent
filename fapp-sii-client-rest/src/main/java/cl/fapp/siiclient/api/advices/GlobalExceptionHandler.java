package cl.fapp.siiclient.api.advices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import cl.fapp.siiclient.api.jsend.JSend;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = { MaxUploadSizeExceededException.class })
	protected ResponseEntity<Object> handleMaxUploadSizeExceeded(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "El archivo supera el tamaño maximo";
		logger.error(bodyOfResponse);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should be application specific";
		logger.error(bodyOfResponse);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleGeneral(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "This should sssbe application specific";
		logger.error(bodyOfResponse, ex);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	/*
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { logger.error("exception=",
	 * ex); return super.handleMethodArgumentNotValid(ex, headers, status, request);
	 * }
	 * 
	 * @Override protected ResponseEntity<Object>
	 * handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus
	 * status, WebRequest request) { logger.error("exception=", ex); return
	 * super.handleTypeMismatch(ex, headers, status, request); }
	 */

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		String uri = null;
		try {
			uri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		} catch (Exception innerex) {
			logger.error("Error recuperando la URI del servicio. Error=" + innerex.getMessage());
		}

		List<String> validationErrors = ex.getBindingResult().getAllErrors().stream()
				.map(ObjectError::getDefaultMessage).collect(Collectors.toList());

		String addText = (uri == null) ? "" : " (" + uri + ")";
		logger.error("Error mientras se valida request al servicio" + addText + ". Error=" + validationErrors);

		return handleExceptionInternal(ex, JSend.error("El request no es valido"), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.error("exception=", ex);
		if (ex.getCause() instanceof InvalidFormatException) {
			InvalidFormatException iex = (InvalidFormatException) ex.getCause();
			List<Map<String, String>> errors = new ArrayList<>();
			iex.getPath().forEach(reference -> {
				Map<String, String> error = new HashMap<>();
				error.put(reference.getFieldName(), iex.getOriginalMessage());
				errors.add(error);
			});

			return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		}
		return super.handleHttpMessageNotReadable(ex, headers, status, request);
	}
}