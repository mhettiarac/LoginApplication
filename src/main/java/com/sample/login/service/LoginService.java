package com.sample.login.service;

import com.sample.login.entity.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;

public interface LoginService {
    public ResponseEntity<String> authenticateUserthrouJPA(UserDTO user);
    public ResponseEntity<String> authenticateUser(UserDTO user);
    public ResponseEntity<String> authenticateSingleUser(UserDTO payloadUser);
    public ResponseEntity<String> authenticateUserthrouSQL(UserDTO user) throws SQLException, ClassNotFoundException;
}
