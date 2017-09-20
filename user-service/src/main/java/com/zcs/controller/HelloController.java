package com.zcs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hugo on 2017/9/19.
 */

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Value("${test.name}")
    String testName;

    @RequestMapping(value = "/testname",method= RequestMethod.GET)
    public String testname() {
        return testName;
    }
}
