package org.example.shopping.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.example.shopping.model.Discount;

import java.time.LocalDateTime;

@Getter
@Setter
public class DiscountRequest {
    @Enumerated(EnumType.STRING)
    private Discount.Type type;
    @Enumerated(EnumType.STRING)
    private Discount.Kind kind;
    Double value;
    Integer quantity;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDateTime start_date;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDateTime end_date;
}
