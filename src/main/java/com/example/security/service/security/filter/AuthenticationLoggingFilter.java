package com.example.security.service.security.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationLoggingFilter implements Filter {
  private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    String requestId = httpServletRequest.getHeader("Request-Id");
    logger.info(String.format("Authentication success, request-id: %s", requestId));
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
