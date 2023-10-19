package cl.fapp.services.mail.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "Entrada para el servicio de envio de DTE por correo")
/**
 * Entrada para el servicio de envio de DTE por correo
 */
public class EmailSenderDTERequest {
	
	/**
	 * Rut del emisor
	 */
	@Schema(description = "Rut del emisor", required = true)
	private String rutEmisor = null;
	
	/**
	 * Tipos de documento que se buscan
	 */
	@Schema(description = "Tipo documento", required = true)
	private List<Integer> tipos = null;
	
	/**
	 * Estados en que debe encontrarse el documento
	 */
	@Schema(description = "Estado", required = false)
	private List<String> estados = null;
	
	/**
	 * Fecha de emision del DTE debe ser mayor o igual a fechaDesde
	 */
	@Schema(description = "Fecha desde", required = false)
	private String fechaDesde = null;

	/**
	 * Fecha de emision del DTE debe ser menor o igual a fechaHasta
	 */
	@Schema(description = "Fecha hasta", required = false)
	private String fechaHasta = null;
}
