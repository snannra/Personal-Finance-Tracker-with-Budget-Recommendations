import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Import FormsModule
import { RouterModule, Routes } from '@angular/router'; // Import RouterModule for routing

import { AppComponent } from './app.component'; // Main app component
import { NavbarComponent } from './navbar/navbar.component'; // Add your components
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ExpenseFormComponent } from './expense-form/expense-form.component';
import { IncomeFormComponent } from './income-form/income-form.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'expenses/add', component: ExpenseFormComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Default route
  { path: '**', redirectTo: '/login' } // Wildcard route
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    IncomeFormComponent,
    HeaderComponent,
    FooterComponent,
    ExpenseFormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, 
    RouterModule.forRoot(routes) 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
