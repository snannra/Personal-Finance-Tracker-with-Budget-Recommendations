package personal_finance_tracker.persoal_finance_tracker.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
}
