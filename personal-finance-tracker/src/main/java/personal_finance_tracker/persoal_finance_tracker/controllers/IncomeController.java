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
    public ResponseEntity<List<Income>> getUserIncome(Principal principal) {
        Optional<User> userOptional = userService.findByUsername(principal.getName());

        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();
        List<Income> incomeList = incomeService.getIncomeByUser(user);
        return ResponseEntity.ok(incomeList);
    }

    @PostMapping
    public ResponseEntity<Income> createIncome(@RequestBody Income income, Principal principal) {
        Optional<User> userOptional = userService.findByUsername(principal.getName());

        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User user = userOptional.get();
        income.setUser(user);
        Income savedIncome = incomeService.saveIncome(income);
        return ResponseEntity.ok(savedIncome);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        try {
            Income updatedIncome = incomeService.updateIncome(id, income);
            return ResponseEntity.ok(updatedIncome);
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
