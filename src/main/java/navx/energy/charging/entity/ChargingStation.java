package navx.energy.charging.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "charging_stations")
public class ChargingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Double lat;
    private Double lng;

    @OneToMany(mappedBy = "stationId", cascade = CascadeType.ALL)
    private List<ChargerPod> chargerPods;
}
