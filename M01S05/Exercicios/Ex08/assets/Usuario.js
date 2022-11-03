export class Usuario {
    constructor(nome, email, senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    autenticar(emailInformado, senhaInformada) {
        console.log(this.email);
        console.log(this.senha);
        console.log(emailInformado);
        console.log(senhaInformada);
        return (this.email === emailInformado && this.senha === senhaInformada);
    }
}