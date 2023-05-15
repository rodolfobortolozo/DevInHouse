package tech.devinhouse.personagens.controller;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.personagens.dto.PersonagemIdadeResponse;
import tech.devinhouse.personagens.dto.PersonagemRequest;
import tech.devinhouse.personagens.dto.PersonagemResponse;
import tech.devinhouse.personagens.dto.PersonagemUpdateRequest;
import tech.devinhouse.personagens.model.Personagem;
import tech.devinhouse.personagens.service.PersonagemService;

import java.net.URI;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/personagens")
@CrossOrigin
public class PersonagensController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonagemService service;


    @PostMapping
    public ResponseEntity inserir(@RequestBody @Valid PersonagemRequest request) {
        Personagem personagem = modelMapper.map(request, Personagem.class);
        personagem = service.inserir(personagem);
        PersonagemResponse resp = modelMapper.map(personagem, PersonagemResponse.class);
        return ResponseEntity.created(URI.create(resp.getId().toString())).body(resp);  // 201
    }

    @GetMapping
    public ResponseEntity<List<PersonagemResponse>> consultar() {
        List<Personagem> personagens = service.consultar();
        List<PersonagemResponse> resp = personagens.stream()
                .map(p -> modelMapper.map(p, PersonagemResponse.class)).toList();
        return ResponseEntity.ok(resp);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonagemResponse> consultar(@PathVariable("id") Long id) {
        Personagem personagem = service.consultar(id);
        PersonagemResponse resp = modelMapper.map(personagem, PersonagemResponse.class);
        return ResponseEntity.ok(resp);
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<PersonagemResponse> consultarPorCPF(@PathVariable("cpf") Long cpf) {
        Personagem personagem = service.consultarPor(cpf);
        PersonagemResponse resp = modelMapper.map(personagem, PersonagemResponse.class);
        return ResponseEntity.ok(resp);
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonagemResponse> alterar(@PathVariable("id") Long id,
                                                      @RequestBody @Valid PersonagemUpdateRequest request) {
        Personagem personagem = modelMapper.map(request, Personagem.class);
        personagem.setId(id);
        personagem = service.alterar(personagem);
        PersonagemResponse resp = modelMapper.map(personagem, PersonagemResponse.class);
        return ResponseEntity.ok(resp);
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}/idade")
    public ResponseEntity<PersonagemIdadeResponse> consultarIdade(@PathVariable("id") Long id) {
        Integer idade = service.consultarIdade(id);
        String nome = service.consultarNome(id);
        var resp = new PersonagemIdadeResponse(nome, idade);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("dados")
    public ResponseEntity<List<PersonagemResponse>> incluirDefault() {
        var lista = List.of(
                new Personagem(null, 12345678901L, "John Snow", LocalDate.of(1707, Month.JANUARY, 1), "Game of Thrones"),
                new Personagem(null, 22345678902L, "Sansa Stark", LocalDate.of(1705, Month.APRIL, 3), "Game of Thrones"),
                new Personagem(null, 32345678903L, "Adrian Monk", LocalDate.of(1977, Month.FEBRUARY, 2), "Monk"),
                new Personagem(null, 42345678904L, "Gandalf", LocalDate.of(1100, Month.JANUARY, 1), "Senhor dos Aneis"),
                new Personagem(null, 52345678905L, "Frodo Baggins", LocalDate.of(1600, Month.SEPTEMBER, 5), "Senhor dos Aneis"),
                new Personagem(null, 62345678906L, "Gollum", LocalDate.of(1690, Month.JULY, 10), "Senhor dos Aneis"),
                new Personagem(null, 72345678907L, "Saruman", LocalDate.of(1090, Month.DECEMBER, 31), "Senhor dos Aneis"),
                new Personagem(null, 82345678908L, "Aragorn", LocalDate.of(1777, Month.MARCH, 22), "Senhor dos Aneis")
        );
        List<Personagem> inseridos = service.inserir(lista);
        List<PersonagemResponse> resp = inseridos.stream().map(p -> modelMapper.map(p, PersonagemResponse.class)).toList();
        return ResponseEntity.created(URI.create("")).body(resp);
    }

}
