package org.example.shopping.repository;

import org.example.shopping.model.User;
import org.example.shopping.util.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
