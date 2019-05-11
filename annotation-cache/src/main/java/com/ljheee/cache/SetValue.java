package com.ljheee.cache;

import java.lang.annotation.*;

/**
 * Created by lijianhua04 on 2019/5/11.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SetValue {

    Class<?> beanClass();
    String method();
    String paramField();// 调用哪个类的哪个方法，及其入参；取targetFiled属性

    String targetFiled();

}
