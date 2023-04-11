package tech.devinhouse.quiz.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.quiz.repository.model.Pergunta;
import tech.devinhouse.quiz.repository.PerguntaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;

    public PerguntaService(PerguntaRepository perguntaRepository) {
        this.perguntaRepository = perguntaRepository;
    }

    public List<Pergunta> getAll(){
        return this.perguntaRepository.findAll();
    }

    public Optional<Pergunta> getById(Long id){
        return this.perguntaRepository.findById(id);
    }

    public Pergunta savePergunta(Pergunta pergunta){
        return this.perguntaRepository.save(pergunta);
    }

    public void deletePergunta(Long id){
        this.perguntaRepository.deleteById(id);
    }


}
