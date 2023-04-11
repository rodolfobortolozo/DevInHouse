package tech.devinhouse.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.devinhouse.quiz.repository.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
