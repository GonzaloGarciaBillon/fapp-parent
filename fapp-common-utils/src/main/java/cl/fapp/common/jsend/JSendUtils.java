package cl.fapp.common.jsend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsendUtils
 * convertir estructura JSend a string utilizando jackson
 */
public class JSendUtils {
	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String toJson(Object object) throws JsonProcessingException {
		return objectMapper.writeValueAsString(object);
	}
}
