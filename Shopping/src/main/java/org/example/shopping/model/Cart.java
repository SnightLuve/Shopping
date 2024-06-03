package org.example.shopping.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cart")
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate ngaytao;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate ngaycapnhat;
    private String ghichu;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<CartDetail> cartDetails;
    @ManyToOne
    @JoinColumn(name = "userid",referencedColumnName = "id")
    User user;
}
