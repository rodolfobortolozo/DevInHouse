package tech.devinhouse.quiz.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.devinhouse.quiz.mapper.PerguntaMapper;
import tech.devinhouse.quiz.repository.PerguntaRepository;
import tech.devinhouse.quiz.repository.QuizRepository;
import tech.devinhouse.quiz.repository.model.Pergunta;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;

import java.util.List;
import java.util.Optional;

@Service
public class PerguntaService {

    private final PerguntaRepository perguntaRepository;
    private final QuizRepository quizRepository;

    public PerguntaService(PerguntaRepository perguntaRepository, QuizRepository quizRepository) {
        this.perguntaRepository = perguntaRepository;
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<Object> getAll(){

        List<Pergunta> perguntas = this.perguntaRepository.findAll();

        if (perguntas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Nenhuma Pergunta Cadastrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(perguntas);
    }

    public ResponseEntity<Object> getById(Long id){
        Optional<Pergunta> pergunta =  this.perguntaRepository.findById(id);

        if (pergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não Encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pergunta);
    }

    public ResponseEntity<Object> savePergunta(PerguntaRequest perguntaRequest){
        //return this.perguntaRepository.save(pergunta);

        Optional<Quiz> opQuiz = this.quizRepository.findById(perguntaRequest.getIdQuiz());

        if (opQuiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quiz não encontrado");
        }

        Pergunta pergunta = PerguntaMapper.INSTANCE.resToPergunta(perguntaRequest);
        pergunta.setQuiz(opQuiz.get());

        Pergunta newPergunta = this.perguntaRepository.save(pergunta);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPergunta);
    }

    public ResponseEntity<Object> updatePergunta(Long id, PerguntaRequest perguntaRequest) {

        Optional<Quiz> opQuiz = this.quizRepository.findById(perguntaRequest.getIdQuiz());
        Optional<Pergunta> opPergunta = this.perguntaRepository.findById(id);

        if (opPergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não encontrado");
        }

        if (opQuiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Quiz não encontrado");
        }

        Pergunta pergunta = PerguntaMapper.INSTANCE.resToPergunta(perguntaRequest);

        pergunta.setId(id);
        pergunta.setQuiz(opQuiz.get());

        Pergunta newPergunta = this.perguntaRepository.save(pergunta);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPergunta);
    }

    public ResponseEntity<Object> deletePergunta(Long id){
        Optional<Pergunta> pergunta = this.perguntaRepository.findById(id);

        if (pergunta.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pergunta não Encontrada");
        }
        this.perguntaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


}
