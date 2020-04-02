package com.example.demo.repository;

import com.example.demo.dao.Person;
import com.example.demo.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Integer> {


    Person findOneByName(String name);

    void findAllByName(String name);
}
