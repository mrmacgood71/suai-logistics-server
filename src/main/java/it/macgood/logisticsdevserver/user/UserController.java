package it.macgood.logisticsdevserver.user;

import com.fasterxml.jackson.annotation.JsonView;
import it.macgood.logisticsdevserver.user.model.*;
import it.macgood.logisticsdevserver.view.View;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{id}")
    private ResponseEntity<ResponseUser> getUser(
            @PathVariable String id
    ) {
        try {
            return ResponseEntity.ok(userService.getRoleByUserId(Long.parseLong(id)));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/addManager")
    public ResponseEntity<Manager> createManager(
            @RequestBody RequestManager manager
    ) {
        try {
            Manager saved = userService.saveManager(manager);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/addDriver")
    @JsonView(View.GetDriver.class)
    public ResponseEntity<Driver> createDriver(
            @RequestBody RequestDriver driver
    ) {
        try {
            Driver saved = userService.saveRequestedDriver(driver);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/editDriver/{id}")
    public ResponseEntity<Driver> editDriver(
            @PathVariable String id,
            @RequestBody RequestDriver driver
    ) {
        try {
            Driver saved = userService.upsertDriver(driver);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("deleteDriver/{id}")
    public ResponseEntity<Driver> deleteDriver(
            @PathVariable String id
    ) {
        try {
            Driver saved = userService.deleteDriver(Long.parseLong(id));
            if (saved.getFirstname().isEmpty()) {
                return ResponseEntity
                        .internalServerError()
                        .body(Driver.builder()
                                .firstname("Этот водитель сейчас в поездке")
                                .lastname("Удалить его невозможно")
                                .build()
                        );
            }
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(Driver.builder()
                            .firstname("Этот водитель сейчас в поездке")
                            .lastname("Удалить его невозможно")
                            .build()
                    );
        }
    }

    @DeleteMapping("/quitByManager/{id}")
    public ResponseEntity<Boolean> quitFromCompanyByManager(
            @PathVariable String id
    ) {
        userService.deleteCompany(Long.parseLong(id));
        return ResponseEntity.ok(true);
    }

}
