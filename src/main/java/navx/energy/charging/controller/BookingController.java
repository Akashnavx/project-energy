package navx.energy.charging.controller;

import navx.energy.charging.entity.BookingSlot;
import navx.energy.charging.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/stations/nearby")
    public ResponseEntity<?> getNearbyStations(@RequestParam Double lat, @RequestParam Double lng, @RequestParam Double radius_km) {
        return ResponseEntity.ok(Map.of("status", "success", "data", Map.of(
                "stations", bookingService.findNearbyStations(lat, lng, radius_km)
        )));
    }

    @GetMapping("/stations/{stationId}/chargers")
    public ResponseEntity<?> getChargersInStation(@PathVariable String stationId) {
        return ResponseEntity.ok(Map.of("status", "success", "data", Map.of(
                "stationId", stationId,
                "chargers", bookingService.getChargersForStation(stationId)
        )));
    }

    @GetMapping("/chargers/{chargerId}/slots")
    public ResponseEntity<?> getAvailableSlots(@PathVariable String chargerId) {
        return ResponseEntity.ok(Map.of("status", "success", "data", Map.of(
                "chargerId", chargerId,
                "slots", bookingService.getAvailableSlots(chargerId)
        )));
    }

    @PostMapping("/slots/book")
    public ResponseEntity<?> bookSlot(@RequestBody Map<String, String> request) {
        BookingSlot savedSlot = bookingService.createBookingSafely(
                request.get("chargerId"),
                request.get("vesselId"),
                request.get("idempotencyKey")
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "status", "success",
                "message", "Charging slot booked.",
                "data", Map.of(
                        "reservationId", savedSlot.getId(),
                        "chargerId", savedSlot.getChargerPodId(),
                        "reservationState", savedSlot.getState()
                )
        ));
    }
}
