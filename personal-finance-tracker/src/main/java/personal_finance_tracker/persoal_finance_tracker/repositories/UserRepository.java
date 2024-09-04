package personal_finance_tracker.persoal_finance_tracker.repositories;

import personal_finance_tracker.persoal_finance_tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}