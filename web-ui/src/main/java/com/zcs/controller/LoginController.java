package com.zcs.controller;

import com.zcs.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.cglib.core.CollectionUtils.filter;

/**
 * Created by hugo on 2017/11/16.
 */
@Controller
public class LoginController {

    @GetMapping(value = "login")
    public void Login(User user) {

    }

    @PostMapping(value = "login")
    public void doLogin(User user) {
         new  Thread (()->System.out.print("你好1")).start();

        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

        System.out.println("Languages which starts with J :");

        features.stream().filter(s ->{
           return s.startsWith("L")&&s.endsWith("s");}
        ).collect(Collectors.toList());

                System.out.print("你好2");

    }


}
