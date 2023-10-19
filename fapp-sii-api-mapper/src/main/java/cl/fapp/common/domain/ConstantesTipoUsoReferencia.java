package cl.fapp.common.domain;

import java.util.HashMap;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeracion para Tipo de uso de una Referencia
 *
 */
@Schema(enumAsRef = true, description = "Tipos de uso de referencia", defaultValue = "1")
public enum ConstantesTipoUsoReferencia {
	ANULAR_DOCUMENTO(1), 
	CORREGIR_TEXTO(2), 
	CORREGIR_MONTOS(3);

	/**
	 * Mantiene el valor asignado a cada enumerador
	 */
	private Integer value;

	/**
	 * HashMap utilizado para localizar nombre de la enumeracion utilizando su valor
	 */
	private static Map<Integer, ConstantesTipoUsoReferencia> map = new HashMap<Integer, ConstantesTipoUsoReferencia>();
	static {
		for (ConstantesTipoUsoReferencia legEnum : ConstantesTipoUsoReferencia.values()) {
			map.put(legEnum.value, legEnum);
		}
	}

	/**
	 * Retorna el nombre de la enumeracion dado su valor
	 * 
	 * @param currentValue valor de la enumeracion
	 * @return nombre de la enumeracion
	 */
	public static ConstantesTipoUsoReferencia valueOf(Integer currentValue) {
		return map.get(currentValue);
	}

	/**
	 * Constructor de la enumeracion
	 * 
	 * @param currentValue valor asignado al nombre cuando se declara internamente
	 */
	ConstantesTipoUsoReferencia(Integer currentValue) {
		this.value = currentValue;
	}

	/**
	 * Retorna el valor de la enumeracion dado su nombre (forma: ENUM_NOMBRE.getValue())
	 * 
	 * @return el valor asignado al nombre de la enumeracion
	 */
	public Integer getValue() {
		return value;
	}
}
