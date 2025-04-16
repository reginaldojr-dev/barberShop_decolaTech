import { Component, inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-schedule-form',
  standalone: true,
  templateUrl: './schedule-form.component.html',
  styleUrls: ['./schedule-form.component.css'],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatButtonModule,
    RouterModule,
    MatIconModule,
  ],
})
export class ScheduleFormComponent {
  private fb = inject(FormBuilder); // ✅ injeta corretamente
  scheduleForm: FormGroup = this.fb.group({
    nome: ['', Validators.required],
    numeroTelefone: ['', Validators.required],
    data: ['', Validators.required],
    hora: ['', Validators.required],
    servico: ['', Validators.required]
  });

  agendar() {
    if (this.scheduleForm.valid) {
      console.log('Agendamento realizado com sucesso:', this.scheduleForm.value);
    }
  }
}
