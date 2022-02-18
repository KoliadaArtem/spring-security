package com.example.security.service.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestValidationFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    String requestId = httpServletRequest.getHeader("Request-Id");
    if (requestId == null || requestId.isEmpty()) {
      httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      return;
    }
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
