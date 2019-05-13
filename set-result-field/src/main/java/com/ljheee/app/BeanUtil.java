package com.ljheee.app;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 */
@Component
public class BeanUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void setFieldValue4Collection(Collection ret) {
        try {

            if (CollectionUtils.isEmpty(ret)) {
                return;
            }

            // 获取返回结果类型clazz
            Class<?> clazz = ret.iterator().next().getClass();
            Field[] declaredFields = clazz.getDeclaredFields();

            //选择加了@SetValue的需要 set的属性值
            for (Field field : declaredFields) {
                if (field.isAnnotationPresent(SetValue.class)) {
                    SetValue annotation = field.getAnnotation(SetValue.class);
                    Class<?> beanClass = annotation.beanClass();
                    Object bean = applicationContext.getBean(beanClass);

                    String methodName = annotation.method();
                    String paramField = annotation.paramField();
                    String targetFiled = annotation.targetFiled();


                    // 通过方法名+参数类型获取方法(重载多个同名方法)
                    // 找到 UserDAO.getUserById(uid)方法
                    Method method = beanClass.getMethod(methodName, clazz.getDeclaredField(paramField).getType());
                    System.out.println(method);

                    //参数需要从 Order对象中getUid()
                    Method paramValueGetMethod = clazz.getMethod("get" + StringUtils.capitalize(paramField));

                    //给加了 @SetValue的字段设置值的方法 setUserName()
                    Method setValueMethod = clazz.getMethod("set" + StringUtils.capitalize(field.getName()), field.getType());


                    for (Object obj : ret) {
                        Object paramValue = paramValueGetMethod.invoke(obj);//从Order对象中 getUid()作为UserDAO.getUserById(uid)的参数
                        Object value = method.invoke(bean, paramValue);//UserDAO.getUserById(uid)返回 User对象

                        Method getTargetValueMethod = null;// 从UserDAO.getUserById(uid)返回的User对象中获取name，set到Order userName中
                        if (value != null) {
                            if (getTargetValueMethod == null) {
                                getTargetValueMethod = value.getClass().getMethod("get" + StringUtils.capitalize(targetFiled));
                            }
                            value = getTargetValueMethod.invoke(value);
                        }
                        setValueMethod.invoke(obj, value);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
