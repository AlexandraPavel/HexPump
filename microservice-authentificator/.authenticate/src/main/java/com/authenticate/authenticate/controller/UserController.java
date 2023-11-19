package com.authenticate.authenticate.controller;

import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @NonNull
    UserService userService;

    @GetMapping(value = "/index", produces = "text/html")
    public String getLogin() {
        return "index";
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        String redirectUrl = "/profile";
        userService.validateUserAuthe(userDTO);
        return ResponseEntity.ok(redirectUrl);
    }
}
