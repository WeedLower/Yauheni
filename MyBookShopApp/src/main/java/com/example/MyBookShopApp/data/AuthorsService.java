package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.book.Author;
import com.example.MyBookShopApp.data.struct.book.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public AuthorsService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Map<String, List<Author>> getAuthorMap() {
        return authorRepository.findAll().stream().collect(Collectors.groupingBy((Author a)-> {return a.getLastName().substring(0,1);}));
    }

    public Author getAuthor(Integer id){
        return authorRepository.findById(id).get();
    }

    public List<Book> getBookAuthor(Integer authorId){
        return bookRepository.findBooksByAuthor_Id(authorId);
    }
}
