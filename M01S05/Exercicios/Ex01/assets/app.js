import {Funcionario} from "./Funcionario.js";

const ada = new Funcionario('366.817.168-81','Rodolfo Rodrigues Bortolozo','1000');

console.log(ada.salario);

//Valida Cpf
console.log(Funcionario.isValidCPF('366.817.168-81'));

console.log(ada.promover(50));