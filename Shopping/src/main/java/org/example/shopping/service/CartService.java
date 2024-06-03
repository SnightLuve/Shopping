package org.example.shopping.service;

import org.example.shopping.model.Cart;
import org.example.shopping.model.CartDetail;

import java.util.List;

public interface CartService {
    Cart createGioHang(Cart cart);
    Cart findByIdgiohang(Long id);
    Cart addSpToCart(Long id, CartDetail cartDetail);
}
