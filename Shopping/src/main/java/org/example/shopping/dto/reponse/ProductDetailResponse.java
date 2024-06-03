package org.example.shopping.dto.reponse;

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
    Long productId;
    Long brandId;
    Long categoryId;
    Long colorId;
    Long sizeId;
    Long soleId;
    Long materialId;
    Double quantity;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
