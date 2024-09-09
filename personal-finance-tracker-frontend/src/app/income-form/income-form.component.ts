import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IncomeService } from '../services/income/income.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-income-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './income-form.component.html'
})
export class IncomeFormComponent {
  income = {
    amount: 0,
    description: '',
    incomeDate: ''
  };

  constructor(private incomeService: IncomeService) {}

  onSubmit() {
    this.incomeService.createIncome(this.income).subscribe(response => {
      console.log('Income added successfully', response);
    }, error => {
      console.error('Error adding income', error);
    });
  }
}
