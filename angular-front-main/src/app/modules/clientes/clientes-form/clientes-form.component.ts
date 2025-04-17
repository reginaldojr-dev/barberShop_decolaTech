import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClientesService } from 'src/app/core/services/clientes.service';
import { RouterModule, Router } from '@angular/router';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { HttpClient } from '@angular/common/http';
import { MatSnackBar } from '@angular/material/snack-bar';


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
  clientesForm: FormGroup;
  searchForm: FormGroup;
  clienteDetails: any = null;
  clienteNotFound = false;

  constructor(
    private fb: FormBuilder,
    private clientesService: ClientesService,
    private dialog: MatDialog,
    private http: HttpClient,
    private router: Router,
    private snackBar: MatSnackBar
  ) {
    // Inicializa o formulário de cadastro
    this.clientesForm = this.fb.group({
      nome: ['', Validators.required],
      telefone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      idade: ['', [Validators.required, Validators.min(0)]],
      preferencia: ['']
    });

    // Formulário de busca (se ainda for necessário)
    this.searchForm = this.fb.group({
      clienteId: ['', Validators.required]
    });
  }

  cadastrarClientes() {
    if (this.clientesForm.invalid) return;
  
    this.clientesService.cadastrarClientes(this.clientesForm.value).subscribe({
      next: () => {
        this.snackBar.open('Cliente cadastrado com sucesso!', 'Fechar', {
          duration: 3000,
          horizontalPosition: 'right',
          verticalPosition: 'top',
          panelClass: ['snack-success']
        });
        this.clientesForm.reset(); // limpa o formulário
      },
      error: (err: any) => {
        this.snackBar.open('Erro ao cadastrar cliente!', 'Fechar', {
          duration: 3000,
          horizontalPosition: 'right',
          verticalPosition: 'top',
          panelClass: ['snack-error']
        });
        console.error('Erro ao cadastrar cliente:', err);
      }
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
