package navx.energy.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.Instant;


public class ApiErrorResponse {
    private String status;      // e.g., "error" or "failed"
    private String message;     // e.g., "Vessel not found in the database."
    private String errorCode;   // e.g., "404_NOT_FOUND"
    private Instant timestamp;

    public ApiErrorResponse(String status, String message, String errorCode, Instant timestamp) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
