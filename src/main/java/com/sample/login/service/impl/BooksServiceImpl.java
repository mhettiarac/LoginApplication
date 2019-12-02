package com.sample.login.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sample.login.entity.dto.BookDTO;
import com.sample.login.repository.UserRepository;
import com.sample.login.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<String> getAllBooksList() {
        ArrayList<BookDTO> booksDTO=null;
        HashMap<String,Object> allbooks=new HashMap<>();
        JsonArray array = new JsonArray();
        Gson gson = new Gson();
        String json=null;
        try {
            booksDTO = userRepository.getAllbooksList();
            for(BookDTO b:booksDTO){
                array.add(new JsonParser().parse(gson.toJson(b,BookDTO.class)).getAsJsonObject());
            }
            allbooks.put("books",array);
            json = gson.toJson(allbooks);
        } catch (Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<String> ("No books fond in records", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (booksDTO != null) {
            return new ResponseEntity<String> (json, HttpStatus.OK);
        }
        return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<String> getSpecificBook(String name) {
        ArrayList<BookDTO> booksDTO=null;
        HashMap<String,Object> allbooks=new HashMap<>();
        JsonArray array = new JsonArray();
        Gson gson = new Gson();
        String json=null;
        try {
            booksDTO = userRepository.getbooksbyName(name);
            for(BookDTO b:booksDTO){
                array.add(new JsonParser().parse(gson.toJson(b,BookDTO.class)).getAsJsonObject());
            }
            allbooks.put("books",array);
            json = gson.toJson(allbooks);
        } catch (Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<String> ("No books fond in records", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (booksDTO != null) {
            return new ResponseEntity<String> (json, HttpStatus.OK);
        }
        return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
    }

}
