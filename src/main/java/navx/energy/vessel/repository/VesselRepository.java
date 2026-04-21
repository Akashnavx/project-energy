package navx.energy.vessel.repository;

import navx.energy.vessel.entity.Vessel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface VesselRepository extends JpaRepository<Vessel, String> {
    List<Vessel> findByPilotUserId(String pilotUserId);
    List<Vessel> findByFleetId(String fleetId);
}