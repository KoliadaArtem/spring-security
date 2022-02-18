package com.example.security.configuration.security;


import com.example.security.service.security.filter.AuthenticationLoggingFilter;
import com.example.security.service.security.AuthenticationProviderService;
import com.example.security.service.security.filter.CustomAuthenticationFilter;
import com.example.security.service.security.filter.RequestValidationFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  private AuthenticationProviderService authenticationProviderService;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity.formLogin().defaultSuccessUrl("/main", true);
    httpSecurity.addFilterAt(new CustomAuthenticationFilter(), BasicAuthenticationFilter.class);

//    httpSecurity.httpBasic();
    httpSecurity.authorizeRequests().anyRequest().denyAll();

//        .anyRequest().authenticated();

    httpSecurity.csrf().disable();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(authenticationProviderService);
  }
}
