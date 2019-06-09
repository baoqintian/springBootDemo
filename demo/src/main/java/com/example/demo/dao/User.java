package com.example.demo.dao;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    public User() {

    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String userName;

    @Column
    private int age;

    @Column
    private String password;

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setId(Integer id) {

        this.id = id;
    }


    public int getAge() {

        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}

