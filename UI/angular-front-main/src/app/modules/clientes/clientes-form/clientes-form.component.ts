import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClientesService } from 'src/app/core/services/clientes.service';
import { RouterModule } from '@angular/router';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-clientes-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    RouterModule,
    MatDialogModule,
    MatIconModule,
    MatButtonModule,
    MatInputModule,
    MatSelectModule,
    MatFormFieldModule
  ],
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent {
cadastrarClientes() {
throw new Error('Method not implemented.');
}
  searchForm: FormGroup;
  clienteDetails: any = null;
  clienteNotFound = false;
clientesForm: any;

  constructor(
    private fb: FormBuilder,
    private clientesService: ClientesService,
    private dialog: MatDialog,
    private http: HttpClient
  ) {
    this.searchForm = this.fb.group({
      clienteId: ['', Validators.required]
    });
  }

  buscarCliente(): void {
    const id = this.searchForm.value.clienteId;

    this.clientesService.getClientesById(id).subscribe({
      next: (clientes: any) => {
        this.clienteDetails = clientes;
        this.clienteNotFound = false;
      },
      error: (err: any) => {
        console.error('Erro ao buscar cliente:', err);
        this.clienteDetails = null;
        this.clienteNotFound = true;
      }
    });
  }
}
