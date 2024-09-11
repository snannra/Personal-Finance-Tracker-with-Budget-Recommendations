import { Component, OnInit } from '@angular/core';
import { Chart } from 'chart.js/auto';  // Import Chart.js with auto-register functionality
import { CommonModule } from '@angular/common';
import { IncomeService } from '../services/income/income.service';
import { ExpenseService } from '../services/expense/expense.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  imports: [CommonModule],
  standalone: true,
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  incomeList: any[] = [];
  expenseList: any[] = [];
  incomeChart: any;
  expenseChart: any;

  constructor(
    private incomeService: IncomeService,
    private expenseService: ExpenseService,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.loadIncome();
    this.loadExpenses();
  }

  loadIncome() {
    this.incomeService.getAllIncomes().subscribe({
      next: (data) => {
        this.incomeList = data;
        this.renderIncomeChart();
      },
      error: (err) => {
        console.error('Error loading income data', err);
      }
    });
  }

  loadExpenses() {
    this.expenseService.getAllExpenses().subscribe({
      next: (data) => {
        this.expenseList = data;
        this.renderExpenseChart();
      },
      error: (err) => {
        console.error('Error loading expense data', err);
      }
    });
  }

  renderIncomeChart() {
    if (this.incomeChart) {
      this.incomeChart.destroy(); // Destroy the old chart if exists
    }

    const labels = this.incomeList.map((income) => income.incomeDate);
    const data = this.incomeList.map((income) => income.amount);

    this.incomeChart = new Chart('incomeChart', {
      type: 'line', // or any other type like 'bar'
      data: {
        labels: labels,
        datasets: [{
          label: 'Income Over Time',
          data: data,
          borderColor: 'rgba(75, 192, 192, 1)',
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          x: {
            type: 'category',  // Register the 'category' scale here
            title: {
              display: true,
              text: 'Date'
            }
          },
          y: {
            title: {
              display: true,
              text: 'Amount'
            },
            beginAtZero: true
          }
        }
      }
    });
  }

  renderExpenseChart() {
    if (this.expenseChart) {
      this.expenseChart.destroy(); // Destroy the old chart if exists
    }

    const labels = this.expenseList.map((expense) => expense.expenseDate);
    const data = this.expenseList.map((expense) => expense.amount);

    this.expenseChart = new Chart('expenseChart', {
      type: 'line', // or any other type like 'bar'
      data: {
        labels: labels,
        datasets: [{
          label: 'Expenses Over Time',
          data: data,
          borderColor: 'rgba(255, 99, 132, 1)',
          backgroundColor: 'rgba(255, 99, 132, 0.2)',
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          x: {
            type: 'category',  // Register the 'category' scale here as well
            title: {
              display: true,
              text: 'Date'
            }
          },
          y: {
            title: {
              display: true,
              text: 'Amount'
            },
            beginAtZero: true
          }
        }
      }
    });
  }

  goToIncomeForm() {
    this.router.navigate(['/income-form']);
  }

  // Method to navigate to expense form
  goToExpenseForm() {
    this.router.navigate(['/expense-form']);
  }
}
