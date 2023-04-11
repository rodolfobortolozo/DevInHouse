package tech.devinhouse.locadora.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.locadora.mapper.FilmeMapper;
import tech.devinhouse.locadora.model.Categoria;
import tech.devinhouse.locadora.model.Filme;
import tech.devinhouse.locadora.model.TabelaPreco;
import tech.devinhouse.locadora.model.request.FilmeRequest;
import tech.devinhouse.locadora.service.CategoriaService;
import tech.devinhouse.locadora.service.FilmeService;
import tech.devinhouse.locadora.service.TabelaPrecoService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;
    private final TabelaPrecoService tabelaPrecoService;
    private final CategoriaService categoriaService;

    public FilmeController(FilmeService filmeService, TabelaPrecoService tabelaPrecoService, CategoriaService categoriaService) {
        this.filmeService = filmeService;
        this.tabelaPrecoService = tabelaPrecoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<Object> getAllFilmes(){
        List<Filme> filmes = this.filmeService.getAllFilmes();

        if(filmes.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum Filme Cadastrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(filmes);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getFilmesById(@PathVariable(value = "id")Long id){

        Optional<Filme> filme = this.filmeService.findFilmeById(id);
        if(filme.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Filme Cadastrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(filme);

    }

    @PostMapping
    public ResponseEntity<Object> saveFilme(@Valid @RequestBody FilmeRequest filmeRequest){
        Long idTabPreco = filmeRequest.getIdTabpreco();
        Optional<TabelaPreco> opTabelaPreco = this.tabelaPrecoService.findTabPrecoById(idTabPreco);

        if(opTabelaPreco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tabela de preço não Encontrada");
        }

        Filme filme = FilmeMapper.INSTANCE.reqToFilme(filmeRequest);
        filme.setTabelaPreco(opTabelaPreco.get());

        Filme newFilme = this.filmeService.saveFilme(filme);
        newFilme.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(filme);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<Object> updateFilme(@PathVariable(value = "id") Long id,
                                              @Valid @RequestBody FilmeRequest filmeRequest){

        Long idTabPreco = filmeRequest.getIdTabpreco();
        Optional<TabelaPreco> opTabelaPreco = this.tabelaPrecoService.findTabPrecoById(idTabPreco);

        Optional<Filme> opFilme = this.filmeService.findFilmeById(id);

        if(opFilme.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Filme não Encontrado");
        }

        if(opTabelaPreco.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tabela de preço não Encontrada");
        }


        Filme filme = FilmeMapper.INSTANCE.reqToFilme(filmeRequest);
        filme.setId(opFilme.get().getId());
        filme.setTabelaPreco(opTabelaPreco.get());

        Filme newFilme = this.filmeService.saveFilme(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFilme);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> deleteFilme(@PathVariable (value = "id")Long id){

        Optional<Filme> opFilme = this.filmeService.findFilmeById(id);

        if(opFilme.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum Filme encontrado");
        }

        this.tabelaPrecoService.findTabPrecoById(id);

        return ResponseEntity.status(HttpStatus.OK).body(null);

    }
}
