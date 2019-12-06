package com.sample.login.repository.impl;

import com.sample.login.entity.dto.BookDTO;
import com.sample.login.entity.dto.LoginDTO;
import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.JavaJDBC;

import java.sql.*;
import java.util.ArrayList;

public class JavaJDBCImpl implements JavaJDBC {

    public final static String DB_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://testapp.ctob98wau1er.us-east-2.rds.amazonaws.com:3306/testapp";
    public final static String DB_USERNAME = "admin";
    public final static String DB_PASSWORD = "1qaz2wsx";

    private static final String FETCH_USER_BY_USERNAME_SQL = "select * from testapp.user where user.username=? AND password=?";

    @Override
    public LoginDTO retrieveUser(String userName, String passWord) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        LoginDTO user = null;
        try{
            con = this.getDBConnectionEstablished();
            stmt = con.createStatement();
            String query ="select user.userName,user.password from testapp.user where user.username='"+userName +"' AND password='"+passWord+"'";
            System.out.println(query);
            rs = stmt.executeQuery(query);

            while(rs.next()){
                user = new LoginDTO();
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

    public ArrayList<BookDTO> getAllbooksList() throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<BookDTO> books = null;
        BookDTO book = null;
        try{
            con = this.getDBConnectionEstablished();
            stmt = con.createStatement();
            String query ="select * from testapp.books";
            System.out.println(query);
            rs = stmt.executeQuery(query);
            books = new ArrayList<>();
            while(rs.next()){
                book= new BookDTO();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setType(rs.getString("format"));
                book.setPrice(Double.parseDouble(rs.getString("price")));
                books.add(book);
            }
            //test
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null) rs.close();
            stmt.close();
            con.close();
        }

        return books;
    }

    @Override
    public ArrayList<BookDTO> getbooksbyName(String name) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<BookDTO> books = null;
        BookDTO book = null;
        try{
            con = this.getDBConnectionEstablished();
            stmt = con.createStatement();
            String query ="SELECT * FROM testapp.books where title LIKE '%"+name+"%'";
            System.out.println(query);
            rs = stmt.executeQuery(query);
            books = new ArrayList<>();
            while(rs.next()){
                book= new BookDTO();
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setType(rs.getString("format"));
                book.setPrice(Double.parseDouble(rs.getString("price")));
                books.add(book);
            }
            //test
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(rs != null) rs.close();
            stmt.close();
            con.close();
        }

        return books;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws SQLException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        LoginDTO user = null;
        try{
            con = this.getDBConnectionEstablished();
            stmt = con.createStatement();
            String query="INSERT INTO testapp.user ( user.firstName, user.lastName, user.email, user.userName, user.password) " +
            "VALUES ('"
                    +userDTO.getFirstName()+"', '"
                    +userDTO.getLastName()+"', '"
                    +userDTO.getEmail()+"', '"
                    +userDTO.getUserName()+"', '"
                    +userDTO.getPassword()+"')";
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (Exception e) {
            return null;
        } finally{
            if(rs != null) rs.close();
            stmt.close();
            con.close();
        }

        return userDTO;
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

