import { Component, OnInit } from '@angular/core';
import { IncomeService } from '../services/income/income.service';
import { ExpenseService } from '../services/expense/expense.service';
import { firstValueFrom } from 'rxjs';
import { Chart } from 'chart.js';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  incomeList: any[] = [];
  expenseList: any[] = [];

  incomeChart: any;
  expenseChart: any;

  constructor(private incomeService: IncomeService, private expenseService: ExpenseService) {}

  ngOnInit() {
    this.loadData();
  }

  async loadData() {
    try {
      const incomes = await firstValueFrom(this.incomeService.getAllIncomes());
      const expenses = await firstValueFrom(this.expenseService.getAllExpenses());

      this.incomeList = incomes;
      this.expenseList = expenses;

      this.renderIncomeChart();
      this.renderExpenseChart();
    } catch (error) {
      console.error('Error loading data', error);
    }
  }

  renderIncomeChart() {
    const incomeDates = this.incomeList.map(income => income.date);
    const incomeAmounts = this.incomeList.map(income => income.amount);

    this.incomeChart = new Chart('incomeChart', {
      type: 'line',
      data: {
        labels: incomeDates,
        datasets: [
          {
            label: 'Income Over Time',
            data: incomeAmounts,
            borderColor: 'green',
            fill: false
          }
        ]
      },
      options: {
        scales: {
          x: { title: { display: true, text: 'Date' }},
          y: { title: { display: true, text: 'Amount' }}
        }
      }
    });
  }

  renderExpenseChart() {
    const expenseDates = this.expenseList.map(expense => expense.date);
    const expenseAmounts = this.expenseList.map(expense => expense.amount);

    this.expenseChart = new Chart('expenseChart', {
      type: 'line',
      data: {
        labels: expenseDates,
        datasets: [
          {
            label: 'Expenses Over Time',
            data: expenseAmounts,
            borderColor: 'red',
            fill: false
          }
        ]
      },
      options: {
        scales: {
          x: { title: { display: true, text: 'Date' }},
          y: { title: { display: true, text: 'Amount' }}
        }
      }
    });
  }
}
