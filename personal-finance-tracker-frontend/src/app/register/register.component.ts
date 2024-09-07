import { Component } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html'
})
export class RegisterComponent {
  user = {
    username: '',
    email: '',
    password: ''
  };

  constructor(private authService: AuthService) {}

  onSubmit() {
    this.authService.register(this.user).subscribe(response => {
      console.log('User registered successfully', response);
    }, error => {
      console.error('Error registering user', error);
    });
  }
}