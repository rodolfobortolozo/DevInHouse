package tech.devinhouse.quiz.service;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tech.devinhouse.quiz.controller.QuizController;
import tech.devinhouse.quiz.mapper.QuizMapper;
import tech.devinhouse.quiz.repository.QuizRepository;
import tech.devinhouse.quiz.repository.model.Quiz;
import tech.devinhouse.quiz.repository.model.dto.QuizRequest;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public ResponseEntity<Object> getAll(){
        List<Quiz> quizzes =  this.quizRepository.findAll()
                .stream()
                .map(q-> q.add( linksHateoas(q.getId(),"GET", "get_quiz") ))
                .toList();

        if (quizzes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Nenhum Quiz Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(quizzes);
    }

    public ResponseEntity<Object> getById(Long id){

        Optional<Quiz> quiz = this.quizRepository.findById(id).stream()
                .map(q-> {
                    q.add( linksHateoas(q.getId(),"GET", "get_quiz") );
                    q.add( linksHateoas(q.getId(),"PUT", "update_quiz") );
                    q.add( linksHateoas(q.getId(),"DELETE", "delete_quiz") );
                    q.add( linksHateoasCollection() );
                    return  q;
                }).findFirst();

        //quiz.add( linkTo( methodOn(QuizController.class).getQuizById(quiz.get().getId())).withSelfRel());
        //quiz1.add( linkTo( methodOn(QuizController.class).getQuizById(quiz.get().getId())).withSelfRel());
        //quiz1.add( linkTo( methodOn(QuizController.class).getQuizById(quiz.get().getId())).withRel("GETQUIZ").withType("GET"));
        //quiz1.add( linkTo( methodOn(QuizController.class).getQuizById(quiz.get().getId())).withRel("GETQUIZ").withType("PUT"));
        //quiz1.add(linkTo(methodOn(QuizController.class).getAllQuiz()).withRel(IanaLinkRelations.COLLECTION));

        if (quiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(quiz);
    }

    public ResponseEntity<Object> saveQuiz(QuizRequest quizrRequest){

        Quiz quiz = QuizMapper.INSTANCE.reqToQuiz(quizrRequest);
        Quiz newQuiz = this.quizRepository.save(quiz);

        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);

    }

    public ResponseEntity<Object> updatePergunta(Long id, QuizRequest quizRequest) {

        Optional<Quiz> opQuiz = this.quizRepository.findById(id);

        if (opQuiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }


        Quiz quiz = QuizMapper.INSTANCE.reqToQuiz(quizRequest);
        quiz.setId(id);
        Quiz newQuiz = this.quizRepository.save(quiz);
        return ResponseEntity.status(HttpStatus.CREATED).body(newQuiz);
    }

    public ResponseEntity<Object> deleteQuiz(Long id){
        Optional<Quiz> quiz = this.quizRepository.findById(id);

        if (quiz.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum Quiz Cadastrado");
        }
        this.quizRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);


    }

    private Link linksHateoasCollection(){
        return  linkTo(methodOn(QuizController.class).getAllQuiz())
                .withRel(IanaLinkRelations.COLLECTION);
    }

    private Link linksHateoas(Long id, String type, String rel){
        return  linkTo(methodOn(QuizController.class)
                .getQuizById(id))
                .withRel(rel)
                .withType(type);
    }


}
