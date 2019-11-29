package com.sample.login.repository.impl;

import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.JavaJDBC;

import java.sql.*;

public class JavaJDBCImpl implements JavaJDBC {

    public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/testapp";
    public final static String DB_USERNAME = "root";
    public final static String DB_PASSWORD = "1qaz2wsx@";

    private static final String FETCH_USER_BY_USERNAME_SQL = "select * from testapp.user where user.username=? AND password=?";

    @Override
    public UserDTO retrieveUser(String userName, String passWord) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        UserDTO user = null;
        try{
            con = this.getDBConnectionEstablished();
            stmt = con.createStatement();
            String query ="select * from testapp.user where user.username='"+userName +"' AND password='"+userName+"'";
            System.out.println(query);
            rs = stmt.executeQuery(query);

            while(rs.next()){
                user = new UserDTO();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println("Name="+rs.getString("username")+",password="+rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null) rs.close();
            stmt.close();
            con.close();
        }

        return user;
    }

    public Connection getDBConnectionEstablished() throws Exception {
        Connection con = null;

        // load the Driver Class
        Class.forName(DB_DRIVER_CLASS);

        // create the connection now
        con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        System.out.println("DB Connection created successfully");
        return con;

    }


}
