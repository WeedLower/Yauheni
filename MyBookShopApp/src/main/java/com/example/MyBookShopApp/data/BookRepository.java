package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findBooksByAuthor_Id(Integer id);
//    List<Book> findBooksByAuthor_FirstName(String name);
//
//    @Query("from Book")
//    List<Book> customFindAllBooks();
}
