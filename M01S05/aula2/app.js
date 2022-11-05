import
  Pessoa,
  { paraMaiusculo, nomeGenerico as nome }
from "./Pessoa.js";

paraMaiusculo(nome);

console.log('Olá! m1-s05-a2')

const romeu = new Pessoa(5, "a@b.com")
const isaac = new Pessoa("Isaac", "a@b.com")

console.log(romeu);
console.log(isaac);

romeu.caminha()

console.log(
  Pessoa.isPessoa(romeu)
);
