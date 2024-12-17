package hu.unideb.inf.recept_gyujtemeny.data.repository;

import hu.unideb.inf.recept_gyujtemeny.data.entity.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosultsagRepository extends JpaRepository<JogosultsagEntity, Long> {
    JogosultsagEntity findByNev(String nev);


}