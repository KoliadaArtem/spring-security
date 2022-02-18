package com.example.security.service.security;

import com.example.security.model.persistence.UserEntity;
import com.example.security.model.security.AppUserDetails;
import com.example.security.repository.ProductRepository;
import com.example.security.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
  private UserRepository userRepository;
  @Override
  public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Supplier<UsernameNotFoundException> usernameNotFoundExceptionSupplier = () -> new UsernameNotFoundException(String.format("%s not found!", username));
    UserEntity userEntity = userRepository.findUserByUsername(username).orElseThrow(usernameNotFoundExceptionSupplier);
    return new AppUserDetails(userEntity);
  }
}
