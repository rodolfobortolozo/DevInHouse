var numero = 0;
var resultado = 0;

//Laço de REpetição para Calculo
while(numero != -1){
    
    resultado += numero;
    numero = parseInt(prompt("Informe o número"));

}

alert(`Resultado da soma dos números é: ${resultado} !`);
