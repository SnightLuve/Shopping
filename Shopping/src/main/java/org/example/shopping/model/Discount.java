package org.example.shopping.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Kind kind;
    Double value;
    Integer quantity;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDateTime start_date;
    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDateTime end_date;
    public enum Type{
        PERCENTAGE,AMOUNT
    }
    public enum Kind{
            NORMAL,FREE_SHIP
    }
}
