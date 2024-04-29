package cl.fapp.advices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import cl.fapp.common.jsend.JSend;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { MaxUploadSizeExceededException.class })
	protected ResponseEntity<Object> handleMaxUploadSizeExceeded(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "El archivo supera el tamañoo maximo";
		log.error(bodyOfResponse);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Se ha pasado un argumento no valido al metodo";
		log.error(bodyOfResponse);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleGeneral(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Excepcion general";
		log.error(bodyOfResponse, ex);
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		log.error("Exception=", ex);

		String uri = null;
		try {
			uri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		} catch (Exception innerex) {
			log.error("Error recuperando la URI del servicio. Error=" + innerex.getMessage());
		}

		List<String> validationErrors = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());

		String addText = (uri == null) ? "" : " (" + uri + ")";
		log.error("Error mientras se valida request al servicio" + addText + ". Error=" + validationErrors);

		return handleExceptionInternal(ex, JSend.error("El request no es valido. Error=" + validationErrors), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);

	}

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String uri = null;
		try {
			uri = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
		} catch (Exception innerex) {
			log.error("Error recuperando la URI del servicio. Error=" + innerex.getMessage());
		}

		List<String> validationErrors = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());

		String addText = (uri == null) ? "" : " (" + uri + ")";
		log.error("Error mientras se valida request al servicio" + addText + ". Error=" + validationErrors);

		return handleExceptionInternal(ex, JSend.error("El request no es valido. Error=" + validationErrors), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.error("Exception=", ex);

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