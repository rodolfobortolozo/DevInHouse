export class Funcionario{
    //Variaveis Privadas
    #nomeCompleto;
    #cpf;
    #salario;
    #percentual;

    constructor(cpf, nomeCompleto, salario){
        
        this.#cpf = cpf;
        this.#nomeCompleto = nomeCompleto;
        this.#salario = parseFloat(salario);
    
    }

    promover(percentual){
        
        this.#percentual = parseFloat(percentual) / 100;
 
            return this.#salario + (this.#salario * this.#percentual);

    }

    get salario(){
        return this.#salario;
    }

    //Validação do CPF
    static isValidCPF(cpf) {
    if (typeof cpf !== 'string') return false
    cpf = cpf.replace(/[^\d]+/g, '')
    if (cpf.length !== 11 || !!cpf.match(/(\d)\1{10}/)) return false
    cpf = cpf.split('').map(el => +el)
    const rest = (count) => (cpf.slice(0, count-12)
        .reduce( (soma, el, index) => (soma + el * (count-index)), 0 )*10) % 11 % 10
    return rest(10) === cpf[9] && rest(11) === cpf[10]
}
    
}