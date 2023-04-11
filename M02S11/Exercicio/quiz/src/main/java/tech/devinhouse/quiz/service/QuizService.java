package tech.devinhouse.quiz.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getAll(){
        return this.quizRepository.findAll();
    }

    public Optional<Quiz> getById(Long id){
        return this.quizRepository.findById(id);
    }

    public Quiz saveQuiz(Quiz quiz){
        return this.quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id){
        this.quizRepository.deleteById(id);
    }


}
