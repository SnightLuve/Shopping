package org.example.shopping.service;

import org.example.shopping.dto.response.ProductDetailResponse;
import org.example.shopping.dto.request.ProductDetailRequest;
import org.example.shopping.model.ProductDetail;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetailResponse> getAll();
    List<ProductDetailResponse> getData(int pageNo, int pageSize);

    ProductDetailResponse insert(ProductDetailRequest productDetailRequest);
    ProductDetailResponse update(ProductDetailRequest productDetailRequest, Long id);
    void delete(Long id);
    ProductDetail getById(Long id);

}
