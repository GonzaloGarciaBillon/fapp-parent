package cl.fapp.repository.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.fapp.repository.model.Bitacora;

public interface BitacoraRepository extends JpaRepository<Bitacora, Long> {
}
