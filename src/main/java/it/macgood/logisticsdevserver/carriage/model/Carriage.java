package it.macgood.logisticsdevserver.carriage.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.geolocation.Town;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import it.macgood.logisticsdevserver.view.View;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.GetShortCarriage.class)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "departure_town", referencedColumnName = "placeId")
    @JsonView(View.GetShortCarriage.class)
    private Town departureTown;

    @ManyToOne
    @JoinColumn(name = "destination_town", referencedColumnName = "placeId")
    @JsonView(View.GetShortCarriage.class)
    private Town destinationTown;

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

    @ManyToOne
    @JsonView(View.GetShortCarriage.class)
    private Company company;

    @OneToOne
    @JsonView(View.GetShortCarriage.class)
    private Vehicle vehicle;
}
