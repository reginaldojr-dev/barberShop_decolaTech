// pets.module.ts (versão mínima)
import { NgModule } from '@angular/core';
import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesService } from 'src/app/core/services/clientes.service';

@NgModule({
  imports: [ClientesRoutingModule],
  providers: [ClientesService],
})
export class ClientesModule { }