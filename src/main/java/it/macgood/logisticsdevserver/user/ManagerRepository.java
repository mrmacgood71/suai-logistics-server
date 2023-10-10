package it.macgood.logisticsdevserver.user;

import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.user.model.Manager;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Modifying
    @Transactional
    @Query(value = "update manager set company_id = :companyId where id = :managerId", nativeQuery = true)
    void updateCompany(String companyId, Long managerId);

}
