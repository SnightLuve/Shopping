package org.example.shopping.service;

import org.example.shopping.dto.request.OrderDetailRequest;

public interface OrderDetailService {
    String add(OrderDetailRequest orderDetailRequest);
    String delete(Long id);
    String update(OrderDetailRequest orderDetailRequest, Long id);

}
