import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {
  private apiUrl = 'http://localhost:8080/api/expense';  // Replace with your actual backend API URL

  constructor(private http: HttpClient) { }

  private getAuthHeaders() {
    const token = localStorage.getItem('token'); // Retrieve the token from local storage
    return new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json'
    });
  }


  // Get all expenses for the logged-in user
  getAllExpenses(): Observable<any> {
    return this.http.get(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  getExpenseById(id: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }

  // Create a new expense
  createExpense(expenseData: any): Observable<any> {
    return this.http.post(this.apiUrl, expenseData, { headers: this.getAuthHeaders() });
  }

  // Update an existing expense
  updateExpense(id: number, expenseData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, expenseData, { headers: this.getAuthHeaders() });
  }

  // Delete an expense
  deleteExpense(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }
}