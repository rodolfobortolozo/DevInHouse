package com.br.devinhouse.contacorrente.controller;

import com.br.devinhouse.contacorrente.mapper.ContaMapper;
import com.br.devinhouse.contacorrente.model.entity.Cliente;
import com.br.devinhouse.contacorrente.model.entity.Conta;
import com.br.devinhouse.contacorrente.model.request.ContaRequest;
import com.br.devinhouse.contacorrente.model.response.ContaResponse;
import com.br.devinhouse.contacorrente.service.ClienteService;
import com.br.devinhouse.contacorrente.service.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ContaController {

    private final ContaService contaService;
    private final ClienteService clienteService;

    public ContaController(ContaService contaService, ClienteService clienteService) {
        this.contaService = contaService;
        this.clienteService = clienteService;
    }


    @PostMapping(path = "/clientes/{id}/contas")
    public ResponseEntity<Object> saveConta(@PathVariable(value = "id") Long id,
                                            @RequestBody ContaRequest contaRequest){

        Optional<Cliente> cliente = this.clienteService.findById(id);

        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não Encontrado");
        }
        if(contaService.existsByNroConta(contaRequest.getNroConta())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Numero de Conta já Existe");
        }

        Conta conta = ContaMapper.INSTANCE.fromContaRequest(contaRequest);
        conta.setSaldo(0L);

        conta.setCliente(cliente.get());

        Conta newConta = contaService.saveConta(conta);
        ContaResponse contaResponse = ContaMapper.INSTANCE.doContaResponse(newConta);
        return ResponseEntity.status(HttpStatus.CREATED).body(contaResponse);

    }

    @GetMapping(path = "/contas")
    public ResponseEntity<Object> getAllContas() {

            List<Conta> contas = contaService.getAllContas();

            if(contas.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não tem Conta Cadastradas");
            }

            List<ContaResponse> contaResponse = ContaMapper.INSTANCE.toListContaResponse(contas);
            return ResponseEntity.status(HttpStatus.OK).body(contaResponse);

    }

    @DeleteMapping("/clientes/{id}/contas/{nroconta}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") Long id,
                                                @PathVariable(value = "nroconta") String nroConta){

        Optional<Cliente> cliente = this.clienteService.findById(id);
        Optional<Conta> conta = this.contaService.findContaByNroConta(nroConta);

        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        if(conta.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada!");
        }

        this.contaService.deleteConta(conta.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta Deletada!");

    }
}
