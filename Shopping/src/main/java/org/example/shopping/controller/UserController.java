package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.config.language.Translator;
import org.example.shopping.dto.response.ResponseObject;
import org.example.shopping.dto.request.UserRequest;
import org.example.shopping.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello User");
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int page) {
        Pageable pageable= PageRequest.of(page-1,4);
        ResponseObject<?> responseObject = ResponseObject.builder()
                .data(userService.findAll(pageable).getContent())
                .status(HttpStatus.OK)
                .message(Translator.toLocale("user.add.success"))
                .build();
        return ResponseEntity.ok(responseObject);
    }
    @GetMapping("/getByUserName")
    public ResponseEntity<?> getByUserName(@RequestParam String username) {
        ResponseObject<?> responseObject=ResponseObject.builder()
                .data(userService.findByUsername(username))
                .status(HttpStatus.OK)
                .message(Translator.toLocale("user.add.success"))
                .build();
        return ResponseEntity.ok(responseObject);
    }
    @PostMapping("")
    public ResponseEntity<?> addUser(@RequestBody UserRequest userRequest) {
        ResponseObject<?> responseObject=ResponseObject.builder()
                .data(userService.addUser(userRequest))
                .status(HttpStatus.OK)
                .message(Translator.toLocale("user.add.success"))
                .build();
        return ResponseEntity.ok(responseObject);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUser(userRequest, id), HttpStatus.OK);
    }
}
