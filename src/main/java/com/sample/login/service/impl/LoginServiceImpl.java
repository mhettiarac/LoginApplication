package com.sample.login.service.impl;

import com.sample.login.entity.User;
import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.UserRepository;
import com.sample.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean authenticateUser(UserDTO user) {
        User storedUser = null;
        storedUser = userRepository.findByUsername(user.getUsername());
        if (storedUser != null) {
            if (storedUser.getUsername().equals(user.getUsername()) && storedUser.getPassword().equals(user.getPassword())) {
                return true;
            }
        } else return false;
        return false;
    }
}
