package it.macgood.logisticsdevserver.company;

import it.macgood.logisticsdevserver.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    Optional<Company> findById(String id);
}
