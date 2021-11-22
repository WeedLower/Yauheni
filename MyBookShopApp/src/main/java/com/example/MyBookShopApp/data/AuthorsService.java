package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, List<Author>> getAuthorMap() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors",(ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;

        });
        return authors.stream().collect(Collectors.groupingBy((Author a)-> {return a.getLastName().substring(0,1);}));
    }
     public Author getAuthor(Integer id){
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors WHERE ID",((ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setBiography(rs.getString("biography"));
            author.setPhoto(rs.getString("photo"));
            return author;
        }));
        Author author=authors.get(id-1);
        return author;
     }


    public List<Book> getBookAuthor(Integer authorId){
        List<Book> books = jdbcTemplate.query("SELECT books.id, books.title, books.priceold, books.price, authors.first_name, authors.last_name\n" +
                "FROM books LEFT JOIN authors \n" +
                "ON books.author = authors.Id",(ResultSet rs, int rowNum) -> {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("authors.first_name")+" "+rs.getString("authors.last_name"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });

        return books.stream().filter(book -> book.getId().equals(authorId)).collect(Collectors.toList());
    }
}
