package com.example.demo.repository;

import com.example.demo.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface  UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();


    User findByUserNameAndPassword(String userName, String password);

    User findByUserName(String userName);

    User findOneByUserName(String userName);
}
