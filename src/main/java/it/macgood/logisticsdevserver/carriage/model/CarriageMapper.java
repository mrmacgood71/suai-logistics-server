package it.macgood.logisticsdevserver.carriage.model;

import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.geolocation.Town;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;

import java.net.ResponseCache;

public class CarriageMapper {
    public static Carriage RequestCarriageToCarriage(
            RequestCarriage request,
            Town departureTown,
            Town destinationTown,
            Company company,
            Vehicle vehicle
    ) {
        return Carriage.builder()
                .destinationTown(destinationTown)
                .departureTown(departureTown)
                .departureDate(request.getDepartureDate())
                .departureTime(request.getDepartureTime())
                .expectedDestinationDate(request.getExpectedDestinationDate())
                .expectedDestinationTime(request.getExpectedDestinationTime())
                .cargoType(request.getCargoType())
                .status(request.getStatus())
                .company(company)
                .actualDestinationTime(request.getActualDestinationTime())
                .vehicle(vehicle)
                .build();
    }


    public static ResponseCarriage CarriageToResponseCarriage(Carriage saved) {
        return ResponseCarriage.builder()
                .id(saved.getId())
                .departureTownId(saved.getDepartureTown().getPlaceId())
                .departureTownName(saved.getDepartureTown().getCity() + ", " + saved.getDepartureTown().getRegionName())
                .departureTownLatitude(saved.getDepartureTown().getLat())
                .departureTownLongitude(saved.getDepartureTown().getLon())
                .destinationTownId(saved.getDestinationTown().getPlaceId())
                .destinationTownName(saved.getDestinationTown().getCity() + ", " + saved.getDestinationTown().getRegionName())
                .destinationTownLatitude(saved.getDestinationTown().getLat())
                .destinationTownLongitude(saved.getDestinationTown().getLon())
                .departureDate(saved.getDepartureDate())
                .departureTime(saved.getDepartureTime())
                .expectedDestinationDate(saved.getExpectedDestinationDate())
                .expectedDestinationTime(saved.getExpectedDestinationTime())
                .cargoType(saved.getCargoType())
                .status(saved.getStatus())
                .actualDestinationTime(saved.getActualDestinationTime())
                .vehicleId(saved.getVehicle().getTransportNumber())
                .driverId(saved.getVehicle().getDriver().getId())
                .driverFirstname(saved.getVehicle().getDriver().getFirstname())
                .driverLastname(saved.getVehicle().getDriver().getLastname())
                .companyId(saved.getCompany().getId())
                .companyName(saved.getCompany().getName())
                .build();
    }
}
