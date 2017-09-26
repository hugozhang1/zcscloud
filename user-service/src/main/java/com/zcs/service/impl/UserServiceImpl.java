package com.zcs.service.impl;

import com.zcs.domain.User;
import com.zcs.repository.UserRepositry;
import com.zcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hugo on 2017/9/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public User findUserById(Integer id) {

        return userRepositry.findOne(id);
    }

    @Override
    public List<User> findAllUser() {
        return userRepositry.findAll();
    }

    @Override
    public User findUserByName(String userName) {
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepositry.save(user);

    }
}
