package com.zcs.controller;

import com.zcs.domain.User;
import com.zcs.model.ClosePOSTResponse;
import com.zcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by hugo on 2017/9/19.
 */

@RestController
public class HelloController {

    @Autowired
    UserService userService;


    @Value("${test.name}")
    String testName;

    @RequestMapping(value = "/testname",method= RequestMethod.GET)
    public String testname() {
        return testName;
    }

    @RequestMapping(value = "/users",method= RequestMethod.GET)
    public List<User> getALLUser() {
        return userService.findAllUser();
    }
    @RequestMapping(value = "/api/periods/close")
    public ClosePOSTResponse repose(){
        System.out.println("--------------------------" +
                "=================");
        return new ClosePOSTResponse("201709");
    }


}
