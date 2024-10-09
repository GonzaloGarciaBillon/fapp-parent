package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.Rubro;

@Repository
public interface RubroRepository extends JpaRepository<Rubro,Long> {
    
}
