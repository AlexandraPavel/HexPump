package com.innovation.hexpump.controller;

import com.innovation.hexpump.dtos.UserDTO;
import com.innovation.hexpump.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        userService.validateUserHexpump(userDTO);
        return ResponseEntity.ok(redirectUrl);
    }


}
