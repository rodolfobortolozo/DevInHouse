package tech.devinhouse.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.locadora.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
