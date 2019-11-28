package com.sample.login.repository;


import com.sample.login.entity.dto.UserDTO;

import java.util.List;

public interface JDBCRepository {

    public List<UserDTO> retrieveUser();

    public UserDTO retrieveSingleUser(String userName, String passWord) ;

}
