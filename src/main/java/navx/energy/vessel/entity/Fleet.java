package navx.energy.vessel.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "fleets")
public class Fleet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String managerUserId;
    @OneToMany(mappedBy = "fleetId", cascade = CascadeType.ALL)
    private List<Vessel> vessels;
}