package tech.devinhouse.quiz.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tech.devinhouse.quiz.mapper.QuizMapper;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.QuizRepository;
import tech.devinhouse.quiz.repository.model.dto.QuizRequest;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<Object> getAll(){
        List<Quiz> quizzes = this.quizRepository.findAll();

        if (quizzes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum Quiz Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(quizzes);
    }

    public ResponseEntity<Object> getById(Long id){

        Optional<Quiz> quiz = this.quizRepository.findById(id);

        if (quiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    public ResponseEntity<Object> saveQuiz(QuizRequest quizrRequest){

        Quiz quiz = QuizMapper.INSTANCE.reqToQuiz(quizrRequest);
        Quiz newQuiz = this.quizRepository.save(quiz);

        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);

    }

    public ResponseEntity<Object> updatePergunta(Long id, QuizRequest quizRequest) {

        Optional<Quiz> opQuiz = this.quizRepository.findById(id);

        if (opQuiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }


        Quiz quiz = QuizMapper.INSTANCE.reqToQuiz(quizRequest);
        quiz.setId(id);
        Quiz newQuiz = this.quizRepository.save(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);
    }

    public ResponseEntity<Object> deleteQuiz(Long id){
        Optional<Quiz> quiz = this.quizRepository.findById(id);

        if (quiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }
        this.quizRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);


    }


}
