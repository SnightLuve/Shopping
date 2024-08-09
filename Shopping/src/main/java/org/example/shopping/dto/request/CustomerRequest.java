package org.example.shopping.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerRequest {
    @NotBlank(message = "Full name not blank")
    private String fullName;
    private LocalDateTime birthday;
    @NotBlank(message = "Phone not blank")
    private String phone;
    @NotBlank(message = "Address not blank")
    private String address;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
