package personal_finance_tracker.persoal_finance_tracker.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import personal_finance_tracker.persoal_finance_tracker.dto.UserRegistrationDTO;
import personal_finance_tracker.persoal_finance_tracker.entities.User;
import personal_finance_tracker.persoal_finance_tracker.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerNewUser(UserRegistrationDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        return userRepository.save(user);
    }
}
