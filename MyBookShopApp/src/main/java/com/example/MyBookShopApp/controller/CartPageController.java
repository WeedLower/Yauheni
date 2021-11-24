package com.example.MyBookShopApp.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartPageController {
    @GetMapping("/cart")
    public String catrPage(){
        return "cart";
    }
}
