package com.zcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hugo on 2017/11/16.
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String sayHello(){
        return "hello";
    }
}
