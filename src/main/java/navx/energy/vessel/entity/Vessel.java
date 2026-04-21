package navx.energy.vessel.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "vessels")
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String fleetId;
    private String pilotUserId;
    private Integer batteryPercentage;
    private String batteryHealth;
    private String boatState;
    private Boolean chargingIndicator;
    private Integer fuelMeterLevel;
    private Boolean maintenanceIndicator;
}