package org.example.shopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailResponse {
    Long id;
    String productName;
    String brandName;
    String colorName;
    String sizeName;
    Integer quantity;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
