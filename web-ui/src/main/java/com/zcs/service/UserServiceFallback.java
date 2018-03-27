package com.zcs.service;

import com.zcs.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugo on 2017/11/20.
 */
@Component
public class UserServiceFallback implements UserService{
    @Override
    public List<User> findALL() {

        User user = new User();
        user.setUserName("123132132");
        List list =new ArrayList();
        list.add(user);
        return list;
    }
}
