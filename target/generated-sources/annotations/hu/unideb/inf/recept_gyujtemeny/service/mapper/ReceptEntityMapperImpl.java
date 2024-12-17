package hu.unideb.inf.recept_gyujtemeny.service.mapper;

import hu.unideb.inf.recept_gyujtemeny.data.entity.ReceptEntity;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-17T20:23:04+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ReceptEntityMapperImpl implements ReceptEntityMapper {

    @Override
    public ReceptEntity toEntity(ReceptDto receptDto) {
        if ( receptDto == null ) {
            return null;
        }

        ReceptEntity receptEntity = new ReceptEntity();

        if ( receptDto.getId() != null ) {
            receptEntity.setId( receptDto.getId() );
        }
        receptEntity.setCim( receptDto.getCim() );
        receptEntity.setAdag( receptDto.getAdag() );
        receptEntity.setHozzavalok( receptDto.getHozzavalok() );
        receptEntity.setLeiras( receptDto.getLeiras() );
        receptEntity.setFeltoltesDatum( receptDto.getFeltoltesDatum() );

        return receptEntity;
    }

    @Override
    public ReceptDto toDto(ReceptEntity receptEntity) {
        if ( receptEntity == null ) {
            return null;
        }

        ReceptDto receptDto = new ReceptDto();

        receptDto.setId( receptEntity.getId() );
        receptDto.setCim( receptEntity.getCim() );
        receptDto.setAdag( receptEntity.getAdag() );
        receptDto.setHozzavalok( receptEntity.getHozzavalok() );
        receptDto.setLeiras( receptEntity.getLeiras() );
        receptDto.setFeltoltesDatum( receptEntity.getFeltoltesDatum() );

        return receptDto;
    }

    @Override
    public ReceptEntity partialUpdate(ReceptDto receptDto, ReceptEntity receptEntity) {
        if ( receptDto == null ) {
            return receptEntity;
        }

        if ( receptDto.getId() != null ) {
            receptEntity.setId( receptDto.getId() );
        }
        if ( receptDto.getCim() != null ) {
            receptEntity.setCim( receptDto.getCim() );
        }
        if ( receptDto.getAdag() != null ) {
            receptEntity.setAdag( receptDto.getAdag() );
        }
        if ( receptDto.getHozzavalok() != null ) {
            receptEntity.setHozzavalok( receptDto.getHozzavalok() );
        }
        if ( receptDto.getLeiras() != null ) {
            receptEntity.setLeiras( receptDto.getLeiras() );
        }
        if ( receptDto.getFeltoltesDatum() != null ) {
            receptEntity.setFeltoltesDatum( receptDto.getFeltoltesDatum() );
        }

        return receptEntity;
    }
}
