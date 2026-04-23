package navx.energy.charging.controller;

import navx.energy.charging.service.ChargingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/charging")
public class ChargingController {

    private final ChargingService chargingService;

    public ChargingController(ChargingService chargingService) {
        this.chargingService = chargingService;
    }

    @GetMapping("/sessions/active")
    public ResponseEntity<?> getActiveSessions() {
        return ResponseEntity.ok(Map.of("status", "success", "data", Map.of(
                "activeSessions", chargingService.getActiveChargingSessions()
        )));
    }

    @PostMapping("/sessions")
    public ResponseEntity<?> getSessionDetails(@RequestBody Map<String, String> request) {
        String sessionId = request.get("sessionId");
        return ResponseEntity.ok(Map.of("status", "success", "data", chargingService.getSessionDetails(sessionId)));
    }

    @GetMapping("/vessels/require-charging")
    public ResponseEntity<?> getLowBatteryVessels() {
        return ResponseEntity.ok(Map.of("status", "success", "data", Map.of(
                "vesselsRequiringCharging", chargingService.getVesselsRequiringCharging()
        )));
    }
}
