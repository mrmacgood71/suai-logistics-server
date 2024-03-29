package it.macgood.logisticsdevserver.user;

import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.user.model.Driver;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findAll();
    List<Driver> findByCompany(Company company);

    Optional<Driver> findByVehicle(Vehicle vehicle);

    Optional<Driver> findById(Long id);


}
