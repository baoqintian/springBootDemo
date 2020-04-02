package com.example.demo.controller;

import com.example.demo.dao.User2;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CacheConfig(cacheNames = "emp", cacheManager = "myCacheManager")
@RestController
public class UserController {
    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User2 getUser() {
        User2 user = new User2("aa@126.com", "aa", "aa123456", "aa", "123");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

}

