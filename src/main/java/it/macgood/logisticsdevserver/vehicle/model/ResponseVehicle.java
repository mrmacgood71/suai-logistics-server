package it.macgood.logisticsdevserver.vehicle.model;

import it.macgood.logisticsdevserver.company.model.ResponseCompany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseVehicle {
    private String transportNumber;
    private String mark;
    private String model;
    private ResponseCompany company;
}
