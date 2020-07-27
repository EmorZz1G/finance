package com.finance.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommonController {

    /**
     *  判断登入信息是否存入session，实现登录界面的跳转
     * @param session 浏览器session中的的信息
     * @return 判断session中是否已存入登入信息，实现重定向到用户界面/管理员界面/登录界面
     */
    @GetMapping("/toindex.html")
    public String toIndex(HttpSession session){
        Object obj = session.getAttribute("loginAdmin");
        if(obj!=null){
            return "redirect:/admin/index.html";
        }
        obj = session.getAttribute("loginUser");
        if(obj!=null){
            return "redirect:/user/index.html";
        }
        return "login";
    }
}
