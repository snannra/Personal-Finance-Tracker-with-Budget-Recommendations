import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
  private apiUrl = 'http://localhost:8080/api/expense';  // Replace with your actual backend API URL

  constructor(private http: HttpClient) { }

  // Get all expenses
  getAllExpenses(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Get a single expense by ID
  getExpenseById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`);
  }

  // Create a new expense
  createExpense(expenseData: any): Observable<any> {
    return this.http.post(this.apiUrl, expenseData);
  }

  // Update an existing expense by ID
  updateExpense(id: number, expenseData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, expenseData);
  }

  // Delete an expense by ID
  deleteExpense(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}