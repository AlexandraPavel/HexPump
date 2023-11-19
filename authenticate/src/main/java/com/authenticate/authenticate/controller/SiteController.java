package com.authenticate.authenticate.controller;

import com.authenticate.authenticate.dtos.RequestLoginDTO;
import com.authenticate.authenticate.dtos.UserDTO;
import com.authenticate.authenticate.entity.SiteKeep;
import com.authenticate.authenticate.entity.UserAuthe;
import com.authenticate.authenticate.service.BioService;
import com.authenticate.authenticate.service.SiteService;
import com.authenticate.authenticate.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SiteController {

    @NonNull
    SiteService siteService;

//    @PostMapping("/user")
//    public ResponseEntity<String> addUser(@RequestBody UserDTO userDTO){
//        System.out.println(userDTO);
//        String redirectUrl = "Good";
//        if (userService.addUser(userDTO))
//            return ResponseEntity.ok(redirectUrl);
//        else
//            return ResponseEntity.badRequest().build();
//    }

    @GetMapping("/sites")
    public ResponseEntity<List<SiteKeep>> findAllSites(){
        List<SiteKeep> users = siteService.findAllSites();
        if (users != null)
            return ResponseEntity.ok(users);
        else
            return ResponseEntity.badRequest().build();
    }
}
