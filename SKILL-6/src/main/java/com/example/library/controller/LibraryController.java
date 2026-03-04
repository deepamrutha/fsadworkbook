
package com.example.library.controller;

import org.springframework.web.bind.annotation.*;
import com.example.library.model.Book;

import java.util.*;

@RestController
public class LibraryController {

    private List<Book> bookList = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    @GetMapping("/count")
    public int totalBooks() {
        return 100;
    }

    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    @GetMapping("/books")
    public List<String> getBooks() {
        return Arrays.asList("Spring Boot Guide", "Java Fundamentals", "Clean Code");
    }

    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Showing details for Book ID: " + id;
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Search request received for book title: " + title;
    }

    @GetMapping("/author/{name}")
    public String authorName(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully: " + book.getTitle();
    }

    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
