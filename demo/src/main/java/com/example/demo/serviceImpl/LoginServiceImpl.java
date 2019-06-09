package com.example.demo.serviceImpl;

import com.example.demo.dao.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param userName: 登入人姓名
     * @param password: 登入人密码
     * @return YES 登入成功
     */
    @Override
    public Map<String, String> isExistUser(String userName, String password) {
        //判断用户是否存在
        User u = userRepository.findOneByUserName(userName);
        Map<String, String> map = new HashMap<>();

        //如果用户存在判断用户的密码是否正确
        if (u == null) {
            map.put("result","用户不存在！");
        }else if (u != null && password.equals(u.getPassword())) {
            map.put("result","YES");

        }else {
            map.put("result","用户密码错误！");
        }

        return map;
    }

    /**
     * 注册用户 抛出异常则事务回滚
     * @param userName : 用户名
     * @param password 用户密码
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> registerUser(String userName, String password) throws Exception{
        //判断用户是否存在
        User u = userRepository.findOneByUserName(userName);
        Map<String, String> map = new HashMap<>();

        try {
            //如果用户存在判断用户的密码是否正确
            if (u != null) {
                map.put("result","用户已经存在！");
            }else  {
                User user = new User();
                user.setUserName(u.getUserName());
                user.setPassword(u.getPassword());
                userRepository.save(user);
                map.put("result","YES");
            }
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return map;
    }
}

