package com.example.MyBookShopApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenresPageController {

    @GetMapping("/genres")
    public String genresPage(){
        return "/genres/index";
    }

    @GetMapping("genres/SLUG")
    public String genresSlugPage(){
        return "genres/slug";
    }

}
