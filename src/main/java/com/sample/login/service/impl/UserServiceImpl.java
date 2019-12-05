package com.sample.login.service.impl;

import com.sample.login.entity.User;
import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.UserRepository;
import com.sample.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> insertUserthrouJPA(UserDTO user) {
        Integer storedUser = null;
       storedUser = userRepository.insertWithJDBCQuery(user);
        if (storedUser == 1) {
            return new ResponseEntity<String>(user.getFirstName() +" "+user.getLastName()+" User successfully created!", HttpStatus.CREATED);
        }
        else return new ResponseEntity<String>("Sorry, can not create user!", HttpStatus.CONFLICT);

    }

    @Override
    public ResponseEntity<String> createUser(UserDTO payloadUser) {
        UserDTO addedUser;
        try {
            addedUser = userRepository.createUser(payloadUser);
        } catch (Exception e) {
            return new ResponseEntity<String>("User Can not be created!", HttpStatus.CONFLICT);
        }
        if (addedUser != null) {
            return new ResponseEntity<String>("New User Created as " + payloadUser.getUserName() + " " + payloadUser.getLastName() + " !", HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("Sorry!, This User Can not be created!", HttpStatus.CONFLICT);
    }
}
