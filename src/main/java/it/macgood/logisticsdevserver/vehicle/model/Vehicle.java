package it.macgood.logisticsdevserver.vehicle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.user.model.Driver;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    private String transportNumber;
    private String mark;
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Company company;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    private Driver driver;
}
