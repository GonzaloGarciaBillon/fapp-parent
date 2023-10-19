package cl.fapp.common.domain;

import java.util.HashMap;
import java.util.Map;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Enumeracion para Tipo de Envio del Libro Electronico
 * 
 * {@link #PARCIAL}
 * {@link #FINAL}
 * {@link #TOTAL}
 * {@link #AJUSTE}
 */
@Schema(enumAsRef = true, description = "Tipo de Envio del Libro Electronico", defaultValue = "FINAL")
public enum ConstantesTipoEnvioLibro {
	// @formatter:off
	PARCIAL("PARCIAL"),
	FINAL("FINAL"),
	TOTAL("TOTAL"),
	AJUSTE("AJUSTE");
	// @formatter:on

	/**
	 * Mantiene el valor asignado a cada enumerador
	 */
	private String value;

	/**
	 * HashMap utilizado para localizar nombre de la enumeracion utilizando su valor
	 */
	private static Map<String, ConstantesTipoEnvioLibro> map = new HashMap<String, ConstantesTipoEnvioLibro>();
	static {
		for (ConstantesTipoEnvioLibro legEnum : ConstantesTipoEnvioLibro.values()) {
			map.put(legEnum.value, legEnum);
		}
	}

	/**
	 * Constructor de la enumeracion
	 * 
	 * @param currentValue valor asignado al nombre cuando se declara internamente
	 */
	ConstantesTipoEnvioLibro(String currentValue) {
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
