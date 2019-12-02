package com.sample.login.service;

import org.springframework.http.ResponseEntity;

public interface BooksService {

    public ResponseEntity<String> getAllBooksList();
    public ResponseEntity<String> getSpecificBook(String name);
}
