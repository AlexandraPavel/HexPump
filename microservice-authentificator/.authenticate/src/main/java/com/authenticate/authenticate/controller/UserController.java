package com.authenticate.authenticate.controller;

import com.authenticate.authenticate.dtos.RequestLoginDTO;
import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.entity.UserAuthe;
import com.authenticate.authenticate.service.BioService;
import com.authenticate.authenticate.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    @NonNull
    UserService userService;

    @NonNull
    BioService bioService;

    @PostMapping("/login-valid")
    public ResponseEntity<String> validateLogin(String userID) {

        String redirectUrl = "Good";
        return ResponseEntity.ok(redirectUrl);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody RequestLoginDTO requestDTO){
        System.out.println(requestDTO);
        if (userService.validateUserBio(requestDTO))
            return ResponseEntity.ok("valid");
        else
            return ResponseEntity.badRequest().build();
    }

    @PostMapping("/user")
    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
        System.out.println(userDTO);
        String redirectUrl = "Good";
        if (userService.addUser(userDTO))
            return ResponseEntity.ok(redirectUrl);
        else
            return ResponseEntity.badRequest().build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserAuthe>> findAllUsers(){
        List<UserAuthe> users = userService.findAllUsers();
        if (users != null)
            return ResponseEntity.ok(users);
        else
            return ResponseEntity.badRequest().build();
    }
}
