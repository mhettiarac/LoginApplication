package com.sample.login.controller;

import com.sample.login.entity.dto.LoginDTO;
import com.sample.login.entity.dto.UserDTO;
import com.sample.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * convert the class into a rest endpoint
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> doLogin(@RequestBody UserDTO userDTO){
        return userService.insertUserthrouJPA(userDTO);
    }

}
