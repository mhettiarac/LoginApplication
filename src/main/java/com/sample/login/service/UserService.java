package com.sample.login.service;

import com.sample.login.entity.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService  {

    ResponseEntity<String> createUser(UserDTO userDTO);

    ResponseEntity<String> insertUserthrouJPA(UserDTO userDTO);
}
