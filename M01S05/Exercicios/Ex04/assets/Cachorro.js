import { Animal } from "./Animal.js";

export class Cachorro extends Animal{
    
    constructor(nomeCachorro, idadeCachorro){

        super(nomeCachorro, idadeCachorro);
    }

    get som(){
        return 'Latido';
    }

}