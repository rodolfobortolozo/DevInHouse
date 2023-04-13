package tech.devinhouse.quiz.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;
import tech.devinhouse.quiz.service.PerguntaService;

@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPerguntas() {
        return this.perguntaService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getPerguntaById(@Valid @PathVariable(value = "id") Long id) {
        return this.perguntaService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> savePergunta(@Valid @RequestBody PerguntaRequest perguntaRequest) {
        return this.perguntaService.savePergunta(perguntaRequest);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updatePergunta(@Valid @PathVariable(value = "id") Long id,
                                                 @RequestBody PerguntaRequest perguntaRequest) {

        return this.perguntaService.updatePergunta(id, perguntaRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        return this.perguntaService.deletePergunta(id);
    }

    @GetMapping(path = "/quiz/{id}")
    public ResponseEntity<Object> getByQuiz(@PathVariable(value = "id") Long id){
        return this.perguntaService.perguntaByQuiz(id);
    }
}
