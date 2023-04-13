package tech.devinhouse.quiz.controller;

import jakarta.validation.Valid;
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
        return this.quizService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getQuizById(@Valid  @PathVariable(value = "id") Long id) {
       return this.quizService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> saveQuiz(@Valid @RequestBody QuizRequest quizrRequest) {

        return this.quizService.saveQuiz(quizrRequest);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updatePergunta(@Valid @PathVariable(value = "id") Long id,
            @RequestBody QuizRequest quizRequest) {

        return this.quizService.updatePergunta(id, quizRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@Valid @PathVariable(value = "id") Long id) {
        return this.quizService.deleteQuiz(id);
    }

}
