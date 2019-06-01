package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* @Description:    通过controller访问到html
* @Author:         zgf
* @CreateDate:     2019/5/26 18:54
* @UpdateUser:     zgf
* @UpdateDate:     2019/5/26 18:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello() {
        return "index";
    }

}
