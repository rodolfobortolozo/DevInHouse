package tech.devinhouse.quiz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import tech.devinhouse.quiz.repository.model.Pergunta;
import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;

@Mapper
public interface PerguntaMapper {

    PerguntaMapper INSTANCE = Mappers.getMapper(PerguntaMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "quiz", ignore = true)
    @Mapping(target = "perguntas", ignore = true)
    Pergunta resToPergunta(PerguntaRequest perguntaRequest);
}
