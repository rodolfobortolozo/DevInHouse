package tech.devinhouse.quiz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.devinhouse.quiz.mapper.PerguntaMapper;
import tech.devinhouse.quiz.repository.model.Pergunta;
import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;
import tech.devinhouse.quiz.service.PerguntaService;
import tech.devinhouse.quiz.service.QuizService;
import tech.devinhouse.quiz.repository.model.Quiz;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    private final PerguntaService perguntaService;
    private final QuizService quizService;

    public PerguntaController(PerguntaService perguntaService, QuizService quizService) {
        this.perguntaService = perguntaService;
        this.quizService = quizService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPerguntas() {
        List<Pergunta> perguntas = this.perguntaService.getAll();

        if (perguntas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Pergunta Cadastrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(perguntas);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getPerguntaById(@PathVariable(value = "id") Long id) {
        Optional<Pergunta> pergunta = this.perguntaService.getById(id);

        if (pergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não Encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pergunta);
    }

    @PostMapping()
    public ResponseEntity<Object> savePergunta(@RequestBody PerguntaRequest perguntaRequest) {

        Optional<Quiz> opQuiz = this.quizService.getById(perguntaRequest.getQuiz());

        if (opQuiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quiz não encontardo");
        }

        Pergunta pergunta = PerguntaMapper.INSTANCE.resToPergunta(perguntaRequest);
        pergunta.setQuiz(opQuiz.get());

        Pergunta newPergunta = this.perguntaService.savePergunta(pergunta);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPergunta);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> supdatePergunta(@PathVariable(value = "id") Long id,
            @RequestBody Pergunta pergunta) {

        Optional<Pergunta> opPergunta = this.perguntaService.getById(id);

        if (opPergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não Encontrada");
        }

        pergunta.setId(id);
        Pergunta newPergunta = this.perguntaService.savePergunta(pergunta);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPergunta);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        Optional<Pergunta> pergunta = this.perguntaService.getById(id);

        if (pergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não Encontrada");
        }
        this.perguntaService.deletePergunta(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
