package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.DiscountRequest;
import org.example.shopping.model.Discount;
import org.example.shopping.repository.DiscountRepository;
import org.example.shopping.service.DiscountService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final ModelMapper modelMapper;

    @Override
    public Discount createDiscount(DiscountRequest discountRequest) {
        Discount discount = new Discount();
        modelMapper.map(discountRequest, discount);


        if (discountRequest.getStart_date().isAfter(discountRequest.getEnd_date())) {
            throw new IllegalArgumentException("Start date cannot be greater than end date");
        }

        if (discountRequest.getEnd_date().isBefore(discountRequest.getStart_date())) {
            throw new IllegalArgumentException("End date cannot be less than start date");
        }

        switch (discountRequest.getType()) {
            case AMOUNT:
                discount.setType(Discount.Type.AMOUNT);
                if (discountRequest.getValue() > 1_000_000) {
                    throw new IllegalArgumentException("Discount cannot exceed 1 million");
                }
                break;
            case PERCENTAGE:
                discount.setType(Discount.Type.PERCENTAGE);
                if (discountRequest.getValue() > 70) {
                    throw new IllegalArgumentException("Discount cannot exceed 70%");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid discount type");
        }

        return discountRepository.save(discount);
    }

    @Override
    public Page<Discount> getAll(Pageable pageable) {
        return discountRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        discountRepository.deleteById(id);
    }

    @Override
    public Optional<Discount> getById(Long id) {
        return discountRepository.findById(id);
    }

    @Override
    public Discount update(Discount discount) {
        return discountRepository.save(discount);
    }

}
