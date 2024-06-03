package org.example.shopping.service;

import org.example.shopping.dto.reponse.TongTienResponse;
import org.example.shopping.model.Cart;
import org.example.shopping.model.CartDetail;

import java.util.List;

public interface CartDetailService {
    // Get on ghct
    List<CartDetail> getALlGHCT(Long id);

    // Add sản phẩm vào giỏ hàng
    void addSPVaoGioHangCT(Cart idgiohang , Long idctsp , Integer soluong );

    // Cập Nhật Số Lượng Giỏ Hàng CT
    CartDetail updateGHCT(Long idghct , Integer soluong);

    // Delete sản phẩm trong giỏ hàng chi tiết
    CartDetail deleteSPGHCT(Long idghct);

    // Delete All sản phẩm trong giỏ hàng chi tiết
    public void deleteALlSPGHCT(Long idgiohang);

    // get All checkout
    List<Cart> getAllTongTien(Long idgiohang);

    // get All checkout
    List<TongTienResponse> getTongSoTien(Long idgiohang);
}
