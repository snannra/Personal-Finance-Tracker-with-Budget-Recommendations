package personal_finance_tracker.persoal_finance_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}

/*
 * package personal_finance_tracker.persoal_finance_tracker.config;
 * 
 * import org.springframework.context.annotation.Bean;
 * import org.springframework.context.annotation.Configuration;
 * import org.springframework.security.config.Customizer;
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * import org.springframework.security.crypto.password.PasswordEncoder;
 * import org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration
 * public class SecurityConfig {
 * 
 * @Bean
 * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
 * Exception {
 * http
 * .csrf(csrf -> csrf.disable()) // Disable CSRF globally
 * .authorizeHttpRequests(authz -> authz
 * .requestMatchers("/api/auth/register", "/api/auth/login").permitAll() //
 * Allow public access to
 * // register and login
 * .anyRequest().authenticated() // All other endpoints require authentication
 * )
 * .httpBasic(Customizer.withDefaults()); // Enable basic authentication
 * 
 * return http.build();
 * }
 * 
 * @Bean
 * public PasswordEncoder passwordEncoder() {
 * return new BCryptPasswordEncoder(); // BCrypt for password hashing
 * }
 * }
 */