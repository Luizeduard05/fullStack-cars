import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ICarro } from 'src/app/model/ICarro';
import { CarroService } from 'src/app/services/carro.service';

@Component({
  selector: 'app-cards-car',
  templateUrl: './cards-car.component.html',
  styleUrls: ['./cards-car.component.css']
})
export class CardsCarComponent implements OnInit {

  // OBJETO CARRO
  nome_carro!: string;
  ano_fabricacao!: number;
  marca!: string; 


  // JSON DE CARROS
  carros: ICarro[] = [];

  // CONFIGURAÇÃO DADOS DE CARREGAMENTO
  dadosCarregados = false;

  constructor(private service: CarroService, private router: Router) { }

  ngOnInit(): void {
    this.getAll()
  }

  getAll(): void {
    this.service.getAll()
      .subscribe(retorno => {
        this.carros = retorno;
        this.dadosCarregados = true
      }

      );

  }

  selecionarCar(i: number): void {
    this.service.carroSelecionado = this.carros[i];
    this.router.navigateByUrl('/dadosCar')
  }
}