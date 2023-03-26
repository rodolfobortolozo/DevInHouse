package com.br.devinhouse.contacorrente.repository;


import com.br.devinhouse.contacorrente.model.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

    boolean existsByNroConta(String nroConta);

    Optional<Conta> findContaByNroConta(String nroConta);
}
