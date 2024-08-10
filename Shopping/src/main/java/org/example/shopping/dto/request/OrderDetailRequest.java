package org.example.shopping.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailRequest {
    private Long orderId;
    private Long productDetailId;
    private Integer quantity;
    private String method;
}
