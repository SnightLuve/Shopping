package org.example.shopping.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.reponse.ProductDetailResponse;
import org.example.shopping.dto.request.ProductDetailRequest;
import org.example.shopping.model.ProductDetail;
import org.example.shopping.repository.*;
import org.example.shopping.service.ProductDetailService;
import org.modelmapper.ModelMapper;
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

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ColorRepository  colorRepository;
    private final SizeRepository  sizeRepository;
    private final SoleRepository soleRepository;
    private final MaterialRepository materialRepository;
    private final BrandRepository brandRepository;
    private final ProductDetailRepository productDetailRepository;
    @Override
    public List<ProductDetailResponse> getAll() {
        return productDetailRepository.getAll();
    }

    @Override
    public List<ProductDetailResponse> getData(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        Page<ProductDetail> productDetails = productDetailRepository.findAll(pageable);
        return productDetails.stream().map(p->ProductDetailResponse.builder()
                .productId(p.getProduct().getId())
                .brandId(p.getBrand().getId())
                .colorId(p.getColor().getId())
                .sizeId(p.getSize().getId())
                .soleId(p.getSole().getId())
                .materialId(p.getMaterial().getId())
                .categoryId(p.getCategory().getId())
                .quantity(p.getQuantity())
                .build()).toList();
    }

    @Override
    public ProductDetailResponse insert(ProductDetailRequest productDetailRequest) {
        ProductDetail productDetail=new ProductDetail().builder()
                .product(productRepository.getReferenceById(productDetailRequest.getProductId()))
                .brand(brandRepository.getReferenceById(productDetailRequest.getBrandId()))
                .color(colorRepository.getReferenceById(productDetailRequest.getColorId()))
                .size(sizeRepository.getReferenceById(productDetailRequest.getSizeId()))
                .sole(soleRepository.getReferenceById(productDetailRequest.getSoleId()))
                .category(categoryRepository.getReferenceById(productDetailRequest.getCategoryId()))
                .material(materialRepository.getReferenceById(productDetailRequest.getMaterialId()))
                .quantity(productDetailRequest.getQuantity())
                .created_at(LocalDateTime.now())
                .build();
        ProductDetail p=productDetailRepository.save(productDetail);
        return new ProductDetailResponse(
                p.getId(),
                p.getProduct().getId(),
                p.getBrand().getId(),
                p.getCategory().getId(),
                p.getColor().getId(),
                p.getSize().getId(),
                p.getSole().getId(),
                p.getMaterial().getId(),
                p.getQuantity(),
                p.getCreated_at(),
                p.getUpdated_at()
        );    }
    @Transactional
    @Modifying
    @Override
    public ProductDetailResponse update(ProductDetailRequest productDetailRequest) {
        return null;
    }

    @Override
    public ProductDetailResponse delete(ProductDetailRequest productDetailRequest) {
        return null;
    }

    @Override
    public ProductDetail getById(Long id) {
        return productDetailRepository.findById(id).orElse(null);
    }
}
