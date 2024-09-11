import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IncomeService {
  private apiUrl = 'http://localhost:8080/api/income';

  constructor(private http: HttpClient) {}

  // Get authentication token from local storage
  private getAuthHeaders() {
    const token = localStorage.getItem('token');
    if (token) {
      return new HttpHeaders({
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json'
      });
    } else {
      console.error('No token found in localStorage');
      return new HttpHeaders({
        'Content-Type': 'application/json'
      });
    }
  }

  // Get all incomes
  getAllIncomes(): Observable<any> {
    return this.http.get(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  // Create income
  createIncome(incomeData: any): Observable<any> {
    return this.http.post(this.apiUrl, incomeData, { headers: this.getAuthHeaders() });
  }

  // Update income
  updateIncome(id: number, incomeData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, incomeData, { headers: this.getAuthHeaders() });
  }

  // Delete income
  deleteIncome(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`, { headers: this.getAuthHeaders() });
  }
}
