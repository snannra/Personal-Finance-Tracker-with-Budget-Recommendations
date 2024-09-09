import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';  // Import FormsModule for ngModel
import { CommonModule } from '@angular/common';  // Import CommonModule for common directives like ngIf, ngFor
import { ExpenseService } from '../services/expense/expense.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-expense-form',
  standalone: true,
  imports: [CommonModule, FormsModule],  // Add FormsModule here for ngModel
  templateUrl: './expense-form.component.html',
  styleUrls: ['./expense-form.component.css']
})
export class ExpenseFormComponent implements OnInit {
  expenseData = {
    description: '',
    category: '',
    amount: 0,
    date: ''
  };

  isEditMode = false;  // To check if it's add or edit mode
  errorMessage: string | null = null;
  expenseId: number | null = null;

  constructor(
    private expenseService: ExpenseService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    // Check if we are editing an existing expense
    this.expenseId = this.route.snapshot.params['id'];
    if (this.expenseId) {
      this.isEditMode = true;
      this.loadExpense();
    }
  }

  // Load the existing expense data for editing
  loadExpense() {
    if (this.expenseId) {
      this.expenseService.getExpenseById(this.expenseId).subscribe({
        next: (expense) => {
          this.expenseData = expense;
        },
        error: (err) => {
          console.error('Failed to load expense', err);
        }
      });
    }
  }

  // Add or update expense
  onSubmit() {
    if (this.isEditMode) {
      this.updateExpense();
    } else {
      this.addExpense();
    }
  }

  // Add a new expense
  addExpense() {
    this.expenseService.createExpense(this.expenseData).subscribe({
      next: (response) => {
        console.log('Expense added', response);
        this.router.navigate(['/expenses']);  // Redirect to expenses list
      },
      error: (error) => {
        console.error('Failed to add expense', error);
        this.errorMessage = 'Failed to add expense';
      }
    });
  }

  // Update an existing expense
  updateExpense() {
    if (this.expenseId) {
      this.expenseService.updateExpense(this.expenseId, this.expenseData).subscribe({
        next: (response) => {
          console.log('Expense updated', response);
          this.router.navigate(['/expenses']);  // Redirect to expenses list
        },
        error: (error) => {
          console.error('Failed to update expense', error);
          this.errorMessage = 'Failed to update expense';
        }
      });
    }
  }
}
