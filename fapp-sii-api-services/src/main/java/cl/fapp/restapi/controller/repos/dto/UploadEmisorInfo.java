package cl.fapp.restapi.controller.repos.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(description="Datos soportados por la API para crear un Emisor")
public class UploadEmisorInfo {
	private String rutemisor;
	private String giro;
	private String razonSocial;
	private String comuna;
	private String ciudad;
	private String direccion;
	private String codigoResolucion;
	private String fechaResolucion;
	private List<String> actividades;
}
