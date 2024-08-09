package org.example.shopping.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;

@Data
public class SigninRequest implements Serializable {
    private String username;
    private String fullName;
    private Boolean gender;
    private String phone;
    @Email(message = "Email invalid format")
    private String email;
    private String password;
}
