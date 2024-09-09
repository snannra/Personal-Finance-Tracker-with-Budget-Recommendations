import { Component, OnInit } from '@angular/core';
import { ExpenseService } from '../services/expense/expense.service';
import { Router } from '@angular/router';
import { firstValueFrom } from 'rxjs';

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html',
  styleUrls: ['./expense-list.component.css']
})
export class ExpenseListComponent implements OnInit {
  expenseList: any[] = [];

  constructor(private expenseService: ExpenseService, private router: Router) {}

  ngOnInit() {
    this.loadExpenses();
  }

  async loadExpenses() {
    try {
      const data = await firstValueFrom(this.expenseService.getAllExpenses());
      this.expenseList = data;
    } catch (error) {
      console.error('Error loading expense data', error);
    }
  }

  async deleteExpense(id: number) {
    try {
      await firstValueFrom(this.expenseService.deleteExpense(id));
      this.loadExpenses(); // Reload the list after deletion
    } catch (error) {
      console.error('Error deleting expense', error);
    }
  }

  updateExpense(id: number) {
    this.router.navigate(['/expenses/edit', id]); // Redirect to the edit page with the expense id
  }
}
