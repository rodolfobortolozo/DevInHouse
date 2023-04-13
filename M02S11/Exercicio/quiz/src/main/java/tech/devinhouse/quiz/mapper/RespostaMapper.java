package tech.devinhouse.quiz.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import tech.devinhouse.quiz.repository.model.Resposta;
import tech.devinhouse.quiz.repository.model.dto.RespostaRequest;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RespostaMapper {

    RespostaMapper INSTANCE = Mappers.getMapper(RespostaMapper.class);

    Resposta reqToResposta(RespostaRequest respostaRequest);
}
