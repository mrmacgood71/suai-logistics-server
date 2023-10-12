package it.macgood.logisticsdevserver.carriage;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.carriage.model.Carriage;
import it.macgood.logisticsdevserver.carriage.model.RequestCarriage;
import it.macgood.logisticsdevserver.carriage.model.ResponseCarriage;
import it.macgood.logisticsdevserver.view.View;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/carriage")
public class CarriageController {

    private final CarriageService carriageService;

    @GetMapping
    @JsonView(View.GetShortCarriage.class)
    public ResponseEntity<List<Carriage>> getAll() {
        return ResponseEntity.ok(carriageService.findAll());
    }

    @GetMapping(value = "/byCompany/{id}")
    @JsonView(View.GetShortCarriage.class)
    public ResponseEntity<List<ResponseCarriage>> getAllByCompany(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(carriageService.findAllByCompanyId(id));
    }

    @GetMapping(value = "/{id}")
    @JsonView(View.GetShortCarriage.class)
    public ResponseEntity<Carriage> getById(
            @PathVariable String id
    ) {
        return ResponseEntity.ok(carriageService.findById(Long.parseLong(id)));
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonView(View.GetShortCarriage.class)
    public ResponseEntity<ResponseCarriage> addCarriage(
            @RequestBody RequestCarriage requestCarriage
    ) {
        ResponseCarriage carriage = carriageService.saveCarriage(requestCarriage);

        return ResponseEntity.ok(carriage);
    }

    @PostMapping(value = "/undo/{id}")
    public ResponseEntity<String> changeStatus(@PathVariable String id) {
        try {
            carriageService.changeStatus(Long.parseLong(id));
            return ResponseEntity.ok("Отмена произошла успешно");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка");
        }
    }

    @GetMapping("/withStatus")
    public ResponseEntity<List<ResponseCarriage>> status(
            @RequestParam String type
    ) {
        try {
            List<ResponseCarriage> carriages = carriageService.findAllByStatus(type);
            return ResponseEntity.ok(carriages);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/byDriver/{id}")
    public ResponseEntity<ResponseCarriage> byDriver(
            @PathVariable String id
    ) {
        try {
            ResponseCarriage byDriver = carriageService.findByDriver(Long.parseLong(id));
            return ResponseEntity.ok(byDriver);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
