package it.macgood.logisticsdevserver.carriage.model;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.view.View;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCarriage {
    @JsonView(View.GetShortCarriage.class)
    private Long id;
    @JsonView(View.GetShortCarriage.class)
    private String departureTownId;
    @JsonView(View.GetShortCarriage.class)
    private String departureTownName;
    @JsonView(View.GetShortCarriage.class)
    private Double departureTownLatitude;
    @JsonView(View.GetShortCarriage.class)
    private Double departureTownLongitude;
    @JsonView(View.GetShortCarriage.class)
    private String destinationTownId;
    @JsonView(View.GetShortCarriage.class)
    private String destinationTownName;
    @JsonView(View.GetShortCarriage.class)
    private Double destinationTownLatitude;
    @JsonView(View.GetShortCarriage.class)
    private Double destinationTownLongitude;
    @JsonView(View.GetShortCarriage.class)
    private String departureDate;
    @JsonView(View.GetShortCarriage.class)
    private String departureTime;
    @JsonView(View.GetShortCarriage.class)
    private String expectedDestinationDate;
    @JsonView(View.GetShortCarriage.class)
    private String expectedDestinationTime;
    @JsonView(View.GetShortCarriage.class)
    private String cargoType;
    @JsonView(View.GetShortCarriage.class)
    private String status;
    @JsonView(View.GetShortCarriage.class)
    private String actualDestinationTime;
    @JsonView(View.GetShortCarriage.class)
    private String vehicleId;
    @JsonView(View.GetShortCarriage.class)
    private Long driverId;
    @JsonView(View.GetShortCarriage.class)
    private String driverFirstname;
    @JsonView(View.GetShortCarriage.class)
    private String driverLastname;
    @JsonView(View.GetShortCarriage.class)
    private String companyId;
    @JsonView(View.GetShortCarriage.class)
    private String companyName;
}
