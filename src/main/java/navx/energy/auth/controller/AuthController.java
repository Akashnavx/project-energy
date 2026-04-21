package navx.energy.auth.controller;

import navx.energy.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    // Inject the Service, NOT the repository!
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        Map<String, Object> payload = authService.processLogin(loginRequest);

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", payload,
                "message", "Authentication successful."
        ));
    }
}
