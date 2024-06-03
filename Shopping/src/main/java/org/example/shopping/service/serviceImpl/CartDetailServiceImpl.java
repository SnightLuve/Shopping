package org.example.shopping.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.reponse.TongTienResponse;
import org.example.shopping.model.Cart;
import org.example.shopping.model.CartDetail;
import org.example.shopping.repository.CartDetailRepository;
import org.example.shopping.repository.CartRepository;
import org.example.shopping.service.CartDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CartDetailServiceImpl implements CartDetailService {
    private final CartDetailRepository cartDetailRepository;
    private final CartRepository cartRepository;
    @Override
    public List<CartDetail> getALlGHCT(Long id) {
        return cartDetailRepository.findAll();
    }

    @Override
    public void addSPVaoGioHangCT(Cart idgiohang, Long idctsp, Integer soluong) {
        Cart cart=cartRepository.findById(idctsp).get();
        CartDetail cartDetail=new CartDetail();
        cartDetail.setCart(cart);
        cartDetail.setSoluong(soluong);
    }

    @Override
    public CartDetail updateGHCT(Long idghct, Integer soluong) {
        return null;
    }

    @Override
    public CartDetail deleteSPGHCT(Long idghct) {
        return null;
    }

    @Override
    public void deleteALlSPGHCT(Long idgiohang) {

    }

    @Override
    public List<Cart> getAllTongTien(Long idgiohang) {
        return List.of();
    }

    @Override
    public List<TongTienResponse> getTongSoTien(Long idgiohang) {
        return List.of();
    }
}
