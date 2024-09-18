import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IncomeService } from '../services/income/income.service';
import { Router } from '@angular/router'; // Import Router for navigation
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-income-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './income-form.component.html'
})
export class IncomeFormComponent {
  incomeData = {
    amount: 0,
    description: '',
    date: ''
  };

  constructor(
    private incomeService: IncomeService,
    private router: Router // Inject Router for navigation
  ) {}

  onSubmit() {

    const incomeToSend = {
      ...this.incomeData,
      incomeDate: this.incomeData.date ? new Date(this.incomeData.date).toISOString().split('T')[0] : null
    };

    console.log('Income data being sent:', this.incomeData);
    this.incomeService.createIncome(incomeToSend).subscribe({
      next: (response) => {
        console.log('Income added successfully', response);
        this.router.navigate(['/dashboard']);
      },
      error: (error) => {
        console.error('Error adding income', error);
      }
    });
  }
}
