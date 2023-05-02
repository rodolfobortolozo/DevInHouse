package tech.devinhouse.veiculos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.devinhouse.veiculos.model.Veiculos;
import tech.devinhouse.veiculos.service.VeiculosService;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

  private final VeiculosService veiculosService;

  public VeiculosController(VeiculosService veiculosService) {
    this.veiculosService = veiculosService;
  }

  @GetMapping
  public ResponseEntity<List<Veiculos>> buscarTodos(){

    return this.veiculosService.buscarTodosVeiculos();

  }

  @PostMapping
  public ResponseEntity<Veiculos> SalvarVeiculos(@RequestBody Veiculos veiculos){

    return this.veiculosService.salvarVeiculo(veiculos);

  }

  @PutMapping("/{placa}/multas")
  public ResponseEntity<Veiculos> adicionarMulta(@PathVariable("placa") String placa){
    return this.veiculosService.adicionarMulta(placa);
  }

  @GetMapping("/{placa}")
  public ResponseEntity<Veiculos> pesquisarPlaca(@PathVariable("placa") String placa){
    return this.veiculosService.pesquisarPlaca(placa);
  }

  @DeleteMapping("/{placa}")
  public ResponseEntity<Object> deletarVeiculo(@PathVariable("placa") String placa){
    return this.veiculosService.deletarVeiculo(placa);
  }



}
