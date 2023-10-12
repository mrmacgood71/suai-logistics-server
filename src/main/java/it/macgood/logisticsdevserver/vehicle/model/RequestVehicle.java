package it.macgood.logisticsdevserver.vehicle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestVehicle {

    private String transportNumber;
    private String mark;
    private String model;
    private String company;
    private Long driverId;
}
