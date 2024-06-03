package org.example.shopping.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.shopping.model.Discount;
import org.example.shopping.model.Order;
import org.example.shopping.model.Payment;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    String madonhang;
    Long userid;
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
    Long discountId;
    List<Payment> payment;
    Integer trangthai;
    @Enumerated(EnumType.STRING)
    Order.Type type;
}
