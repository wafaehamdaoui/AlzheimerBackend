package ma.wafae.ta3aounyati.repositories;

import ma.wafae.ta3aounyati.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByUsername(String username);
}
