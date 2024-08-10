package org.example.shopping.service;

import org.example.shopping.dto.request.CustomerRequest;
import org.example.shopping.dto.request.OrderRequest;
import org.example.shopping.model.Order;
import org.springframework.data.domain.Page;

public interface OrderService {
    Long add(OrderRequest orderRequest);
    Order findById(Long id);
    String deleteById(Long id);
    String update(OrderRequest orderRequest, Long id);
    Page<Order> findAll(int pageNo);
    String updateCustomer(CustomerRequest customerRequest, Long id);
}
