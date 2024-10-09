package cl.fapp.restapi.controller.clientes.dto;

import java.util.Date;

// import cl.fapp.repository.model.Emisores;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientesRequest {
    @Schema(description = "Id auto-incremento", required = false, example = "1")
    private Long idCliente;
    @Schema(description = "rut del proveedor", required = true, example = "123456789-0")
    private String rut;
    @Schema(description = "Razon Social del proveedor", required = true, example = "Proveedor 1")
    private String razonSocial;
    @Schema(description = "Direccion del proveedor", required = true, example = "Direccion del proveedor 1")
    private String direccion;
    @Schema(description = "Email del proveedor", required = true, example = "contacto@email.com")
    private String email;
    @Schema(description = "Telefono del proveedor", required = false, example = "+56912345678")
    private String telefono;
    @Schema(description = "Emisor asociado al proveedor", required = true, example = "77571105-1")
    private String emisor;
    @Schema(description = "Fecha de creacion", required = false, example = "2021-06-01T00:00:00.000Z")
    private Date createdate;
    @Schema(description = "fecha de actualizacion", required = false, example = "2021-06-01T00:00:00.000Z")
    private Date updateDate;
}
