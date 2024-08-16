package org.example.shopping.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.shopping.dto.request.OrderDetailRequest;
import org.example.shopping.service.OrderDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/orderDetail", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @PostMapping(value = "")
    public ResponseEntity<?> getAll(@RequestBody @Valid OrderDetailRequest orderDetailRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors= bindingResult.getFieldErrors()
                    .stream()
                    .map(error -> error.getField()+ ""+error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        return new ResponseEntity<>(orderDetailService.add(orderDetailRequest), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        orderDetailService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid OrderDetailRequest orderDetailRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> errors=bindingResult.getFieldErrors()
                    .stream()
                    .map(error->error.getField())
                    .toList();
            return ResponseEntity.badRequest().body(errors);
        }
        return new ResponseEntity<>(orderDetailService.update(orderDetailRequest, id), HttpStatus.ACCEPTED);
    }



}
