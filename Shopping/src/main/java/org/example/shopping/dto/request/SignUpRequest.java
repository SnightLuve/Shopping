package org.example.shopping.dto.request;

import lombok.Data;

@Data
public class SignUpRequest {
    private String username;
    private String lastName;
    private String email;
    private String password;
}
