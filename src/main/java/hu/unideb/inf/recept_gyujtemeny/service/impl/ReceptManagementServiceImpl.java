package hu.unideb.inf.recept_gyujtemeny.service.impl;

import hu.unideb.inf.recept_gyujtemeny.data.entity.ReceptEntity;
import hu.unideb.inf.recept_gyujtemeny.data.repository.ReceptRepository;
import hu.unideb.inf.recept_gyujtemeny.service.ReceptManagementService;
import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import hu.unideb.inf.recept_gyujtemeny.service.mapper.ReceptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceptManagementServiceImpl implements ReceptManagementService {

    @Autowired
    private ReceptRepository repo;

    @Autowired
    private ReceptMapper mapper;

    @Override
    public ReceptDto findById(Long id) {
        ReceptEntity entity = repo.getReferenceById(id);
        return mapper.receptEntityToDto(entity);  // MapStruct konverzió
    }

    @Override
    public List<ReceptDto> findAll() {
        List<ReceptEntity> entities = repo.findAll();
        return mapper.receptEntityListToDtoList(entities);  // MapStruct konverzió
    }

    @Override
    public ReceptDto save(ReceptDto receptDto) {
        ReceptEntity entity = mapper.receptDtoToEntity(receptDto);  // MapStruct konverzió
        entity = repo.save(entity);
        return mapper.receptEntityToDto(entity);  // MapStruct konverzió
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    // Szűrés cím alapján
    @Override
    public List<ReceptDto> findByCim(String cim) {
        List<ReceptEntity> entities = repo.findAllByCimContains(cim);
        return mapper.receptEntityListToDtoList(entities);  // MapStruct konverzió
    }
    @Override
    public List<ReceptDto> filterRecept(String cim, Integer adag, String hozzavalok, String leiras, Date feltoltesDatum) {
        List<ReceptEntity> szurt = repo.findAll()
                .stream()
                .filter(x -> cim == null || x.getCim().contains(cim))  // Cím alapján szűrés
                .filter(x -> adag == null || x.getAdag().equals(adag))  // Adag alapján szűrés
                .filter(x -> hozzavalok == null || x.getHozzavalok().contains(hozzavalok))  // Hozzávalók alapján szűrés
                .filter(x -> leiras == null || x.getLeiras().contains(leiras))  // Leírás alapján szűrés
                .filter(x -> feltoltesDatum == null || x.getFeltoltesDatum().after(feltoltesDatum))  // Feltöltés dátuma alapján szűrés
                .collect(Collectors.toList());

        return mapper.receptEntityListToDtoList(szurt);  // MapStruct konverzió és a szűrt lista visszaadása
    }
}


