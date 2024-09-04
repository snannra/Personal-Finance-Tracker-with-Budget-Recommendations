package personal_finance_tracker.persoal_finance_tracker.repositories;

import personal_finance_tracker.persoal_finance_tracker.entities.Savings;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SavingsRepository extends JpaRepository<Savings, Long> {
    List<Savings> findByUserId(Long userId);
}
