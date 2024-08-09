package org.example.shopping.service;

import org.example.shopping.dto.response.UserResponse;
import org.example.shopping.dto.request.UserRequest;
import org.example.shopping.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
    Page<User> findAll(Pageable pageable);
    UserResponse findByUsername(String username);
    UserResponse addUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest, Long id);
    void deleteUser(Long id);
}
