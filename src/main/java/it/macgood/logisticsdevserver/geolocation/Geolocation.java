package it.macgood.logisticsdevserver.geolocation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Geolocation {

    private String latitude;

    private String longitude;
}
