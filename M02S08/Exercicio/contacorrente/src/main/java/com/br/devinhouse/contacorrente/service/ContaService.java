package com.br.devinhouse.contacorrente.service;

import com.br.devinhouse.contacorrente.model.entity.Conta;
import com.br.devinhouse.contacorrente.repository.ContaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional
    public Conta saveConta(Conta conta){

        return this.contaRepository.save(conta);

    }

    public boolean existsByNroConta(String nroConta){

        return this.contaRepository.existsByNroConta(nroConta);

    }

    public Optional<Conta> findContaByNroConta(String nroConta){
        return this.contaRepository.findContaByNroConta(nroConta);
    }

    public List<Conta> getAllContas(){

            return this.contaRepository.findAll();

    }

    @Transactional
    public void deleteConta(Conta conta){

        this.contaRepository.delete(conta);

    }
}
