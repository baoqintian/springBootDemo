package com.example.demo.service;

import java.util.Map;

public interface LoginService {
    /**
     *
     * @param userName
     * @param password
     * @return
     */
    Map<String, String> isExistUser(String userName, String password);
}

