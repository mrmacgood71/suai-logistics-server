package it.macgood.logisticsdevserver.user;

import it.macgood.logisticsdevserver.user.model.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final DriverRepository driverRepository;
    private final ManagerRepository managerRepository;

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

    public Driver saveRequestedDriver(RequestDriver driver) {
        return driverRepository.save(Driver.builder()
                .id(driver.getId())
                .firstname(driver.getFirstname())
                .lastname(driver.getLastname())
                .build());
    }

//    public Driver saveDriver(Driver driver)

}
