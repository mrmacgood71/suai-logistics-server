package it.macgood.logisticsdevserver.carriage;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.geolocation.Town;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import it.macgood.logisticsdevserver.view.View;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(View.GetShortCarriage.class)
    private Long id;

    @OneToOne
    @JoinColumn(name = "departure_town", referencedColumnName = "placeId")
    @JsonView(View.GetShortCarriage.class)
    private Town departureTown;

    @OneToOne
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

    @OneToOne
    @JsonView(View.GetShortCarriage.class)
    private Vehicle vehicle;

}
