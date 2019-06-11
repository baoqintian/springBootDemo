package com.example.demo.service;

import com.example.demo.dao.User;

import java.util.List;
import java.util.Map;

public interface LoginService {
    /**
     * @param userName: 登入人姓名
     * @param password: 登入人密码
     * @return YES 登入成功
     */
    Map<String, String> isExistUser(String userName, String password);

    /**
     * 注册用户
     * @param userName: 用户名
     * @param password  用户密码
     * @return
     */
    Map<String, String> registerUser(String userName, String password)  throws Exception;

    /**
     * 测试缓存
     * @return
     */
    List<User> findAll();
}

