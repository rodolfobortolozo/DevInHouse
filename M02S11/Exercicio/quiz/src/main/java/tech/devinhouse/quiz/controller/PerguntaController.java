package tech.devinhouse.quiz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;
import tech.devinhouse.quiz.service.PerguntaService;

@Tag(name = "Pergunta", description = "Tutorial Pergunta APIs")
@RestController
@RequestMapping("/perguntas")
public class PerguntaController {

    private final PerguntaService perguntaService;

    public PerguntaController(PerguntaService perguntaService) {
        this.perguntaService = perguntaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPerguntas(Pageable pageable) {
        return this.perguntaService.getAll(pageable);
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
