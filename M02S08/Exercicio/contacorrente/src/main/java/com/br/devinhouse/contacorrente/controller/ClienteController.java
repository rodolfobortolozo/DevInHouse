package com.br.devinhouse.contacorrente.controller;

import com.br.devinhouse.contacorrente.mapper.ClienteMapper;
import com.br.devinhouse.contacorrente.model.entity.Cliente;
import com.br.devinhouse.contacorrente.model.request.ClienteRequest;
import com.br.devinhouse.contacorrente.model.response.ClienteResponse;
import com.br.devinhouse.contacorrente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    ClienteService clienteService;

    ClienteController (ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Object> getAll() {

            List<ClienteResponse> clientesResponse = ClienteMapper.INSTANCE.toListClienteResponse(clienteService.getAllCliente());

            if (clientesResponse.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Cliente Instalado");
            }

            return ResponseEntity.status(HttpStatus.OK).body(clientesResponse);
    }

    @PostMapping
    public ResponseEntity<Object> saveCliente(@Valid @RequestBody ClienteRequest clienteRequest){

            Cliente cliente = ClienteMapper.INSTANCE.fromClientRequest(clienteRequest);
            cliente.setAtivo(1);
            Cliente newCliente = this.clienteService.saveCliente(cliente);
            ClienteResponse clienteResponse = ClienteMapper.INSTANCE.toClienteResponse(newCliente);
            return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getClienteById(@PathVariable Long id) {

        Optional<Cliente> clientesOp = clienteService.findById(id);
        List<Cliente> clientes = clientesOp.stream().collect(Collectors.toList());
        List<ClienteResponse> clienteResponse = ClienteMapper.INSTANCE.toListClienteResponse(clientes);

        if (clienteResponse.isEmpty()) {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
            throw new IllegalArgumentException("Teste");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteResponse);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClienteById(@PathVariable(value = "id") Long id,
                                                    @RequestBody ClienteRequest clienteRequest){
        Optional<Cliente> cliente = this.clienteService.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }

        Cliente updateCLiente = ClienteMapper.INSTANCE.fromClientRequest(clienteRequest);
        updateCLiente.setId(cliente.get().getId());
        Cliente updateCliente = this.clienteService.saveCliente(updateCLiente);
        ClienteResponse clienteResponse = ClienteMapper.INSTANCE.toClienteResponse(updateCliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id){

        Optional<Cliente> cliente = this.clienteService.findById(id);
        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        this.clienteService.deleteCliente(cliente.get());
        return ResponseEntity.status(HttpStatus.OK).body("Cliente Deletado!");

    }
}
