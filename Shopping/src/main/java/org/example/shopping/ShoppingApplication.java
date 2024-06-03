package org.example.shopping;

import org.example.shopping.util.Role;
import org.example.shopping.model.User;
import org.example.shopping.repository.UserRepository;
import org.example.shopping.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShoppingApplication{
    //implements CommandLineRunner
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  JWTService jwtService;

//    @Override
//    public void run(String... args) {
//        User adminAccount = userRepository.findByRole(Role.ADMIN);
//        if(adminAccount == null) {
//            User user = new User();
//             user.setUsername("minhson");
//             user.setPassword(new BCryptPasswordEncoder().encode("123"));
//             user.setFullname("minhson");
//             user.setEmail("son@gmail.com");
//             user.setRole(Role.USER);
//             userRepository.save(user);
//        }
//    }

    public static void main(String[] args) {
        SpringApplication.run(ShoppingApplication.class, args);
    }

}
