package com.example.MyBookShopApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SigninRegisteryController {

    @GetMapping("/signin")
    public String signinPage(){
        return "/signin";
    }
    @GetMapping("/signup")
    public String registaryPage(){
        return "/signup";
    }
}
