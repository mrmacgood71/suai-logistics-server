package it.macgood.logisticsdevserver.carriage;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.view.View;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/carriage")
public class CarriageController {

    private final CarriageService carriageService;

    // TODO: 12.10.2023 сделать
    @GetMapping
    @JsonView(View.GetShortCarriage.class)
    public ResponseEntity<List<Carriage>> getAll() {
        return ResponseEntity.ok(carriageService.findAll());
    }
    @GetMapping(value = "/{id}")
    @JsonView(View.GetShortCarriage.class)
    public ResponseEntity<Carriage> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(carriageService.findById(Long.parseLong(id)));
    }


}
