package tech.devinhouse.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.quiz.repository.model.Resposta;

import java.util.List;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta,Long> {

  List<Resposta> findByPerguntaId(Long id);
}
