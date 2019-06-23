package com.example.demo.controller;

import com.example.demo.dao.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
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
//若返回json等内容到页面，则需要加@ResponseBody注解;@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RestController
@RequestMapping(value = "/api")
public class Login {

    private final Logger log = LoggerFactory.getLogger(Login.class);

    private final LoginService loginService;

    public Login(LoginService loginService) {
        this.loginService = loginService;
    }


    /**
     * POST /login  登入验证
     * @param map: 登入验证信息
     *           userName: 登入人姓名
     *           password: 登入人密码
     * @param session 登入信息正确把登入人信息放在session中
     * @return result
     *             YES 登入成功
     */
    @PostMapping("/login")
    public Map<String, String> login (@RequestBody Map<String, String> map, HttpSession session) {
        String userName = map.get("userName");
        String password = map.get("password");
        Map<String,String> mapResult = null;
        try {
            mapResult = loginService.isExistUser(userName,password);
            if (mapResult.get("result").equals("YES")) {
                session.setAttribute("userName",userName);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //返回验证结果
        return mapResult;
    }

    /**
     * @POST /register 注册用户
     * @param map
     *            userName: 注册人姓名
     *            password: 注册人密码
     * @return result
     *              YES: 注册成功
     */
    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> map) {
        String userName = map.get("userName");
        String password = map.get("password");
        Map<String,String> mapResult = null;
        try {
            mapResult = loginService.registerUser(userName,password);
            if (mapResult.get("result").equals("YES")) {
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        //返回验证结果
        return mapResult;
    }

    /**
     * 测试缓存
     * @return
     */

    @GetMapping("test/{id}")
    public List<User> findAll() {
        return loginService.findAll();
    }

    /**
     * @CachePut 既可以调用方法、又可以更新缓存
     * @param id
     * @return
     */

    /**
     *
     * @CacheEvict要求指定一个或多个缓存，使之都受影响。此外，还提供了一个额外的参数allEntries 。
     * 表示是否需要清除缓存中的所有元素。默认为false，表示不需要。
     * 当指定了allEntries为true时，Spring Cache将忽略指定的key。有的时候我们需要Cache一下清除所有的元素。
     */


}

