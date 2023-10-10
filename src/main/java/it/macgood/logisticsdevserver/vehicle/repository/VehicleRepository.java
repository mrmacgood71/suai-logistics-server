package it.macgood.logisticsdevserver.vehicle.repository;

import it.macgood.logisticsdevserver.user.model.Driver;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    List<Vehicle> findAll();

    Vehicle findByTransportNumber(String transportNumber);

    Optional<Vehicle> findByDriver(Driver driver);


}
