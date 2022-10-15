//Exercicio 1
let idade = parseInt(prompt("Informe o a Idade"));

if(idade<16){
    alert('Não pode votar')
}else if(idade<18 || idade>=70){
    alert('Voto Opcional')
}else {
    alert('Obrigatório a Votar')
}

//Exercicio 2
let mes = parseInt(prompt("Informe o Mês"));
mesDescrito(mes);

function mesDescrito(mes){
    switch(mes){
        case 1:
            alert('Janeiro');
            break;
        case 2:
            alert('Fevereiro');
            break;
        case 3:
            alert('Março');
            break;
        case 4:
            alert('Abril');
            break;
        case 5:
            alert('Maio');
            break;
        case 6:
            alert('Junho');
            break;
        case 7:
            alert('Julho');
            break;
        case 8:
            alert('Agosto');
            break;
        case 9:
            alert('Setembro');
            break;
        case 10:
            alert('Outubro');
            break;
        case 11:
            alert('Novembro');
            break;
        case 12:
            alert('Dezembro');  
            break;
        default:
            alert('Mês Inválido');
    }
}

//Ternario

let isAutenticado = false;

isAutenticado? console.log('Bem Vindo!') : console.log('Acesso Negado!');