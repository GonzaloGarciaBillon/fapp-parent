package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import java.util.List;

import cl.fapp.repository.model.Emisores;
import cl.fapp.repository.model.Impresoras;

@Repository
@RepositoryRestResource(exported = false)
public interface ImpresorasRepository extends  JpaRepository<Impresoras, Long> {
    List<Impresoras> findByCliente(Emisores emisor);
}
