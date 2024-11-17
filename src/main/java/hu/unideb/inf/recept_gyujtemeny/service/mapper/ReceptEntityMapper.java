package hu.unideb.inf.recept_gyujtemeny.service.mapper;

import hu.unideb.inf.recept_gyujtemeny.data.entity.ReceptEntity;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import org.mapstruct.*;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReceptEntityMapper {

    ReceptEntity toEntity(ReceptDto receptDto);

    ReceptDto toDto(ReceptEntity receptEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ReceptEntity partialUpdate(ReceptDto receptDto, @MappingTarget ReceptEntity receptEntity);
}
