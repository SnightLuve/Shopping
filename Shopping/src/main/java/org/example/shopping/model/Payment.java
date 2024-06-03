package org.example.shopping.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    Order order;


    @JsonFormat(pattern = "yyyy/MM/dd")
    LocalDateTime payment_date;
    Integer amount;
    PaymentMethod payment_method;
    String note;
    Boolean status;
    String Code;
    public  enum PaymentMethod{
        CAST,BANK,TWO
    }

}

