package it.macgood.logisticsdevserver.company.model;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.user.model.Driver;
import it.macgood.logisticsdevserver.user.model.Manager;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
import it.macgood.logisticsdevserver.view.View;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(View.GetShortCarriage.class)
    private String id;
    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Driver> drivers = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Manager> managers = new ArrayList<>();
}
