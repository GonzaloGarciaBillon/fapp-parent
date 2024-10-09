package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.util.List;

import cl.fapp.repository.model.Emisores;

@Repository
@RepositoryRestResource(exported = false)
public interface EmisoresRepository extends JpaRepository<Emisores, String> {
    // Búsqueda por RUT del emisor
    Emisores findByRutemisor(String rutemisor);

    // Búsqueda por razón social
    List<Emisores> findByRazonSocialContainingIgnoreCase(String razonSocial);

    // Búsqueda por email
    List<Emisores> findByEmail(String email);

    // Ejemplo de una consulta JPQL para buscar emisores por ciudad
    @Query("select e from Emisores e where e.ciudad = :ciudad")
    List<Emisores> findByCiudad(@Param("ciudad") String ciudad);

    // Ejemplo de consulta usando SQL nativo, útil si necesitas rendimiento o
    // consultas que son demasiado complejas para JPQL
    @Query(value = "SELECT * FROM emisores WHERE estado = ?1", nativeQuery = true)
    List<Emisores> findByEstado(String estado);

}