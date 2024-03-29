package com.sample.login.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * match with the JPA Entity and the table name is given
 * JPA is an ORM concept
 * JPA is a specification of ORM
 */
@Entity
@Table(name = "user")
public class Login {
    @Column
    @Id
    private Integer id;
    @Column(name = "userName")
    private String username;
    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
