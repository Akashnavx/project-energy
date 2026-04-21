package navx.energy.auth.service;

import navx.energy.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Business Logic: Fetch user and map it to the frontend JSON structure
    public Map<String, Object> getMyProfileDetails() {
        // In reality, get User ID from JWT here.
        // Example: Optional<User> user = userRepository.findById("usr_998877");

        return Map.of(
                "userProfile", Map.of(
                        "userId", "usr_998877",
                        "name", "Arjun Kumar",
                        "email", "arjun@fleet.com",
                        "phone", "+919876543210"
                ),
                "role", "PILOT",
                "featureEntitlements", List.of("VIEW_ASSIGNED_BOATS", "BOOK_CHARGING_SLOT")
        );
    }
}
