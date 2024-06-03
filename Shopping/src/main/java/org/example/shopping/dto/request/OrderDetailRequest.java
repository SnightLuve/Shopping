package org.example.shopping.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetailRequest {
    Long productDetailId;
    Double soLuong;
    Boolean trangThai;
    Long orderId;
}
