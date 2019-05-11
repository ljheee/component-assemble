package com.ljheee.cache.entity;


import com.ljheee.cache.SetValue;
import com.ljheee.cache.dao.UserDAO;

import java.io.Serializable;

/**
 * 复合对象，包含订单信息，和用户信息
 */
public class Order implements Serializable {


    private Integer id;
    private Integer uid;

    // 标识：userName属性值，从UserDAO.getUserById(uid) 得到的对象name属性获取
    @SetValue(beanClass = UserDAO.class, method = "getUserById", paramField = "uid", targetFiled = "name")
    private String userName;

    public Order() {
    }

    public Order(Integer id, Integer uid, String userName) {
        this.id = id;
        this.uid = uid;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                '}';
    }
}
