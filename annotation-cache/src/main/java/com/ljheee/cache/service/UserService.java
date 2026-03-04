package com.ljheee.cache.service;

import com.ljheee.cache.UsingCache;
import com.ljheee.cache.dao.UserDAO;
import com.ljheee.cache.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lijianhua04 on 2019/5/11.
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @UsingCache(key = "#uid", cacheName = "c-cn")
    public User queryUser(Integer uid) {
        User user = userDAO.getUserById(uid);
        return user;
    }



}
