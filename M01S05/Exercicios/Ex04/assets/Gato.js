import { Animal } from "./Animal.js";

export class Gato extends Animal{

    constructor(nomeGato, idadeGato){    
        super(nomeGato, idadeGato);
    }


    get som(){
        return 'Miau';
    }

}