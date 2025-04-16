import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Clientes } from '../models/clientes';

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  private apiUrl = `${environment.apiBaseUrl}/clientes`;

  constructor(private http: HttpClient) { }

  getClientes(): Observable<Clientes[]> {
    return this.http.get<Clientes[]>(this.apiUrl);
  }

  getClientesById(id: string): Observable<Clientes> {
    return this.http.get<Clientes>(`${this.apiUrl}/${id}`);
  }

  createClientes(pet: Clientes): Observable<Clientes> {
    return this.http.post<Clientes>(this.apiUrl, pet);
  }

  updateClientes(id: string, clientes: Clientes): Observable<Clientes> {
    return this.http.put<Clientes>(`${this.apiUrl}/${id}`, clientes);
  }

  deleteClientes(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
