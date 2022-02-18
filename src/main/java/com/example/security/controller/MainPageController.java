package com.example.security.controller;

import com.example.security.service.ProductService;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainPageController {
  private ProductService productService;

  @GetMapping("/main")
  public String main(Authentication authentication, Model model) {
    model.addAttribute("username", authentication.getName());
    model.addAttribute("products", productService.findAll());
    return "main.html";
  }
}
