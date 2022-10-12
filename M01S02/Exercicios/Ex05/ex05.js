var numero = 0;
var resto = 0;
var qtdpar = 0;
var qtdimpar = 0;

//Laço de REpetição para Calculo

numero = parseInt(prompt("Informe o número"));

for(var i=0;i<=numero;i++){

    resto = i % 2;
    if(resto == 0){
        qtdpar +=1;
    }else{
        qtdimpar +=1;
    }

}

alert(`A quantidade é de ${qtdpar} pares e ${qtdimpar} ímpares !`);
