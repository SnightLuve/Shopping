package org.example.shopping.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.shopping.config.language.Translator;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.dto.request.ProductDetailRequest;
import org.example.shopping.service.ProductDetailService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productDetail")
@RequiredArgsConstructor
@Slf4j
public class ProductDetailController {
    private final ProductDetailService productDetailService;

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        ResponseObject<?> responseObject =  ResponseObject.builder()
                .data(productDetailService.getAll())
                .success(true)
                .message("Get all product detail successfully")
                .status(HttpStatus.OK)
                .build();
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("/data")
    public ResponseEntity<?> getProductDetail(
            @RequestParam(defaultValue = "1", required = false) int pageNo,
            @RequestParam(defaultValue = "5") int pageSize) {
        ResponseObject<?> responseObject = ResponseObject.builder()
                .data(productDetailService.getData(pageNo, pageSize))
                .status(HttpStatus.OK)
                .success(true)
                .message("Get product detail successfully")
                .build();
        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try{
            return new ResponseEntity<>(productDetailService.getById(id), HttpStatus.OK);
        }catch (Exception e) {
            log.error("error: {}", e.getMessage(),e.getCause());
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
    }
        }

    @PostMapping(value = "/add", consumes = "application/json")
    public ResponseEntity<?> add(@RequestBody @Valid ProductDetailRequest productDetailRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errors =bindingResult.getFieldErrors()
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
                .message(Translator.toLocale("productDetail.add.success"))
                .data(productDetailService.insert(productDetailRequest))
                .success(true)
                .build();
        return new ResponseEntity<>(responseObject, HttpStatus.CREATED);
    }
}
