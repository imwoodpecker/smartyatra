package com.smartyatra.smart_yatra_backend.repository;

import com.smartyatra.smart_yatra_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String Email);
    List<User> findAll();
    List<User> findByRole(String role);
    void deleteById(Long id);
    long countByRole(String role);
}