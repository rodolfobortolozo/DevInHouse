package com.br.devinhouse.contacorrente.repository;

import com.br.devinhouse.contacorrente.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsById(Long id);
}
