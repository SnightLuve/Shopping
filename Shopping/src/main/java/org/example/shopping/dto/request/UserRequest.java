package org.example.shopping.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.example.shopping.util.EnumPattern;
import org.example.shopping.util.Role;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {
    String username;
    String password;
    String email;
    String fullName;
    Boolean gender;
    String phone;
    String address;
    @Enumerated(EnumType.STRING)
    @EnumPattern(name = "role", regexp = "ADMIN|STAFF")
    Role role;
    Integer status;
}
