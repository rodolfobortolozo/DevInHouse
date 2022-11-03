import { Partida } from "./Partida.js";

export class Time{
     #nome;
     #sigla;
     #vitorias;
     #derrotas;
     #empates;
     #golMarcados;
     #golSofridos;

     constructor(nome, sigla, vitorias, derrotas, empates, golMarcados, golSofridos){
      this.#nome = nome;
      this.#sigla = sigla;
      this.#vitorias = vitorias;
      this.#derrotas = derrotas;
      this.#empates = empates;
      this.#golMarcados = golMarcados;
      this.#golSofridos = golSofridos;
     }

     computaPartida(partida){
      

     }
   
}