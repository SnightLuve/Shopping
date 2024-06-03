package org.example.shopping.service;

import org.example.shopping.dto.request.OrderRequest;
import org.example.shopping.model.Order;
import org.example.shopping.model.OrderDetail;

import java.security.Principal;
import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest orderRequest, List<OrderDetail> orderDetailList, Principal username);
}
