import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClientesListComponent } from './clientes-list/clientes-list.component';
import { ClientesDetailsComponent } from './clientes-details/clientes-details.component';

const routes: Routes = [
  { path: 'cadastrar', component: ClientesFormComponent },
  { path: 'editar/:id', component: ClientesFormComponent },
  { path: 'listar', component: ClientesListComponent },
  { path: ':id', component: ClientesDetailsComponent },
  { path: '', redirectTo: 'listar', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }