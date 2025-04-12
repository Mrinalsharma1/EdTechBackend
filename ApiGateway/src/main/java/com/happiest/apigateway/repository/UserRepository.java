package com.happiest.apigateway.repository;

import com.happiest.apigateway.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsername(String name);
    boolean existsByUsername(String username);

}

