import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ClientesService } from '../../../core/services/clientes.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-clientes-list',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    RouterModule,
  ],
  templateUrl: './clientes-list.component.html',
  styleUrls: ['./clientes-list.component.css']
})
export class ClientesListComponent {
  searchForm: FormGroup;
  clienteDetails: any = null;
  clienteNotFound = false;

  constructor(
    private clientesService: ClientesService,
    private fb: FormBuilder
  ) {
    this.searchForm = this.fb.group({
      clienteId: ['', [Validators.required]]
    });

    console.log('ClientesListComponent carregado!');
  }

  buscarClientes() {
    if (this.searchForm.invalid) return;

    const id = this.searchForm.value.clienteId;

    this.clientesService.getClientesById(id).subscribe({
      next: (data: any) => {
        this.clienteDetails = data;
        this.clienteNotFound = false;
      },
      error: () => {
        this.clienteDetails = null;
        this.clienteNotFound = true;
      }
    });
  }
}
