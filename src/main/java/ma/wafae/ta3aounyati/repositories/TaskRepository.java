package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
