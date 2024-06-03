package org.example.shopping.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    Color color;

    @ManyToOne
    @JoinColumn(name = "size_id", referencedColumnName = "id")
    Size size;

    @ManyToOne
    @JoinColumn(name = "sole_id", referencedColumnName = "id")
    Sole sole;

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    Material material;
    Double quantity;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime created_at;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime updated_at;

    @PrePersist
    protected void onCreate() {
        created_at = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }
}
