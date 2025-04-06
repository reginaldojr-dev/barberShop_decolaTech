import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardHomeComponent } from './dashboard-home/dashboard-home.component';

const routes: Routes = [
  { 
    path: '', 
    component: DashboardHomeComponent,
    children: [
      // Rotas filhas do dashboard
      { 
        path: 'cadastrar-clientes', 
        loadChildren: () => import('../clientes/clientes.module').then(m => m.ClientesModule),
        data: { title: 'Cadastrar Cliente' }
      },
      { 
        path: 'agendar-servico', 
        loadChildren: () => import('../schedule/schedule.module').then(m => m.ScheduleModule),
        data: { title: 'Agendar Serviço' }
      },
      { 
        path: 'listar-clientes', 
        loadChildren: () => import('../clientes/clientes.module').then(m => m.ClientesModule),
        data: { title: 'Listar Clientes' }
      },
      {
        path: 'listar-agendamentos',
        loadChildren: () => import('../schedule/schedule.module').then(m => m.ScheduleModule),
        data: { title: 'Listar Agendamentos' }
      },
      // Redirecionamento padrão
      { path: '', redirectTo: '', pathMatch: 'full' }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }