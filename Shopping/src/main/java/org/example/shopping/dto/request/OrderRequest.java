package org.example.shopping.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderRequest {
    private Long userId;
    private Long paymentId;
    private Long customerId;
    private Long discountId;
    private Integer quantity;
    private Double totalMoney;
    private LocalDateTime createdAt;
    private Integer status;
}
