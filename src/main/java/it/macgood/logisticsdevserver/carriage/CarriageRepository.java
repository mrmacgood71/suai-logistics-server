package it.macgood.logisticsdevserver.carriage;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarriageRepository extends JpaRepository<Carriage, Long> {
    List<Carriage> findAll();

    Optional<Carriage> findById(Long id);



}
