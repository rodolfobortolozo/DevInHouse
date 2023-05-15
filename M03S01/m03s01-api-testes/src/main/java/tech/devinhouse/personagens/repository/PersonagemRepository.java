package tech.devinhouse.personagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.devinhouse.personagens.model.Personagem;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

    boolean existsPersonagemByCpf(Long cpf);

    Optional<Personagem> findByCpf(Long cpf);

    @Query("SELECT p FROM Personagem p WHERE p.dataNascimento > :data") // jpql
    List<Personagem> consultarPorDataNascimentoPosteriorA(LocalDate data);

    @Query("SELECT p FROM Personagem p WHERE p.nome LIKE :nomeParcial")
    List<Personagem> consultarPorNomeParcial(String nomeParcial);

}
