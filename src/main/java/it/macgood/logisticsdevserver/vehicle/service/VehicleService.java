package it.macgood.logisticsdevserver.vehicle.service;

import it.macgood.logisticsdevserver.company.CompanyRepository;
import it.macgood.logisticsdevserver.company.model.ResponseCompany;
import it.macgood.logisticsdevserver.user.DriverRepository;
import it.macgood.logisticsdevserver.user.model.Driver;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import it.macgood.logisticsdevserver.vehicle.repository.VehicleRepository;
import it.macgood.logisticsdevserver.vehicle.model.RequestVehicle;
import it.macgood.logisticsdevserver.vehicle.model.ResponseVehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final CompanyRepository companyRepository;
    private final DriverRepository driverRepository;

    public List<ResponseVehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<ResponseVehicle> response = new ArrayList<>();
        for (var vehicle : vehicles) {
            response.add(ResponseVehicle.builder()
                            .model(vehicle.getModel())
                            .transportNumber(vehicle.getTransportNumber())
                            .mark(vehicle.getMark())
                            .company(new ResponseCompany(vehicle.getCompany().getId(), vehicle.getCompany().getName()))
                    .build());
            System.out.println(vehicle.getCompany().getId());
        }
        return response;
    }

    public Boolean save(RequestVehicle request) {
        try {
            Vehicle vehicle = Vehicle.builder()
                    .model(request.getModel())
                    .mark(request.getMark())
                    .transportNumber(request.getTransportNumber())
                    .driver(driverRepository.findById(request.getDriverId()).orElseThrow())
                    .company(companyRepository.findById(request.getCompany()).orElseThrow())
                    .build();
            vehicleRepository.save(vehicle);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Vehicle getByTransportNumber(String transportNumber) {
        return vehicleRepository.findByTransportNumber(transportNumber);
    }

    public void linkVehicleToDriver(String driverId, String vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
        vehicle.setDriver(driverRepository.findById(Long.parseLong(driverId)).orElseThrow());
        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getByCompanyId(String companyId) {
        List<Vehicle> all = vehicleRepository.findAll();
        return all.stream()
                .filter(vehicle -> vehicle.getCompany().getId().equals(companyId))
                .collect(Collectors.toList());
    }

    public Vehicle getByDriverId(Long driverId) {
        Optional<Driver> driver = driverRepository.findById(driverId);
        Optional<Vehicle> vehicle = vehicleRepository.findByDriver(driver.orElseThrow());

        return vehicle.orElseThrow();
    }

    public Boolean deleteVehicle(String id) {
        try {
            vehicleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
