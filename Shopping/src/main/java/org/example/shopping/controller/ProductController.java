package org.example.shopping.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.ProductRequest;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.model.Product;
import org.example.shopping.service.ProductService;
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
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam int pageSize
    ){
        Pageable pageable= PageRequest.of(pageNo-1, pageSize);
        return new ResponseEntity<>(productService.getAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ProductRequest productRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors=bindingResult.getFieldErrors()
                    .stream().map(FieldError::getDefaultMessage).toList();
            return ResponseEntity.badRequest()
                    .body(ResponseObject.builder()
                            .message(String.join(";",errors))
                            .status(HttpStatus.BAD_REQUEST)
                            .success(false)
                            .build());
        }
        ResponseObject<?> response=ResponseObject.builder()
                .data(productService.createProduct(productRequest))
                .status(HttpStatus.CREATED)
                .success(true)
                .build();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ResponseObject<?> response= ResponseObject.builder()
                .data(productService.getProduct(id))
                .success(true)
                .status(HttpStatus.OK)
                .message("Get product by id successfully")
                .build();
        return  ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Product product){
        ResponseObject<?> response=ResponseObject.builder()
                .data(productService.updateProduct(product))
                .success(true)
                .status(HttpStatus.OK)
                .message("Update product successfully")
                .build();
        return  ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
