package com.sample.login.repository;

import com.sample.login.entity.dto.BookDTO;
import com.sample.login.entity.dto.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface JavaJDBC {
    public UserDTO retrieveUser(String userName, String passWord) throws ClassNotFoundException, SQLException;

    public ArrayList<BookDTO> getAllbooksList() throws SQLException;

    public ArrayList<BookDTO> getbooksbyName(String name) throws SQLException;
}
