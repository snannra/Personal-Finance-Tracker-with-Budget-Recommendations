package personal_finance_tracker.persoal_finance_tracker.controllers;

import personal_finance_tracker.persoal_finance_tracker.entities.Income;
import personal_finance_tracker.persoal_finance_tracker.entities.User;
import personal_finance_tracker.persoal_finance_tracker.services.IncomeService;
import personal_finance_tracker.persoal_finance_tracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Income> getUserIncome(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return incomeService.getIncomeByUser(user);
    }

    @PostMapping
    public Income createIncome(@RequestBody Income income, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        income.setUser(user);
        Income savedIncome = incomeService.saveIncome(income);
        return ResponseEntity.ok(savedIncome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        try {
            return ResponseEntity.ok(incomeService.updateIncome(id, income));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}