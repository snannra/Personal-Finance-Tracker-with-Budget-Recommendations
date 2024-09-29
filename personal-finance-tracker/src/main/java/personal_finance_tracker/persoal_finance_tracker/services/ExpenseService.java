package personal_finance_tracker.persoal_finance_tracker.services;

import personal_finance_tracker.persoal_finance_tracker.entities.Expense;
import personal_finance_tracker.persoal_finance_tracker.entities.User;
import personal_finance_tracker.persoal_finance_tracker.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getExpensesByUser(User user) {
        return expenseRepository.findByUser(user);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense expense) {
        if (expenseRepository.existsById(id)) {
            expense.setId(id);
            return expenseRepository.save(expense);
        } else {
            throw new RuntimeException("Expense not found");
        }
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
