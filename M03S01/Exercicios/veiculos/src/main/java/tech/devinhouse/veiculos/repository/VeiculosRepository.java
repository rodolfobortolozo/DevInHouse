package tech.devinhouse.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.veiculos.model.Veiculos;

@Repository
public interface VeiculosRepository extends JpaRepository<Veiculos, String> {

  boolean existsByPlaca(String placa);
}
