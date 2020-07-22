package com.finance.common.aop;


import com.finance.common.annotation.UserAvatarAnno;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*@Aspect
@Component*/
public class TestAspect {

    @Pointcut("@annotation(com.finance.common.annotation.UserAvatarAnno)")
    public void test(){}

    @Before("@annotation(userAvatarAnno)")
    public void doBefore(UserAvatarAnno userAvatarAnno){
        System.out.println(userAvatarAnno);
    }
}
