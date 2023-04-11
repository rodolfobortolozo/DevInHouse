package tech.devinhouse.quiz.service;

import org.springframework.stereotype.Service;
import tech.devinhouse.quiz.repository.model.Resposta;
import tech.devinhouse.quiz.repository.RespostaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;

    public RespostaService(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public List<Resposta> getAll(){
        return this.respostaRepository.findAll();
    }

    public Optional<Resposta> getById(Long id){
        return this.respostaRepository.findById(id);
    }

    public Resposta saveResposta(Resposta resposta){
        return this.respostaRepository.save(resposta);
    }

    public void deleteResposta(Long id){
        this.respostaRepository.deleteById(id);
    }


}
