package it.macgood.logisticsdevserver.geolocation;

import it.macgood.logisticsdevserver.carriage.CarriageService;
import it.macgood.logisticsdevserver.carriage.model.ResponseCarriage;
import it.macgood.logisticsdevserver.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "api/v1/geo")
public class GeolocationController {

    private final CarriageService carriageService;
    private final GeolocationService geolocationService;

    @GetMapping(value = "/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public GeolocationResponse getGeolocationInfoForDriver(
            @RequestParam(required = false) String driverId,
            @RequestBody Geolocation current
    ) {
        ResponseCarriage carriage = carriageService.findByDriver(Long.parseLong(driverId));
        return geolocationService.getInformation(carriage, current);

    }
}