package personal_finance_tracker.persoal_finance_tracker.repositories;

import personal_finance_tracker.persoal_finance_tracker.entities.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByUserId(Long userId);
}
