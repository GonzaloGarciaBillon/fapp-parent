package cl.fapp.common.domain;

import java.util.HashMap;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeracion para Indicador de Servicio
 *
 */
@Schema(enumAsRef = true, description = "Indicadores de servicio", defaultValue = "VENTA_Y_SERVICIOS")
public enum ConstantesIndicadorServicio {
	SERVICIOS_PERIODICOS(1), 
	SERVICIOS_PERIODICOS_DOMICILIARIOS(2), 
	VENTA_Y_SERVICIOS(3), 
	ESPECTACULOS_POR_CUENTA_DE_TERCEROS(4);

	/**
	 * Mantiene el valor asignado a cada enumerador
	 */
	private Integer value;

	/**
	 * HashMap utilizado para localizar nombre de la enumeracion utilizando su valor
	 */
	private static Map<Integer, ConstantesIndicadorServicio> map = new HashMap<Integer, ConstantesIndicadorServicio>();
	static {
		for (ConstantesIndicadorServicio legEnum : ConstantesIndicadorServicio.values()) {
			map.put(legEnum.value, legEnum);
		}
	}

	/**
	 * Retorna el nombre de la enumeracion dado su valor
	 * 
	 * @param currentValue valor de la enumeracion
	 * @return nombre de la enumeracion
	 */
	public static ConstantesIndicadorServicio valueOf(Integer currentValue) {
		return map.get(currentValue);
	}

	/**
	 * Constructor de la enumeracion
	 * 
	 * @param currentValue valor asignado al nombre cuando se declara internamente
	 */
	ConstantesIndicadorServicio(Integer currentValue) {
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
