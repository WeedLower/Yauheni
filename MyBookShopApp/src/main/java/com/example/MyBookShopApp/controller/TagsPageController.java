package com.example.MyBookShopApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TagsPageController {
    @GetMapping("/tags/SLUG")
    public String tagsPage(){
        return "/tags/index";
    }
}
