package navx.energy.vessel.repository;

import navx.energy.vessel.entity.Fleet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FleetRepository extends JpaRepository<Fleet, String> {
    // Allows us to find a Fleet assigned to a specific manager
    Optional<Fleet> findByManagerUserId(String managerUserId);
}
