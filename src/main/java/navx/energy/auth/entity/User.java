package navx.energy.auth.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Role role;
    @ElementCollection
    private List<String> featureEntitlements;
}
