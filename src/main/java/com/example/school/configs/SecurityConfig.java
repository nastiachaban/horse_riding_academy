package com.example.school.configs;

import com.example.school.services.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final Logger LOGGER= LoggerFactory.getLogger(SecurityConfig.class);
    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {

        return http
                .csrf().disable()
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/images/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users/signUp/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/signUp/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users/logIn/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/logIn/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/school/home/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/school/home/**").permitAll()

                        .anyRequest().authenticated())
                .formLogin(form -> form
                        .loginPage("/users/logIn")
                        .loginProcessingUrl("/users/logIn")  // GET - show login form
                        .defaultSuccessUrl("/school/home", true)   // Redirect after successful login
                        .failureUrl("/users/logIn?error=true")        // Redirect on failed login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/users/logout")
                        .logoutSuccessUrl("/users/logIn?logout=true")
                        .permitAll()
                )
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}