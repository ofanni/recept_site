package hu.unideb.inf.recept_gyujtemeny.data.repository;

import hu.unideb.inf.recept_gyujtemeny.data.entity.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FelhasznaloRepository extends JpaRepository<FelhasznaloEntity, Long> {
    FelhasznaloEntity findByFelhNev(String felhNev);

}