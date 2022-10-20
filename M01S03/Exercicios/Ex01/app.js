

const ex1 = [56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47]
const ex2 = []
const ex3 = [1]
const ex4 = [1, -1]
const ex5 = null
const ex6 = [-2,-2,-2,-2]
const ex7 = [20,10, 30]



const procuraMinMax = (lista) => {

    let numMaior = -Infinity;
    let numMenor = Infinity;
    
    if( !Array.isArray(lista) || lista.length <= 1 ){
        return 'Não foi possivel definir';
    }
    
    lista.forEach(list => {
        if(list > numMaior){
            numMaior = list;
        }
        if(list < numMenor){
            numMenor = list;
        }
    })
    
    if(numMaior == numMenor){
        return 'Não foi possivel definir';
    }    
    
    return `Maior número do array ${numMaior} e o menor ${numMenor}`;

};

console.log(procuraMinMax(ex6));