package com.zcs.repository;

import com.zcs.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hugo on 2017/9/21.
 */
public interface UserRepositry extends JpaRepository<User,Integer> {

     public User findByUserName(String userName);
}
