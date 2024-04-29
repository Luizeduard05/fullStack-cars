import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ICor } from 'src/app/model/ICor';
import { IMarca } from 'src/app/model/IMarca';
import { CarroService } from 'src/app/services/carro.service';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent {

  constructor(private service: CarroService, private router: Router) { }

  //Dados do veiculo
  nome_carro!: string;
  ano_fabricacao!: number;
  ano_modelo!: number;
  modelo_carro!: string;
  marcaNome!: string; // Variavel que armazena o nome em string
  coresString!: string; // Variavel que armazena o nome em string

  postCar(): void {

    this.validaCampos()

    //Alterando o tipo da variavel marca
    const novaMarca: IMarca = {
      nome: this.marcaNome
    }

    // Convertendo string em array de string
    const coresArray = this.coresString.split(',')

    // Criação de array de objetos a partir dos dados coresArays
    const coresObjetos: ICor[] = coresArray.map(cor => ({ cor }))

    const novoCarro = {
      nome_carro: this.nome_carro,
      ano_fabricacao: this.ano_fabricacao,
      ano_modelo: this.ano_modelo,
      modelo_carro: this.modelo_carro,
      marca: novaMarca,
      cores: coresObjetos
    }

    this.service.postCar(novoCarro)
      .subscribe(() => {
        alert('Carro adicionado com sucesso')
        this.router.navigateByUrl('')
      }
      )
  }

  validaCampos() {
    if (!this.nome_carro) {
      alert("O Campo Nome não pode ser vazio")
    } else if (!this.ano_fabricacao) {
      alert("O Campo Ano de Fabricação deve ser um número maior que 1000")
    } else if (!this.ano_modelo) {
      alert("O Campo Ano Modelo deve ser um número maior que 1000")
    } else if (!this.modelo_carro) {
      alert("O Campo Modelo não pode ser vázio")
    } else if (!this.marcaNome) {
      alert("O Campo Marca não pode ser vázio")
    } else if (!this.coresString) {
      alert("O Campo Cores não pode ser vázio")
    }
  }

  cancelar(): void {
    this.router.navigateByUrl('')
  }
}
