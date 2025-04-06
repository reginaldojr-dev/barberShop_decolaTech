import { Routes } from '@angular/router';
import { DashboardHomeComponent } from './modules/dashboard/dashboard-home/dashboard-home.component';
import { ClientesFormComponent } from './modules/clientes/clientes-form/clientes-form.component';
import { ClientesListComponent } from './modules/clientes/clientes-list/clientes-list.component';
import { ScheduleFormComponent } from './modules/schedule/schedule-form/schedule-form.component';
import { ScheduleListComponent } from './modules/schedule/schedule-list/schedule-list.component';


export const routes: Routes = [
  { 
    path: '', 
    redirectTo: 'dashboard', 
    pathMatch: 'full' 
  },
  { 
    path: 'dashboard', 
    component: DashboardHomeComponent
  },
  { 
    path: 'cadastrar-cliente', 
    component: ClientesFormComponent,
    data: { title: 'Cadastrar Cliente' }
  },
  { 
    path: 'listar-cliente', 
    component: ClientesListComponent,
    data: { title: 'Lista de Clientes' }
  },
  { 
    path: 'agendar-servico', 
    component: ScheduleFormComponent,
    data: { title: 'Agendar Serviço' }
  },
  { 
    path: 'listar-agendamentos', 
    component: ScheduleListComponent,
    data: { title: 'Lista de Agendamentos' }
  },
  { 
    path: '**', 
    redirectTo: 'dashboard' 
  }
];