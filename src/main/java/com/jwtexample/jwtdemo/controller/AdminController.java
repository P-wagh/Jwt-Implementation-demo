package com.jwtexample.jwtdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    
    @GetMapping("/test")
    public String getMethodName() {
        return "this is form the ADMIN";
    }
    
}
