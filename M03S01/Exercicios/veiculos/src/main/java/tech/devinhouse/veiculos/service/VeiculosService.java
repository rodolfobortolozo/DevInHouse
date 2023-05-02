package tech.devinhouse.veiculos.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.devinhouse.veiculos.model.Veiculos;
import tech.devinhouse.veiculos.repository.VeiculosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculosService {

  private final VeiculosRepository veiculosRepository;

  public VeiculosService(VeiculosRepository veiculosRepository) {
    this.veiculosRepository = veiculosRepository;
  }

  public ResponseEntity<List<Veiculos>> buscarTodosVeiculos(){
    return ResponseEntity.status(HttpStatus.OK).body(this.veiculosRepository.findAll());
  }

  public ResponseEntity<Veiculos> salvarVeiculo(Veiculos veiculos){

    if(this.veiculosRepository.existsByPlaca(veiculos.getPlaca())){
      return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
    }

    veiculos.setQtdMultas(0);
    return ResponseEntity.status(HttpStatus.CREATED).body(this.veiculosRepository.save(veiculos));

  }

  public ResponseEntity<Veiculos> adicionarMulta(String placa){

    return this.veiculosRepository.findById(placa)
            .map(veiculos ->{
              veiculos.setQtdMultas(veiculos.getQtdMultas() + 1);
              return ResponseEntity.status(HttpStatus.OK).body(this.veiculosRepository.save(veiculos));

            }).orElse(ResponseEntity.notFound().build());
  }

  public ResponseEntity<Veiculos> pesquisarPlaca(String placa){

    return this.veiculosRepository.findById(placa)
            .map(veiculos ->{
              return ResponseEntity.status(HttpStatus.OK).body(veiculos);

            }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

  }

  public ResponseEntity<Object> deletarVeiculo(String placa){

    return this.veiculosRepository.findById(placa)
            .map(veiculos ->{

              if(veiculos.getQtdMultas()>0){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
              }

              this.veiculosRepository.deleteById(placa);
              return ResponseEntity.status(HttpStatus.OK).body(null);

            }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));

  }

}
