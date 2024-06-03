package org.example.shopping.service;

import org.example.shopping.dto.reponse.ProductDetailResponse;
import org.example.shopping.dto.request.ProductDetailRequest;
import org.example.shopping.model.ProductDetail;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductDetailService {
    List<ProductDetailResponse> getAll();
    List<ProductDetailResponse> getData(int pageNo, int pageSize);

    ProductDetailResponse insert(ProductDetailRequest productDetailRequest);
    ProductDetailResponse update(ProductDetailRequest productDetailRequest);
    ProductDetailResponse delete(ProductDetailRequest productDetailRequest);
    ProductDetail getById(Long id);

}
