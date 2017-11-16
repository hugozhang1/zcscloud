package com.zcs.service.impl;

import com.zcs.domain.User;
import com.zcs.repository.UserRepositry;
import com.zcs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by hugo on 2017/9/26.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    CacheManager cacheManager;

    @Autowired
    private UserRepositry userRepositry;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User findUserById(Integer id) {

        return userRepositry.findOne(id);
    }

    @Override
    public List<User> findAllUser() {
        Collection<String> cacheNames   = cacheManager.getCacheNames();
        System.out.println(cacheNames);
        return userRepositry.findAll();
    }

    @Override
    @Cacheable(cacheNames={"users"},key = "#userName")
    public User findUserByName(String userName) {
         User users= userRepositry.findByUserName(userName);

             return  users;

    }

    @Override
    @CachePut(value={"users"},key="#user.getUserName()")// 更新accountCache 缓存
    public User addUser(User user) {

        return userRepositry.save(user);

    }
    /*@PostConstruct
    public void init(){
      if (cacheManager instanceof RedisCacheManager){
          RedisCacheManager redisCacheManager =(RedisCacheManager) cacheManager;
          redisCacheManager.setCacheNames(Arrays.asList("invoice:user"));

          Cache cache=     redisCacheManager.getCache("invoice:user");
       List<User> users=   this.findAllUser();
       for(User user:users){
          cache.put(user.getUserName(),user);
       }

      }
    }*/
}
