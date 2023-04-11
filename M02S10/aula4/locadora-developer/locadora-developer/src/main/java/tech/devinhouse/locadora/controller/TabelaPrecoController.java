package tech.devinhouse.locadora.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.locadora.mapper.TabelaPrecoMapper;
import tech.devinhouse.locadora.model.TabelaPreco;
import tech.devinhouse.locadora.model.request.TabelaPrecoRequest;
import tech.devinhouse.locadora.service.TabelaPrecoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tabprecos")
public class TabelaPrecoController {

  private final TabelaPrecoService tabelaPrecoService;
  public TabelaPrecoController(TabelaPrecoService tabelaPrecoService) {
    this.tabelaPrecoService = tabelaPrecoService;
  }

  @GetMapping
  public ResponseEntity<Object> getAllTabPreco(){

    List<TabelaPreco> tabelaPreco = this.tabelaPrecoService.getAllTabPreco();

    if(tabelaPreco.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Tabela de Preço");
    }
      return ResponseEntity.status(HttpStatus.OK).body(tabelaPreco);
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Object> getTabPrecoById(@PathVariable(value = "id") Long id){

    Optional<TabelaPreco> tabelaPreco = this.tabelaPrecoService.findTabPrecoById(id);

    if(tabelaPreco.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Tabela de Preço");
    }
    return ResponseEntity.status(HttpStatus.OK).body(tabelaPreco);
  }

  @PostMapping
  public ResponseEntity<TabelaPreco> saveTabPreco(@Valid @RequestBody TabelaPrecoRequest tabelaPrecoRequest){
    TabelaPreco tabelaPreco = TabelaPrecoMapper.INSTANCE.reqToTabPreco(tabelaPrecoRequest);
    tabelaPreco.setId(null);
    TabelaPreco newtabelaPreco =this.tabelaPrecoService.saveTabPreco(tabelaPreco);

    return ResponseEntity.status(HttpStatus.CREATED).body(newtabelaPreco);

  }

  @PutMapping(path = "{id}")
  public ResponseEntity<Object> updateTabPreco(@PathVariable (value = "id")Long id,
                                               @Valid @RequestBody TabelaPrecoRequest tabelaPrecoRequest){

    Optional<TabelaPreco> opTabelaPreco = this.tabelaPrecoService.findTabPrecoById(id);

    if(opTabelaPreco.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Tabela de Preço");
    }

    TabelaPreco tabelaPreco = TabelaPrecoMapper.INSTANCE.reqToTabPreco(tabelaPrecoRequest);
    tabelaPreco.setId(opTabelaPreco.get().getId());
    TabelaPreco newtabelaPreco =this.tabelaPrecoService.saveTabPreco(tabelaPreco);

    return ResponseEntity.status(HttpStatus.OK).body(newtabelaPreco);

  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Object> deleteTabPreco(@PathVariable (value = "id")Long id){

    Optional<TabelaPreco> opTabelaPreco = this.tabelaPrecoService.findTabPrecoById(id);

    if(opTabelaPreco.isEmpty()){
      return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Tabela de Preço");
    }

    this.tabelaPrecoService.deleteTabPrecoById(id);

    return ResponseEntity.status(HttpStatus.OK).body(null);

  }

}
