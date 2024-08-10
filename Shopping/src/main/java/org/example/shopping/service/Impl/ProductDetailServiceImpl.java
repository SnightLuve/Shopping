package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.ProductDetailRequest;
import org.example.shopping.dto.response.ProductDetailResponse;
import org.example.shopping.exception.ProductDetailNotFound;
import org.example.shopping.model.Brand;
import org.example.shopping.model.Color;
import org.example.shopping.model.Product;
import org.example.shopping.model.ProductDetail;
import org.example.shopping.model.Size;
import org.example.shopping.repository.BrandRepository;
import org.example.shopping.repository.ColorRepository;
import org.example.shopping.repository.ProductDetailRepository;
import org.example.shopping.repository.ProductRepository;
import org.example.shopping.repository.SizeRepository;
import org.example.shopping.service.ProductDetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductDetailServiceImpl implements ProductDetailService {

    private final ProductRepository productRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;
    private final BrandRepository brandRepository;
    private final ProductDetailRepository productDetailRepository;


    @Override
    public List<ProductDetailResponse> getAll() {
        return productDetailRepository.getAll();
    }

    @Override
    public List<ProductDetailResponse> getData(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        Page<ProductDetail> productDetails = productDetailRepository.findAll(pageable);
        return productDetails.stream().map(p -> ProductDetailResponse.builder()
                .productName(p.getProduct().getName())
                .brandName(p.getBrand().getName())
                .colorName(p.getColor().getName())
                .sizeName(p.getSize().getName())
                .quantity(p.getQuantity())
                .build()).toList();
    }

    @Override
    public ProductDetailResponse insert(ProductDetailRequest productDetailRequest) {
        ProductDetail productDetail = ProductDetail.builder()
                .product(productRepository.getReferenceById(productDetailRequest.getProductId()))
                .brand(brandRepository.getReferenceById(productDetailRequest.getBrandId()))
                .color(colorRepository.getReferenceById(productDetailRequest.getColorId()))
                .size(sizeRepository.getReferenceById(productDetailRequest.getSizeId()))
                .quantity(productDetailRequest.getQuantity())
                .created_at(LocalDateTime.now())
                .build();
        ProductDetail p = productDetailRepository.save(productDetail);
        return new ProductDetailResponse(
                p.getId(),
                p.getProduct().getName(),
                p.getBrand().getName(),
                p.getColor().getName(),
                p.getSize().getName(),
                p.getQuantity(),
                p.getCreated_at(),
                p.getUpdated_at()
        );
    }

    @Transactional
    @Modifying
    @Override
    public String update(ProductDetailRequest productDetailRequest, Long id) {
        Product product= productRepository.findById(productDetailRequest.getProductId()).orElseThrow();
        Color color= colorRepository.findById(productDetailRequest.getColorId()).orElseThrow();
        Brand brand= brandRepository.findById(productDetailRequest.getBrandId()).orElseThrow();
        Size size= sizeRepository.findById(productDetailRequest.getSizeId()).orElseThrow();

        productDetailRepository.save(
                ProductDetail.builder()
                        .id(id)
                        .product(product)
                        .color(color)
                        .brand(brand)
                        .size(size)
                        .quantity(productDetailRequest.getQuantity())
                        .created_at(LocalDateTime.now())
                        .updated_at(LocalDateTime.now())
                        .build()
        );
        return "Product detail updated";
    }

    @Override
    public void delete(Long id) {
        productDetailRepository.deleteById(id);
    }

    @Override
    public ProductDetailResponse getById(Long id) {
        ProductDetail productDetail = productDetailRepository.findById(id).orElseThrow(
                () -> new ProductDetailNotFound("Not found by id: " + id)
        );
        return new ProductDetailResponse(
                productDetail.getId(),
                productDetail.getProduct().getName(),
                productDetail.getBrand().getName(),
                productDetail.getColor().getName(),
                productDetail.getSize().getName(),
                productDetail.getQuantity(),
                productDetail.getCreated_at(),
                productDetail.getUpdated_at()
        );
    }

    @Override
    public List<ProductDetailResponse> filterProductDetail(int pageNo, Long colorId, Long brandId, Long sizeId, Long productId) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return productDetailRepository.filter(pageable, brandId, colorId, brandId, productId);
    }

    @Override
    public void updateQuantityProductDetail(Long id, Integer quantity, String method) {
        ProductDetail productDetail = productDetailRepository.findById(id).orElseThrow();
        if (method.equalsIgnoreCase("minus")) {
            productDetail.setQuantity(productDetail.getQuantity() - quantity);
        } else {
            productDetail.setQuantity(productDetail.getQuantity() + quantity);
        }
        productDetailRepository.save(productDetail);
    }
}
