package com.sample.login.repository;

import com.sample.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * entity,primary key data type
     **/
    User findByUsername(String username);

    User findByPassword(String password);
}
