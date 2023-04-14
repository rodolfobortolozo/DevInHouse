package tech.devinhouse.quiz.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;
import tech.devinhouse.quiz.repository.model.dto.RespostaRequest;
import tech.devinhouse.quiz.service.PerguntaService;
import tech.devinhouse.quiz.service.RespostaService;

@Tag(name = "Resposta", description = "Tutorial Resposta APIs")
@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllPerguntas(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return this.respostaService.getAll(pageable);
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
