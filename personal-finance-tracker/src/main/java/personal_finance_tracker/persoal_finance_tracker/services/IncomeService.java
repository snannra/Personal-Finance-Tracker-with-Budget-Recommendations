package personal_finance_tracker.persoal_finance_tracker.services;

import personal_finance_tracker.persoal_finance_tracker.entities.Income;
import personal_finance_tracker.persoal_finance_tracker.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAllIncomes() {
        return incomeRepository.findAll();
    }

    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    public Income createIncome(Income income) {
        return incomeRepository.save(income);
    }

    public Income updateIncome(Long id, Income income) {
        if (incomeRepository.existsById(id)) {
            income.setId(id);
            return incomeRepository.save(income);
        } else {
            throw new RuntimeException("Income not found");
        }
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}
