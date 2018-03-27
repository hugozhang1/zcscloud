package com.zcs.service;

import com.zcs.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by hugo on 2017/11/20.
 */
@FeignClient(value = "USER-SERVICE",fallback = UserServiceFallback.class)
public interface UserService {


    @RequestMapping(value = "/users",method = RequestMethod.GET)
    List<User> findALL();
}
