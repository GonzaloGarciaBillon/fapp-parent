package cl.fapp.repository.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import cl.fapp.repository.model.Task;

@Repository
@RepositoryRestResource(exported = false)
public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findByNameIgnoreCase(String name);

}