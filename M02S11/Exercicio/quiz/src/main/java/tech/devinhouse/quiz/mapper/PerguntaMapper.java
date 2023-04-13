package tech.devinhouse.quiz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import tech.devinhouse.quiz.repository.model.Pergunta;
import tech.devinhouse.quiz.repository.model.dto.PerguntaRequest;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PerguntaMapper {

    PerguntaMapper INSTANCE = Mappers.getMapper(PerguntaMapper.class);

    @Mapping(target = "quiz",ignore = true)
    Pergunta resToPergunta(PerguntaRequest perguntaRequest);
}
