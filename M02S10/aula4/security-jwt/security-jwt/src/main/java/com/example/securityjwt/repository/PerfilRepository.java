package com.example.securityjwt.repository;

import com.example.securityjwt.model.Perfil;
import com.example.securityjwt.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
