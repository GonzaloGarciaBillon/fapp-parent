package cl.fapp.common.domain;

import java.util.HashMap;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeracion para Tipos de Documento
 *
 */
@Schema(enumAsRef = true, description = "Tipos de documento", defaultValue = "BOLETA_AFECTA")
public enum ConstantesTipoDocumento {
	FACTURA_AFECTA(33),
	FACTURA_EXENTA(34), 
	BOLETA_AFECTA(39), 
	BOLETA_EXENTA(41), 
	NOTA_DEBITO(56), 
	NOTA_CREDITO(61);

	/**
	 * Mantiene el valor asignado a cada enumerador
	 */
	private Integer value;

	/**
	 * HashMap utilizado para localizar nombre de la enumeracion utilizando su valor
	 */
	private static Map<Integer, ConstantesTipoDocumento> map = new HashMap<Integer, ConstantesTipoDocumento>();
	static {
		for (ConstantesTipoDocumento legEnum : ConstantesTipoDocumento.values()) {
			map.put(legEnum.value, legEnum);
		}
	}

	/**
	 * Retorna el nombre de la enumeracion dado su valor
	 * @param currentValue valor de la enumeracion
	 * @return nombre de la enumeracion
	 */
	public static ConstantesTipoDocumento valueOf(Integer currentValue) {
		return map.get(currentValue);
	}

	/**
	 * Constructor de la enumeracion
	 * 
	 * @param currentValue valor asignado al nombre cuando se declara internamente
	 */
	ConstantesTipoDocumento(Integer currentValue) {
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
