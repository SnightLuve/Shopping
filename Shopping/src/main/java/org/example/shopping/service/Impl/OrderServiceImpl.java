package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.CustomerRequest;
import org.example.shopping.dto.request.OrderRequest;
import org.example.shopping.exception.UserNotFoundException;
import org.example.shopping.model.Customer;
import org.example.shopping.model.Order;
import org.example.shopping.model.OrderDetail;
import org.example.shopping.model.Payment;
import org.example.shopping.model.User;
import org.example.shopping.repository.CustomerRepository;
import org.example.shopping.repository.OrderDetailRepository;
import org.example.shopping.repository.OrderRepository;
import org.example.shopping.repository.PaymentRepository;
import org.example.shopping.repository.UserRepository;
import org.example.shopping.service.OrderService;
import org.example.shopping.service.ProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    private final PaymentRepository paymentRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductDetailService productDetailService;

    @Override
    public Long add(OrderRequest orderRequest) {
        Optional<User> optionalUser = userRepository.findById(orderRequest.getUserId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Order order = orderRepository.save(
                    Order.builder()
                            .createdAt(LocalDateTime.now())
                            .user(user)
                            .status(0)
                            .build());
            log.info("Id of order: {} ", order.getId());
            return order.getId();
        } else {
            throw new UserNotFoundException("User not found by id: " + orderRequest.getUserId());
        }

    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(()-> new RuntimeException("Not found by id: "+id));
    }

    @Override
    public String deleteById(Long id) {
        Order order=findById(id);
        List<OrderDetail> list= orderDetailRepository.findAllByOrder(order);
        for (OrderDetail orderDetail:list) {
            productDetailService.updateQuantityProductDetail(orderDetail.getId(), orderDetail.getQuantity(), "minus");
        }
        order.setStatus(0);
        orderRepository.save(order);
        return "Deleted order: " + order.getId();
    }

    @Override
    public String update(OrderRequest orderRequest, Long id) {
        Order order=findById(id);
        User user=userRepository.findById(orderRequest.getUserId()).orElseThrow();
        Payment payment=paymentRepository.findById(orderRequest.getPaymentId()).orElseThrow();
        if(orderRequest.getCustomerId()!=null){
            Customer customer=customerRepository.findById(orderRequest.getCustomerId()).orElseThrow();
            order.setCustomer(customer);
        }
        order.setPayment(payment);
        order.setUser(user);
        order.setQuantity(orderRequest.getQuantity());
        order.setTotalMoney(orderRequest.getTotalMoney());
        orderRepository.save(order);
        return "Success";
    }

    @Override
    public Page<Order> findAll(int pageNo) {
        Pageable pageable= PageRequest.of(pageNo-1,5, Sort.by("id").reverse());
        return orderRepository.getAll(pageable);
    }

    @Override
    public String updateCustomer(CustomerRequest customerRequest, Long id) {
        if(customerRequest.getAddress().isBlank() || customerRequest.getPhone().isBlank() || customerRequest.getFullName().isBlank()){
            return "Vui long nhap day du";
        }
        Customer customer=customerRepository.save(
                Customer.builder()
                        .phone(customerRequest.getPhone())
                        .address(customerRequest.getAddress())
                        .fullName(customerRequest.getFullName())
                        .birthday(customerRequest.getBirthday())
                        .createdAt(LocalDateTime.now())
                        .build());
        Order order=orderRepository.findById(id).orElseThrow();
        order.setCustomer(customer);
        orderRepository.save(order);
        return "Success";
    }
}
