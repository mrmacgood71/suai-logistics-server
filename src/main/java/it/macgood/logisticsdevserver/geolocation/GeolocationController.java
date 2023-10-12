package it.macgood.logisticsdevserver.geolocation;

import it.macgood.logisticsdevserver.carriage.CarriageService;
import it.macgood.logisticsdevserver.carriage.model.ResponseCarriage;
import it.macgood.logisticsdevserver.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/geo")
public class GeolocationController {

    private final CarriageService carriageService;
    private final GeolocationService geolocationService;

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public GeolocationResponse getGeolocationInfoForDriver(
            @RequestParam String driverId,
            @RequestBody Geolocation current
    ) {
        ResponseCarriage carriage = carriageService.findByDriver(Long.parseLong(driverId));
        return geolocationService.getInformation(carriage, current);
    }

    @GetMapping(value = "accept", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> accept(
            @RequestParam String driverId
    ) {
        try {
            ResponseCarriage byDriver = carriageService.findByDriver(Long.parseLong(driverId));
            carriageService.changeStatus(byDriver.getId());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }

    }
}
