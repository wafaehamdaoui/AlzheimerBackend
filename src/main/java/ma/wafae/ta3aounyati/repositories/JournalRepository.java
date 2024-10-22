package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends JpaRepository<Journal,Integer> {
}
