package com.example.demo.dao;

public class Book {

    private String auto;

    private String name;

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String auto, String name) {
        this.auto = auto;
        this.name = name;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "auto='" + auto + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

