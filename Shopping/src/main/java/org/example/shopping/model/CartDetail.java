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
@Table(name = "cartdetail")
@Builder
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Integer soluong;
    Double dongia;
    @ManyToOne
    @JoinColumn(name = "productdetailid")
    ProductDetail productDetail;
    @ManyToOne
    @JoinColumn(name = "cartid", referencedColumnName = "id",nullable = false)
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "id")
    Order order;
    Integer trangthai;
}
