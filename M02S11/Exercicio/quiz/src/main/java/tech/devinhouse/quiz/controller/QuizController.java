package tech.devinhouse.quiz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.devinhouse.quiz.mapper.QuizMapper;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.model.dto.QuizRequest;
import tech.devinhouse.quiz.service.QuizService;

import java.util.List;
import java.util.Optional;

@Tag(name = "Quiz", description = "Tutorial Quiz APIs")
@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Operation(
            summary = "Retrieve a Tutorial by Id",
            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "tutorials", "get" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Quiz.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping
    public ResponseEntity<Object> getAllQuiz(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return this.quizService.getAll(pageable);
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
