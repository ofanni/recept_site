package hu.unideb.inf.recept_gyujtemeny.service;

import hu.unideb.inf.recept_gyujtemeny.service.dto.ReceptDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

public interface ReceptManagementService {

    ReceptDto findById(Long id);
    List<ReceptDto> findAll();
    ReceptDto save(ReceptDto recept);
    void delete(Long id);

    List<ReceptDto> findByCim(String cim);
    List<ReceptDto> filterRecept(String cim,
                              Integer adag,
                              String hozzavalok,
                              String leiras,
                              Date feltoltesDatum);
}
