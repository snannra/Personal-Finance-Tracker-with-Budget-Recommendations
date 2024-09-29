package personal_finance_tracker.persoal_finance_tracker.controllers;

import personal_finance_tracker.persoal_finance_tracker.entities.Expense;
import personal_finance_tracker.persoal_finance_tracker.entities.Income;
import personal_finance_tracker.persoal_finance_tracker.entities.User;
import personal_finance_tracker.persoal_finance_tracker.services.ExpenseService;
import personal_finance_tracker.persoal_finance_tracker.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Expense> getUserExpense(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return expenseService.getExpensesByUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        if (expense.isPresent()) {
            return ResponseEntity.ok(expense.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Income createIncome(@RequestBody Expense expense, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        expense.setUser(user);
        Expense savedExpense = expenseService.saveExpense(expense);
        return ResponseEntity.ok(savedExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        try {
            return ResponseEntity.ok(expenseService.updateExpense(id, expense));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
