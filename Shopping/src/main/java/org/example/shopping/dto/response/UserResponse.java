package org.example.shopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shopping.model.User;
import org.example.shopping.util.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    Long id;
    String username;
    String password;
    String email;
    String fullName;
    Boolean gender;
    String phone;
    String address;
    Role role;
    Integer is_Activity;

    public static UserResponse fromUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .gender(user.getGender())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .is_Activity(user.getStatus())
                .build();
    }
}
