package org.example.shopping.service;

import org.example.shopping.dto.request.ProductRequest;
import org.example.shopping.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Product createProduct(ProductRequest productRequest);
    Page<Product> getAll(Pageable pageable);
    void deleteProduct(Long id);
    Product getProduct(Long id);
    Product updateProduct(Product product);
}
