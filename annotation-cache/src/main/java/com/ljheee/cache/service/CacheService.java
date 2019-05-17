package com.ljheee.cache.service;

import com.ljheee.cache.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 */
@Component
public class CacheService {

    private Map<String, User> map = new HashMap<>();


    @PostConstruct
    public void post() {
        map.put("10002", new User(10001, "abc", "123", "appid"));
    }

    public User getCacheUser(String uid) {
        User user = map.get(uid);
        return user;
    }

    public void putCacheUser(String uid, User user) {
        map.put(uid, user);
    }
}
