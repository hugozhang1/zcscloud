package com.zcs.service;


import com.zcs.WebApplication;
import com.zcs.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hugo on 2017/11/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void findALL() throws Exception {
        userService.findALL().stream().forEach(System.out::print);
    }

}