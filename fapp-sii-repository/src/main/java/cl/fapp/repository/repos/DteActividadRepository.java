package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.DteActividad;

@Repository
public interface DteActividadRepository extends JpaRepository<DteActividad,Long> {
    
}
