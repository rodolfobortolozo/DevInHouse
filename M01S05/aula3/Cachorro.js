
import Animal from "./Animal.js";

export default class Cachorro extends Animal {
  constructor(nome) {
    super(nome, "Latido");
  }

  get nome() {
    return `${super.nome} faz ${this.som} (cachorro)`;
  }

  teste() {
    console.log(this.nome);
    console.log(super.nome);
  }
}
