package it.macgood.logisticsdevserver.vehicle.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.carriage.Carriage;
import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.user.model.Driver;
import it.macgood.logisticsdevserver.view.View;
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
    @JsonView(View.GetShortCarriage.class)
    private String transportNumber;
    @JsonView(View.GetShortCarriage.class)
    private String mark;
    @JsonView(View.GetShortCarriage.class)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Company company;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    @JsonView(View.GetShortCarriage.class)
    private Driver driver;

    @OneToOne
    @JoinColumn(name = "carriage_id", referencedColumnName = "id")
    @JsonIgnore
    private Carriage carriage;
}
