package com.example.demo.controller;

import com.example.demo.dao.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    登入注册接口
* @Author:         zgf
* @CreateDate:     2019/5/26 19:28
* @UpdateUser:     zgf
* @UpdateDate:     2019/5/26 19:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class Login {


   @Autowired
   LoginService loginService;



    @GetMapping("/test")
    public String login (HttpServletRequest request) {
        System.out.println("aaaa");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Map<String,String> mapRuslt = loginService.isExistUser(userName,password);
//        if ("YES".equals(mapRuslt.get("result"))) {
//            session.setAttribute("loginUser",userName);
//            return "/hello";
//        }


        return null;
    }
}

