package com.example.security.repository;

import com.example.security.model.persistence.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
  Optional<UserEntity> findUserByUsername(String username);

}
