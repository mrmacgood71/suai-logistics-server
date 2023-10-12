package it.macgood.logisticsdevserver.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.company.model.Company;
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
@Entity(name = "manager")
@Table(name = "manager")
public class Manager {
    @Id
    @JsonView(View.GetDriver.class)
    private Long id;
    @JsonView(View.GetDriver.class)
    private String firstname;
    @JsonView(View.GetDriver.class)
    private String lastname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="company_id")
    private Company company;

}

