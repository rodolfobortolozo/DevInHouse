package tech.devinhouse.locadora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.locadora.model.TabelaPreco;

@Repository
public interface TabelaPrecoRepository extends JpaRepository<TabelaPreco,Long> {

}
