package org.example.shopping.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String madonhang;
    @ManyToOne
    @JoinColumn(name = "userid")
    User user;
    LocalDateTime ngaytao;
    LocalDateTime ngaycapnhat;
    LocalDateTime ngaygiaohang;
    LocalDateTime ngaynhan;
    String tennguoinhan;
    String diachi;
    String phone;
    String tenguoigiao;
    String sdtnguoigiao;
    Double giatrigiam;
    Double tiengiaohang;
    Double tienship;
    Double tienmat;
    Double tienck;
    Double tienthua;
    Double thanhtien;
    @ManyToOne
    @JoinColumn(name = "discountid")
    Discount discount;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    List<Payment> payment;
    Integer trangthai;
    @Enumerated(EnumType.STRING)
    Type type;

    public enum Type{
        NORMAL,
        ONLINE
    }

}
