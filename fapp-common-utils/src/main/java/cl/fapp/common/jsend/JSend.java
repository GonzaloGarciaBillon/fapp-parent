package cl.fapp.common.jsend;

import java.util.StringJoiner;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Biblioteca que genera string jsend de un objeto jsend
 */
public class JSend {
	@JsonInclude(Include.NON_NULL)
	private JSendStatus status;

	@JsonInclude(Include.NON_NULL)
	private Integer code;

	@JsonInclude(Include.NON_NULL)
	private String message;

	@JsonInclude(Include.NON_NULL)
	private Object data;

	/**
	 * JSend
	 *
	 * @param status  estado de la respuesta
	 * @param code    codigo de estado
	 * @param message mensaje de error
	 * @param data    contiene el objeto de la respuesta
	 */
	public JSend(JSendStatus status, Integer code, String message, Object data) {
		this.status = status;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * ToJsonString
	 *
	 * @return string json obtenido con jackson
	 */
	public String toJsonString() {
		try {
			return JSendUtils.toJson(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * toString
	 *
	 * @return String
	 */
	@Override
	public String toString() {
		return new StringJoiner(", ", JSend.class.getSimpleName() + "[", "]").add("status=" + status)
				.add("code=" + code).add("message='" + message + "'").add("data='" + data + "'").toString();
	}

	/**
	 * success con datos
	 *
	 * @param data datos de la respuesta
	 * @return JSend
	 */
	public static JSend success(Object data) {
		return new JSend(JSendStatus.success, null, null, data);
	}

	/**
	 * success sin datos
	 *
	 * @return JSend
	 */
	public static JSend success() {
		return success(null);
	}

	/**
	 * error con codigo, mensaje y datos
	 *
	 * @param code    codigo de estado
	 * @param message mensaje de error
	 * @param data    datos en la respuesta de error
	 * @return JSend
	 */
	public static JSend error(Integer code, String message, Object data) {
		return new JSend(JSendStatus.error, code, message, data);
	}

	/**
	 * error solo con mensaje y data
	 *
	 * @param message mensaje
	 * @param data    datos en la respuesta de error
	 * @return JSend
	 */
	public static JSend error(String message, Object data) {
		return error(null, message, data);
	}

	/**
	 * error solo con mensaje
	 *
	 * @param message mensaje
	 * @return JSend
	 */
	public static JSend error(String message) {
		return error(null, message, null);
	}

	/**
	 * un fallo con datos
	 *
	 * @param data datos en la respuesta
	 * @return Jsend
	 */
	public static JSend fail(Object data) {
		return new JSend(JSendStatus.fail, null, null, data);
	}

	public JSendStatus getStatus() {
		return status;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}
