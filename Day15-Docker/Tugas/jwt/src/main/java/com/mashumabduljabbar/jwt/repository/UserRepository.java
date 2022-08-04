package com.mashumabduljabbar.jwt.repository;
import org.springframework.data.repository.CrudRepository;

import com.mashumabduljabbar.jwt.model.UserDao;
public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByPhone(String phone);
}