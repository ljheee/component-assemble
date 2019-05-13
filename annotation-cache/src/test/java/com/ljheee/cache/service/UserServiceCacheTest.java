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
    public void test(){
//       userDAO.getUserList().stream().forEach(System.out::println);
       userService.queryOrders(10).stream().forEach(System.out::println);
   }



}
