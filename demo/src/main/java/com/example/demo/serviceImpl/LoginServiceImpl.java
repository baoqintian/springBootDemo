package com.example.demo.serviceImpl;

import com.example.demo.dao.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {


    private final UserRepository userRepository;

    LoginServiceImpl (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Map<String, String> isExistUser(String userName, String password) {
        //判断用户是否存在
        List<User> userList = userRepository.findAll();
        User u = userRepository.findOneByUserName(userName);
        Map<String, String> map = new HashMap<>();
        //如果用户存在判断用户的密码是否正确
        if (u != null && password.equals(u.getPassword())) {
            map.put("result","YES");
        }else if (u == null) {
            map.put("result","用户不存在！");
        }else {
            map.put("result","用户密码错误！");
        }

        return map;
    }
}

