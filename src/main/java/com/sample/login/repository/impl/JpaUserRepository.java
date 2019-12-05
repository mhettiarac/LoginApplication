package com.sample.login.repository.impl;

import com.sample.login.entity.dto.UserDTO;
import com.sample.login.repository.JPARepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class JpaUserRepository implements JPARepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public UserDTO insertWithQuery(UserDTO user) {
        try {
            entityManager.persist(user);
        }catch (Exception e){
            return null;
        }
        return user;
    }
}
