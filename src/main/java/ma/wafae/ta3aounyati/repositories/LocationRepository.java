package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
    List<Location> findByUserId(Integer userId);
}
