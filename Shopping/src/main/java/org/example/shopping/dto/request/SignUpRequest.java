package org.example.shopping.dto.request;

import lombok.Data;
import org.example.shopping.util.Role;

@Data
public class SignUpRequest {
    private String username;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
