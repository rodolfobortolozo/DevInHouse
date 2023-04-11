package tech.devinhouse.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.devinhouse.locadora.model.Categoria;
import tech.devinhouse.locadora.model.request.CategoriaRequest;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    CategoriaMapper INSTANCE = Mappers.getMapper(CategoriaMapper.class);

    Categoria reqToCategoria(CategoriaRequest categoriaRequest);
}
