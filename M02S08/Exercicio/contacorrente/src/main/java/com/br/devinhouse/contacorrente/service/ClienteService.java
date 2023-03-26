package com.br.devinhouse.contacorrente.service;

import com.br.devinhouse.contacorrente.model.entity.Cliente;
import com.br.devinhouse.contacorrente.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente saveCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAllCliente(){

        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id){

        return clienteRepository.findById(id);
    }

    @Transactional
    public void deleteCliente(Cliente cliente){

        this.clienteRepository.delete(cliente);

    }

}
