package com.example.security.service;

import com.example.security.model.persistence.ProductEntity;
import com.example.security.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
  private ProductRepository productRepository;

  public List<ProductEntity> findAll() {
    return productRepository.findAll();
  }
}
