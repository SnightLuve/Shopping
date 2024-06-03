package org.example.shopping.dto.reponse;

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
    String fullname;
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
                .fullname(user.getFullname())
                .gender(user.getGender())
                .phone(user.getPhone())
                .address(user.getAddress())
                .role(user.getRole())
                .is_Activity(user.getIs_Activity())
                .build();
    }
}
