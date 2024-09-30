package personal_finance_tracker.persoal_finance_tracker.controllers;

import personal_finance_tracker.persoal_finance_tracker.entities.Expense;
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

    // Get expenses for the authenticated user
    @GetMapping
    public ResponseEntity<List<Expense>> getUserExpense(Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent()) {
            List<Expense> expenses = expenseService.getExpensesByUser(user.get());
            return ResponseEntity.ok(expenses);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get a specific expense by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return expense.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new expense for the authenticated user
    @PostMapping
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense, Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        if (user.isPresent()) {
            expense.setUser(user.get());
            Expense savedExpense = expenseService.saveExpense(expense);
            return ResponseEntity.ok(savedExpense);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update an existing expense by ID
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        try {
            Expense updatedExpense = expenseService.updateExpense(id, expense);
            return ResponseEntity.ok(updatedExpense);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an expense by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
