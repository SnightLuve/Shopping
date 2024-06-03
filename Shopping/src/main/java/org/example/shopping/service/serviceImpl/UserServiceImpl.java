package org.example.shopping.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.reponse.UserResponse;
import org.example.shopping.model.User;
import org.example.shopping.repository.UserRepository;
import org.example.shopping.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetailsService userDetailsService(){
        return new UserDetailsService(){
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username)
                        .orElseThrow(()->new UsernameNotFoundException("User not found"));
            }
        };
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserResponse findByUsername(String username) {
        Optional<User> user=userRepository.findByUsername(username);
        UserResponse userResponse=modelMapper.map(user,UserResponse.class);
        return userResponse;
    }
}
