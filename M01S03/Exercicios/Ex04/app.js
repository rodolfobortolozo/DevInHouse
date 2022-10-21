const objUm = { a: 1, b: 2 };
const objDois = { c: 3, d: 4 };


//Spread
const mesclaObjetos = (array1, array2) =>  { 
        
    return  {...array1, ...array2};

};

const novoObjeto = mesclaObjetos(objUm, objDois);

console.log(novoObjeto);
