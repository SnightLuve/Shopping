package org.example.shopping.service;

import org.example.shopping.dto.response.ProductDetailResponse;
import org.example.shopping.dto.request.ProductDetailRequest;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetailResponse> getAll();
    List<ProductDetailResponse> getData(int pageNo, int pageSize);

    ProductDetailResponse insert(ProductDetailRequest productDetailRequest);
    String update(ProductDetailRequest productDetailRequest, Long id);
    void delete(Long id);
    ProductDetailResponse getById(Long id);
    List<ProductDetailResponse> filterProductDetail(int pageNo, Long colorId, Long brandId, Long sizeId, Long productId);

    void updateQuantityProductDetail(Long id, Integer quantity, String method);

}
