const objeto ={
    texto: "O rato roeu a roupa do reid de Roma.",
    termo: "rato"
}

const ProcuraTermo = (obj) =>{

    return obj.texto.includes(obj.termo);
}

console.log(ProcuraTermo(objeto));