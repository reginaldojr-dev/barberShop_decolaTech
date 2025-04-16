import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ClientesService } from './services/clientes.service';

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    ClientesService,
  ]
})
export class CoreModule { }
