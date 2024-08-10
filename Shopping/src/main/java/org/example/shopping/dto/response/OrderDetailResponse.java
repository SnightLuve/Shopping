package org.example.shopping.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResponse {
    Long id;
    Long productDetailId;
    String productName;
    String colorName;
    String sizeName;
    String brandName;
    Integer quantity;
    Double totalMoney;
}
