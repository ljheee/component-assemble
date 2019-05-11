package com.ljheee.cache.dao;


import com.ljheee.cache.entity.User;

import java.util.List;

/**
 * Created by lijianhua04 on 2018/7/18.
 */
public interface UserDAO {



    Integer addUser(User user);


    List<User> getUserList();
    public User getUserById(Integer id);

    Integer getUserCount();

    void deleteById(Integer id);
}
