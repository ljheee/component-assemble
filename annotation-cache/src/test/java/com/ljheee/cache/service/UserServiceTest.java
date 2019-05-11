package com.ljheee.cache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lijianhua04 on 2019/5/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/*.xml")//去除DB
public class UserServiceTest {

    @Autowired(required = false)
    private UserService userService;


   @Test
    public void test(){
//       userDAO.getUserList().stream().forEach(System.out::println);
       userService.queryOrders(10).stream().forEach(System.out::println);
   }



}
