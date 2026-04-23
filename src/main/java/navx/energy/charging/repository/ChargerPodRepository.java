package navx.energy.charging.repository;

import navx.energy.charging.entity.ChargerPod;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ChargerPodRepository extends JpaRepository<ChargerPod, String> {
    List<ChargerPod> findByStationId(String stationId);
}
