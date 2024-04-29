import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, delay } from 'rxjs';
import { ICarro } from '../model/ICarro';

@Injectable({
  providedIn: 'root'
})
export class CarroService {

  private apiUrl = 'http://localhost:8080/api/v1/carro';

  // Função para selecionar um carro
  carroSelecionado!: ICarro;

  constructor(private http: HttpClient) { }

  getAll(): Observable<ICarro[]> {
    return this.http.get<ICarro[]>(this.apiUrl)
    .pipe(
      // delay(3000)
    )
    }

  postCar(carro: ICarro): Observable<ICarro> {
    return this.http.post<ICarro>(this.apiUrl, carro);
  }

  putCar(carro: ICarro): Observable<ICarro> {
    return this.http.put<ICarro>(`${this.apiUrl}/${carro.id}`, carro)
  }
    
  deleteCar(carro: ICarro): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${carro.id}`);
  }
  }

