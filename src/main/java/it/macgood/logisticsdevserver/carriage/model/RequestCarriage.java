package it.macgood.logisticsdevserver.carriage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCarriage {
    private String departureTownId;
    private String destinationTownId;
    private String vehicleId;
    private String companyId;
    private String departureDate;
    private String departureTime;
    private String expectedDestinationDate;
    private String expectedDestinationTime;
    private String cargoType;
    private String status;
    private String actualDestinationTime;

}
