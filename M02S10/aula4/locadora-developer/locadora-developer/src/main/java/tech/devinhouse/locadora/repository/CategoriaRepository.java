package tech.devinhouse.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.devinhouse.locadora.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
