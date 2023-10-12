package it.macgood.logisticsdevserver.geolocation;

import it.macgood.logisticsdevserver.carriage.model.ResponseCarriage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeolocationService {

    public GeolocationResponse getInformation(ResponseCarriage carriage, Geolocation current) {
        return GeolocationResponse.builder()
                .departureTownId(carriage.getDepartureTownId())
                .departureTownName(carriage.getDepartureTownName())
                .departureTownLatitude(carriage.getDepartureTownLatitude())
                .departureTownLongitude(carriage.getDepartureTownLongitude())
                .destinationTownId(carriage.getDestinationTownId())
                .destinationTownName(carriage.getDestinationTownName())
                .destinationTownLatitude(carriage.getDestinationTownLatitude())
                .destinationTownLongitude(carriage.getDestinationTownLongitude())
                .departureDate(carriage.getDepartureDate())
                .departureTime(carriage.getDepartureTime())
                .expectedDestinationDate(carriage.getExpectedDestinationDate())
                .expectedDestinationTime(carriage.getExpectedDestinationTime())
                .cargoType(carriage.getCargoType())
                .status(carriage.getStatus())
                .actualDestinationTime(carriage.getActualDestinationTime())
                .vehicleId(carriage.getVehicleId())
                .companyId(carriage.getCompanyId())
                .companyName(carriage.getCompanyName())
                .mapUrl("https://www.google.com/maps/dir/"
                        + carriage.getDepartureTownLatitude()
                        + ","
                        + carriage.getDepartureTownLongitude()
                        + "/"
                        + carriage.getDestinationTownName()
                )
                .build();
    }

}
