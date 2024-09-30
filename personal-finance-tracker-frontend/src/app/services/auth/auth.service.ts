import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/api/auth'; // Your API endpoint

  constructor(private http: HttpClient) { }

  // Login method, expecting the server to return a token
  login(credentials: { username: string; password: string }): Observable<{ token: string }> {
    return this.http.post<{ token: string }>(`${this.apiUrl}/login`, credentials);
  }
  
  // Check if the user is logged in by verifying if a token is stored in localStorage
  isLoggedIn(): boolean {
    if (typeof window === 'undefined') {
      return false;
    }

    // Make sure the token key is consistent with what you store in localStorage
    return !!localStorage.getItem('token');
  }

  // Register new users
  register(user: { username: string; email: string; password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user);
  }
}
