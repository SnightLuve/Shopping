package org.example.shopping.service;

import org.example.shopping.dto.request.CustomerRequest;
import org.example.shopping.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> getAll(Pageable pageable);

    Customer createCustomer(CustomerRequest customerRequest);

    void removeById(Long id);

    Customer getCustomerById(Long id);

    Customer update(Customer customer);

}
