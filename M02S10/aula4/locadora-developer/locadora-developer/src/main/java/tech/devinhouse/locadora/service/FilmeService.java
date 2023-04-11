package tech.devinhouse.locadora.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.locadora.model.Filme;
import tech.devinhouse.locadora.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> getAllFilmes(){
        return this.filmeRepository.findAll();
    }

    public Filme saveFilme(Filme filme){
        return this.filmeRepository.save(filme);
    }

    public Optional<Filme> findFilmeById (Long id){
        return this.filmeRepository.findById(id);
    }

    public void deteleFilmeById(Long id){
        this.filmeRepository.deleteById(id);
    }
}
