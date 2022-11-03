import { Juros } from "./Juros.js";

const jurosMensal = new Juros(10000,0.07,24);

console.log(jurosMensal.calcularJurosSimples());

console.log(jurosMensal.calcularJurosCompostos());

const jurosAnual = new Juros(10000,0.15,10);

console.log(jurosAnual.calcularJurosSimples());

console.log(jurosAnual.calcularJurosCompostos());