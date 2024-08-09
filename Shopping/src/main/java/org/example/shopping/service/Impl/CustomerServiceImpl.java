package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.CustomerRequest;
import org.example.shopping.model.Customer;
import org.example.shopping.repository.CustomerRepository;
import org.example.shopping.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Page<Customer> getAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer createCustomer(CustomerRequest customerRequest) {
        Customer customer=modelMapper.map(customerRequest,Customer.class);
        return customerRepository.save(customer);
    }

    @Override
    public void removeById(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
}
