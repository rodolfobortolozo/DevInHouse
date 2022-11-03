export class Juros{
   #capitalInicial;  
   #taxaAplicada;
   #tempo;

   constructor(capitalInicial, taxaAplicada, tempo){

    this.#capitalInicial = parseFloat(capitalInicial);
    this.#taxaAplicada = parseFloat(taxaAplicada);
    this.#tempo = parseFloat(tempo);

   }

   calcularJurosSimples(){
    return this.#capitalInicial * this.#taxaAplicada * this.#tempo;
   }

   calcularJurosCompostos(){
      return this.#capitalInicial * (1 + this.#taxaAplicada) ** this.#tempo;
     }
}