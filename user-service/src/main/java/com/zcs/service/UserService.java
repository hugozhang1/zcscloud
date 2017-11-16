package com.zcs.service;

import com.zcs.domain.User;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * Created by hugo on 2017/9/26.
 */
public interface UserService {

    User findUserById(Integer id);

    List<User> findAllUser();

    User findUserByName(String userName);

    /**
     * 添加一个用户
     * @param user 用户
     * @return 返回添加的的用户
     */
    User addUser(User user);


}

