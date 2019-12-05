package com.sample.login.repository;


import com.sample.login.entity.dto.LoginDTO;
import com.sample.login.entity.dto.UserDTO;

import java.util.List;

public interface JDBCRepository {

    public List<LoginDTO> retrieveUser();

    public LoginDTO retrieveSingleUser(String userName, String passWord) ;

    public int insertWithJDBCQuery(UserDTO user);

}
