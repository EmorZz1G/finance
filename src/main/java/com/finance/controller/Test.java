package com.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class Test {
    @RequestMapping("/user/test")

    @ResponseBody
    public String test(HttpSession session){
        session.setMaxInactiveInterval(5);
        System.out.println("关闭了");
        return "成功";
    }
}
