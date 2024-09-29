package personal_finance_tracker.persoal_finance_tracker.services;

import personal_finance_tracker.persoal_finance_tracker.entities.Income;
import personal_finance_tracker.persoal_finance_tracker.entities.User;
import personal_finance_tracker.persoal_finance_tracker.repositories.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getIncomeByUser(User user) {
        return incomeRepository.findByUser(user);
    }

    public Income saveIncome(Income income) {
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
