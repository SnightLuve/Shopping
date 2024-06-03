package org.example.shopping.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;
    String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("create_at")
    LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("update_at")
    LocalDateTime updatedAt;
}
