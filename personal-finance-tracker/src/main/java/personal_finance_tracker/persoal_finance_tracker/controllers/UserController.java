package personal_finance_tracker.persoal_finance_tracker.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import personal_finance_tracker.persoal_finance_tracker.dto.LoginRequestDTO;
import personal_finance_tracker.persoal_finance_tracker.dto.UserRegistrationDTO;
import personal_finance_tracker.persoal_finance_tracker.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userDTO) {
        userService.registerNewUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody LoginRequestDTO loginRequest) {
        boolean isAuthenticated = userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
        Map<String, String> response = new HashMap<>();

        if (isAuthenticated) {
            response.put("message", "Login successful");
            return ResponseEntity.ok(response); // Returning JSON
        } else {
            response.put("error", "Invalid username or password");
            return ResponseEntity.status(401).body(response); // Returning JSON
        }
    }

}
