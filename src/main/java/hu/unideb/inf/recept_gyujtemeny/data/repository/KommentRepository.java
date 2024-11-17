package hu.unideb.inf.recept_gyujtemeny.data.repository;

import hu.unideb.inf.recept_gyujtemeny.data.entity.KommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KommentRepository extends JpaRepository<KommentEntity, Long> {
}