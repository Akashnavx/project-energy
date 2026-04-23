package navx.energy.charging.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.Instant;

@Data
@Entity
@Table(name = "booking_slots")
public class BookingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String chargerPodId;
    private String vesselId;

    @Column(unique = true)
    private String idempotencyKey;

    private String state;

    private Instant startTime;
    private Instant endTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChargerPodId() {
        return chargerPodId;
    }

    public void setChargerPodId(String chargerPodId) {
        this.chargerPodId = chargerPodId;
    }

    public String getVesselId() {
        return vesselId;
    }

    public void setVesselId(String vesselId) {
        this.vesselId = vesselId;
    }

    public String getIdempotencyKey() {
        return idempotencyKey;
    }

    public void setIdempotencyKey(String idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Instant getStartTime() {
        return startTime;
    }

    public void setStartTime(Instant startTime) {
        this.startTime = startTime;
    }

    public Instant getEndTime() {
        return endTime;
    }

    public void setEndTime(Instant endTime) {
        this.endTime = endTime;
    }
}
