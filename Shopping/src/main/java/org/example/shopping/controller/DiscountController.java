package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.service.DiscountService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/discount")
public class DiscountController {
    private final DiscountService discountService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam int pageSize
    ){
        Pageable pageable= PageRequest.of(pageNo-1,pageSize);
        return new ResponseEntity<>(discountService.getAll(pageable), HttpStatus.OK);
    }
}
