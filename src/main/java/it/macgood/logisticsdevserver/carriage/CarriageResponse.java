package it.macgood.logisticsdevserver.carriage;

import it.macgood.logisticsdevserver.geolocation.Town;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import jakarta.persistence.*;

public class CarriageResponse {

    private Long id;
    private Town departureTown;
    private Town destinationTown;
    private String departureDate;
    private String departureTime;
    private String expectedDestinationDate;
    private String expectedDestinationTime;
    private String cargoType;
    private String status;
    private String actualDestinationTime;
    private Vehicle vehicle;
}
