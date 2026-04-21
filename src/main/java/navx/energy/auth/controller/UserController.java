package navx.energy.auth.controller;

import navx.energy.auth.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/mine")
    public ResponseEntity<?> getMyProfile() {
        Map<String, Object> profileData = userService.getMyProfileDetails();

        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", profileData
        ));
    }
}
