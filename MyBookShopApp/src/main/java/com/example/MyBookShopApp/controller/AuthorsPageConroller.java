package com.example.MyBookShopApp.controller;

import com.example.MyBookShopApp.data.struct.book.Author;
import com.example.MyBookShopApp.data.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorsPageConroller {

    private final AuthorsService authorsService;

    @Autowired
    public AuthorsPageConroller(AuthorsService authorsService){
        this.authorsService=authorsService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap(){
        return authorsService.getAuthorMap();
    }

    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }

    @RequestMapping(value = "/SLUG", method = RequestMethod.GET)
    public String authorId(@RequestParam(name = "id") Integer id,Model model){
        Author author=authorsService.getAuthor(id);
        author.setBookList(authorsService.getBookAuthor(id));
        model.addAttribute("books",author.getBooks());
        model.addAttribute("id",author.getId());
        model.addAttribute("lastname",author.getLastName());
        model.addAttribute("firstname",author.getFirstName());
        model.addAttribute("biography",author.getDescription());
        model.addAttribute("photo",author.getPhoto());
        return "/authors/slug";
    }
}
