package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello() {
    return "HALO!";
  }

  @PostMapping("/a")
  public String postEndpointA() {
    return "Works!";
  }
  @GetMapping("/a")
  public String getEndpointA() {
    return "Works!";
  }
  @GetMapping("/a/b")
  public String getEnpointB() {
    return "Works!";
  }
  @PostMapping("/a/b")
  public String postEnpointB() {
    return "Works!";
  }
  @GetMapping("/a/b/c")
  public String getEnpointC() {
    return "Works!";
  }
}
