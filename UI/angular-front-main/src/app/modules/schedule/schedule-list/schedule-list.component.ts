import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatTableModule } from '@angular/material/table';
import { ScheduleService } from 'src/app/core/services/schedule.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-schedule-list',
  standalone: true,
  templateUrl: './schedule-list.component.html',
  styleUrls: ['./schedule-list.component.css'],
  imports: [CommonModule, MatTableModule, RouterModule]
})
export class ScheduleListComponent implements OnInit {
  private scheduleService = inject(ScheduleService);

  agendamentos = [
    { nomeTutor: 'João', nomePet: 'Rex', data: '2024-04-01', hora: '10:00', servico: 'Banho' },
    { nomeTutor: 'Maria', nomePet: 'Mia', data: '2024-04-01', hora: '09:30', servico: 'Tosa' },
    { nomeTutor: 'Carlos', nomePet: 'Bobby', data: '2024-04-02', hora: '14:00', servico: 'Consulta Veterinária' }
  ];

  displayedColumns: string[] = ['data', 'hora', 'nomeTutor', 'nomePet', 'servico'];

  ngOnInit() {
    this.ordenarAgendamentos();
  }

  ordenarAgendamentos() {
    this.agendamentos.sort((a, b) => {
      const dataA = new Date(`${a.data}T${a.hora}`);
      const dataB = new Date(`${b.data}T${b.hora}`);
      return dataA.getTime() - dataB.getTime();
    });
  }
}
