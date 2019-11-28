package com.sample.login.repository.impl;

import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.JDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JDBCRepositoryImpl implements JDBCRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String FETCH_USER_SQL = "select * from testapp.user where user.username='test'";
    private static final String FETCH_USER_BY_USERNAME_SQL = "select * from testapp.user where user.username=? AND password=?";

    @Override
    public List<UserDTO> retrieveUser() {
        return jdbcTemplate.query(FETCH_USER_SQL, (resultSet, i) -> extractUser(resultSet));
    }

    @Override
    public UserDTO retrieveSingleUser(String userName, String passWord) throws EmptyResultDataAccessException {
            return jdbcTemplate.queryForObject(FETCH_USER_BY_USERNAME_SQL, new Object[]{userName, passWord}, (resultSet, i) -> extractUser(resultSet));
    }


    private UserDTO extractUser(ResultSet resultSet) throws SQLException {
        UserDTO user = new UserDTO();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

}
