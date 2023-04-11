package tech.devinhouse.locadora.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.locadora.mapper.CategoriaMapper;
import tech.devinhouse.locadora.mapper.TabelaPrecoMapper;
import tech.devinhouse.locadora.model.Categoria;
import tech.devinhouse.locadora.model.TabelaPreco;
import tech.devinhouse.locadora.model.request.CategoriaRequest;
import tech.devinhouse.locadora.service.CategoriaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  private final CategoriaService categoriaService;
  public CategoriaController(CategoriaService categoriaService) {
    this.categoriaService = categoriaService;
  }

  @GetMapping
  public ResponseEntity<Object> getAllCategoria(){

    List<Categoria> categorias = this.categoriaService.getAllCategorias();

    if(categorias.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma categoria");
    }
      return ResponseEntity.status(HttpStatus.OK).body(categorias);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> getCategoriaById(@PathVariable(value = "id") Long id){

    Optional<Categoria> categoria = this.categoriaService.findCategoriaById(id);

    if(categoria.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Categoria");
    }
    return ResponseEntity.status(HttpStatus.OK).body(categoria);
  }

  @PostMapping
  public ResponseEntity<Categoria> saveCategoria(@Valid @RequestBody CategoriaRequest categoriaRequest){
    Categoria categoria = CategoriaMapper.INSTANCE.reqToCategoria(categoriaRequest);
    categoria.setId(null);
    Categoria newCategoria =this.categoriaService.saveCategoria(categoria);

    return ResponseEntity.status(HttpStatus.CREATED).body(newCategoria);

  }

  @PutMapping(path = "{id}")
  public ResponseEntity<Object> updateCategoria(@PathVariable (value = "id")Long id,
                                               @Valid @RequestBody CategoriaRequest categoriaRequest){

    Optional<Categoria> opCategoria = this.categoriaService.findCategoriaById(id);

    if(opCategoria.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Categoria");
    }

    Categoria categoria = CategoriaMapper.INSTANCE.reqToCategoria(categoriaRequest);
    categoria.setId(opCategoria.get().getId());
    Categoria newCategoria =this.categoriaService.saveCategoria(categoria);

    return ResponseEntity.status(HttpStatus.OK).body(newCategoria);

  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Object> deleteCategoria(@PathVariable (value = "id")Long id){

    Optional<Categoria> opTabelaPreco = this.categoriaService.findCategoriaById(id);

    if(opTabelaPreco.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Categoria");
    }

    this.categoriaService.deteleCategoriaById(id);

    return ResponseEntity.status(HttpStatus.OK).body(null);

  }

}
