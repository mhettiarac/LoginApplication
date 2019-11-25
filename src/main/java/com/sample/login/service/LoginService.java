package com.sample.login.service;

import com.sample.login.entity.User;
import com.sample.login.entity.dto.UserDTO;

public interface LoginService {
    public Boolean authenticateUser(UserDTO user);
}
