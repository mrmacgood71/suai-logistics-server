package it.macgood.logisticsdevserver.user.model;

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
