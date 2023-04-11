package tech.devinhouse.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.devinhouse.quiz.mapper.QuizMapper;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.model.dto.QuizRequest;
import tech.devinhouse.quiz.service.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllQuiz() {
        List<Quiz> quizzes = this.quizService.getAll();

        if (quizzes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum Quiz Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(quizzes);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getQuizById(@PathVariable(value = "id") Long id) {
        Optional<Quiz> quiz = this.quizService.getById(id);

        if (quiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    @PostMapping()
    public ResponseEntity<Object> saveQuiz(@RequestBody QuizRequest quizrRequest) {

        Quiz quiz = QuizMapper.INSTANCE.reqToQuiz(quizrRequest);

        Quiz newQuiz = this.quizService.saveQuiz(quiz);

        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updatePergunta(@PathVariable(value = "id") Long id,
            @RequestBody QuizRequest quizRequest) {

        Optional<Quiz> opQuiz = this.quizService.getById(id);
        Quiz quiz = QuizMapper.INSTANCE.reqToQuiz(quizRequest);

        if (opQuiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }

        quiz.setId(id);
        Quiz newQuiz = this.quizService.saveQuiz(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        Optional<Quiz> quiz = this.quizService.getById(id);

        if (quiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }
        this.quizService.deleteQuiz(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
