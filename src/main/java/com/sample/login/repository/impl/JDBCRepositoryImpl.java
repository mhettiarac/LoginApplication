package com.sample.login.repository.impl;

import com.sample.login.entity.dto.LoginDTO;
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
    public List<LoginDTO> retrieveUser() {
        return jdbcTemplate.query(FETCH_USER_SQL, (resultSet, i) -> extractUser(resultSet));
    }

    @Override
    public LoginDTO retrieveSingleUser(String userName, String passWord) throws EmptyResultDataAccessException {
            return jdbcTemplate.queryForObject(FETCH_USER_BY_USERNAME_SQL, new Object[]{userName, passWord}, (resultSet, i) -> extractUser(resultSet));
    }

    @Override
    public int insertWithJDBCQuery(UserDTO user) {
        return jdbcTemplate.update(
                "INSERT INTO user (firstName, lastName, email, userName,password) VALUES (?, ?,?,?,?)",user.getFirstName(),user.getLastName(),user.getEmail(),user.getUserName(),user.getPassword());
    }


    private LoginDTO extractUser(ResultSet resultSet) throws SQLException {
        LoginDTO user = new LoginDTO();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }

}
