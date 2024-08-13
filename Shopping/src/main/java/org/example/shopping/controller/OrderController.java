package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.OrderRequest;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") Integer pageNo
    ){
        ResponseObject<?> response=ResponseObject.builder()
                .data(orderService.findAll(pageNo))
                .message("Get all orders success")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest orderRequest){
        ResponseObject<?> response=ResponseObject.builder()
                .data(orderService.add(orderRequest))
                .message("Get all orders success")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ResponseObject<?> response=ResponseObject.builder()
                .data(orderService.findById(id))
                .message("Get all orders success")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        ResponseObject<?> response=ResponseObject.builder()
                .data(orderService.deleteById(id))
                .message("Get all orders success")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
