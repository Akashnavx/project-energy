package navx.energy.charging.repository;

import navx.energy.charging.entity.BookingSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface BookingSlotRepository extends JpaRepository<BookingSlot, String> {
    List<BookingSlot> findByChargerPodId(String chargerPodId);
    Optional<BookingSlot> findByIdempotencyKey(String idempotencyKey);
}