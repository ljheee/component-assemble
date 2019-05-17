package com.ljheee.cache;

import com.ljheee.cache.entity.User;
import com.ljheee.cache.service.CacheService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Collection;


/**
 * <aop:aspectj-autoproxy/>
 * 针对于 类，不能实现接口或继承
 */
@Component
@Aspect
public class CacheAspect {


    @Autowired
    CacheService cacheService;

    @Around("@annotation(usingCache)")
    public Object doCache(ProceedingJoinPoint pjp, UsingCache usingCache) throws Throwable {
        System.out.println("======doCache");

        Object[] args = pjp.getArgs();
        System.out.println(args[0]);
        String key = getKey(usingCache.key(), pjp);//把#id  换成uid
        System.out.println("uid====" + key);

        User cache = cacheService.getCacheUser(key);
        if(cache != null){
            System.out.println("get from cache====" + cache);
            return cache;
        }

        Object ret = pjp.proceed();
        cacheService.putCacheUser(key,(User)ret);

        return ret;
    }

    /**
     * Spel 解析入参
     * 也可以用 pjp.getArgs()[0]准确获取第一个参数，单数参数改变还要改
     * @param key
     * @param pjp
     * @return
     */
    private String getKey(String key, ProceedingJoinPoint pjp) {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = discoverer.getParameterNames(method);
        return SpelParser.getKey(key, parameterNames, pjp.getArgs());
    }
}
