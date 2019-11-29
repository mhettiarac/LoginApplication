package com.sample.login.service.impl;

import com.sample.login.entity.User;
import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.UserRepository;
import com.sample.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<String> authenticateUserthrouJPA(UserDTO user) {
        User storedUser = null;
        storedUser = userRepository.findByUsername(user.getUsername());
        if (storedUser != null) {
            if (storedUser.getUsername().equals(user.getUsername()) && storedUser.getPassword().equals(user.getPassword())) {
                return new ResponseEntity<String> ("Successfully logged in!", HttpStatus.OK);
            }
        } else return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<String> authenticateUser(UserDTO payloadUser) {
        List<UserDTO> userDTOS = userRepository.retrieveUser();
        if (userDTOS != null) {
            for (UserDTO u : userDTOS) {
                if (u.getUsername().equals(payloadUser.getUsername())
                        &&
                        u.getPassword().equals(payloadUser.getPassword())){
                   return new ResponseEntity<String> ("Successfully logged in!", HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<String> authenticateSingleUser(UserDTO payloadUser) {
        UserDTO userDTO=null;
        try {
            userDTO = userRepository.retrieveSingleUser(payloadUser.getUsername(), payloadUser.getPassword());
        } catch (EmptyResultDataAccessException e){
            System.out.println(e.getCause());
            return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
        }
        if (userDTO != null) {
                    return new ResponseEntity<String> ("Successfully logged in!", HttpStatus.OK);
        }
        return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<String> authenticateUserthrouSQL(UserDTO payloadUser) throws SQLException, ClassNotFoundException {
        UserDTO userDTO=null;
        try {
            userDTO = userRepository.retrieveUser(payloadUser.getUsername(), payloadUser.getPassword());
        } catch (Exception e){
            System.out.println(e.getCause());
            return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
        }
        if (userDTO != null) {
            return new ResponseEntity<String> ("Successfully logged in!", HttpStatus.OK);
        }
        return new ResponseEntity<String> ("Invalid User!", HttpStatus.UNAUTHORIZED);
    }
}
