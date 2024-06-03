package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.reponse.ResponseObject;
import org.example.shopping.model.Cart;
import org.example.shopping.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ResponseObject> createCart(@RequestBody Cart cart) {
        ResponseObject responseObject = new ResponseObject().builder()
                .data(cartService.createGioHang(cart))
                .status(HttpStatus.CREATED)
                .success(true)
                .message("Successfully created cart.")
                .build();
        return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
    }
}
