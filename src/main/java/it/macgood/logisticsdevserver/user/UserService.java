package it.macgood.logisticsdevserver.user;

import it.macgood.logisticsdevserver.carriage.CarriageRepository;
import it.macgood.logisticsdevserver.carriage.CarriageService;
import it.macgood.logisticsdevserver.carriage.model.Carriage;
import it.macgood.logisticsdevserver.company.CompanyRepository;
import it.macgood.logisticsdevserver.user.model.*;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import it.macgood.logisticsdevserver.vehicle.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final ManagerRepository managerRepository;
    private final CompanyRepository companyRepository;
    private final CarriageRepository carriageRepository;

    public ResponseUser getRoleByUserId(Long id) {

        Optional<Driver> driverOptional = driverRepository.findById(id);

        if (!driverOptional.isEmpty()) {
            Driver driver = driverOptional.get();

            return ResponseUser.builder()
                    .id(driver.getId())
                    .role("Driver")
                    .companyId(driver.getCompany().getId())
                    .firstname(driver.getFirstname())
                    .lastname(driver.getLastname())
                    .build();
        }

        Optional<Manager> managerOptional = managerRepository.findById(id);
        if (!managerOptional.isEmpty()) {
            Manager manager = managerOptional.get();

            return ResponseUser.builder()
                    .id(manager.getId())
                    .role("Manager")
                    .companyId(manager.getCompany().getId())
                    .firstname(manager.getFirstname())
                    .lastname(manager.getLastname())
                    .build();
        }

        return ResponseUser.builder().role("Empty").build();
    }

    public Manager saveManager(RequestManager manager) {
        return managerRepository.save(Manager.builder()
                .id(manager.getId())
                .firstname(manager.getFirstname())
                .lastname(manager.getLastname())
                .build()
        );
    }

    public void deleteCompany(Long id) {
        Manager manager = managerRepository.findById(id).get();
        manager.setCompany(null);
        managerRepository.save(manager);
    }

    public Driver saveRequestedDriver(RequestDriver driver) {
        return driverRepository.save(Driver.builder()
                .id(driver.getId())
                .firstname(driver.getFirstname())
                .lastname(driver.getLastname())
                .company(companyRepository.findById(driver.getCompanyId()).get())
                .build());
    }

    public Driver upsertDriver(RequestDriver driver) {
        return driverRepository.save(Driver.builder()
                .id(driver.getId())
                .firstname(driver.getFirstname())
                .lastname(driver.getLastname())
                .company(companyRepository.findById(driver.getCompanyId()).get())
                .build());
    }

    public Driver deleteDriver(Long id) {
        var deletedDriver = driverRepository.findById(id);
        try {
            Optional<Carriage> first = carriageRepository.findAll()
                    .stream()
                    .filter(carriage -> carriage.getVehicle().getDriver().getId().equals(id))
                    .findFirst();
            if (first.isEmpty()) {
                Optional<Vehicle> byDriver = vehicleRepository.findByDriver(deletedDriver.get());
                if (!byDriver.isEmpty()) {
                    byDriver.get().setDriver(null);
                    vehicleRepository.save(byDriver.get());
                }
                driverRepository.deleteById(id);
                return deletedDriver.orElseThrow();
            } else {
                return Driver.builder().build();
            }


        } catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

}
