package org.example.shopping.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.CustomerRequest;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.model.Customer;
import org.example.shopping.service.CustomerService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int pageNo, @RequestParam int pageSize){
        Pageable pageable= PageRequest.of(pageNo-1, pageSize);
        ResponseObject<?> response=ResponseObject.builder()
                .success(true)
                .data(customerService.getAll(pageable))
                .message("Get all customer successfully")
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CustomerRequest customerRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors=bindingResult.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(
                    ResponseObject.builder()
                            .message(String.join(";", errors))
                            .status(HttpStatus.BAD_REQUEST)
                            .build());
        }
        ResponseObject<?> responseObject = ResponseObject.builder()
                .status(HttpStatus.CREATED)
                .message("Add success")
                .data(customerService.createCustomer(customerRequest))
                .success(true)
                .build();
        return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        customerService.removeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.update(customer),HttpStatus.ACCEPTED);
    }
}
