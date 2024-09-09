import { Component, OnInit } from '@angular/core';
import { IncomeService } from '../services/income/income.service';
import { firstValueFrom } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-income-list',
  templateUrl: './income-list.component.html',
  styleUrls: ['./income-list.component.css']
})
export class IncomeListComponent implements OnInit {
  incomeList: any[] = [];

  constructor(private incomeService: IncomeService, private router: Router) {}

  ngOnInit() {
    this.loadIncome();
  }

  async loadIncome() {
    try {
      const data = await firstValueFrom(this.incomeService.getAllIncomes());
      this.incomeList = data;
    } catch (error) {
      console.error('Error loading income data', error);
    }
  }

  async deleteIncome(id: number) {
    try {
      await firstValueFrom(this.incomeService.deleteIncome(id));
      this.loadIncome(); // Reload the list after deletion
    } catch (error) {
      console.error('Error deleting income', error);
    }
  }

  updateIncome(id: number) {
    this.router.navigate(['/incomes/edit', id]); // Redirect to the edit page with the income id
  }
}
