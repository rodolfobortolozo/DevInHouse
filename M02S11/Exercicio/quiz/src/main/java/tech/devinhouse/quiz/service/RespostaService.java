package tech.devinhouse.quiz.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.devinhouse.quiz.mapper.RespostaMapper;
import tech.devinhouse.quiz.repository.PerguntaRepository;
import tech.devinhouse.quiz.repository.RespostaRepository;
import tech.devinhouse.quiz.repository.model.Pergunta;
import tech.devinhouse.quiz.repository.model.Resposta;
import tech.devinhouse.quiz.repository.model.dto.RespostaRequest;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final PerguntaRepository perguntaRepository;

    public RespostaService(PerguntaRepository perguntaRepository, RespostaRepository respostaRepository) {
        this.perguntaRepository = perguntaRepository;
        this.respostaRepository = respostaRepository;
    }

    public ResponseEntity<Object> getAll(){

        List<Resposta> resposta = this.respostaRepository.findAll();

        if (resposta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Resposta Cadastrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    public ResponseEntity<Object> getById(Long id){
        Optional<Resposta> resposta =  this.respostaRepository.findById(id);

        if (resposta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Respota não Encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    public ResponseEntity<Object> saveResposta(RespostaRequest respostaRequest){

        Optional<Pergunta> opPergunta = this.perguntaRepository.findById(respostaRequest.getIdPergunta());

        if (opPergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não encontrada");
        }

        Resposta resposta = RespostaMapper.INSTANCE.reqToResposta(respostaRequest);
        resposta.setPergunta(opPergunta.get());

        Resposta newResposta = this.respostaRepository.save(resposta);

        return ResponseEntity.status(HttpStatus.CREATED).body(newResposta);
    }

    public ResponseEntity<Object> updateResposta(Long id, RespostaRequest respostaRequest) {

        Optional<Pergunta> opPergunta = this.perguntaRepository.findById(respostaRequest.getIdPergunta());
        Optional<Resposta> opResposta = this.respostaRepository.findById(id);

        if (opPergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não encontrado");
        }

        if (opResposta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resposta não encontrado");
        }

        Resposta resposta = RespostaMapper.INSTANCE.reqToResposta(respostaRequest);

        resposta.setId(id);
        resposta.setPergunta(opPergunta.get());

        Resposta newPergunta = this.respostaRepository.save(resposta);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPergunta);
    }

    public ResponseEntity<Object> deleteResposta(Long id){
        Optional<Resposta> resposta = this.respostaRepository.findById(id);

        if (resposta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resposta não Encontrada");
        }
        this.respostaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    public ResponseEntity<Object> getbyPerguntaId(Long id){
        List<Pergunta> pergunta = this.perguntaRepository.findPerguntaByQuizId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pergunta);
    }


}
