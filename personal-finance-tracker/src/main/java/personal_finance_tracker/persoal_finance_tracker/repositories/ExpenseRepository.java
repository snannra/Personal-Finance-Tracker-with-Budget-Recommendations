package personal_finance_tracker.persoal_finance_tracker.repositories;

import personal_finance_tracker.persoal_finance_tracker.entities.Expense;

import personal_finance_tracker.persoal_finance_tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByUser(User user);
}
