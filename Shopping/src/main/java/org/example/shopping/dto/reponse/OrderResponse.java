package org.example.shopping.dto.reponse;

import org.example.shopping.model.Payment;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    Long id;
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
    Boolean trangthai;
}
