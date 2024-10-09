package cl.fapp.common.jsend;

import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * JsendUtils
 * convertir estructura JSend a string utilizando jackson
 */
public class JSendUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		// Registrar el módulo para manejar las fechas de Java 8
		objectMapper.registerModule(new JavaTimeModule());
		// Configurar la zona horaria predeterminada como la zona horaria del sistema
		objectMapper.setTimeZone(TimeZone.getDefault());
	}

	public static String toJson(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}
}
