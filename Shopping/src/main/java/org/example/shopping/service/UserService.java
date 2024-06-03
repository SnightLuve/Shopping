package org.example.shopping.service;

import org.example.shopping.dto.reponse.UserResponse;
import org.example.shopping.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    Page<User> findAll(Pageable pageable);
    UserResponse findByUsername(String username);
}
