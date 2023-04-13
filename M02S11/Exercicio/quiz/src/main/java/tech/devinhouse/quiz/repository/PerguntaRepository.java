package tech.devinhouse.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.quiz.repository.model.Pergunta;

import java.util.List;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

  List<Pergunta> findPerguntaByQuizId (Long id);
}
