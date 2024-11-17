package hu.unideb.inf.recept_gyujtemeny.data.repository;

import hu.unideb.inf.recept_gyujtemeny.data.entity.ReceptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceptRepository extends JpaRepository<ReceptEntity, Long> {
    List<ReceptEntity> findAllByCimContains(String cim);

}