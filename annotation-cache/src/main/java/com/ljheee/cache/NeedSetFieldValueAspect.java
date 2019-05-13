package com.ljheee.cache;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;


/**
 *
 * <aop:aspectj-autoproxy/>
 * 针对于 类，不能实现接口或继承
 */
@Component
@Aspect
public class NeedSetFieldValueAspect {

    @Autowired(required = false)
    BeanUtil beanUtil;

    @Around("@annotation(com.ljheee.cache.NeedSetFieldValue)")
    public Object doSetValue(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("======doSetValue");
        Object ret = pjp.proceed();
        if(ret instanceof Collection){
            beanUtil.setFieldValue4Collection((Collection) ret);
        }
        return ret;
    }
}
