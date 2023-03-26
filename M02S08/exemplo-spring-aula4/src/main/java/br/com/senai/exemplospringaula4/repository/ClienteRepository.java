package br.com.senai.exemplospringaula4.repository;

import br.com.senai.exemplospringaula4.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {
    private static List<Cliente> clienteList = new ArrayList<>();

    public List<Cliente> encontrarClientes(){
        return clienteList;
    }

    public Cliente encontrarClienteId(Integer id){
        return clienteList.get(id);
    }

    public boolean salvarCliente(Cliente cliente){
        return clienteList.add(cliente);
    }

    public boolean deletarClienteId(Integer id){
        return clienteList.remove(encontrarClienteId(id));
    }

    public void atualizarClientId(Integer id, Cliente cliente){
        clienteList.add(id,cliente);
    }
}
