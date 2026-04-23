package navx.energy.charging.repository;

import navx.energy.charging.entity.ChargingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChargingSessionRepository extends JpaRepository<ChargingSession, String> {
    List<ChargingSession> findByState(String state);
}
