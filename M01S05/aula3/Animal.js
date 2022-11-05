
export default class Animal {
  #nome
  som
  constructor(nome, som) {
    this.#nome = nome;
    this.som = som;
  }

  getMetodoComum() {
    return `Id: ${this.#nome}`;
  }
  setMetodoComum(valor) {
    console.log({ valor });
    this.#nome = valor;
  }
  get nome() {
    // adicione aqui sua lógica...
    return `Animal: ${this.#nome}`;
  }
  set nome(valor) {
    // adicione aqui sua lógica...
    this.#nome = valor;
  }
}
