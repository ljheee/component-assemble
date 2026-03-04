package com.ljheee.cache;

import java.lang.annotation.*;

/**
 * 缓存注解
 * 有缓存时走缓存，没缓存时查表后设置缓存
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface UsingCache {

    //缓存key
    String key();

    //缓存存储的区域（用于缓存隔离）
    String cacheName();
}
