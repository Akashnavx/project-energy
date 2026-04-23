package navx.energy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 1. Catch when the database can't find something (e.g., Vessel ID is wrong)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ApiErrorResponse error = new ApiErrorResponse(
                "error",
                ex.getMessage(),
                "404_NOT_FOUND",
                Instant.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND); // Returns HTTP 404
    }

    // 2. Catch Business Logic failures (e.g., trying to book an already occupied charger)
    @ExceptionHandler(InvalidBookingException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidBooking(InvalidBookingException ex) {
        ApiErrorResponse error = new ApiErrorResponse(
                "error",
                ex.getMessage(),
                "400_BAD_REQUEST",
                Instant.now()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); // Returns HTTP 400
    }

    // 3. The Ultimate Safety Net: Catch literally anything else (like NullPointerExceptions)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGenericException(Exception ex) {
        // You would normally log the actual crash here using slf4j: log.error("Server Crash: ", ex);

        ApiErrorResponse error = new ApiErrorResponse(
                "error",
                "An unexpected server error occurred. Please try again later.", // Hide the real crash from hackers
                "500_INTERNAL_SERVER_ERROR",
                Instant.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR); // Returns HTTP 500
    }
}
