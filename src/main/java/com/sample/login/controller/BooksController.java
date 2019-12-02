package com.sample.login.controller;

import com.sample.login.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<String> getAllBooks(){
        return booksService.getAllBooksList();
    }

    @GetMapping("/books/search")
    public ResponseEntity<String> getSearchedBooks(@RequestParam(value="name", defaultValue="") String name){
        return booksService.getSpecificBook(name);
    }
}
