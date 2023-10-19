package cl.fapp.common.domain;

import java.util.HashMap;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeracion para Tipo de Libro de Compra o Venta Enviado
 * {@link #MENSUAL}
 * {@link #ESPECIAL}
 * {@link #RECTIFICA} 
 */
@Schema(enumAsRef = true, description = "Tipo de Libro de Compra o Venta Enviado", defaultValue = "MENSUAL")
public enum ConstantesTipoLibro {
	// @formatter:off
	MENSUAL("MENSUAL"),
	ESPECIAL("ESPECIAL"),
	RECTIFICA("RECTIFICA");
	// @formatter:on

	/**
	 * Mantiene el valor asignado a cada enumerador
	 */
	private String value;

	/**
	 * HashMap utilizado para localizar nombre de la enumeracion utilizando su valor
	 */
	private static Map<String, ConstantesTipoLibro> map = new HashMap<String, ConstantesTipoLibro>();
	static {
		for (ConstantesTipoLibro legEnum : ConstantesTipoLibro.values()) {
			map.put(legEnum.value, legEnum);
		}
	}

	/**
	 * Constructor de la enumeracion
	 * 
	 * @param currentValue valor asignado al nombre cuando se declara internamente
	 */
	ConstantesTipoLibro(String currentValue) {
		this.value = currentValue;
	}

	/**
	 * Retorna el valor de la enumeracion dado su nombre (forma: ENUM_NOMBRE.getValue())
	 * 
	 * @return el valor asignado al nombre de la enumeracion
	 */
	public String getValue() {
		return value;
	}

}
