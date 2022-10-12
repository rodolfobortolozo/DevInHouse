var tipoCalculo = prompt('Informe o Tipo de Calculo que deseja fazer + - * /');
var numero1 = parseFloat(prompt('Informe o Primeiro Número:'));
var numero2 = parseFloat(prompt('Informe o Segundo Número:'));
var resultado = 0;


switch(tipoCalculo){
    case '+':
        resultado = numero1 + numero2;
        break;
    case '-':
        resultado = numero1 - numero2;
        break;
    case '*':
        resultado = numero1 * numero2;
        break;
    case '/':
        resultado = numero1 / numero2;
        break;
    default:
        alert('Operção Inválida!');
}


alert(`O resultado do seu cálculo é: ${resultado}`);
