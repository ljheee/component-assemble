package com.ljheee.app.service;

import com.ljheee.app.NeedSetFieldValue;
import com.ljheee.app.dao.UserDAO;
import com.ljheee.app.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lijianhua04 on 2019/5/11.
 */

public interface IUserService {
    public List<Order> queryOrders(Integer uid);


}
