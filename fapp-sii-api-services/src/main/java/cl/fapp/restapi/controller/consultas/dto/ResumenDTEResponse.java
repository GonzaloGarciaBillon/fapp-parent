package cl.fapp.restapi.controller.consultas.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Respuesta del servicio consulta DTE
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Respuesta del servicio consulta DTE")
public class ResumenDTEResponse  {
    private int cantidadVentas;
	// private long foliosUtilizados;
    private long montoVentas;
    private BigDecimal montoNeto;
    private BigDecimal ivaRecaudado;
}
