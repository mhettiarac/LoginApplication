package com.sample.login.repository;

import com.sample.login.entity.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface JavaJDBC {
    public UserDTO retrieveUser(String userName, String passWord) throws ClassNotFoundException, SQLException;
}
