package org.example.shopping.dto.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.io.Serializable;

@Data
public class SigninRequest implements Serializable {
    private String username;
    private String fullname;
    private Boolean gender;
    private String phone;
    private String address;
    @Email(message = "Email invalid format")
    private String email;
    private String password;
    private boolean is_Activity;
}
