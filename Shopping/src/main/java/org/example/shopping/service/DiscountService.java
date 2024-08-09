package org.example.shopping.service;

import org.example.shopping.dto.request.DiscountRequest;
import org.example.shopping.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DiscountService {
    Discount createDiscount(DiscountRequest discountRequest);
    Page<Discount> getAll(Pageable pageable);
    void delete(Long id);
    Optional<Discount> getById(Long id);
    Discount update(Discount discount);
}
