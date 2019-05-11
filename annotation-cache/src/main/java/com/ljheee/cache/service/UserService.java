package com.ljheee.cache.service;

import com.ljheee.cache.NeedSetFieldValue;
import com.ljheee.cache.dao.UserDAO;
import com.ljheee.cache.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijianhua04 on 2019/5/11.
 */
@Service
public class UserService  {

    @Autowired
    private UserDAO userDAO;


    @NeedSetFieldValue
    public List<Order> queryOrders(Integer uid){
        List<Order> orders = new ArrayList<>();

        // Order包含订单信息，和用户信息

        // 查询Order信息
        Order order = new Order();
        order.setId(111);
        order.setUid(uid);
        orders.add(order);

        //查询 对应的用户name ，交给注解完成

        return orders;

    }




}
