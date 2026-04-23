package navx.energy.charging.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Data
@Entity
@Table(name = "charging_sessions")
public class ChargingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String vesselId;
    private String chargerPodId;

    private String state; // "CHARGING", "PLUGGED_IN", "PAYMENT_PENDING", "COMPLETED"
    private Integer stateOfChargePercentage;
    private Integer timeToFullMinutes;
    private Double energyConsumed;
    private Long sessionCostPaise;

    private Instant startedAt;
    private Instant completedAt;
}
