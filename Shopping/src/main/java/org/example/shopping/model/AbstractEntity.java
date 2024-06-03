package org.example.shopping.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    T id;
    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date createdAt;
    @Column(name = "updated_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    Date updatedAt;

}
