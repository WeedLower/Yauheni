package com.example.MyBookShopApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtherElementsPage {
    @GetMapping("/documents")
    public String documentsPage(){
        return "/documents/index";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "/about";
    }
    @GetMapping("/faq")
    public String faqPage(){
        return "/faq";
    }
    @GetMapping("/contact")
    public String contactPage(){
        return "/contacts";
    }
    @GetMapping("/postponed")
    public String postponedPage(){
        return "/postponed";
    }
    @GetMapping("/profile")
    public String profilePage(){
        return "/profile";
    }
}
