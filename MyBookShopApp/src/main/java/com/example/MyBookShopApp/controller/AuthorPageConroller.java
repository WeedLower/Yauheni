package com.example.MyBookShopApp.controller;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;
import java.util.Map;

@Controller
public class AuthorPageConroller {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorPageConroller(AuthorsService authorsService){
        this.authorsService=authorsService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap(){
        return authorsService.getAuthorMap();
    }

    @GetMapping("/authors")
    public String authorsPage(){
        return "author";
    }
}
