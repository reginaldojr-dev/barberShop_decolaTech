import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { Router, RouterModule } from '@angular/router';
import { MatCardModule } from '@angular/material/card';


@Component({
  selector: 'app-dashboard-home',
  standalone: true,
  imports: [CommonModule, RouterModule, MatButtonModule, MatCardModule],
  templateUrl: './dashboard-home.component.html',
  styleUrls: ['./dashboard-home.component.css']
})
export class DashboardHomeComponent {
  constructor(private router: Router) {}

  navigateToPetForm() {
    this.router.navigate(['/cadastrar-cliente']);
  }
  
  navigateToScheduleForm() {
    this.router.navigate(['/agendar-servico']);
  }
  
  navigateToPetList() {
    this.router.navigate(['/listar-cliente']);
  }
  
  
}
