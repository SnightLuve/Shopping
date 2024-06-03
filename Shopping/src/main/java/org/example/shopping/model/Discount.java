package org.example.shopping.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "discount")
public class Discount {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
//    @OneToMany(mappedBy = "discount",fetch = FetchType.LAZY)
//    private List<Order> order;
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
            NORMAL,FREESHIP
    }
}
