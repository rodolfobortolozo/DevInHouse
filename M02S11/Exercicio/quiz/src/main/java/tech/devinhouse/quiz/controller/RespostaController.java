package tech.devinhouse.quiz.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;
import tech.devinhouse.quiz.repository.model.dto.RespostaRequest;
import tech.devinhouse.quiz.service.PerguntaService;
import tech.devinhouse.quiz.service.RespostaService;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPerguntas() {
        return this.respostaService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getRespostaById(@Valid  @PathVariable(value = "id") Long id) {
        return this.respostaService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> saveResposta(@Valid @RequestBody RespostaRequest respostaRequest) {
        return this.respostaService.saveResposta(respostaRequest);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateResposta(@Valid @PathVariable(value = "id") Long id,
                                                 @RequestBody RespostaRequest respostaRequest) {

        return this.respostaService.updateResposta(id, respostaRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@Valid @PathVariable(value = "id") Long id) {
        return this.respostaService.deleteResposta(id);
    }

    @GetMapping(path = "/pergunta/{id}")
    public ResponseEntity<Object> getRespostaByPerguntaId(@PathVariable(value = "id") Long id){
        return this.respostaService.getbyPerguntaId(id);
    }

}
