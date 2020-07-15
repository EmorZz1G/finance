package com.finance.config.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Emor
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        try {
            Object subject = request.getSession().getAttribute("loginAdmin");
            if(subject!=null){
                return true;
            }
            subject = request.getSession().getAttribute("loginUser");
            if(subject!=null){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        response.sendRedirect("/login");
        return false;
    }
}
