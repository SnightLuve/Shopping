package org.example.shopping.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailRequest implements Serializable {
    @NotNull
    Long productId;
    @NotNull
    Long brandId;
    @NotNull
    Long categoryId;
    @NotNull
    Long colorId;
    Long sizeId;
    Long soleId;
    Long materialId;
    Double quantity;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDateTime createdAt;
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDateTime updatedAt;
}
