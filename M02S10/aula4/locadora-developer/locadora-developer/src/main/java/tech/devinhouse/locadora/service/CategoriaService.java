package tech.devinhouse.locadora.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.locadora.model.Categoria;
import tech.devinhouse.locadora.model.Filme;
import tech.devinhouse.locadora.repository.CategoriaRepository;
import tech.devinhouse.locadora.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> getAllCategorias(){
        return this.categoriaRepository.findAll();
    }

    public Categoria saveCategoria(Categoria categoria){
        return this.categoriaRepository.save(categoria);
    }

    public Optional<Categoria> findCategoriaById (Long id){
        return this.categoriaRepository.findById(id);
    }

    public void deteleCategoriaById(Long id){
        this.categoriaRepository.deleteById(id);
    }
}
