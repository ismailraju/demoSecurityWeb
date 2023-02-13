package com.example.demoSecurityWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
    @GetMapping("/login")
    String login() {
        return "login";
    }

    @GetMapping("/hello")
    String hello() {
        return "hello";
    }

    @GetMapping(value = {"/", "/home"})
    String home() {
        return "home";
    }
}