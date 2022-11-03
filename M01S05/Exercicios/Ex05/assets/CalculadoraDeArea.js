export class CalculadoraDeArea{
    #tipo;
    #base;
    #altura;

    constructor(tipo, base, altura){
        this.#tipo = tipo;
        this.#base = parseFloat(base);
        this.#altura = parseFloat(altura)   ;
    }

    Calcular(){
        switch (this.#tipo){

            case 'quadrado':
                return this.#base * this.#altura;
                break;

            case 'triangulo':
                return (this.#base * this.#altura) / 2;
                break;
            default:
                return('Tipo Informado inválido!');

        }

    }
}