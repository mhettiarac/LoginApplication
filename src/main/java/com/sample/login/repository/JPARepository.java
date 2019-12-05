package com.sample.login.repository;

import com.sample.login.entity.dto.UserDTO;

public interface JPARepository {

   public UserDTO insertWithQuery(UserDTO user);
}
