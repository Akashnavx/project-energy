package navx.energy.charging.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class ChargingService {

    public List<Map<String, Object>> getActiveChargingSessions() {
        // Logic: Fetch active sessions from database joining vessel names
        return List.of(
                Map.of(
                        "sessionId", "sess_889900",
                        "vesselId", "vsl_002",
                        "vesselName", "Ocean Breeze",
                        "chargerId", "chg_pod_04",
                        "state", "CHARGING",
                        "stateOfChargePercentage", 42
                )
        );
    }

    public Map<String, Object> getSessionDetails(String sessionId) {
        // Logic: sessionRepository.findById(sessionId)
        return Map.of(
                "sessionId", sessionId,
                "boatId", "vsl_002",
                "chargerName", "Pod 04 - Fast Charge",
                "stateOfChargePercentage", 42,
                "timeToFullMinutes", 45,
                "sessionCost", 150.00
        );
    }

    public List<Map<String, Object>> getVesselsRequiringCharging() {
        // Logic: vesselRepository.findByBatteryPercentageLessThan(20)
        return List.of(
                Map.of(
                        "vesselId", "vsl_005",
                        "name", "Wave Rider",
                        "batteryPercentage", 12,
                        "boatState", "DOCKED"
                )
        );
    }
}
