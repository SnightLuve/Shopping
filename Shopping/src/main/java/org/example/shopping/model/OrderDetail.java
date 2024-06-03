package org.example.shopping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productdetailid",referencedColumnName = "id")
    ProductDetail productDetail;
    Double soluong;
    Boolean trangthai;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderid",referencedColumnName = "id")
    Order order;
}
