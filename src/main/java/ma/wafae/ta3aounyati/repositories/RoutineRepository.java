package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoutineRepository extends JpaRepository<Routine,Integer> {
    List<Routine> findByUserId(Integer userId);
}
