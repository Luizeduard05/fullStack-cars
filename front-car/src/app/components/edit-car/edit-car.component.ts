import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CarroService } from 'src/app/services/carro.service';

@Component({
  selector: 'app-edit-car',
  templateUrl: './edit-car.component.html',
  styleUrls: ['./edit-car.component.css']
})
export class EditCarComponent {

  carroSelecionado = this.service.carroSelecionado;
  editarCampos: boolean = false;

  constructor(private service: CarroService, private router: Router) { }

  editCar(): void {

    if (this.carroSelecionado.cores.some(cor => cor.cor.trim() === '')) {
      alert("O Campo cores não pode ser vazio")
      return;
    }

    if (!this.editarCampos) {
      this.editarCampos = true

      // Desabilitação Botão de remover
      document.getElementById('removeBtn')?.setAttribute('disabled', 'true')
      //Alterando texto do botão editar
      const alterarBtn = document.getElementById('alterarBtn');
      alterarBtn?.setAttribute('value', 'Salvar')
    } else {
      this.service.putCar(this.carroSelecionado)
        .subscribe(() => {
          alert("Carro editado")
          this.router.navigateByUrl('')
        });
    }
  }

  deleteCar(): void {
    this.service.deleteCar(this.carroSelecionado)
      .subscribe(() => {
        alert("Carro excluido");
        this.router.navigateByUrl('')
      })
  }

  cancelar(): void {
    this.router.navigateByUrl('')
  }
}

