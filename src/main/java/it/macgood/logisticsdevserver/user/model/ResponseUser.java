package it.macgood.logisticsdevserver.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.macgood.logisticsdevserver.company.model.Company;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseUser {
    private Long id;

    private String firstname;
    private String lastname;
    private String role;
    private String companyId;
}
