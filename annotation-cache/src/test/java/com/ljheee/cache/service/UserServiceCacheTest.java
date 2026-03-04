package com.ljheee.cache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")
public class UserServiceCacheTest {

    @Autowired(required = false)
    private UserService userService;


    @Test
    public void testCache() {
        System.out.println(userService.queryUser(10));
        System.out.println(userService.queryUser(10));//第二次 走缓存
    }


}
