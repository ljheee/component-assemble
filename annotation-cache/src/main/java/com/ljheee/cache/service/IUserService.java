package com.ljheee.cache.service;

import com.ljheee.cache.entity.Order;

import java.util.List;

/**
 * Created by lijianhua04 on 2019/5/11.
 */

public interface IUserService {
    public List<Order> queryOrders(Integer uid);


}
