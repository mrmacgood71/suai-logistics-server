package it.macgood.logisticsdevserver.invite;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/invite")
public class InvitationController {

    private final InvitationService invitationService;

    @GetMapping(value = "/{managerId}/getCode", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InvitationResponse> getCode(
            @PathVariable String managerId
    ) {
        try {
            String invitationCode = invitationService.getInvitationCode(Long.parseLong(managerId));
            return ResponseEntity.ok(InvitationResponse.builder().code(invitationCode).build());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // TODO: 12.10.2023 сделать
    @PostMapping("/accept")
    public void acceptDriver(
            @RequestParam String userId,
            @RequestParam String key
    ) {

    }
}
