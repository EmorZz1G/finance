package com.finance.common.aop.mbp;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AssociationAspect {

//    @After(value = "@annotation(com.finance.common.annotation.AssociationProcessor)")
    public void injectEntity(Joinpoint joinpoint){

    }
}
