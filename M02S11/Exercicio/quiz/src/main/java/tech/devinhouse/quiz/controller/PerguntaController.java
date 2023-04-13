package tech.devinhouse.quiz.controller;

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
    public ResponseEntity<Object> getPerguntaById(@PathVariable(value = "id") Long id) {
        return this.perguntaService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> savePergunta(@RequestBody PerguntaRequest perguntaRequest) {
        return this.perguntaService.savePergunta(perguntaRequest);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updatePergunta(@PathVariable(value = "id") Long id,
                                                 @RequestBody PerguntaRequest perguntaRequest) {

        return this.perguntaService.updatePergunta(id, perguntaRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        return this.perguntaService.deletePergunta(id);
    }

}
