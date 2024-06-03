package org.example.shopping.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.model.Cart;
import org.example.shopping.model.CartDetail;
import org.example.shopping.model.User;
import org.example.shopping.repository.CartDetailRepository;
import org.example.shopping.repository.CartRepository;
import org.example.shopping.repository.UserRepository;
import org.example.shopping.service.CartService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;

    @Override
    public Cart createGioHang(Cart cart) {

        User user=userRepository.findById(cart.getUser().getId()).orElseThrow(()->new RuntimeException("user not found"));
        cart.setUser(user);
        cart.setNgaytao(LocalDate.now());
        List<CartDetail> cartDetails=cart.getCartDetails();
        for(CartDetail cartDetail:cartDetails) {
            cartDetail.setCart(cart);
            cartDetailRepository.save(cartDetail);
        }
        return cartRepository.save(cart);
    }

    @Override
    public Cart findByIdgiohang(Long id) {
        return cartRepository.findById(id).orElseThrow(()->new RuntimeException("cart not found"));
    }

    @Override
    public Cart addSpToCart(Long id, CartDetail cartDetail) {
        Cart cart = cartRepository.findById(id).get();
        cart.getCartDetails().add(cartDetail);
        return cartRepository.save(cart);
    }
}
