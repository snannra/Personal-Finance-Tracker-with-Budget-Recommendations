import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ExpenseFormComponent } from './expense-form/expense-form.component';

export const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'expenses/add', component: ExpenseFormComponent }, // Route for adding a new expense
  { path: 'expenses/edit/:id', component: ExpenseFormComponent }, // Route for editing an expense with :id param
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Default route redirect to login
  { path: '**', redirectTo: '/login' } // Fallback route
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
