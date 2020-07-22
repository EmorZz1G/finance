package com.finance.common.aop;


import com.finance.pojo.user.User;
import com.finance.pojo.user.UserAvatar;
import com.finance.service.user.personal.avatar.UserAvatarService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class UserAvatarAspect {

    @Pointcut("@annotation(com.finance.common.annotation.UserAvatarAnno)")
    public void avatar() {
    }

    @Autowired
    UserAvatarService userAvatarService;

    @After("avatar()")
    public void setAvatar() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser instanceof User) {
            User user = (User) loginUser;
            Object _userAvatar = session.getAttribute("userAvatar");
            if (_userAvatar==null) {
                UserAvatar usingAvatar = userAvatarService.getUsingAvatar(user.getId());
                session.setAttribute("userAvatar", usingAvatar);
            }
        }
    }
}
