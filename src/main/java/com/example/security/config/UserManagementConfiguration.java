package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
public class UserManagementConfiguration {

  @Bean
  public UserDetailsManager userDetailsManager() {
    UserDetails userDetails = User.withUsername("artem")
        .password("12345")
        .authorities("read")
        .build();

    InMemoryUserDetailsManager memoryUserDetailsManager = new InMemoryUserDetailsManager();
    memoryUserDetailsManager.createUser(userDetails);
    return memoryUserDetailsManager;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
