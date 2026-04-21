package navx.energy.vessel.service;

import navx.energy.vessel.repository.FleetRepository;
import navx.energy.vessel.repository.VesselRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class VesselService {

    private final VesselRepository vesselRepository;
    private final FleetRepository fleetRepository;

    public VesselService(VesselRepository vesselRepository, FleetRepository fleetRepository) {
        this.vesselRepository = vesselRepository;
        this.fleetRepository = fleetRepository;
    }

    public List<Map<String, Object>> getVesselsForAssignedPilot() {
        // Logic: Extract Pilot ID, then call vesselRepository.findByPilotUserId(pilotId)
        return List.of(
                Map.of(
                        "vesselId", "vsl_001",
                        "name", "NavX Explorer",
                        "boatState", "SAILING",
                        "batteryPercentage", 78
                )
        );
    }

    public Map<String, Object> getOverallFleetSummary() {
        // Logic: Extract Manager ID, call fleetRepository, then vesselRepository
        return Map.of(
                "fleetId", "flt_123",
                "totalVessels", 3,
                "vessels", getVesselsForAssignedPilot() // Resuing the mock data
        );
    }

    public Map<String, Object> getParticularBoatDetails(String vesselId) {
        // Logic: vesselRepository.findById(vesselId)
        return Map.of(
                "vesselId", vesselId,
                "name", "Ocean Breeze",
                "boatState", "DOCKED"
        );
    }
}
