package com.finance.common.aop;


import com.finance.common.annotation.MyCacheEvict;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * 清空缓存，自带的好像也可以用
 */
@Aspect
@Component
@Order(99999999)
public class MyCacheEvictAspect {


    @Resource
    RedisTemplate<Object,Object> redisTemplate;

    @Pointcut("@annotation(com.finance.common.annotation.MyCacheEvict)")
    public void evict(){}


    /**
     * 代替原注解清空缓存
     * @param joinPoint
     */
    @After(value = "evict()")
    public void  afterReturning(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        MyCacheEvict myCacheEvict = signature.getMethod().getAnnotation(MyCacheEvict.class);
        String[] strings = myCacheEvict.cacheNames();
        Object arg = joinPoint.getArgs()[0];
        if(!(arg instanceof Integer)){
            throw new RuntimeException("第一个参数应该是整型");
        }
        for (String cacheName : strings) {
            redisTemplate.delete(cacheName+"::"+arg);
            System.out.println(cacheName+"::"+arg+" 被删除");
        }
    }
}
