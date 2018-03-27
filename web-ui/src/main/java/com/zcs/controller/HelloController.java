package com.zcs.controller;

import com.zcs.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.applet.AppletContext;

/**
 * Created by hugo on 2017/11/16.
 */
@Controller
public class HelloController {

    @Autowired
    BeanFactory beanFactory;

    @Autowired
    UserService userService;

    @RequestMapping(value = "hello" ,method = RequestMethod.GET)
    public void hello(Model model){
       System.out.println(beanFactory.getClass());
        model.addAttribute("name","nihao");
        userService.findALL().stream().forEach(user -> {
            System.out.println(user.getUserName());
        });

    }

    @RequestMapping(value = "sayhello" ,method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        System.out.print(beanFactory.getClass());
        return "sayhello1";

    }
}
