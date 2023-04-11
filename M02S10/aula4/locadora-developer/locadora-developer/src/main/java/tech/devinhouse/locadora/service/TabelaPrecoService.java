package tech.devinhouse.locadora.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.locadora.model.TabelaPreco;
import tech.devinhouse.locadora.repository.TabelaPrecoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TabelaPrecoService {

  private final TabelaPrecoRepository tabelaPrecoRepository;

  public TabelaPrecoService(TabelaPrecoRepository tabelaPrecoRepository) {
    this.tabelaPrecoRepository = tabelaPrecoRepository;
  }

  public List<TabelaPreco> getAllTabPreco(){
    return this.tabelaPrecoRepository.findAll();
  }

  public TabelaPreco saveTabPreco(TabelaPreco tabelaPreco){
    return  this.tabelaPrecoRepository.save(tabelaPreco);
  }

  public Optional<TabelaPreco> findTabPrecoById(Long id){
    return this.tabelaPrecoRepository.findById(id);
  }

  public void deleteTabPrecoById(Long id){
   this.tabelaPrecoRepository.deleteById(id);
  }

}
