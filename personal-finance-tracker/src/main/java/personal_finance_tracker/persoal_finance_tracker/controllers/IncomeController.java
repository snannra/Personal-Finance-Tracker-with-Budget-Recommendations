package personal_finance_tracker.persoal_finance_tracker.controllers;

import personal_finance_tracker.persoal_finance_tracker.entities.Income;
import personal_finance_tracker.persoal_finance_tracker.services.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @GetMapping
    public List<Income> getAllIncomes() {
        return incomeService.getAllIncomes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        Optional<Income> income = incomeService.getIncomeById(id);
        return income.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Income createIncome(@RequestBody Income income) {
        return incomeService.createIncome(income);
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