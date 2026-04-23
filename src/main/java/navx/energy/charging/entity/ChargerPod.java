package navx.energy.charging.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "charger_pods")
public class ChargerPod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String stationId;
    private String name;
    private String type;
    private String status;
}