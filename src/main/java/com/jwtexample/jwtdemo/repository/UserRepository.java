package com.jwtexample.jwtdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtexample.jwtdemo.model.Role;
import com.jwtexample.jwtdemo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);

    User findByRole(Role role);
}
