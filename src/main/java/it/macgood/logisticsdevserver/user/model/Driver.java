package it.macgood.logisticsdevserver.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.company.model.Company;
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
@Table(name = "Driver")
public class Driver {

    @Id
    @JsonView({View.GetDriver.class, View.GetShortCarriage.class})
    private Long id;
    @JsonView({View.GetDriver.class, View.GetShortCarriage.class})
    private String firstname;
    @JsonView({View.GetDriver.class, View.GetShortCarriage.class})
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    @JsonIgnore
    private Company company;

    @OneToOne(mappedBy = "driver")
    @JsonIgnore
    private Vehicle vehicle;

    @Override
    public String toString() {
        return "" + this.id;
    }
}
