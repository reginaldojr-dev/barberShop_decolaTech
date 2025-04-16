import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ScheduleFormComponent } from './schedule-form/schedule-form.component';
import { ScheduleListComponent } from './schedule-list/schedule-list.component';

const routes: Routes = [
  { path: 'novo', component: ScheduleFormComponent },
  { path: 'editar/:id', component: ScheduleFormComponent },
  { path: 'listar', component: ScheduleListComponent },
  { path: '', redirectTo: 'listar', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ScheduleRoutingModule { }