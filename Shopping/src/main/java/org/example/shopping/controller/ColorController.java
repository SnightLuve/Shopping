package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.model.Color;
import org.example.shopping.service.ColorService;
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
@RequestMapping("/api/v1/color")
public class ColorController {
    private final ColorService colorService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        ResponseObject<?> response=ResponseObject.builder()
                .message("Get all brands successful")
                .data(colorService.getAllColors())
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Color color){
        ResponseObject<?> response=ResponseObject.builder()
                .message("Add a new  brand successful")
                .data(colorService.createColor(color))
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        colorService.deleteColorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Color color){
        return new ResponseEntity<>(colorService.updateColor(color),HttpStatus.ACCEPTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return new ResponseEntity<>(colorService.getColorById(id),HttpStatus.OK);
    }

}
