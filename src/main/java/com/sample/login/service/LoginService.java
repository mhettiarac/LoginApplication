package com.sample.login.service;

import com.sample.login.entity.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface LoginService {
    public ResponseEntity<String> authenticateUser(UserDTO user);
    public ResponseEntity<String> authenticateSingleUser(UserDTO payloadUser);
}
