package com.jwtexample.jwtdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/home")
public class HomeController {
    
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to jwtDemo";
    }
    
}
