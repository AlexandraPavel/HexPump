package com.innovation.hexpump.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllerSimple {
    @GetMapping("/profile")
    public String getProfile() {
        return "profile";
    }
    @GetMapping("/verifyIdentity")
    public String getVerifyIdentity() {
        return "verifyIdentity";
    }
    @GetMapping("/registerIdentity")
    public String getRegisterIdentity() {
        return "registerIdentity";
    }
}
