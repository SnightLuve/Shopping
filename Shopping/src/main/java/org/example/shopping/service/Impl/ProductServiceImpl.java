package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.ProductRequest;
import org.example.shopping.model.Product;
import org.example.shopping.repository.ProductRepository;
import org.example.shopping.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product createProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
