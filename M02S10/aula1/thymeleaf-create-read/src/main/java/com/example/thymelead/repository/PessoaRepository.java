package com.example.thymelead.repository;

import com.example.thymelead.repository.model.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Long> {
}
