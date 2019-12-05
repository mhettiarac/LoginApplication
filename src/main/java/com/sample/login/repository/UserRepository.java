package com.sample.login.repository;

import com.sample.login.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Login, Integer> , JDBCRepository, JavaJDBC {
    /**
     * entity,primary key data type
     **/
    Login findByUsername(String username);

    Login findByPassword(String password);

}
