package org.example.shopping.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.reponse.OrderResponse;
import org.example.shopping.dto.request.OrderRequest;
import org.example.shopping.model.Cart;
import org.example.shopping.model.CartDetail;
import org.example.shopping.model.Discount;
import org.example.shopping.model.Order;
import org.example.shopping.model.OrderDetail;
import org.example.shopping.model.User;
import org.example.shopping.repository.CartDetailRepository;
import org.example.shopping.repository.CartRepository;
import org.example.shopping.repository.DiscountRepository;
import org.example.shopping.repository.OrderDetailRepository;
import org.example.shopping.repository.OrderRepository;
import org.example.shopping.repository.UserRepository;
import org.example.shopping.service.OrderService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartDetailRepository cartDetailRepository;


    @Override
    public Order createOrder(OrderRequest orderRequest, List<OrderDetail> orderDetailList, Principal username) {
        User user=userRepository.findByUsername(String.valueOf(username)).orElseThrow();
        Order order = new Order();
        order.setUser(user);
        order.setNgaytao(LocalDateTime.now());
        order.setMadonhang(orderRequest.getMadonhang());
        order.setNgaygiaohang(orderRequest.getNgaygiaohang());
        order.setNgaynhan(orderRequest.getNgaynhan());
        order.setTennguoinhan(orderRequest.getTennguoinhan());
        order.setDiachi(orderRequest.getDiachi());
        order.setPhone(orderRequest.getPhone());
        order.setSdtnguoigiao(orderRequest.getSdtnguoigiao());
        order.setTenguoigiao(orderRequest.getTenguoigiao());
        if(orderRequest.getType()== Order.Type.NORMAL){
            order.setTienship(0.0);
            order.setTenguoigiao(null);
        }else {
            order.setTienship(orderRequest.getTienship());
            order.setTenguoigiao(orderRequest.getTenguoigiao());
        }
        order=orderRepository.save(order);
        for(OrderDetail orderDetail:orderDetailList){
            orderDetail.setOrder(order);
            orderDetailRepository.save(orderDetail);
        }
        return order;
    }
}
