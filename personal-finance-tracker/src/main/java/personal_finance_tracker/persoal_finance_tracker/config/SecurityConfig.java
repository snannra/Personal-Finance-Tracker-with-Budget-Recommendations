package personal_finance_tracker.persoal_finance_tracker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring security settings"); // Log message instead of System.out.println

        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for now
                .authorizeHttpRequests(authz -> authz
                        .anyRequest().permitAll() // Allow all requests without authentication
                );

        return http.build();
    }
}