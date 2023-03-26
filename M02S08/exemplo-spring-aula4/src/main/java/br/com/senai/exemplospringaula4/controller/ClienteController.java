package br.com.senai.exemplospringaula4.controller;

import br.com.senai.exemplospringaula4.model.Cliente;
import br.com.senai.exemplospringaula4.service.ClienteService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cliente")
@RestController
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }


    @GetMapping
    public List<Cliente> listarCliente(){
        return service.pesquisarClientes();
    }

    @GetMapping(params = "id")
    public Cliente listarClienteId(
            @RequestParam Integer id
    ){
        return service.pesquisarClientePorId(id);
    }

//    @GetMapping("/{id}")
//    public Cliente listarClienteId(
//            @PathVariable Integer id
//    ){
//        return service.pesquisarClientePorId(id);
//    }

    @PostMapping
    public boolean criarCliente(
            @RequestBody
            @Validated
            Cliente cliente
    ){
        return service.criarCliente(cliente);
    }

    // localhost:8080/cliente/{id}
    // localhost:8080/cliente/1
    // localhost:8080/cliente/0
    @DeleteMapping("/{id}")
    public boolean listarCliente(@PathVariable Integer id){
        return service.deletarClientePorId(id);
    }

    @PutMapping()
    public void atualizarCliente(
            @RequestParam Integer id,
            @RequestBody @Validated Cliente cliente
    ){
        service.alterarClientePorId(id, cliente);
    }


}
