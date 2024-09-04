package personal_finance_tracker.persoal_finance_tracker.repositories;

import personal_finance_tracker.persoal_finance_tracker.entities.BudgetHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BudgetHistoryRepository extends JpaRepository<BudgetHistory, Long> {
    List<BudgetHistory> findByUserIdAndYear(Long userId, Integer year);
}
