package com.finance.controller.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class CommonController {
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
