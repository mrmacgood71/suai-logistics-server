package it.macgood.logisticsdevserver.vehicle.controller;

import it.macgood.logisticsdevserver.vehicle.model.RequestVehicle;
import it.macgood.logisticsdevserver.vehicle.model.ResponseVehicle;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import it.macgood.logisticsdevserver.vehicle.service.VehicleService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
@RequestMapping("api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping
    public List<ResponseVehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PostMapping(value = "/linkDriver")
    public void linkVehicleToDriver(
            @RequestParam("driverId") String driverId,
            @RequestParam("vehicleId") String vehicleId
    ) {
        vehicleService.linkVehicleToDriver(driverId, vehicleId);
    }


    @GetMapping(value = "/byCompany/{companyId}")
    public List<Vehicle> getVehiclesByCompanyId(
            @PathVariable String companyId
    ) {
        return vehicleService.getByCompanyId(companyId);
    }

    @GetMapping(value = "/byTransportNumber/{transportNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> getByTransportNumber(
            @PathVariable String transportNumber
    ) {
        try {
            var vehicle = vehicleService.getByTransportNumber(transportNumber);
            return ResponseEntity.ok(vehicle);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping(value = "/byDriver/{driverId}")
    public ResponseEntity<Vehicle> getByDriverId(
            @PathVariable String driverId
    ) {
        try {
            var vehicle = vehicleService.getByDriverId(Long.parseLong(driverId));
            return ResponseEntity.ok(vehicle);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> addVehicle(
            @RequestBody RequestVehicle vehicle
    ) {
        return ResponseEntity.ok(vehicleService.save(vehicle));
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteVehicle(
            @PathVariable String id
    ) {
        try {
            Boolean isDeleted = vehicleService.deleteVehicle(id);
            return ResponseEntity.ok(isDeleted);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(false);
        }
    }

}
