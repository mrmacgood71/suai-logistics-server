package it.macgood.logisticsdevserver.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDriver {
    private Long id;
    private String companyId;
    private String firstname;
    private String lastname;
}
