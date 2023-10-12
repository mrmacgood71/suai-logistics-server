package it.macgood.logisticsdevserver.geolocation;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.view.View;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "towns")
public class Town {

        @Id
        @JsonView(View.GetShortCarriage.class)
        private String placeId;
        @JsonView(View.GetShortCarriage.class)
        private String city;
        private Long population;
        @JsonView(View.GetShortCarriage.class)
        private Double lat;
        @JsonView(View.GetShortCarriage.class)
        private Double lon;
        private String regionName;
        private String regionNameAo;
        private String regionIsoCode;
        private String federalDistrict;
        private Double okato;
        private Double oktmo;
        private Double kladrId;
        private String fiasId;
}