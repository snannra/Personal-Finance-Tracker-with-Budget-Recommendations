import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class IncomeService {
  private apiUrl = 'http://localhost:8080/api/income';

  constructor(private http: HttpClient) { }

  // Get all incomes
  getAllIncomes(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  // Create income
  createIncome(incomeData: any): Observable<any> {
    return this.http.post(this.apiUrl, incomeData);
  }

  // Update income
  updateIncome(id: number, incomeData: any): Observable<any> {
    return this.http.put(`${this.apiUrl}/${id}`, incomeData);
  }

  // Delete income
  deleteIncome(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}