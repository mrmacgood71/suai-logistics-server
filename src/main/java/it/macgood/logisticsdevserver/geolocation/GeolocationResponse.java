package it.macgood.logisticsdevserver.geolocation;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.view.View;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeolocationResponse {

    private String departureTownId;
    private String departureTownName;
    private Double departureTownLatitude;
    private Double departureTownLongitude;
    private String destinationTownId;
    private String destinationTownName;
    private Double destinationTownLatitude;
    private Double destinationTownLongitude;
    private String departureDate;
    private String departureTime;
    private String expectedDestinationDate;
    private String expectedDestinationTime;
    private String cargoType;
    private String status;
    private String actualDestinationTime;
    private String vehicleId;
    private String companyId;
    private String companyName;
    private String mapUrl;

}
