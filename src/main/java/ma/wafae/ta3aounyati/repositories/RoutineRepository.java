package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Integer> {
}
