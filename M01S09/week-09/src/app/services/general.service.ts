import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class GeneralService {
  constructor() {}

  somar(numero1: number, numero2: number) {
    return numero1 + numero2;
  }
  subtrair(numero1: number, numero2: number) {
    return numero1 - numero2;
  }
  dividir(numero1: number, numero2: number) {
    return numero1 / numero2;
  }
  multiplicar(numero1: number, numero2: number) {
    return numero1 * numero2;
  }
}
