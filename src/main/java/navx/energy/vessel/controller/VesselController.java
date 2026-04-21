package navx.energy.vessel.controller;

import navx.energy.vessel.service.VesselService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vessels")
public class VesselController {

    private final VesselService vesselService;

    // Injecting the Service, keeping database repositories totally hidden from the internet!
    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @GetMapping("/mine")
    public ResponseEntity<?> getMyVessels() {
        List<Map<String, Object>> myBoats = vesselService.getVesselsForAssignedPilot();
        return ResponseEntity.ok(Map.of("status", "success", "data", Map.of("vessels", myBoats)));
    }

    @GetMapping("/fleetList")
    public ResponseEntity<?> getFleetList() {
        Map<String, Object> fleetData = vesselService.getOverallFleetSummary();
        return ResponseEntity.ok(Map.of("status", "success", "data", fleetData));
    }

    @GetMapping("/fleet/{vesselId}")
    public ResponseEntity<?> getParticularBoat(@PathVariable String vesselId) {
        Map<String, Object> boatData = vesselService.getParticularBoatDetails(vesselId);
        return ResponseEntity.ok(Map.of("status", "success", "data", boatData));
    }
}
