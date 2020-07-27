package com.finance.common.aop;


import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.condition.RequestConditionHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 日志系统
 */
@Aspect
@Component
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.finance.controller.*.*.*(..))")
    public void controllerLog(){}


    /**
     * 请求注入
     * @param joinPoint
     */
    @Before("controllerLog()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.trace("URI : "+request.getRequestURI());
        log.trace("HTTP_METHOD : "+request.getMethod());
        log.trace("IP : "+request.getRemoteAddr());
        log.trace("CLASS_METHOD : "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        log.trace("QUERY : "+request.getQueryString());
        log.trace("ARGS : "+ Arrays.toString(joinPoint.getArgs()));
    }

    @After("controllerLog()")
    public void doAfter(JoinPoint joinPoint){
        log.trace("METHOD_OVER : "+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "ret",pointcut = "controllerLog()")
    public void returning(Object ret){
        log.trace("RETURN_OBJECT : "+ret);
    }

    @AfterThrowing(throwing = "e" , pointcut = "controllerLog()" )
    public void throwz(JoinPoint joinPoint,Exception e){
        log.error("METHOD : "+joinPoint.getSignature().getName()+" HAS ERROR {}",e);
    }

}
