export class Personagem{
    #nome;
    #percentualVida;
    #percentualDano;

    constructor(nome){
        
        this.#nome = nome;
        this.#percentualVida = +100;
    
    }

    sofreuDano(percentuaDano){
        
        this.#percentualDano = parseFloat(percentuaDano);

        this.#percentualVida = this.#percentualVida -  this.#percentualDano;
        
        return this.#percentualVida;

    }

    usouKitMedico(){
        
        if( this.#percentualVida + 10 >= 100){

            this.#percentualVida = 100;

        }else{
        
            this.#percentualVida += 10;
        }
    }

    get percentualVida(){
        return this.#percentualVida;
    }
}