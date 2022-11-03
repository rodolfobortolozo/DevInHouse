import { Usuario } from "./Usuario.js";

const form = document.getElementById('form');
const usuario = new Usuario('Rodolfo', 'rodolfobortolozo@gmail.com','123456');

//Função para validar usuário;
const ValidarUsuario = (event)=>{
    event.preventDefault();

    const user = document.getElementById('usuario').value;
    const password = document.getElementById('senha').value;
    
    if(usuario.autenticar(user,password)){
        return console.log('Sucesso');
    }

    return console.log('Credenciais inválidas!');
}

form.addEventListener('submit', ValidarUsuario);