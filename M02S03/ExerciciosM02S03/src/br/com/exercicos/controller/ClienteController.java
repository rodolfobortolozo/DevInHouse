package br.com.exercicos.controller;

import br.com.exercicos.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    List<Cliente> arrCliente = new ArrayList<>();

    public Boolean cadastroCliente(Cliente cliente){

        try{
            cliente.setId( arrCliente.size()+1 );

            arrCliente.add(cliente);

            return true;
        }catch (Exception ex){

            return false;
        }
    }

    public List<Cliente> listaCliente(){

        return arrCliente;
    }

}
