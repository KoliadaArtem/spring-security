package com.example.security.service.security;

import com.example.security.model.persistence.EncryptionAlgorithm;
import com.example.security.model.security.AppUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationProviderService implements AuthenticationProvider {
  @Autowired
  private JpaUserDetailsService userDetailsService;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  @Autowired
  private SCryptPasswordEncoder sCryptPasswordEncoder;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String username = authentication.getName();
    String password = authentication.getCredentials().toString();

    AppUserDetails userDetails = userDetailsService.loadUserByUsername(username);
    if (isPasswordCorrect(password, userDetails.getPassword(), userDetails.getUserEntity().getAlgorithm())) {
      return new UsernamePasswordAuthenticationToken(
          userDetails.getUsername(),
          userDetails.getPassword(),
          userDetails.getAuthorities());
    }
    throw new BadCredentialsException("Bad credentials");
  }

  private boolean isPasswordCorrect(String password, String savedPassword, EncryptionAlgorithm algorithm) {
    switch (algorithm) {
      case BCRYPT:
        return isCryptMatch(password, savedPassword, bCryptPasswordEncoder);
      case SCRYPT:
        return isCryptMatch(password, savedPassword, sCryptPasswordEncoder);
    }
    throw new BadCredentialsException("Unexpected error");
  }

  private boolean isCryptMatch(String password, String savedPassword, PasswordEncoder passwordEncoder) {
    return passwordEncoder.matches(password, savedPassword);
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class
        .isAssignableFrom(aClass);
  }
}
