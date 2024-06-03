package org.example.shopping.repository;

import org.example.shopping.model.Brand;
import org.example.shopping.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
