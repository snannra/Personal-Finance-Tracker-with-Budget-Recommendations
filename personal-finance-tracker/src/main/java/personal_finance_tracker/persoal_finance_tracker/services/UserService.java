package personal_finance_tracker.persoal_finance_tracker.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import personal_finance_tracker.persoal_finance_tracker.dto.UserRegistrationDTO;
import personal_finance_tracker.persoal_finance_tracker.entities.User;
import personal_finance_tracker.persoal_finance_tracker.repositories.UserRepository;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Method to register a new user
    public User registerNewUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Hash the password

        return userRepository.save(user);
    }

    // Method to authenticate user based on username and password
    public boolean authenticate(String username, String password) {
        // Find user by username
        logger.info("Authenticating user: {}", username);
        Optional<User> optionalUser = userRepository.findByUsername(username);

        // Check if the user exists and the password matches
        if (optionalUser.isPresent()) {
            User user = optionalUser.get(); // Get the User object from Optional
            if (passwordEncoder.matches(password, user.getPassword())) {
                return true; // If password matches
            }
        }
        return false; // If user does not exist or password does not match
    }
}
