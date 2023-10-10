package it.macgood.logisticsdevserver.user;

import it.macgood.logisticsdevserver.user.model.*;
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
            @PathVariable String id
    ) {

    }


}
