package cl.fapp.common.domain;

import java.util.HashMap;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeracion para Tipos de operacion que se declara en un Libro contable
 *  {@link #COMPRA}
 *  {@link #VENTA}
 */
@Schema(enumAsRef = true, description = "Tipo de operacion declarada en el libro", defaultValue = "COMPRA")
public enum ConstantesTipoOperacionLibro {
	// @formatter:off
	COMPRA("COMPRA"),
	VENTA("VENTA");
	// @formatter:on

	/**
	 * Mantiene el valor asignado a cada enumerador
	 */
	private String value;

	/**
	 * HashMap utilizado para localizar nombre de la enumeracion utilizando su valor
	 */
	private static Map<String, ConstantesTipoOperacionLibro> map = new HashMap<String, ConstantesTipoOperacionLibro>();
	static {
		for (ConstantesTipoOperacionLibro legEnum : ConstantesTipoOperacionLibro.values()) {
			map.put(legEnum.value, legEnum);
		}
	}

	/**
	 * Constructor de la enumeracion
	 * 
	 * @param currentValue valor asignado al nombre cuando se declara internamente
	 */
	ConstantesTipoOperacionLibro(String currentValue) {
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
