package tech.devinhouse.quiz.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.model.dto.QuizRequest;
import tech.devinhouse.quiz.service.QuizService;


@Tag(name = "Quiz", description = "Tutorial Quiz APIs")
@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Operation(
            summary = "Recupera Todos os Quiz Cadastrados",
            description = "Retornara Todos os Quiz Cadasrados",
            tags = { "Quiz" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Quiz.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping
    public ResponseEntity<Object> getAllQuiz() {
        return this.quizService.getAll();
    }

    @Operation(
            summary = "Recupera o quiz pelo Id",
            description = "Retornara o quiz pelo seu Id cadastrado",
            tags = { "Quiz" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Quiz.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getQuizById(@Valid  @PathVariable(value = "id") Long id) {
       return this.quizService.getById(id);
    }

    @Operation(
            summary = "Salva o Quiz",
            description = "Salva o Quiz",
            tags = { "Quiz" })
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = QuizRequest.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping()
    public ResponseEntity<Object> saveQuiz(@Valid @RequestBody QuizRequest quizrRequest) {

        return this.quizService.saveQuiz(quizrRequest);
    }


    @Operation(
            summary = "Atualiza o Quiz pelo Id",
            description = "Atualiza o Quiz pelo Id",
            tags = { "Quiz" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = QuizRequest.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updatePergunta(@Valid @PathVariable(value = "id") Long id,
            @RequestBody QuizRequest quizRequest) {

        return this.quizService.updatePergunta(id, quizRequest);
    }

    @Operation(
            summary = "Deleta o Quiz pelo Id",
            description = "Deleta o Quiz pelo Id",
            tags = { "Quiz" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@Valid @PathVariable(value = "id") Long id) {
        return this.quizService.deleteQuiz(id);
    }

}
