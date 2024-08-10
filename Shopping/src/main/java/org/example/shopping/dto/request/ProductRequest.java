package org.example.shopping.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductRequest {
    @NotBlank(message = "Name it not blank")
    private String name;
    @NotNull(message = "Price is not null")
    @DecimalMin(value = "100000",inclusive = false)
    private Double price;
    @NotBlank(message = "Description is not null")
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
