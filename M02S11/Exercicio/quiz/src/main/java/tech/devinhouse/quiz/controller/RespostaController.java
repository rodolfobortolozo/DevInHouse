package tech.devinhouse.quiz.controller;

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
    public ResponseEntity<Object> getRespostaById(@PathVariable(value = "id") Long id) {
        return this.respostaService.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Object> saveResposta(@RequestBody RespostaRequest respostaRequest) {
        return this.respostaService.saveResposta(respostaRequest);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Object> updateResposta(@PathVariable(value = "id") Long id,
                                                 @RequestBody RespostaRequest respostaRequest) {

        return this.respostaService.updateResposta(id, respostaRequest);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        return this.respostaService.deleteResposta(id);
    }

}
