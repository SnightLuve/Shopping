package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.model.Size;
import org.example.shopping.service.SizeService;
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
@RequestMapping("/api/v1/size")
public class SizeController {
    private final SizeService sizeService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        ResponseObject<?> response=ResponseObject.builder()
                .message("Get all brands successful")
                .data(sizeService.getAllSizes())
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Size size){
        ResponseObject<?> response=ResponseObject.builder()
                .message("Add a new  brand successful")
                .data(sizeService.createSize(size))
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        sizeService.deleteSizeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Size size){
        return new ResponseEntity<>(sizeService.updateSize(size),HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(sizeService.getSizeById(id),HttpStatus.OK);
    }

}
