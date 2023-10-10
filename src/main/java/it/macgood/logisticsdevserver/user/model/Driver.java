package it.macgood.logisticsdevserver.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.macgood.logisticsdevserver.company.model.Company;
import it.macgood.logisticsdevserver.vehicle.model.Vehicle;
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
@Table(name = "Driver")
public class Driver {

    @Id
    private Long id;

    private String firstname;
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @OneToOne(mappedBy = "driver")
    @JsonIgnore
    private Vehicle vehicle;
}
