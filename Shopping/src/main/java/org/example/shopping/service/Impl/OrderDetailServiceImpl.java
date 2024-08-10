package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.constants.Constants;
import org.example.shopping.dto.request.OrderDetailRequest;
import org.example.shopping.dto.response.OrderDetailResponse;
import org.example.shopping.exception.OrderDetailNotFoundException;
import org.example.shopping.exception.OrderNotFoundException;
import org.example.shopping.exception.ProductDetailNotFound;
import org.example.shopping.model.Order;
import org.example.shopping.model.OrderDetail;
import org.example.shopping.model.ProductDetail;
import org.example.shopping.repository.OrderDetailRepository;
import org.example.shopping.repository.OrderRepository;
import org.example.shopping.repository.ProductDetailRepository;
import org.example.shopping.service.OrderDetailService;
import org.example.shopping.service.ProductDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    private final ProductDetailRepository productDetailRepository;
    private final OrderRepository orderRepository;
    private final ProductDetailService productDetailService;


    @Override
    public String add(OrderDetailRequest orderDetailRequest) {
        ProductDetail productDetail = productDetailRepository.findById(orderDetailRequest.getProductDetailId())
                .orElseThrow(() -> new ProductDetailNotFound("Product Detail Not Found" + orderDetailRequest.getProductDetailId()));
        Order order = orderRepository.findById(orderDetailRequest.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order Not Found" + orderDetailRequest.getOrderId()));
        Optional<OrderDetail> orderDetail = orderDetailRepository.findByOrderAndProductDetail(order, productDetail);
        if (orderDetail.isEmpty()) {
            if (orderDetailRequest.getQuantity() > productDetail.getQuantity()) {
                return "Over quantity";
            }
            OrderDetail orderDetail1 = orderDetailRepository.save(
                    OrderDetail.builder()
                            .order(order)
                            .productDetail(productDetail)
                            .quantity(orderDetailRequest.getQuantity())
                            .totalMoney(productDetail.getProduct().getPrice() * orderDetailRequest.getQuantity())
                            .build());
            updateOrder(order.getId());
            productDetailService.updateQuantityProductDetail(productDetail.getId(), orderDetail1.getQuantity(), "minus");
        } else {
            Integer totalQuantity = orderDetail.get().getQuantity() + orderDetailRequest.getQuantity();
            Double totalMoney = orderDetail.get().getTotalMoney() + (orderDetailRequest.getQuantity() * productDetail.getProduct().getPrice());
            if (orderDetailRequest.getQuantity() > productDetail.getQuantity()) {
                return "Over quantity";
            }
            OrderDetail orderDetail1 = orderDetailRepository.save(
                    OrderDetail.builder()
                            .id(orderDetail.get().getId())
                            .order(order)
                            .totalMoney(totalMoney)
                            .quantity(totalQuantity)
                            .build());
            updateOrder(order.getId());
            productDetailService.updateQuantityProductDetail(productDetail.getId(), orderDetail1.getQuantity(), "minus");
        }

        return "Add successfully";
    }

    private void updateOrder(Long id) {
        Double totalMoney = 0.0;
        Integer quantity = 0;
        List<OrderDetailResponse> list = orderDetailRepository.getAllProductDetailByOrderId(id);
        for (OrderDetailResponse orderDetailResponse : list) {
            totalMoney += orderDetailResponse.getTotalMoney();
            quantity += orderDetailResponse.getQuantity();
        }
        orderRepository.updateOrder(totalMoney, quantity, id);
    }

    @Override
    public String delete(Long id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Not Found" + id));
        orderDetailRepository.deleteById(id);
        updateOrder(orderDetail.getId());
        productDetailService.updateQuantityProductDetail(orderDetail.getId(), orderDetail.getQuantity(), "plus");
        return "Delete successfully";
    }

    @Transactional
    @Override
    public String update(OrderDetailRequest orderDetailRequest, Long id) {
        Integer totalQuantity;
        ProductDetail productDetail = productDetailRepository.findById(orderDetailRequest.getProductDetailId())
                .orElseThrow(()->new ProductDetailNotFound("Product Detail Not Found" +
                        orderDetailRequest.getProductDetailId()));
        Order order = orderRepository.findById(orderDetailRequest.getOrderId())
                .orElseThrow(()->new OrderNotFoundException(Constants.ORDER_NOT_FOUND));
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(()->new OrderDetailNotFoundException(Constants.ORDER_DETAILS_NOT_FOUND));
        if (orderDetailRequest.getMethod().equalsIgnoreCase("plus")) {
            if (orderDetailRequest.getQuantity() > productDetail.getQuantity()) {
                return "Over quantity";
            }
            totalQuantity = orderDetailRequest.getQuantity() + orderDetail.getQuantity();
        }else {
            totalQuantity= orderDetailRequest.getQuantity() - orderDetail.getQuantity();
        }
        orderDetail.setQuantity(totalQuantity);
        orderDetail.setTotalMoney(productDetail.getProduct().getPrice()*totalQuantity);
        orderDetailRepository.save(orderDetail);
        updateOrder(order.getId());
        if(orderDetailRequest.getMethod().equalsIgnoreCase("minus")) {
            productDetailService.updateQuantityProductDetail(productDetail.getId(), 1, "plus");
        }else {
            productDetailService.updateQuantityProductDetail(productDetail.getId(), 1, "minus");
        }
        return "Update successfully";
    }
}