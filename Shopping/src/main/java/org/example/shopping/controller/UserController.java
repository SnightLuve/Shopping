package org.example.shopping.controller;

import lombok.RequiredArgsConstructor;
import org.example.shopping.config.language.Translator;
import org.example.shopping.dto.reponse.ResponseObject;
import org.example.shopping.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
//    @Operation(summary = "",description = "",responses = {
//            @ApiResponse(responseCode = "200",description = "get users successfully",
//            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//            examples = @ExampleObject(name = "ex name",summary = "ex summary",
//            value = """
//                    {
//                        "status":200,
//                        "message":"success",
//                        "data":1
//                    }
//
//                    """
//            ))
//            )
//    })
    @GetMapping(value = "/list")
    public ResponseEntity<ResponseObject> getAll(@RequestParam(defaultValue = "1") int page) {
        Pageable pageable= PageRequest.of(page-1,4);
        ResponseObject responseObject = new ResponseObject().builder()
                .data(userService.findAll(pageable).getContent())
                .status(HttpStatus.OK)
                .message(Translator.toLocale("user.add.success"))
                .build();
        return ResponseEntity.ok(responseObject);
    }
    @GetMapping("/getByUserName")
    public ResponseEntity<ResponseObject> getByUserName(@RequestParam String username) {
        ResponseObject responseObject=new ResponseObject().builder()
                .data(userService.findByUsername(username))
                .status(HttpStatus.OK)
                .message(Translator.toLocale("user.add.success"))
                .build();
        return ResponseEntity.ok(responseObject);
    }
}
