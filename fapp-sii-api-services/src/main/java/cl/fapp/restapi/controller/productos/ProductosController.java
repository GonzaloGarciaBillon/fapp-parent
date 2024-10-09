package cl.fapp.restapi.controller.productos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fapp.common.jsend.JSend;
import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Productos;
import cl.fapp.repository.repos.ProductosRepository;
import cl.fapp.restapi.controller.productos.dto.ProductosRequest;
import cl.fapp.restapi.controller.productos.dto.ProductosResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "${fapp.api.controller.base-path}")
@Service
public class ProductosController {

    final ProductosRepository productosRepo;

    ProductosController(ProductosRepository productosRepo) {
        this.productosRepo = productosRepo;
    }

    private static final String SUCCESS = "success";

    /**
     * Agrega un producto a partir del request a la api y la escribe en la base de
     * datos.
     * 
     * @param payload request para agregar productos
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/agregarProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductosResponse> agregarProducto(@RequestBody ProductosRequest payload) {
        ProductosResponse response = new ProductosResponse();
        try {
            Productos newProducto = new Productos();
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getEmisor());

            newProducto.setNombre(payload.getNombre());
            newProducto.setDescripcion(payload.getDescripcion());
            newProducto.setPrecio(payload.getPrecio().doubleValue());
            newProducto.setCategoria(payload.getCategoria());
            newProducto.setEstado("ACTIVO");
            newProducto.setCodigo(payload.getCodigo());
            newProducto.setEmisor(emisor);
            newProducto.setCreateDate(ahora);
            newProducto.setUpdateDate(ahora);

            Productos savedProducto = productosRepo.save(newProducto);
            Long createdId = savedProducto.getIdProducto();

            log.debug("Producto agregado con id =" + savedProducto.getIdProducto());

            response.setStatus(SUCCESS);
            response.setCreatedId(createdId);
            response.setMessage("Producto agregado correctamente con id = " + createdId);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al agregar producto", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Elimina un producto a partir del request a la api y las elimina en la base de
     * datos.
     * 
     * @param payload request para eliminar productos
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/eliminarProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductosResponse> eliminarProducto(@RequestBody ProductosRequest payload) {
        ProductosResponse response = new ProductosResponse();
        try {
            Productos producto = productosRepo.findById(payload.getIdProducto()).get();
            productosRepo.delete(producto);

            log.debug("Producto eliminado con id =" + producto.getIdProducto());

            response.setStatus(SUCCESS);
            response.setMessage("Producto eliminado correctamente con id = " + producto.getIdProducto());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al eliminar producto", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Actualiza un producto a partir del request a la api y las actualiza en la
     * base de datos.
     * 
     * @param payload request para actualizar productos
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/actualizarProducto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductosResponse> actualizarProducto(@RequestBody ProductosRequest payload) {
        ProductosResponse response = new ProductosResponse();
        try {
            Productos producto = productosRepo.findById(payload.getIdProducto()).get();
            Date ahora = new Date();

            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getEmisor());

            producto.setNombre(payload.getNombre());
            producto.setDescripcion(payload.getDescripcion());
            producto.setPrecio(payload.getPrecio().doubleValue()); // Convert Integer to Double
            producto.setEstado(payload.getEstado());
            producto.setCodigo(payload.getCodigo());
            producto.setCategoria(payload.getCategoria());
            // producto.setEmisor(emisor);
            producto.setUpdateDate(ahora);

            Productos updatedProducto = productosRepo.save(producto);

            log.debug("Producto actualizado con id =" + payload.getIdProducto());

            response.setStatus(SUCCESS);
            response.setMessage("Producto actualizado correctamente con id = " + updatedProducto.getIdProducto());

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            log.error("Error al actualizar producto", e);
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Lista los productos a partir del request a la API y los devuelve en un JSON.
     * 
     * @param payload request para listar productos
     * @return objeto {@link JSend} simple
     */
    @PostMapping(value = "/listarProductos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JSend> listarProductos(@Validated @RequestBody ProductosRequest payload) {
        try {
            Emisores emisor = new Emisores();
            emisor.setRutemisor(payload.getEmisor());

            List<Productos> listaProductos = productosRepo.findByEmisor(emisor);

            List<Map<String, Object>> productosJson = new ArrayList<>();

            for (Productos producto : listaProductos) {
                Map<String, Object> productoMap = new HashMap<>();
                productoMap.put("idProducto", producto.getIdProducto());
                productoMap.put("nombre", producto.getNombre());
                productoMap.put("descripcion", producto.getDescripcion());
                productoMap.put("precio", producto.getPrecio());
                productoMap.put("estado", producto.getEstado());
                productoMap.put("codigo", producto.getCodigo());
                productoMap.put("categoria", producto.getCategoria());
                productoMap.put("cliente", producto.getEmisor().getRutemisor());
                productoMap.put("updateDate", producto.getUpdateDate());

                productosJson.add(productoMap);
            }

            if (listaProductos != null && !listaProductos.isEmpty()) {
                log.debug("Lista de productos recuperada");
                return ResponseEntity.ok().body(JSend.success(productosJson));
            } else {
                return ResponseEntity.ok()
                        .body(JSend.success("No se encontraron productos para el cliente " + payload.getEmisor()));
            }
        } catch (Exception e) {
            log.error("No se pudo obtener la lista de productos: ", e);
            return ResponseEntity.badRequest().body(JSend.error(e.getMessage()));
        }
    }
}
