package it.macgood.logisticsdevserver.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestManager {
    private Long id;
    private String firstname;
    private String lastname;
}
