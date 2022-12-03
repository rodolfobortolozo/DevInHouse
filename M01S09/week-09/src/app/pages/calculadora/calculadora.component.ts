import { Component, Input } from '@angular/core';
import { NgModel, FormsModule } from '@angular/forms';
import { GeneralService } from 'src/app/services/general.service';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.scss'],
})
export class CalculadoraComponent {
  constructor(private calculadora: GeneralService) {}
  num1: Number = 0;
  num2: Number = 0;
  operacao: String = '';
  resultado: Number = 0;
  msg: String = '';

  calcular() {
    switch (this.operacao) {
      case 'Multiplicar':
        this.resultado = this.calculadora.multiplicar(
          Number(this.num1),
          Number(this.num2)
        );
        break;
      case 'Somar':
        this.resultado = this.calculadora.somar(
          Number(this.num1),
          Number(this.num2)
        );
        break;
      case 'Dividir':
        this.resultado = this.calculadora.dividir(
          Number(this.num1),
          Number(this.num2)
        );
        break;
      case 'Subtrair':
        this.resultado = this.calculadora.subtrair(
          Number(this.num1),
          Number(this.num2)
        );
        break;
      default:
        alert('Operação Inválida');
        break;
    }
  }
}
