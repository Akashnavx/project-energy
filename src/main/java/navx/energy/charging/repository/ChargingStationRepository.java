package navx.energy.charging.repository;

import navx.energy.charging.entity.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
public interface ChargingStationRepository extends JpaRepository<ChargingStation, String> {
    @Query(value = "SELECT * FROM charging_stations LIMIT 10", nativeQuery = true)
    List<ChargingStation> findNearbyStations(@Param("lat") Double lat, @Param("lng") Double lng);
}
