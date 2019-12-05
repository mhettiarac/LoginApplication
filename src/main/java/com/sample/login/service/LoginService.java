package com.sample.login.service;

import com.sample.login.entity.dto.LoginDTO;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;

public interface LoginService {
    public ResponseEntity<String> authenticateUserthrouJPA(LoginDTO user);
    public ResponseEntity<String> authenticateUser(LoginDTO user);
    public ResponseEntity<String> authenticateSingleUser(LoginDTO payloadUser);
    public ResponseEntity<String> authenticateUserthrouSQL(LoginDTO user) throws SQLException, ClassNotFoundException;
}
