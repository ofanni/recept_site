package hu.unideb.inf.recept_gyujtemeny.service.mapper;

import hu.unideb.inf.recept_gyujtemeny.data.entity.ReceptEntity;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-19T21:04:20+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ReceptMapperImpl implements ReceptMapper {

    @Override
    public ReceptDto receptEntityToDto(ReceptEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ReceptDto receptDto = new ReceptDto();

        receptDto.setId( entity.getId() );
        receptDto.setCim( entity.getCim() );
        receptDto.setAdag( entity.getAdag() );
        receptDto.setHozzavalok( entity.getHozzavalok() );
        receptDto.setLeiras( entity.getLeiras() );
        receptDto.setFeltoltesDatum( entity.getFeltoltesDatum() );

        return receptDto;
    }

    @Override
    public List<ReceptDto> receptEntityListToDtoList(List<ReceptEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ReceptDto> list = new ArrayList<ReceptDto>( entities.size() );
        for ( ReceptEntity receptEntity : entities ) {
            list.add( receptEntityToDto( receptEntity ) );
        }

        return list;
    }

    @Override
    public ReceptEntity receptDtoToEntity(ReceptDto dto) {
        if ( dto == null ) {
            return null;
        }

        ReceptEntity receptEntity = new ReceptEntity();

        if ( dto.getId() != null ) {
            receptEntity.setId( dto.getId() );
        }
        receptEntity.setCim( dto.getCim() );
        receptEntity.setAdag( dto.getAdag() );
        receptEntity.setHozzavalok( dto.getHozzavalok() );
        receptEntity.setLeiras( dto.getLeiras() );
        receptEntity.setFeltoltesDatum( dto.getFeltoltesDatum() );

        return receptEntity;
    }

    @Override
    public List<ReceptEntity> receptDtoListToEntityList(List<ReceptDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<ReceptEntity> list = new ArrayList<ReceptEntity>( dtos.size() );
        for ( ReceptDto receptDto : dtos ) {
            list.add( receptDtoToEntity( receptDto ) );
        }

        return list;
    }
}
