package com.zcs.controller;

import com.zcs.domain.User;
import com.zcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hugo on 2017/9/26.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @Value("${test.name}")
    String testName;


    /**
     * 查询所有用户
     * @return 用户
     */
    @RequestMapping(value = "/users",method= RequestMethod.GET)
    public List<User> getALLUser() {
        return userService.findAllUser();
    }
}
