export class Fatura{
    #id;
    #descricao;
    #quantia;
    #preco;

    constructor(id, descricao, quantia, preco){
        
        this.#id = id;
        this.#descricao = descricao;
        this.#quantia = parseFloat(quantia);
        this.#preco = parseFloat(preco);
        
        if(this.#quantia<0) this.#quantia = 0;

        if(this.#preco<0) this.#preco = 0;
    
    }

    obterValorTotal (){
        return this.#quantia * this.#preco;
    }

    get valorTotal(){
        return this.#quantia * this.#preco;
    }
}