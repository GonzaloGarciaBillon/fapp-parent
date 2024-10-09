package cl.fapp.restapi.controller.productos.dto;

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
public class ProductosRequest {
    @Schema(description = "Id auto-incremento", required = false, example = "1")
    private Long idProducto;
    @Schema(description = "Nombre del producto", required = true, example = "Producto 1")
    private String nombre;
    @Schema(description = "Descripcion del producto", required = true, example = "Descripcion del producto 1")
    private String descripcion;
    @Schema(description = "Categoria del producto", required = true, example = "Categoria 1")
    private String categoria;
    @Schema(description = "Precio del producto", required = true, example = "10000")
    private Integer precio;
    @Schema(description = "Estado del producto", required = true, example = "ACTIVO")
    private String estado;
    @Schema(description = "Codigo del producto", required = false, example = "7456985256985685")
    private String codigo;
    @Schema(description = "Emisor asociado al producto", required = true, example = "77571105-1")
    private String emisor;
    @Schema(description = "Fecha de creacion", required = false, example = "2021-06-01T00:00:00.000Z")
    private Date createdate;
    @Schema(description = "fecha de actualizacion", required = false, example = "2021-06-01T00:00:00.000Z")
    private Date updateDate;
}
