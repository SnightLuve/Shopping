package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.model.Brand;
import org.example.shopping.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandController {
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        ResponseObject<?> response=ResponseObject.builder()
                .message("Get all brands successful")
                .data(brandService.getAllBrands())
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Brand brand){
        ResponseObject<?> response=ResponseObject.builder()
                .message("Add a new  brand successful")
                .data(brandService.createBrand(brand))
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        brandService.deleteBrandById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Brand brand){
        return new ResponseEntity<>(brandService.updateBrand(brand),HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(brandService.getBrandById(id),HttpStatus.OK);
    }

}
