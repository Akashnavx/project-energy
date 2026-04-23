package navx.energy.charging.service;

import navx.energy.charging.entity.BookingSlot;
import navx.energy.charging.entity.ChargerPod;
import navx.energy.charging.entity.ChargingStation;
import navx.energy.charging.repository.BookingSlotRepository;
import navx.energy.charging.repository.ChargerPodRepository;
import navx.energy.charging.repository.ChargingStationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final ChargingStationRepository stationRepo;
    private final ChargerPodRepository podRepo;
    private final BookingSlotRepository slotRepo;

    public BookingService(ChargingStationRepository stationRepo, ChargerPodRepository podRepo, BookingSlotRepository slotRepo) {
        this.stationRepo = stationRepo;
        this.podRepo = podRepo;
        this.slotRepo = slotRepo;
    }

    public List<ChargingStation> findNearbyStations(Double lat, Double lng, Double radiusKm) {
        return stationRepo.findNearbyStations(lat, lng);
    }

    public List<ChargerPod> getChargersForStation(String stationId) {
        return podRepo.findByStationId(stationId);
    }

    public List<BookingSlot> getAvailableSlots(String chargerId) {
        return slotRepo.findByChargerPodId(chargerId);
    }

    public BookingSlot createBookingSafely(String chargerId, String vesselId, String idempotencyKey) {
        Optional<BookingSlot> existingBooking = slotRepo.findByIdempotencyKey(idempotencyKey);
        if (existingBooking.isPresent()) {
            return existingBooking.get();
        }

        BookingSlot newSlot = new BookingSlot();
        newSlot.setChargerPodId(chargerId);
        newSlot.setVesselId(vesselId);
        newSlot.setIdempotencyKey(idempotencyKey);
        newSlot.setState("BOOKED");
        newSlot.setStartTime(Instant.now());
        newSlot.setEndTime(Instant.now().plusSeconds(3600));

        return slotRepo.save(newSlot);
    }
}
