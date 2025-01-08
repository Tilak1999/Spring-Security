package com.learnjava.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("hello")
    public String welcome(){
        return "Welcome to Spring Security 6";
    }
}
