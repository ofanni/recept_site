package hu.unideb.inf.recept_gyujtemeny.service.mapper;

import hu.unideb.inf.recept_gyujtemeny.data.entity.ReceptEntity;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceptMapper {

    @Mapping(source = "id", target = "id")
    ReceptDto receptEntityToDto(ReceptEntity entity);

    List<ReceptDto> receptEntityListToDtoList(List<ReceptEntity> entities);

    ReceptEntity receptDtoToEntity(ReceptDto dto);

    List<ReceptEntity> receptDtoListToEntityList(List<ReceptDto> dtos);
}
